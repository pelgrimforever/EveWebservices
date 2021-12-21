/*
 * JSONView_shipfit.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 17.11.2021 15:41
 *
 */
 
package eve.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import eve.interfaces.logicview.IView_shipfit;
import eve.logicview.View_shipfit;
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
public class JSONView_shipfit {
    
    public static JSONArray toJSONArray(ArrayList view_shipfits) {
        JSONArray jsonview_shipfits = new JSONArray();
        Iterator view_shipfitsI = view_shipfits.iterator();
        while(view_shipfitsI.hasNext()) {
            jsonview_shipfits.add(JSONView_shipfit.toJSON((View_shipfit)view_shipfitsI.next()));
        }
        return jsonview_shipfits;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(IView_shipfit view_shipfit) {
        JSONObject json = new JSONObject();
        json.put("shiptype", view_shipfit.getShiptype());
        json.put("packaged_volume", view_shipfit.getPackaged_volume());
        json.put("username", view_shipfit.getUsername());
        json.put("shipname", view_shipfit.getShipname());
        json.put("evetype", String.valueOf(view_shipfit.getEvetype()));
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    public static View_shipfit toView_shipfit(JSONObject json) {
        View_shipfit view_shipfit = new View_shipfit();
        view_shipfit.setShiptype(JSONConversion.getString(json, "shiptype"));
        view_shipfit.setPackaged_volume(JSONConversion.getdouble(json, "packaged_volume"));
        view_shipfit.setUsername(JSONConversion.getString(json, "username"));
        view_shipfit.setShipname(JSONConversion.getString(json, "shipname"));
        view_shipfit.setEvetype(JSONConversion.getlong(json, "evetype"));
        return view_shipfit;
    }

    /**
     * 
     * @param json: JSONObject with the View_shipfitsearch parameters
     * @return 
     */
    public static View_shipfitsearch toView_shipfitsearch(JSONObject json) {
        View_shipfitsearch view_shipfitsearch = new View_shipfitsearch();
        view_shipfitsearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        view_shipfitsearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        view_shipfitsearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("shiptype");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_shipfitsearch.shiptype(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("packaged_volume");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_shipfitsearch.packaged_volume(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("username");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_shipfitsearch.username(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("shipname");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_shipfitsearch.shipname(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("evetype");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_shipfitsearch.evetype(valuearray, operators, andor);
        }
        return view_shipfitsearch;
    }
}

