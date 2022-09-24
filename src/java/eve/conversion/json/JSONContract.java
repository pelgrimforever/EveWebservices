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
import eve.entity.pk.ContractPK;
import eve.interfaces.entity.pk.IContractPK;
import eve.interfaces.logicentity.IContract;
import eve.logicentity.Contract;
import eve.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSONContract {
    
    public static JSONArray toJSONArray(ArrayList contracts) {
        JSONArray jsoncontracts = new JSONArray();
        Iterator contractsI = contracts.iterator();
        while(contractsI.hasNext()) {
            jsoncontracts.add(toJSON((Contract)contractsI.next()));
        }
        return jsoncontracts;
    }

    public static JSONObject toJSON(IContractPK contractPK) {
        JSONObject json = null;
        if(contractPK!=null) {
            json = new JSONObject();
            json.put("id", String.valueOf(contractPK.getId()));
        }
        return json;
    }

    public static JSONObject toJSON(IContract contract) {
        JSONObject json = new JSONObject();
        json.put("PK", toJSON(contract.getPrimaryKey()));
        json.put("collateral", contract.getCollateral());
        if(contract.getDate_expired()!=null) {
	        json.put("date_expired", contract.getDate_expired().getTime());
        }
        if(contract.getDate_issued()!=null) {
	        json.put("date_issued", contract.getDate_issued().getTime());
        }
        json.put("days_to_complete", contract.getDays_to_complete());
        json.put("end_location_id", String.valueOf(contract.getEnd_location_id()));
        json.put("for_corporation", contract.getFor_corporation());
        json.put("price", contract.getPrice());
        json.put("reward", contract.getReward());
        json.put("start_location_id", String.valueOf(contract.getStart_location_id()));
        json.put("title", contract.getTitle());
        json.put("type", contract.getType());
        json.put("volume", contract.getVolume());
        json.put("page", contract.getPage());
        json.put("active", contract.getActive());
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    public static JSONObject toJSON(Contractsearch contractsearch) {
        JSONObject json = new JSONObject();
        if(contractsearch.used()) {
            byte andoroperator = contractsearch.getAndoroperator();
            int maxresults = contractsearch.getMaxresults();
            boolean docount = contractsearch.getDocount();
            Iterator<EntityPK> primarykeysI = contractsearch.getPrimarykeys().iterator();
            Iterator<Fieldsearcher> fieldsearchersI = contractsearch.getFieldsearchers().iterator();
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
            json.put("keysearch", kss);
        }
        return json;
    }

    public static Contractsearch toContractsearch(JSONObject json) {
        Contractsearch contractsearch = new Contractsearch();
        contractsearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        contractsearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        contractsearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONArray pks = (JSONArray)json.get("primarykeys");
        for(int i=0; i<pks.size(); i++) {
            contractsearch.addPrimarykey(ContractPK.getKey((String)pks.get(i)));
        }
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("id");
        if(field!=null) {
            long[] valuearray = JSONConversion.getLongvalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            contractsearch.id(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("collateral");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            contractsearch.collateral(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("date_expired");
        if(field!=null) {
            Timestamp[] valuearray = JSONConversion.getTimestampvalues(field);
            byte[] operators = JSONConversion.getTimeoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            contractsearch.date_expired(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("date_issued");
        if(field!=null) {
            Timestamp[] valuearray = JSONConversion.getTimestampvalues(field);
            byte[] operators = JSONConversion.getTimeoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            contractsearch.date_issued(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("days_to_complete");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            contractsearch.days_to_complete(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("end_location_id");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            contractsearch.end_location_id(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("for_corporation");
        if(field!=null) {
            boolean value = JSONConversion.getBooleanvalue(field);
            contractsearch.for_corporation(value);
        }
        field = (JSONObject)fss.get("price");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            contractsearch.price(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("reward");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            contractsearch.reward(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("start_location_id");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            contractsearch.start_location_id(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("title");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            contractsearch.title(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("type");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            contractsearch.type(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("volume");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            contractsearch.volume(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("page");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            contractsearch.page(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("active");
        if(field!=null) {
            boolean value = JSONConversion.getBooleanvalue(field);
            contractsearch.active(value);
        }
        JSONObject kss = (JSONObject)json.get("keysearch");
        JSONArray keysearch;
        return contractsearch;
    }
    
    public static ContractPK toContractPK(JSONObject json) {
        ContractPK contractPK = null;
        if(json!=null) {
            contractPK = new ContractPK(JSONConversion.getlong(json, "id"));
        }
        return contractPK;
    }

    public static Contract toContract(JSONObject json) {
        Contract contract = new Contract(toContractPK((JSONObject)json.get("PK")));
        updateContract(contract, json);
        return contract;
    }

    public static void updateContract(IContract contract, JSONObject json) {
        contract.setCollateral(JSONConversion.getdouble(json, "collateral"));
        contract.setDate_expired(JSONConversion.getTimestamp(json, "date_expired"));
        contract.setDate_issued(JSONConversion.getTimestamp(json, "date_issued"));
        contract.setDays_to_complete(JSONConversion.getint(json, "days_to_complete"));
        contract.setEnd_location_id(JSONConversion.getlong(json, "end_location_id"));
        contract.setFor_corporation(JSONConversion.getboolean(json, "for_corporation"));
        contract.setPrice(JSONConversion.getdouble(json, "price"));
        contract.setReward(JSONConversion.getdouble(json, "reward"));
        contract.setStart_location_id(JSONConversion.getlong(json, "start_location_id"));
        contract.setTitle(JSONConversion.getString(json, "title"));
        contract.setType(JSONConversion.getString(json, "type"));
        contract.setVolume(JSONConversion.getdouble(json, "volume"));
        contract.setPage(JSONConversion.getint(json, "page"));
        contract.setActive(JSONConversion.getboolean(json, "active"));
    }

    public static Contract initContract(JSONObject json) {
        Contract contract = new Contract(toContractPK((JSONObject)json.get("PK")));
        contract.initCollateral(JSONConversion.getdouble(json, "collateral"));
        contract.initDate_expired(JSONConversion.getTimestamp(json, "date_expired"));
        contract.initDate_issued(JSONConversion.getTimestamp(json, "date_issued"));
        contract.initDays_to_complete(JSONConversion.getint(json, "days_to_complete"));
        contract.initEnd_location_id(JSONConversion.getlong(json, "end_location_id"));
        contract.initFor_corporation(JSONConversion.getboolean(json, "for_corporation"));
        contract.initPrice(JSONConversion.getdouble(json, "price"));
        contract.initReward(JSONConversion.getdouble(json, "reward"));
        contract.initStart_location_id(JSONConversion.getlong(json, "start_location_id"));
        contract.initTitle(JSONConversion.getString(json, "title"));
        contract.initType(JSONConversion.getString(json, "type"));
        contract.initVolume(JSONConversion.getdouble(json, "volume"));
        contract.initPage(JSONConversion.getint(json, "page"));
        contract.initActive(JSONConversion.getboolean(json, "active"));
        return contract;
    }
}

