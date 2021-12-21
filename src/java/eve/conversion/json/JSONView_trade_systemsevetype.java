/*
 * JSONView_trade_systemsevetype.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 16.11.2021 15:46
 *
 */
 
package eve.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import eve.interfaces.logicview.IView_trade_systemsevetype;
import eve.logicview.View_trade_systemsevetype;
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
public class JSONView_trade_systemsevetype {
    
    public static JSONArray toJSONArray(ArrayList view_trade_systemsevetypes) {
        JSONArray jsonview_trade_systemsevetypes = new JSONArray();
        Iterator view_trade_systemsevetypesI = view_trade_systemsevetypes.iterator();
        while(view_trade_systemsevetypesI.hasNext()) {
            jsonview_trade_systemsevetypes.add(JSONView_trade_systemsevetype.toJSON((View_trade_systemsevetype)view_trade_systemsevetypesI.next()));
        }
        return jsonview_trade_systemsevetypes;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(IView_trade_systemsevetype view_trade_systemsevetype) {
        JSONObject json = new JSONObject();
        json.put("systemsell", String.valueOf(view_trade_systemsevetype.getSystemsell()));
        json.put("systembuy", String.valueOf(view_trade_systemsevetype.getSystembuy()));
        json.put("evetype", String.valueOf(view_trade_systemsevetype.getEvetype()));
        json.put("jumps", view_trade_systemsevetype.getJumps());
        json.put("jumpslowsec", view_trade_systemsevetype.getJumpslowsec());
        json.put("jumpsnullsec", view_trade_systemsevetype.getJumpsnullsec());
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    public static View_trade_systemsevetype toView_trade_systemsevetype(JSONObject json) {
        View_trade_systemsevetype view_trade_systemsevetype = new View_trade_systemsevetype();
        view_trade_systemsevetype.setSystemsell(JSONConversion.getlong(json, "systemsell"));
        view_trade_systemsevetype.setSystembuy(JSONConversion.getlong(json, "systembuy"));
        view_trade_systemsevetype.setEvetype(JSONConversion.getlong(json, "evetype"));
        view_trade_systemsevetype.setJumps(JSONConversion.getint(json, "jumps"));
        view_trade_systemsevetype.setJumpslowsec(JSONConversion.getint(json, "jumpslowsec"));
        view_trade_systemsevetype.setJumpsnullsec(JSONConversion.getint(json, "jumpsnullsec"));
        return view_trade_systemsevetype;
    }

    /**
     * 
     * @param json: JSONObject with the View_trade_systemsevetypesearch parameters
     * @return 
     */
    public static View_trade_systemsevetypesearch toView_trade_systemsevetypesearch(JSONObject json) {
        View_trade_systemsevetypesearch view_trade_systemsevetypesearch = new View_trade_systemsevetypesearch();
        view_trade_systemsevetypesearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        view_trade_systemsevetypesearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        view_trade_systemsevetypesearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("systemsell");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_trade_systemsevetypesearch.systemsell(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("systembuy");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_trade_systemsevetypesearch.systembuy(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("evetype");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_trade_systemsevetypesearch.evetype(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("jumps");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_trade_systemsevetypesearch.jumps(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("jumpslowsec");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_trade_systemsevetypesearch.jumpslowsec(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("jumpsnullsec");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_trade_systemsevetypesearch.jumpsnullsec(valuearray, operators, andor);
        }
        return view_trade_systemsevetypesearch;
    }
}

