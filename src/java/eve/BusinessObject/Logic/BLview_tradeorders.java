/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 2.5.2021 16:26
 * @author Franky Laseure
 */

package eve.BusinessObject.Logic;

import db.*;
import eve.BusinessObject.view.Bview_tradeorders;
import eve.conversion.entity.EMview_tradeorders;
import eve.entity.pk.Security_islandPK;
import general.exception.DBException;
import java.util.ArrayList;

public class BLview_tradeorders extends Bview_tradeorders {
//Metacoder: NO AUTHOMATIC UPDATE
	
    
    public ArrayList getTradeorders(Security_islandPK security_islandPK, float max_cargovolume, float net_perc, long min_profit) throws DBException {
        Object[][] parameter = { { "max_cargovolume", max_cargovolume }, { "net_perc", net_perc }, { "min_profit", min_profit } };
        SQLparameters sqlparameters = new SQLparameters(parameter);
        sqlparameters.add(security_islandPK.getSQLprimarykey());
        return viewio.getEntities(EMview_tradeorders.SQLSelect4tradevalues, sqlparameters);
    }
    
    public BLview_tradeorders(SQLreader sqlreader) {
        super(sqlreader);
    }

}
