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
public class View_stocktrade_orders_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private BLview_stocktrade_orders blview_stocktrade_orders = new BLview_stocktrade_orders(sqlreader);
    
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

