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
public class View_evetype_order_history_region_month_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private BLview_evetype_order_history_region_month blview_evetype_order_history_region_month = new BLview_evetype_order_history_region_month(sqlreader);
    
    public View_evetype_order_history_region_month_usecases() {
        this(false);
    }
    
    public View_evetype_order_history_region_month_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blview_evetype_order_history_region_month.setAuthenticated(loggedin);
    }
    
    public ArrayList<View_evetype_order_history_region_month> get_all() throws DBException {
        return blview_evetype_order_history_region_month.getView_evetype_order_history_region_months();
    }
    
//Custom code, do not change this line
//add here custom operations
    public ArrayList<View_evetype_order_history_region_month> getView_evetype_order_history_region_months_YM_for_evetype_usecase(EvetypePK evetypePK) throws DBException {
        return blview_evetype_order_history_region_month.getView_evetype_order_history_region_months_YM(evetypePK);
    }
//Custom code, do not change this line   

}

