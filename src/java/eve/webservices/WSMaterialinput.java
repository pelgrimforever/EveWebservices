/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */

package eve.webservices;

import base.restservices.RS_json_login;
import eve.BusinessObject.Logic.*;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.IMaterialinputsearch;
import eve.interfaces.webservice.WSIMaterialinput;
import eve.logicentity.Materialinput;
import eve.searchentity.Materialinputsearch;
import eve.usecases.*;
import general.exception.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.jws.WebMethod;
import javax.jws.WebService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import eve.usecases.custom.Security_usecases;

@WebService(endpointInterface = "eve.interfaces.webservice.WSIMaterialinput")
public class WSMaterialinput extends RS_json_login implements WSIMaterialinput {

    private Security_usecases security_usecases = new Security_usecases();
    
    private JSONArray toJSONArray(ArrayList materialinputs) {
        JSONArray jsonmaterialinputs = new JSONArray();
        Iterator materialinputsI = materialinputs.iterator();
        while(materialinputsI.hasNext()) {
            jsonmaterialinputs.add(JSONMaterialinput.toJSON((Materialinput)materialinputsI.next()));
        }
        return jsonmaterialinputs;
    }

    //@WebMethod(operationName = "getMaterialinputs")
    @Override
    public String getMaterialinputs() {
        try {
            Materialinput_usecases materialinputusecases = new Materialinput_usecases(loggedin);
            return get_all_materialinput(materialinputusecases);
        }
        catch(CustomException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Materialinput_usecases materialinputusecases = new Materialinput_usecases(loggedin);
            return search_materialinput(materialinputusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getMaterialinput")
    @Override
    public String getMaterialinput(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Materialinput_usecases materialinputusecases = new Materialinput_usecases(loggedin);
            return get_materialinput_with_primarykey(materialinputusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "insertMaterialinput")
    @Override
    public void insertMaterialinput(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Materialinput_usecases materialinputusecases = new Materialinput_usecases(loggedin);
            insert_materialinput(materialinputusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "updateMaterialinput")
    @Override
    public void updateMaterialinput(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Materialinput_usecases materialinputusecases = new Materialinput_usecases(loggedin);
            update_materialinput(materialinputusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "deleteMaterialinput")
    @Override
    public void deleteMaterialinput(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Materialinput_usecases materialinputusecases = new Materialinput_usecases(loggedin);
            delete_materialinput(materialinputusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getMaterialinputs4evetype")
    @Override
    public String getMaterialinputs4evetype(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Materialinput_usecases materialinputusecases = new Materialinput_usecases(loggedin);
            return get_materialinput_with_foreignkey_evetype(materialinputusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4evetype")
    @Override
    public void delete4evetype(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Materialinput_usecases materialinputusecases = new Materialinput_usecases(loggedin);
            delete_materialinput(materialinputusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }


    private String count_records(Materialinput_usecases materialinputusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", materialinputusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_materialinput(Materialinput_usecases materialinputusecases) throws ParseException, CustomException {
    	return JSONMaterialinput.toJSONArray(materialinputusecases.get_all()).toJSONString();
    }
    
    private String get_materialinput_with_primarykey(Materialinput_usecases materialinputusecases, JSONObject json) throws ParseException, CustomException {
        IMaterialinputPK materialinputPK = (IMaterialinputPK)JSONMaterialinput.toMaterialinputPK((JSONObject)json.get("materialinputpk"));
	return JSONMaterialinput.toJSON(materialinputusecases.get_materialinput_by_primarykey(materialinputPK)).toJSONString();
    }
    
    private String get_materialinput_with_foreignkey_evetype(Materialinput_usecases materialinputusecases, JSONObject json) throws ParseException, CustomException {
        IEvetypePK evetypePK = (IEvetypePK)JSONEvetype.toEvetypePK((JSONObject)json.get("evetypepk"));
        return JSONMaterialinput.toJSONArray(materialinputusecases.get_materialinput_with_foreignkey_evetype(evetypePK)).toJSONString();
    }
    
    private String search_materialinput(Materialinput_usecases materialinputusecases, JSONObject json) throws ParseException, CustomException {
        IMaterialinputsearch search = (IMaterialinputsearch)JSONMaterialinput.toMaterialinputsearch((JSONObject)json.get("search"));
        return JSONMaterialinput.toJSONArray(materialinputusecases.search_materialinput(search)).toJSONString();
    }
    
    private String search_materialinput_count(Materialinput_usecases materialinputusecases, JSONObject json) throws ParseException, CustomException {
        IMaterialinputsearch materialinputsearch = (IMaterialinputsearch)JSONMaterialinput.toMaterialinputsearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", materialinputusecases.search_materialinput_count(materialinputsearch));
        return jsonsearchcount.toJSONString();
    }

    private void insert_materialinput(Materialinput_usecases materialinputusecases, JSONObject json) throws ParseException, CustomException {
        IMaterialinput materialinput = (IMaterialinput)JSONMaterialinput.toMaterialinput((JSONObject)json.get("materialinput"));
        materialinputusecases.insertMaterialinput(materialinput);
        setReturnstatus("OK");
    }

    private void update_materialinput(Materialinput_usecases materialinputusecases, JSONObject json) throws ParseException, CustomException {
        IMaterialinput materialinput = (IMaterialinput)JSONMaterialinput.toMaterialinput((JSONObject)json.get("materialinput"));
        materialinputusecases.updateMaterialinput(materialinput);
        setReturnstatus("OK");
    }

    private void delete_materialinput(Materialinput_usecases materialinputusecases, JSONObject json) throws ParseException, CustomException {
        IMaterialinput materialinput = (IMaterialinput)JSONMaterialinput.toMaterialinput((JSONObject)json.get("materialinput"));
        materialinputusecases.deleteMaterialinput(materialinput);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Evetype(Materialinput_usecases materialinputusecases, JSONObject json) throws ParseException, CustomException {
        IEvetypePK evetypePK = (IEvetypePK)JSONEvetype.toEvetypePK((JSONObject)json.get("evetypepk"));
        materialinputusecases.delete_all_containing_Evetype(evetypePK);
        setReturnstatus("OK");
    }

}

