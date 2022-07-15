package eve.usecases.custom;

import data.conversion.JSONConversion;
import eve.data.Swagger;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * @author Franky Laseure
 */
public class Swagger_usecases {

    public Swagger_usecases() {
    }
    
    public JSONObject findOrder(long regionid, int page, long orderid) {
        JSONObject jsonorder = null;
        JSONArray jsonorders = Swagger.getMarket_region_orders(regionid, page);
        jsonorder = findOrder(jsonorders, orderid);
        if(jsonorder==null && page>1) {
            jsonorders = Swagger.getMarket_region_orders(regionid, page-1);
            jsonorder = findOrder(jsonorders, orderid);
        }        
        return jsonorder;
    }
    
    private JSONObject findOrder(JSONArray jsonorders, long orderid) {
        JSONObject result = null;
        JSONObject jsonorder;
        Iterator<JSONObject> jsonordersI = jsonorders.iterator();
        boolean keeprunning = true;
        while(jsonordersI.hasNext() && keeprunning) {
            jsonorder = jsonordersI.next();
            if(JSONConversion.getLong(jsonorder, "order_id")==orderid) {
                result = jsonorder;
                keeprunning = false;
            }
        }
        return result;
    }
    
}
