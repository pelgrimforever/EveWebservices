/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */
 
package eve.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import eve.interfaces.logicview.IView_contractitem;
import eve.logicview.View_contractitem;
import eve.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSONView_contractitem {
    
    public static JSONArray toJSONArray(ArrayList view_contractitems) {
        JSONArray jsonview_contractitems = new JSONArray();
        Iterator view_contractitemsI = view_contractitems.iterator();
        while(view_contractitemsI.hasNext()) {
            jsonview_contractitems.add(JSONView_contractitem.toJSON((View_contractitem)view_contractitemsI.next()));
        }
        return jsonview_contractitems;
    }

    public static JSONObject toJSON(IView_contractitem view_contractitem) {
        JSONObject json = new JSONObject();
        json.put("id", String.valueOf(view_contractitem.getId()));
        json.put("contract", String.valueOf(view_contractitem.getContract()));
        json.put("blueprint_copy", view_contractitem.getBlueprint_copy());
        json.put("included", view_contractitem.getIncluded());
        json.put("quantity", String.valueOf(view_contractitem.getQuantity()));
        json.put("evetype", String.valueOf(view_contractitem.getEvetype()));
        json.put("material_efficiency", view_contractitem.getMaterial_efficiency());
        json.put("runs", view_contractitem.getRuns());
        json.put("time_efficiency", view_contractitem.getTime_efficiency());
        json.put("packaged_volume", view_contractitem.getPackaged_volume());
        json.put("typename", view_contractitem.getTypename());
        json.put("typegroupid", String.valueOf(view_contractitem.getTypegroupid()));
        json.put("groupname", view_contractitem.getGroupname());
        json.put("categoryid", String.valueOf(view_contractitem.getCategoryid()));
        json.put("categoryname", view_contractitem.getCategoryname());
        json.put("avg_buyorder", view_contractitem.getAvg_buyorder());
        json.put("min_buyorder", view_contractitem.getMin_buyorder());
        json.put("max_buyorder", view_contractitem.getMax_buyorder());
        json.put("avg_sellorder", view_contractitem.getAvg_sellorder());
        json.put("min_selorder", view_contractitem.getMin_selorder());
        json.put("max_selorder", view_contractitem.getMax_selorder());
        json.put("average", view_contractitem.getAverage());
        json.put("highest", view_contractitem.getHighest());
        json.put("lowest", view_contractitem.getLowest());
        json.put("order_count", String.valueOf(view_contractitem.getOrder_count()));
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    public static View_contractitem toView_contractitem(JSONObject json) {
        View_contractitem view_contractitem = new View_contractitem();
        view_contractitem.setId(JSONConversion.getlong(json, "id"));
        view_contractitem.setContract(JSONConversion.getlong(json, "contract"));
        view_contractitem.setBlueprint_copy(JSONConversion.getboolean(json, "blueprint_copy"));
        view_contractitem.setIncluded(JSONConversion.getboolean(json, "included"));
        view_contractitem.setQuantity(JSONConversion.getlong(json, "quantity"));
        view_contractitem.setEvetype(JSONConversion.getlong(json, "evetype"));
        view_contractitem.setMaterial_efficiency(JSONConversion.getint(json, "material_efficiency"));
        view_contractitem.setRuns(JSONConversion.getint(json, "runs"));
        view_contractitem.setTime_efficiency(JSONConversion.getint(json, "time_efficiency"));
        view_contractitem.setPackaged_volume(JSONConversion.getdouble(json, "packaged_volume"));
        view_contractitem.setTypename(JSONConversion.getString(json, "typename"));
        view_contractitem.setTypegroupid(JSONConversion.getlong(json, "typegroupid"));
        view_contractitem.setGroupname(JSONConversion.getString(json, "groupname"));
        view_contractitem.setCategoryid(JSONConversion.getlong(json, "categoryid"));
        view_contractitem.setCategoryname(JSONConversion.getString(json, "categoryname"));
        view_contractitem.setAvg_buyorder(JSONConversion.getdouble(json, "avg_buyorder"));
        view_contractitem.setMin_buyorder(JSONConversion.getdouble(json, "min_buyorder"));
        view_contractitem.setMax_buyorder(JSONConversion.getdouble(json, "max_buyorder"));
        view_contractitem.setAvg_sellorder(JSONConversion.getdouble(json, "avg_sellorder"));
        view_contractitem.setMin_selorder(JSONConversion.getdouble(json, "min_selorder"));
        view_contractitem.setMax_selorder(JSONConversion.getdouble(json, "max_selorder"));
        view_contractitem.setAverage(JSONConversion.getdouble(json, "average"));
        view_contractitem.setHighest(JSONConversion.getdouble(json, "highest"));
        view_contractitem.setLowest(JSONConversion.getdouble(json, "lowest"));
        view_contractitem.setOrder_count(JSONConversion.getlong(json, "order_count"));
        return view_contractitem;
    }

    public static View_contractitemsearch toView_contractitemsearch(JSONObject json) {
        View_contractitemsearch view_contractitemsearch = new View_contractitemsearch();
        view_contractitemsearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        view_contractitemsearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        view_contractitemsearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("id");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_contractitemsearch.id(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("contract");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_contractitemsearch.contract(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("blueprint_copy");
        if(field!=null) {
            boolean value = JSONConversion.getBooleanvalue(field);
            view_contractitemsearch.blueprint_copy(value);
        }
        field = (JSONObject)fss.get("included");
        if(field!=null) {
            boolean value = JSONConversion.getBooleanvalue(field);
            view_contractitemsearch.included(value);
        }
        field = (JSONObject)fss.get("quantity");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_contractitemsearch.quantity(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("evetype");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_contractitemsearch.evetype(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("material_efficiency");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_contractitemsearch.material_efficiency(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("runs");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_contractitemsearch.runs(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("time_efficiency");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_contractitemsearch.time_efficiency(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("packaged_volume");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_contractitemsearch.packaged_volume(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("typename");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_contractitemsearch.typename(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("typegroupid");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_contractitemsearch.typegroupid(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("groupname");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_contractitemsearch.groupname(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("categoryid");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_contractitemsearch.categoryid(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("categoryname");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_contractitemsearch.categoryname(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("avg_buyorder");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_contractitemsearch.avg_buyorder(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("min_buyorder");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_contractitemsearch.min_buyorder(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("max_buyorder");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_contractitemsearch.max_buyorder(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("avg_sellorder");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_contractitemsearch.avg_sellorder(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("min_selorder");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_contractitemsearch.min_selorder(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("max_selorder");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_contractitemsearch.max_selorder(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("average");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_contractitemsearch.average(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("highest");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_contractitemsearch.highest(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("lowest");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_contractitemsearch.lowest(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("order_count");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_contractitemsearch.order_count(valuearray, operators, andor);
        }
        return view_contractitemsearch;
    }
}

