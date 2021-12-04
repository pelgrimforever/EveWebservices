/*
 * JSONView_stocktrade_system.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 4.11.2021 14:51
 *
 */
 
package eve.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import eve.interfaces.logicview.IView_stocktrade_system;
import eve.logicview.View_stocktrade_system;
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
public class JSONView_stocktrade_system {
    
    public static JSONArray toJSONArray(ArrayList view_stocktrade_systems) {
        JSONArray jsonview_stocktrade_systems = new JSONArray();
        Iterator view_stocktrade_systemsI = view_stocktrade_systems.iterator();
        while(view_stocktrade_systemsI.hasNext()) {
            jsonview_stocktrade_systems.add(JSONView_stocktrade_system.toJSON((View_stocktrade_system)view_stocktrade_systemsI.next()));
        }
        return jsonview_stocktrade_systems;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(IView_stocktrade_system view_stocktrade_system) {
        JSONObject json = new JSONObject();
        json.put("username", view_stocktrade_system.getUsername());
        json.put("id", String.valueOf(view_stocktrade_system.getId()));
        json.put("name", view_stocktrade_system.getName());
        json.put("region", view_stocktrade_system.getRegion());
        json.put("sellprice", view_stocktrade_system.getSellprice());
        json.put("totalvolume", view_stocktrade_system.getTotalvolume());
//Custom code, do not change this line
        json.put("start_system", String.valueOf(view_stocktrade_system.getStart_system()));
        json.put("start_system_jumps", view_stocktrade_system.getStart_system_jumps());
//Custom code, do not change this line
        return json;
    }

    public static View_stocktrade_system toView_stocktrade_system(JSONObject json) {
        View_stocktrade_system view_stocktrade_system = new View_stocktrade_system();
        view_stocktrade_system.setUsername(JSONConversion.getString(json, "username"));
        view_stocktrade_system.setId(JSONConversion.getlong(json, "id"));
        view_stocktrade_system.setName(JSONConversion.getString(json, "name"));
        view_stocktrade_system.setRegion(JSONConversion.getString(json, "region"));
        view_stocktrade_system.setSellprice(JSONConversion.getdouble(json, "sellprice"));
        view_stocktrade_system.setTotalvolume(JSONConversion.getdouble(json, "totalvolume"));
        return view_stocktrade_system;
    }

    /**
     * 
     * @param json: JSONObject with the View_stocktrade_systemsearch parameters
     * @return 
     */
    public static View_stocktrade_systemsearch toView_stocktrade_systemsearch(JSONObject json) {
        View_stocktrade_systemsearch view_stocktrade_systemsearch = new View_stocktrade_systemsearch();
        view_stocktrade_systemsearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        view_stocktrade_systemsearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        view_stocktrade_systemsearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("username");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_stocktrade_systemsearch.username(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("id");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_stocktrade_systemsearch.id(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("name");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_stocktrade_systemsearch.name(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("region");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_stocktrade_systemsearch.region(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("sellprice");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_stocktrade_systemsearch.sellprice(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("totalvolume");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_stocktrade_systemsearch.totalvolume(valuearray, operators, andor);
        }
        return view_stocktrade_systemsearch;
    }
}

