/*
 * BLview_userbp.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 28.0.2022 15:57
 *
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import db.SQLparameters;
import eve.logicview.View_userbp;
import eve.BusinessObject.view.Bview_userbp;
import eve.conversion.entity.EMview_userbp;
import java.util.ArrayList;

/**
 * Business Logic Entity class BLview_userbp
 *
 * Class for manipulating data- and database objects
 * for View View_userbp and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLview_userbp extends Bview_userbp {
//Metacoder: NO AUTHOMATIC UPDATE
	
    /**
     * Constructor, sets View_userbp as default Entity
     */
    public BLview_userbp() {
        this.setLogginrequired(true);
    }

    /**
     * get all View_userbp objects for username
     * @return ArrayList of View_userbp objects
     * @throws DBException
     */
    public ArrayList<View_userbp> getView_userbps(String username) throws DBException {
        Object[][] parameters = {{ "username", username}};
        SQLparameters sqlparameters = new SQLparameters(parameters);
        return getEntities(EMview_userbp.SQLSelect4user, sqlparameters);
    }

    /**
     * get all View_userbp objects for username / blueprint type
     * @param username user name
     * @param bp blueprint id
     * @return ArrayList of View_userbp objects
     * @throws DBException
     */
    public ArrayList<View_userbp> getView_userbps(String username, long bp) throws DBException {
        Object[][] parameters = {{ "username", username}, { "bp", bp }};
        SQLparameters sqlparameters = new SQLparameters(parameters);
        return getEntities(EMview_userbp.SQLSelect4userbp, sqlparameters);
    }
}
