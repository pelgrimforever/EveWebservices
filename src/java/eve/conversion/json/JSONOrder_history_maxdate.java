/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 17.6.2022 13:4
 */
 
package eve.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import eve.interfaces.logicview.IOrder_history_maxdate;
import eve.logicview.Order_history_maxdate;
import eve.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * @author Franky Laseure
 */
public class JSONOrder_history_maxdate {
    
    public static JSONArray toJSONArray(ArrayList order_history_maxdates) {
        JSONArray jsonorder_history_maxdates = new JSONArray();
        Iterator order_history_maxdatesI = order_history_maxdates.iterator();
        while(order_history_maxdatesI.hasNext()) {
            jsonorder_history_maxdates.add(JSONOrder_history_maxdate.toJSON((Order_history_maxdate)order_history_maxdatesI.next()));
        }
        return jsonorder_history_maxdates;
    }

    public static JSONObject toJSON(IOrder_history_maxdate order_history_maxdate) {
        JSONObject json = new JSONObject();
        if(order_history_maxdate.getMaxdate()!=null) {
	        json.put("maxdate", order_history_maxdate.getMaxdate().getTime());
        }
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    public static Order_history_maxdate toOrder_history_maxdate(JSONObject json) {
        Order_history_maxdate order_history_maxdate = new Order_history_maxdate();
        order_history_maxdate.setMaxdate(JSONConversion.getDate(json, "maxdate"));
        return order_history_maxdate;
    }

    public static Order_history_maxdatesearch toOrder_history_maxdatesearch(JSONObject json) {
        Order_history_maxdatesearch order_history_maxdatesearch = new Order_history_maxdatesearch();
        order_history_maxdatesearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        order_history_maxdatesearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        order_history_maxdatesearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("maxdate");
        if(field!=null) {
            Date[] valuearray = JSONConversion.getDatevalues(field);
            byte[] operators = JSONConversion.getDateoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            order_history_maxdatesearch.maxdate(valuearray, operators, andor);
        }
        return order_history_maxdatesearch;
    }
}

