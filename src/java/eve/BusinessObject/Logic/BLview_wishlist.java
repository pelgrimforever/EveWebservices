/*
 * BLview_wishlist.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 16.11.2021 15:51
 *
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import db.SQLparameters;
import eve.BusinessObject.view.Bview_wishlist;
import eve.conversion.entity.EMview_wishlist;
import java.util.ArrayList;

/**
 * Business Logic Entity class BLview_wishlist
 *
 * Class for manipulating data- and database objects
 * for View View_wishlist and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLview_wishlist extends Bview_wishlist {
//Metacoder: NO AUTHOMATIC UPDATE
	
    /**
     * Constructor, sets View_wishlist as default Entity
     */
    public BLview_wishlist() {
        this.setLogginrequired(true);
    }

    public ArrayList getView_wishlist4username(String username) throws DBException {
        Object[][] parameter = { { "username", username } };
        SQLparameters sqlparameters = new SQLparameters(parameter);
        return getEntities(EMview_wishlist.SQLSelect4username, sqlparameters);
    }
}
