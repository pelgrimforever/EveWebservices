/*
 * Generated on 17.6.2022 13:4
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
public class Order_history_maxdate_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private BLorder_history_maxdate blorder_history_maxdate = new BLorder_history_maxdate(sqlreader);
    
    public Order_history_maxdate_usecases() {
        this(false);
    }
    
    public Order_history_maxdate_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blorder_history_maxdate.setAuthenticated(loggedin);
    }
    
    public ArrayList<Order_history_maxdate> get_all() throws DBException {
        return blorder_history_maxdate.getOrder_history_maxdates();
    }
    
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

}

