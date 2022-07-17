/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 17.6.2022 13:4
 */
 
package eve.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import eve.interfaces.logicview.IView_security_island_systemcount;
import eve.logicview.View_security_island_systemcount;
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
public class JSONView_security_island_systemcount {
    
    public static JSONArray toJSONArray(ArrayList view_security_island_systemcounts) {
        JSONArray jsonview_security_island_systemcounts = new JSONArray();
        Iterator view_security_island_systemcountsI = view_security_island_systemcounts.iterator();
        while(view_security_island_systemcountsI.hasNext()) {
            jsonview_security_island_systemcounts.add(JSONView_security_island_systemcount.toJSON((View_security_island_systemcount)view_security_island_systemcountsI.next()));
        }
        return jsonview_security_island_systemcounts;
    }

    public static JSONObject toJSON(IView_security_island_systemcount view_security_island_systemcount) {
        JSONObject json = new JSONObject();
        json.put("id", String.valueOf(view_security_island_systemcount.getId()));
        json.put("name", view_security_island_systemcount.getName());
        json.put("systems", String.valueOf(view_security_island_systemcount.getSystems()));
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    public static View_security_island_systemcount toView_security_island_systemcount(JSONObject json) {
        View_security_island_systemcount view_security_island_systemcount = new View_security_island_systemcount();
        view_security_island_systemcount.setId(JSONConversion.getlong(json, "id"));
        view_security_island_systemcount.setName(JSONConversion.getString(json, "name"));
        view_security_island_systemcount.setSystems(JSONConversion.getlong(json, "systems"));
        return view_security_island_systemcount;
    }

    public static View_security_island_systemcountsearch toView_security_island_systemcountsearch(JSONObject json) {
        View_security_island_systemcountsearch view_security_island_systemcountsearch = new View_security_island_systemcountsearch();
        view_security_island_systemcountsearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        view_security_island_systemcountsearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        view_security_island_systemcountsearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("id");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_security_island_systemcountsearch.id(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("name");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_security_island_systemcountsearch.name(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("systems");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_security_island_systemcountsearch.systems(valuearray, operators, andor);
        }
        return view_security_island_systemcountsearch;
    }
}

