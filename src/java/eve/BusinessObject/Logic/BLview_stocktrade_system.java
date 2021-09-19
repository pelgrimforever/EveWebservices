/*
 * BLview_stocktrade_system.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 18.8.2021 9:31
 *
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import data.interfaces.db.View;
import eve.interfaces.logicview.IView_stocktrade_system;
import eve.logicview.View_stocktrade_system;
import eve.BusinessObject.view.Bview_stocktrade_system;
import eve.interfaces.BusinessObject.IBLview_stocktrade_system;
import eve.logicview.View_stock;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Business Logic Entity class BLview_stocktrade_system
 *
 * Class for manipulating data- and database objects
 * for View View_stocktrade_system and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLview_stocktrade_system extends Bview_stocktrade_system implements IBLview_stocktrade_system {
//ProjectGenerator: NO AUTHOMATIC UPDATE
	
    /**
     * Constructor, sets View_stocktrade_system as default Entity
     */
    public BLview_stocktrade_system() {
    }

    @Override
    public void loadExtra(ResultSet dbresult, View view_stocktrade_system) throws SQLException {
        
    }
    
    public ArrayList getView_stocktrade_system4username(String username) throws DBException {
        Object[][] parameter = { { "username", username } };
        return getMapper().loadViewVector(this, View_stocktrade_system.SQLSelect4username, parameter);
    }
}
