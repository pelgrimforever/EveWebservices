/*
 * JSONView_bpmaterial.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 26.0.2022 16:51
 *
 */
 
package eve.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import eve.interfaces.logicview.IView_bpmaterial;
import eve.logicview.View_bpmaterial;
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
public class JSONView_bpmaterial {
    
    public static JSONArray toJSONArray(ArrayList view_bpmaterials) {
        JSONArray jsonview_bpmaterials = new JSONArray();
        Iterator view_bpmaterialsI = view_bpmaterials.iterator();
        while(view_bpmaterialsI.hasNext()) {
            jsonview_bpmaterials.add(JSONView_bpmaterial.toJSON((View_bpmaterial)view_bpmaterialsI.next()));
        }
        return jsonview_bpmaterials;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(IView_bpmaterial view_bpmaterial) {
        JSONObject json = new JSONObject();
        json.put("bp", String.valueOf(view_bpmaterial.getBp()));
        json.put("material", String.valueOf(view_bpmaterial.getMaterial()));
        json.put("amount", String.valueOf(view_bpmaterial.getAmount()));
        json.put("category", String.valueOf(view_bpmaterial.getCategory()));
        json.put("typegroupid", String.valueOf(view_bpmaterial.getTypegroupid()));
        json.put("typegroupname", view_bpmaterial.getTypegroupname());
        json.put("name", view_bpmaterial.getName());
        json.put("average", view_bpmaterial.getAverage());
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    public static View_bpmaterial toView_bpmaterial(JSONObject json) {
        View_bpmaterial view_bpmaterial = new View_bpmaterial();
        view_bpmaterial.setBp(JSONConversion.getlong(json, "bp"));
        view_bpmaterial.setMaterial(JSONConversion.getlong(json, "material"));
        view_bpmaterial.setAmount(JSONConversion.getlong(json, "amount"));
        view_bpmaterial.setCategory(JSONConversion.getlong(json, "category"));
        view_bpmaterial.setTypegroupid(JSONConversion.getlong(json, "typegroupid"));
        view_bpmaterial.setTypegroupname(JSONConversion.getString(json, "typegroupname"));
        view_bpmaterial.setName(JSONConversion.getString(json, "name"));
        view_bpmaterial.setAverage(JSONConversion.getdouble(json, "average"));
        return view_bpmaterial;
    }

    /**
     * 
     * @param json: JSONObject with the View_bpmaterialsearch parameters
     * @return 
     */
    public static View_bpmaterialsearch toView_bpmaterialsearch(JSONObject json) {
        View_bpmaterialsearch view_bpmaterialsearch = new View_bpmaterialsearch();
        view_bpmaterialsearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        view_bpmaterialsearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        view_bpmaterialsearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("bp");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_bpmaterialsearch.bp(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("material");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_bpmaterialsearch.material(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("amount");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_bpmaterialsearch.amount(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("category");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_bpmaterialsearch.category(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("typegroupid");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_bpmaterialsearch.typegroupid(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("typegroupname");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_bpmaterialsearch.typegroupname(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("name");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_bpmaterialsearch.name(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("average");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_bpmaterialsearch.average(valuearray, operators, andor);
        }
        return view_bpmaterialsearch;
    }
}

