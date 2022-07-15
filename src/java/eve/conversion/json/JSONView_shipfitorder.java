/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 13.6.2022 11:21
 */
 
package eve.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import eve.interfaces.logicview.IView_shipfitorder;
import eve.logicview.View_shipfitorder;
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
public class JSONView_shipfitorder {
    
    public static JSONArray toJSONArray(ArrayList view_shipfitorders) {
        JSONArray jsonview_shipfitorders = new JSONArray();
        Iterator view_shipfitordersI = view_shipfitorders.iterator();
        while(view_shipfitordersI.hasNext()) {
            jsonview_shipfitorders.add(JSONView_shipfitorder.toJSON((View_shipfitorder)view_shipfitordersI.next()));
        }
        return jsonview_shipfitorders;
    }

    public static JSONObject toJSON(IView_shipfitorder view_shipfitorder) {
        JSONObject json = new JSONObject();
        json.put("evetypename", view_shipfitorder.getEvetypename());
        json.put("packaged_volume", view_shipfitorder.getPackaged_volume());
        json.put("username", view_shipfitorder.getUsername());
        json.put("shipname", view_shipfitorder.getShipname());
        json.put("evetype", String.valueOf(view_shipfitorder.getEvetype()));
        json.put("amountwanted", view_shipfitorder.getAmountwanted());
        json.put("amountinstock", view_shipfitorder.getAmountinstock());
        json.put("amountplanned", String.valueOf(view_shipfitorder.getAmountplanned()));
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    public static View_shipfitorder toView_shipfitorder(JSONObject json) {
        View_shipfitorder view_shipfitorder = new View_shipfitorder();
        view_shipfitorder.setEvetypename(JSONConversion.getString(json, "evetypename"));
        view_shipfitorder.setPackaged_volume(JSONConversion.getdouble(json, "packaged_volume"));
        view_shipfitorder.setUsername(JSONConversion.getString(json, "username"));
        view_shipfitorder.setShipname(JSONConversion.getString(json, "shipname"));
        view_shipfitorder.setEvetype(JSONConversion.getlong(json, "evetype"));
        view_shipfitorder.setAmountwanted(JSONConversion.getint(json, "amountwanted"));
        view_shipfitorder.setAmountinstock(JSONConversion.getint(json, "amountinstock"));
        view_shipfitorder.setAmountplanned(JSONConversion.getlong(json, "amountplanned"));
        return view_shipfitorder;
    }

    public static View_shipfitordersearch toView_shipfitordersearch(JSONObject json) {
        View_shipfitordersearch view_shipfitordersearch = new View_shipfitordersearch();
        view_shipfitordersearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        view_shipfitordersearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        view_shipfitordersearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("evetypename");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_shipfitordersearch.evetypename(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("packaged_volume");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_shipfitordersearch.packaged_volume(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("username");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_shipfitordersearch.username(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("shipname");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_shipfitordersearch.shipname(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("evetype");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_shipfitordersearch.evetype(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("amountwanted");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_shipfitordersearch.amountwanted(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("amountinstock");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_shipfitordersearch.amountinstock(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("amountplanned");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_shipfitordersearch.amountplanned(valuearray, operators, andor);
        }
        return view_shipfitordersearch;
    }
}

