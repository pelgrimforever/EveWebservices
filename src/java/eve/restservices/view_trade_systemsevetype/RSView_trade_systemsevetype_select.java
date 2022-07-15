/*
 * Generated on 13.6.2022 18:20
 */

package eve.restservices.view_trade_systemsevetype;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import eve.BusinessObject.Logic.*;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.interfaces.logicview.IView_trade_systemsevetype;
import eve.interfaces.servlet.IView_trade_systemsevetypeOperation;
import eve.usecases.View_trade_systemsevetype_usecases;
import eve.logicview.View_trade_systemsevetype;
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
@Path("rsview_trade_systemsevetype_select")
public class RSView_trade_systemsevetype_select extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            View_trade_systemsevetype_usecases view_trade_systemsevetypeusecases = new View_trade_systemsevetype_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IView_trade_systemsevetypeOperation.SELECT_ALL:
                    result = get_all_view_trade_systemsevetype(view_trade_systemsevetypeusecases);
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

    private String get_all_view_trade_systemsevetype(View_trade_systemsevetype_usecases view_trade_systemsevetypeusecases) throws ParseException, CustomException {
    	return JSONView_trade_systemsevetype.toJSONArray(view_trade_systemsevetypeusecases.get_all()).toJSONString();
    }
}

