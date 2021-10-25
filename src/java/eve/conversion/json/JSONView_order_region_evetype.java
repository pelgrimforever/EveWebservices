/*
 * JSONView_order_region_evetype.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 25.9.2021 15:16
 *
 */
 
package eve.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import eve.interfaces.logicview.IView_order_region_evetype;
import eve.logicview.View_order_region_evetype;
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
public class JSONView_order_region_evetype {
    
    public static JSONArray toJSONArray(ArrayList view_order_region_evetypes) {
        JSONArray jsonview_order_region_evetypes = new JSONArray();
        Iterator view_order_region_evetypesI = view_order_region_evetypes.iterator();
        while(view_order_region_evetypesI.hasNext()) {
            jsonview_order_region_evetypes.add(JSONView_order_region_evetype.toJSON((View_order_region_evetype)view_order_region_evetypesI.next()));
        }
        return jsonview_order_region_evetypes;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(IView_order_region_evetype view_order_region_evetype) {
        JSONObject json = new JSONObject();
        json.put("region", String.valueOf(view_order_region_evetype.getRegion()));
        json.put("evetype", String.valueOf(view_order_region_evetype.getEvetype()));
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    public static View_order_region_evetype toView_order_region_evetype(JSONObject json) {
        View_order_region_evetype view_order_region_evetype = new View_order_region_evetype();
        view_order_region_evetype.setRegion(JSONConversion.getlong(json, "region"));
        view_order_region_evetype.setEvetype(JSONConversion.getlong(json, "evetype"));
        return view_order_region_evetype;
    }

    /**
     * 
     * @param json: JSONObject with the View_order_region_evetypesearch parameters
     * @return 
     */
    public static View_order_region_evetypesearch toView_order_region_evetypesearch(JSONObject json) {
        View_order_region_evetypesearch view_order_region_evetypesearch = new View_order_region_evetypesearch();
        view_order_region_evetypesearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        view_order_region_evetypesearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        view_order_region_evetypesearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("region");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_order_region_evetypesearch.region(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("evetype");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_order_region_evetypesearch.evetype(valuearray, operators, andor);
        }
        return view_order_region_evetypesearch;
    }
}

