/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 13.6.2022 11:21
 */
 
package eve.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import eve.interfaces.logicview.IView_evetypes;
import eve.logicview.View_evetypes;
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
public class JSONView_evetypes {
    
    public static JSONArray toJSONArray(ArrayList view_evetypess) {
        JSONArray jsonview_evetypess = new JSONArray();
        Iterator view_evetypessI = view_evetypess.iterator();
        while(view_evetypessI.hasNext()) {
            jsonview_evetypess.add(JSONView_evetypes.toJSON((View_evetypes)view_evetypessI.next()));
        }
        return jsonview_evetypess;
    }

    public static JSONObject toJSON(IView_evetypes view_evetypes) {
        JSONObject json = new JSONObject();
        json.put("category", String.valueOf(view_evetypes.getCategory()));
        json.put("typegroupid", String.valueOf(view_evetypes.getTypegroupid()));
        json.put("typegroupname", view_evetypes.getTypegroupname());
        json.put("id", String.valueOf(view_evetypes.getId()));
        json.put("name", view_evetypes.getName());
        json.put("configuredbp", view_evetypes.getConfiguredbp());
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    public static View_evetypes toView_evetypes(JSONObject json) {
        View_evetypes view_evetypes = new View_evetypes();
        view_evetypes.setCategory(JSONConversion.getlong(json, "category"));
        view_evetypes.setTypegroupid(JSONConversion.getlong(json, "typegroupid"));
        view_evetypes.setTypegroupname(JSONConversion.getString(json, "typegroupname"));
        view_evetypes.setId(JSONConversion.getlong(json, "id"));
        view_evetypes.setName(JSONConversion.getString(json, "name"));
        view_evetypes.setConfiguredbp(JSONConversion.getboolean(json, "configuredbp"));
        return view_evetypes;
    }

    public static View_evetypessearch toView_evetypessearch(JSONObject json) {
        View_evetypessearch view_evetypessearch = new View_evetypessearch();
        view_evetypessearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        view_evetypessearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        view_evetypessearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("category");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_evetypessearch.category(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("typegroupid");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_evetypessearch.typegroupid(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("typegroupname");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_evetypessearch.typegroupname(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("id");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_evetypessearch.id(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("name");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_evetypessearch.name(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("configuredbp");
        if(field!=null) {
            boolean value = JSONConversion.getBooleanvalue(field);
            view_evetypessearch.configuredbp(value);
        }
        return view_evetypessearch;
    }
}

