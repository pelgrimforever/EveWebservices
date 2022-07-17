/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 17.6.2022 13:4
 */
 
package eve.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.interfaces.db.EntityPK;
import data.interfaces.db.Fieldsearcher;
import data.json.piJson;
import eve.entity.pk.EveuserPK;
import eve.interfaces.entity.pk.IEveuserPK;
import eve.interfaces.logicentity.IEveuser;
import eve.logicentity.Eveuser;
import eve.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * @author Franky Laseure
 */
public class JSONEveuser {
    
    public static JSONArray toJSONArray(ArrayList eveusers) {
        JSONArray jsoneveusers = new JSONArray();
        Iterator eveusersI = eveusers.iterator();
        while(eveusersI.hasNext()) {
            jsoneveusers.add(toJSON((Eveuser)eveusersI.next()));
        }
        return jsoneveusers;
    }

    public static JSONObject toJSON(IEveuserPK eveuserPK) {
        JSONObject json = null;
        if(eveuserPK!=null) {
            json = new JSONObject();
            json.put("username", eveuserPK.getUsername());
        }
        return json;
    }

    public static JSONObject toJSON(IEveuser eveuser) {
        JSONObject json = new JSONObject();
        json.put("PK", toJSON(eveuser.getPrimaryKey()));
        if(eveuser.getCreatedat()!=null) {
	        json.put("createdat", eveuser.getCreatedat().getTime());
        }
        json.put("admin", eveuser.getAdmin());
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    public static JSONObject toJSON(Eveusersearch eveusersearch) {
        JSONObject json = new JSONObject();
        if(eveusersearch.used()) {
            byte andoroperator = eveusersearch.getAndoroperator();
            int maxresults = eveusersearch.getMaxresults();
            boolean docount = eveusersearch.getDocount();
            Iterator<EntityPK> primarykeysI = eveusersearch.getPrimarykeys().iterator();
            Iterator<Fieldsearcher> fieldsearchersI = eveusersearch.getFieldsearchers().iterator();
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
            if(eveusersearch.getFrontendpage_authsearch()!=null && eveusersearch.getFrontendpage_authsearch().used()) {
                kss.put("frontendpage_authsearcher", JSONFrontendpage_auth.toJSON((Frontendpage_authsearch)eveusersearch.getFrontendpage_authsearch()));
            }
            if(eveusersearch.getRelFrontendpagesearch()!=null && eveusersearch.getRelFrontendpagesearch().used()) {
                kss.put("frontendpagesearcher", JSONFrontendpage_auth.toJSON((Frontendpage_authsearch)eveusersearch.getRelFrontendpagesearch()));
            }
            json.put("keysearch", kss);
        }
        return json;
    }

    public static Eveusersearch toEveusersearch(JSONObject json) {
        Eveusersearch eveusersearch = new Eveusersearch();
        eveusersearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        eveusersearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        eveusersearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONArray pks = (JSONArray)json.get("primarykeys");
        for(int i=0; i<pks.size(); i++) {
            eveusersearch.addPrimarykey(EveuserPK.getKey((String)pks.get(i)));
        }
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("username");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            eveusersearch.username(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("createdat");
        if(field!=null) {
            Date[] valuearray = JSONConversion.getDatevalues(field);
            byte[] operators = JSONConversion.getDateoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            eveusersearch.createdat(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("admin");
        if(field!=null) {
            boolean value = JSONConversion.getBooleanvalue(field);
            eveusersearch.admin(value);
        }
        JSONObject kss = (JSONObject)json.get("keysearch");
        JSONArray keysearch;
        keysearch = (JSONArray)kss.get("frontendpage_authsearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Frontendpage_authsearch frontendpage_authsearch = JSONFrontendpage_auth.toFrontendpage_authsearch((JSONObject)keysearch.get(i));
                eveusersearch.frontendpage_auth(frontendpage_authsearch);
            }
        }
        keysearch = (JSONArray)kss.get("frontendpagesearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Frontendpagesearch frontendpagesearch = JSONFrontendpage.toFrontendpagesearch((JSONObject)keysearch.get(i));
                eveusersearch.relfrontendpage(frontendpagesearch);
            }
        }
        return eveusersearch;
    }
    
    public static EveuserPK toEveuserPK(JSONObject json) {
        EveuserPK eveuserPK = null;
        if(json!=null) {
            eveuserPK = new EveuserPK(JSONConversion.getString(json, "username"));
        }
        return eveuserPK;
    }

    public static Eveuser toEveuser(JSONObject json) {
        Eveuser eveuser = new Eveuser(toEveuserPK((JSONObject)json.get("PK")));
        updateEveuser(eveuser, json);
        return eveuser;
    }

    public static void updateEveuser(IEveuser eveuser, JSONObject json) {
        eveuser.setCreatedat(JSONConversion.getDate(json, "createdat"));
        eveuser.setAdmin(JSONConversion.getboolean(json, "admin"));
    }

    public static Eveuser initEveuser(JSONObject json) {
        Eveuser eveuser = new Eveuser(toEveuserPK((JSONObject)json.get("PK")));
        eveuser.initCreatedat(JSONConversion.getDate(json, "createdat"));
        eveuser.initAdmin(JSONConversion.getboolean(json, "admin"));
        return eveuser;
    }
}

