/*
 * Generated on 13.4.2022 19:13
 */

package eve.usecases;

import data.conversion.JSONConversion;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.*;
import eve.interfaces.entity.pk.*;
import eve.logicentity.Evetype;
import eve.logicview.*;
import general.exception.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class Evetype_usecases {

    private boolean loggedin = false;
    private BLevetype blevetype = new BLevetype();
    
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
        blevetype.toggleConfiguredbp(evetypePK);
    }

    public void calculate_estimated_productioncosts() throws DBException, DataException, CustomException {
        blevetype.calculateBpproductioncost();
    }
//Custom code, do not change this line   

    public long count() throws DBException {
        return blevetype.count();
    }
    
    public ArrayList<Evetype> get_all() throws DBException {
        return blevetype.getEvetypes();
    }
    
    public boolean getEvetypeExists(IEvetypePK evetypePK) throws DBException {
        return blevetype.getEntityExists(evetypePK);
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
    
    public ArrayList<Evetype> search_evetype(IEvetypesearch evetypesearch) throws ParseException, CustomException {
        return blevetype.search(evetypesearch);
    }
    
    public long search_evetype_count(IEvetypesearch evetypesearch) throws ParseException, CustomException {
        return blevetype.searchcount(evetypesearch);
    }

    public void secureinsertEvetype(IEvetype evetype) throws DBException, DataException {
        blevetype.secureinsertEvetype(evetype);
    }

    public void secureupdateEvetype(IEvetype evetype) throws DBException, DataException {
        blevetype.secureupdateEvetype(evetype);
    }

    public void securedeleteEvetype(IEvetype evetype) throws DBException, DataException {
        blevetype.securedeleteEvetype(evetype);
    }
}

