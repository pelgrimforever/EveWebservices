/*
 * BLview_shipfitorder.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 19.11.2021 16:16
 *
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import data.interfaces.db.View;
import db.SQLparameters;
import eve.interfaces.logicview.IView_shipfitorder;
import eve.logicview.View_shipfitorder;
import eve.BusinessObject.view.Bview_shipfitorder;
import eve.conversion.entity.EMview_shipfitorder;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Business Logic Entity class BLview_shipfitorder
 *
 * Class for manipulating data- and database objects
 * for View View_shipfitorder and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLview_shipfitorder extends Bview_shipfitorder {
//Metacoder: NO AUTHOMATIC UPDATE
	
    /**
     * Constructor, sets View_shipfitorder as default Entity
     */
    public BLview_shipfitorder() {
    }

    /**
     * get all View_shipfitorder objects for username
     * @return ArrayList of View_shipfitorder objects
     * @throws DBException
     */
    public ArrayList<View_shipfitorder> getView_shipfitorders(String username) throws DBException {
        Object[][] parameter = { { "username", username } };
        SQLparameters sqlparameters = new SQLparameters(parameter);
        return getEntities(EMview_shipfitorder.SQLSelect4username, sqlparameters);
    }
}
