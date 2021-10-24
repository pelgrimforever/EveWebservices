/*
 * BLview_stocktrade_system.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 18.8.2021 9:31
 *
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import db.SQLparameters;
import eve.BusinessObject.view.Bview_stocktrade_system;
import eve.conversion.entity.EMview_stocktrade_system;
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
public class BLview_stocktrade_system extends Bview_stocktrade_system {
//ProjectGenerator: NO AUTHOMATIC UPDATE
	
    /**
     * Constructor, sets View_stocktrade_system as default Entity
     */
    public BLview_stocktrade_system() {
    }

    public ArrayList getView_stocktrade_system4username(String username) throws DBException {
        Object[][] parameter = { { "username", username } };
        SQLparameters sqlparameters = new SQLparameters(parameter);
        return getEntities(EMview_stocktrade_system.SQLSelect4username, sqlparameters);
    }
}
