/*
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */

package eve.restservices.evetype;

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
import eve.interfaces.searchentity.IEvetypesearch;
import eve.interfaces.servlet.IEvetypeOperation;
import eve.logicentity.Evetype;
import eve.searchentity.Evetypesearch;
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

@Path("rsevetype_delete")
public class RSEvetype_delete extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Evetype_usecases evetypeusecases = new Evetype_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IEvetypeOperation.DELETE_EVETYPE:
                    delete_evetype(evetypeusecases, json);
                    break;
                case IEvetypeOperation.DELETE_Market_group:
                    delete_evetype(evetypeusecases, json);
                    break;
                case IEvetypeOperation.DELETE_Typegroup:
                    delete_evetype(evetypeusecases, json);
                    break;
                case IEvetypeOperation.DELETE_Graphic:
                    delete_evetype(evetypeusecases, json);
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

    private void delete_evetype(Evetype_usecases evetypeusecases, JSONObject json) throws ParseException, CustomException {
        IEvetype evetype = (IEvetype)JSONEvetype.toEvetype((JSONObject)json.get("evetype"));
        evetypeusecases.deleteEvetype(evetype);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Market_group(Evetype_usecases evetypeusecases, JSONObject json) throws ParseException, CustomException {
        IMarket_groupPK market_groupPK = (IMarket_groupPK)JSONMarket_group.toMarket_groupPK((JSONObject)json.get("market_grouppk"));
        evetypeusecases.delete_all_containing_Market_group(market_groupPK);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Typegroup(Evetype_usecases evetypeusecases, JSONObject json) throws ParseException, CustomException {
        ITypegroupPK typegroupPK = (ITypegroupPK)JSONTypegroup.toTypegroupPK((JSONObject)json.get("typegrouppk"));
        evetypeusecases.delete_all_containing_Typegroup(typegroupPK);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Graphic(Evetype_usecases evetypeusecases, JSONObject json) throws ParseException, CustomException {
        IGraphicPK graphicPK = (IGraphicPK)JSONGraphic.toGraphicPK((JSONObject)json.get("graphicpk"));
        evetypeusecases.delete_all_containing_Graphic(graphicPK);
        setReturnstatus("OK");
    }

}

