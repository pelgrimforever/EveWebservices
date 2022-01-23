/*
 * JSONMaterialinput.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 19.0.2022 21:56
 *
 */
 
package eve.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.interfaces.db.EntityPK;
import data.interfaces.db.Fieldsearcher;
import data.json.piJson;
import eve.entity.pk.MaterialinputPK;
import eve.interfaces.entity.pk.IMaterialinputPK;
import eve.interfaces.logicentity.IMaterialinput;
import eve.logicentity.Materialinput;
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
public class JSONMaterialinput {
    
    public static JSONArray toJSONArray(ArrayList materialinputs) {
        JSONArray jsonmaterialinputs = new JSONArray();
        Iterator materialinputsI = materialinputs.iterator();
        while(materialinputsI.hasNext()) {
            jsonmaterialinputs.add(toJSON((Materialinput)materialinputsI.next()));
        }
        return jsonmaterialinputs;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(IMaterialinputPK materialinputPK) {
        JSONObject json = null;
        if(materialinputPK!=null) {
            json = new JSONObject();
            json.put("username", materialinputPK.getUsername());
            json.put("evetype", String.valueOf(materialinputPK.getEvetype()));
            if(materialinputPK.getAddtimestamp()!=null) {
                json.put("addtimestamp", materialinputPK.getAddtimestamp().getTime());
            }
        }
        return json;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(IMaterialinput materialinput) {
        JSONObject json = new JSONObject();
        json.put("PK", toJSON(materialinput.getPrimaryKey()));
        json.put("amount", String.valueOf(materialinput.getAmount()));
        json.put("unitprice", materialinput.getUnitprice());
        json.put("usedamount", String.valueOf(materialinput.getUsedamount()));
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(Materialinputsearch materialinputsearch) {
        JSONObject json = new JSONObject();
        if(materialinputsearch.used()) {
            byte andoroperator = materialinputsearch.getAndoroperator();
            int maxresults = materialinputsearch.getMaxresults();
            boolean docount = materialinputsearch.getDocount();
            Iterator<EntityPK> primarykeysI = materialinputsearch.getPrimarykeys().iterator();
            Iterator<Fieldsearcher> fieldsearchersI = materialinputsearch.getFieldsearchers().iterator();
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
            if(materialinputsearch.getEvetypesearch()!=null && materialinputsearch.getEvetypesearch().used()) {
                kss.put("evetypesearcher", JSONEvetype.toJSON((Evetypesearch)materialinputsearch.getEvetypesearch()));
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
    public static Materialinputsearch toMaterialinputsearch(JSONObject json) {
        Materialinputsearch materialinputsearch = new Materialinputsearch();
        materialinputsearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        materialinputsearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        materialinputsearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONArray pks = (JSONArray)json.get("primarykeys");
        for(int i=0; i<pks.size(); i++) {
            materialinputsearch.addPrimarykey(MaterialinputPK.getKey((String)pks.get(i)));
        }
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("username");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            materialinputsearch.username(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("addtimestamp");
        if(field!=null) {
            Timestamp[] valuearray = JSONConversion.getTimestampvalues(field);
            byte[] operators = JSONConversion.getTimeoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            materialinputsearch.addtimestamp(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("amount");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            materialinputsearch.amount(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("unitprice");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            materialinputsearch.unitprice(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("usedamount");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            materialinputsearch.usedamount(valuearray, operators, andor);
        }
        JSONObject kss = (JSONObject)json.get("keysearch");
        JSONArray keysearch;
        keysearch = (JSONArray)kss.get("evetypesearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Evetypesearch evetypesearch = JSONEvetype.toEvetypesearch((JSONObject)keysearch.get(i));
                materialinputsearch.evetype(evetypesearch);
            }
        }
        return materialinputsearch;
    }
    
    public static MaterialinputPK toMaterialinputPK(JSONObject json) {
        MaterialinputPK materialinputPK = null;
        if(json!=null) {
            materialinputPK = new MaterialinputPK(JSONConversion.getString(json, "username"), JSONConversion.getlong(json, "evetype"), JSONConversion.getTimestamp(json, "addtimestamp"));
        }
        return materialinputPK;
    }

    public static Materialinput toMaterialinput(JSONObject json) {
        Materialinput materialinput = new Materialinput(toMaterialinputPK((JSONObject)json.get("PK")));
        updateMaterialinput(materialinput, json);
        return materialinput;
    }

    public static void updateMaterialinput(IMaterialinput materialinput, JSONObject json) {
        materialinput.setAmount(JSONConversion.getlong(json, "amount"));
        materialinput.setUnitprice(JSONConversion.getdouble(json, "unitprice"));
        materialinput.setUsedamount(JSONConversion.getlong(json, "usedamount"));
    }

    public static Materialinput initMaterialinput(JSONObject json) {
        Materialinput materialinput = new Materialinput(toMaterialinputPK((JSONObject)json.get("PK")));
        materialinput.initAmount(JSONConversion.getlong(json, "amount"));
        materialinput.initUnitprice(JSONConversion.getdouble(json, "unitprice"));
        materialinput.initUsedamount(JSONConversion.getlong(json, "usedamount"));
        return materialinput;
    }
}

