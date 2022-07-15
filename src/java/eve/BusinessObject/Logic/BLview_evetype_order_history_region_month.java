/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 11.1.2022 21:46
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import data.interfaces.db.View;
import db.*;
import eve.interfaces.logicview.IView_evetype_order_history_region_month;
import eve.logicview.View_evetype_order_history_region_month;
import eve.BusinessObject.view.Bview_evetype_order_history_region_month;
import eve.conversion.entity.EMview_evetype_order_history_region_month;
import eve.interfaces.entity.pk.IEvetypePK;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * @author Franky Laseure
 */
public class BLview_evetype_order_history_region_month extends Bview_evetype_order_history_region_month {
//Metacoder: NO AUTHOMATIC UPDATE
	
    public BLview_evetype_order_history_region_month(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(true);
    }

    public ArrayList<View_evetype_order_history_region_month> getView_evetype_order_history_region_months_YM(IEvetypePK evetypePK) throws DBException {
        BLorder_history_maxdate blorder_history_maxdate = new BLorder_history_maxdate(viewio.getSQLreader());
        Date maxdate = blorder_history_maxdate.getOrder_history_maxdates().get(0).getMaxdate();
        Calendar c = Calendar.getInstance(); 
        c.setTime(maxdate); 
        c.add(Calendar.MONTH, -1);
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH)+1;
        
        Object[][] parameters = {{ "year", year }, { "month", month }};
        SQLparameters sqlparameters = new SQLparameters(parameters);
        sqlparameters.add(evetypePK.getSQLprimarykey());
        return viewio.getEntities(EMview_evetype_order_history_region_month.SQLselect4evetypeYM, sqlparameters);
    }
}
