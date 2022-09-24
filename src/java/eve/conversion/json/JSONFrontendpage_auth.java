/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */
 
package eve.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.interfaces.db.EntityPK;
import data.interfaces.db.Fieldsearcher;
import data.json.piJson;
import eve.entity.pk.Frontendpage_authPK;
import eve.interfaces.entity.pk.IFrontendpage_authPK;
import eve.interfaces.logicentity.IFrontendpage_auth;
import eve.logicentity.Frontendpage_auth;
import eve.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSONFrontendpage_auth {
    
    public static JSONArray toJSONArray(ArrayList frontendpage_auths) {
        JSONArray jsonfrontendpage_auths = new JSONArray();
        Iterator frontendpage_authsI = frontendpage_auths.iterator();
        while(frontendpage_authsI.hasNext()) {
            jsonfrontendpage_auths.add(toJSON((Frontendpage_auth)frontendpage_authsI.next()));
        }
        return jsonfrontendpage_auths;
    }

    public static JSONObject toJSON(IFrontendpage_authPK frontendpage_authPK) {
        JSONObject json = null;
        if(frontendpage_authPK!=null) {
            json = new JSONObject();
            json.put("username", frontendpage_authPK.getUsername());
            json.put("frontendpage", frontendpage_authPK.getFrontendpage());
        }
        return json;
    }

    public static JSONObject toJSON(IFrontendpage_auth frontendpage_auth) {
        JSONObject json = new JSONObject();
        json.put("PK", toJSON(frontendpage_auth.getPrimaryKey()));
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    public static JSONObject toJSON(Frontendpage_authsearch frontendpage_authsearch) {
        JSONObject json = new JSONObject();
        if(frontendpage_authsearch.used()) {
            byte andoroperator = frontendpage_authsearch.getAndoroperator();
            int maxresults = frontendpage_authsearch.getMaxresults();
            boolean docount = frontendpage_authsearch.getDocount();
            Iterator<EntityPK> primarykeysI = frontendpage_authsearch.getPrimarykeys().iterator();
            Iterator<Fieldsearcher> fieldsearchersI = frontendpage_authsearch.getFieldsearchers().iterator();
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
            if(frontendpage_authsearch.getFrontendpagesearch()!=null && frontendpage_authsearch.getFrontendpagesearch().used()) {
                kss.put("frontendpagesearcher", JSONFrontendpage.toJSON((Frontendpagesearch)frontendpage_authsearch.getFrontendpagesearch()));
            }
            if(frontendpage_authsearch.getEveusersearch()!=null && frontendpage_authsearch.getEveusersearch().used()) {
                kss.put("eveusersearcher", JSONEveuser.toJSON((Eveusersearch)frontendpage_authsearch.getEveusersearch()));
            }
            json.put("keysearch", kss);
        }
        return json;
    }

    public static Frontendpage_authsearch toFrontendpage_authsearch(JSONObject json) {
        Frontendpage_authsearch frontendpage_authsearch = new Frontendpage_authsearch();
        frontendpage_authsearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        frontendpage_authsearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        frontendpage_authsearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONArray pks = (JSONArray)json.get("primarykeys");
        for(int i=0; i<pks.size(); i++) {
            frontendpage_authsearch.addPrimarykey(Frontendpage_authPK.getKey((String)pks.get(i)));
        }
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        JSONObject kss = (JSONObject)json.get("keysearch");
        JSONArray keysearch;
        keysearch = (JSONArray)kss.get("frontendpagesearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Frontendpagesearch frontendpagesearch = JSONFrontendpage.toFrontendpagesearch((JSONObject)keysearch.get(i));
                frontendpage_authsearch.frontendpage(frontendpagesearch);
            }
        }
        keysearch = (JSONArray)kss.get("eveusersearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Eveusersearch eveusersearch = JSONEveuser.toEveusersearch((JSONObject)keysearch.get(i));
                frontendpage_authsearch.eveuser(eveusersearch);
            }
        }
        return frontendpage_authsearch;
    }
    
    public static Frontendpage_authPK toFrontendpage_authPK(JSONObject json) {
        Frontendpage_authPK frontendpage_authPK = null;
        if(json!=null) {
            frontendpage_authPK = new Frontendpage_authPK(JSONConversion.getString(json, "username"), JSONConversion.getString(json, "frontendpage"));
        }
        return frontendpage_authPK;
    }

    public static Frontendpage_auth toFrontendpage_auth(JSONObject json) {
        Frontendpage_auth frontendpage_auth = new Frontendpage_auth(toFrontendpage_authPK((JSONObject)json.get("PK")));
        updateFrontendpage_auth(frontendpage_auth, json);
        return frontendpage_auth;
    }

    public static void updateFrontendpage_auth(IFrontendpage_auth frontendpage_auth, JSONObject json) {
    }

    public static Frontendpage_auth initFrontendpage_auth(JSONObject json) {
        Frontendpage_auth frontendpage_auth = new Frontendpage_auth(toFrontendpage_authPK((JSONObject)json.get("PK")));
        return frontendpage_auth;
    }
}

