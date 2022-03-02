/*
 * BLview_evetype_order_history_month.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 14.11.2021 16:21
 *
 */

package eve.BusinessObject.Logic;

import static com.ictportal.tools.DateTools.month;
import static com.ictportal.tools.DateTools.year;
import general.exception.DBException;
import db.SQLparameters;
import eve.logicview.View_evetype_order_history_month;
import eve.BusinessObject.view.Bview_evetype_order_history_month;
import eve.conversion.entity.EMview_evetype_order_history_month;
import eve.interfaces.entity.pk.IEvetypePK;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Business Logic Entity class BLview_evetype_order_history_month
 *
 * Class for manipulating data- and database objects
 * for View View_evetype_order_history_month and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLview_evetype_order_history_month extends Bview_evetype_order_history_month {
//Metacoder: NO AUTHOMATIC UPDATE
	
    /**
     * Constructor, sets View_evetype_order_history_month as default Entity
     */
    public BLview_evetype_order_history_month() {
        this.setLogginrequired(true);
    }

    /**
     * get all View_evetype_order_history_month objects for an evetypePK
     * @param evetypePK Evetype primary key
     * @return ArrayList of View_evetype_order_history_month objects
     * @throws DBException
     */
    public ArrayList<View_evetype_order_history_month> getView_evetype_order_history_months(IEvetypePK evetypePK) throws DBException {
        return getEntities(EMview_evetype_order_history_month.SQLselect4evetype, evetypePK.getSQLprimarykey());
    }

    /**
     * get all View_evetype_order_history_month objects for an evetypePK from last full month in orderhistory
     * @param evetypePK Evetype primary key
     * @return ArrayList of View_evetype_order_history_month objects
     * @throws DBException
     */
    public ArrayList<View_evetype_order_history_month> getView_evetype_order_history_monthsYM(IEvetypePK evetypePK) throws DBException {
        View_evetype_order_history_month maxyearmonth = (View_evetype_order_history_month)this.getEntity(EMview_evetype_order_history_month.SQLselectmaxyearmonth);
        int year = maxyearmonth.getYear();
        int month = maxyearmonth.getMonth();
        //previous month
        if(month==1) {
            month = 12;
            year--;
        } else {
            month--;
        }
        
        Object[][] parameters = {{ "year", year }, { "month", month }};
        SQLparameters sqlparameters = new SQLparameters(parameters);
        sqlparameters.add(evetypePK.getSQLprimarykey());
        return getEntities(EMview_evetype_order_history_month.SQLselect4evetypeYM, sqlparameters);
    }
}
