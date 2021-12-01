/*
 * BLview_tradecombined_sell.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 27.10.2021 18:14
 *
 */

package eve.BusinessObject.Logic;

import data.conversion.JSONConversion;
import general.exception.DBException;
import eve.BusinessObject.view.Bview_tradecombined_sell;
import eve.conversion.entity.EMview_tradecombined_sell;
import eve.entity.pk.OrdersPK;
import eve.entity.pk.TradecombinedPK;
import eve.logicview.View_order;
import eve.logicview.View_tradecombined_sell;
import java.util.ArrayList;
import org.json.simple.JSONObject;

/**
 * Business Logic Entity class BLview_tradecombined_sell
 *
 * Class for manipulating data- and database objects
 * for View View_tradecombined_sell and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLview_tradecombined_sell extends Bview_tradecombined_sell {
//Metacoder: NO AUTHOMATIC UPDATE
	
    /**
     * Constructor, sets View_tradecombined_sell as default Entity
     */
    public BLview_tradecombined_sell() {
    }
    
    /**
     * get all orders combined in a Tradecombined line
     * @param tradecombinedPK tradecombined primary key
     * @return List of View_tradecobmined_sells
     * @throws DBException 
     */
    public ArrayList getView_tradecombined_sells(TradecombinedPK tradecombinedPK) throws DBException {
        BLview_order blview_order = new BLview_order();
        ArrayList<View_tradecombined_sell> tradelines = getEntities(EMview_tradecombined_sell.SQLSelect4Tradecombined_sell, tradecombinedPK.getSQLprimarykey());
        OrdersPK sellordersPK;
        OrdersPK buyordersPK;
        View_order sellorder;
        View_order buyorder;
        for(View_tradecombined_sell tradeline: tradelines) {
            sellordersPK = new OrdersPK(tradeline.getSell_id());
            buyordersPK = new OrdersPK(tradeline.getBuy_id());
            sellorder = blview_order.getView_order(sellordersPK);
            buyorder = blview_order.getView_order(buyordersPK);
            JSONObject jsonsellorder = Swaggerorder.findOrder(sellorder.getRegion(), sellorder.getPage(), sellordersPK.getId());
            JSONObject jsonbuyorder = Swaggerorder.findOrder(buyorder.getRegion(), buyorder.getPage(), buyordersPK.getId());
            if(jsonsellorder!=null) {
                tradeline.setSell_updated(JSONConversion.getLong(jsonsellorder, "volume_remain"));
            }
            if(jsonbuyorder!=null) {
                tradeline.setBuy_updated(JSONConversion.getLong(jsonbuyorder, "volume_remain"));
            }
        }
        return tradelines;
    }    

}
