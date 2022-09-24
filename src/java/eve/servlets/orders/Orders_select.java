/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */

package eve.servlets.orders;

import general.exception.*;
import data.interfaces.db.Filedata;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.IOrders;
import eve.interfaces.servlet.IOrdersOperation;
import eve.interfaces.searchentity.IOrderssearch;
import eve.servlets.DataServlet;
import eve.servlets.SecurityDataServlet;
import eve.usecases.Orders_usecases;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="Orders_select", urlPatterns={"/eve.Orders_select"})
public class Orders_select extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Orders_usecases ordersusecases = new Orders_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case IOrdersOperation.SELECT_ALL:
                    dataobject = ordersusecases.get_all();
                    break;
                case IOrdersOperation.SELECT_ORDERS:
                    dataobject = get_orders_with_primarykey(ordersusecases);
                    break;
                case IOrdersOperation.SELECT_Evetype:
                    dataobject = get_orders_with_foreignkey_evetype(ordersusecases);
                    break;
                case IOrdersOperation.SELECT_System:
                    dataobject = get_orders_with_foreignkey_system(ordersusecases);
                    break;
                case IOrdersOperation.SELECT_Tradecombined_sellbuy_order_id:
                    dataobject = get_orders_with_externalforeignkey_tradecombined_sellBuy_order_id(ordersusecases);
                    break;
                case IOrdersOperation.SELECT_Tradecombined_sellsell_order_id:
                    dataobject = get_orders_with_externalforeignkey_tradecombined_sellSell_order_id(ordersusecases);
                    break;
                case IOrdersOperation.SELECT_Shipfitorderselected:
                    dataobject = get_orders_with_externalforeignkey_shipfitorderselected(ordersusecases);
                    break;
                case IOrdersOperation.SELECT_Tradesell_order_id:
                    dataobject = get_orders_with_externalforeignkey_tradeSell_order_id(ordersusecases);
                    break;
                case IOrdersOperation.SELECT_Tradebuy_order_id:
                    dataobject = get_orders_with_externalforeignkey_tradeBuy_order_id(ordersusecases);
                    break;
                case IOrdersOperation.SELECT_SEARCH:
                    dataobject = search_orders(ordersusecases);
                    break;
                case IOrdersOperation.SELECT_SEARCHCOUNT:
                    dataobject = search_orders_count(ordersusecases);
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

    private Object get_orders_with_primarykey(Orders_usecases ordersusecases) throws DBException {
        IOrdersPK ordersPK = (IOrdersPK)parser.getJavaObject("orderspk");
        return ordersusecases.get_orders_by_primarykey(ordersPK);
    }

    private Object get_orders_with_foreignkey_evetype(Orders_usecases ordersusecases) throws CustomException {
        IEvetypePK evetypePK = (IEvetypePK)parser.getJavaObject("evetypepk");
        return ordersusecases.get_orders_with_foreignkey_evetype(evetypePK);
    }
    
    private Object get_orders_with_foreignkey_system(Orders_usecases ordersusecases) throws CustomException {
        ISystemPK systemPK = (ISystemPK)parser.getJavaObject("systempk");
        return ordersusecases.get_orders_with_foreignkey_system(systemPK);
    }
    
    private Object get_orders_with_externalforeignkey_tradecombined_sellBuy_order_id(Orders_usecases ordersusecases) throws CustomException {
        ITradecombined_sellPK tradecombined_sellBuy_order_idPK = (ITradecombined_sellPK)parser.getJavaObject("tradecombined_sellpk");
        return ordersusecases.get_orders_with_externalforeignkey_tradecombined_sellBuy_order_id(tradecombined_sellBuy_order_idPK);
    }
    
    private Object get_orders_with_externalforeignkey_tradecombined_sellSell_order_id(Orders_usecases ordersusecases) throws CustomException {
        ITradecombined_sellPK tradecombined_sellSell_order_idPK = (ITradecombined_sellPK)parser.getJavaObject("tradecombined_sellpk");
        return ordersusecases.get_orders_with_externalforeignkey_tradecombined_sellSell_order_id(tradecombined_sellSell_order_idPK);
    }
    
    private Object get_orders_with_externalforeignkey_shipfitorderselected(Orders_usecases ordersusecases) throws CustomException {
        IShipfitorderselectedPK shipfitorderselectedPK = (IShipfitorderselectedPK)parser.getJavaObject("shipfitorderselectedpk");
        return ordersusecases.get_orders_with_externalforeignkey_shipfitorderselected(shipfitorderselectedPK);
    }
    
    private Object get_orders_with_externalforeignkey_tradeSell_order_id(Orders_usecases ordersusecases) throws CustomException {
        ITradePK tradeSell_order_idPK = (ITradePK)parser.getJavaObject("tradepk");
        return ordersusecases.get_orders_with_externalforeignkey_tradeSell_order_id(tradeSell_order_idPK);
    }
    
    private Object get_orders_with_externalforeignkey_tradeBuy_order_id(Orders_usecases ordersusecases) throws CustomException {
        ITradePK tradeBuy_order_idPK = (ITradePK)parser.getJavaObject("tradepk");
        return ordersusecases.get_orders_with_externalforeignkey_tradeBuy_order_id(tradeBuy_order_idPK);
    }
    
    private Object search_orders(Orders_usecases ordersusecases) throws CustomException {
        IOrderssearch search = (IOrderssearch)parser.getJavaObject("search");
        return ordersusecases.search_orders(search);
    }
    
    private Object search_orders_count(Orders_usecases ordersusecases) throws CustomException {
        IOrderssearch orderssearch = (IOrderssearch)parser.getJavaObject("search");
        return ordersusecases.search_orders_count(orderssearch);
    }

    @Override
    public String getServletInfo() {
        return "orders_select";
    }

}

