/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 7.11.2021 16:9
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import db.*;
import eve.BusinessObject.view.Bview_tradeorders_lowsec;
import eve.conversion.entity.EMview_tradeorders_lowsec;
import java.util.ArrayList;

/**
 * @author Franky Laseure
 */
public class BLview_tradeorders_lowsec extends Bview_tradeorders_lowsec {
//Metacoder: NO AUTHOMATIC UPDATE
	
    public ArrayList getTradeorders(float max_cargovolume, float net_perc, long min_profit) throws DBException {
        Object[][] parameter = { { "max_cargovolume", max_cargovolume }, { "net_perc", net_perc }, { "min_profit", min_profit } };
        SQLparameters sqlparameters = new SQLparameters(parameter);
        return viewio.getEntities(EMview_tradeorders_lowsec.SQLSelect4tradevalues, sqlparameters);
    }
    
    public BLview_tradeorders_lowsec(SQLreader sqlreader) {
        super(sqlreader);
    }

}
