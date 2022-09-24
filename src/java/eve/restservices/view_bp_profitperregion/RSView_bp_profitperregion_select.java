/*
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */

package eve.restservices.view_bp_profitperregion;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import eve.BusinessObject.Logic.*;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.interfaces.logicview.IView_bp_profitperregion;
import eve.interfaces.servlet.IView_bp_profitperregionOperation;
import eve.usecases.View_bp_profitperregion_usecases;
import eve.logicview.View_bp_profitperregion;
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

@Path("rsview_bp_profitperregion_select")
public class RSView_bp_profitperregion_select extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            View_bp_profitperregion_usecases view_bp_profitperregionusecases = new View_bp_profitperregion_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IView_bp_profitperregionOperation.SELECT_ALL:
                    result = get_all_view_bp_profitperregion(view_bp_profitperregionusecases);
                    break;
//Custom code, do not change this line
//add here custom operations
                case IView_bp_profitperregionOperation.SELECT_LASTMONTH:
                    result = getView_bp_profitperregions4lastmonth(view_bp_profitperregionusecases);
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
    private String getView_bp_profitperregions4lastmonth(View_bp_profitperregion_usecases view_bp_profitperregioninteractor) throws ParseException, CustomException {
        return JSONView_bp_profitperregion.toJSONArray(view_bp_profitperregioninteractor.getView_bp_profitperregions4lastmonth_usecase()).toJSONString();
    }
//Custom code, do not change this line   

    private String get_all_view_bp_profitperregion(View_bp_profitperregion_usecases view_bp_profitperregionusecases) throws ParseException, CustomException {
    	return JSONView_bp_profitperregion.toJSONArray(view_bp_profitperregionusecases.get_all()).toJSONString();
    }
}

