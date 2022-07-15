/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 17.11.2021 15:41
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import db.*;
import eve.BusinessObject.view.Bview_shipfit;
import eve.conversion.entity.EMview_shipfit;
import java.util.ArrayList;

/**
 * @author Franky Laseure
 */
public class BLview_shipfit extends Bview_shipfit {
//Metacoder: NO AUTHOMATIC UPDATE
	
    public BLview_shipfit(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(true);
    }

    public ArrayList getView_shipfits4username(String username) throws DBException {
        Object[][] parameter = { { "username", username } };
        SQLparameters sqlparameters = new SQLparameters(parameter);
        return viewio.getEntities(EMview_shipfit.SQLSelect4username, sqlparameters);
    }
}
