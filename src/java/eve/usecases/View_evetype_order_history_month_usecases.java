/*
 * Generated on 13.4.2022 19:13
 */

package eve.usecases;

import data.conversion.JSONConversion;
import eve.interfaces.searchentity.*;
import eve.logicview.*;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.*;
import eve.logicview.View_evetype_order_history_month;
import general.exception.*;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class View_evetype_order_history_month_usecases {

    private boolean loggedin = false;
    private BLview_evetype_order_history_month blview_evetype_order_history_month = new BLview_evetype_order_history_month();
    
    public View_evetype_order_history_month_usecases() {
        this(false);
    }
    
    public View_evetype_order_history_month_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blview_evetype_order_history_month.setAuthenticated(loggedin);
    }
    
    public ArrayList<View_evetype_order_history_month> get_all() throws DBException {
        return blview_evetype_order_history_month.getView_evetype_order_history_months();
    }
    
//Custom code, do not change this line
//add here custom operations
    public ArrayList<View_evetype_order_history_month> getView_evetype_order_history_months_for_evetype_usecase(EvetypePK evetypePK) throws DBException {
        return blview_evetype_order_history_month.getView_evetype_order_history_months(evetypePK);
    }

    public ArrayList<View_evetype_order_history_month> getView_evetype_order_history_monthsYM_for_evetype_usecase(EvetypePK evetypePK) throws DBException {
        return blview_evetype_order_history_month.getView_evetype_order_history_monthsYM(evetypePK);
    }
//Custom code, do not change this line   

}

