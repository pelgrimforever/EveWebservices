package eve.usecases.custom;

import data.conversion.JSONConversion;
import eve.data.Swagger;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * @author Franky Laseure
 */
public class Swagger_route_usecases {
    
    public Swagger_route_usecases() {
    }
    
    public ArrayList<Long> getRoute_usecase(long origin, long destination, ArrayList<Long> avoidsystems, boolean secure) {
        JSONArray swaggerroute = Swagger.getRoute(origin, destination, avoidsystems, secure);
        return transform_routeJSON_to_ArrayList(swaggerroute);        
    }

    private ArrayList<Long> transform_routeJSON_to_ArrayList(JSONArray jsonroute) {
        ArrayList<Long> route = new ArrayList<>();
        Iterator<Long> jsonrouteI = jsonroute.iterator();
        while(jsonrouteI.hasNext())
            route.add((long)jsonrouteI.next());
        return route;
    }

    public ArrayList<Systemkill_data> getSystemkills_usecase() {
        ArrayList<Systemkill_data> systemkills = new ArrayList<Systemkill_data>();
        JSONArray jsonsystemkills = Swagger.getSystemkills();
        Iterator<JSONObject> jsonsystemkillsI = jsonsystemkills.iterator();
        while(jsonsystemkillsI.hasNext())
            systemkills.add(transform_systemkillsJSON_to_Systemkill_data(jsonsystemkillsI.next()));
        return systemkills;
    }
    
    private Systemkill_data transform_systemkillsJSON_to_Systemkill_data(JSONObject json) {
        Systemkill_data data = new Systemkill_data();
        data.setSystem_id(JSONConversion.getLong(json, "system_id"));
        data.setNpc_kills(JSONConversion.getint(json, "npc_kills"));
        data.setPod_kills(JSONConversion.getint(json, "pod_kills"));
        data.setShip_kills(JSONConversion.getint(json, "ship_kills"));
        return data;
    }
    
    public class Systemkill_data {
        long system_id;
        int npc_kills;
        int pod_kills;
        int ship_kills;

        public long getSystem_id() {
            return system_id;
        }

        public void setSystem_id(long system_id) {
            this.system_id = system_id;
        }

        public int getNpc_kills() {
            return npc_kills;
        }

        public void setNpc_kills(int npc_kills) {
            this.npc_kills = npc_kills;
        }

        public int getPod_kills() {
            return pod_kills;
        }

        public void setPod_kills(int pod_kills) {
            this.pod_kills = pod_kills;
        }

        public int getShip_kills() {
            return ship_kills;
        }

        public void setShip_kills(int ship_kills) {
            this.ship_kills = ship_kills;
        }
    }
    
    public ArrayList<EveGatecheck_data> getGatecheck_for_systems_usecase(ArrayList systems) {
        ArrayList<EveGatecheck_data> evegatechecks = new ArrayList<>();
        JSONObject jsongatechecks = Swagger.getEveGatecheck(systems);
        Iterator<String> jsongatecheckI = jsongatechecks.keySet().iterator();
        String key;
        while(jsongatecheckI.hasNext())
            validate_and_transform_gatecheckJSON_to_EveGatecheck_data(evegatechecks, jsongatecheckI.next(), jsongatechecks);
        return evegatechecks;
    }
    
    public void validate_and_transform_gatecheckJSON_to_EveGatecheck_data(ArrayList<EveGatecheck_data> evegatechecks, String key, JSONObject jsongatechecks) {
        try {
            Long.valueOf(key);
            String systemid = String.valueOf(key);
            evegatechecks.add(transform_gatecheckJSON_to_EveGatecheck_data(systemid, jsongatechecks));
        }
        catch(Exception e) {
        }
    }
    
    public EveGatecheck_data transform_gatecheckJSON_to_EveGatecheck_data(String systemid, JSONObject jsongatechecks) {
        EveGatecheck_data data = new EveGatecheck_data();
        data.setSystem_id(Long.valueOf(systemid));
        JSONObject gatecheck = (JSONObject)jsongatechecks.get(systemid);
        JSONObject kills = (JSONObject)gatecheck.get("kills");
        data.setKillmails(JSONConversion.getint(kills, "killCount"));
        data.setKillmailgatekills(JSONConversion.getint(kills, "gateKillCount"));
        data.setKillmaildata((JSONObject)kills.get("data"));
        return data;
    }

    public class EveGatecheck_data {
        long system_id;
        int killmails;
        int killmailgatekills;
        JSONObject killmaildata;

        public long getSystem_id() {
            return system_id;
        }

        public void setSystem_id(long system_id) {
            this.system_id = system_id;
        }

        public int getKillmails() {
            return killmails;
        }

        public void setKillmails(int killmails) {
            this.killmails = killmails;
        }

        public int getKillmailgatekills() {
            return killmailgatekills;
        }

        public void setKillmailgatekills(int killmailgatekills) {
            this.killmailgatekills = killmailgatekills;
        }

        public JSONObject getKillmaildata() {
            return killmaildata;
        }

        public void setKillmaildata(JSONObject killmaildata) {
            this.killmaildata = killmaildata;
        }
        
        
    }
}
