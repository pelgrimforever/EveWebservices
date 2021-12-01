/*
 * BLview_stocktrade_system.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 18.8.2021 9:31
 *
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import db.SQLparameters;
import eve.BusinessObject.view.Bview_stocktrade_system;
import eve.conversion.entity.EMview_stocktrade_system;
import eve.logicentity.Settings;
import eve.logicentity.Usersettings;
import general.exception.DataException;
import java.util.ArrayList;

/**
 * Business Logic Entity class BLview_stocktrade_system
 *
 * Class for manipulating data- and database objects
 * for View View_stocktrade_system and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLview_stocktrade_system extends Bview_stocktrade_system {
//Metacoder: NO AUTHOMATIC UPDATE
	
    /**
     * Constructor, sets View_stocktrade_system as default Entity
     */
    public BLview_stocktrade_system() {
    }

    public ArrayList getView_stocktrade_system4username(String username) throws DBException, DataException {
        BLusersettings blusersettings = new BLusersettings();
        ArrayList<Usersettings> usersettings = blusersettings.getUsersettings(username);
        Usersettings usersettingStocksystemid = null;
        for(Usersettings usersetting: usersettings) {
            if(usersetting.getPrimaryKey().getName().equals(Settings.STOCKSYSTEMID)) {
                usersettingStocksystemid = usersetting;
            }
        }
        if(usersettingStocksystemid!=null && usersettingStocksystemid.getValue()!=null) {
            long stocksystemid = Long.valueOf(usersettingStocksystemid.getValue());
            Object[][] parameter = { { "username", username }, { "stocksystemid", stocksystemid } };
            SQLparameters sqlparameters = new SQLparameters(parameter);
            return getEntities(EMview_stocktrade_system.SQLSelect4usernamestartsystem, sqlparameters);
        } else {
            return new ArrayList();
        }
    }
}
