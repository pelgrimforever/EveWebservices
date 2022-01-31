/*
 * JSONUserbp.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 29.0.2022 18:3
 *
 */
 
package eve.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.interfaces.db.EntityPK;
import data.interfaces.db.Fieldsearcher;
import data.json.piJson;
import eve.entity.pk.UserbpPK;
import eve.interfaces.entity.pk.IUserbpPK;
import eve.interfaces.logicentity.IUserbp;
import eve.logicentity.Userbp;
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
public class JSONUserbp {
    
    public static JSONArray toJSONArray(ArrayList userbps) {
        JSONArray jsonuserbps = new JSONArray();
        Iterator userbpsI = userbps.iterator();
        while(userbpsI.hasNext()) {
            jsonuserbps.add(toJSON((Userbp)userbpsI.next()));
        }
        return jsonuserbps;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(IUserbpPK userbpPK) {
        JSONObject json = null;
        if(userbpPK!=null) {
            json = new JSONObject();
            json.put("username", userbpPK.getUsername());
            json.put("bp", String.valueOf(userbpPK.getBp()));
            json.put("serialnumber", userbpPK.getSerialnumber());
        }
        return json;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(IUserbp userbp) {
        JSONObject json = new JSONObject();
        json.put("PK", toJSON(userbp.getPrimaryKey()));
        json.put("original", userbp.getOriginal());
        json.put("materialefficiency", userbp.getMaterialefficiency());
        json.put("amountproduced", userbp.getAmountproduced());
        json.put("totalamount", userbp.getTotalamount());
        json.put("bpprice", userbp.getBpprice());
        json.put("researchcost", userbp.getResearchcost());
        json.put("stationfee", userbp.getStationfee());
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(Userbpsearch userbpsearch) {
        JSONObject json = new JSONObject();
        if(userbpsearch.used()) {
            byte andoroperator = userbpsearch.getAndoroperator();
            int maxresults = userbpsearch.getMaxresults();
            boolean docount = userbpsearch.getDocount();
            Iterator<EntityPK> primarykeysI = userbpsearch.getPrimarykeys().iterator();
            Iterator<Fieldsearcher> fieldsearchersI = userbpsearch.getFieldsearchers().iterator();
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
            if(userbpsearch.getEvetypesearch()!=null && userbpsearch.getEvetypesearch().used()) {
                kss.put("evetypesearcher", JSONEvetype.toJSON((Evetypesearch)userbpsearch.getEvetypesearch()));
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
    public static Userbpsearch toUserbpsearch(JSONObject json) {
        Userbpsearch userbpsearch = new Userbpsearch();
        userbpsearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        userbpsearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        userbpsearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONArray pks = (JSONArray)json.get("primarykeys");
        for(int i=0; i<pks.size(); i++) {
            userbpsearch.addPrimarykey(UserbpPK.getKey((String)pks.get(i)));
        }
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("username");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            userbpsearch.username(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("serialnumber");
        if(field!=null) {
            long[] valuearray = JSONConversion.getLongvalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            userbpsearch.serialnumber(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("original");
        if(field!=null) {
            boolean value = JSONConversion.getBooleanvalue(field);
            userbpsearch.original(value);
        }
        field = (JSONObject)fss.get("materialefficiency");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            userbpsearch.materialefficiency(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("amountproduced");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            userbpsearch.amountproduced(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("totalamount");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            userbpsearch.totalamount(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("bpprice");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            userbpsearch.bpprice(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("researchcost");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            userbpsearch.researchcost(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("stationfee");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            userbpsearch.stationfee(valuearray, operators, andor);
        }
        JSONObject kss = (JSONObject)json.get("keysearch");
        JSONArray keysearch;
        keysearch = (JSONArray)kss.get("evetypesearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Evetypesearch evetypesearch = JSONEvetype.toEvetypesearch((JSONObject)keysearch.get(i));
                userbpsearch.evetype(evetypesearch);
            }
        }
        return userbpsearch;
    }
    
    public static UserbpPK toUserbpPK(JSONObject json) {
        UserbpPK userbpPK = null;
        if(json!=null) {
            userbpPK = new UserbpPK(JSONConversion.getString(json, "username"), JSONConversion.getlong(json, "bp"), JSONConversion.getint(json, "serialnumber"));
        }
        return userbpPK;
    }

    public static Userbp toUserbp(JSONObject json) {
        Userbp userbp = new Userbp(toUserbpPK((JSONObject)json.get("PK")));
        updateUserbp(userbp, json);
        return userbp;
    }

    public static void updateUserbp(IUserbp userbp, JSONObject json) {
        userbp.setOriginal(JSONConversion.getboolean(json, "original"));
        userbp.setMaterialefficiency(JSONConversion.getint(json, "materialefficiency"));
        userbp.setAmountproduced(JSONConversion.getint(json, "amountproduced"));
        userbp.setTotalamount(JSONConversion.getint(json, "totalamount"));
        userbp.setBpprice(JSONConversion.getdouble(json, "bpprice"));
        userbp.setResearchcost(JSONConversion.getdouble(json, "researchcost"));
        userbp.setStationfee(JSONConversion.getdouble(json, "stationfee"));
    }

    public static Userbp initUserbp(JSONObject json) {
        Userbp userbp = new Userbp(toUserbpPK((JSONObject)json.get("PK")));
        userbp.initOriginal(JSONConversion.getboolean(json, "original"));
        userbp.initMaterialefficiency(JSONConversion.getint(json, "materialefficiency"));
        userbp.initAmountproduced(JSONConversion.getint(json, "amountproduced"));
        userbp.initTotalamount(JSONConversion.getint(json, "totalamount"));
        userbp.initBpprice(JSONConversion.getdouble(json, "bpprice"));
        userbp.initResearchcost(JSONConversion.getdouble(json, "researchcost"));
        userbp.initStationfee(JSONConversion.getdouble(json, "stationfee"));
        return userbp;
    }
}

