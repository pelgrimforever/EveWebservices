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
import eve.entity.pk.ContractitemPK;
import eve.interfaces.entity.pk.IContractitemPK;
import eve.interfaces.logicentity.IContractitem;
import eve.logicentity.Contractitem;
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
public class JSONContractitem {
    
    public static JSONArray toJSONArray(ArrayList contractitems) {
        JSONArray jsoncontractitems = new JSONArray();
        Iterator contractitemsI = contractitems.iterator();
        while(contractitemsI.hasNext()) {
            jsoncontractitems.add(toJSON((Contractitem)contractitemsI.next()));
        }
        return jsoncontractitems;
    }

    public static JSONObject toJSON(IContractitemPK contractitemPK) {
        JSONObject json = null;
        if(contractitemPK!=null) {
            json = new JSONObject();
            json.put("id", String.valueOf(contractitemPK.getId()));
        }
        return json;
    }

    public static JSONObject toJSON(IContractitem contractitem) {
        JSONObject json = new JSONObject();
        json.put("PK", toJSON(contractitem.getPrimaryKey()));
        json.put("evetypePK", JSONEvetype.toJSON(contractitem.getEvetypePK()));
        json.put("contractPK", JSONContract.toJSON(contractitem.getContractPK()));
        json.put("blueprint_copy", contractitem.getBlueprint_copy());
        json.put("included", contractitem.getIncluded());
        json.put("quantity", String.valueOf(contractitem.getQuantity()));
        json.put("material_efficiency", contractitem.getMaterial_efficiency());
        json.put("runs", contractitem.getRuns());
        json.put("time_efficiency", contractitem.getTime_efficiency());
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    public static JSONObject toJSON(Contractitemsearch contractitemsearch) {
        JSONObject json = new JSONObject();
        if(contractitemsearch.used()) {
            byte andoroperator = contractitemsearch.getAndoroperator();
            int maxresults = contractitemsearch.getMaxresults();
            boolean docount = contractitemsearch.getDocount();
            Iterator<EntityPK> primarykeysI = contractitemsearch.getPrimarykeys().iterator();
            Iterator<Fieldsearcher> fieldsearchersI = contractitemsearch.getFieldsearchers().iterator();
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
            if(contractitemsearch.getEvetypesearch()!=null && contractitemsearch.getEvetypesearch().used()) {
                kss.put("evetypesearcher", JSONEvetype.toJSON((Evetypesearch)contractitemsearch.getEvetypesearch()));
            }
            if(contractitemsearch.getContractsearch()!=null && contractitemsearch.getContractsearch().used()) {
                kss.put("contractsearcher", JSONContract.toJSON((Contractsearch)contractitemsearch.getContractsearch()));
            }
            json.put("keysearch", kss);
        }
        return json;
    }

    public static Contractitemsearch toContractitemsearch(JSONObject json) {
        Contractitemsearch contractitemsearch = new Contractitemsearch();
        contractitemsearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        contractitemsearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        contractitemsearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONArray pks = (JSONArray)json.get("primarykeys");
        for(int i=0; i<pks.size(); i++) {
            contractitemsearch.addPrimarykey(ContractitemPK.getKey((String)pks.get(i)));
        }
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("id");
        if(field!=null) {
            long[] valuearray = JSONConversion.getLongvalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            contractitemsearch.id(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("blueprint_copy");
        if(field!=null) {
            boolean value = JSONConversion.getBooleanvalue(field);
            contractitemsearch.blueprint_copy(value);
        }
        field = (JSONObject)fss.get("included");
        if(field!=null) {
            boolean value = JSONConversion.getBooleanvalue(field);
            contractitemsearch.included(value);
        }
        field = (JSONObject)fss.get("quantity");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            contractitemsearch.quantity(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("material_efficiency");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            contractitemsearch.material_efficiency(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("runs");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            contractitemsearch.runs(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("time_efficiency");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            contractitemsearch.time_efficiency(valuearray, operators, andor);
        }
        JSONObject kss = (JSONObject)json.get("keysearch");
        JSONArray keysearch;
        keysearch = (JSONArray)kss.get("evetypesearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Evetypesearch evetypesearch = JSONEvetype.toEvetypesearch((JSONObject)keysearch.get(i));
                contractitemsearch.evetype(evetypesearch);
            }
        }
        keysearch = (JSONArray)kss.get("contractsearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Contractsearch contractsearch = JSONContract.toContractsearch((JSONObject)keysearch.get(i));
                contractitemsearch.contract(contractsearch);
            }
        }
        return contractitemsearch;
    }
    
    public static ContractitemPK toContractitemPK(JSONObject json) {
        ContractitemPK contractitemPK = null;
        if(json!=null) {
            contractitemPK = new ContractitemPK(JSONConversion.getlong(json, "id"));
        }
        return contractitemPK;
    }

    public static Contractitem toContractitem(JSONObject json) {
        Contractitem contractitem = new Contractitem(toContractitemPK((JSONObject)json.get("PK")));
        updateContractitem(contractitem, json);
        return contractitem;
    }

    public static void updateContractitem(IContractitem contractitem, JSONObject json) {
        contractitem.setEvetypePK(JSONEvetype.toEvetypePK((JSONObject)json.get("evetypePK")));
        contractitem.setContractPK(JSONContract.toContractPK((JSONObject)json.get("contractPK")));
        contractitem.setBlueprint_copy(JSONConversion.getboolean(json, "blueprint_copy"));
        contractitem.setIncluded(JSONConversion.getboolean(json, "included"));
        contractitem.setQuantity(JSONConversion.getlong(json, "quantity"));
        contractitem.setMaterial_efficiency(JSONConversion.getint(json, "material_efficiency"));
        contractitem.setRuns(JSONConversion.getint(json, "runs"));
        contractitem.setTime_efficiency(JSONConversion.getint(json, "time_efficiency"));
    }

    public static Contractitem initContractitem(JSONObject json) {
        Contractitem contractitem = new Contractitem(toContractitemPK((JSONObject)json.get("PK")));
        contractitem.initEvetypePK(JSONEvetype.toEvetypePK((JSONObject)json.get("evetypePK")));
        contractitem.initContractPK(JSONContract.toContractPK((JSONObject)json.get("contractPK")));
        contractitem.initBlueprint_copy(JSONConversion.getboolean(json, "blueprint_copy"));
        contractitem.initIncluded(JSONConversion.getboolean(json, "included"));
        contractitem.initQuantity(JSONConversion.getlong(json, "quantity"));
        contractitem.initMaterial_efficiency(JSONConversion.getint(json, "material_efficiency"));
        contractitem.initRuns(JSONConversion.getint(json, "runs"));
        contractitem.initTime_efficiency(JSONConversion.getint(json, "time_efficiency"));
        return contractitem;
    }
}

