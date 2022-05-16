/*
 * WSEveuser.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 11.4.2022 9:13
 *
 */

package eve.webservices;

import eve.BusinessObject.Logic.*;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.webservice.WSIEveuser;
import eve.logicentity.Eveuser;
import eve.searchentity.Eveusersearch;
import general.exception.CustomException;
import general.exception.DataException;
import general.exception.DBException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.jws.WebMethod;
import javax.jws.WebService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Franky Laseure
 */
@WebService(endpointInterface = "eve.interfaces.webservice.WSIEveuser")
public class WSEveuser implements WSIEveuser {

    private JSONArray toJSONArray(ArrayList eveusers) {
        JSONArray jsoneveusers = new JSONArray();
        Iterator eveusersI = eveusers.iterator();
        while(eveusersI.hasNext()) {
            jsoneveusers.add(JSONEveuser.toJSON((Eveuser)eveusersI.next()));
        }
        return jsoneveusers;
    }

    /**
     * Web service operation
     */
    //@WebMethod(operationName = "getEveusers")
    @Override
    public String getEveusers() {
        try {
            BLeveuser bleveuser = new BLeveuser();
            ArrayList eveusers = bleveuser.getAll();
            JSONArray jsoneveusers = toJSONArray(eveusers);
            return jsoneveusers.toJSONString();
        }
        catch(DBException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String json) {
        BLeveuser bleveuser = new BLeveuser();
        JSONParser parser = new JSONParser();
        String result = "";
        Eveuser eveuser;
        try {
            Eveusersearch eveusersearch = JSONEveuser.toEveusersearch((JSONObject)parser.parse(json));
            ArrayList eveusers = bleveuser.search(eveusersearch);
            JSONArray jsoneveusers = toJSONArray(eveusers);
            result = jsoneveusers.toJSONString();
        }
        catch(ParseException e) {
            result = "";
        }
        catch(DBException e) {
            result = "";
        }
        return result;
    }

    //@WebMethod(operationName = "getEveuser")
    @Override
    public String getEveuser(String json) {
        BLeveuser bleveuser = new BLeveuser();
        JSONParser parser = new JSONParser();
        String result = "";
        Eveuser eveuser;
        try {
            EveuserPK eveuserPK = JSONEveuser.toEveuserPK((JSONObject)parser.parse(json));
            eveuser = bleveuser.getEveuser(eveuserPK);
            if(eveuser!=null) {
                result = JSONEveuser.toJSON(eveuser).toJSONString();
            }
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
        return result;
    }

    //@WebMethod(operationName = "insertEveuser")
    @Override
    public void insertEveuser(String json) {
        BLeveuser bleveuser = new BLeveuser();
        JSONParser parser = new JSONParser();
        try {
            IEveuser eveuser = JSONEveuser.toEveuser((JSONObject)parser.parse(json));
            bleveuser.insertEveuser(eveuser);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "updateEveuser")
    @Override
    public void updateEveuser(String json) {
        BLeveuser bleveuser = new BLeveuser();
        JSONParser parser = new JSONParser();
        try {
            IEveuser eveuser = JSONEveuser.toEveuser((JSONObject)parser.parse(json));
            bleveuser.updateEveuser(eveuser);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "deleteEveuser")
    @Override
    public void deleteEveuser(String json) {
        BLeveuser bleveuser = new BLeveuser();
        JSONParser parser = new JSONParser();
        try {
            IEveuser eveuser = JSONEveuser.toEveuser((JSONObject)parser.parse(json));
            bleveuser.deleteEveuser(eveuser);
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "getEveusers4frontendpage_auth")
    @Override
    public String getEveusers4frontendpage_auth(String json) {
        BLeveuser bleveuser = new BLeveuser();
        JSONParser parser = new JSONParser();
        Eveuser eveuser;
        try {
            String result = null;
            IFrontendpage_authPK frontendpage_authPK = JSONFrontendpage_auth.toFrontendpage_authPK((JSONObject)parser.parse(json));
            eveuser = (Eveuser)bleveuser.getFrontendpage_auth(frontendpage_authPK);
            if(eveuser!=null) {
                result = JSONEveuser.toJSON(eveuser).toJSONString();
            }
            return result;
        }
        catch(ParseException e) {
            return null;
        }
        catch(DBException e) {
            return null;
        }
        catch(CustomException e) {
            return null;
        }
    }


}

