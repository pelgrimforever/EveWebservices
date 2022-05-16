/*
 * WSBpmaterial.java
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
import eve.interfaces.webservice.WSIBpmaterial;
import eve.logicentity.Bpmaterial;
import eve.searchentity.Bpmaterialsearch;
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
@WebService(endpointInterface = "eve.interfaces.webservice.WSIBpmaterial")
public class WSBpmaterial implements WSIBpmaterial {

    private JSONArray toJSONArray(ArrayList bpmaterials) {
        JSONArray jsonbpmaterials = new JSONArray();
        Iterator bpmaterialsI = bpmaterials.iterator();
        while(bpmaterialsI.hasNext()) {
            jsonbpmaterials.add(JSONBpmaterial.toJSON((Bpmaterial)bpmaterialsI.next()));
        }
        return jsonbpmaterials;
    }

    /**
     * Web service operation
     */
    //@WebMethod(operationName = "getBpmaterials")
    @Override
    public String getBpmaterials() {
        try {
            BLbpmaterial blbpmaterial = new BLbpmaterial();
            ArrayList bpmaterials = blbpmaterial.getAll();
            JSONArray jsonbpmaterials = toJSONArray(bpmaterials);
            return jsonbpmaterials.toJSONString();
        }
        catch(DBException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String json) {
        BLbpmaterial blbpmaterial = new BLbpmaterial();
        JSONParser parser = new JSONParser();
        String result = "";
        Bpmaterial bpmaterial;
        try {
            Bpmaterialsearch bpmaterialsearch = JSONBpmaterial.toBpmaterialsearch((JSONObject)parser.parse(json));
            ArrayList bpmaterials = blbpmaterial.search(bpmaterialsearch);
            JSONArray jsonbpmaterials = toJSONArray(bpmaterials);
            result = jsonbpmaterials.toJSONString();
        }
        catch(ParseException e) {
            result = "";
        }
        catch(DBException e) {
            result = "";
        }
        return result;
    }

    //@WebMethod(operationName = "getBpmaterial")
    @Override
    public String getBpmaterial(String json) {
        BLbpmaterial blbpmaterial = new BLbpmaterial();
        JSONParser parser = new JSONParser();
        String result = "";
        Bpmaterial bpmaterial;
        try {
            BpmaterialPK bpmaterialPK = JSONBpmaterial.toBpmaterialPK((JSONObject)parser.parse(json));
            bpmaterial = blbpmaterial.getBpmaterial(bpmaterialPK);
            if(bpmaterial!=null) {
                result = JSONBpmaterial.toJSON(bpmaterial).toJSONString();
            }
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
        return result;
    }

    //@WebMethod(operationName = "insertBpmaterial")
    @Override
    public void insertBpmaterial(String json) {
        BLbpmaterial blbpmaterial = new BLbpmaterial();
        JSONParser parser = new JSONParser();
        try {
            IBpmaterial bpmaterial = JSONBpmaterial.toBpmaterial((JSONObject)parser.parse(json));
            blbpmaterial.insertBpmaterial(bpmaterial);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "updateBpmaterial")
    @Override
    public void updateBpmaterial(String json) {
        BLbpmaterial blbpmaterial = new BLbpmaterial();
        JSONParser parser = new JSONParser();
        try {
            IBpmaterial bpmaterial = JSONBpmaterial.toBpmaterial((JSONObject)parser.parse(json));
            blbpmaterial.updateBpmaterial(bpmaterial);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "deleteBpmaterial")
    @Override
    public void deleteBpmaterial(String json) {
        BLbpmaterial blbpmaterial = new BLbpmaterial();
        JSONParser parser = new JSONParser();
        try {
            IBpmaterial bpmaterial = JSONBpmaterial.toBpmaterial((JSONObject)parser.parse(json));
            blbpmaterial.deleteBpmaterial(bpmaterial);
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "getBpmaterials4evetypeBp")
    @Override
    public String getBpmaterials4evetypeBp(String json) {
        BLbpmaterial blbpmaterial = new BLbpmaterial();
        JSONParser parser = new JSONParser();
        Bpmaterial bpmaterial;
        try {
            IEvetypePK evetypeBpPK = JSONEvetype.toEvetypePK((JSONObject)parser.parse(json));
            ArrayList bpmaterials = blbpmaterial.getBpmaterials4evetypeBp(evetypeBpPK);
            JSONArray jsonbpmaterials = toJSONArray(bpmaterials);
            return jsonbpmaterials.toJSONString();
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

    //@WebMethod(operationName = "delete4evetypeBp")
    @Override
    public void delete4evetypeBp(String json) {
        BLbpmaterial blbpmaterial = new BLbpmaterial();
        JSONParser parser = new JSONParser();
        Bpmaterial bpmaterial;
        try {
            IEvetypePK evetypeBpPK = JSONEvetype.toEvetypePK((JSONObject)parser.parse(json));
            blbpmaterial.delete4evetypeBp(evetypeBpPK);
        }
        catch(ParseException e) {
        }
    }

    //@WebMethod(operationName = "getBpmaterials4evetypeMaterial")
    @Override
    public String getBpmaterials4evetypeMaterial(String json) {
        BLbpmaterial blbpmaterial = new BLbpmaterial();
        JSONParser parser = new JSONParser();
        Bpmaterial bpmaterial;
        try {
            IEvetypePK evetypeMaterialPK = JSONEvetype.toEvetypePK((JSONObject)parser.parse(json));
            ArrayList bpmaterials = blbpmaterial.getBpmaterials4evetypeMaterial(evetypeMaterialPK);
            JSONArray jsonbpmaterials = toJSONArray(bpmaterials);
            return jsonbpmaterials.toJSONString();
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

    //@WebMethod(operationName = "delete4evetypeMaterial")
    @Override
    public void delete4evetypeMaterial(String json) {
        BLbpmaterial blbpmaterial = new BLbpmaterial();
        JSONParser parser = new JSONParser();
        Bpmaterial bpmaterial;
        try {
            IEvetypePK evetypeMaterialPK = JSONEvetype.toEvetypePK((JSONObject)parser.parse(json));
            blbpmaterial.delete4evetypeMaterial(evetypeMaterialPK);
        }
        catch(ParseException e) {
        }
    }


}

