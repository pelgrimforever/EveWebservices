/*
 * Generated on 17.6.2022 13:4
 */

package eve.restservices.bpmaterial;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.usecases.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.IBpmaterialsearch;
import eve.interfaces.servlet.IBpmaterialOperation;
import eve.logicentity.Bpmaterial;
import eve.searchentity.Bpmaterialsearch;
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

/**
 * @author Franky Laseure
 */
@Path("rsbpmaterial_select")
public class RSBpmaterial_select extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Bpmaterial_usecases bpmaterialusecases = new Bpmaterial_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IBpmaterialOperation.SELECT_COUNT:
                    result = count_records(bpmaterialusecases);
                    break;
                case IBpmaterialOperation.SELECT_ALL:
                    result = get_all_bpmaterial(bpmaterialusecases);
                    break;
                case IBpmaterialOperation.SELECT_BPMATERIAL:
                    result = get_bpmaterial_with_primarykey(bpmaterialusecases, json);
                    break;
                case IBpmaterialOperation.SELECT_Evetypebp:
                    result = get_bpmaterial_with_foreignkey_evetypeBp(bpmaterialusecases, json);
                    break;
                case IBpmaterialOperation.SELECT_Evetypematerial:
                    result = get_bpmaterial_with_foreignkey_evetypeMaterial(bpmaterialusecases, json);
                    break;
                case IBpmaterialOperation.SELECT_SEARCH:
                    result = search_bpmaterial(bpmaterialusecases, json);
                    break;
                case IBpmaterialOperation.SELECT_SEARCHCOUNT:
                    result = search_bpmaterial_count(bpmaterialusecases, json);
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
}

