/*
 * BLview_tradeorders_lowsec.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 7.11.2021 16:9
 *
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import db.SQLparameters;
import eve.BusinessObject.view.Bview_tradeorders_lowsec;
import eve.conversion.entity.EMview_tradeorders_lowsec;
import java.util.ArrayList;

/**
 * Business Logic Entity class BLview_tradeorders_lowsec
 *
 * Class for manipulating data- and database objects
 * for View View_tradeorders_lowsec and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLview_tradeorders_lowsec extends Bview_tradeorders_lowsec {
//Metacoder: NO AUTHOMATIC UPDATE
	
    public ArrayList getTradeorders(float max_cargovolume, float net_perc, long min_profit) throws DBException {
        Object[][] parameter = { { "max_cargovolume", max_cargovolume }, { "net_perc", net_perc }, { "min_profit", min_profit } };
        SQLparameters sqlparameters = new SQLparameters(parameter);
        return getEntities(EMview_tradeorders_lowsec.SQLSelect4tradevalues, sqlparameters);
    }
    
    /**
     * Constructor, sets View_tradeorders_lowsec as default Entity
     */
    public BLview_tradeorders_lowsec() {
    }

}
