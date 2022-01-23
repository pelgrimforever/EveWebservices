/*
 * BLview_materialinput.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 17.0.2022 13:34
 *
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import db.SQLparameters;
import eve.logicview.View_materialinput;
import eve.BusinessObject.view.Bview_materialinput;
import eve.conversion.entity.EMview_materialinput;
import java.util.ArrayList;

/**
 * Business Logic Entity class BLview_materialinput
 *
 * Class for manipulating data- and database objects
 * for View View_materialinput and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLview_materialinput extends Bview_materialinput {
//Metacoder: NO AUTHOMATIC UPDATE
	
    /**
     * Constructor, sets View_materialinput as default Entity
     */
    public BLview_materialinput() {
    }

    /**
     * get all View_materialinput objects for user
     * @return ArrayList of View_materialinput objects
     * @throws DBException
     */
    public ArrayList<View_materialinput> getView_materialinputs(String username) throws DBException {
        Object[][] parameter = { { "username", username } };
        SQLparameters sqlparameters = new SQLparameters(parameter);
        return getEntities(EMview_materialinput.SQLSelect4username, sqlparameters);
    }

}
