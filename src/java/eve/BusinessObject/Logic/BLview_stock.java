/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 25.7.2021 16:36
 * @author Franky Laseure
 */

package eve.BusinessObject.Logic;

import db.*;
import eve.BusinessObject.view.Bview_stock;
import eve.conversion.entity.EMview_stock;
import general.exception.DBException;
import java.util.ArrayList;

public class BLview_stock extends Bview_stock {
//Metacoder: NO AUTHOMATIC UPDATE
	
    public BLview_stock(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(true);
    }

    public ArrayList getView_stock4username(String username) throws DBException {
        Object[][] parameter = { { "username", username } };
        SQLparameters sqlparameters = new SQLparameters(parameter);
        return viewio.getEntities(EMview_stock.SQLSelect4username, sqlparameters);
    }
    
}
