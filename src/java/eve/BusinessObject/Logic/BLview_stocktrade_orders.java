/*
 * BLview_stocktrade_orders.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 18.8.2021 9:39
 *
 */

package eve.BusinessObject.Logic;

import data.interfaces.db.View;
import eve.BusinessObject.view.Bview_stocktrade_orders;
import eve.interfaces.BusinessObject.IBLview_stocktrade_orders;
import eve.logicview.View_stocktrade_orders;
import general.exception.DBException;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class BLview_stocktrade_orders extends Bview_stocktrade_orders implements IBLview_stocktrade_orders {
//ProjectGenerator: NO AUTHOMATIC UPDATE
	
    /**
     * Constructor, sets View_stocktrade_orders as default Entity
     */
    public BLview_stocktrade_orders() {
    }

    @Override
    public void loadExtra(ResultSet dbresult, View view_stocktrade_orders) throws SQLException {
        
    }
    
    public ArrayList getView_stocktrade_orders4usernamesystem(String username, long system) throws DBException {
        Object[][] parameter = { { "username", username }, { "system", system } };
        return getMapper().loadViewVector(this, View_stocktrade_orders.SQLSelect4usernamesystem, parameter);
    }
}
