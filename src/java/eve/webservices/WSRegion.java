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


}

