/*
 * JSONRoute.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 30.10.2021 10:3
 *
 */
 
package eve.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.interfaces.db.EntityPK;
import data.interfaces.db.Fieldsearcher;
import data.json.piJson;
import eve.entity.pk.RoutePK;
import eve.interfaces.entity.pk.IRoutePK;
import eve.interfaces.logicentity.IRoute;
import eve.logicentity.Route;
import eve.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * JSON fields are by default ignored
 * @author Franky Laseure
 */
public class JSONRoute {
    
    public static JSONArray toJSONArray(ArrayList routes) {
        JSONArray jsonroutes = new JSONArray();
        Iterator routesI = routes.iterator();
        while(routesI.hasNext()) {
            jsonroutes.add(toJSON((Route)routesI.next()));
        }
        return jsonroutes;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(IRoutePK routePK) {
        JSONObject json = null;
        if(routePK!=null) {
            json = new JSONObject();
            json.put("routetype", String.valueOf(routePK.getRoutetype()));
            json.put("system", String.valueOf(routePK.getSystem()));
        }
        return json;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(IRoute route) {
        JSONObject json = new JSONObject();
        json.put("PK", toJSON(route.getPrimaryKey()));
        if(route.getJsonroutes()!=null) {
            json.put("jsonroutes", "");
        }
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(Routesearch routesearch) {
        JSONObject json = new JSONObject();
        if(routesearch.used()) {
            byte andoroperator = routesearch.getAndoroperator();
            int maxresults = routesearch.getMaxresults();
            boolean docount = routesearch.getDocount();
            Iterator<EntityPK> primarykeysI = routesearch.getPrimarykeys().iterator();
            Iterator<Fieldsearcher> fieldsearchersI = routesearch.getFieldsearchers().iterator();
            EntityPK primarykey;
            Fieldsearcher fieldsearcher;
            
            json.put("andor", andoroperator);
            json.put("maxresults", maxresults);
            json.put("docount", docount);
            JSONArray pks = new JSONArray();
            int i = 0;
            while(primarykeysI.hasNext()) {
                primarykey = primarykeysI.next();
                pks.add(primarykey.getKeystring());
            }
            json.put("primarykeys", pks);
            JSONObject fss = new JSONObject();
            while(fieldsearchersI.hasNext()) {
                fieldsearcher = fieldsearchersI.next();
                if(fieldsearcher.used()) {
                    fss.put(fieldsearcher.getShortFieldname(), JSONConversion.toJSON(fieldsearcher));
                }
            }
            json.put("fields", fss);
            JSONObject kss = new JSONObject();
            if(routesearch.getRoutetypesearch()!=null && routesearch.getRoutetypesearch().used()) {
                kss.put("routetypesearcher", JSONRoutetype.toJSON((Routetypesearch)routesearch.getRoutetypesearch()));
            }
            if(routesearch.getSystemsearch()!=null && routesearch.getSystemsearch().used()) {
                kss.put("systemsearcher", JSONSystem.toJSON((Systemsearch)routesearch.getSystemsearch()));
            }
            json.put("keysearch", kss);
        }
        return json;
    }

    /**
     * 
     * @param json: JSONObject with the Filmsearch parameters
     * @return 
     */
    public static Routesearch toRoutesearch(JSONObject json) {
        Routesearch routesearch = new Routesearch();
        routesearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        routesearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        routesearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONArray pks = (JSONArray)json.get("primarykeys");
        for(int i=0; i<pks.size(); i++) {
            routesearch.addPrimarykey(RoutePK.getKey((String)pks.get(i)));
        }
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        JSONObject kss = (JSONObject)json.get("keysearch");
        JSONArray keysearch;
        keysearch = (JSONArray)kss.get("routetypesearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Routetypesearch routetypesearch = JSONRoutetype.toRoutetypesearch((JSONObject)keysearch.get(i));
                routesearch.routetype(routetypesearch);
            }
        }
        keysearch = (JSONArray)kss.get("systemsearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Systemsearch systemsearch = JSONSystem.toSystemsearch((JSONObject)keysearch.get(i));
                routesearch.system(systemsearch);
            }
        }
        return routesearch;
    }
    
    public static RoutePK toRoutePK(JSONObject json) {
        RoutePK routePK = null;
        if(json!=null) {
            routePK = new RoutePK(JSONConversion.getlong(json, "routetype"), JSONConversion.getlong(json, "system"));
        }
        return routePK;
    }

    public static Route toRoute(JSONObject json) {
        Route route = new Route(toRoutePK((JSONObject)json.get("PK")));
        updateRoute(route, json);
        return route;
    }

    public static void updateRoute(IRoute route, JSONObject json) {
    }

    public static Route initRoute(JSONObject json) {
        Route route = new Route(toRoutePK((JSONObject)json.get("PK")));
        return route;
    }
}

