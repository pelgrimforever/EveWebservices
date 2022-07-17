/*
 * Generated on 17.6.2022 13:4
 */

package eve.restservices.view_tradeorders_lowsec;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import eve.BusinessObject.Logic.*;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.interfaces.logicview.IView_tradeorders_lowsec;
import eve.interfaces.servlet.IView_tradeorders_lowsecOperation;
import eve.usecases.View_tradeorders_lowsec_usecases;
import eve.logicview.View_tradeorders_lowsec;
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
@Path("rsview_tradeorders_lowsec_select")
public class RSView_tradeorders_lowsec_select extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            View_tradeorders_lowsec_usecases view_tradeorders_lowsecusecases = new View_tradeorders_lowsec_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IView_tradeorders_lowsecOperation.SELECT_ALL:
                    result = get_all_view_tradeorders_lowsec(view_tradeorders_lowsecusecases);
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

    private String get_all_view_tradeorders_lowsec(View_tradeorders_lowsec_usecases view_tradeorders_lowsecusecases) throws ParseException, CustomException {
    	return JSONView_tradeorders_lowsec.toJSONArray(view_tradeorders_lowsecusecases.get_all()).toJSONString();
    }
}

