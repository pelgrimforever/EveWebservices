/*
 * BLview_userbpmaterial.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 31.0.2022 17:49
 *
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import db.SQLparameters;
import eve.logicview.View_userbpmaterial;
import eve.BusinessObject.view.Bview_userbpmaterial;
import eve.conversion.entity.EMview_userbpmaterial;
import java.util.ArrayList;

/**
 * Business Logic Entity class BLview_userbpmaterial
 *
 * Class for manipulating data- and database objects
 * for View View_userbpmaterial and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLview_userbpmaterial extends Bview_userbpmaterial {
//Metacoder: NO AUTHOMATIC UPDATE
	
    /**
     * Constructor, sets View_userbpmaterial as default Entity
     */
    public BLview_userbpmaterial() {
    }

    /**
     * get all View_userbpmaterial for a blueprint / username materialinput
     * @param bp blueprint id (evetype)
     * @param username user name
     * @return ArrayList of View_userbpmaterial objects
     * @throws DBException
     */
    public ArrayList<View_userbpmaterial> getView_userbpmaterials(long bp, String username) throws DBException {
        Object[][] parameters = {{ "bp", bp}, { "username", username}};
        SQLparameters sqlparameters = new SQLparameters(parameters);
        return getEntities(EMview_userbpmaterial.SQLSelect4bp_user, sqlparameters);
    }

}
