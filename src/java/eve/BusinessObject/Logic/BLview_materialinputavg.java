/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 23.0.2022 17:52
 * @author Franky Laseure
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import data.interfaces.db.View;
import db.*;
import eve.interfaces.logicview.IView_materialinputavg;
import eve.logicview.View_materialinputavg;
import eve.BusinessObject.view.Bview_materialinputavg;
import eve.conversion.entity.EMview_materialinputavg;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BLview_materialinputavg extends Bview_materialinputavg {
//Metacoder: NO AUTHOMATIC UPDATE
	
    public BLview_materialinputavg(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(true);
    }

    public ArrayList<View_materialinputavg> getView_materialinputavgs(String username) throws DBException {
        Object[][] parameter = { { "username", username } };
        SQLparameters sqlparameters = new SQLparameters(parameter);
        return viewio.getEntities(EMview_materialinputavg.SQLSelect4username, sqlparameters);
    }
}
