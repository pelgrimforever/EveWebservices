/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 18.8.2021 9:31
 */

package eve.BusinessObject.Logic;

import db.SQLTwriter;
import general.exception.DBException;
import db.*;
import db.SQLTqueue;
import eve.BusinessObject.view.Bview_stocktrade_system;
import eve.conversion.entity.EMview_stocktrade_system;
import eve.logicentity.Settings;
import eve.logicentity.Syssettings;
import eve.logicentity.Usersettings;
import eve.logicview.View_stocktrade_system;
import general.exception.DataException;
import java.util.ArrayList;

/**
 * @author Franky Laseure
 */
public class BLview_stocktrade_system extends Bview_stocktrade_system {
//Metacoder: NO AUTHOMATIC UPDATE
	
    public BLview_stocktrade_system(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(true);
    }
    
    public ArrayList<View_stocktrade_system> getViewstocktradesystems_for_user_startsystem(String username, long stocksystemid) throws DataException, DBException {
        Object[][] parameter = { { "username", username }, { "stocksystemid", stocksystemid } };
        SQLparameters sqlparameters = new SQLparameters(parameter);
        return viewio.getEntities(EMview_stocktrade_system.SQLSelect4usernamestartsystem, sqlparameters);
    }
}
