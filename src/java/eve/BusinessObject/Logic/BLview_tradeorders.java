/*
 * BLview_tradeorders.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 2.5.2021 16:26
 *
 */

package eve.BusinessObject.Logic;

import db.SQLparameters;
import eve.BusinessObject.view.Bview_tradeorders;
import eve.conversion.entity.EMview_tradeorders;
import eve.entity.pk.Security_islandPK;
import general.exception.DBException;
import java.util.ArrayList;

/**
 * Business Logic Entity class BLview_tradeorders
 *
 * Class for manipulating data- and database objects
 * for View View_tradeorders and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLview_tradeorders extends Bview_tradeorders {
//ProjectGenerator: NO AUTHOMATIC UPDATE
	
    
    public ArrayList getTradeorders(Security_islandPK security_islandPK, float max_cargovolume, float net_perc, long min_profit) throws DBException {
        Object[][] parameter = { { "max_cargovolume", max_cargovolume }, { "net_perc", net_perc }, { "min_profit", min_profit } };
        SQLparameters sqlparameters = new SQLparameters(parameter);
        sqlparameters.add(security_islandPK.getSQLprimarykey());
        return getEntities(EMview_tradeorders.SQLSelect4tradevalues, sqlparameters);
    }
    
    /**
     * Constructor, sets View_tradeorders as default Entity
     */
    public BLview_tradeorders() {
    }

}
