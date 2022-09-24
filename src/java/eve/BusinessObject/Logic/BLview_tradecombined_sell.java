/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 27.10.2021 18:14
 * @author Franky Laseure
 */

package eve.BusinessObject.Logic;

import data.conversion.JSONConversion;
import db.*;
import general.exception.DBException;
import eve.BusinessObject.view.Bview_tradecombined_sell;
import eve.conversion.entity.EMview_tradecombined_sell;
import eve.entity.pk.OrdersPK;
import eve.entity.pk.SystemPK;
import eve.entity.pk.TradecombinedPK;
import eve.logicview.View_order;
import eve.logicview.View_tradecombined_sell;
import java.util.ArrayList;
import org.json.simple.JSONObject;

public class BLview_tradecombined_sell extends Bview_tradecombined_sell {
//Metacoder: NO AUTHOMATIC UPDATE
	
    public BLview_tradecombined_sell(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(true);
    }
    
    public ArrayList<View_tradecombined_sell> getView_tradecombined_sells_for_evetype(TradecombinedPK tradecombinedPK) throws DBException {
        return viewio.getEntities(EMview_tradecombined_sell.SQLSelect4Tradecombined_sell, tradecombinedPK.getSQLprimarykey());
    }    

    public ArrayList<View_tradecombined_sell> getView_tradecombined_sells_for_all_evetypes(SystemPK sell_systemPK, SystemPK buy_systemPK) throws DBException {
        Object[][] systemparameters = { { "sell_system", sell_systemPK.getId() }, { "buy_system", buy_systemPK.getId() } };
        SQLparameters sqlparameters = new SQLparameters(systemparameters);
        return viewio.getEntities(EMview_tradecombined_sell.SQLSelect4sellbuysystem, sqlparameters);
    }    

}
