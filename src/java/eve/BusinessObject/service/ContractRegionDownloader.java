package eve.BusinessObject.service;

import db.SQLTwriter;
import data.conversion.JSONConversion;
import db.SQLMapper;
import db.SQLToutput;
import db.SQLTqueue;
import db.SQLreader;
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
import eve.logicentity.Contract;
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
 * @author Franky Laseure
 */
public class ContractRegionDownloader implements Runnable {
    
    private final Marketdata data;
    private final ContractStatus contractstatus;
    private boolean keeprunning = true;
    private int id = 0;
    
    public ContractRegionDownloader(SQLreader sqlreader, SQLTwriter sqlwriter, Marketdata data, ContractStatus marketstatus, int id) {
        this.sqlreader = sqlreader;
        this.sqlwriter = sqlwriter;
        this.data = data;
        this.contractstatus = marketstatus;
        this.id = id;
    }
    
    public void stoprunning() {
        this.keeprunning = false;
    }

    private SQLreader sqlreader;
    private SQLTwriter sqlwriter;
    private SQLTqueue transactionqueue;
    private BLregion blregion;
    private BLcontract blcontract;
    private BLcontractitem blcontractitem;
    private BLmarket_group blmarketgroup;
    private BLtypegroup bltypegroup;
    private BLgraphic blgraphic;
    private BLevetype blevetype;
    private BLorders blorders;
    private Region region;
    private int pagenr;
    private SQLToutput toutput;
    private JSONArray jsoncontracts;
    private Iterator<JSONObject> jsoncontractsI;
    private JSONArray jsoncontractitems;
    private Iterator<JSONObject> jsoncontractitemsI;
    private int contractcounter;
    private int contractitemcounter;
    private int errorcounter;
    private int contractbatch;
    private long contractid;
    private ContractPK contractpk;
    private HashMap<Long, Contract> contracts_in_database;
    private ArrayList<Long> type_statements;
    private ArrayList<Contract> contracts;
    private final Contract emptycontract = new Contract();
    private boolean swaggerpage_contracts_is_not_empty;
    private boolean validregion;
    
    @Override
    public void run() {
        initialize();
        transactionqueue = new SQLTqueue();
        try {
            initialize_region();
            validregion = region!=null;
            while(keeprunning && validregion)
                download_contracts_for_region(region);
        }
        catch(DBException e) {
            contractstatus.addMessage("ContractRegionDownloader " + e.getMessage());
        }
        catch(Exception e) {
            contractstatus.addMessage("ContractRegionDownloader " + e.getMessage());
        }
        return;
    }    

    private void download_contracts_for_region(Region region) throws DBException, DataException {
        initialize_download_contracts_for_region();
        do
            download_next_swaggerpage_contracts_for_region(region);
        while(keeprunning && swaggerpage_contracts_is_not_empty);
        update_process_status(region);
        if(keeprunning)
            update_region_in_database(region);            
        initialize_region();
    }    

    private void initialize_region() throws DBException {
        region = data.getNextregion();
        validregion = region!=null;
        if(validregion)
            load_contracts_from_database(region);
    }

    private void update_region_in_database(Region region) throws DBException, DataException {
        region.setContractpages(pagenr);
        region.setContracterrors(errorcounter);
        blregion.updateRegion(transactionqueue, region);
    }

    private void update_process_status(Region region) {
        pagenr--;
        contractstatus.updateStatus(region.getPrimaryKey().getId(), Math.max(1, pagenr), contractbatch);
        contractstatus.setDone(region.getPrimaryKey().getId());
    }

    private void download_next_swaggerpage_contracts_for_region(Region region) throws DBException, DataException {
        download_prepare_next_swaggerpage(region);
        while(keeprunning && jsoncontractsI.hasNext())
            write_contract_to_database(jsoncontractsI.next());
        if(keeprunning && swaggerpage_contracts_is_not_empty)
            write_contractbuffer_to_database_initialize_for_next_swaggerpage(region);
        type_statements = new ArrayList<>();
    }

    private void download_prepare_next_swaggerpage(Region region) {
        pagenr++;
        jsoncontracts = Swagger.getPubliccontracts_region(region.getPrimaryKey().getId(), pagenr);
        swaggerpage_contracts_is_not_empty = jsoncontracts.size()>0;
        contractbatch += jsoncontracts.size();
        jsoncontractsI = jsoncontracts.iterator();
    }

    private void write_contractbuffer_to_database_initialize_for_next_swaggerpage(Region region) throws DataException, DBException {
        contractcounter = 0;
        toutput = sqlwriter.Commit2DB(transactionqueue);
        if(toutput.getHaserror())
            process_blcontract_error();
        contractitemcounter = 0;
        toutput = sqlwriter.Commit2DB(transactionqueue);
        if(toutput.getHaserror())
            process_blcontractitem_error();
        contractstatus.updateStatus(region.getPrimaryKey().getId(), pagenr, contractbatch);
    }

    private void process_blcontractitem_error() throws DataException, DBException {
        correctTypeError(toutput.getSqllist(), type_statements);
        errorcounter++;
    }

    private void process_blcontract_error() {
        contractstatus.addMessage("ContractRegionDownloader Error (Page end) " + toutput.getErrormessage());
        errorcounter++;
    }

    private void write_contract_to_database(JSONObject jsoncontractdetails) throws DBException, DataException {
        contractid = JSONConversion.getLong(jsoncontractdetails, "contract_id");
        contractpk.setId(contractid);
        if(contracts_in_database.get(contractid)!=null)
            reactivate_contract_in_database();
        else
            insert_contract_in_database(jsoncontractdetails);
    }

    private void reactivate_contract_in_database() throws DataException, DBException {
        blcontract.addStatement(transactionqueue, EMcontract.SQLactivatecontract, contractpk.getSQLprimarykey());
        contractcounter++;
        if(contractbuffer_is_full())
            write_contractbuffer_to_database();
    }

    private void insert_contract_in_database(JSONObject jsoncontractdetails) throws DataException, DBException {
        insert_contract_header_in_database(jsoncontractdetails);
        download_contract_details_from_swagger();
        while(keeprunning && jsoncontractitemsI.hasNext())
            insert_contract_details_in_database(jsoncontractitemsI.next());
    }
    
    private void insert_contract_details_in_database(JSONObject jsoncontractitem) throws DataException, DBException {
        blcontractitem.addStatement(transactionqueue, composeSQLinsertitem(contractid, jsoncontractitem));
        type_statements.add(JSONConversion.getLong(jsoncontractitem, "type_id"));
        contractitemcounter++;
        if(contractbuffer_is_full() || contractitembuffer_is_full())
            write_contractbuffer_to_database();
    }

    private boolean contractbuffer_is_full() {
        return contractcounter>=100;
    }
    
    private boolean contractitembuffer_is_full() {
        return contractitemcounter>=100;
    }
    
    private void download_contract_details_from_swagger() {
        jsoncontractitems = Swagger.getPubliccontractitems(contractid);
        jsoncontractitemsI = jsoncontractitems.iterator();
    }

    private void insert_contract_header_in_database(JSONObject jsoncontractdetails) {
        contracts_in_database.put(contractid, emptycontract);
        blcontract.addStatement(transactionqueue, composeSQLinsert(jsoncontractdetails, pagenr));
        contractcounter++;
    }

    private void write_contractbuffer_to_database() throws DataException, DBException {
        toutput = sqlwriter.Commit2DB(transactionqueue);
        if(toutput.getHaserror())
            process_write_contractbuffer_to_database_error();
        toutput = sqlwriter.Commit2DB(transactionqueue);
        if(toutput.getHaserror())
            process_blcontractitem_error();
        reset_contractbuffer_parameters();
    }

    private void reset_contractbuffer_parameters() {
        contractcounter = 0;
        contractitemcounter = 0;
        type_statements = new ArrayList<>();
    }

    private void process_write_contractbuffer_to_database_error() {
        contractstatus.addMessage("ContractRegionDownloader Error " + toutput.getErrormessage());
        errorcounter++;
    }

    private void initialize_download_contracts_for_region() {
        pagenr = 0;
        contractbatch = 0;
        errorcounter = 0;
    }

    private void load_contracts_from_database(Region region) throws DBException {
        contracts = blcontract.getContracts_for_region(region.getPrimaryKey());
        for(Contract contract: contracts)
            contracts_in_database.put(contract.getPrimaryKey().getId(), contract);
        contracts.clear();
    }

    private void initialize() {
        blregion = new BLregion(sqlreader);
        blregion.setAuthenticated(true);
        blcontract = new BLcontract(sqlreader);
        blcontract.setAuthenticated(true);
        blcontractitem = new BLcontractitem(sqlreader);
        blcontractitem.setAuthenticated(true);
        blmarketgroup = new BLmarket_group(sqlreader);
        blmarketgroup.setAuthenticated(true);
        bltypegroup = new BLtypegroup(sqlreader);
        bltypegroup.setAuthenticated(true);
        blgraphic = new BLgraphic(sqlreader);
        blgraphic.setAuthenticated(true);
        blevetype = new BLevetype(sqlreader);
        blevetype.setAuthenticated(true);
        blorders = new BLorders(sqlreader);
        blorders.setAuthenticated(true);
        errorcounter = 0;
        contractbatch = 0;
        contractpk = new ContractPK();
        contracts_in_database = new HashMap<>();
        reset_contractbuffer_parameters();
    }

    //put as local variable, got results that did not make sence when using SQLMapper.DATETIMEFORMATTER
    private final SimpleDateFormat datetimeformat = new SimpleDateFormat(SQLMapper.DATETIMEFORMAT);    
    
    private String composeSQLinsert(JSONObject jsoncontractdetails, int pagenr) {
        StringBuilder sqlb = new StringBuilder();
        sqlb.append("insert into contract values (");
        sqlb.append(JSONConversion.getLong(jsoncontractdetails, "contract_id")).append(",");
        if(jsoncontractdetails.containsKey("collateral"))
            sqlb.append(JSONConversion.getDouble(jsoncontractdetails, "collateral")).append(",");
        else
            sqlb.append("0,");
        sqlb.append("'").append(datetimeformat.format(Swagger.datetimestring2Timestamp(JSONConversion.getString(jsoncontractdetails, "date_expired")))).append("',");
        sqlb.append("'").append(datetimeformat.format(Swagger.datetimestring2Timestamp(JSONConversion.getString(jsoncontractdetails, "date_issued")))).append("',");
        sqlb.append(JSONConversion.getint(jsoncontractdetails, "days_to_complete")).append(",");
        sqlb.append(JSONConversion.getLong(jsoncontractdetails, "end_location_id")).append(",");
        if(jsoncontractdetails.containsKey("for_corporation"))
            sqlb.append(JSONConversion.getboolean(jsoncontractdetails, "for_corporation")).append(",");
        else
            sqlb.append("false,");
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
        if(jsoncontractitem.containsKey("is_blueprint_copy"))
            sqlb.append(JSONConversion.getboolean(jsoncontractitem, "is_blueprint_copy")).append(",");
        else
            sqlb.append("false,");
        sqlb.append(JSONConversion.getboolean(jsoncontractitem, "is_included")).append(",");
        sqlb.append(JSONConversion.getint(jsoncontractitem, "quantity")).append(",");
        sqlb.append(JSONConversion.getLong(jsoncontractitem, "type_id")).append(",");
        if(jsoncontractitem.containsKey("material_efficiency"))
            sqlb.append(JSONConversion.getint(jsoncontractitem, "material_efficiency")).append(",");
        else
            sqlb.append("0,");            
        if(jsoncontractitem.containsKey("runs"))
            sqlb.append(JSONConversion.getint(jsoncontractitem, "runs")).append(",");
        else
            sqlb.append("0,");            
        if(jsoncontractitem.containsKey("time_efficiency"))
            sqlb.append(JSONConversion.getint(jsoncontractitem, "time_efficiency"));
        else
            sqlb.append("0");            
        sqlb.append(")");
        return sqlb.toString();
    }
    
    private String composeSQLupdate(JSONObject jsonorderdetails) {
        StringBuilder sqlb = new StringBuilder();
        sqlb.append("update orders set volume_remain = ").append(JSONConversion.getLong(jsonorderdetails, "volume_remain "));
        sqlb.append("where orderid = ").append(JSONConversion.getLong(jsonorderdetails, "order_id"));
        return sqlb.toString();
    }
        
    private Evetype evetype;
    private JSONObject jsonmarketgroup;
    private Market_groupPK marketgroupPK;
    private Market_group marketgroup;
    private JSONObject jsongraphic;
    private GraphicPK graphicPK;
    private Graphic graphic;
    private JSONObject jsontypegroup;
    private TypegroupPK typegroupPK;
    private Typegroup typegroup;
    private SQLToutput toutputtest;
    private int l;
    private HashMap<Long, Boolean> evetypehash;
    
    private void correctTypeError(ArrayList<SQLToutput.SQLToutputLine> sqlstatements, ArrayList<Long> type_statements) throws DBException, DataException {
        l = sqlstatements.size();
        evetypehash = new HashMap<>();
        for(int s=0; s<l; s++)
            evaluate_sql_type_statement(type_statements.get(s), sqlstatements.get(s));
    }
    
    private void evaluate_sql_type_statement(long type_statement, SQLToutput.SQLToutputLine sqlstatement) throws DBException, DataException {    
        boolean evetype_not_in_database = !blevetype.getEvetypeExists(new EvetypePK(type_statement));
        boolean evetype_not_already_processed = !evetypehash.containsKey(type_statement);
        if(evetype_not_in_database) {
            if(evetype_not_already_processed) {
                process_evetype_statement(type_statement);
            }                                    
        }
        blorders.addStatement(transactionqueue, sqlstatement.getSql());
        SQLToutput toutput2 = sqlwriter.Commit2DB(transactionqueue);
        if(toutput2.getHaserror()) {
            contractstatus.addMessage("MarketRegionDownloader correctTypeError " + toutput2.getErrormessage());
        }
    }

    private void process_evetype_statement(long type_statement) throws DataException, DBException {
        JSONObject jsonevetypedetails = Swagger.getType(type_statement);
        evetype = blevetype.convert2Evetype(jsonevetypedetails);
        blevetype.insertupdateEvetype(transactionqueue, evetype);
        graphicPK = evetype.getGraphicPK();
        boolean graphic_not_in_database = !blgraphic.getGraphicExists(graphicPK);
        if(graphicPK!=null && graphic_not_in_database)
            update_graphic_in_database();
        marketgroupPK = evetype.getMarket_groupPK();
        boolean marketgroup_not_in_database = !blmarketgroup.getMarket_groupExists(marketgroupPK);
        if(marketgroupPK!=null && marketgroup_not_in_database)
            update_marketgroup_in_database();
        typegroupPK = evetype.getTypegroupPK();
        boolean typegroup_not_in_database = !bltypegroup.getTypegroupExists(typegroupPK);
        if(typegroupPK!=null && typegroup_not_in_database)
            update_typegroup_in_database();
        commit_evetype_to_database(type_statement);
    }

    private void commit_evetype_to_database(long type_statement) throws DBException {
        toutputtest = sqlwriter.Commit2DB(transactionqueue);
        if(toutputtest.getHaserror())
            contractstatus.addMessage("Type " + type_statement + " could not be added");
        else
            contractstatus.addMessage("Type added " + evetype.getName());
    }

    private void update_typegroup_in_database() throws DataException, DBException {
        jsontypegroup = Swagger.getGroup(typegroupPK.getId());
        typegroup = bltypegroup.updateTypegroup(transactionqueue, jsontypegroup);
        toutputtest = sqlwriter.Commit2DB(transactionqueue);
        if(toutputtest.getHaserror())
            contractstatus.addMessage("Typegroup " + typegroupPK.getId() + " could not be added");
        else
            contractstatus.addMessage("Typegroup added " + typegroup.getName());
    }

    private void update_marketgroup_in_database() throws DataException, DBException {
        jsonmarketgroup = Swagger.getMarketgroup(marketgroupPK.getId());
        marketgroup = blmarketgroup.updateMarket_group(transactionqueue, jsonmarketgroup);
        toutputtest = sqlwriter.Commit2DB(transactionqueue);
        if(toutputtest.getHaserror())
            contractstatus.addMessage("Marketgroup " + marketgroupPK.getId() + " could not be added");
        else
            contractstatus.addMessage("Marketgroup added " + marketgroup.getName());
    }

    private void update_graphic_in_database() throws DBException, DataException {
        jsongraphic = Swagger.getGraphic(graphicPK.getId());
        graphic = blgraphic.updateGraphic(transactionqueue, jsongraphic);
        toutputtest = sqlwriter.Commit2DB(transactionqueue);
        if(toutputtest.getHaserror()) {
            contractstatus.addMessage("Graphic " + graphicPK.getId() + " could not be added");
        } else {
            contractstatus.addMessage("Graphic added " + graphic.getGraphic_file());
        }
    }
}
