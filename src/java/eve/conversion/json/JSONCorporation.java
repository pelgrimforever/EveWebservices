/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 13.6.2022 11:21
 */
 
package eve.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.interfaces.db.EntityPK;
import data.interfaces.db.Fieldsearcher;
import data.json.piJson;
import eve.entity.pk.CorporationPK;
import eve.interfaces.entity.pk.ICorporationPK;
import eve.interfaces.logicentity.ICorporation;
import eve.logicentity.Corporation;
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
public class JSONCorporation {
    
    public static JSONArray toJSONArray(ArrayList corporations) {
        JSONArray jsoncorporations = new JSONArray();
        Iterator corporationsI = corporations.iterator();
        while(corporationsI.hasNext()) {
            jsoncorporations.add(toJSON((Corporation)corporationsI.next()));
        }
        return jsoncorporations;
    }

    public static JSONObject toJSON(ICorporationPK corporationPK) {
        JSONObject json = null;
        if(corporationPK!=null) {
            json = new JSONObject();
            json.put("id", String.valueOf(corporationPK.getId()));
        }
        return json;
    }

    public static JSONObject toJSON(ICorporation corporation) {
        JSONObject json = new JSONObject();
        json.put("PK", toJSON(corporation.getPrimaryKey()));
        json.put("stationPK", JSONStation.toJSON(corporation.getStationPK()));
        json.put("factionPK", JSONFaction.toJSON(corporation.getFactionPK()));
        json.put("alliancePK", JSONAlliance.toJSON(corporation.getAlliancePK()));
        json.put("name", corporation.getName());
        json.put("ceo", String.valueOf(corporation.getCeo()));
        json.put("creator", String.valueOf(corporation.getCreator()));
        json.put("member_count", corporation.getMember_count());
        json.put("tax_rate", corporation.getTax_rate());
        json.put("ticker", corporation.getTicker());
        if(corporation.getDate_founded()!=null) {
	        json.put("date_founded", corporation.getDate_founded().getTime());
        }
        json.put("description", corporation.getDescription());
        json.put("shares", corporation.getShares());
        json.put("url", corporation.getUrl());
        json.put("war_eligible", corporation.getWar_eligible());
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    public static JSONObject toJSON(Corporationsearch corporationsearch) {
        JSONObject json = new JSONObject();
        if(corporationsearch.used()) {
            byte andoroperator = corporationsearch.getAndoroperator();
            int maxresults = corporationsearch.getMaxresults();
            boolean docount = corporationsearch.getDocount();
            Iterator<EntityPK> primarykeysI = corporationsearch.getPrimarykeys().iterator();
            Iterator<Fieldsearcher> fieldsearchersI = corporationsearch.getFieldsearchers().iterator();
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
            if(corporationsearch.getStationsearch()!=null && corporationsearch.getStationsearch().used()) {
                kss.put("stationsearcher", JSONStation.toJSON((Stationsearch)corporationsearch.getStationsearch()));
            }
            if(corporationsearch.getFactionsearch()!=null && corporationsearch.getFactionsearch().used()) {
                kss.put("factionsearcher", JSONFaction.toJSON((Factionsearch)corporationsearch.getFactionsearch()));
            }
            if(corporationsearch.getAlliancesearch()!=null && corporationsearch.getAlliancesearch().used()) {
                kss.put("alliancesearcher", JSONAlliance.toJSON((Alliancesearch)corporationsearch.getAlliancesearch()));
            }
            json.put("keysearch", kss);
        }
        return json;
    }

    public static Corporationsearch toCorporationsearch(JSONObject json) {
        Corporationsearch corporationsearch = new Corporationsearch();
        corporationsearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        corporationsearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        corporationsearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONArray pks = (JSONArray)json.get("primarykeys");
        for(int i=0; i<pks.size(); i++) {
            corporationsearch.addPrimarykey(CorporationPK.getKey((String)pks.get(i)));
        }
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("id");
        if(field!=null) {
            long[] valuearray = JSONConversion.getLongvalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            corporationsearch.id(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("name");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            corporationsearch.name(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("ceo");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            corporationsearch.ceo(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("creator");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            corporationsearch.creator(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("member_count");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            corporationsearch.member_count(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("tax_rate");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            corporationsearch.tax_rate(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("ticker");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            corporationsearch.ticker(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("date_founded");
        if(field!=null) {
            Timestamp[] valuearray = JSONConversion.getTimestampvalues(field);
            byte[] operators = JSONConversion.getTimeoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            corporationsearch.date_founded(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("description");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            corporationsearch.description(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("shares");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            corporationsearch.shares(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("url");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            corporationsearch.url(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("war_eligible");
        if(field!=null) {
            boolean value = JSONConversion.getBooleanvalue(field);
            corporationsearch.war_eligible(value);
        }
        JSONObject kss = (JSONObject)json.get("keysearch");
        JSONArray keysearch;
        keysearch = (JSONArray)kss.get("stationsearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Stationsearch stationsearch = JSONStation.toStationsearch((JSONObject)keysearch.get(i));
                corporationsearch.station(stationsearch);
            }
        }
        keysearch = (JSONArray)kss.get("factionsearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Factionsearch factionsearch = JSONFaction.toFactionsearch((JSONObject)keysearch.get(i));
                corporationsearch.faction(factionsearch);
            }
        }
        keysearch = (JSONArray)kss.get("alliancesearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Alliancesearch alliancesearch = JSONAlliance.toAlliancesearch((JSONObject)keysearch.get(i));
                corporationsearch.alliance(alliancesearch);
            }
        }
        return corporationsearch;
    }
    
    public static CorporationPK toCorporationPK(JSONObject json) {
        CorporationPK corporationPK = null;
        if(json!=null) {
            corporationPK = new CorporationPK(JSONConversion.getlong(json, "id"));
        }
        return corporationPK;
    }

    public static Corporation toCorporation(JSONObject json) {
        Corporation corporation = new Corporation(toCorporationPK((JSONObject)json.get("PK")));
        updateCorporation(corporation, json);
        return corporation;
    }

    public static void updateCorporation(ICorporation corporation, JSONObject json) {
        corporation.setStationPK(JSONStation.toStationPK((JSONObject)json.get("stationPK")));
        corporation.setFactionPK(JSONFaction.toFactionPK((JSONObject)json.get("factionPK")));
        corporation.setAlliancePK(JSONAlliance.toAlliancePK((JSONObject)json.get("alliancePK")));
        corporation.setName(JSONConversion.getString(json, "name"));
        corporation.setCeo(JSONConversion.getlong(json, "ceo"));
        corporation.setCreator(JSONConversion.getlong(json, "creator"));
        corporation.setMember_count(JSONConversion.getint(json, "member_count"));
        corporation.setTax_rate(JSONConversion.getdouble(json, "tax_rate"));
        corporation.setTicker(JSONConversion.getString(json, "ticker"));
        corporation.setDate_founded(JSONConversion.getTimestamp(json, "date_founded"));
        corporation.setDescription(JSONConversion.getString(json, "description"));
        corporation.setShares(JSONConversion.getint(json, "shares"));
        corporation.setUrl(JSONConversion.getString(json, "url"));
        corporation.setWar_eligible(JSONConversion.getboolean(json, "war_eligible"));
    }

    public static Corporation initCorporation(JSONObject json) {
        Corporation corporation = new Corporation(toCorporationPK((JSONObject)json.get("PK")));
        corporation.initStationPK(JSONStation.toStationPK((JSONObject)json.get("stationPK")));
        corporation.initFactionPK(JSONFaction.toFactionPK((JSONObject)json.get("factionPK")));
        corporation.initAlliancePK(JSONAlliance.toAlliancePK((JSONObject)json.get("alliancePK")));
        corporation.initName(JSONConversion.getString(json, "name"));
        corporation.initCeo(JSONConversion.getlong(json, "ceo"));
        corporation.initCreator(JSONConversion.getlong(json, "creator"));
        corporation.initMember_count(JSONConversion.getint(json, "member_count"));
        corporation.initTax_rate(JSONConversion.getdouble(json, "tax_rate"));
        corporation.initTicker(JSONConversion.getString(json, "ticker"));
        corporation.initDate_founded(JSONConversion.getTimestamp(json, "date_founded"));
        corporation.initDescription(JSONConversion.getString(json, "description"));
        corporation.initShares(JSONConversion.getint(json, "shares"));
        corporation.initUrl(JSONConversion.getString(json, "url"));
        corporation.initWar_eligible(JSONConversion.getboolean(json, "war_eligible"));
        return corporation;
    }
}

