/*
 * WSAllnodes_system.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 11.4.2022 9:13
 *
 */

package eve.webservices;

import eve.BusinessObject.Logic.*;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.webservice.WSIAllnodes_system;
import eve.logicentity.Allnodes_system;
import eve.searchentity.Allnodes_systemsearch;
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
@WebService(endpointInterface = "eve.interfaces.webservice.WSIAllnodes_system")
public class WSAllnodes_system implements WSIAllnodes_system {

    private JSONArray toJSONArray(ArrayList allnodes_systems) {
        JSONArray jsonallnodes_systems = new JSONArray();
        Iterator allnodes_systemsI = allnodes_systems.iterator();
        while(allnodes_systemsI.hasNext()) {
            jsonallnodes_systems.add(JSONAllnodes_system.toJSON((Allnodes_system)allnodes_systemsI.next()));
        }
        return jsonallnodes_systems;
    }

    /**
     * Web service operation
     */
    //@WebMethod(operationName = "getAllnodes_systems")
    @Override
    public String getAllnodes_systems() {
        try {
            BLallnodes_system blallnodes_system = new BLallnodes_system();
            ArrayList allnodes_systems = blallnodes_system.getAll();
            JSONArray jsonallnodes_systems = toJSONArray(allnodes_systems);
            return jsonallnodes_systems.toJSONString();
        }
        catch(DBException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String json) {
        BLallnodes_system blallnodes_system = new BLallnodes_system();
        JSONParser parser = new JSONParser();
        String result = "";
        Allnodes_system allnodes_system;
        try {
            Allnodes_systemsearch allnodes_systemsearch = JSONAllnodes_system.toAllnodes_systemsearch((JSONObject)parser.parse(json));
            ArrayList allnodes_systems = blallnodes_system.search(allnodes_systemsearch);
            JSONArray jsonallnodes_systems = toJSONArray(allnodes_systems);
            result = jsonallnodes_systems.toJSONString();
        }
        catch(ParseException e) {
            result = "";
        }
        catch(DBException e) {
            result = "";
        }
        return result;
    }

    //@WebMethod(operationName = "getAllnodes_system")
    @Override
    public String getAllnodes_system(String json) {
        BLallnodes_system blallnodes_system = new BLallnodes_system();
        JSONParser parser = new JSONParser();
        String result = "";
        Allnodes_system allnodes_system;
        try {
            Allnodes_systemPK allnodes_systemPK = JSONAllnodes_system.toAllnodes_systemPK((JSONObject)parser.parse(json));
            allnodes_system = blallnodes_system.getAllnodes_system(allnodes_systemPK);
            if(allnodes_system!=null) {
                result = JSONAllnodes_system.toJSON(allnodes_system).toJSONString();
            }
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
        return result;
    }

    //@WebMethod(operationName = "insertAllnodes_system")
    @Override
    public void insertAllnodes_system(String json) {
        BLallnodes_system blallnodes_system = new BLallnodes_system();
        JSONParser parser = new JSONParser();
        try {
            IAllnodes_system allnodes_system = JSONAllnodes_system.toAllnodes_system((JSONObject)parser.parse(json));
            blallnodes_system.insertAllnodes_system(allnodes_system);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "updateAllnodes_system")
    @Override
    public void updateAllnodes_system(String json) {
        BLallnodes_system blallnodes_system = new BLallnodes_system();
        JSONParser parser = new JSONParser();
        try {
            IAllnodes_system allnodes_system = JSONAllnodes_system.toAllnodes_system((JSONObject)parser.parse(json));
            blallnodes_system.updateAllnodes_system(allnodes_system);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "deleteAllnodes_system")
    @Override
    public void deleteAllnodes_system(String json) {
        BLallnodes_system blallnodes_system = new BLallnodes_system();
        JSONParser parser = new JSONParser();
        try {
            IAllnodes_system allnodes_system = JSONAllnodes_system.toAllnodes_system((JSONObject)parser.parse(json));
            blallnodes_system.deleteAllnodes_system(allnodes_system);
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
    }


}

