/*
 * JSONSystem.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 25.9.2021 15:16
 *
 */
 
package eve.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.interfaces.db.EntityPK;
import data.interfaces.db.Fieldsearcher;
import data.json.piJson;
import eve.entity.pk.SystemPK;
import eve.interfaces.entity.pk.ISystemPK;
import eve.interfaces.logicentity.ISystem;
import eve.logicentity.System;
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
public class JSONSystem {
    
    public static JSONArray toJSONArray(ArrayList systems) {
        JSONArray jsonsystems = new JSONArray();
        Iterator systemsI = systems.iterator();
        while(systemsI.hasNext()) {
            jsonsystems.add(toJSON((System)systemsI.next()));
        }
        return jsonsystems;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(ISystemPK systemPK) {
        JSONObject json = null;
        if(systemPK!=null) {
            json = new JSONObject();
            json.put("id", String.valueOf(systemPK.getId()));
        }
        return json;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(ISystem system) {
        JSONObject json = new JSONObject();
        json.put("PK", toJSON(system.getPrimaryKey()));
        json.put("security_islandPK", JSONSecurity_island.toJSON(system.getSecurity_islandPK()));
        json.put("constellationPK", JSONConstellation.toJSON(system.getConstellationPK()));
        json.put("name", system.getName());
        json.put("security_class", system.getSecurity_class());
        json.put("security_status", system.getSecurity_status());
        json.put("star_id", String.valueOf(system.getStar_id()));
        json.put("noaccess", system.getNoaccess());
        json.put("isconstellationborder", system.getIsconstellationborder());
        json.put("isregionborder", system.getIsregionborder());
//Custom code, do not change this line
        json.put("npc_kills", system.getNpc_kills());
        json.put("pod_kills", system.getPod_kills());
        json.put("ship_kills", system.getShip_kills());
        json.put("killmailcount", system.getKillmailcount());
        json.put("killmailgatecount", system.getKillmailgatecount());
        json.put("killmaildata", system.getKillmaildata());
//Custom code, do not change this line
        return json;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(Systemsearch systemsearch) {
        JSONObject json = new JSONObject();
        if(systemsearch.used()) {
            byte andoroperator = systemsearch.getAndoroperator();
            int maxresults = systemsearch.getMaxresults();
            boolean docount = systemsearch.getDocount();
            Iterator<EntityPK> primarykeysI = systemsearch.getPrimarykeys().iterator();
            Iterator<Fieldsearcher> fieldsearchersI = systemsearch.getFieldsearchers().iterator();
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
            if(systemsearch.getSecurity_islandsearch()!=null && systemsearch.getSecurity_islandsearch().used()) {
                kss.put("security_islandsearcher", JSONSecurity_island.toJSON((Security_islandsearch)systemsearch.getSecurity_islandsearch()));
            }
            if(systemsearch.getConstellationsearch()!=null && systemsearch.getConstellationsearch().used()) {
                kss.put("constellationsearcher", JSONConstellation.toJSON((Constellationsearch)systemsearch.getConstellationsearch()));
            }
            if(systemsearch.getSystemjumpssystem_endsearch()!=null && systemsearch.getSystemjumpssystem_endsearch().used()) {
                kss.put("systemjumpsSystem_endsearcher", JSONSystemjumps.toJSON((Systemjumpssearch)systemsearch.getSystemjumpssystem_endsearch()));
            }
            if(systemsearch.getSystemjumpssystem_startsearch()!=null && systemsearch.getSystemjumpssystem_startsearch().used()) {
                kss.put("systemjumpsSystem_startsearcher", JSONSystemjumps.toJSON((Systemjumpssearch)systemsearch.getSystemjumpssystem_startsearch()));
            }
            if(systemsearch.getRoutesearch()!=null && systemsearch.getRoutesearch().used()) {
                kss.put("routesearcher", JSONRoute.toJSON((Routesearch)systemsearch.getRoutesearch()));
            }
            if(systemsearch.getRoutetypesearch()!=null && systemsearch.getRoutetypesearch().used()) {
                kss.put("routetypesearcher", JSONRoute.toJSON((Routesearch)systemsearch.getRoutetypesearch()));
            }
            if(systemsearch.getSystemtradesell_systemsearch()!=null && systemsearch.getSystemtradesell_systemsearch().used()) {
                kss.put("systemtradeSell_systemsearcher", JSONSystemtrade.toJSON((Systemtradesearch)systemsearch.getSystemtradesell_systemsearch()));
            }
            if(systemsearch.getSystemtradebuy_systemsearch()!=null && systemsearch.getSystemtradebuy_systemsearch().used()) {
                kss.put("systemtradeBuy_systemsearcher", JSONSystemtrade.toJSON((Systemtradesearch)systemsearch.getSystemtradebuy_systemsearch()));
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
    public static Systemsearch toSystemsearch(JSONObject json) {
        Systemsearch systemsearch = new Systemsearch();
        systemsearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        systemsearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        systemsearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONArray pks = (JSONArray)json.get("primarykeys");
        for(int i=0; i<pks.size(); i++) {
            systemsearch.addPrimarykey(SystemPK.getKey((String)pks.get(i)));
        }
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("id");
        if(field!=null) {
            long[] valuearray = JSONConversion.getLongvalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            systemsearch.id(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("name");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            systemsearch.name(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("security_class");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            systemsearch.security_class(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("security_status");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            systemsearch.security_status(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("star_id");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            systemsearch.star_id(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("noaccess");
        if(field!=null) {
            boolean value = JSONConversion.getBooleanvalue(field);
            systemsearch.noaccess(value);
        }
        field = (JSONObject)fss.get("isconstellationborder");
        if(field!=null) {
            boolean value = JSONConversion.getBooleanvalue(field);
            systemsearch.isconstellationborder(value);
        }
        field = (JSONObject)fss.get("isregionborder");
        if(field!=null) {
            boolean value = JSONConversion.getBooleanvalue(field);
            systemsearch.isregionborder(value);
        }
        JSONObject kss = (JSONObject)json.get("keysearch");
        JSONArray keysearch;
        keysearch = (JSONArray)kss.get("security_islandsearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Security_islandsearch security_islandsearch = JSONSecurity_island.toSecurity_islandsearch((JSONObject)keysearch.get(i));
                systemsearch.security_island(security_islandsearch);
            }
        }
        keysearch = (JSONArray)kss.get("constellationsearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Constellationsearch constellationsearch = JSONConstellation.toConstellationsearch((JSONObject)keysearch.get(i));
                systemsearch.constellation(constellationsearch);
            }
        }
        keysearch = (JSONArray)kss.get("systemjumpsSystem_endsearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Systemjumpssearch systemjumpsSystem_endsearch = JSONSystemjumps.toSystemjumpssearch((JSONObject)keysearch.get(i));
                systemsearch.systemjumpsSystem_end(systemjumpsSystem_endsearch);
            }
        }
        keysearch = (JSONArray)kss.get("systemjumpsSystem_startsearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Systemjumpssearch systemjumpsSystem_startsearch = JSONSystemjumps.toSystemjumpssearch((JSONObject)keysearch.get(i));
                systemsearch.systemjumpsSystem_start(systemjumpsSystem_startsearch);
            }
        }
        keysearch = (JSONArray)kss.get("routesearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Routesearch routesearch = JSONRoute.toRoutesearch((JSONObject)keysearch.get(i));
                systemsearch.route(routesearch);
            }
        }
        keysearch = (JSONArray)kss.get("routetypesearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Routetypesearch routetypesearch = JSONRoutetype.toRoutetypesearch((JSONObject)keysearch.get(i));
                systemsearch.routetype(routetypesearch);
            }
        }
        keysearch = (JSONArray)kss.get("systemtradeSell_systemsearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Systemtradesearch systemtradeSell_systemsearch = JSONSystemtrade.toSystemtradesearch((JSONObject)keysearch.get(i));
                systemsearch.systemtradeSell_system(systemtradeSell_systemsearch);
            }
        }
        keysearch = (JSONArray)kss.get("systemtradeBuy_systemsearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Systemtradesearch systemtradeBuy_systemsearch = JSONSystemtrade.toSystemtradesearch((JSONObject)keysearch.get(i));
                systemsearch.systemtradeBuy_system(systemtradeBuy_systemsearch);
            }
        }
        return systemsearch;
    }
    
    public static SystemPK toSystemPK(JSONObject json) {
        SystemPK systemPK = null;
        if(json!=null) {
            systemPK = new SystemPK(JSONConversion.getlong(json, "id"));
        }
        return systemPK;
    }

    public static System toSystem(JSONObject json) {
        System system = new System(toSystemPK((JSONObject)json.get("PK")));
        updateSystem(system, json);
        return system;
    }

    public static void updateSystem(ISystem system, JSONObject json) {
        system.setSecurity_islandPK(JSONSecurity_island.toSecurity_islandPK((JSONObject)json.get("security_islandPK")));
        system.setConstellationPK(JSONConstellation.toConstellationPK((JSONObject)json.get("constellationPK")));
        system.setName(JSONConversion.getString(json, "name"));
        system.setSecurity_class(JSONConversion.getString(json, "security_class"));
        system.setSecurity_status(JSONConversion.getdouble(json, "security_status"));
        system.setStar_id(JSONConversion.getlong(json, "star_id"));
        system.setNoaccess(JSONConversion.getboolean(json, "noaccess"));
        system.setIsconstellationborder(JSONConversion.getboolean(json, "isconstellationborder"));
        system.setIsregionborder(JSONConversion.getboolean(json, "isregionborder"));
    }

    public static System initSystem(JSONObject json) {
        System system = new System(toSystemPK((JSONObject)json.get("PK")));
        system.initSecurity_islandPK(JSONSecurity_island.toSecurity_islandPK((JSONObject)json.get("security_islandPK")));
        system.initConstellationPK(JSONConstellation.toConstellationPK((JSONObject)json.get("constellationPK")));
        system.initName(JSONConversion.getString(json, "name"));
        system.initSecurity_class(JSONConversion.getString(json, "security_class"));
        system.initSecurity_status(JSONConversion.getdouble(json, "security_status"));
        system.initStar_id(JSONConversion.getlong(json, "star_id"));
        system.initNoaccess(JSONConversion.getboolean(json, "noaccess"));
        system.initIsconstellationborder(JSONConversion.getboolean(json, "isconstellationborder"));
        system.initIsregionborder(JSONConversion.getboolean(json, "isregionborder"));
        return system;
    }
}

