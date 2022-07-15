/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 17.0.2022 13:34
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import db.*;
import eve.logicview.View_materialinput;
import eve.BusinessObject.view.Bview_materialinput;
import eve.conversion.entity.EMview_materialinput;
import java.util.ArrayList;

/**
 * @author Franky Laseure
 */
public class BLview_materialinput extends Bview_materialinput {
//Metacoder: NO AUTHOMATIC UPDATE
	
    public BLview_materialinput(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(true);
    }

    public ArrayList<View_materialinput> getView_materialinputs(String username) throws DBException {
        Object[][] parameter = { { "username", username } };
        SQLparameters sqlparameters = new SQLparameters(parameter);
        return viewio.getEntities(EMview_materialinput.SQLSelect4username, sqlparameters);
    }

}
