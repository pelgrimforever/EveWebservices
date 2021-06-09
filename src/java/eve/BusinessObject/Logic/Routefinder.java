/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eve.BusinessObject.Logic;

import data.json.piJsonarray;
import eve.logicentity.Route;
import java.util.HashMap;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author pelgrim
 */
public class Routefinder {
    
    private long routetype;
    private long systemid;
    private JSONArray jsonroute;
    private HashMap<Long, JSONObject> routenode = new HashMap<>();
    
    public Routefinder(Route route) {
        routetype = route.getPrimaryKey().getRoutetype();
        systemid = route.getPrimaryKey().getSystem();
        jsonroute = ((piJsonarray)route.getJsonroutes()).getJSONArray();
        //route always starts with 1 rootnode in the top array
        JSONObject jsonnode = (JSONObject)jsonroute.get(0);
        routenode.put((Long)jsonnode.get("id"), jsonnode);
        loadChildren((JSONArray)jsonnode.get("jsonchildren"));
    }
    
    public void loadChildren(JSONArray jsonchildren) {
        if(jsonchildren!=null) {
            Iterator<JSONObject> childrenI = jsonchildren.iterator();
            JSONObject node;
            while(childrenI.hasNext()) {
                node = childrenI.next();
                routenode.put((Long)node.get("id"), node);
                loadChildren((JSONArray)node.get("jsonchildren"));
            }
        }
    }
    
    public JSONObject getSystem(Long systemid) {
        return routenode.get(systemid);
    }
    
    public int getJumps(Long destinationid) {
        int jumps = -1;
        JSONObject jsonroutenode = getSystem(destinationid);
        if(jsonroutenode!=null) {
            jumps = ((Long)jsonroutenode.get("jumps")).intValue();
        }
        return jumps;
    }
    
}
