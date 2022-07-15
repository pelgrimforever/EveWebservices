/*
 * Generated on 13.6.2022 11:21
 */

package eve.usecases;

import db.*;
import data.conversion.JSONConversion;
import data.interfaces.db.Filedata;
import data.gis.shape.piPoint;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.*;
import eve.interfaces.entity.pk.*;
import eve.logicentity.*;
import eve.logicentity.Evetype;
import eve.logicview.*;
import eve.usecases.custom.*;
import general.exception.*;
import java.sql.Date;
import java.util.*;
import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class Evetype_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private SQLTwriter sqlwriter = new SQLTwriter();
    private BLevetype blevetype = new BLevetype(sqlreader);
    
    public Evetype_usecases() {
        this(false);
    }
    
    public Evetype_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blevetype.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
    public void toggle_configuredbp(IEvetypePK evetypePK) throws DBException, DataException {
        SQLTqueue transactionqueue = new SQLTqueue();
        blevetype.toggleConfiguredbp(transactionqueue, evetypePK);
        sqlwriter.Commit2DB(transactionqueue);
    }

    public void calculate_estimated_productioncosts() throws DBException, DataException, CustomException {
        SQLTqueue transactionqueue = new SQLTqueue();
        int materialefficiency = 10;
        int breakevenproduction = 20;
        double researchcostperc = 0.2;
        double stationfeeperc = 0.1;
        double totalcostperc = 1 + researchcostperc + stationfeeperc;
        BLview_bpmaterial blview_bpmaterial = new BLview_bpmaterial(sqlreader);
        ArrayList<Evetype> blueprints = blevetype.getConfiguredblueprints();
        ArrayList<View_bpmaterial> bpmaterials;
        int transactioncounter = 0;
        for(Evetype blueprint: blueprints) {
            double totalprice = 0;
            bpmaterials = blview_bpmaterial.getView_bpmaterials(blueprint.getPrimaryKey().getId());
            for(View_bpmaterial mat: bpmaterials) {
                totalprice += Bpproduction_usecases.calculate_net_materialprice(materialefficiency, mat.getAverage(), mat.getAmount());
            }
            totalprice += blueprint.getAverage() * totalcostperc / breakevenproduction;
            blueprint.setEstimatedproductioncost(totalprice);
            blevetype.updateEvetype(transactionqueue, blueprint);
            if(transactioncounter==100) {
                sqlwriter.Commit2DB(transactionqueue);
                transactioncounter = 0;
            }
        }
        sqlwriter.Commit2DB(transactionqueue);
    }
//Custom code, do not change this line   

    public long count() throws DBException {
        return blevetype.count();
    }
    
    public ArrayList<Evetype> get_all() throws DBException {
        return blevetype.getEvetypes();
    }
    
    public boolean getEvetypeExists(IEvetypePK evetypePK) throws DBException {
        return blevetype.getEvetypeExists(evetypePK);
    }
    
    public Evetype get_evetype_by_primarykey(IEvetypePK evetypePK) throws DBException {
        return blevetype.getEvetype(evetypePK);
    }

    public ArrayList<Evetype> get_evetype_with_foreignkey_market_group(IMarket_groupPK market_groupPK) throws CustomException {
        return blevetype.getEvetypes4market_group(market_groupPK);
    }
    
    public ArrayList<Evetype> get_evetype_with_foreignkey_typegroup(ITypegroupPK typegroupPK) throws CustomException {
        return blevetype.getEvetypes4typegroup(typegroupPK);
    }
    
    public ArrayList<Evetype> get_evetype_with_foreignkey_graphic(IGraphicPK graphicPK) throws CustomException {
        return blevetype.getEvetypes4graphic(graphicPK);
    }
    
    public Evetype get_evetype_with_externalforeignkey_wishlist(IWishlistPK wishlistPK) throws CustomException {
        return blevetype.getWishlist(wishlistPK);
    }
    
    public Evetype get_evetype_with_externalforeignkey_materialinput(IMaterialinputPK materialinputPK) throws CustomException {
        return blevetype.getMaterialinput(materialinputPK);
    }
    
    public Evetype get_evetype_with_externalforeignkey_bpmaterialBp(IBpmaterialPK bpmaterialBpPK) throws CustomException {
        return blevetype.getBpmaterialbp(bpmaterialBpPK);
    }
    
    public Evetype get_evetype_with_externalforeignkey_bpmaterialMaterial(IBpmaterialPK bpmaterialMaterialPK) throws CustomException {
        return blevetype.getBpmaterialmaterial(bpmaterialMaterialPK);
    }
    
    public Evetype get_evetype_with_externalforeignkey_order_history_month(IOrder_history_monthPK order_history_monthPK) throws CustomException {
        return blevetype.getOrder_history_month(order_history_monthPK);
    }
    
    public Evetype get_evetype_with_externalforeignkey_stock(IStockPK stockPK) throws CustomException {
        return blevetype.getStock(stockPK);
    }
    
    public Evetype get_evetype_with_externalforeignkey_order_history(IOrder_historyPK order_historyPK) throws CustomException {
        return blevetype.getOrder_history(order_historyPK);
    }
    
    public Evetype get_evetype_with_externalforeignkey_shipfitmodule(IShipfitmodulePK shipfitmodulePK) throws CustomException {
        return blevetype.getShipfitmodule(shipfitmodulePK);
    }
    
    public Evetype get_evetype_with_externalforeignkey_shipfitorder(IShipfitorderPK shipfitorderPK) throws CustomException {
        return blevetype.getShipfitorder(shipfitorderPK);
    }
    
    public Evetype get_evetype_with_externalforeignkey_tradecombined(ITradecombinedPK tradecombinedPK) throws CustomException {
        return blevetype.getTradecombined(tradecombinedPK);
    }
    
    public Evetype get_evetype_with_externalforeignkey_userbp(IUserbpPK userbpPK) throws CustomException {
        return blevetype.getUserbp(userbpPK);
    }
    
    public ArrayList<Evetype> search_evetype(IEvetypesearch evetypesearch) throws CustomException {
        return blevetype.search(evetypesearch);
    }
    
    public long search_evetype_count(IEvetypesearch evetypesearch) throws CustomException {
        return blevetype.searchcount(evetypesearch);
    }

    public void insertEvetype(IEvetype evetype) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blevetype.insertEvetype(tq, evetype);
        sqlwriter.Commit2DB(tq);
    }

    public void updateEvetype(IEvetype evetype) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blevetype.updateEvetype(tq, evetype);
        sqlwriter.Commit2DB(tq);
    }

    public void deleteEvetype(IEvetype evetype) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blevetype.deleteEvetype(tq, evetype);
        sqlwriter.Commit2DB(tq);
    }

    public void delete_all_containing_Market_group(IMarket_groupPK market_groupPK) throws CustomException {
        SQLTqueue tq = new SQLTqueue();
        blevetype.delete4market_group(tq, market_groupPK);
        sqlwriter.Commit2DB(tq);
    }
    
    public void delete_all_containing_Typegroup(ITypegroupPK typegroupPK) throws CustomException {
        SQLTqueue tq = new SQLTqueue();
        blevetype.delete4typegroup(tq, typegroupPK);
        sqlwriter.Commit2DB(tq);
    }
    
    public void delete_all_containing_Graphic(IGraphicPK graphicPK) throws CustomException {
        SQLTqueue tq = new SQLTqueue();
        blevetype.delete4graphic(tq, graphicPK);
        sqlwriter.Commit2DB(tq);
    }
    
}

