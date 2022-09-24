/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */
 
package eve.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import eve.interfaces.logicview.IView_system;
import eve.logicview.View_system;
import eve.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSONView_system {
    
    public static JSONArray toJSONArray(ArrayList view_systems) {
        JSONArray jsonview_systems = new JSONArray();
        Iterator view_systemsI = view_systems.iterator();
        while(view_systemsI.hasNext()) {
            jsonview_systems.add(JSONView_system.toJSON((View_system)view_systemsI.next()));
        }
        return jsonview_systems;
    }

    public static JSONObject toJSON(IView_system view_system) {
        JSONObject json = new JSONObject();
        json.put("jumpssafe", view_system.getJumpssafe());
        json.put("jumpssafelowsec", view_system.getJumpssafelowsec());
        json.put("jumpssafenullsec", view_system.getJumpssafenullsec());
        json.put("regionname", view_system.getRegionname());
        json.put("system_start", String.valueOf(view_system.getSystem_start()));
        json.put("system_end", String.valueOf(view_system.getSystem_end()));
        json.put("id", String.valueOf(view_system.getId()));
        json.put("name", view_system.getName());
        json.put("constellation", String.valueOf(view_system.getConstellation()));
        json.put("security_class", view_system.getSecurity_class());
        json.put("security_status", view_system.getSecurity_status());
        json.put("star_id", String.valueOf(view_system.getStar_id()));
        json.put("noaccess", view_system.getNoaccess());
        json.put("isconstellationborder", view_system.getIsconstellationborder());
        json.put("isregionborder", view_system.getIsregionborder());
        json.put("security_island", String.valueOf(view_system.getSecurity_island()));
        if(view_system.getDownloaddate()!=null) {
	        json.put("downloaddate", view_system.getDownloaddate().getTime());
        }
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    public static View_system toView_system(JSONObject json) {
        View_system view_system = new View_system();
        view_system.setJumpssafe(JSONConversion.getint(json, "jumpssafe"));
        view_system.setJumpssafelowsec(JSONConversion.getint(json, "jumpssafelowsec"));
        view_system.setJumpssafenullsec(JSONConversion.getint(json, "jumpssafenullsec"));
        view_system.setRegionname(JSONConversion.getString(json, "regionname"));
        view_system.setSystem_start(JSONConversion.getlong(json, "system_start"));
        view_system.setSystem_end(JSONConversion.getlong(json, "system_end"));
        view_system.setId(JSONConversion.getlong(json, "id"));
        view_system.setName(JSONConversion.getString(json, "name"));
        view_system.setConstellation(JSONConversion.getlong(json, "constellation"));
        view_system.setSecurity_class(JSONConversion.getString(json, "security_class"));
        view_system.setSecurity_status(JSONConversion.getdouble(json, "security_status"));
        view_system.setStar_id(JSONConversion.getlong(json, "star_id"));
        view_system.setNoaccess(JSONConversion.getboolean(json, "noaccess"));
        view_system.setIsconstellationborder(JSONConversion.getboolean(json, "isconstellationborder"));
        view_system.setIsregionborder(JSONConversion.getboolean(json, "isregionborder"));
        view_system.setSecurity_island(JSONConversion.getlong(json, "security_island"));
        view_system.setDownloaddate(JSONConversion.getDate(json, "downloaddate"));
        return view_system;
    }

    public static View_systemsearch toView_systemsearch(JSONObject json) {
        View_systemsearch view_systemsearch = new View_systemsearch();
        view_systemsearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        view_systemsearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        view_systemsearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("jumpssafe");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_systemsearch.jumpssafe(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("jumpssafelowsec");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_systemsearch.jumpssafelowsec(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("jumpssafenullsec");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_systemsearch.jumpssafenullsec(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("regionname");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_systemsearch.regionname(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("system_start");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_systemsearch.system_start(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("system_end");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_systemsearch.system_end(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("id");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_systemsearch.id(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("name");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_systemsearch.name(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("constellation");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_systemsearch.constellation(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("security_class");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_systemsearch.security_class(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("security_status");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_systemsearch.security_status(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("star_id");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_systemsearch.star_id(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("noaccess");
        if(field!=null) {
            boolean value = JSONConversion.getBooleanvalue(field);
            view_systemsearch.noaccess(value);
        }
        field = (JSONObject)fss.get("isconstellationborder");
        if(field!=null) {
            boolean value = JSONConversion.getBooleanvalue(field);
            view_systemsearch.isconstellationborder(value);
        }
        field = (JSONObject)fss.get("isregionborder");
        if(field!=null) {
            boolean value = JSONConversion.getBooleanvalue(field);
            view_systemsearch.isregionborder(value);
        }
        field = (JSONObject)fss.get("security_island");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_systemsearch.security_island(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("downloaddate");
        if(field!=null) {
            Date[] valuearray = JSONConversion.getDatevalues(field);
            byte[] operators = JSONConversion.getDateoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_systemsearch.downloaddate(valuearray, operators, andor);
        }
        return view_systemsearch;
    }
}

