/*
 * Generated on 13.6.2022 18:20
 */

package eve.restservices.view_evetypes;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import eve.BusinessObject.Logic.*;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.interfaces.logicview.IView_evetypes;
import eve.interfaces.servlet.IView_evetypesOperation;
import eve.usecases.View_evetypes_usecases;
import eve.logicview.View_evetypes;
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
@Path("rsview_evetypes_select")
public class RSView_evetypes_select extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            View_evetypes_usecases view_evetypesusecases = new View_evetypes_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IView_evetypesOperation.SELECT_ALL:
                    result = get_all_view_evetypes(view_evetypesusecases);
                    break;
//Custom code, do not change this line
//add here custom operations
                case IView_evetypesOperation.SELECT_SHIPS:
                    result = getShips(view_evetypesusecases);
                    break;
                case IView_evetypesOperation.SELECT_MODULES:
                    result = getModules(view_evetypesusecases);
                    break;
                case IView_evetypesOperation.SELECT_CHARGES:
                    result = getCharges(view_evetypesusecases);
                    break;
                case IView_evetypesOperation.SELECT_DRONES:
                    result = getDrones(view_evetypesusecases);
                    break;
                case IView_evetypesOperation.SELECT_DEPLOYABLES:
                    result = getDeployables(view_evetypesusecases);
                    break;
                case IView_evetypesOperation.SELECT_MINERALS:
                    result = getMinerals(view_evetypesusecases);
                    break;
                case IView_evetypesOperation.SELECT_SALVAGED:
                    result = getSalvagedmaterials(view_evetypesusecases);
                    break;
                case IView_evetypesOperation.SELECT_BLEUPRINT:
                    result = getBlueprints(view_evetypesusecases, json);
                    break;
                case IView_evetypesOperation.SELECT_BLEUPRINTRESULT:
                    result = getBlueprintresult(view_evetypesusecases, json);
                    break;
                case IView_evetypesOperation.SELECT_COMMODITY:
                    result = getCommodities(view_evetypesusecases, json);
                    break;
                case IView_evetypesOperation.SELECT_MATERIAL:
                    result = getMaterials(view_evetypesusecases);
                    break;
                case IView_evetypesOperation.SELECT_PLANETARYCOMMODITY:
                    result = getPlanetarycommodities(view_evetypesusecases);
                    break;
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
    private String getShips(View_evetypes_usecases view_evetypesusecases) throws ParseException, CustomException {
        return JSONView_evetypes.toJSONArray(view_evetypesusecases.getShips_usecase()).toJSONString();
    }

    private String getModules(View_evetypes_usecases view_evetypesusecases) throws ParseException, CustomException {
        return JSONView_evetypes.toJSONArray(view_evetypesusecases.getModules_usecase()).toJSONString();
    }

    private String getCharges(View_evetypes_usecases view_evetypesusecases) throws ParseException, CustomException {
        return JSONView_evetypes.toJSONArray(view_evetypesusecases.getCharges_usecase()).toJSONString();
    }

    private String getDrones(View_evetypes_usecases view_evetypesusecases) throws ParseException, CustomException {
        return JSONView_evetypes.toJSONArray(view_evetypesusecases.getDrones_usecase()).toJSONString();
    }

    private String getDeployables(View_evetypes_usecases view_evetypesusecases) throws ParseException, CustomException {
        return JSONView_evetypes.toJSONArray(view_evetypesusecases.getDeployables_usecase()).toJSONString();
    }

    private String getMinerals(View_evetypes_usecases view_evetypesusecases) throws ParseException, CustomException {
        return JSONView_evetypes.toJSONArray(view_evetypesusecases.getMinerals_usecase()).toJSONString();
    }

    private String getSalvagedmaterials(View_evetypes_usecases view_evetypesusecases) throws ParseException, CustomException {
        return JSONView_evetypes.toJSONArray(view_evetypesusecases.getSalvagedmaterials_usecase()).toJSONString();
    }

    private String getBlueprints(View_evetypes_usecases view_evetypesusecases, JSONObject json) throws ParseException, CustomException {
        String searchstring = JSONConversion.getString(json, "searchstring");
        return JSONView_evetypes.toJSONArray(view_evetypesusecases.getBlueprints_usecase(searchstring)).toJSONString();
    }

    private String getBlueprintresult(View_evetypes_usecases view_evetypesusecases, JSONObject json) throws ParseException, CustomException {
        View_evetypes viewevetype = JSONView_evetypes.toView_evetypes((JSONObject)json.get("viewblueprint"));
        return JSONView_evetypes.toJSON(view_evetypesusecases.getBlueprintresult_usecase(viewevetype)).toJSONString();
    }

    private String getCommodities(View_evetypes_usecases view_evetypesusecases, JSONObject json) throws ParseException, CustomException {
        String searchstring = JSONConversion.getString(json, "searchstring");
        return JSONView_evetypes.toJSONArray(view_evetypesusecases.getCommodities_usecase(searchstring)).toJSONString();
    }

    private String getMaterials(View_evetypes_usecases view_evetypesusecases) throws ParseException, CustomException {
        return JSONView_evetypes.toJSONArray(view_evetypesusecases.getMaterials_usecase()).toJSONString();
    }

    private String getPlanetarycommodities(View_evetypes_usecases view_evetypesusecases) throws ParseException, CustomException {
        return JSONView_evetypes.toJSONArray(view_evetypesusecases.getPlanetarycommodities_usecase()).toJSONString();
    }
//Custom code, do not change this line   

    private String get_all_view_evetypes(View_evetypes_usecases view_evetypesusecases) throws ParseException, CustomException {
    	return JSONView_evetypes.toJSONArray(view_evetypesusecases.get_all()).toJSONString();
    }
}

