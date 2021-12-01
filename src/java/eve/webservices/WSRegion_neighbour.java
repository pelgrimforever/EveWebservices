/*
 * WSRegion_neighbour.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 30.10.2021 10:3
 *
 */

package eve.webservices;

import eve.BusinessObject.Logic.*;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.webservice.WSIRegion_neighbour;
import eve.logicentity.Region_neighbour;
import eve.searchentity.Region_neighboursearch;
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
@WebService(endpointInterface = "eve.interfaces.webservice.WSIRegion_neighbour")
public class WSRegion_neighbour implements WSIRegion_neighbour {

    private JSONArray toJSONArray(ArrayList region_neighbours) {
        JSONArray jsonregion_neighbours = new JSONArray();
        Iterator region_neighboursI = region_neighbours.iterator();
        while(region_neighboursI.hasNext()) {
            jsonregion_neighbours.add(JSONRegion_neighbour.toJSON((Region_neighbour)region_neighboursI.next()));
        }
        return jsonregion_neighbours;
    }

    /**
     * Web service operation
     */
    //@WebMethod(operationName = "getRegion_neighbours")
    @Override
    public String getRegion_neighbours() {
        try {
            BLregion_neighbour blregion_neighbour = new BLregion_neighbour();
            ArrayList region_neighbours = blregion_neighbour.getAll();
            JSONArray jsonregion_neighbours = toJSONArray(region_neighbours);
            return jsonregion_neighbours.toJSONString();
        }
        catch(DBException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String json) {
        BLregion_neighbour blregion_neighbour = new BLregion_neighbour();
        JSONParser parser = new JSONParser();
        String result = "";
        Region_neighbour region_neighbour;
        try {
            Region_neighboursearch region_neighboursearch = JSONRegion_neighbour.toRegion_neighboursearch((JSONObject)parser.parse(json));
            ArrayList region_neighbours = blregion_neighbour.search(region_neighboursearch);
            JSONArray jsonregion_neighbours = toJSONArray(region_neighbours);
            result = jsonregion_neighbours.toJSONString();
        }
        catch(ParseException e) {
            result = "";
        }
        catch(DBException e) {
            result = "";
        }
        return result;
    }

    //@WebMethod(operationName = "getRegion_neighbour")
    @Override
    public String getRegion_neighbour(String json) {
        BLregion_neighbour blregion_neighbour = new BLregion_neighbour();
        JSONParser parser = new JSONParser();
        String result = "";
        Region_neighbour region_neighbour;
        try {
            Region_neighbourPK region_neighbourPK = JSONRegion_neighbour.toRegion_neighbourPK((JSONObject)parser.parse(json));
            region_neighbour = blregion_neighbour.getRegion_neighbour(region_neighbourPK);
            if(region_neighbour!=null) {
                result = JSONRegion_neighbour.toJSON(region_neighbour).toJSONString();
            }
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
        return result;
    }

    //@WebMethod(operationName = "insertRegion_neighbour")
    @Override
    public void insertRegion_neighbour(String json) {
        BLregion_neighbour blregion_neighbour = new BLregion_neighbour();
        JSONParser parser = new JSONParser();
        try {
            IRegion_neighbour region_neighbour = JSONRegion_neighbour.toRegion_neighbour((JSONObject)parser.parse(json));
            blregion_neighbour.insertRegion_neighbour(region_neighbour);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "updateRegion_neighbour")
    @Override
    public void updateRegion_neighbour(String json) {
        BLregion_neighbour blregion_neighbour = new BLregion_neighbour();
        JSONParser parser = new JSONParser();
        try {
            IRegion_neighbour region_neighbour = JSONRegion_neighbour.toRegion_neighbour((JSONObject)parser.parse(json));
            blregion_neighbour.updateRegion_neighbour(region_neighbour);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "deleteRegion_neighbour")
    @Override
    public void deleteRegion_neighbour(String json) {
        BLregion_neighbour blregion_neighbour = new BLregion_neighbour();
        JSONParser parser = new JSONParser();
        try {
            IRegion_neighbour region_neighbour = JSONRegion_neighbour.toRegion_neighbour((JSONObject)parser.parse(json));
            blregion_neighbour.deleteRegion_neighbour(region_neighbour);
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "getRegion_neighbours4regionRegion")
    @Override
    public String getRegion_neighbours4regionRegion(String json) {
        BLregion_neighbour blregion_neighbour = new BLregion_neighbour();
        JSONParser parser = new JSONParser();
        Region_neighbour region_neighbour;
        try {
            IRegionPK regionRegionPK = JSONRegion.toRegionPK((JSONObject)parser.parse(json));
            ArrayList region_neighbours = blregion_neighbour.getRegion_neighbours4regionRegion(regionRegionPK);
            JSONArray jsonregion_neighbours = toJSONArray(region_neighbours);
            return jsonregion_neighbours.toJSONString();
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

    //@WebMethod(operationName = "delete4regionRegion")
    @Override
    public void delete4regionRegion(String json) {
        BLregion_neighbour blregion_neighbour = new BLregion_neighbour();
        JSONParser parser = new JSONParser();
        Region_neighbour region_neighbour;
        try {
            IRegionPK regionRegionPK = JSONRegion.toRegionPK((JSONObject)parser.parse(json));
            blregion_neighbour.delete4regionRegion(regionRegionPK);
        }
        catch(ParseException e) {
        }
    }

    //@WebMethod(operationName = "getRegion_neighbours4regionNeighbour")
    @Override
    public String getRegion_neighbours4regionNeighbour(String json) {
        BLregion_neighbour blregion_neighbour = new BLregion_neighbour();
        JSONParser parser = new JSONParser();
        Region_neighbour region_neighbour;
        try {
            IRegionPK regionNeighbourPK = JSONRegion.toRegionPK((JSONObject)parser.parse(json));
            ArrayList region_neighbours = blregion_neighbour.getRegion_neighbours4regionNeighbour(regionNeighbourPK);
            JSONArray jsonregion_neighbours = toJSONArray(region_neighbours);
            return jsonregion_neighbours.toJSONString();
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

    //@WebMethod(operationName = "delete4regionNeighbour")
    @Override
    public void delete4regionNeighbour(String json) {
        BLregion_neighbour blregion_neighbour = new BLregion_neighbour();
        JSONParser parser = new JSONParser();
        Region_neighbour region_neighbour;
        try {
            IRegionPK regionNeighbourPK = JSONRegion.toRegionPK((JSONObject)parser.parse(json));
            blregion_neighbour.delete4regionNeighbour(regionNeighbourPK);
        }
        catch(ParseException e) {
        }
    }


}

