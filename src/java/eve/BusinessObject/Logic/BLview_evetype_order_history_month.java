/*
 * BLview_evetype_order_history_month.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 14.11.2021 16:21
 *
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import data.interfaces.db.View;
import eve.interfaces.logicview.IView_evetype_order_history_month;
import eve.logicview.View_evetype_order_history_month;
import eve.BusinessObject.view.Bview_evetype_order_history_month;
import eve.conversion.entity.EMview_evetype_order_history_month;
import eve.interfaces.entity.pk.IEvetypePK;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
}
