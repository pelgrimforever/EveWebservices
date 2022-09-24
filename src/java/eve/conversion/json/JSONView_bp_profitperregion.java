/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */
 
package eve.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import eve.interfaces.logicview.IView_bp_profitperregion;
import eve.logicview.View_bp_profitperregion;
import eve.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSONView_bp_profitperregion {
    
    public static JSONArray toJSONArray(ArrayList view_bp_profitperregions) {
        JSONArray jsonview_bp_profitperregions = new JSONArray();
        Iterator view_bp_profitperregionsI = view_bp_profitperregions.iterator();
        while(view_bp_profitperregionsI.hasNext()) {
            jsonview_bp_profitperregions.add(JSONView_bp_profitperregion.toJSON((View_bp_profitperregion)view_bp_profitperregionsI.next()));
        }
        return jsonview_bp_profitperregions;
    }

    public static JSONObject toJSON(IView_bp_profitperregion view_bp_profitperregion) {
        JSONObject json = new JSONObject();
        json.put("categoryid", String.valueOf(view_bp_profitperregion.getCategoryid()));
        json.put("categoryname", view_bp_profitperregion.getCategoryname());
        json.put("typegroupid", String.valueOf(view_bp_profitperregion.getTypegroupid()));
        json.put("typegroupname", view_bp_profitperregion.getTypegroupname());
        json.put("id", String.valueOf(view_bp_profitperregion.getId()));
        json.put("name", view_bp_profitperregion.getName());
        json.put("estimatedproductioncost", view_bp_profitperregion.getEstimatedproductioncost());
        json.put("region", String.valueOf(view_bp_profitperregion.getRegion()));
        json.put("regionname", view_bp_profitperregion.getRegionname());
        json.put("year", view_bp_profitperregion.getYear());
        json.put("month", view_bp_profitperregion.getMonth());
        json.put("average", view_bp_profitperregion.getAverage());
        json.put("highest", view_bp_profitperregion.getHighest());
        json.put("lowest", view_bp_profitperregion.getLowest());
        json.put("volume", view_bp_profitperregion.getVolume());
        json.put("ordercount", view_bp_profitperregion.getOrdercount());
        json.put("percprofit", view_bp_profitperregion.getPercprofit());
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    public static View_bp_profitperregion toView_bp_profitperregion(JSONObject json) {
        View_bp_profitperregion view_bp_profitperregion = new View_bp_profitperregion();
        view_bp_profitperregion.setCategoryid(JSONConversion.getlong(json, "categoryid"));
        view_bp_profitperregion.setCategoryname(JSONConversion.getString(json, "categoryname"));
        view_bp_profitperregion.setTypegroupid(JSONConversion.getlong(json, "typegroupid"));
        view_bp_profitperregion.setTypegroupname(JSONConversion.getString(json, "typegroupname"));
        view_bp_profitperregion.setId(JSONConversion.getlong(json, "id"));
        view_bp_profitperregion.setName(JSONConversion.getString(json, "name"));
        view_bp_profitperregion.setEstimatedproductioncost(JSONConversion.getdouble(json, "estimatedproductioncost"));
        view_bp_profitperregion.setRegion(JSONConversion.getlong(json, "region"));
        view_bp_profitperregion.setRegionname(JSONConversion.getString(json, "regionname"));
        view_bp_profitperregion.setYear(JSONConversion.getint(json, "year"));
        view_bp_profitperregion.setMonth(JSONConversion.getint(json, "month"));
        view_bp_profitperregion.setAverage(JSONConversion.getdouble(json, "average"));
        view_bp_profitperregion.setHighest(JSONConversion.getdouble(json, "highest"));
        view_bp_profitperregion.setLowest(JSONConversion.getdouble(json, "lowest"));
        view_bp_profitperregion.setVolume(JSONConversion.getfloat(json, "volume"));
        view_bp_profitperregion.setOrdercount(JSONConversion.getfloat(json, "ordercount"));
        view_bp_profitperregion.setPercprofit(JSONConversion.getdouble(json, "percprofit"));
        return view_bp_profitperregion;
    }

    public static View_bp_profitperregionsearch toView_bp_profitperregionsearch(JSONObject json) {
        View_bp_profitperregionsearch view_bp_profitperregionsearch = new View_bp_profitperregionsearch();
        view_bp_profitperregionsearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        view_bp_profitperregionsearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        view_bp_profitperregionsearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("categoryid");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_bp_profitperregionsearch.categoryid(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("categoryname");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_bp_profitperregionsearch.categoryname(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("typegroupid");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_bp_profitperregionsearch.typegroupid(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("typegroupname");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_bp_profitperregionsearch.typegroupname(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("id");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_bp_profitperregionsearch.id(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("name");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_bp_profitperregionsearch.name(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("estimatedproductioncost");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_bp_profitperregionsearch.estimatedproductioncost(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("region");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_bp_profitperregionsearch.region(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("regionname");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_bp_profitperregionsearch.regionname(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("year");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_bp_profitperregionsearch.year(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("month");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_bp_profitperregionsearch.month(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("average");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_bp_profitperregionsearch.average(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("highest");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_bp_profitperregionsearch.highest(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("lowest");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_bp_profitperregionsearch.lowest(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("volume");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_bp_profitperregionsearch.volume(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("ordercount");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_bp_profitperregionsearch.ordercount(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("percprofit");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_bp_profitperregionsearch.percprofit(valuearray, operators, andor);
        }
        return view_bp_profitperregionsearch;
    }
}

