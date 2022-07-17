/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 17.6.2022 13:4
 */
 
package eve.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import eve.interfaces.logicview.IView_activemodules;
import eve.logicview.View_activemodules;
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
public class JSONView_activemodules {
    
    public static JSONArray toJSONArray(ArrayList view_activemoduless) {
        JSONArray jsonview_activemoduless = new JSONArray();
        Iterator view_activemodulessI = view_activemoduless.iterator();
        while(view_activemodulessI.hasNext()) {
            jsonview_activemoduless.add(JSONView_activemodules.toJSON((View_activemodules)view_activemodulessI.next()));
        }
        return jsonview_activemoduless;
    }

    public static JSONObject toJSON(IView_activemodules view_activemodules) {
        JSONObject json = new JSONObject();
        json.put("typegroupid", String.valueOf(view_activemodules.getTypegroupid()));
        json.put("typegroupname", view_activemodules.getTypegroupname());
        json.put("id", String.valueOf(view_activemodules.getId()));
        json.put("name", view_activemodules.getName());
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    public static View_activemodules toView_activemodules(JSONObject json) {
        View_activemodules view_activemodules = new View_activemodules();
        view_activemodules.setTypegroupid(JSONConversion.getlong(json, "typegroupid"));
        view_activemodules.setTypegroupname(JSONConversion.getString(json, "typegroupname"));
        view_activemodules.setId(JSONConversion.getlong(json, "id"));
        view_activemodules.setName(JSONConversion.getString(json, "name"));
        return view_activemodules;
    }

    public static View_activemodulessearch toView_activemodulessearch(JSONObject json) {
        View_activemodulessearch view_activemodulessearch = new View_activemodulessearch();
        view_activemodulessearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        view_activemodulessearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        view_activemodulessearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("typegroupid");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_activemodulessearch.typegroupid(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("typegroupname");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_activemodulessearch.typegroupname(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("id");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_activemodulessearch.id(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("name");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_activemodulessearch.name(valuearray, compareoperator, andor);
        }
        return view_activemodulessearch;
    }
}

