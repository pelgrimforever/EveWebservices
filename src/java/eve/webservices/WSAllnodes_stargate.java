/*
 * WSAllnodes_stargate.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 16.11.2021 15:46
 *
 */

package eve.webservices;

import eve.BusinessObject.Logic.*;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.webservice.WSIAllnodes_stargate;
import eve.logicentity.Allnodes_stargate;
import eve.searchentity.Allnodes_stargatesearch;
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
@WebService(endpointInterface = "eve.interfaces.webservice.WSIAllnodes_stargate")
public class WSAllnodes_stargate implements WSIAllnodes_stargate {

    private JSONArray toJSONArray(ArrayList allnodes_stargates) {
        JSONArray jsonallnodes_stargates = new JSONArray();
        Iterator allnodes_stargatesI = allnodes_stargates.iterator();
        while(allnodes_stargatesI.hasNext()) {
            jsonallnodes_stargates.add(JSONAllnodes_stargate.toJSON((Allnodes_stargate)allnodes_stargatesI.next()));
        }
        return jsonallnodes_stargates;
    }

    /**
     * Web service operation
     */
    //@WebMethod(operationName = "getAllnodes_stargates")
    @Override
    public String getAllnodes_stargates() {
        try {
            BLallnodes_stargate blallnodes_stargate = new BLallnodes_stargate();
            ArrayList allnodes_stargates = blallnodes_stargate.getAll();
            JSONArray jsonallnodes_stargates = toJSONArray(allnodes_stargates);
            return jsonallnodes_stargates.toJSONString();
        }
        catch(DBException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String json) {
        BLallnodes_stargate blallnodes_stargate = new BLallnodes_stargate();
        JSONParser parser = new JSONParser();
        String result = "";
        Allnodes_stargate allnodes_stargate;
        try {
            Allnodes_stargatesearch allnodes_stargatesearch = JSONAllnodes_stargate.toAllnodes_stargatesearch((JSONObject)parser.parse(json));
            ArrayList allnodes_stargates = blallnodes_stargate.search(allnodes_stargatesearch);
            JSONArray jsonallnodes_stargates = toJSONArray(allnodes_stargates);
            result = jsonallnodes_stargates.toJSONString();
        }
        catch(ParseException e) {
            result = "";
        }
        catch(DBException e) {
            result = "";
        }
        return result;
    }

    //@WebMethod(operationName = "getAllnodes_stargate")
    @Override
    public String getAllnodes_stargate(String json) {
        BLallnodes_stargate blallnodes_stargate = new BLallnodes_stargate();
        JSONParser parser = new JSONParser();
        String result = "";
        Allnodes_stargate allnodes_stargate;
        try {
            Allnodes_stargatePK allnodes_stargatePK = JSONAllnodes_stargate.toAllnodes_stargatePK((JSONObject)parser.parse(json));
            allnodes_stargate = blallnodes_stargate.getAllnodes_stargate(allnodes_stargatePK);
            if(allnodes_stargate!=null) {
                result = JSONAllnodes_stargate.toJSON(allnodes_stargate).toJSONString();
            }
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
        return result;
    }

    //@WebMethod(operationName = "insertAllnodes_stargate")
    @Override
    public void insertAllnodes_stargate(String json) {
        BLallnodes_stargate blallnodes_stargate = new BLallnodes_stargate();
        JSONParser parser = new JSONParser();
        try {
            IAllnodes_stargate allnodes_stargate = JSONAllnodes_stargate.toAllnodes_stargate((JSONObject)parser.parse(json));
            blallnodes_stargate.insertAllnodes_stargate(allnodes_stargate);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "updateAllnodes_stargate")
    @Override
    public void updateAllnodes_stargate(String json) {
        BLallnodes_stargate blallnodes_stargate = new BLallnodes_stargate();
        JSONParser parser = new JSONParser();
        try {
            IAllnodes_stargate allnodes_stargate = JSONAllnodes_stargate.toAllnodes_stargate((JSONObject)parser.parse(json));
            blallnodes_stargate.updateAllnodes_stargate(allnodes_stargate);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "deleteAllnodes_stargate")
    @Override
    public void deleteAllnodes_stargate(String json) {
        BLallnodes_stargate blallnodes_stargate = new BLallnodes_stargate();
        JSONParser parser = new JSONParser();
        try {
            IAllnodes_stargate allnodes_stargate = JSONAllnodes_stargate.toAllnodes_stargate((JSONObject)parser.parse(json));
            blallnodes_stargate.deleteAllnodes_stargate(allnodes_stargate);
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
    }


}

