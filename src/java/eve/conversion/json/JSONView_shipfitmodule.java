/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 17.6.2022 13:4
 */
 
package eve.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import eve.interfaces.logicview.IView_shipfitmodule;
import eve.logicview.View_shipfitmodule;
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
public class JSONView_shipfitmodule {
    
    public static JSONArray toJSONArray(ArrayList view_shipfitmodules) {
        JSONArray jsonview_shipfitmodules = new JSONArray();
        Iterator view_shipfitmodulesI = view_shipfitmodules.iterator();
        while(view_shipfitmodulesI.hasNext()) {
            jsonview_shipfitmodules.add(JSONView_shipfitmodule.toJSON((View_shipfitmodule)view_shipfitmodulesI.next()));
        }
        return jsonview_shipfitmodules;
    }

    public static JSONObject toJSON(IView_shipfitmodule view_shipfitmodule) {
        JSONObject json = new JSONObject();
        json.put("modulename", view_shipfitmodule.getModulename());
        json.put("packaged_volume", view_shipfitmodule.getPackaged_volume());
        json.put("username", view_shipfitmodule.getUsername());
        json.put("shipname", view_shipfitmodule.getShipname());
        json.put("moduletype", String.valueOf(view_shipfitmodule.getModuletype()));
        json.put("amount", view_shipfitmodule.getAmount());
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    public static View_shipfitmodule toView_shipfitmodule(JSONObject json) {
        View_shipfitmodule view_shipfitmodule = new View_shipfitmodule();
        view_shipfitmodule.setModulename(JSONConversion.getString(json, "modulename"));
        view_shipfitmodule.setPackaged_volume(JSONConversion.getdouble(json, "packaged_volume"));
        view_shipfitmodule.setUsername(JSONConversion.getString(json, "username"));
        view_shipfitmodule.setShipname(JSONConversion.getString(json, "shipname"));
        view_shipfitmodule.setModuletype(JSONConversion.getlong(json, "moduletype"));
        view_shipfitmodule.setAmount(JSONConversion.getint(json, "amount"));
        return view_shipfitmodule;
    }

    public static View_shipfitmodulesearch toView_shipfitmodulesearch(JSONObject json) {
        View_shipfitmodulesearch view_shipfitmodulesearch = new View_shipfitmodulesearch();
        view_shipfitmodulesearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        view_shipfitmodulesearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        view_shipfitmodulesearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("modulename");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_shipfitmodulesearch.modulename(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("packaged_volume");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_shipfitmodulesearch.packaged_volume(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("username");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_shipfitmodulesearch.username(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("shipname");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_shipfitmodulesearch.shipname(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("moduletype");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_shipfitmodulesearch.moduletype(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("amount");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_shipfitmodulesearch.amount(valuearray, operators, andor);
        }
        return view_shipfitmodulesearch;
    }
}

