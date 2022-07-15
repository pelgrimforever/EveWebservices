/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 13.6.2022 11:21
 */
 
package eve.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.interfaces.db.EntityPK;
import data.interfaces.db.Fieldsearcher;
import data.json.piJson;
import eve.entity.pk.BpmaterialPK;
import eve.interfaces.entity.pk.IBpmaterialPK;
import eve.interfaces.logicentity.IBpmaterial;
import eve.logicentity.Bpmaterial;
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
public class JSONBpmaterial {
    
    public static JSONArray toJSONArray(ArrayList bpmaterials) {
        JSONArray jsonbpmaterials = new JSONArray();
        Iterator bpmaterialsI = bpmaterials.iterator();
        while(bpmaterialsI.hasNext()) {
            jsonbpmaterials.add(toJSON((Bpmaterial)bpmaterialsI.next()));
        }
        return jsonbpmaterials;
    }

    public static JSONObject toJSON(IBpmaterialPK bpmaterialPK) {
        JSONObject json = null;
        if(bpmaterialPK!=null) {
            json = new JSONObject();
            json.put("bp", String.valueOf(bpmaterialPK.getBp()));
            json.put("material", String.valueOf(bpmaterialPK.getMaterial()));
        }
        return json;
    }

    public static JSONObject toJSON(IBpmaterial bpmaterial) {
        JSONObject json = new JSONObject();
        json.put("PK", toJSON(bpmaterial.getPrimaryKey()));
        json.put("amount", String.valueOf(bpmaterial.getAmount()));
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    public static JSONObject toJSON(Bpmaterialsearch bpmaterialsearch) {
        JSONObject json = new JSONObject();
        if(bpmaterialsearch.used()) {
            byte andoroperator = bpmaterialsearch.getAndoroperator();
            int maxresults = bpmaterialsearch.getMaxresults();
            boolean docount = bpmaterialsearch.getDocount();
            Iterator<EntityPK> primarykeysI = bpmaterialsearch.getPrimarykeys().iterator();
            Iterator<Fieldsearcher> fieldsearchersI = bpmaterialsearch.getFieldsearchers().iterator();
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
            if(bpmaterialsearch.getEvetypebpsearch()!=null && bpmaterialsearch.getEvetypebpsearch().used()) {
                kss.put("evetypeBpsearcher", JSONEvetype.toJSON((Evetypesearch)bpmaterialsearch.getEvetypebpsearch()));
            }
            if(bpmaterialsearch.getEvetypematerialsearch()!=null && bpmaterialsearch.getEvetypematerialsearch().used()) {
                kss.put("evetypeMaterialsearcher", JSONEvetype.toJSON((Evetypesearch)bpmaterialsearch.getEvetypematerialsearch()));
            }
            json.put("keysearch", kss);
        }
        return json;
    }

    public static Bpmaterialsearch toBpmaterialsearch(JSONObject json) {
        Bpmaterialsearch bpmaterialsearch = new Bpmaterialsearch();
        bpmaterialsearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        bpmaterialsearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        bpmaterialsearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONArray pks = (JSONArray)json.get("primarykeys");
        for(int i=0; i<pks.size(); i++) {
            bpmaterialsearch.addPrimarykey(BpmaterialPK.getKey((String)pks.get(i)));
        }
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("amount");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            bpmaterialsearch.amount(valuearray, operators, andor);
        }
        JSONObject kss = (JSONObject)json.get("keysearch");
        JSONArray keysearch;
        keysearch = (JSONArray)kss.get("evetypeBpsearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Evetypesearch evetypeBpsearch = JSONEvetype.toEvetypesearch((JSONObject)keysearch.get(i));
                bpmaterialsearch.evetypeBp(evetypeBpsearch);
            }
        }
        keysearch = (JSONArray)kss.get("evetypeMaterialsearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Evetypesearch evetypeMaterialsearch = JSONEvetype.toEvetypesearch((JSONObject)keysearch.get(i));
                bpmaterialsearch.evetypeMaterial(evetypeMaterialsearch);
            }
        }
        return bpmaterialsearch;
    }
    
    public static BpmaterialPK toBpmaterialPK(JSONObject json) {
        BpmaterialPK bpmaterialPK = null;
        if(json!=null) {
            bpmaterialPK = new BpmaterialPK(JSONConversion.getlong(json, "bp"), JSONConversion.getlong(json, "material"));
        }
        return bpmaterialPK;
    }

    public static Bpmaterial toBpmaterial(JSONObject json) {
        Bpmaterial bpmaterial = new Bpmaterial(toBpmaterialPK((JSONObject)json.get("PK")));
        updateBpmaterial(bpmaterial, json);
        return bpmaterial;
    }

    public static void updateBpmaterial(IBpmaterial bpmaterial, JSONObject json) {
        bpmaterial.setAmount(JSONConversion.getlong(json, "amount"));
    }

    public static Bpmaterial initBpmaterial(JSONObject json) {
        Bpmaterial bpmaterial = new Bpmaterial(toBpmaterialPK((JSONObject)json.get("PK")));
        bpmaterial.initAmount(JSONConversion.getlong(json, "amount"));
        return bpmaterial;
    }
}

