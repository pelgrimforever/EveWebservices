/*
 * BLview_shipfitmodule.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 18.11.2021 16:29
 *
 */

package eve.BusinessObject.Logic;

import db.SQLparameters;
import eve.BusinessObject.view.Bview_shipfitmodule;
import eve.conversion.entity.EMview_shipfitmodule;
import general.exception.DBException;
import java.util.ArrayList;

/**
 * Business Logic Entity class BLview_shipfitmodule
 *
 * Class for manipulating data- and database objects
 * for View View_shipfitmodule and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLview_shipfitmodule extends Bview_shipfitmodule {
//Metacoder: NO AUTHOMATIC UPDATE
	
    /**
     * Constructor, sets View_shipfitmodule as default Entity
     */
    public BLview_shipfitmodule() {
        this.setLogginrequired(true);
    }

    public ArrayList getview_shipfitmodules(String username, String shipname) throws DBException {
        Object[][] parameters = { { "username", username }, { "shipname", shipname } };
        SQLparameters sqlparameters = new SQLparameters(parameters);
        return this.getEntities(EMview_shipfitmodule.SQLSelect4shipfit, sqlparameters);
    }
    
}
