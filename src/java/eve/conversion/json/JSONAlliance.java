/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 17.6.2022 13:4
 */
 
package eve.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.interfaces.db.EntityPK;
import data.interfaces.db.Fieldsearcher;
import data.json.piJson;
import eve.entity.pk.AlliancePK;
import eve.interfaces.entity.pk.IAlliancePK;
import eve.interfaces.logicentity.IAlliance;
import eve.logicentity.Alliance;
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
public class JSONAlliance {
    
    public static JSONArray toJSONArray(ArrayList alliances) {
        JSONArray jsonalliances = new JSONArray();
        Iterator alliancesI = alliances.iterator();
        while(alliancesI.hasNext()) {
            jsonalliances.add(toJSON((Alliance)alliancesI.next()));
        }
        return jsonalliances;
    }

    public static JSONObject toJSON(IAlliancePK alliancePK) {
        JSONObject json = null;
        if(alliancePK!=null) {
            json = new JSONObject();
            json.put("id", String.valueOf(alliancePK.getId()));
        }
        return json;
    }

    public static JSONObject toJSON(IAlliance alliance) {
        JSONObject json = new JSONObject();
        json.put("PK", toJSON(alliance.getPrimaryKey()));
        json.put("corporationCreator_corporationPK", JSONCorporation.toJSON(alliance.getCorporationcreator_corporationPK()));
        json.put("corporationExecutor_corporationPK", JSONCorporation.toJSON(alliance.getCorporationexecutor_corporationPK()));
        json.put("name", alliance.getName());
        json.put("creator", String.valueOf(alliance.getCreator()));
        if(alliance.getDate_founded()!=null) {
	        json.put("date_founded", alliance.getDate_founded().getTime());
        }
        json.put("ticker", alliance.getTicker());
        json.put("faction_id", String.valueOf(alliance.getFaction_id()));
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    public static JSONObject toJSON(Alliancesearch alliancesearch) {
        JSONObject json = new JSONObject();
        if(alliancesearch.used()) {
            byte andoroperator = alliancesearch.getAndoroperator();
            int maxresults = alliancesearch.getMaxresults();
            boolean docount = alliancesearch.getDocount();
            Iterator<EntityPK> primarykeysI = alliancesearch.getPrimarykeys().iterator();
            Iterator<Fieldsearcher> fieldsearchersI = alliancesearch.getFieldsearchers().iterator();
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
            if(alliancesearch.getCorporationcreator_corporationsearch()!=null && alliancesearch.getCorporationcreator_corporationsearch().used()) {
                kss.put("corporationCreator_corporationsearcher", JSONCorporation.toJSON((Corporationsearch)alliancesearch.getCorporationcreator_corporationsearch()));
            }
            if(alliancesearch.getCorporationexecutor_corporationsearch()!=null && alliancesearch.getCorporationexecutor_corporationsearch().used()) {
                kss.put("corporationExecutor_corporationsearcher", JSONCorporation.toJSON((Corporationsearch)alliancesearch.getCorporationexecutor_corporationsearch()));
            }
            json.put("keysearch", kss);
        }
        return json;
    }

    public static Alliancesearch toAlliancesearch(JSONObject json) {
        Alliancesearch alliancesearch = new Alliancesearch();
        alliancesearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        alliancesearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        alliancesearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONArray pks = (JSONArray)json.get("primarykeys");
        for(int i=0; i<pks.size(); i++) {
            alliancesearch.addPrimarykey(AlliancePK.getKey((String)pks.get(i)));
        }
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("id");
        if(field!=null) {
            long[] valuearray = JSONConversion.getLongvalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            alliancesearch.id(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("name");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            alliancesearch.name(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("creator");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            alliancesearch.creator(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("date_founded");
        if(field!=null) {
            Timestamp[] valuearray = JSONConversion.getTimestampvalues(field);
            byte[] operators = JSONConversion.getTimeoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            alliancesearch.date_founded(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("ticker");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            alliancesearch.ticker(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("faction_id");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            alliancesearch.faction_id(valuearray, operators, andor);
        }
        JSONObject kss = (JSONObject)json.get("keysearch");
        JSONArray keysearch;
        keysearch = (JSONArray)kss.get("corporationCreator_corporationsearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Corporationsearch corporationCreator_corporationsearch = JSONCorporation.toCorporationsearch((JSONObject)keysearch.get(i));
                alliancesearch.corporationCreator_corporation(corporationCreator_corporationsearch);
            }
        }
        keysearch = (JSONArray)kss.get("corporationExecutor_corporationsearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Corporationsearch corporationExecutor_corporationsearch = JSONCorporation.toCorporationsearch((JSONObject)keysearch.get(i));
                alliancesearch.corporationExecutor_corporation(corporationExecutor_corporationsearch);
            }
        }
        return alliancesearch;
    }
    
    public static AlliancePK toAlliancePK(JSONObject json) {
        AlliancePK alliancePK = null;
        if(json!=null) {
            alliancePK = new AlliancePK(JSONConversion.getlong(json, "id"));
        }
        return alliancePK;
    }

    public static Alliance toAlliance(JSONObject json) {
        Alliance alliance = new Alliance(toAlliancePK((JSONObject)json.get("PK")));
        updateAlliance(alliance, json);
        return alliance;
    }

    public static void updateAlliance(IAlliance alliance, JSONObject json) {
        alliance.setCorporationcreator_corporationPK(JSONCorporation.toCorporationPK((JSONObject)json.get("corporationCreator_corporationPK")));
        alliance.setCorporationexecutor_corporationPK(JSONCorporation.toCorporationPK((JSONObject)json.get("corporationExecutor_corporationPK")));
        alliance.setName(JSONConversion.getString(json, "name"));
        alliance.setCreator(JSONConversion.getlong(json, "creator"));
        alliance.setDate_founded(JSONConversion.getTimestamp(json, "date_founded"));
        alliance.setTicker(JSONConversion.getString(json, "ticker"));
        alliance.setFaction_id(JSONConversion.getlong(json, "faction_id"));
    }

    public static Alliance initAlliance(JSONObject json) {
        Alliance alliance = new Alliance(toAlliancePK((JSONObject)json.get("PK")));
        alliance.initCorporationcreator_corporationPK(JSONCorporation.toCorporationPK((JSONObject)json.get("corporationCreator_corporationPK")));
        alliance.initCorporationexecutor_corporationPK(JSONCorporation.toCorporationPK((JSONObject)json.get("corporationExecutor_corporationPK")));
        alliance.initName(JSONConversion.getString(json, "name"));
        alliance.initCreator(JSONConversion.getlong(json, "creator"));
        alliance.initDate_founded(JSONConversion.getTimestamp(json, "date_founded"));
        alliance.initTicker(JSONConversion.getString(json, "ticker"));
        alliance.initFaction_id(JSONConversion.getlong(json, "faction_id"));
        return alliance;
    }
}

