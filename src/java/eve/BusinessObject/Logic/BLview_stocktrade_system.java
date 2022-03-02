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
import eve.logicentity.Syssettings;
import eve.logicentity.Usersettings;
import eve.logicview.View_stocktrade_system;
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
        this.setLogginrequired(true);
    }

    /**
     * get all stock trade grouped by system
     * sell prices are netto prices (with broker fee subtracted)
     * @param username: User name
     * @return ArrayList
     * @throws DBException
     * @throws DataException 
     */
    public ArrayList getView_stocktrade_system4username(String username) throws DBException, DataException {
        BLusersettings blusersettings = new BLusersettings();
        blusersettings.setAuthenticated(true);
        BLsyssettings blsyssettings = new BLsyssettings();
        blsyssettings.setAuthenticated(true);
        
        ArrayList<Usersettings> usersettings = blusersettings.getUsersettings(username);
        Usersettings usersettingStocksystemid = blusersettings.getUsersetting(usersettings, Settings.STOCKSYSTEMID);
        Syssettings syssettingBrokerfee = blsyssettings.getSyssettings(Syssettings.BROKER_FEE);
        float perc_tax = Float.valueOf(syssettingBrokerfee.getValue());
        float perc_net = 1 - perc_tax;        
        if(usersettingStocksystemid!=null && usersettingStocksystemid.getValue()!=null) {
            long stocksystemid = Long.valueOf(usersettingStocksystemid.getValue());
            Object[][] parameter = { { "username", username }, { "stocksystemid", stocksystemid } };
            SQLparameters sqlparameters = new SQLparameters(parameter);
            ArrayList<View_stocktrade_system> viewstocktradesystems = getEntities(EMview_stocktrade_system.SQLSelect4usernamestartsystem, sqlparameters);
            for(View_stocktrade_system stocktradesystem: viewstocktradesystems) {
                stocktradesystem.setSellprice(stocktradesystem.getSellprice()*perc_net);
            }
            return viewstocktradesystems;
        } else {
            return new ArrayList();
        }
    }
}
