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
import eve.logicentity.Order_history_month;
import eve.logicview.*;
import general.exception.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class Order_history_month_usecases {

    private boolean loggedin = false;
    private BLorder_history_month blorder_history_month = new BLorder_history_month();
    
    public Order_history_month_usecases() {
        this(false);
    }
    
    public Order_history_month_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blorder_history_month.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

    public long count() throws DBException {
        return blorder_history_month.count();
    }
    
    public ArrayList<Order_history_month> get_all() throws DBException {
        return blorder_history_month.getOrder_history_months();
    }
    
    public boolean getOrder_history_monthExists(IOrder_history_monthPK order_history_monthPK) throws DBException {
        return blorder_history_month.getEntityExists(order_history_monthPK);
    }
    
    public Order_history_month get_order_history_month_by_primarykey(IOrder_history_monthPK order_history_monthPK) throws DBException {
        return blorder_history_month.getOrder_history_month(order_history_monthPK);
    }

    public ArrayList<Order_history_month> get_order_history_month_with_foreignkey_evetype(IEvetypePK evetypePK) throws CustomException {
        return blorder_history_month.getOrder_history_months4evetype(evetypePK);
    }
    
    public ArrayList<Order_history_month> get_order_history_month_with_foreignkey_region(IRegionPK regionPK) throws CustomException {
        return blorder_history_month.getOrder_history_months4region(regionPK);
    }
    
    public ArrayList<Order_history_month> search_order_history_month(IOrder_history_monthsearch order_history_monthsearch) throws ParseException, CustomException {
        return blorder_history_month.search(order_history_monthsearch);
    }
    
    public long search_order_history_month_count(IOrder_history_monthsearch order_history_monthsearch) throws ParseException, CustomException {
        return blorder_history_month.searchcount(order_history_monthsearch);
    }

    public void secureinsertOrder_history_month(IOrder_history_month order_history_month) throws DBException, DataException {
        blorder_history_month.secureinsertOrder_history_month(order_history_month);
    }

    public void secureupdateOrder_history_month(IOrder_history_month order_history_month) throws DBException, DataException {
        blorder_history_month.secureupdateOrder_history_month(order_history_month);
    }

    public void securedeleteOrder_history_month(IOrder_history_month order_history_month) throws DBException, DataException {
        blorder_history_month.securedeleteOrder_history_month(order_history_month);
    }
}

