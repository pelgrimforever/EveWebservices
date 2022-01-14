/*
 * JSONMarket_group.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 8.0.2022 19:32
 *
 */
 
package eve.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.interfaces.db.EntityPK;
import data.interfaces.db.Fieldsearcher;
import data.json.piJson;
import eve.entity.pk.Market_groupPK;
import eve.interfaces.entity.pk.IMarket_groupPK;
import eve.interfaces.logicentity.IMarket_group;
import eve.logicentity.Market_group;
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
public class JSONMarket_group {
    
    public static JSONArray toJSONArray(ArrayList market_groups) {
        JSONArray jsonmarket_groups = new JSONArray();
        Iterator market_groupsI = market_groups.iterator();
        while(market_groupsI.hasNext()) {
            jsonmarket_groups.add(toJSON((Market_group)market_groupsI.next()));
        }
        return jsonmarket_groups;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(IMarket_groupPK market_groupPK) {
        JSONObject json = null;
        if(market_groupPK!=null) {
            json = new JSONObject();
            json.put("id", String.valueOf(market_groupPK.getId()));
        }
        return json;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(IMarket_group market_group) {
        JSONObject json = new JSONObject();
        json.put("PK", toJSON(market_group.getPrimaryKey()));
        json.put("market_groupParent_idPK", JSONMarket_group.toJSON(market_group.getMarket_groupparent_idPK()));
        json.put("name", market_group.getName());
        json.put("description", market_group.getDescription());
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(Market_groupsearch market_groupsearch) {
        JSONObject json = new JSONObject();
        if(market_groupsearch.used()) {
            byte andoroperator = market_groupsearch.getAndoroperator();
            int maxresults = market_groupsearch.getMaxresults();
            boolean docount = market_groupsearch.getDocount();
            Iterator<EntityPK> primarykeysI = market_groupsearch.getPrimarykeys().iterator();
            Iterator<Fieldsearcher> fieldsearchersI = market_groupsearch.getFieldsearchers().iterator();
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
            if(market_groupsearch.getMarket_groupparent_idsearch()!=null && market_groupsearch.getMarket_groupparent_idsearch().used()) {
                kss.put("market_groupParent_idsearcher", JSONMarket_group.toJSON((Market_groupsearch)market_groupsearch.getMarket_groupparent_idsearch()));
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
    public static Market_groupsearch toMarket_groupsearch(JSONObject json) {
        Market_groupsearch market_groupsearch = new Market_groupsearch();
        market_groupsearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        market_groupsearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        market_groupsearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONArray pks = (JSONArray)json.get("primarykeys");
        for(int i=0; i<pks.size(); i++) {
            market_groupsearch.addPrimarykey(Market_groupPK.getKey((String)pks.get(i)));
        }
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("id");
        if(field!=null) {
            long[] valuearray = JSONConversion.getLongvalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            market_groupsearch.id(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("name");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            market_groupsearch.name(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("description");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            market_groupsearch.description(valuearray, compareoperator, andor);
        }
        JSONObject kss = (JSONObject)json.get("keysearch");
        JSONArray keysearch;
        keysearch = (JSONArray)kss.get("market_groupParent_idsearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Market_groupsearch market_groupParent_idsearch = JSONMarket_group.toMarket_groupsearch((JSONObject)keysearch.get(i));
                market_groupsearch.market_groupParent_id(market_groupParent_idsearch);
            }
        }
        return market_groupsearch;
    }
    
    public static Market_groupPK toMarket_groupPK(JSONObject json) {
        Market_groupPK market_groupPK = null;
        if(json!=null) {
            market_groupPK = new Market_groupPK(JSONConversion.getlong(json, "id"));
        }
        return market_groupPK;
    }

    public static Market_group toMarket_group(JSONObject json) {
        Market_group market_group = new Market_group(toMarket_groupPK((JSONObject)json.get("PK")));
        updateMarket_group(market_group, json);
        return market_group;
    }

    public static void updateMarket_group(IMarket_group market_group, JSONObject json) {
        market_group.setMarket_groupparent_idPK(JSONMarket_group.toMarket_groupPK((JSONObject)json.get("market_groupParent_idPK")));
        market_group.setName(JSONConversion.getString(json, "name"));
        market_group.setDescription(JSONConversion.getString(json, "description"));
    }

    public static Market_group initMarket_group(JSONObject json) {
        Market_group market_group = new Market_group(toMarket_groupPK((JSONObject)json.get("PK")));
        market_group.initMarket_groupparent_idPK(JSONMarket_group.toMarket_groupPK((JSONObject)json.get("market_groupParent_idPK")));
        market_group.initName(JSONConversion.getString(json, "name"));
        market_group.initDescription(JSONConversion.getString(json, "description"));
        return market_group;
    }
}

