/*
 * JSONView_stock.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 16.11.2021 15:46
 *
 */
 
package eve.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import eve.interfaces.logicview.IView_stock;
import eve.logicview.View_stock;
import eve.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author Franky Laseure
 */
public class JSONView_stock {
    
    public static JSONArray toJSONArray(ArrayList view_stocks) {
        JSONArray jsonview_stocks = new JSONArray();
        Iterator view_stocksI = view_stocks.iterator();
        while(view_stocksI.hasNext()) {
            jsonview_stocks.add(JSONView_stock.toJSON((View_stock)view_stocksI.next()));
        }
        return jsonview_stocks;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(IView_stock view_stock) {
        JSONObject json = new JSONObject();
        json.put("username", view_stock.getUsername());
        json.put("evetype", String.valueOf(view_stock.getEvetype()));
        json.put("amount", String.valueOf(view_stock.getAmount()));
        json.put("name", view_stock.getName());
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    public static View_stock toView_stock(JSONObject json) {
        View_stock view_stock = new View_stock();
        view_stock.setUsername(JSONConversion.getString(json, "username"));
        view_stock.setEvetype(JSONConversion.getlong(json, "evetype"));
        view_stock.setAmount(JSONConversion.getlong(json, "amount"));
        view_stock.setName(JSONConversion.getString(json, "name"));
        return view_stock;
    }

    /**
     * 
     * @param json: JSONObject with the View_stocksearch parameters
     * @return 
     */
    public static View_stocksearch toView_stocksearch(JSONObject json) {
        View_stocksearch view_stocksearch = new View_stocksearch();
        view_stocksearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        view_stocksearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        view_stocksearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("username");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_stocksearch.username(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("evetype");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_stocksearch.evetype(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("amount");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_stocksearch.amount(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("name");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_stocksearch.name(valuearray, compareoperator, andor);
        }
        return view_stocksearch;
    }
}

