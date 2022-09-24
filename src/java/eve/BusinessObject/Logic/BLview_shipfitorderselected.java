/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 20.11.2021 17:22
 * @author Franky Laseure
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import data.interfaces.db.View;
import db.*;
import eve.interfaces.logicview.IView_shipfitorderselected;
import eve.logicview.View_shipfitorderselected;
import eve.BusinessObject.view.Bview_shipfitorderselected;
import eve.conversion.entity.EMview_shipfitorderselected;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BLview_shipfitorderselected extends Bview_shipfitorderselected {
//Metacoder: NO AUTHOMATIC UPDATE
	
    public BLview_shipfitorderselected(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(true);
    }

    public ArrayList<View_shipfitorderselected> getView_shipfitorderselecteds(String username) throws DBException {
        Object[][] parameter = { { "username", username } };
        SQLparameters sqlparameters = new SQLparameters(parameter);
        return viewio.getEntities(EMview_shipfitorderselected.SQLSelect4username, sqlparameters);
    }

    public ArrayList<View_shipfitorderselected> getView_shipfitorderselecteds(String username, long systemid) throws DBException {
        Object[][] parameter = { { "username", username }, { "systemid", systemid } };
        SQLparameters sqlparameters = new SQLparameters(parameter);
        return viewio.getEntities(EMview_shipfitorderselected.SQLSelect4usernamesystem, sqlparameters);
    }
}
