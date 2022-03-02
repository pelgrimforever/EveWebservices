/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eve.BusinessObject.service;

import data.conversion.JSONConversion;
import db.SQLMapper;
import db.TransactionOutput;
import db.TransactionOutput.TransactionOutputLine;
import eve.BusinessObject.Logic.BLcontract;
import eve.BusinessObject.Logic.BLcontractitem;
import eve.BusinessObject.Logic.BLevetype;
import eve.BusinessObject.Logic.BLgraphic;
import eve.BusinessObject.Logic.BLmarket_group;
import eve.BusinessObject.Logic.BLorders;
import eve.BusinessObject.Logic.BLregion;
import eve.BusinessObject.Logic.BLtypegroup;
import eve.BusinessObject.service.ContractService.ContractStatus;
import eve.conversion.entity.EMcontract;
import eve.data.Swagger;
import eve.entity.pk.ContractPK;
import eve.entity.pk.EvetypePK;
import eve.entity.pk.GraphicPK;
import eve.entity.pk.Market_groupPK;
import eve.entity.pk.TypegroupPK;
import eve.logicentity.Evetype;
import eve.logicentity.Graphic;
import eve.logicentity.Market_group;
import eve.logicentity.Region;
import eve.logicentity.Typegroup;
import general.exception.DBException;
import general.exception.DataException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author pelgrim
 */
public class ContractRegionDownloader implements Runnable {
    
    private final Marketdata data;
    private final ContractStatus contractstatus;
    private boolean keeprunning = true;
    private int id = 0;
    
    public ContractRegionDownloader(Marketdata data, ContractStatus marketstatus, int id) {
        this.data = data;
        this.contractstatus = marketstatus;
        this.id = id;
    }
    
    public void stoprunning() {
        this.keeprunning = false;
    }

    @Override
    public void run() {
        BLregion blregion = new BLregion();
        blregion.setAuthenticated(true);
        BLcontract blcontract = new BLcontract();
        blcontract.setAuthenticated(true);
        BLcontractitem blcontractitem = new BLcontractitem();
        blcontractitem.setAuthenticated(true);

        int pagenr;
        StringBuilder sqlb = new StringBuilder();
        JSONObject jsoncontractdetails, jsoncontractitem;
        TransactionOutput toutput;
        JSONArray jsoncontracts;
        Iterator<JSONObject> jsoncontractsI;
        JSONArray jsoncontractitems;
        Iterator<JSONObject> jsoncontractitemsI;
        int contractcounter = 0;
        int contractitemcounter = 0;
        int errorcounter = 0;
        int contractbatch = 0;
        int rangenumber = 0;
        long contractid;
        ContractPK contractpk = new ContractPK();
        String sqlcontract, sqlitem;
        HashMap<Long, Boolean> contractids = new HashMap<>();
        ArrayList<String> sqlstatements = new ArrayList<>();
        ArrayList<Long> type_statements = new ArrayList<>();

        try {
            Region region = data.getNextregion();
            while(keeprunning && region!=null) {
                pagenr = 0;
                contractbatch = 0;
                errorcounter = 0;
                contractids.clear();
                do {
                    pagenr++;
                    jsoncontracts = Swagger.getPubliccontracts_region(region.getPrimaryKey().getId(), pagenr);
                    contractbatch += jsoncontracts.size();
                    jsoncontractsI = jsoncontracts.iterator();
                    while(keeprunning && jsoncontractsI.hasNext()) {
                        jsoncontractdetails = jsoncontractsI.next();
                        contractid = JSONConversion.getLong(jsoncontractdetails, "contract_id");
                        contractpk.setId(contractid);
                        if(contractids.get(contractid)==null) {
                            if(blcontract.getContractExists(contractpk)) {
                                blcontract.addStatement(EMcontract.SQLactivatecontract, contractpk.getSQLprimarykey());
                                contractcounter++;
                                if(contractcounter>=100) {
                                    contractcounter = 0;
                                    toutput = blcontract.Commit2DB();
                                    if(toutput.getHaserror()) {
                                        contractstatus.addMessage("ContractRegionDownloader Error " + toutput.getErrormessage());
                                        errorcounter++;
                                    }
                                    contractitemcounter = 0;
                                    toutput = blcontractitem.Commit2DB();
                                    if(toutput.getHaserror()) {
                                        correctTypeError(toutput.getSqllist(), type_statements);
                                        errorcounter++;
                                    }
                                    type_statements = new ArrayList<>();
                                }
                            } else {
                                contractids.put(contractid, true);
                                sqlcontract = composeSQLinsert(jsoncontractdetails, pagenr);
                                blcontract.addStatement(sqlcontract);
                                contractcounter++;
                                jsoncontractitems = Swagger.getPubliccontractitems(contractid);
                                jsoncontractitemsI = jsoncontractitems.iterator();
                                while(keeprunning && jsoncontractitemsI.hasNext()) {
                                    jsoncontractitem = jsoncontractitemsI.next();
                                    sqlitem = composeSQLinsertitem(contractid, jsoncontractitem);
                                    blcontractitem.addStatement(sqlitem);
                                    type_statements.add(JSONConversion.getLong(jsoncontractitem, "type_id"));
                                    contractitemcounter++;
                                    if(contractcounter>=100 || contractitemcounter>=100) {
                                        contractcounter = 0;
                                        toutput = blcontract.Commit2DB();
                                        if(toutput.getHaserror()) {
                                            contractstatus.addMessage("ContractRegionDownloader Error " + toutput.getErrormessage());
                                            errorcounter++;
                                        }
                                        contractitemcounter = 0;
                                        toutput = blcontractitem.Commit2DB();
                                        if(toutput.getHaserror()) {
                                            correctTypeError(toutput.getSqllist(), type_statements);
                                            errorcounter++;
                                        }
                                        type_statements = new ArrayList<>();
                                    }
                                }
                            }
                        }
                    }
                    //don't attempt to commit to database if keeprunning flag is off
                    if(keeprunning && jsoncontracts.size()>0) {
                        contractcounter = 0;
                        toutput = blcontract.Commit2DB();
                        if(toutput.getHaserror()) {
                            contractstatus.addMessage("ContractRegionDownloader Error (Page end) " + toutput.getErrormessage());
                            errorcounter++;
                        }
                        contractitemcounter = 0;
                        toutput = blcontractitem.Commit2DB();
                        if(toutput.getHaserror()) {
                            correctTypeError(toutput.getSqllist(), type_statements);
                            errorcounter++;
                        }
                        contractstatus.updateStatus(region.getPrimaryKey().getId(), pagenr, contractbatch);
                    }
                    type_statements = new ArrayList<>();
                } while(keeprunning && jsoncontracts.size()>0);
                pagenr--;
                contractstatus.updateStatus(region.getPrimaryKey().getId(), Math.max(1, pagenr), contractbatch);
                contractstatus.setDone(region.getPrimaryKey().getId());
                //don't attempt to commit to database if keeprunning flag is off
                if(keeprunning) {
                    region.setContractpages(pagenr);
                    region.setContracterrors(errorcounter);
                    blregion.updateRegion(region);

                    region = data.getNextregion();
                }
            }         
        }
        catch(DBException e) {
            contractstatus.addMessage("ContractRegionDownloader " + e.getMessage());
        }
        catch(Exception e) {
            contractstatus.addMessage("ContractRegionDownloader " + e.getMessage());
        }
        return;
    }    

    //put as local variable, got results that did not make sence when using SQLMapper.DATETIMEFORMATTER
    private final SimpleDateFormat datetimeformat = new SimpleDateFormat(SQLMapper.DATETIMEFORMAT);    
    
    private String composeSQLinsert(JSONObject jsoncontractdetails, int pagenr) {
        StringBuilder sqlb = new StringBuilder();
        sqlb.append("insert into contract values (");
        sqlb.append(JSONConversion.getLong(jsoncontractdetails, "contract_id")).append(",");
        if(jsoncontractdetails.containsKey("collateral")) {
            sqlb.append(JSONConversion.getDouble(jsoncontractdetails, "collateral")).append(",");
        } else {
            sqlb.append("0,");
        }
        sqlb.append("'").append(datetimeformat.format(Swagger.datetimestring2Timestamp(JSONConversion.getString(jsoncontractdetails, "date_expired")))).append("',");
        sqlb.append("'").append(datetimeformat.format(Swagger.datetimestring2Timestamp(JSONConversion.getString(jsoncontractdetails, "date_issued")))).append("',");
        sqlb.append(JSONConversion.getint(jsoncontractdetails, "days_to_complete")).append(",");
        sqlb.append(JSONConversion.getLong(jsoncontractdetails, "end_location_id")).append(",");
        if(jsoncontractdetails.containsKey("for_corporation")) {
            sqlb.append(JSONConversion.getboolean(jsoncontractdetails, "for_corporation")).append(",");
        } else {
            sqlb.append("false,");
        }
        sqlb.append(JSONConversion.getDouble(jsoncontractdetails, "price")).append(",");
        sqlb.append(JSONConversion.getDouble(jsoncontractdetails, "reward")).append(",");
        sqlb.append(JSONConversion.getLong(jsoncontractdetails, "start_location_id")).append(",");
        StringBuilder title = new StringBuilder(JSONConversion.getString(jsoncontractdetails, "title"));
        SQLMapper.stringDoublequotes(title);
        sqlb.append("'").append(title).append("',");        
        sqlb.append("'").append(JSONConversion.getString(jsoncontractdetails, "type")).append("',");        
        sqlb.append(JSONConversion.getDouble(jsoncontractdetails, "volume")).append(",");
        sqlb.append(pagenr);
        sqlb.append(",true)");
        return sqlb.toString();
    }
    
    private String composeSQLinsertitem(long contractid, JSONObject jsoncontractitem) {
        StringBuilder sqlb = new StringBuilder();
        sqlb.append("insert into contractitem values (");
        sqlb.append(JSONConversion.getLong(jsoncontractitem, "record_id")).append(",");
        sqlb.append(contractid).append(",");
        if(jsoncontractitem.containsKey("is_blueprint_copy")) {
            sqlb.append(JSONConversion.getboolean(jsoncontractitem, "is_blueprint_copy")).append(",");
        } else {
            sqlb.append("false,");
        }
        sqlb.append(JSONConversion.getboolean(jsoncontractitem, "is_included")).append(",");
        sqlb.append(JSONConversion.getint(jsoncontractitem, "quantity")).append(",");
        sqlb.append(JSONConversion.getLong(jsoncontractitem, "type_id")).append(",");
        if(jsoncontractitem.containsKey("material_efficiency")) {
            sqlb.append(JSONConversion.getint(jsoncontractitem, "material_efficiency")).append(",");
        } else {
            sqlb.append("0,");            
        }
        if(jsoncontractitem.containsKey("runs")) {
            sqlb.append(JSONConversion.getint(jsoncontractitem, "runs")).append(",");
        } else {
            sqlb.append("0,");            
        }
        if(jsoncontractitem.containsKey("time_efficiency")) {
            sqlb.append(JSONConversion.getint(jsoncontractitem, "time_efficiency"));
        } else {
            sqlb.append("0");            
        }
        sqlb.append(")");
        return sqlb.toString();
    }
    
    private String composeSQLupdate(JSONObject jsonorderdetails) {
        StringBuilder sqlb = new StringBuilder();
        sqlb.append("update orders set volume_remain = ").append(JSONConversion.getLong(jsonorderdetails, "volume_remain "));
        sqlb.append("where orderid = ").append(JSONConversion.getLong(jsonorderdetails, "order_id"));
        return sqlb.toString();
    }
    
    public void correctTypeError(ArrayList<TransactionOutput.TransactionOutputLine> sqlstatements, ArrayList<Long> type_statements) throws DBException, DataException {
        Swagger swagger = new Swagger();
        BLmarket_group blmarketgroup = new BLmarket_group();
        blmarketgroup.setAuthenticated(true);
        BLtypegroup bltypegroup = new BLtypegroup();
        bltypegroup.setAuthenticated(true);
        BLgraphic blgraphic = new BLgraphic();
        blgraphic.setAuthenticated(true);
        BLevetype blevetype = new BLevetype();
        blevetype.setAuthenticated(true);
        BLorders blorders = new BLorders();
        blorders.setAuthenticated(true);
        
        Evetype evetype;
        JSONObject jsonmarketgroup;
        Market_groupPK marketgroupPK;
        Market_group marketgroup;
        JSONObject jsongraphic;
        GraphicPK graphicPK;
        Graphic graphic;
        JSONObject jsontypegroup;
        TypegroupPK typegroupPK;
        Typegroup typegroup;
        TransactionOutput toutputtest;
        int l = sqlstatements.size();
        HashMap<Long, Boolean> evetypehash = new HashMap<>();
        for(int s=0; s<l; s++) {
            if(!blevetype.getEntityExists(new EvetypePK(type_statements.get(s)))) {
                if(!evetypehash.containsKey(type_statements.get(s))) {
                    JSONObject jsonevetypedetails = Swagger.getType(type_statements.get(s));
                    evetype = blevetype.updateEvetype(jsonevetypedetails);
                    marketgroupPK = evetype.getMarket_groupPK();
                    graphicPK = evetype.getGraphicPK();
                    typegroupPK = evetype.getTypegroupPK();
                    if(graphicPK!=null && !blgraphic.getEntityExists(graphicPK)) {
                        jsongraphic = Swagger.getGraphic(graphicPK.getId());
                        graphic = blgraphic.updateGraphic(jsongraphic);
                        toutputtest = blgraphic.Commit2DB();
                        if(toutputtest.getHaserror()) {
                            contractstatus.addMessage("Graphic " + graphicPK.getId() + " could not be added");
                        } else {
                            contractstatus.addMessage("Graphic added " + graphic.getGraphic_file());
                        }
                    }
                    if(marketgroupPK!=null && !blmarketgroup.getEntityExists(marketgroupPK)) {
                        jsonmarketgroup = Swagger.getMarketgroup(marketgroupPK.getId());
                        marketgroup = blmarketgroup.updateMarket_group(jsonmarketgroup);
                        toutputtest = blmarketgroup.Commit2DB();
                        if(toutputtest.getHaserror()) {
                            contractstatus.addMessage("Marketgroup " + marketgroupPK.getId() + " could not be added");
                        } else {
                            contractstatus.addMessage("Marketgroup added " + marketgroup.getName());
                        }
                    }
                    if(typegroupPK!=null && !bltypegroup.getEntityExists(typegroupPK)) {
                        jsontypegroup = Swagger.getGroup(typegroupPK.getId());
                        typegroup = bltypegroup.updateTypegroup(jsontypegroup);
                        toutputtest = bltypegroup.Commit2DB();
                        if(toutputtest.getHaserror()) {
                            contractstatus.addMessage("Typegroup " + typegroupPK.getId() + " could not be added");
                        } else {
                            contractstatus.addMessage("Typegroup added " + typegroup.getName());
                        }
                    }
                    toutputtest = blevetype.Commit2DB();
                    if(toutputtest.getHaserror()) {
                        contractstatus.addMessage("Type " + type_statements.get(s) + " could not be added");
                    } else {
                        contractstatus.addMessage("Type added " + evetype.getName());
                    }
                }                                    
            }
            blorders.addStatement(sqlstatements.get(s).getSql());
            TransactionOutput toutput2 = blorders.Commit2DB();
            if(toutput2.getHaserror()) {
                contractstatus.addMessage("MarketRegionDownloader correctTypeError " + toutput2.getErrormessage());
            }
        }
    }
}
