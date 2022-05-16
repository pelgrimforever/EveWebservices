/*
 * Generated on 13.4.2022 19:13
 */

package eve.usecases;

import data.conversion.JSONConversion;
import eve.interfaces.searchentity.*;
import eve.logicview.*;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.*;
import eve.logicview.View_stocktrade_orders;
import general.exception.*;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class View_stocktrade_orders_usecases {

    private boolean loggedin = false;
    private BLview_stocktrade_orders blview_stocktrade_orders = new BLview_stocktrade_orders();
    
    public View_stocktrade_orders_usecases() {
        this(false);
    }
    
    public View_stocktrade_orders_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blview_stocktrade_orders.setAuthenticated(loggedin);
    }
    
    public ArrayList<View_stocktrade_orders> get_all() throws DBException {
        return blview_stocktrade_orders.getView_stocktrade_orderss();
    }
    
//Custom code, do not change this line
//add here custom operations
    public ArrayList<View_stocktrade_orders> getView_stocktrade_orders4usernamesystem_usecase(String username, long system) throws DBException {
        return blview_stocktrade_orders.getView_stocktrade_orders4usernamesystem(username, system);
    }
//Custom code, do not change this line   

}

