/*
 * Generated on 20.4.2022 10:3
 */

package eve.restservices.userbp;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.usecases.Userbp_usecases;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.IUserbpsearch;
import eve.interfaces.servlet.IUserbpOperation;
import eve.logicentity.Userbp;
import eve.searchentity.Userbpsearch;
import eve.servlets.DataServlet;
import eve.usecases.Security_usecases;
import general.exception.CustomException;
import general.exception.DataException;
import general.exception.DBException;
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
@Path("rsuserbp_select")
public class RSUserbp_select extends RS_json_login {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(Security_usecases.check_authorization(authorisationstring));
            IUserbpPK userbpPK;
            IUserbp userbp;
            Userbp_usecases userbpusecases = new Userbp_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IUserbpOperation.SELECT_COUNT:
                    result = count_records(userbpusecases);
                    break;
                case IUserbpOperation.SELECT_ALL:
                    result = get_all_userbp(userbpusecases);
                    break;
                case IUserbpOperation.SELECT_USERBP:
                    result = get_userbp_with_primarykey(userbpusecases, json);
                    break;
                case IUserbpOperation.SELECT_Evetype:
                    result = get_userbp_with_foreignkey_evetype(userbpusecases, json);
                    break;
                case IUserbpOperation.SELECT_SEARCH:
                    result = search_userbp(userbpusecases, json);
                    break;
                case IUserbpOperation.SELECT_SEARCHCOUNT:
                    result = search_userbp_count(userbpusecases, json);
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

    private String count_records(Userbp_usecases userbpusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", userbpusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_userbp(Userbp_usecases userbpusecases) throws ParseException, CustomException {
    	return JSONUserbp.toJSONArray(userbpusecases.get_all()).toJSONString();
    }
    
    private String get_userbp_with_primarykey(Userbp_usecases userbpusecases, JSONObject json) throws ParseException, CustomException {
        IUserbpPK userbpPK = (IUserbpPK)JSONUserbp.toUserbpPK((JSONObject)json.get("userbppk"));
	return JSONUserbp.toJSON(userbpusecases.get_userbp_by_primarykey(userbpPK)).toJSONString();
    }
    
    private String get_userbp_with_foreignkey_evetype(Userbp_usecases userbpusecases, JSONObject json) throws ParseException, CustomException {
        IEvetypePK evetypePK = (IEvetypePK)JSONEvetype.toEvetypePK((JSONObject)json.get("evetypepk"));
        return JSONUserbp.toJSONArray(userbpusecases.get_userbp_with_foreignkey_evetype(evetypePK)).toJSONString();
    }
    
    private String search_userbp(Userbp_usecases userbpusecases, JSONObject json) throws ParseException, CustomException {
        IUserbpsearch search = (IUserbpsearch)JSONUserbp.toUserbpsearch((JSONObject)json.get("search"));
        return JSONUserbp.toJSONArray(userbpusecases.search_userbp(search)).toJSONString();
    }
    
    private String search_userbp_count(Userbp_usecases userbpusecases, JSONObject json) throws ParseException, CustomException {
        IUserbpsearch userbpsearch = (IUserbpsearch)JSONUserbp.toUserbpsearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", userbpusecases.search_userbp_count(userbpsearch));
        return jsonsearchcount.toJSONString();
    }
}

