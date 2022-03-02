/*
 * BLview_bp_profitperregion.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 22.1.2022 8:34
 *
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import data.interfaces.db.View;
import db.SQLparameters;
import eve.interfaces.logicview.IView_bp_profitperregion;
import eve.logicview.View_bp_profitperregion;
import eve.BusinessObject.view.Bview_bp_profitperregion;
import eve.conversion.entity.EMview_bp_profitperregion;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Business Logic Entity class BLview_bp_profitperregion
 *
 * Class for manipulating data- and database objects
 * for View View_bp_profitperregion and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLview_bp_profitperregion extends Bview_bp_profitperregion {
//Metacoder: NO AUTHOMATIC UPDATE
	
    /**
     * Constructor, sets View_bp_profitperregion as default Entity
     */
    public BLview_bp_profitperregion() {
        this.setLogginrequired(true);
    }

    /**
     * get all View_bp_profitperregion objects for last history month in orderhistory
     * @return ArrayList of View_bp_profitperregion objects
     * @throws DBException
     */
    public ArrayList<View_bp_profitperregion> getView_bp_profitperregions4lastmonth() throws DBException {
        BLorder_history_maxdate blorder_history_maxdate = new BLorder_history_maxdate();
        Date maxdate = blorder_history_maxdate.getOrder_history_maxdates().get(0).getMaxdate();
        Calendar c = Calendar.getInstance(); 
        c.setTime(maxdate); 
        c.add(Calendar.MONTH, -1);
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH)+1;
        
        Object[][] parameters = {{ "year", year }, { "month", month }};
        SQLparameters sqlparameters = new SQLparameters(parameters);
        return getEntities(EMview_bp_profitperregion.SQLSelect4lastmonth, sqlparameters);
    }
}
