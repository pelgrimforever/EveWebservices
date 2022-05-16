/*
 * WSFrontendpage.java
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
import eve.interfaces.webservice.WSIFrontendpage;
import eve.logicentity.Frontendpage;
import eve.searchentity.Frontendpagesearch;
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
@WebService(endpointInterface = "eve.interfaces.webservice.WSIFrontendpage")
public class WSFrontendpage implements WSIFrontendpage {

    private JSONArray toJSONArray(ArrayList frontendpages) {
        JSONArray jsonfrontendpages = new JSONArray();
        Iterator frontendpagesI = frontendpages.iterator();
        while(frontendpagesI.hasNext()) {
            jsonfrontendpages.add(JSONFrontendpage.toJSON((Frontendpage)frontendpagesI.next()));
        }
        return jsonfrontendpages;
    }

    /**
     * Web service operation
     */
    //@WebMethod(operationName = "getFrontendpages")
    @Override
    public String getFrontendpages() {
        try {
            BLfrontendpage blfrontendpage = new BLfrontendpage();
            ArrayList frontendpages = blfrontendpage.getAll();
            JSONArray jsonfrontendpages = toJSONArray(frontendpages);
            return jsonfrontendpages.toJSONString();
        }
        catch(DBException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String json) {
        BLfrontendpage blfrontendpage = new BLfrontendpage();
        JSONParser parser = new JSONParser();
        String result = "";
        Frontendpage frontendpage;
        try {
            Frontendpagesearch frontendpagesearch = JSONFrontendpage.toFrontendpagesearch((JSONObject)parser.parse(json));
            ArrayList frontendpages = blfrontendpage.search(frontendpagesearch);
            JSONArray jsonfrontendpages = toJSONArray(frontendpages);
            result = jsonfrontendpages.toJSONString();
        }
        catch(ParseException e) {
            result = "";
        }
        catch(DBException e) {
            result = "";
        }
        return result;
    }

    //@WebMethod(operationName = "getFrontendpage")
    @Override
    public String getFrontendpage(String json) {
        BLfrontendpage blfrontendpage = new BLfrontendpage();
        JSONParser parser = new JSONParser();
        String result = "";
        Frontendpage frontendpage;
        try {
            FrontendpagePK frontendpagePK = JSONFrontendpage.toFrontendpagePK((JSONObject)parser.parse(json));
            frontendpage = blfrontendpage.getFrontendpage(frontendpagePK);
            if(frontendpage!=null) {
                result = JSONFrontendpage.toJSON(frontendpage).toJSONString();
            }
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
        return result;
    }

    //@WebMethod(operationName = "insertFrontendpage")
    @Override
    public void insertFrontendpage(String json) {
        BLfrontendpage blfrontendpage = new BLfrontendpage();
        JSONParser parser = new JSONParser();
        try {
            IFrontendpage frontendpage = JSONFrontendpage.toFrontendpage((JSONObject)parser.parse(json));
            blfrontendpage.insertFrontendpage(frontendpage);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "updateFrontendpage")
    @Override
    public void updateFrontendpage(String json) {
        BLfrontendpage blfrontendpage = new BLfrontendpage();
        JSONParser parser = new JSONParser();
        try {
            IFrontendpage frontendpage = JSONFrontendpage.toFrontendpage((JSONObject)parser.parse(json));
            blfrontendpage.updateFrontendpage(frontendpage);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "deleteFrontendpage")
    @Override
    public void deleteFrontendpage(String json) {
        BLfrontendpage blfrontendpage = new BLfrontendpage();
        JSONParser parser = new JSONParser();
        try {
            IFrontendpage frontendpage = JSONFrontendpage.toFrontendpage((JSONObject)parser.parse(json));
            blfrontendpage.deleteFrontendpage(frontendpage);
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "getFrontendpages4frontendpage_auth")
    @Override
    public String getFrontendpages4frontendpage_auth(String json) {
        BLfrontendpage blfrontendpage = new BLfrontendpage();
        JSONParser parser = new JSONParser();
        Frontendpage frontendpage;
        try {
            String result = null;
            IFrontendpage_authPK frontendpage_authPK = JSONFrontendpage_auth.toFrontendpage_authPK((JSONObject)parser.parse(json));
            frontendpage = (Frontendpage)blfrontendpage.getFrontendpage_auth(frontendpage_authPK);
            if(frontendpage!=null) {
                result = JSONFrontendpage.toJSON(frontendpage).toJSONString();
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

