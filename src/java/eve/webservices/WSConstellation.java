/*
 * WSConstellation.java
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
import eve.interfaces.webservice.WSIConstellation;
import eve.logicentity.Constellation;
import eve.searchentity.Constellationsearch;
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
@WebService(endpointInterface = "eve.interfaces.webservice.WSIConstellation")
public class WSConstellation implements WSIConstellation {

    private JSONArray toJSONArray(ArrayList constellations) {
        JSONArray jsonconstellations = new JSONArray();
        Iterator constellationsI = constellations.iterator();
        while(constellationsI.hasNext()) {
            jsonconstellations.add(JSONConstellation.toJSON((Constellation)constellationsI.next()));
        }
        return jsonconstellations;
    }

    /**
     * Web service operation
     */
    //@WebMethod(operationName = "getConstellations")
    @Override
    public String getConstellations() {
        try {
            BLconstellation blconstellation = new BLconstellation();
            ArrayList constellations = blconstellation.getAll();
            JSONArray jsonconstellations = toJSONArray(constellations);
            return jsonconstellations.toJSONString();
        }
        catch(DBException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String json) {
        BLconstellation blconstellation = new BLconstellation();
        JSONParser parser = new JSONParser();
        String result = "";
        Constellation constellation;
        try {
            Constellationsearch constellationsearch = JSONConstellation.toConstellationsearch((JSONObject)parser.parse(json));
            ArrayList constellations = blconstellation.search(constellationsearch);
            JSONArray jsonconstellations = toJSONArray(constellations);
            result = jsonconstellations.toJSONString();
        }
        catch(ParseException e) {
            result = "";
        }
        catch(DBException e) {
            result = "";
        }
        return result;
    }

    //@WebMethod(operationName = "getConstellation")
    @Override
    public String getConstellation(String json) {
        BLconstellation blconstellation = new BLconstellation();
        JSONParser parser = new JSONParser();
        String result = "";
        Constellation constellation;
        try {
            ConstellationPK constellationPK = JSONConstellation.toConstellationPK((JSONObject)parser.parse(json));
            constellation = blconstellation.getConstellation(constellationPK);
            if(constellation!=null) {
                result = JSONConstellation.toJSON(constellation).toJSONString();
            }
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
        return result;
    }

    //@WebMethod(operationName = "insertConstellation")
    @Override
    public void insertConstellation(String json) {
        BLconstellation blconstellation = new BLconstellation();
        JSONParser parser = new JSONParser();
        try {
            IConstellation constellation = JSONConstellation.toConstellation((JSONObject)parser.parse(json));
            blconstellation.insertConstellation(constellation);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "updateConstellation")
    @Override
    public void updateConstellation(String json) {
        BLconstellation blconstellation = new BLconstellation();
        JSONParser parser = new JSONParser();
        try {
            IConstellation constellation = JSONConstellation.toConstellation((JSONObject)parser.parse(json));
            blconstellation.updateConstellation(constellation);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "deleteConstellation")
    @Override
    public void deleteConstellation(String json) {
        BLconstellation blconstellation = new BLconstellation();
        JSONParser parser = new JSONParser();
        try {
            IConstellation constellation = JSONConstellation.toConstellation((JSONObject)parser.parse(json));
            blconstellation.deleteConstellation(constellation);
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "getConstellations4region")
    @Override
    public String getConstellations4region(String json) {
        BLconstellation blconstellation = new BLconstellation();
        JSONParser parser = new JSONParser();
        Constellation constellation;
        try {
            IRegionPK regionPK = JSONRegion.toRegionPK((JSONObject)parser.parse(json));
            ArrayList constellations = blconstellation.getConstellations4region(regionPK);
            JSONArray jsonconstellations = toJSONArray(constellations);
            return jsonconstellations.toJSONString();
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

    //@WebMethod(operationName = "delete4region")
    @Override
    public void delete4region(String json) {
        BLconstellation blconstellation = new BLconstellation();
        JSONParser parser = new JSONParser();
        Constellation constellation;
        try {
            IRegionPK regionPK = JSONRegion.toRegionPK((JSONObject)parser.parse(json));
            blconstellation.delete4region(regionPK);
        }
        catch(ParseException e) {
        }
    }

    //@WebMethod(operationName = "getConstellations4constellation_neighbourNeighbour")
    @Override
    public String getConstellations4constellation_neighbourNeighbour(String json) {
        BLconstellation blconstellation = new BLconstellation();
        JSONParser parser = new JSONParser();
        Constellation constellation;
        try {
            String result = null;
            IConstellation_neighbourPK constellation_neighbourNeighbourPK = JSONConstellation_neighbour.toConstellation_neighbourPK((JSONObject)parser.parse(json));
            constellation = (Constellation)blconstellation.getConstellation_neighbourneighbour(constellation_neighbourNeighbourPK);
            if(constellation!=null) {
                result = JSONConstellation.toJSON(constellation).toJSONString();
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

    //@WebMethod(operationName = "getConstellations4constellation_neighbourConstellation")
    @Override
    public String getConstellations4constellation_neighbourConstellation(String json) {
        BLconstellation blconstellation = new BLconstellation();
        JSONParser parser = new JSONParser();
        Constellation constellation;
        try {
            String result = null;
            IConstellation_neighbourPK constellation_neighbourConstellationPK = JSONConstellation_neighbour.toConstellation_neighbourPK((JSONObject)parser.parse(json));
            constellation = (Constellation)blconstellation.getConstellation_neighbourconstellation(constellation_neighbourConstellationPK);
            if(constellation!=null) {
                result = JSONConstellation.toJSON(constellation).toJSONString();
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

