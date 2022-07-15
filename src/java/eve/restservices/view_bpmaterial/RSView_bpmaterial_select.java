/*
 * Generated on 13.6.2022 18:20
 */

package eve.restservices.view_bpmaterial;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import eve.BusinessObject.Logic.*;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.interfaces.logicview.IView_bpmaterial;
import eve.interfaces.servlet.IView_bpmaterialOperation;
import eve.usecases.View_bpmaterial_usecases;
import eve.logicview.View_bpmaterial;
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
@Path("rsview_bpmaterial_select")
public class RSView_bpmaterial_select extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            View_bpmaterial_usecases view_bpmaterialusecases = new View_bpmaterial_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IView_bpmaterialOperation.SELECT_ALL:
                    result = get_all_view_bpmaterial(view_bpmaterialusecases);
                    break;
//Custom code, do not change this line
//add here custom operations
                case IView_bpmaterialOperation.SELECT_4BLUEPRINT:
                    result = getView_bpmaterials_for_blueprint(view_bpmaterialusecases, json);
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
    private String getView_bpmaterials_for_blueprint(View_bpmaterial_usecases view_bpmaterialinteractor, JSONObject json) throws ParseException, CustomException {
        long blueprintid = JSONConversion.getlong(json, "bp");
        return JSONView_bpmaterial.toJSONArray(view_bpmaterialinteractor.getView_bpmaterials_for_blueprint_usecase(blueprintid)).toJSONString();
    }
//Custom code, do not change this line   

    private String get_all_view_bpmaterial(View_bpmaterial_usecases view_bpmaterialusecases) throws ParseException, CustomException {
    	return JSONView_bpmaterial.toJSONArray(view_bpmaterialusecases.get_all()).toJSONString();
    }
}

