/*
 * BLview_shipfit.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 17.11.2021 15:41
 *
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import db.SQLparameters;
import eve.BusinessObject.view.Bview_shipfit;
import eve.conversion.entity.EMview_shipfit;
import java.util.ArrayList;

/**
 * Business Logic Entity class BLview_shipfit
 *
 * Class for manipulating data- and database objects
 * for View View_shipfit and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLview_shipfit extends Bview_shipfit {
//Metacoder: NO AUTHOMATIC UPDATE
	
    /**
     * Constructor, sets View_shipfit as default Entity
     */
    public BLview_shipfit() {
    }

    public ArrayList getView_shipfits4username(String username) throws DBException {
        Object[][] parameter = { { "username", username } };
        SQLparameters sqlparameters = new SQLparameters(parameter);
        return getEntities(EMview_shipfit.SQLSelect4username, sqlparameters);
    }
}
