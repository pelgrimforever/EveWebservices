/*
 * JSONStargate.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 16.11.2021 15:46
 *
 */
 
package eve.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.interfaces.db.EntityPK;
import data.interfaces.db.Fieldsearcher;
import data.json.piJson;
import eve.entity.pk.StargatePK;
import eve.interfaces.entity.pk.IStargatePK;
import eve.interfaces.logicentity.IStargate;
import eve.logicentity.Stargate;
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
public class JSONStargate {
    
    public static JSONArray toJSONArray(ArrayList stargates) {
        JSONArray jsonstargates = new JSONArray();
        Iterator stargatesI = stargates.iterator();
        while(stargatesI.hasNext()) {
            jsonstargates.add(toJSON((Stargate)stargatesI.next()));
        }
        return jsonstargates;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(IStargatePK stargatePK) {
        JSONObject json = null;
        if(stargatePK!=null) {
            json = new JSONObject();
            json.put("id", String.valueOf(stargatePK.getId()));
        }
        return json;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(IStargate stargate) {
        JSONObject json = new JSONObject();
        json.put("PK", toJSON(stargate.getPrimaryKey()));
        json.put("systemSystemPK", JSONSystem.toJSON(stargate.getSystemsystemPK()));
        json.put("systemTo_systemPK", JSONSystem.toJSON(stargate.getSystemto_systemPK()));
        json.put("to_stargate", String.valueOf(stargate.getTo_stargate()));
        json.put("name", stargate.getName());
        json.put("x", stargate.getX());
        json.put("y", stargate.getY());
        json.put("z", stargate.getZ());
        json.put("isconstellationborder", stargate.getIsconstellationborder());
        json.put("isregionborder", stargate.getIsregionborder());
        if(stargate.getDownloaddate()!=null) {
	        json.put("downloaddate", stargate.getDownloaddate().getTime());
        }
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(Stargatesearch stargatesearch) {
        JSONObject json = new JSONObject();
        if(stargatesearch.used()) {
            byte andoroperator = stargatesearch.getAndoroperator();
            int maxresults = stargatesearch.getMaxresults();
            boolean docount = stargatesearch.getDocount();
            Iterator<EntityPK> primarykeysI = stargatesearch.getPrimarykeys().iterator();
            Iterator<Fieldsearcher> fieldsearchersI = stargatesearch.getFieldsearchers().iterator();
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
            if(stargatesearch.getSystemsystemsearch()!=null && stargatesearch.getSystemsystemsearch().used()) {
                kss.put("systemSystemsearcher", JSONSystem.toJSON((Systemsearch)stargatesearch.getSystemsystemsearch()));
            }
            if(stargatesearch.getSystemto_systemsearch()!=null && stargatesearch.getSystemto_systemsearch().used()) {
                kss.put("systemTo_systemsearcher", JSONSystem.toJSON((Systemsearch)stargatesearch.getSystemto_systemsearch()));
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
    public static Stargatesearch toStargatesearch(JSONObject json) {
        Stargatesearch stargatesearch = new Stargatesearch();
        stargatesearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        stargatesearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        stargatesearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONArray pks = (JSONArray)json.get("primarykeys");
        for(int i=0; i<pks.size(); i++) {
            stargatesearch.addPrimarykey(StargatePK.getKey((String)pks.get(i)));
        }
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("id");
        if(field!=null) {
            long[] valuearray = JSONConversion.getLongvalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            stargatesearch.id(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("to_stargate");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            stargatesearch.to_stargate(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("name");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            stargatesearch.name(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("x");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            stargatesearch.x(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("y");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            stargatesearch.y(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("z");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            stargatesearch.z(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("isconstellationborder");
        if(field!=null) {
            boolean value = JSONConversion.getBooleanvalue(field);
            stargatesearch.isconstellationborder(value);
        }
        field = (JSONObject)fss.get("isregionborder");
        if(field!=null) {
            boolean value = JSONConversion.getBooleanvalue(field);
            stargatesearch.isregionborder(value);
        }
        field = (JSONObject)fss.get("downloaddate");
        if(field!=null) {
            Date[] valuearray = JSONConversion.getDatevalues(field);
            byte[] operators = JSONConversion.getDateoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            stargatesearch.downloaddate(valuearray, operators, andor);
        }
        JSONObject kss = (JSONObject)json.get("keysearch");
        JSONArray keysearch;
        keysearch = (JSONArray)kss.get("systemSystemsearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Systemsearch systemSystemsearch = JSONSystem.toSystemsearch((JSONObject)keysearch.get(i));
                stargatesearch.systemSystem(systemSystemsearch);
            }
        }
        keysearch = (JSONArray)kss.get("systemTo_systemsearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Systemsearch systemTo_systemsearch = JSONSystem.toSystemsearch((JSONObject)keysearch.get(i));
                stargatesearch.systemTo_system(systemTo_systemsearch);
            }
        }
        return stargatesearch;
    }
    
    public static StargatePK toStargatePK(JSONObject json) {
        StargatePK stargatePK = null;
        if(json!=null) {
            stargatePK = new StargatePK(JSONConversion.getlong(json, "id"));
        }
        return stargatePK;
    }

    public static Stargate toStargate(JSONObject json) {
        Stargate stargate = new Stargate(toStargatePK((JSONObject)json.get("PK")));
        updateStargate(stargate, json);
        return stargate;
    }

    public static void updateStargate(IStargate stargate, JSONObject json) {
        stargate.setSystemsystemPK(JSONSystem.toSystemPK((JSONObject)json.get("systemSystemPK")));
        stargate.setSystemto_systemPK(JSONSystem.toSystemPK((JSONObject)json.get("systemTo_systemPK")));
        stargate.setTo_stargate(JSONConversion.getlong(json, "to_stargate"));
        stargate.setName(JSONConversion.getString(json, "name"));
        stargate.setX(JSONConversion.getdouble(json, "x"));
        stargate.setY(JSONConversion.getdouble(json, "y"));
        stargate.setZ(JSONConversion.getdouble(json, "z"));
        stargate.setIsconstellationborder(JSONConversion.getboolean(json, "isconstellationborder"));
        stargate.setIsregionborder(JSONConversion.getboolean(json, "isregionborder"));
        stargate.setDownloaddate(JSONConversion.getDate(json, "downloaddate"));
    }

    public static Stargate initStargate(JSONObject json) {
        Stargate stargate = new Stargate(toStargatePK((JSONObject)json.get("PK")));
        stargate.initSystemsystemPK(JSONSystem.toSystemPK((JSONObject)json.get("systemSystemPK")));
        stargate.initSystemto_systemPK(JSONSystem.toSystemPK((JSONObject)json.get("systemTo_systemPK")));
        stargate.initTo_stargate(JSONConversion.getlong(json, "to_stargate"));
        stargate.initName(JSONConversion.getString(json, "name"));
        stargate.initX(JSONConversion.getdouble(json, "x"));
        stargate.initY(JSONConversion.getdouble(json, "y"));
        stargate.initZ(JSONConversion.getdouble(json, "z"));
        stargate.initIsconstellationborder(JSONConversion.getboolean(json, "isconstellationborder"));
        stargate.initIsregionborder(JSONConversion.getboolean(json, "isregionborder"));
        stargate.initDownloaddate(JSONConversion.getDate(json, "downloaddate"));
        return stargate;
    }
}

