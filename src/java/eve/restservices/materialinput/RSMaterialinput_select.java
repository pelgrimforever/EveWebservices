/*
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */

package eve.restservices.materialinput;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.usecases.*;
import eve.usecases.custom.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.IMaterialinputsearch;
import eve.interfaces.servlet.IMaterialinputOperation;
import eve.logicentity.Materialinput;
import eve.searchentity.Materialinputsearch;
import eve.servlets.DataServlet;
import eve.usecases.custom.*;
import general.exception.*;
import java.sql.Date;
import java.sql.Time;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

@Path("rsmaterialinput_select")
public class RSMaterialinput_select extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Materialinput_usecases materialinputusecases = new Materialinput_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IMaterialinputOperation.SELECT_COUNT:
                    result = count_records(materialinputusecases);
                    break;
                case IMaterialinputOperation.SELECT_ALL:
                    result = get_all_materialinput(materialinputusecases);
                    break;
                case IMaterialinputOperation.SELECT_MATERIALINPUT:
                    result = get_materialinput_with_primarykey(materialinputusecases, json);
                    break;
                case IMaterialinputOperation.SELECT_Evetype:
                    result = get_materialinput_with_foreignkey_evetype(materialinputusecases, json);
                    break;
                case IMaterialinputOperation.SELECT_SEARCH:
                    result = search_materialinput(materialinputusecases, json);
                    break;
                case IMaterialinputOperation.SELECT_SEARCHCOUNT:
                    result = search_materialinput_count(materialinputusecases, json);
                    break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            }
        }
        catch(ParseException | CustomException | IOException e) {
            setReturnstatus(e.getMessage());
        }
        return result;
    }

//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

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
}

