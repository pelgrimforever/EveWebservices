/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 13.6.2022 11:21
 */
 
package eve.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import eve.interfaces.logicview.IView_userbpmaterial;
import eve.logicview.View_userbpmaterial;
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
public class JSONView_userbpmaterial {
    
    public static JSONArray toJSONArray(ArrayList view_userbpmaterials) {
        JSONArray jsonview_userbpmaterials = new JSONArray();
        Iterator view_userbpmaterialsI = view_userbpmaterials.iterator();
        while(view_userbpmaterialsI.hasNext()) {
            jsonview_userbpmaterials.add(JSONView_userbpmaterial.toJSON((View_userbpmaterial)view_userbpmaterialsI.next()));
        }
        return jsonview_userbpmaterials;
    }

    public static JSONObject toJSON(IView_userbpmaterial view_userbpmaterial) {
        JSONObject json = new JSONObject();
        json.put("username", view_userbpmaterial.getUsername());
        json.put("serialnumber", view_userbpmaterial.getSerialnumber());
        json.put("bp", String.valueOf(view_userbpmaterial.getBp()));
        json.put("material", String.valueOf(view_userbpmaterial.getMaterial()));
        json.put("amount", String.valueOf(view_userbpmaterial.getAmount()));
        json.put("category", String.valueOf(view_userbpmaterial.getCategory()));
        json.put("typegroupid", String.valueOf(view_userbpmaterial.getTypegroupid()));
        json.put("typegroupname", view_userbpmaterial.getTypegroupname());
        json.put("name", view_userbpmaterial.getName());
        json.put("marketaverage", view_userbpmaterial.getMarketaverage());
        json.put("materialinputaverage", view_userbpmaterial.getMaterialinputaverage());
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    public static View_userbpmaterial toView_userbpmaterial(JSONObject json) {
        View_userbpmaterial view_userbpmaterial = new View_userbpmaterial();
        view_userbpmaterial.setUsername(JSONConversion.getString(json, "username"));
        view_userbpmaterial.setSerialnumber(JSONConversion.getint(json, "serialnumber"));
        view_userbpmaterial.setBp(JSONConversion.getlong(json, "bp"));
        view_userbpmaterial.setMaterial(JSONConversion.getlong(json, "material"));
        view_userbpmaterial.setAmount(JSONConversion.getlong(json, "amount"));
        view_userbpmaterial.setCategory(JSONConversion.getlong(json, "category"));
        view_userbpmaterial.setTypegroupid(JSONConversion.getlong(json, "typegroupid"));
        view_userbpmaterial.setTypegroupname(JSONConversion.getString(json, "typegroupname"));
        view_userbpmaterial.setName(JSONConversion.getString(json, "name"));
        view_userbpmaterial.setMarketaverage(JSONConversion.getdouble(json, "marketaverage"));
        view_userbpmaterial.setMaterialinputaverage(JSONConversion.getdouble(json, "materialinputaverage"));
        return view_userbpmaterial;
    }

    public static View_userbpmaterialsearch toView_userbpmaterialsearch(JSONObject json) {
        View_userbpmaterialsearch view_userbpmaterialsearch = new View_userbpmaterialsearch();
        view_userbpmaterialsearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        view_userbpmaterialsearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        view_userbpmaterialsearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("username");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_userbpmaterialsearch.username(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("serialnumber");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_userbpmaterialsearch.serialnumber(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("bp");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_userbpmaterialsearch.bp(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("material");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_userbpmaterialsearch.material(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("amount");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_userbpmaterialsearch.amount(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("category");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_userbpmaterialsearch.category(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("typegroupid");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_userbpmaterialsearch.typegroupid(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("typegroupname");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_userbpmaterialsearch.typegroupname(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("name");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_userbpmaterialsearch.name(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("marketaverage");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_userbpmaterialsearch.marketaverage(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("materialinputaverage");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_userbpmaterialsearch.materialinputaverage(valuearray, operators, andor);
        }
        return view_userbpmaterialsearch;
    }
}

