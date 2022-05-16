/*
 * WSUserbp.java
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
import eve.interfaces.webservice.WSIUserbp;
import eve.logicentity.Userbp;
import eve.searchentity.Userbpsearch;
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
@WebService(endpointInterface = "eve.interfaces.webservice.WSIUserbp")
public class WSUserbp implements WSIUserbp {

    private JSONArray toJSONArray(ArrayList userbps) {
        JSONArray jsonuserbps = new JSONArray();
        Iterator userbpsI = userbps.iterator();
        while(userbpsI.hasNext()) {
            jsonuserbps.add(JSONUserbp.toJSON((Userbp)userbpsI.next()));
        }
        return jsonuserbps;
    }

    /**
     * Web service operation
     */
    //@WebMethod(operationName = "getUserbps")
    @Override
    public String getUserbps() {
        try {
            BLuserbp bluserbp = new BLuserbp();
            ArrayList userbps = bluserbp.getAll();
            JSONArray jsonuserbps = toJSONArray(userbps);
            return jsonuserbps.toJSONString();
        }
        catch(DBException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String json) {
        BLuserbp bluserbp = new BLuserbp();
        JSONParser parser = new JSONParser();
        String result = "";
        Userbp userbp;
        try {
            Userbpsearch userbpsearch = JSONUserbp.toUserbpsearch((JSONObject)parser.parse(json));
            ArrayList userbps = bluserbp.search(userbpsearch);
            JSONArray jsonuserbps = toJSONArray(userbps);
            result = jsonuserbps.toJSONString();
        }
        catch(ParseException e) {
            result = "";
        }
        catch(DBException e) {
            result = "";
        }
        return result;
    }

    //@WebMethod(operationName = "getUserbp")
    @Override
    public String getUserbp(String json) {
        BLuserbp bluserbp = new BLuserbp();
        JSONParser parser = new JSONParser();
        String result = "";
        Userbp userbp;
        try {
            UserbpPK userbpPK = JSONUserbp.toUserbpPK((JSONObject)parser.parse(json));
            userbp = bluserbp.getUserbp(userbpPK);
            if(userbp!=null) {
                result = JSONUserbp.toJSON(userbp).toJSONString();
            }
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
        return result;
    }

    //@WebMethod(operationName = "insertUserbp")
    @Override
    public void insertUserbp(String json) {
        BLuserbp bluserbp = new BLuserbp();
        JSONParser parser = new JSONParser();
        try {
            IUserbp userbp = JSONUserbp.toUserbp((JSONObject)parser.parse(json));
            bluserbp.insertUserbp(userbp);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "updateUserbp")
    @Override
    public void updateUserbp(String json) {
        BLuserbp bluserbp = new BLuserbp();
        JSONParser parser = new JSONParser();
        try {
            IUserbp userbp = JSONUserbp.toUserbp((JSONObject)parser.parse(json));
            bluserbp.updateUserbp(userbp);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "deleteUserbp")
    @Override
    public void deleteUserbp(String json) {
        BLuserbp bluserbp = new BLuserbp();
        JSONParser parser = new JSONParser();
        try {
            IUserbp userbp = JSONUserbp.toUserbp((JSONObject)parser.parse(json));
            bluserbp.deleteUserbp(userbp);
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "getUserbps4evetype")
    @Override
    public String getUserbps4evetype(String json) {
        BLuserbp bluserbp = new BLuserbp();
        JSONParser parser = new JSONParser();
        Userbp userbp;
        try {
            IEvetypePK evetypePK = JSONEvetype.toEvetypePK((JSONObject)parser.parse(json));
            ArrayList userbps = bluserbp.getUserbps4evetype(evetypePK);
            JSONArray jsonuserbps = toJSONArray(userbps);
            return jsonuserbps.toJSONString();
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

    //@WebMethod(operationName = "delete4evetype")
    @Override
    public void delete4evetype(String json) {
        BLuserbp bluserbp = new BLuserbp();
        JSONParser parser = new JSONParser();
        Userbp userbp;
        try {
            IEvetypePK evetypePK = JSONEvetype.toEvetypePK((JSONObject)parser.parse(json));
            bluserbp.delete4evetype(evetypePK);
        }
        catch(ParseException e) {
        }
    }


}

