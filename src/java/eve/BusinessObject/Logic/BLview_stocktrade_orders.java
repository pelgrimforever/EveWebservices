/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 18.8.2021 9:39
 * @author Franky Laseure
 */

package eve.BusinessObject.Logic;

import db.*;
import eve.BusinessObject.view.Bview_stocktrade_orders;
import eve.conversion.entity.EMview_stocktrade_orders;
import general.exception.DBException;
import java.util.ArrayList;

public class BLview_stocktrade_orders extends Bview_stocktrade_orders {
//Metacoder: NO AUTHOMATIC UPDATE
	
    public BLview_stocktrade_orders(SQLreader sqlreader) {
        super(sqlreader);
    }

    public ArrayList getView_stocktrade_orders4usernamesystem(String username, long system) throws DBException {
        Object[][] parameter = { { "username", username }, { "system", system } };
        SQLparameters sqlparameters = new SQLparameters(parameter);
        return viewio.getEntities(EMview_stocktrade_orders.SQLSelect4usernamesystem, sqlparameters);
    }
}
