/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 13.6.2022 11:21
 */
 
package eve.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import eve.interfaces.logicview.IView_wishlist;
import eve.logicview.View_wishlist;
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
public class JSONView_wishlist {
    
    public static JSONArray toJSONArray(ArrayList view_wishlists) {
        JSONArray jsonview_wishlists = new JSONArray();
        Iterator view_wishlistsI = view_wishlists.iterator();
        while(view_wishlistsI.hasNext()) {
            jsonview_wishlists.add(JSONView_wishlist.toJSON((View_wishlist)view_wishlistsI.next()));
        }
        return jsonview_wishlists;
    }

    public static JSONObject toJSON(IView_wishlist view_wishlist) {
        JSONObject json = new JSONObject();
        json.put("username", view_wishlist.getUsername());
        json.put("maxprice", view_wishlist.getMaxprice());
        json.put("id", String.valueOf(view_wishlist.getId()));
        json.put("name", view_wishlist.getName());
        json.put("typegroup", String.valueOf(view_wishlist.getTypegroup()));
        json.put("published", view_wishlist.getPublished());
        json.put("description", view_wishlist.getDescription());
        json.put("capacity", view_wishlist.getCapacity());
        json.put("graphic", String.valueOf(view_wishlist.getGraphic()));
        json.put("icon", String.valueOf(view_wishlist.getIcon()));
        json.put("market_group", String.valueOf(view_wishlist.getMarket_group()));
        json.put("mass", view_wishlist.getMass());
        json.put("packaged_volume", view_wishlist.getPackaged_volume());
        json.put("portion_size", view_wishlist.getPortion_size());
        json.put("radius", view_wishlist.getRadius());
        json.put("volume", view_wishlist.getVolume());
        json.put("avg_buyorder", view_wishlist.getAvg_buyorder());
        json.put("avg_sellorder", view_wishlist.getAvg_sellorder());
        json.put("min_buyorder", view_wishlist.getMin_buyorder());
        json.put("max_buyorder", view_wishlist.getMax_buyorder());
        json.put("min_selorder", view_wishlist.getMin_selorder());
        json.put("max_selorder", view_wishlist.getMax_selorder());
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    public static View_wishlist toView_wishlist(JSONObject json) {
        View_wishlist view_wishlist = new View_wishlist();
        view_wishlist.setUsername(JSONConversion.getString(json, "username"));
        view_wishlist.setMaxprice(JSONConversion.getdouble(json, "maxprice"));
        view_wishlist.setId(JSONConversion.getlong(json, "id"));
        view_wishlist.setName(JSONConversion.getString(json, "name"));
        view_wishlist.setTypegroup(JSONConversion.getlong(json, "typegroup"));
        view_wishlist.setPublished(JSONConversion.getboolean(json, "published"));
        view_wishlist.setDescription(JSONConversion.getString(json, "description"));
        view_wishlist.setCapacity(JSONConversion.getdouble(json, "capacity"));
        view_wishlist.setGraphic(JSONConversion.getlong(json, "graphic"));
        view_wishlist.setIcon(JSONConversion.getlong(json, "icon"));
        view_wishlist.setMarket_group(JSONConversion.getlong(json, "market_group"));
        view_wishlist.setMass(JSONConversion.getdouble(json, "mass"));
        view_wishlist.setPackaged_volume(JSONConversion.getdouble(json, "packaged_volume"));
        view_wishlist.setPortion_size(JSONConversion.getint(json, "portion_size"));
        view_wishlist.setRadius(JSONConversion.getdouble(json, "radius"));
        view_wishlist.setVolume(JSONConversion.getdouble(json, "volume"));
        view_wishlist.setAvg_buyorder(JSONConversion.getdouble(json, "avg_buyorder"));
        view_wishlist.setAvg_sellorder(JSONConversion.getdouble(json, "avg_sellorder"));
        view_wishlist.setMin_buyorder(JSONConversion.getdouble(json, "min_buyorder"));
        view_wishlist.setMax_buyorder(JSONConversion.getdouble(json, "max_buyorder"));
        view_wishlist.setMin_selorder(JSONConversion.getdouble(json, "min_selorder"));
        view_wishlist.setMax_selorder(JSONConversion.getdouble(json, "max_selorder"));
        return view_wishlist;
    }

    public static View_wishlistsearch toView_wishlistsearch(JSONObject json) {
        View_wishlistsearch view_wishlistsearch = new View_wishlistsearch();
        view_wishlistsearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        view_wishlistsearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        view_wishlistsearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("username");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_wishlistsearch.username(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("maxprice");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_wishlistsearch.maxprice(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("id");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_wishlistsearch.id(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("name");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_wishlistsearch.name(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("typegroup");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_wishlistsearch.typegroup(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("published");
        if(field!=null) {
            boolean value = JSONConversion.getBooleanvalue(field);
            view_wishlistsearch.published(value);
        }
        field = (JSONObject)fss.get("description");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_wishlistsearch.description(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("capacity");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_wishlistsearch.capacity(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("graphic");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_wishlistsearch.graphic(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("icon");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_wishlistsearch.icon(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("market_group");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_wishlistsearch.market_group(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("mass");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_wishlistsearch.mass(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("packaged_volume");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_wishlistsearch.packaged_volume(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("portion_size");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_wishlistsearch.portion_size(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("radius");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_wishlistsearch.radius(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("volume");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_wishlistsearch.volume(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("avg_buyorder");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_wishlistsearch.avg_buyorder(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("avg_sellorder");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_wishlistsearch.avg_sellorder(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("min_buyorder");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_wishlistsearch.min_buyorder(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("max_buyorder");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_wishlistsearch.max_buyorder(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("min_selorder");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_wishlistsearch.min_selorder(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("max_selorder");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_wishlistsearch.max_selorder(valuearray, operators, andor);
        }
        return view_wishlistsearch;
    }
}

