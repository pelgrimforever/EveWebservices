/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 31.0.2022 17:49
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import db.*;
import eve.logicview.View_userbpmaterial;
import eve.BusinessObject.view.Bview_userbpmaterial;
import eve.conversion.entity.EMview_userbpmaterial;
import java.util.ArrayList;

/**
 * @author Franky Laseure
 */
public class BLview_userbpmaterial extends Bview_userbpmaterial {
//Metacoder: NO AUTHOMATIC UPDATE
	
    public BLview_userbpmaterial(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(true);
    }

    public ArrayList<View_userbpmaterial> getView_userbpmaterials(long bp, int serialnumber, String username) throws DBException {
        Object[][] parameters = {{ "bp", bp}, { "serialnumber", serialnumber}, { "username", username}};
        SQLparameters sqlparameters = new SQLparameters(parameters);
        return viewio.getEntities(EMview_userbpmaterial.SQLSelect4bp_user, sqlparameters);
    }

    public ArrayList<View_userbpmaterial> getView_userbpmaterials(long bp, String username) throws DBException {
        Object[][] parameters = {{ "bp", bp}, { "username", username}};
        SQLparameters sqlparameters = new SQLparameters(parameters);
        return viewio.getEntities(EMview_userbpmaterial.SQLSimulate4bp_user, sqlparameters);
    }
}
