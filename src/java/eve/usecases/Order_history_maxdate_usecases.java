/*
 * Generated on 20.4.2022 10:3
 */

package eve.usecases;

import data.conversion.JSONConversion;
import data.gis.shape.piPoint;
import eve.interfaces.searchentity.*;
import eve.logicview.*;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.*;
import eve.logicview.Order_history_maxdate;
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
    private BLorder_history_maxdate blorder_history_maxdate = new BLorder_history_maxdate();
    
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

