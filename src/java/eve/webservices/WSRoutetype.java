/*
 * WSRoutetype.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 24.9.2021 14:40
 *
 */

package eve.webservices;

import eve.BusinessObject.Logic.*;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.webservice.WSIRoutetype;
import eve.logicentity.Routetype;
import eve.searchentity.Routetypesearch;
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
@WebService(endpointInterface = "eve.interfaces.webservice.WSIRoutetype")
public class WSRoutetype implements WSIRoutetype {

    private JSONArray toJSONArray(ArrayList routetypes) {
        JSONArray jsonroutetypes = new JSONArray();
        Iterator routetypesI = routetypes.iterator();
        while(routetypesI.hasNext()) {
            jsonroutetypes.add(JSONRoutetype.toJSON((Routetype)routetypesI.next()));
        }
        return jsonroutetypes;
    }

    /**
     * Web service operation
     */
    //@WebMethod(operationName = "getRoutetypes")
    @Override
    public String getRoutetypes() {
        try {
            BLroutetype blroutetype = new BLroutetype();
            ArrayList routetypes = blroutetype.getAll();
            JSONArray jsonroutetypes = toJSONArray(routetypes);
            return jsonroutetypes.toJSONString();
        }
        catch(DBException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String json) {
        BLroutetype blroutetype = new BLroutetype();
        JSONParser parser = new JSONParser();
        String result = "";
        Routetype routetype;
        try {
            Routetypesearch routetypesearch = JSONRoutetype.toRoutetypesearch((JSONObject)parser.parse(json));
            ArrayList routetypes = blroutetype.search(routetypesearch);
            JSONArray jsonroutetypes = toJSONArray(routetypes);
            result = jsonroutetypes.toJSONString();
        }
        catch(ParseException e) {
            result = "";
        }
        catch(DBException e) {
            result = "";
        }
        return result;
    }

    //@WebMethod(operationName = "getRoutetype")
    @Override
    public String getRoutetype(String json) {
        BLroutetype blroutetype = new BLroutetype();
        JSONParser parser = new JSONParser();
        String result = "";
        Routetype routetype;
        try {
            RoutetypePK routetypePK = JSONRoutetype.toRoutetypePK((JSONObject)parser.parse(json));
            routetype = blroutetype.getRoutetype(routetypePK);
            if(routetype!=null) {
                result = JSONRoutetype.toJSON(routetype).toJSONString();
            }
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
        return result;
    }

    //@WebMethod(operationName = "insertRoutetype")
    @Override
    public void insertRoutetype(String json) {
        BLroutetype blroutetype = new BLroutetype();
        JSONParser parser = new JSONParser();
        try {
            IRoutetype routetype = JSONRoutetype.toRoutetype((JSONObject)parser.parse(json));
            blroutetype.insertRoutetype(routetype);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "updateRoutetype")
    @Override
    public void updateRoutetype(String json) {
        BLroutetype blroutetype = new BLroutetype();
        JSONParser parser = new JSONParser();
        try {
            IRoutetype routetype = JSONRoutetype.toRoutetype((JSONObject)parser.parse(json));
            blroutetype.updateRoutetype(routetype);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "deleteRoutetype")
    @Override
    public void deleteRoutetype(String json) {
        BLroutetype blroutetype = new BLroutetype();
        JSONParser parser = new JSONParser();
        try {
            IRoutetype routetype = JSONRoutetype.toRoutetype((JSONObject)parser.parse(json));
            blroutetype.deleteRoutetype(routetype);
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "getRoutetypes4security_island")
    @Override
    public String getRoutetypes4security_island(String json) {
        BLroutetype blroutetype = new BLroutetype();
        JSONParser parser = new JSONParser();
        Routetype routetype;
        try {
            ISecurity_islandPK security_islandPK = JSONSecurity_island.toSecurity_islandPK((JSONObject)parser.parse(json));
            ArrayList routetypes = blroutetype.getRoutetypes4security_island(security_islandPK);
            JSONArray jsonroutetypes = toJSONArray(routetypes);
            return jsonroutetypes.toJSONString();
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

    //@WebMethod(operationName = "delete4security_island")
    @Override
    public void delete4security_island(String json) {
        BLroutetype blroutetype = new BLroutetype();
        JSONParser parser = new JSONParser();
        Routetype routetype;
        try {
            ISecurity_islandPK security_islandPK = JSONSecurity_island.toSecurity_islandPK((JSONObject)parser.parse(json));
            blroutetype.delete4security_island(security_islandPK);
        }
        catch(ParseException e) {
        }
    }

    //@WebMethod(operationName = "getRoutetypes4route")
    @Override
    public String getRoutetypes4route(String json) {
        BLroutetype blroutetype = new BLroutetype();
        JSONParser parser = new JSONParser();
        Routetype routetype;
        try {
            String result = null;
            IRoutePK routePK = JSONRoute.toRoutePK((JSONObject)parser.parse(json));
            routetype = (Routetype)blroutetype.getRoute(routePK);
            if(routetype!=null) {
                result = JSONRoutetype.toJSON(routetype).toJSONString();
            }
            return result;
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


}

