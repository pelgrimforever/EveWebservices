/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 13.6.2022 11:21
 */
 
package eve.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import eve.interfaces.logicview.IView_userbp;
import eve.logicview.View_userbp;
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
public class JSONView_userbp {
    
    public static JSONArray toJSONArray(ArrayList view_userbps) {
        JSONArray jsonview_userbps = new JSONArray();
        Iterator view_userbpsI = view_userbps.iterator();
        while(view_userbpsI.hasNext()) {
            jsonview_userbps.add(JSONView_userbp.toJSON((View_userbp)view_userbpsI.next()));
        }
        return jsonview_userbps;
    }

    public static JSONObject toJSON(IView_userbp view_userbp) {
        JSONObject json = new JSONObject();
        json.put("blueprintname", view_userbp.getBlueprintname());
        json.put("typegroupname", view_userbp.getTypegroupname());
        json.put("username", view_userbp.getUsername());
        json.put("bp", String.valueOf(view_userbp.getBp()));
        json.put("serialnumber", view_userbp.getSerialnumber());
        json.put("original", view_userbp.getOriginal());
        json.put("materialefficiency", view_userbp.getMaterialefficiency());
        json.put("amountproduced", view_userbp.getAmountproduced());
        json.put("totalamount", view_userbp.getTotalamount());
        json.put("bpprice", view_userbp.getBpprice());
        json.put("researchcost", view_userbp.getResearchcost());
        json.put("stationfee", view_userbp.getStationfee());
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    public static View_userbp toView_userbp(JSONObject json) {
        View_userbp view_userbp = new View_userbp();
        view_userbp.setBlueprintname(JSONConversion.getString(json, "blueprintname"));
        view_userbp.setTypegroupname(JSONConversion.getString(json, "typegroupname"));
        view_userbp.setUsername(JSONConversion.getString(json, "username"));
        view_userbp.setBp(JSONConversion.getlong(json, "bp"));
        view_userbp.setSerialnumber(JSONConversion.getint(json, "serialnumber"));
        view_userbp.setOriginal(JSONConversion.getboolean(json, "original"));
        view_userbp.setMaterialefficiency(JSONConversion.getint(json, "materialefficiency"));
        view_userbp.setAmountproduced(JSONConversion.getint(json, "amountproduced"));
        view_userbp.setTotalamount(JSONConversion.getint(json, "totalamount"));
        view_userbp.setBpprice(JSONConversion.getdouble(json, "bpprice"));
        view_userbp.setResearchcost(JSONConversion.getdouble(json, "researchcost"));
        view_userbp.setStationfee(JSONConversion.getdouble(json, "stationfee"));
        return view_userbp;
    }

    public static View_userbpsearch toView_userbpsearch(JSONObject json) {
        View_userbpsearch view_userbpsearch = new View_userbpsearch();
        view_userbpsearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        view_userbpsearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        view_userbpsearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("blueprintname");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_userbpsearch.blueprintname(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("typegroupname");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_userbpsearch.typegroupname(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("username");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_userbpsearch.username(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("bp");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_userbpsearch.bp(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("serialnumber");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_userbpsearch.serialnumber(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("original");
        if(field!=null) {
            boolean value = JSONConversion.getBooleanvalue(field);
            view_userbpsearch.original(value);
        }
        field = (JSONObject)fss.get("materialefficiency");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_userbpsearch.materialefficiency(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("amountproduced");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_userbpsearch.amountproduced(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("totalamount");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_userbpsearch.totalamount(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("bpprice");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_userbpsearch.bpprice(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("researchcost");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_userbpsearch.researchcost(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("stationfee");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_userbpsearch.stationfee(valuearray, operators, andor);
        }
        return view_userbpsearch;
    }
}

