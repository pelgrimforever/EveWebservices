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
import eve.entity.pk.FrontendpagePK;
import eve.interfaces.entity.pk.IFrontendpagePK;
import eve.interfaces.logicentity.IFrontendpage;
import eve.logicentity.Frontendpage;
import eve.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSONFrontendpage {
    
    public static JSONArray toJSONArray(ArrayList frontendpages) {
        JSONArray jsonfrontendpages = new JSONArray();
        Iterator frontendpagesI = frontendpages.iterator();
        while(frontendpagesI.hasNext()) {
            jsonfrontendpages.add(toJSON((Frontendpage)frontendpagesI.next()));
        }
        return jsonfrontendpages;
    }

    public static JSONObject toJSON(IFrontendpagePK frontendpagePK) {
        JSONObject json = null;
        if(frontendpagePK!=null) {
            json = new JSONObject();
            json.put("name", frontendpagePK.getName());
        }
        return json;
    }

    public static JSONObject toJSON(IFrontendpage frontendpage) {
        JSONObject json = new JSONObject();
        json.put("PK", toJSON(frontendpage.getPrimaryKey()));
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    public static JSONObject toJSON(Frontendpagesearch frontendpagesearch) {
        JSONObject json = new JSONObject();
        if(frontendpagesearch.used()) {
            byte andoroperator = frontendpagesearch.getAndoroperator();
            int maxresults = frontendpagesearch.getMaxresults();
            boolean docount = frontendpagesearch.getDocount();
            Iterator<EntityPK> primarykeysI = frontendpagesearch.getPrimarykeys().iterator();
            Iterator<Fieldsearcher> fieldsearchersI = frontendpagesearch.getFieldsearchers().iterator();
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
            if(frontendpagesearch.getFrontendpage_authsearch()!=null && frontendpagesearch.getFrontendpage_authsearch().used()) {
                kss.put("frontendpage_authsearcher", JSONFrontendpage_auth.toJSON((Frontendpage_authsearch)frontendpagesearch.getFrontendpage_authsearch()));
            }
            if(frontendpagesearch.getRelEveusersearch()!=null && frontendpagesearch.getRelEveusersearch().used()) {
                kss.put("eveusersearcher", JSONFrontendpage_auth.toJSON((Frontendpage_authsearch)frontendpagesearch.getRelEveusersearch()));
            }
            json.put("keysearch", kss);
        }
        return json;
    }

    public static Frontendpagesearch toFrontendpagesearch(JSONObject json) {
        Frontendpagesearch frontendpagesearch = new Frontendpagesearch();
        frontendpagesearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        frontendpagesearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        frontendpagesearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONArray pks = (JSONArray)json.get("primarykeys");
        for(int i=0; i<pks.size(); i++) {
            frontendpagesearch.addPrimarykey(FrontendpagePK.getKey((String)pks.get(i)));
        }
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("name");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            frontendpagesearch.name(valuearray, compareoperator, andor);
        }
        JSONObject kss = (JSONObject)json.get("keysearch");
        JSONArray keysearch;
        keysearch = (JSONArray)kss.get("frontendpage_authsearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Frontendpage_authsearch frontendpage_authsearch = JSONFrontendpage_auth.toFrontendpage_authsearch((JSONObject)keysearch.get(i));
                frontendpagesearch.frontendpage_auth(frontendpage_authsearch);
            }
        }
        keysearch = (JSONArray)kss.get("eveusersearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Eveusersearch eveusersearch = JSONEveuser.toEveusersearch((JSONObject)keysearch.get(i));
                frontendpagesearch.releveuser(eveusersearch);
            }
        }
        return frontendpagesearch;
    }
    
    public static FrontendpagePK toFrontendpagePK(JSONObject json) {
        FrontendpagePK frontendpagePK = null;
        if(json!=null) {
            frontendpagePK = new FrontendpagePK(JSONConversion.getString(json, "name"));
        }
        return frontendpagePK;
    }

    public static Frontendpage toFrontendpage(JSONObject json) {
        Frontendpage frontendpage = new Frontendpage(toFrontendpagePK((JSONObject)json.get("PK")));
        updateFrontendpage(frontendpage, json);
        return frontendpage;
    }

    public static void updateFrontendpage(IFrontendpage frontendpage, JSONObject json) {
    }

    public static Frontendpage initFrontendpage(JSONObject json) {
        Frontendpage frontendpage = new Frontendpage(toFrontendpagePK((JSONObject)json.get("PK")));
        return frontendpage;
    }
}

