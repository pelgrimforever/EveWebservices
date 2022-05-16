/*
 * WSConstellation_neighbour.java
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
import eve.interfaces.webservice.WSIConstellation_neighbour;
import eve.logicentity.Constellation_neighbour;
import eve.searchentity.Constellation_neighboursearch;
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
@WebService(endpointInterface = "eve.interfaces.webservice.WSIConstellation_neighbour")
public class WSConstellation_neighbour implements WSIConstellation_neighbour {

    private JSONArray toJSONArray(ArrayList constellation_neighbours) {
        JSONArray jsonconstellation_neighbours = new JSONArray();
        Iterator constellation_neighboursI = constellation_neighbours.iterator();
        while(constellation_neighboursI.hasNext()) {
            jsonconstellation_neighbours.add(JSONConstellation_neighbour.toJSON((Constellation_neighbour)constellation_neighboursI.next()));
        }
        return jsonconstellation_neighbours;
    }

    /**
     * Web service operation
     */
    //@WebMethod(operationName = "getConstellation_neighbours")
    @Override
    public String getConstellation_neighbours() {
        try {
            BLconstellation_neighbour blconstellation_neighbour = new BLconstellation_neighbour();
            ArrayList constellation_neighbours = blconstellation_neighbour.getAll();
            JSONArray jsonconstellation_neighbours = toJSONArray(constellation_neighbours);
            return jsonconstellation_neighbours.toJSONString();
        }
        catch(DBException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String json) {
        BLconstellation_neighbour blconstellation_neighbour = new BLconstellation_neighbour();
        JSONParser parser = new JSONParser();
        String result = "";
        Constellation_neighbour constellation_neighbour;
        try {
            Constellation_neighboursearch constellation_neighboursearch = JSONConstellation_neighbour.toConstellation_neighboursearch((JSONObject)parser.parse(json));
            ArrayList constellation_neighbours = blconstellation_neighbour.search(constellation_neighboursearch);
            JSONArray jsonconstellation_neighbours = toJSONArray(constellation_neighbours);
            result = jsonconstellation_neighbours.toJSONString();
        }
        catch(ParseException e) {
            result = "";
        }
        catch(DBException e) {
            result = "";
        }
        return result;
    }

    //@WebMethod(operationName = "getConstellation_neighbour")
    @Override
    public String getConstellation_neighbour(String json) {
        BLconstellation_neighbour blconstellation_neighbour = new BLconstellation_neighbour();
        JSONParser parser = new JSONParser();
        String result = "";
        Constellation_neighbour constellation_neighbour;
        try {
            Constellation_neighbourPK constellation_neighbourPK = JSONConstellation_neighbour.toConstellation_neighbourPK((JSONObject)parser.parse(json));
            constellation_neighbour = blconstellation_neighbour.getConstellation_neighbour(constellation_neighbourPK);
            if(constellation_neighbour!=null) {
                result = JSONConstellation_neighbour.toJSON(constellation_neighbour).toJSONString();
            }
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
        return result;
    }

    //@WebMethod(operationName = "insertConstellation_neighbour")
    @Override
    public void insertConstellation_neighbour(String json) {
        BLconstellation_neighbour blconstellation_neighbour = new BLconstellation_neighbour();
        JSONParser parser = new JSONParser();
        try {
            IConstellation_neighbour constellation_neighbour = JSONConstellation_neighbour.toConstellation_neighbour((JSONObject)parser.parse(json));
            blconstellation_neighbour.insertConstellation_neighbour(constellation_neighbour);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "updateConstellation_neighbour")
    @Override
    public void updateConstellation_neighbour(String json) {
        BLconstellation_neighbour blconstellation_neighbour = new BLconstellation_neighbour();
        JSONParser parser = new JSONParser();
        try {
            IConstellation_neighbour constellation_neighbour = JSONConstellation_neighbour.toConstellation_neighbour((JSONObject)parser.parse(json));
            blconstellation_neighbour.updateConstellation_neighbour(constellation_neighbour);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "deleteConstellation_neighbour")
    @Override
    public void deleteConstellation_neighbour(String json) {
        BLconstellation_neighbour blconstellation_neighbour = new BLconstellation_neighbour();
        JSONParser parser = new JSONParser();
        try {
            IConstellation_neighbour constellation_neighbour = JSONConstellation_neighbour.toConstellation_neighbour((JSONObject)parser.parse(json));
            blconstellation_neighbour.deleteConstellation_neighbour(constellation_neighbour);
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "getConstellation_neighbours4constellationNeighbour")
    @Override
    public String getConstellation_neighbours4constellationNeighbour(String json) {
        BLconstellation_neighbour blconstellation_neighbour = new BLconstellation_neighbour();
        JSONParser parser = new JSONParser();
        Constellation_neighbour constellation_neighbour;
        try {
            IConstellationPK constellationNeighbourPK = JSONConstellation.toConstellationPK((JSONObject)parser.parse(json));
            ArrayList constellation_neighbours = blconstellation_neighbour.getConstellation_neighbours4constellationNeighbour(constellationNeighbourPK);
            JSONArray jsonconstellation_neighbours = toJSONArray(constellation_neighbours);
            return jsonconstellation_neighbours.toJSONString();
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

    //@WebMethod(operationName = "delete4constellationNeighbour")
    @Override
    public void delete4constellationNeighbour(String json) {
        BLconstellation_neighbour blconstellation_neighbour = new BLconstellation_neighbour();
        JSONParser parser = new JSONParser();
        Constellation_neighbour constellation_neighbour;
        try {
            IConstellationPK constellationNeighbourPK = JSONConstellation.toConstellationPK((JSONObject)parser.parse(json));
            blconstellation_neighbour.delete4constellationNeighbour(constellationNeighbourPK);
        }
        catch(ParseException e) {
        }
    }

    //@WebMethod(operationName = "getConstellation_neighbours4constellationConstellation")
    @Override
    public String getConstellation_neighbours4constellationConstellation(String json) {
        BLconstellation_neighbour blconstellation_neighbour = new BLconstellation_neighbour();
        JSONParser parser = new JSONParser();
        Constellation_neighbour constellation_neighbour;
        try {
            IConstellationPK constellationConstellationPK = JSONConstellation.toConstellationPK((JSONObject)parser.parse(json));
            ArrayList constellation_neighbours = blconstellation_neighbour.getConstellation_neighbours4constellationConstellation(constellationConstellationPK);
            JSONArray jsonconstellation_neighbours = toJSONArray(constellation_neighbours);
            return jsonconstellation_neighbours.toJSONString();
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

    //@WebMethod(operationName = "delete4constellationConstellation")
    @Override
    public void delete4constellationConstellation(String json) {
        BLconstellation_neighbour blconstellation_neighbour = new BLconstellation_neighbour();
        JSONParser parser = new JSONParser();
        Constellation_neighbour constellation_neighbour;
        try {
            IConstellationPK constellationConstellationPK = JSONConstellation.toConstellationPK((JSONObject)parser.parse(json));
            blconstellation_neighbour.delete4constellationConstellation(constellationConstellationPK);
        }
        catch(ParseException e) {
        }
    }


}

