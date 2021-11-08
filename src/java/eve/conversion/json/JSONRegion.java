/*
 * JSONRegion.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 8.10.2021 7:21
 *
 */
 
package eve.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.interfaces.db.EntityPK;
import data.interfaces.db.Fieldsearcher;
import data.json.piJson;
import eve.entity.pk.RegionPK;
import eve.interfaces.entity.pk.IRegionPK;
import eve.interfaces.logicentity.IRegion;
import eve.logicentity.Region;
import eve.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * JSON fields are by default ignored
 * @author Franky Laseure
 */
public class JSONRegion {
    
    public static JSONArray toJSONArray(ArrayList regions) {
        JSONArray jsonregions = new JSONArray();
        Iterator regionsI = regions.iterator();
        while(regionsI.hasNext()) {
            jsonregions.add(toJSON((Region)regionsI.next()));
        }
        return jsonregions;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(IRegionPK regionPK) {
        JSONObject json = null;
        if(regionPK!=null) {
            json = new JSONObject();
            json.put("id", String.valueOf(regionPK.getId()));
        }
        return json;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(IRegion region) {
        JSONObject json = new JSONObject();
        json.put("PK", toJSON(region.getPrimaryKey()));
        json.put("name", region.getName());
        json.put("noaccess", region.getNoaccess());
        json.put("orderpages", region.getOrderpages());
        json.put("ordererrors", region.getOrdererrors());
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(Regionsearch regionsearch) {
        JSONObject json = new JSONObject();
        if(regionsearch.used()) {
            byte andoroperator = regionsearch.getAndoroperator();
            int maxresults = regionsearch.getMaxresults();
            boolean docount = regionsearch.getDocount();
            Iterator<EntityPK> primarykeysI = regionsearch.getPrimarykeys().iterator();
            Iterator<Fieldsearcher> fieldsearchersI = regionsearch.getFieldsearchers().iterator();
            EntityPK primarykey;
            Fieldsearcher fieldsearcher;
            
            json.put("andor", andoroperator);
            json.put("maxresults", maxresults);
            json.put("docount", docount);
            JSONArray pks = new JSONArray();
            int i = 0;
            while(primarykeysI.hasNext()) {
                primarykey = primarykeysI.next();
                pks.add(primarykey.getKeystring());
            }
            json.put("primarykeys", pks);
            JSONObject fss = new JSONObject();
            while(fieldsearchersI.hasNext()) {
                fieldsearcher = fieldsearchersI.next();
                if(fieldsearcher.used()) {
                    fss.put(fieldsearcher.getShortFieldname(), JSONConversion.toJSON(fieldsearcher));
                }
            }
            json.put("fields", fss);
            JSONObject kss = new JSONObject();
            if(regionsearch.getOrder_historysearch()!=null && regionsearch.getOrder_historysearch().used()) {
                kss.put("order_historysearcher", JSONOrder_history.toJSON((Order_historysearch)regionsearch.getOrder_historysearch()));
            }
            if(regionsearch.getEvetypesearch()!=null && regionsearch.getEvetypesearch().used()) {
                kss.put("evetypesearcher", JSONOrder_history.toJSON((Order_historysearch)regionsearch.getEvetypesearch()));
            }
            if(regionsearch.getRegion_neighbourregionsearch()!=null && regionsearch.getRegion_neighbourregionsearch().used()) {
                kss.put("region_neighbourRegionsearcher", JSONRegion_neighbour.toJSON((Region_neighboursearch)regionsearch.getRegion_neighbourregionsearch()));
            }
            if(regionsearch.getRegion_neighbourneighboursearch()!=null && regionsearch.getRegion_neighbourneighboursearch().used()) {
                kss.put("region_neighbourNeighboursearcher", JSONRegion_neighbour.toJSON((Region_neighboursearch)regionsearch.getRegion_neighbourneighboursearch()));
            }
            json.put("keysearch", kss);
        }
        return json;
    }

    /**
     * 
     * @param json: JSONObject with the Filmsearch parameters
     * @return 
     */
    public static Regionsearch toRegionsearch(JSONObject json) {
        Regionsearch regionsearch = new Regionsearch();
        regionsearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        regionsearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        regionsearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONArray pks = (JSONArray)json.get("primarykeys");
        for(int i=0; i<pks.size(); i++) {
            regionsearch.addPrimarykey(RegionPK.getKey((String)pks.get(i)));
        }
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("id");
        if(field!=null) {
            long[] valuearray = JSONConversion.getLongvalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            regionsearch.id(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("name");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            regionsearch.name(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("noaccess");
        if(field!=null) {
            boolean value = JSONConversion.getBooleanvalue(field);
            regionsearch.noaccess(value);
        }
        field = (JSONObject)fss.get("orderpages");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            regionsearch.orderpages(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("ordererrors");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            regionsearch.ordererrors(valuearray, operators, andor);
        }
        JSONObject kss = (JSONObject)json.get("keysearch");
        JSONArray keysearch;
        keysearch = (JSONArray)kss.get("order_historysearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Order_historysearch order_historysearch = JSONOrder_history.toOrder_historysearch((JSONObject)keysearch.get(i));
                regionsearch.order_history(order_historysearch);
            }
        }
        keysearch = (JSONArray)kss.get("evetypesearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Evetypesearch evetypesearch = JSONEvetype.toEvetypesearch((JSONObject)keysearch.get(i));
                regionsearch.evetype(evetypesearch);
            }
        }
        keysearch = (JSONArray)kss.get("region_neighbourRegionsearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Region_neighboursearch region_neighbourRegionsearch = JSONRegion_neighbour.toRegion_neighboursearch((JSONObject)keysearch.get(i));
                regionsearch.region_neighbourRegion(region_neighbourRegionsearch);
            }
        }
        keysearch = (JSONArray)kss.get("region_neighbourNeighboursearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Region_neighboursearch region_neighbourNeighboursearch = JSONRegion_neighbour.toRegion_neighboursearch((JSONObject)keysearch.get(i));
                regionsearch.region_neighbourNeighbour(region_neighbourNeighboursearch);
            }
        }
        return regionsearch;
    }
    
    public static RegionPK toRegionPK(JSONObject json) {
        RegionPK regionPK = null;
        if(json!=null) {
            regionPK = new RegionPK(JSONConversion.getlong(json, "id"));
        }
        return regionPK;
    }

    public static Region toRegion(JSONObject json) {
        Region region = new Region(toRegionPK((JSONObject)json.get("PK")));
        updateRegion(region, json);
        return region;
    }

    public static void updateRegion(IRegion region, JSONObject json) {
        region.setName(JSONConversion.getString(json, "name"));
        region.setNoaccess(JSONConversion.getboolean(json, "noaccess"));
        region.setOrderpages(JSONConversion.getint(json, "orderpages"));
        region.setOrdererrors(JSONConversion.getint(json, "ordererrors"));
    }

    public static Region initRegion(JSONObject json) {
        Region region = new Region(toRegionPK((JSONObject)json.get("PK")));
        region.initName(JSONConversion.getString(json, "name"));
        region.initNoaccess(JSONConversion.getboolean(json, "noaccess"));
        region.initOrderpages(JSONConversion.getint(json, "orderpages"));
        region.initOrdererrors(JSONConversion.getint(json, "ordererrors"));
        return region;
    }
}

