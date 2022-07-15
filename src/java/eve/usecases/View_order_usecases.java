/*
 * Generated on 13.6.2022 11:21
 */

package eve.usecases;

import db.*;
import data.conversion.JSONConversion;
import data.gis.shape.piPoint;
import eve.interfaces.searchentity.*;
import eve.logicview.*;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.*;
import eve.logicentity.*;
import eve.logicview.*;
import eve.usecases.custom.*;
import general.exception.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class View_order_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private BLview_order blview_order = new BLview_order(sqlreader);
    
    public View_order_usecases() {
        this(false);
    }
    
    public View_order_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blview_order.setAuthenticated(loggedin);
    }
    
    public ArrayList<View_order> get_all() throws DBException {
        return blview_order.getView_orders();
    }
    
//Custom code, do not change this line
//add here custom operations
    public View_order getView_order_for_orderid_usecase(long orderid) throws DBException {
        return getView_order_for_primarykey_usecase(new OrdersPK(orderid));
    }
    
    public View_order getView_order_for_primarykey_usecase(OrdersPK orderPK) throws DBException {
        return blview_order.getView_order(orderPK);
    }
    
    public ArrayList<View_order> getView_orders4evetype_sell_usecase(EvetypePK evetypePK) throws DBException {
        return blview_order.getView_orders4evetype_sell(evetypePK);
    }
    
    public ArrayList<View_order> getView_orders4evetype_buy_usecase(EvetypePK evetypePK) throws DBException {
        return blview_order.getView_orders4evetype_buy(evetypePK);
    }
    
    public ArrayList<View_order> getView_ordersAtselllowprice_with_startsystem_usecase(eve.entity.pk.SystemPK systemPK) throws DataException, DBException {
        return blview_order.getView_ordersAtselllowprice(systemPK);
    }
    
    public ArrayList<View_order> getOrders4Wishlist_for_user_usecase(String username) throws DataException, DBException {
        return blview_order.getOrders4Wishlist(username);
    }

    public ArrayList<View_order> getView_orders4evetyperegion_sell_usecase(EvetypePK evetypePK, RegionPK regionPK) throws DataException, DBException {
        return blview_order.getView_orders4evetyperegion_sell(evetypePK, regionPK);
    }
//Custom code, do not change this line   

}

