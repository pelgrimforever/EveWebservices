/*
 * BLview_stock.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 25.7.2021 16:36
 *
 */

package eve.BusinessObject.Logic;

import db.SQLparameters;
import eve.BusinessObject.view.Bview_stock;
import eve.conversion.entity.EMview_stock;
import general.exception.DBException;
import java.util.ArrayList;

/**
 * Business Logic Entity class BLview_stock
 *
 * Class for manipulating data- and database objects
 * for View View_stock and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLview_stock extends Bview_stock {
//Metacoder: NO AUTHOMATIC UPDATE
	
    /**
     * Constructor, sets View_stock as default Entity
     */
    public BLview_stock() {
        this.setLogginrequired(true);
    }

    public ArrayList getView_stock4username(String username) throws DBException {
        Object[][] parameter = { { "username", username } };
        SQLparameters sqlparameters = new SQLparameters(parameter);
        return getEntities(EMview_stock.SQLSelect4username, sqlparameters);
    }
    
}
