/*
 * WSRegion.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 6.9.2021 16:29
 *
 */

package eve.webservices;

import eve.BusinessObject.Logic.*;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.webservice.WSIRegion;
import eve.logicentity.Region;
import eve.searchentity.Regionsearch;
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
@WebService(endpointInterface = "eve.interfaces.webservice.WSIRegion")
public class WSRegion implements WSIRegion {

    private JSONArray toJSONArray(ArrayList regions) {
        JSONArray jsonregions = new JSONArray();
        Iterator regionsI = regions.iterator();
        while(regionsI.hasNext()) {
            jsonregions.add(JSONRegion.toJSON((Region)regionsI.next()));
        }
        return jsonregions;
    }

    /**
     * Web service operation
     */
    //@WebMethod(operationName = "getRegions")
    @Override
    public String getRegions() {
        try {
            BLregion blregion = new BLregion();
            ArrayList regions = blregion.getAll();
            JSONArray jsonregions = toJSONArray(regions);
            return jsonregions.toJSONString();
        }
        catch(DBException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String json) {
        BLregion blregion = new BLregion();
        JSONParser parser = new JSONParser();
        String result = "";
        Region region;
        try {
            Regionsearch regionsearch = JSONRegion.toRegionsearch((JSONObject)parser.parse(json));
            ArrayList regions = blregion.search(regionsearch);
            JSONArray jsonregions = toJSONArray(regions);
            result = jsonregions.toJSONString();
        }
        catch(ParseException e) {
            result = "";
        }
        catch(DBException e) {
            result = "";
        }
        return result;
    }

    //@WebMethod(operationName = "getRegion")
    @Override
    public String getRegion(String json) {
        BLregion blregion = new BLregion();
        JSONParser parser = new JSONParser();
        String result = "";
        Region region;
        try {
            RegionPK regionPK = JSONRegion.toRegionPK((JSONObject)parser.parse(json));
            region = blregion.getRegion(regionPK);
            if(region!=null) {
                result = JSONRegion.toJSON(region).toJSONString();
            }
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
        return result;
    }

    //@WebMethod(operationName = "insertRegion")
    @Override
    public void insertRegion(String json) {
        BLregion blregion = new BLregion();
        JSONParser parser = new JSONParser();
        try {
            IRegion region = JSONRegion.toRegion((JSONObject)parser.parse(json));
            blregion.insertRegion(region);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "updateRegion")
    @Override
    public void updateRegion(String json) {
        BLregion blregion = new BLregion();
        JSONParser parser = new JSONParser();
        try {
            IRegion region = JSONRegion.toRegion((JSONObject)parser.parse(json));
            blregion.updateRegion(region);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "deleteRegion")
    @Override
    public void deleteRegion(String json) {
        BLregion blregion = new BLregion();
        JSONParser parser = new JSONParser();
        try {
            IRegion region = JSONRegion.toRegion((JSONObject)parser.parse(json));
            blregion.deleteRegion(region);
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "getRegions4order_history")
    @Override
    public String getRegions4order_history(String json) {
        BLregion blregion = new BLregion();
        JSONParser parser = new JSONParser();
        Region region;
        try {
            String result = null;
            IOrder_historyPK order_historyPK = JSONOrder_history.toOrder_historyPK((JSONObject)parser.parse(json));
            region = (Region)blregion.getOrder_history(order_historyPK);
            if(region!=null) {
                result = JSONRegion.toJSON(region).toJSONString();
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

    //@WebMethod(operationName = "getRegions4region_neighbourRegion")
    @Override
    public String getRegions4region_neighbourRegion(String json) {
        BLregion blregion = new BLregion();
        JSONParser parser = new JSONParser();
        Region region;
        try {
            String result = null;
            IRegion_neighbourPK region_neighbourRegionPK = JSONRegion_neighbour.toRegion_neighbourPK((JSONObject)parser.parse(json));
            region = (Region)blregion.getRegion_neighbourregion(region_neighbourRegionPK);
            if(region!=null) {
                result = JSONRegion.toJSON(region).toJSONString();
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

    //@WebMethod(operationName = "getRegions4region_neighbourNeighbour")
    @Override
    public String getRegions4region_neighbourNeighbour(String json) {
        BLregion blregion = new BLregion();
        JSONParser parser = new JSONParser();
        Region region;
        try {
            String result = null;
            IRegion_neighbourPK region_neighbourNeighbourPK = JSONRegion_neighbour.toRegion_neighbourPK((JSONObject)parser.parse(json));
            region = (Region)blregion.getRegion_neighbourneighbour(region_neighbourNeighbourPK);
            if(region!=null) {
                result = JSONRegion.toJSON(region).toJSONString();
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

