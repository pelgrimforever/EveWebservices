/*
 * JSONView_stocktrade_orders.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 4.11.2021 14:51
 *
 */
 
package eve.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import eve.interfaces.logicview.IView_stocktrade_orders;
import eve.logicview.View_stocktrade_orders;
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
public class JSONView_stocktrade_orders {
    
    public static JSONArray toJSONArray(ArrayList view_stocktrade_orderss) {
        JSONArray jsonview_stocktrade_orderss = new JSONArray();
        Iterator view_stocktrade_orderssI = view_stocktrade_orderss.iterator();
        while(view_stocktrade_orderssI.hasNext()) {
            jsonview_stocktrade_orderss.add(JSONView_stocktrade_orders.toJSON((View_stocktrade_orders)view_stocktrade_orderssI.next()));
        }
        return jsonview_stocktrade_orderss;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(IView_stocktrade_orders view_stocktrade_orders) {
        JSONObject json = new JSONObject();
        json.put("username", view_stocktrade_orders.getUsername());
        json.put("system", String.valueOf(view_stocktrade_orders.getSystem()));
        json.put("locationid", String.valueOf(view_stocktrade_orders.getLocationid()));
        json.put("stationname", view_stocktrade_orders.getStationname());
        json.put("locationname", view_stocktrade_orders.getLocationname());
        json.put("evetypeid", String.valueOf(view_stocktrade_orders.getEvetypeid()));
        json.put("evetypename", view_stocktrade_orders.getEvetypename());
        json.put("packaged_volume", view_stocktrade_orders.getPackaged_volume());
        json.put("min_volume", view_stocktrade_orders.getMin_volume());
        json.put("sellamount", String.valueOf(view_stocktrade_orders.getSellamount()));
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    public static View_stocktrade_orders toView_stocktrade_orders(JSONObject json) {
        View_stocktrade_orders view_stocktrade_orders = new View_stocktrade_orders();
        view_stocktrade_orders.setUsername(JSONConversion.getString(json, "username"));
        view_stocktrade_orders.setSystem(JSONConversion.getlong(json, "system"));
        view_stocktrade_orders.setLocationid(JSONConversion.getlong(json, "locationid"));
        view_stocktrade_orders.setStationname(JSONConversion.getString(json, "stationname"));
        view_stocktrade_orders.setLocationname(JSONConversion.getString(json, "locationname"));
        view_stocktrade_orders.setEvetypeid(JSONConversion.getlong(json, "evetypeid"));
        view_stocktrade_orders.setEvetypename(JSONConversion.getString(json, "evetypename"));
        view_stocktrade_orders.setPackaged_volume(JSONConversion.getdouble(json, "packaged_volume"));
        view_stocktrade_orders.setMin_volume(JSONConversion.getint(json, "min_volume"));
        view_stocktrade_orders.setSellamount(JSONConversion.getlong(json, "sellamount"));
        return view_stocktrade_orders;
    }

    /**
     * 
     * @param json: JSONObject with the View_stocktrade_orderssearch parameters
     * @return 
     */
    public static View_stocktrade_orderssearch toView_stocktrade_orderssearch(JSONObject json) {
        View_stocktrade_orderssearch view_stocktrade_orderssearch = new View_stocktrade_orderssearch();
        view_stocktrade_orderssearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        view_stocktrade_orderssearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        view_stocktrade_orderssearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("username");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_stocktrade_orderssearch.username(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("system");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_stocktrade_orderssearch.system(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("locationid");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_stocktrade_orderssearch.locationid(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("stationname");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_stocktrade_orderssearch.stationname(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("locationname");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_stocktrade_orderssearch.locationname(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("evetypeid");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_stocktrade_orderssearch.evetypeid(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("evetypename");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_stocktrade_orderssearch.evetypename(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("packaged_volume");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_stocktrade_orderssearch.packaged_volume(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("min_volume");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_stocktrade_orderssearch.min_volume(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("sellamount");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_stocktrade_orderssearch.sellamount(valuearray, operators, andor);
        }
        return view_stocktrade_orderssearch;
    }
}

