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
import eve.interfaces.searchentity.IBpmaterialsearch;
import eve.interfaces.webservice.WSIBpmaterial;
import eve.logicentity.Bpmaterial;
import eve.searchentity.Bpmaterialsearch;
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

@WebService(endpointInterface = "eve.interfaces.webservice.WSIBpmaterial")
public class WSBpmaterial extends RS_json_login implements WSIBpmaterial {

    private Security_usecases security_usecases = new Security_usecases();
    
    private JSONArray toJSONArray(ArrayList bpmaterials) {
        JSONArray jsonbpmaterials = new JSONArray();
        Iterator bpmaterialsI = bpmaterials.iterator();
        while(bpmaterialsI.hasNext()) {
            jsonbpmaterials.add(JSONBpmaterial.toJSON((Bpmaterial)bpmaterialsI.next()));
        }
        return jsonbpmaterials;
    }

    //@WebMethod(operationName = "getBpmaterials")
    @Override
    public String getBpmaterials() {
        try {
            Bpmaterial_usecases bpmaterialusecases = new Bpmaterial_usecases(loggedin);
            return get_all_bpmaterial(bpmaterialusecases);
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
            Bpmaterial_usecases bpmaterialusecases = new Bpmaterial_usecases(loggedin);
            return search_bpmaterial(bpmaterialusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getBpmaterial")
    @Override
    public String getBpmaterial(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Bpmaterial_usecases bpmaterialusecases = new Bpmaterial_usecases(loggedin);
            return get_bpmaterial_with_primarykey(bpmaterialusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "insertBpmaterial")
    @Override
    public void insertBpmaterial(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Bpmaterial_usecases bpmaterialusecases = new Bpmaterial_usecases(loggedin);
            insert_bpmaterial(bpmaterialusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "updateBpmaterial")
    @Override
    public void updateBpmaterial(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Bpmaterial_usecases bpmaterialusecases = new Bpmaterial_usecases(loggedin);
            update_bpmaterial(bpmaterialusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "deleteBpmaterial")
    @Override
    public void deleteBpmaterial(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Bpmaterial_usecases bpmaterialusecases = new Bpmaterial_usecases(loggedin);
            delete_bpmaterial(bpmaterialusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getBpmaterials4evetypeBp")
    @Override
    public String getBpmaterials4evetypeBp(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Bpmaterial_usecases bpmaterialusecases = new Bpmaterial_usecases(loggedin);
            return get_bpmaterial_with_foreignkey_evetypeBp(bpmaterialusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4evetypeBp")
    @Override
    public void delete4evetypeBp(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Bpmaterial_usecases bpmaterialusecases = new Bpmaterial_usecases(loggedin);
            delete_bpmaterial(bpmaterialusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getBpmaterials4evetypeMaterial")
    @Override
    public String getBpmaterials4evetypeMaterial(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Bpmaterial_usecases bpmaterialusecases = new Bpmaterial_usecases(loggedin);
            return get_bpmaterial_with_foreignkey_evetypeMaterial(bpmaterialusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4evetypeMaterial")
    @Override
    public void delete4evetypeMaterial(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Bpmaterial_usecases bpmaterialusecases = new Bpmaterial_usecases(loggedin);
            delete_bpmaterial(bpmaterialusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }


    private String count_records(Bpmaterial_usecases bpmaterialusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", bpmaterialusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_bpmaterial(Bpmaterial_usecases bpmaterialusecases) throws ParseException, CustomException {
    	return JSONBpmaterial.toJSONArray(bpmaterialusecases.get_all()).toJSONString();
    }
    
    private String get_bpmaterial_with_primarykey(Bpmaterial_usecases bpmaterialusecases, JSONObject json) throws ParseException, CustomException {
        IBpmaterialPK bpmaterialPK = (IBpmaterialPK)JSONBpmaterial.toBpmaterialPK((JSONObject)json.get("bpmaterialpk"));
	return JSONBpmaterial.toJSON(bpmaterialusecases.get_bpmaterial_by_primarykey(bpmaterialPK)).toJSONString();
    }
    
    private String get_bpmaterial_with_foreignkey_evetypeBp(Bpmaterial_usecases bpmaterialusecases, JSONObject json) throws ParseException, CustomException {
        IEvetypePK evetypeBpPK = (IEvetypePK)JSONEvetype.toEvetypePK((JSONObject)json.get("evetypepk"));
        return JSONBpmaterial.toJSONArray(bpmaterialusecases.get_bpmaterial_with_foreignkey_evetypeBp(evetypeBpPK)).toJSONString();
    }
    
    private String get_bpmaterial_with_foreignkey_evetypeMaterial(Bpmaterial_usecases bpmaterialusecases, JSONObject json) throws ParseException, CustomException {
        IEvetypePK evetypeMaterialPK = (IEvetypePK)JSONEvetype.toEvetypePK((JSONObject)json.get("evetypepk"));
        return JSONBpmaterial.toJSONArray(bpmaterialusecases.get_bpmaterial_with_foreignkey_evetypeMaterial(evetypeMaterialPK)).toJSONString();
    }
    
    private String search_bpmaterial(Bpmaterial_usecases bpmaterialusecases, JSONObject json) throws ParseException, CustomException {
        IBpmaterialsearch search = (IBpmaterialsearch)JSONBpmaterial.toBpmaterialsearch((JSONObject)json.get("search"));
        return JSONBpmaterial.toJSONArray(bpmaterialusecases.search_bpmaterial(search)).toJSONString();
    }
    
    private String search_bpmaterial_count(Bpmaterial_usecases bpmaterialusecases, JSONObject json) throws ParseException, CustomException {
        IBpmaterialsearch bpmaterialsearch = (IBpmaterialsearch)JSONBpmaterial.toBpmaterialsearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", bpmaterialusecases.search_bpmaterial_count(bpmaterialsearch));
        return jsonsearchcount.toJSONString();
    }

    private void insert_bpmaterial(Bpmaterial_usecases bpmaterialusecases, JSONObject json) throws ParseException, CustomException {
        IBpmaterial bpmaterial = (IBpmaterial)JSONBpmaterial.toBpmaterial((JSONObject)json.get("bpmaterial"));
        bpmaterialusecases.insertBpmaterial(bpmaterial);
        setReturnstatus("OK");
    }

    private void update_bpmaterial(Bpmaterial_usecases bpmaterialusecases, JSONObject json) throws ParseException, CustomException {
        IBpmaterial bpmaterial = (IBpmaterial)JSONBpmaterial.toBpmaterial((JSONObject)json.get("bpmaterial"));
        bpmaterialusecases.updateBpmaterial(bpmaterial);
        setReturnstatus("OK");
    }

    private void delete_bpmaterial(Bpmaterial_usecases bpmaterialusecases, JSONObject json) throws ParseException, CustomException {
        IBpmaterial bpmaterial = (IBpmaterial)JSONBpmaterial.toBpmaterial((JSONObject)json.get("bpmaterial"));
        bpmaterialusecases.deleteBpmaterial(bpmaterial);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Evetypebp(Bpmaterial_usecases bpmaterialusecases, JSONObject json) throws ParseException, CustomException {
        IEvetypePK evetypeBpPK = (IEvetypePK)JSONEvetype.toEvetypePK((JSONObject)json.get("evetypepk"));
        bpmaterialusecases.delete_all_containing_Evetypebp(evetypeBpPK);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Evetypematerial(Bpmaterial_usecases bpmaterialusecases, JSONObject json) throws ParseException, CustomException {
        IEvetypePK evetypeMaterialPK = (IEvetypePK)JSONEvetype.toEvetypePK((JSONObject)json.get("evetypepk"));
        bpmaterialusecases.delete_all_containing_Evetypematerial(evetypeMaterialPK);
        setReturnstatus("OK");
    }

}

