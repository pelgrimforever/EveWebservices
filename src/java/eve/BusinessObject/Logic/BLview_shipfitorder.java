/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 19.11.2021 16:16
 * @author Franky Laseure
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import data.interfaces.db.View;
import db.*;
import eve.interfaces.logicview.IView_shipfitorder;
import eve.logicview.View_shipfitorder;
import eve.BusinessObject.view.Bview_shipfitorder;
import eve.conversion.entity.EMview_shipfitorder;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BLview_shipfitorder extends Bview_shipfitorder {
//Metacoder: NO AUTHOMATIC UPDATE
	
    public BLview_shipfitorder(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(true);
    }

    public ArrayList<View_shipfitorder> getView_shipfitorders(String username) throws DBException {
        Object[][] parameter = { { "username", username } };
        SQLparameters sqlparameters = new SQLparameters(parameter);
        return viewio.getEntities(EMview_shipfitorder.SQLSelect4username, sqlparameters);
    }
}
