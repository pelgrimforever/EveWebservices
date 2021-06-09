package eve.webservices;

import eve.BusinessObject.Logic.*;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.webservice.WSISecurity_island;
import eve.logicentity.Security_island;
import eve.searchentity.Security_islandsearch;
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
@WebService(endpointInterface = "eve.interfaces.webservice.WSISecurity_island")
public class WSSecurity_island implements WSISecurity_island {

    private JSONArray toJSONArray(ArrayList security_islands) {
        JSONArray jsonsecurity_islands = new JSONArray();
        Iterator security_islandsI = security_islands.iterator();
        while(security_islandsI.hasNext()) {
            jsonsecurity_islands.add(JSONSecurity_island.toJSON((Security_island)security_islandsI.next()));
        }
        return jsonsecurity_islands;
    }

    /**
     * Web service operation
     */
    //@WebMethod(operationName = "getSecurity_islands")
    @Override
    public String getSecurity_islands() {
        try {
            BLsecurity_island blsecurity_island = new BLsecurity_island();
            ArrayList security_islands = blsecurity_island.getAll();
            JSONArray jsonsecurity_islands = toJSONArray(security_islands);
            return jsonsecurity_islands.toJSONString();
        }
        catch(DBException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String json) {
        BLsecurity_island blsecurity_island = new BLsecurity_island();
        JSONParser parser = new JSONParser();
        String result = "";
        Security_island security_island;
        try {
            Security_islandsearch security_islandsearch = JSONSecurity_island.toSecurity_islandsearch((JSONObject)parser.parse(json));
            ArrayList security_islands = blsecurity_island.search(security_islandsearch);
            JSONArray jsonsecurity_islands = toJSONArray(security_islands);
            result = jsonsecurity_islands.toJSONString();
        }
        catch(ParseException e) {
            result = "";
        }
        catch(DBException e) {
            result = "";
        }
        return result;
    }

    //@WebMethod(operationName = "getSecurity_island")
    @Override
    public String getSecurity_island(String json) {
        BLsecurity_island blsecurity_island = new BLsecurity_island();
        JSONParser parser = new JSONParser();
        String result = "";
        Security_island security_island;
        try {
            Security_islandPK security_islandPK = JSONSecurity_island.toSecurity_islandPK((JSONObject)parser.parse(json));
            security_island = blsecurity_island.getSecurity_island(security_islandPK);
            if(security_island!=null) {
                result = JSONSecurity_island.toJSON(security_island).toJSONString();
            }
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
        return result;
    }

    //@WebMethod(operationName = "insertSecurity_island")
    @Override
    public void insertSecurity_island(String json) {
        BLsecurity_island blsecurity_island = new BLsecurity_island();
        JSONParser parser = new JSONParser();
        try {
            ISecurity_island security_island = JSONSecurity_island.toSecurity_island((JSONObject)parser.parse(json));
            blsecurity_island.insertSecurity_island(security_island);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "updateSecurity_island")
    @Override
    public void updateSecurity_island(String json) {
        BLsecurity_island blsecurity_island = new BLsecurity_island();
        JSONParser parser = new JSONParser();
        try {
            ISecurity_island security_island = JSONSecurity_island.toSecurity_island((JSONObject)parser.parse(json));
            blsecurity_island.updateSecurity_island(security_island);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "deleteSecurity_island")
    @Override
    public void deleteSecurity_island(String json) {
        BLsecurity_island blsecurity_island = new BLsecurity_island();
        JSONParser parser = new JSONParser();
        try {
            ISecurity_island security_island = JSONSecurity_island.toSecurity_island((JSONObject)parser.parse(json));
            blsecurity_island.deleteSecurity_island(security_island);
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
    }


}

