/*
 * WSFrontendpage_auth.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 16.1.2022 20:53
 *
 */

package eve.webservices;

import eve.BusinessObject.Logic.*;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.webservice.WSIFrontendpage_auth;
import eve.logicentity.Frontendpage_auth;
import eve.searchentity.Frontendpage_authsearch;
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
@WebService(endpointInterface = "eve.interfaces.webservice.WSIFrontendpage_auth")
public class WSFrontendpage_auth implements WSIFrontendpage_auth {

    private JSONArray toJSONArray(ArrayList frontendpage_auths) {
        JSONArray jsonfrontendpage_auths = new JSONArray();
        Iterator frontendpage_authsI = frontendpage_auths.iterator();
        while(frontendpage_authsI.hasNext()) {
            jsonfrontendpage_auths.add(JSONFrontendpage_auth.toJSON((Frontendpage_auth)frontendpage_authsI.next()));
        }
        return jsonfrontendpage_auths;
    }

    /**
     * Web service operation
     */
    //@WebMethod(operationName = "getFrontendpage_auths")
    @Override
    public String getFrontendpage_auths() {
        try {
            BLfrontendpage_auth blfrontendpage_auth = new BLfrontendpage_auth();
            ArrayList frontendpage_auths = blfrontendpage_auth.getAll();
            JSONArray jsonfrontendpage_auths = toJSONArray(frontendpage_auths);
            return jsonfrontendpage_auths.toJSONString();
        }
        catch(DBException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String json) {
        BLfrontendpage_auth blfrontendpage_auth = new BLfrontendpage_auth();
        JSONParser parser = new JSONParser();
        String result = "";
        Frontendpage_auth frontendpage_auth;
        try {
            Frontendpage_authsearch frontendpage_authsearch = JSONFrontendpage_auth.toFrontendpage_authsearch((JSONObject)parser.parse(json));
            ArrayList frontendpage_auths = blfrontendpage_auth.search(frontendpage_authsearch);
            JSONArray jsonfrontendpage_auths = toJSONArray(frontendpage_auths);
            result = jsonfrontendpage_auths.toJSONString();
        }
        catch(ParseException e) {
            result = "";
        }
        catch(DBException e) {
            result = "";
        }
        return result;
    }

    //@WebMethod(operationName = "getFrontendpage_auth")
    @Override
    public String getFrontendpage_auth(String json) {
        BLfrontendpage_auth blfrontendpage_auth = new BLfrontendpage_auth();
        JSONParser parser = new JSONParser();
        String result = "";
        Frontendpage_auth frontendpage_auth;
        try {
            Frontendpage_authPK frontendpage_authPK = JSONFrontendpage_auth.toFrontendpage_authPK((JSONObject)parser.parse(json));
            frontendpage_auth = blfrontendpage_auth.getFrontendpage_auth(frontendpage_authPK);
            if(frontendpage_auth!=null) {
                result = JSONFrontendpage_auth.toJSON(frontendpage_auth).toJSONString();
            }
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
        return result;
    }

    //@WebMethod(operationName = "insertFrontendpage_auth")
    @Override
    public void insertFrontendpage_auth(String json) {
        BLfrontendpage_auth blfrontendpage_auth = new BLfrontendpage_auth();
        JSONParser parser = new JSONParser();
        try {
            IFrontendpage_auth frontendpage_auth = JSONFrontendpage_auth.toFrontendpage_auth((JSONObject)parser.parse(json));
            blfrontendpage_auth.insertFrontendpage_auth(frontendpage_auth);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "updateFrontendpage_auth")
    @Override
    public void updateFrontendpage_auth(String json) {
        BLfrontendpage_auth blfrontendpage_auth = new BLfrontendpage_auth();
        JSONParser parser = new JSONParser();
        try {
            IFrontendpage_auth frontendpage_auth = JSONFrontendpage_auth.toFrontendpage_auth((JSONObject)parser.parse(json));
            blfrontendpage_auth.updateFrontendpage_auth(frontendpage_auth);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "deleteFrontendpage_auth")
    @Override
    public void deleteFrontendpage_auth(String json) {
        BLfrontendpage_auth blfrontendpage_auth = new BLfrontendpage_auth();
        JSONParser parser = new JSONParser();
        try {
            IFrontendpage_auth frontendpage_auth = JSONFrontendpage_auth.toFrontendpage_auth((JSONObject)parser.parse(json));
            blfrontendpage_auth.deleteFrontendpage_auth(frontendpage_auth);
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "getFrontendpage_auths4frontendpage")
    @Override
    public String getFrontendpage_auths4frontendpage(String json) {
        BLfrontendpage_auth blfrontendpage_auth = new BLfrontendpage_auth();
        JSONParser parser = new JSONParser();
        Frontendpage_auth frontendpage_auth;
        try {
            IFrontendpagePK frontendpagePK = JSONFrontendpage.toFrontendpagePK((JSONObject)parser.parse(json));
            ArrayList frontendpage_auths = blfrontendpage_auth.getFrontendpage_auths4frontendpage(frontendpagePK);
            JSONArray jsonfrontendpage_auths = toJSONArray(frontendpage_auths);
            return jsonfrontendpage_auths.toJSONString();
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

    //@WebMethod(operationName = "delete4frontendpage")
    @Override
    public void delete4frontendpage(String json) {
        BLfrontendpage_auth blfrontendpage_auth = new BLfrontendpage_auth();
        JSONParser parser = new JSONParser();
        Frontendpage_auth frontendpage_auth;
        try {
            IFrontendpagePK frontendpagePK = JSONFrontendpage.toFrontendpagePK((JSONObject)parser.parse(json));
            blfrontendpage_auth.delete4frontendpage(frontendpagePK);
        }
        catch(ParseException e) {
        }
    }

    //@WebMethod(operationName = "getFrontendpage_auths4eveuser")
    @Override
    public String getFrontendpage_auths4eveuser(String json) {
        BLfrontendpage_auth blfrontendpage_auth = new BLfrontendpage_auth();
        JSONParser parser = new JSONParser();
        Frontendpage_auth frontendpage_auth;
        try {
            IEveuserPK eveuserPK = JSONEveuser.toEveuserPK((JSONObject)parser.parse(json));
            ArrayList frontendpage_auths = blfrontendpage_auth.getFrontendpage_auths4eveuser(eveuserPK);
            JSONArray jsonfrontendpage_auths = toJSONArray(frontendpage_auths);
            return jsonfrontendpage_auths.toJSONString();
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

    //@WebMethod(operationName = "delete4eveuser")
    @Override
    public void delete4eveuser(String json) {
        BLfrontendpage_auth blfrontendpage_auth = new BLfrontendpage_auth();
        JSONParser parser = new JSONParser();
        Frontendpage_auth frontendpage_auth;
        try {
            IEveuserPK eveuserPK = JSONEveuser.toEveuserPK((JSONObject)parser.parse(json));
            blfrontendpage_auth.delete4eveuser(eveuserPK);
        }
        catch(ParseException e) {
        }
    }


}

