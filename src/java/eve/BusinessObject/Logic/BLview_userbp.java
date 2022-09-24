/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 28.0.2022 15:57
 * @author Franky Laseure
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import db.*;
import eve.logicview.View_userbp;
import eve.BusinessObject.view.Bview_userbp;
import eve.conversion.entity.EMview_userbp;
import java.util.ArrayList;

public class BLview_userbp extends Bview_userbp {
//Metacoder: NO AUTHOMATIC UPDATE
	
    public BLview_userbp(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(true);
    }

    public ArrayList<View_userbp> getView_userbps(String username) throws DBException {
        Object[][] parameters = {{ "username", username}};
        SQLparameters sqlparameters = new SQLparameters(parameters);
        return viewio.getEntities(EMview_userbp.SQLSelect4user, sqlparameters);
    }

    public ArrayList<View_userbp> getView_userbps(String username, long bp) throws DBException {
        Object[][] parameters = {{ "username", username}, { "bp", bp }};
        SQLparameters sqlparameters = new SQLparameters(parameters);
        return viewio.getEntities(EMview_userbp.SQLSelect4userbp, sqlparameters);
    }
}
