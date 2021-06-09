package eve.webservices;

import eve.BusinessObject.Logic.*;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.webservice.WSIRace;
import eve.logicentity.Race;
import eve.searchentity.Racesearch;
import general.exception.CustomException;
import general.exception.DataException;
import general.exception.DBException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.jws.WebMethod;
import javax.jws.WebService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Franky Laseure
 */
@WebService(endpointInterface = "eve.interfaces.webservice.WSIRace")
public class WSRace implements WSIRace {

    private JSONArray toJSONArray(ArrayList races) {
        JSONArray jsonraces = new JSONArray();
        Iterator racesI = races.iterator();
        while(racesI.hasNext()) {
            jsonraces.add(JSONRace.toJSON((Race)racesI.next()));
        }
        return jsonraces;
    }

    /**
     * Web service operation
     */
    //@WebMethod(operationName = "getRaces")
    @Override
    public String getRaces() {
        try {
            BLrace blrace = new BLrace();
            ArrayList races = blrace.getAll();
            JSONArray jsonraces = toJSONArray(races);
            return jsonraces.toJSONString();
        }
        catch(DBException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String json) {
        BLrace blrace = new BLrace();
        JSONParser parser = new JSONParser();
        String result = "";
        Race race;
        try {
            Racesearch racesearch = JSONRace.toRacesearch((JSONObject)parser.parse(json));
            ArrayList races = blrace.search(racesearch);
            JSONArray jsonraces = toJSONArray(races);
            result = jsonraces.toJSONString();
        }
        catch(ParseException e) {
            result = "";
        }
        catch(DBException e) {
            result = "";
        }
        return result;
    }

    //@WebMethod(operationName = "getRace")
    @Override
    public String getRace(String json) {
        BLrace blrace = new BLrace();
        JSONParser parser = new JSONParser();
        String result = "";
        Race race;
        try {
            RacePK racePK = JSONRace.toRacePK((JSONObject)parser.parse(json));
            race = blrace.getRace(racePK);
            if(race!=null) {
                result = JSONRace.toJSON(race).toJSONString();
            }
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
        return result;
    }

    //@WebMethod(operationName = "insertRace")
    @Override
    public void insertRace(String json) {
        BLrace blrace = new BLrace();
        JSONParser parser = new JSONParser();
        try {
            IRace race = JSONRace.toRace((JSONObject)parser.parse(json));
            blrace.insertRace(race);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "updateRace")
    @Override
    public void updateRace(String json) {
        BLrace blrace = new BLrace();
        JSONParser parser = new JSONParser();
        try {
            IRace race = JSONRace.toRace((JSONObject)parser.parse(json));
            blrace.updateRace(race);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "deleteRace")
    @Override
    public void deleteRace(String json) {
        BLrace blrace = new BLrace();
        JSONParser parser = new JSONParser();
        try {
            IRace race = JSONRace.toRace((JSONObject)parser.parse(json));
            blrace.deleteRace(race);
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "getRaces4faction")
    @Override
    public String getRaces4faction(String json) {
        BLrace blrace = new BLrace();
        JSONParser parser = new JSONParser();
        Race race;
        try {
            IFactionPK factionPK = JSONFaction.toFactionPK((JSONObject)parser.parse(json));
            ArrayList races = blrace.getRaces4faction(factionPK);
            JSONArray jsonraces = toJSONArray(races);
            return jsonraces.toJSONString();
        }
        catch(ParseException e) {
            return null;
        }
        catch(DBException e) {
            return null;
        }
        catch(CustomException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4faction")
    @Override
    public void delete4faction(String json) {
        BLrace blrace = new BLrace();
        JSONParser parser = new JSONParser();
        Race race;
        try {
            IFactionPK factionPK = JSONFaction.toFactionPK((JSONObject)parser.parse(json));
            blrace.delete4faction(this.getClass().getName(), factionPK);
        }
        catch(ParseException e) {
        }
    }


}

