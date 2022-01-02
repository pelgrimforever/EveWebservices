/*
 * BLview_system.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 30.11.2021 19:35
 *
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import db.SQLparameters;
import eve.logicview.View_system;
import eve.BusinessObject.view.Bview_system;
import eve.conversion.entity.EMview_system;
import java.util.ArrayList;

/**
 * Business Logic Entity class BLview_system
 *
 * Class for manipulating data- and database objects
 * for View View_system and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLview_system extends Bview_system {
//Metacoder: NO AUTHOMATIC UPDATE
	
    /**
     * Constructor, sets View_system as default Entity
     */
    public BLview_system() {
    }
    
    /**
     * get the view_system for given start and end system
     * @param systemstart start system
     * @param systemend end system
     * @return View_system
     * @throws DBException 
     */
    public View_system getView_systems(long systemstart, long systemend) throws DBException {
        Object[][] parameters = {{ "system_start", systemstart }, { "system_end", systemend }};
        SQLparameters sqlparameters = new SQLparameters(parameters);
        return (View_system)getEntity(EMview_system.SQLSelect4startend, sqlparameters);
    }
    

}
