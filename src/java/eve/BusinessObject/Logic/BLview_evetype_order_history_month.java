/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 14.11.2021 16:21
 * @author Franky Laseure
 */

package eve.BusinessObject.Logic;

import static com.ictportal.tools.DateTools.month;
import static com.ictportal.tools.DateTools.year;
import general.exception.DBException;
import db.*;
import eve.logicview.View_evetype_order_history_month;
import eve.BusinessObject.view.Bview_evetype_order_history_month;
import eve.conversion.entity.EMview_evetype_order_history_month;
import eve.interfaces.entity.pk.IEvetypePK;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

public class BLview_evetype_order_history_month extends Bview_evetype_order_history_month {
//Metacoder: NO AUTHOMATIC UPDATE
	
    public BLview_evetype_order_history_month(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(true);
    }

    public ArrayList<View_evetype_order_history_month> getView_evetype_order_history_months(IEvetypePK evetypePK) throws DBException {
        return viewio.getEntities(EMview_evetype_order_history_month.SQLselect4evetype, evetypePK.getSQLprimarykey());
    }

    public ArrayList<View_evetype_order_history_month> getView_evetype_order_history_monthsYM(IEvetypePK evetypePK) throws DBException {
        View_evetype_order_history_month maxyearmonth = (View_evetype_order_history_month)viewio.getEntity(EMview_evetype_order_history_month.SQLselectmaxyearmonth);
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
        return viewio.getEntities(EMview_evetype_order_history_month.SQLselect4evetypeYM, sqlparameters);
    }
}
