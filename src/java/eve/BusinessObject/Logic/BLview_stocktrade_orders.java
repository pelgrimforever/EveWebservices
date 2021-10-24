/*
 * BLview_stocktrade_orders.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 18.8.2021 9:39
 *
 */

package eve.BusinessObject.Logic;

import db.SQLparameters;
import eve.BusinessObject.view.Bview_stocktrade_orders;
import eve.conversion.entity.EMview_stocktrade_orders;
import general.exception.DBException;
import java.util.ArrayList;

/**
 * Business Logic Entity class BLview_stocktrade_orders
 *
 * Class for manipulating data- and database objects
 * for View View_stocktrade_orders and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLview_stocktrade_orders extends Bview_stocktrade_orders {
//ProjectGenerator: NO AUTHOMATIC UPDATE
	
    /**
     * Constructor, sets View_stocktrade_orders as default Entity
     */
    public BLview_stocktrade_orders() {
    }

    public ArrayList getView_stocktrade_orders4usernamesystem(String username, long system) throws DBException {
        Object[][] parameter = { { "username", username }, { "system", system } };
        SQLparameters sqlparameters = new SQLparameters(parameter);
        return getEntities(EMview_stocktrade_orders.SQLSelect4usernamesystem, sqlparameters);
    }
}
