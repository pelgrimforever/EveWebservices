/*
 * Generated on 20.4.2022 10:3
 */

package eve.usecases;

import data.conversion.JSONConversion;
import data.interfaces.db.Filedata;
import data.gis.shape.piPoint;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.*;
import eve.interfaces.entity.pk.*;
import eve.logicentity.Order_history;
import general.exception.*;
import java.sql.Date;
import java.util.*;
import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class Order_history_usecases {

    private boolean loggedin = false;
    private BLorder_history blorder_history = new BLorder_history();
    
    public Order_history_usecases() {
        this(false);
    }
    
    public Order_history_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blorder_history.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

    public long count() throws DBException {
        return blorder_history.count();
    }
    
    public ArrayList<Order_history> get_all() throws DBException {
        return blorder_history.getOrder_historys();
    }
    
    public boolean getOrder_historyExists(IOrder_historyPK order_historyPK) throws DBException {
        return blorder_history.getEntityExists(order_historyPK);
    }
    
    public Order_history get_order_history_by_primarykey(IOrder_historyPK order_historyPK) throws DBException {
        return blorder_history.getOrder_history(order_historyPK);
    }

    public ArrayList<Order_history> get_order_history_with_foreignkey_evetype(IEvetypePK evetypePK) throws CustomException {
        return blorder_history.getOrder_historys4evetype(evetypePK);
    }
    
    public ArrayList<Order_history> get_order_history_with_foreignkey_region(IRegionPK regionPK) throws CustomException {
        return blorder_history.getOrder_historys4region(regionPK);
    }
    
    public ArrayList<Order_history> search_order_history(IOrder_historysearch order_historysearch) throws CustomException {
        return blorder_history.search(order_historysearch);
    }
    
    public long search_order_history_count(IOrder_historysearch order_historysearch) throws CustomException {
        return blorder_history.searchcount(order_historysearch);
    }

    public void secureinsertOrder_history(IOrder_history order_history) throws DBException, DataException {
        blorder_history.secureinsertOrder_history(order_history);
    }

    public void secureupdateOrder_history(IOrder_history order_history) throws DBException, DataException {
        blorder_history.secureupdateOrder_history(order_history);
    }

    public void securedeleteOrder_history(IOrder_history order_history) throws DBException, DataException {
        blorder_history.securedeleteOrder_history(order_history);
    }
}

