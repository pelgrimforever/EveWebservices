/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */
 
package eve.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.interfaces.db.EntityPK;
import data.interfaces.db.Fieldsearcher;
import data.json.piJson;
import eve.entity.pk.RoutetypePK;
import eve.interfaces.entity.pk.IRoutetypePK;
import eve.interfaces.logicentity.IRoutetype;
import eve.logicentity.Routetype;
import eve.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSONRoutetype {
    
    public static JSONArray toJSONArray(ArrayList routetypes) {
        JSONArray jsonroutetypes = new JSONArray();
        Iterator routetypesI = routetypes.iterator();
        while(routetypesI.hasNext()) {
            jsonroutetypes.add(toJSON((Routetype)routetypesI.next()));
        }
        return jsonroutetypes;
    }

    public static JSONObject toJSON(IRoutetypePK routetypePK) {
        JSONObject json = null;
        if(routetypePK!=null) {
            json = new JSONObject();
            json.put("id", String.valueOf(routetypePK.getId()));
        }
        return json;
    }

    public static JSONObject toJSON(IRoutetype routetype) {
        JSONObject json = new JSONObject();
        json.put("PK", toJSON(routetype.getPrimaryKey()));
        json.put("security_islandPK", JSONSecurity_island.toJSON(routetype.getSecurity_islandPK()));
        json.put("name", routetype.getName());
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    public static JSONObject toJSON(Routetypesearch routetypesearch) {
        JSONObject json = new JSONObject();
        if(routetypesearch.used()) {
            byte andoroperator = routetypesearch.getAndoroperator();
            int maxresults = routetypesearch.getMaxresults();
            boolean docount = routetypesearch.getDocount();
            Iterator<EntityPK> primarykeysI = routetypesearch.getPrimarykeys().iterator();
            Iterator<Fieldsearcher> fieldsearchersI = routetypesearch.getFieldsearchers().iterator();
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
            if(routetypesearch.getSecurity_islandsearch()!=null && routetypesearch.getSecurity_islandsearch().used()) {
                kss.put("security_islandsearcher", JSONSecurity_island.toJSON((Security_islandsearch)routetypesearch.getSecurity_islandsearch()));
            }
            json.put("keysearch", kss);
        }
        return json;
    }

    public static Routetypesearch toRoutetypesearch(JSONObject json) {
        Routetypesearch routetypesearch = new Routetypesearch();
        routetypesearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        routetypesearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        routetypesearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONArray pks = (JSONArray)json.get("primarykeys");
        for(int i=0; i<pks.size(); i++) {
            routetypesearch.addPrimarykey(RoutetypePK.getKey((String)pks.get(i)));
        }
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("id");
        if(field!=null) {
            long[] valuearray = JSONConversion.getLongvalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            routetypesearch.id(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("name");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            routetypesearch.name(valuearray, compareoperator, andor);
        }
        JSONObject kss = (JSONObject)json.get("keysearch");
        JSONArray keysearch;
        keysearch = (JSONArray)kss.get("security_islandsearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Security_islandsearch security_islandsearch = JSONSecurity_island.toSecurity_islandsearch((JSONObject)keysearch.get(i));
                routetypesearch.security_island(security_islandsearch);
            }
        }
        return routetypesearch;
    }
    
    public static RoutetypePK toRoutetypePK(JSONObject json) {
        RoutetypePK routetypePK = null;
        if(json!=null) {
            routetypePK = new RoutetypePK(JSONConversion.getlong(json, "id"));
        }
        return routetypePK;
    }

    public static Routetype toRoutetype(JSONObject json) {
        Routetype routetype = new Routetype(toRoutetypePK((JSONObject)json.get("PK")));
        updateRoutetype(routetype, json);
        return routetype;
    }

    public static void updateRoutetype(IRoutetype routetype, JSONObject json) {
        routetype.setSecurity_islandPK(JSONSecurity_island.toSecurity_islandPK((JSONObject)json.get("security_islandPK")));
        routetype.setName(JSONConversion.getString(json, "name"));
    }

    public static Routetype initRoutetype(JSONObject json) {
        Routetype routetype = new Routetype(toRoutetypePK((JSONObject)json.get("PK")));
        routetype.initSecurity_islandPK(JSONSecurity_island.toSecurity_islandPK((JSONObject)json.get("security_islandPK")));
        routetype.initName(JSONConversion.getString(json, "name"));
        return routetype;
    }
}

