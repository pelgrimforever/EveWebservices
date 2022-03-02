/*
 * BLview_shipfitorderselected.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 20.11.2021 17:22
 *
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import data.interfaces.db.View;
import db.SQLparameters;
import eve.interfaces.logicview.IView_shipfitorderselected;
import eve.logicview.View_shipfitorderselected;
import eve.BusinessObject.view.Bview_shipfitorderselected;
import eve.conversion.entity.EMview_shipfitorderselected;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Business Logic Entity class BLview_shipfitorderselected
 *
 * Class for manipulating data- and database objects
 * for View View_shipfitorderselected and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLview_shipfitorderselected extends Bview_shipfitorderselected {
//Metacoder: NO AUTHOMATIC UPDATE
	
    /**
     * Constructor, sets View_shipfitorderselected as default Entity
     */
    public BLview_shipfitorderselected() {
        this.setLogginrequired(true);
    }

    /**
     * get all View_shipfitorderselected objects from database
     * @return ArrayList of View_shipfitorderselected objects
     * @throws DBException
     */
    public ArrayList<View_shipfitorderselected> getView_shipfitorderselecteds(String username) throws DBException {
        Object[][] parameter = { { "username", username } };
        SQLparameters sqlparameters = new SQLparameters(parameter);
        return getEntities(EMview_shipfitorderselected.SQLSelect4username, sqlparameters);
    }

    /**
     * get all View_shipfitorderselected objects from database
     * @param systemid system primary key
     * @return ArrayList of View_shipfitorderselected objects
     * @throws DBException
     */
    public ArrayList<View_shipfitorderselected> getView_shipfitorderselecteds(String username, long systemid) throws DBException {
        Object[][] parameter = { { "username", username }, { "systemid", systemid } };
        SQLparameters sqlparameters = new SQLparameters(parameter);
        return getEntities(EMview_shipfitorderselected.SQLSelect4usernamesystem, sqlparameters);
    }
}
