/*
 * BLview_materialinputavg.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 23.0.2022 17:52
 *
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import data.interfaces.db.View;
import db.SQLparameters;
import eve.interfaces.logicview.IView_materialinputavg;
import eve.logicview.View_materialinputavg;
import eve.BusinessObject.view.Bview_materialinputavg;
import eve.conversion.entity.EMview_materialinputavg;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Business Logic Entity class BLview_materialinputavg
 *
 * Class for manipulating data- and database objects
 * for View View_materialinputavg and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLview_materialinputavg extends Bview_materialinputavg {
//Metacoder: NO AUTHOMATIC UPDATE
	
    /**
     * Constructor, sets View_materialinputavg as default Entity
     */
    public BLview_materialinputavg() {
    }

    /**
     * get all View_materialinputavg objects for username
     * @return ArrayList of View_materialinputavg objects
     * @throws DBException
     */
    public ArrayList<View_materialinputavg> getView_materialinputavgs(String username) throws DBException {
        Object[][] parameter = { { "username", username } };
        SQLparameters sqlparameters = new SQLparameters(parameter);
        return getEntities(EMview_materialinputavg.SQLSelect4username, sqlparameters);
    }
}
