/*
 * WSMaterialinput.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 17.0.2022 13:37
 *
 */

package eve.webservices;

import eve.BusinessObject.Logic.*;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.webservice.WSIMaterialinput;
import eve.logicentity.Materialinput;
import eve.searchentity.Materialinputsearch;
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
@WebService(endpointInterface = "eve.interfaces.webservice.WSIMaterialinput")
public class WSMaterialinput implements WSIMaterialinput {

    private JSONArray toJSONArray(ArrayList materialinputs) {
        JSONArray jsonmaterialinputs = new JSONArray();
        Iterator materialinputsI = materialinputs.iterator();
        while(materialinputsI.hasNext()) {
            jsonmaterialinputs.add(JSONMaterialinput.toJSON((Materialinput)materialinputsI.next()));
        }
        return jsonmaterialinputs;
    }

    /**
     * Web service operation
     */
    //@WebMethod(operationName = "getMaterialinputs")
    @Override
    public String getMaterialinputs() {
        try {
            BLmaterialinput blmaterialinput = new BLmaterialinput();
            ArrayList materialinputs = blmaterialinput.getAll();
            JSONArray jsonmaterialinputs = toJSONArray(materialinputs);
            return jsonmaterialinputs.toJSONString();
        }
        catch(DBException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String json) {
        BLmaterialinput blmaterialinput = new BLmaterialinput();
        JSONParser parser = new JSONParser();
        String result = "";
        Materialinput materialinput;
        try {
            Materialinputsearch materialinputsearch = JSONMaterialinput.toMaterialinputsearch((JSONObject)parser.parse(json));
            ArrayList materialinputs = blmaterialinput.search(materialinputsearch);
            JSONArray jsonmaterialinputs = toJSONArray(materialinputs);
            result = jsonmaterialinputs.toJSONString();
        }
        catch(ParseException e) {
            result = "";
        }
        catch(DBException e) {
            result = "";
        }
        return result;
    }

    //@WebMethod(operationName = "getMaterialinput")
    @Override
    public String getMaterialinput(String json) {
        BLmaterialinput blmaterialinput = new BLmaterialinput();
        JSONParser parser = new JSONParser();
        String result = "";
        Materialinput materialinput;
        try {
            MaterialinputPK materialinputPK = JSONMaterialinput.toMaterialinputPK((JSONObject)parser.parse(json));
            materialinput = blmaterialinput.getMaterialinput(materialinputPK);
            if(materialinput!=null) {
                result = JSONMaterialinput.toJSON(materialinput).toJSONString();
            }
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
        return result;
    }

    //@WebMethod(operationName = "insertMaterialinput")
    @Override
    public void insertMaterialinput(String json) {
        BLmaterialinput blmaterialinput = new BLmaterialinput();
        JSONParser parser = new JSONParser();
        try {
            IMaterialinput materialinput = JSONMaterialinput.toMaterialinput((JSONObject)parser.parse(json));
            blmaterialinput.insertMaterialinput(materialinput);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "updateMaterialinput")
    @Override
    public void updateMaterialinput(String json) {
        BLmaterialinput blmaterialinput = new BLmaterialinput();
        JSONParser parser = new JSONParser();
        try {
            IMaterialinput materialinput = JSONMaterialinput.toMaterialinput((JSONObject)parser.parse(json));
            blmaterialinput.updateMaterialinput(materialinput);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "deleteMaterialinput")
    @Override
    public void deleteMaterialinput(String json) {
        BLmaterialinput blmaterialinput = new BLmaterialinput();
        JSONParser parser = new JSONParser();
        try {
            IMaterialinput materialinput = JSONMaterialinput.toMaterialinput((JSONObject)parser.parse(json));
            blmaterialinput.deleteMaterialinput(materialinput);
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "getMaterialinputs4evetype")
    @Override
    public String getMaterialinputs4evetype(String json) {
        BLmaterialinput blmaterialinput = new BLmaterialinput();
        JSONParser parser = new JSONParser();
        Materialinput materialinput;
        try {
            IEvetypePK evetypePK = JSONEvetype.toEvetypePK((JSONObject)parser.parse(json));
            ArrayList materialinputs = blmaterialinput.getMaterialinputs4evetype(evetypePK);
            JSONArray jsonmaterialinputs = toJSONArray(materialinputs);
            return jsonmaterialinputs.toJSONString();
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
        BLmaterialinput blmaterialinput = new BLmaterialinput();
        JSONParser parser = new JSONParser();
        Materialinput materialinput;
        try {
            IEvetypePK evetypePK = JSONEvetype.toEvetypePK((JSONObject)parser.parse(json));
            blmaterialinput.delete4evetype(evetypePK);
        }
        catch(ParseException e) {
        }
    }


}

