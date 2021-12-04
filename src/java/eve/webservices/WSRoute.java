/*
 * WSRoute.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 4.11.2021 14:51
 *
 */

package eve.webservices;

import eve.BusinessObject.Logic.*;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.webservice.WSIRoute;
import eve.logicentity.Route;
import eve.searchentity.Routesearch;
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
@WebService(endpointInterface = "eve.interfaces.webservice.WSIRoute")
public class WSRoute implements WSIRoute {

    private JSONArray toJSONArray(ArrayList routes) {
        JSONArray jsonroutes = new JSONArray();
        Iterator routesI = routes.iterator();
        while(routesI.hasNext()) {
            jsonroutes.add(JSONRoute.toJSON((Route)routesI.next()));
        }
        return jsonroutes;
    }

    /**
     * Web service operation
     */
    //@WebMethod(operationName = "getRoutes")
    @Override
    public String getRoutes() {
        try {
            BLroute blroute = new BLroute();
            ArrayList routes = blroute.getAll();
            JSONArray jsonroutes = toJSONArray(routes);
            return jsonroutes.toJSONString();
        }
        catch(DBException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String json) {
        BLroute blroute = new BLroute();
        JSONParser parser = new JSONParser();
        String result = "";
        Route route;
        try {
            Routesearch routesearch = JSONRoute.toRoutesearch((JSONObject)parser.parse(json));
            ArrayList routes = blroute.search(routesearch);
            JSONArray jsonroutes = toJSONArray(routes);
            result = jsonroutes.toJSONString();
        }
        catch(ParseException e) {
            result = "";
        }
        catch(DBException e) {
            result = "";
        }
        return result;
    }

    //@WebMethod(operationName = "getRoute")
    @Override
    public String getRoute(String json) {
        BLroute blroute = new BLroute();
        JSONParser parser = new JSONParser();
        String result = "";
        Route route;
        try {
            RoutePK routePK = JSONRoute.toRoutePK((JSONObject)parser.parse(json));
            route = blroute.getRoute(routePK);
            if(route!=null) {
                result = JSONRoute.toJSON(route).toJSONString();
            }
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
        return result;
    }

    //@WebMethod(operationName = "insertRoute")
    @Override
    public void insertRoute(String json) {
        BLroute blroute = new BLroute();
        JSONParser parser = new JSONParser();
        try {
            IRoute route = JSONRoute.toRoute((JSONObject)parser.parse(json));
            blroute.insertRoute(route);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "updateRoute")
    @Override
    public void updateRoute(String json) {
        BLroute blroute = new BLroute();
        JSONParser parser = new JSONParser();
        try {
            IRoute route = JSONRoute.toRoute((JSONObject)parser.parse(json));
            blroute.updateRoute(route);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "deleteRoute")
    @Override
    public void deleteRoute(String json) {
        BLroute blroute = new BLroute();
        JSONParser parser = new JSONParser();
        try {
            IRoute route = JSONRoute.toRoute((JSONObject)parser.parse(json));
            blroute.deleteRoute(route);
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "getRoutes4routetype")
    @Override
    public String getRoutes4routetype(String json) {
        BLroute blroute = new BLroute();
        JSONParser parser = new JSONParser();
        Route route;
        try {
            IRoutetypePK routetypePK = JSONRoutetype.toRoutetypePK((JSONObject)parser.parse(json));
            ArrayList routes = blroute.getRoutes4routetype(routetypePK);
            JSONArray jsonroutes = toJSONArray(routes);
            return jsonroutes.toJSONString();
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

    //@WebMethod(operationName = "delete4routetype")
    @Override
    public void delete4routetype(String json) {
        BLroute blroute = new BLroute();
        JSONParser parser = new JSONParser();
        Route route;
        try {
            IRoutetypePK routetypePK = JSONRoutetype.toRoutetypePK((JSONObject)parser.parse(json));
            blroute.delete4routetype(routetypePK);
        }
        catch(ParseException e) {
        }
    }

    //@WebMethod(operationName = "getRoutes4system")
    @Override
    public String getRoutes4system(String json) {
        BLroute blroute = new BLroute();
        JSONParser parser = new JSONParser();
        Route route;
        try {
            ISystemPK systemPK = JSONSystem.toSystemPK((JSONObject)parser.parse(json));
            ArrayList routes = blroute.getRoutes4system(systemPK);
            JSONArray jsonroutes = toJSONArray(routes);
            return jsonroutes.toJSONString();
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

    //@WebMethod(operationName = "delete4system")
    @Override
    public void delete4system(String json) {
        BLroute blroute = new BLroute();
        JSONParser parser = new JSONParser();
        Route route;
        try {
            ISystemPK systemPK = JSONSystem.toSystemPK((JSONObject)parser.parse(json));
            blroute.delete4system(systemPK);
        }
        catch(ParseException e) {
        }
    }


}

