/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 20.4.2022 10:3
 */

package eve.servlets.evetype;

import general.exception.*;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.IEvetype;
import eve.interfaces.servlet.IEvetypeOperation;
import eve.interfaces.searchentity.IEvetypesearch;
import eve.servlets.DataServlet;
import eve.servlets.SecurityDataServlet;
import eve.usecases.Evetype_usecases;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Franky Laseure
 */
@WebServlet(name="Evetype_select", urlPatterns={"/eve.Evetype_select"})
public class Evetype_select extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Evetype_usecases evetypeusecases = new Evetype_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case IEvetypeOperation.SELECT_ALL:
                    dataobject = evetypeusecases.get_all();
                    break;
                case IEvetypeOperation.SELECT_EVETYPE:
                    dataobject = get_evetype_with_primarykey(evetypeusecases);
                    break;
                case IEvetypeOperation.SELECT_Market_group:
                    dataobject = get_evetype_with_foreignkey_market_group(evetypeusecases);
                    break;
                case IEvetypeOperation.SELECT_Typegroup:
                    dataobject = get_evetype_with_foreignkey_typegroup(evetypeusecases);
                    break;
                case IEvetypeOperation.SELECT_Graphic:
                    dataobject = get_evetype_with_foreignkey_graphic(evetypeusecases);
                    break;
                case IEvetypeOperation.SELECT_Wishlist:
                    dataobject = get_evetype_with_externalforeignkey_wishlist(evetypeusecases);
                    break;
                case IEvetypeOperation.SELECT_Materialinput:
                    dataobject = get_evetype_with_externalforeignkey_materialinput(evetypeusecases);
                    break;
                case IEvetypeOperation.SELECT_Bpmaterialbp:
                    dataobject = get_evetype_with_externalforeignkey_bpmaterialBp(evetypeusecases);
                    break;
                case IEvetypeOperation.SELECT_Bpmaterialmaterial:
                    dataobject = get_evetype_with_externalforeignkey_bpmaterialMaterial(evetypeusecases);
                    break;
                case IEvetypeOperation.SELECT_Order_history_month:
                    dataobject = get_evetype_with_externalforeignkey_order_history_month(evetypeusecases);
                    break;
                case IEvetypeOperation.SELECT_Stock:
                    dataobject = get_evetype_with_externalforeignkey_stock(evetypeusecases);
                    break;
                case IEvetypeOperation.SELECT_Order_history:
                    dataobject = get_evetype_with_externalforeignkey_order_history(evetypeusecases);
                    break;
                case IEvetypeOperation.SELECT_Shipfitmodule:
                    dataobject = get_evetype_with_externalforeignkey_shipfitmodule(evetypeusecases);
                    break;
                case IEvetypeOperation.SELECT_Shipfitorder:
                    dataobject = get_evetype_with_externalforeignkey_shipfitorder(evetypeusecases);
                    break;
                case IEvetypeOperation.SELECT_Tradecombined:
                    dataobject = get_evetype_with_externalforeignkey_tradecombined(evetypeusecases);
                    break;
                case IEvetypeOperation.SELECT_Userbp:
                    dataobject = get_evetype_with_externalforeignkey_userbp(evetypeusecases);
                    break;
                case IEvetypeOperation.SELECT_SEARCH:
                    dataobject = search_evetype(evetypeusecases);
                    break;
                case IEvetypeOperation.SELECT_SEARCHCOUNT:
                    dataobject = search_evetype_count(evetypeusecases);
                    break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            }

        } 
        catch(CustomException e) {
            dataobject = e;
        }
        finally {
        }
        this.sendData(response, dataobject);
    } 

//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

    private Object get_evetype_with_primarykey(Evetype_usecases evetypeusecases) throws DBException {
        IEvetypePK evetypePK = (IEvetypePK)parser.getJavaObject("evetypepk");
        return evetypeusecases.get_evetype_by_primarykey(evetypePK);
    }

    private Object get_evetype_with_foreignkey_market_group(Evetype_usecases evetypeusecases) throws CustomException {
        IMarket_groupPK market_groupPK = (IMarket_groupPK)parser.getJavaObject("market_grouppk");
        return evetypeusecases.get_evetype_with_foreignkey_market_group(market_groupPK);
    }
    
    private Object get_evetype_with_foreignkey_typegroup(Evetype_usecases evetypeusecases) throws CustomException {
        ITypegroupPK typegroupPK = (ITypegroupPK)parser.getJavaObject("typegrouppk");
        return evetypeusecases.get_evetype_with_foreignkey_typegroup(typegroupPK);
    }
    
    private Object get_evetype_with_foreignkey_graphic(Evetype_usecases evetypeusecases) throws CustomException {
        IGraphicPK graphicPK = (IGraphicPK)parser.getJavaObject("graphicpk");
        return evetypeusecases.get_evetype_with_foreignkey_graphic(graphicPK);
    }
    
    private Object get_evetype_with_externalforeignkey_wishlist(Evetype_usecases evetypeusecases) throws CustomException {
        IWishlistPK wishlistPK = (IWishlistPK)parser.getJavaObject("wishlistpk");
        return evetypeusecases.get_evetype_with_externalforeignkey_wishlist(wishlistPK);
    }
    
    private Object get_evetype_with_externalforeignkey_materialinput(Evetype_usecases evetypeusecases) throws CustomException {
        IMaterialinputPK materialinputPK = (IMaterialinputPK)parser.getJavaObject("materialinputpk");
        return evetypeusecases.get_evetype_with_externalforeignkey_materialinput(materialinputPK);
    }
    
    private Object get_evetype_with_externalforeignkey_bpmaterialBp(Evetype_usecases evetypeusecases) throws CustomException {
        IBpmaterialPK bpmaterialBpPK = (IBpmaterialPK)parser.getJavaObject("bpmaterialpk");
        return evetypeusecases.get_evetype_with_externalforeignkey_bpmaterialBp(bpmaterialBpPK);
    }
    
    private Object get_evetype_with_externalforeignkey_bpmaterialMaterial(Evetype_usecases evetypeusecases) throws CustomException {
        IBpmaterialPK bpmaterialMaterialPK = (IBpmaterialPK)parser.getJavaObject("bpmaterialpk");
        return evetypeusecases.get_evetype_with_externalforeignkey_bpmaterialMaterial(bpmaterialMaterialPK);
    }
    
    private Object get_evetype_with_externalforeignkey_order_history_month(Evetype_usecases evetypeusecases) throws CustomException {
        IOrder_history_monthPK order_history_monthPK = (IOrder_history_monthPK)parser.getJavaObject("order_history_monthpk");
        return evetypeusecases.get_evetype_with_externalforeignkey_order_history_month(order_history_monthPK);
    }
    
    private Object get_evetype_with_externalforeignkey_stock(Evetype_usecases evetypeusecases) throws CustomException {
        IStockPK stockPK = (IStockPK)parser.getJavaObject("stockpk");
        return evetypeusecases.get_evetype_with_externalforeignkey_stock(stockPK);
    }
    
    private Object get_evetype_with_externalforeignkey_order_history(Evetype_usecases evetypeusecases) throws CustomException {
        IOrder_historyPK order_historyPK = (IOrder_historyPK)parser.getJavaObject("order_historypk");
        return evetypeusecases.get_evetype_with_externalforeignkey_order_history(order_historyPK);
    }
    
    private Object get_evetype_with_externalforeignkey_shipfitmodule(Evetype_usecases evetypeusecases) throws CustomException {
        IShipfitmodulePK shipfitmodulePK = (IShipfitmodulePK)parser.getJavaObject("shipfitmodulepk");
        return evetypeusecases.get_evetype_with_externalforeignkey_shipfitmodule(shipfitmodulePK);
    }
    
    private Object get_evetype_with_externalforeignkey_shipfitorder(Evetype_usecases evetypeusecases) throws CustomException {
        IShipfitorderPK shipfitorderPK = (IShipfitorderPK)parser.getJavaObject("shipfitorderpk");
        return evetypeusecases.get_evetype_with_externalforeignkey_shipfitorder(shipfitorderPK);
    }
    
    private Object get_evetype_with_externalforeignkey_tradecombined(Evetype_usecases evetypeusecases) throws CustomException {
        ITradecombinedPK tradecombinedPK = (ITradecombinedPK)parser.getJavaObject("tradecombinedpk");
        return evetypeusecases.get_evetype_with_externalforeignkey_tradecombined(tradecombinedPK);
    }
    
    private Object get_evetype_with_externalforeignkey_userbp(Evetype_usecases evetypeusecases) throws CustomException {
        IUserbpPK userbpPK = (IUserbpPK)parser.getJavaObject("userbppk");
        return evetypeusecases.get_evetype_with_externalforeignkey_userbp(userbpPK);
    }
    
    private Object search_evetype(Evetype_usecases evetypeusecases) throws CustomException {
        IEvetypesearch search = (IEvetypesearch)parser.getJavaObject("search");
        return evetypeusecases.search_evetype(search);
    }
    
    private Object search_evetype_count(Evetype_usecases evetypeusecases) throws CustomException {
        IEvetypesearch evetypesearch = (IEvetypesearch)parser.getJavaObject("search");
        return evetypeusecases.search_evetype_count(evetypesearch);
    }

    @Override
    public String getServletInfo() {
        return "evetype_select";
    }

}

