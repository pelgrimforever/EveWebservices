/*
 * Generated on 20.4.2022 10:3
 */

package eve.restservices.allnodes_stargate;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.usecases.Allnodes_stargate_usecases;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.IAllnodes_stargatesearch;
import eve.interfaces.servlet.IAllnodes_stargateOperation;
import eve.logicentity.Allnodes_stargate;
import eve.searchentity.Allnodes_stargatesearch;
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
@Path("rsallnodes_stargate_select")
public class RSAllnodes_stargate_select extends RS_json_login {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(Security_usecases.check_authorization(authorisationstring));
            IAllnodes_stargatePK allnodes_stargatePK;
            IAllnodes_stargate allnodes_stargate;
            Allnodes_stargate_usecases allnodes_stargateusecases = new Allnodes_stargate_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IAllnodes_stargateOperation.SELECT_COUNT:
                    result = count_records(allnodes_stargateusecases);
                    break;
                case IAllnodes_stargateOperation.SELECT_ALL:
                    result = get_all_allnodes_stargate(allnodes_stargateusecases);
                    break;
                case IAllnodes_stargateOperation.SELECT_ALLNODES_STARGATE:
                    result = get_allnodes_stargate_with_primarykey(allnodes_stargateusecases, json);
                    break;
                case IAllnodes_stargateOperation.SELECT_SEARCH:
                    result = search_allnodes_stargate(allnodes_stargateusecases, json);
                    break;
                case IAllnodes_stargateOperation.SELECT_SEARCHCOUNT:
                    result = search_allnodes_stargate_count(allnodes_stargateusecases, json);
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

    private String count_records(Allnodes_stargate_usecases allnodes_stargateusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", allnodes_stargateusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_allnodes_stargate(Allnodes_stargate_usecases allnodes_stargateusecases) throws ParseException, CustomException {
    	return JSONAllnodes_stargate.toJSONArray(allnodes_stargateusecases.get_all()).toJSONString();
    }
    
    private String get_allnodes_stargate_with_primarykey(Allnodes_stargate_usecases allnodes_stargateusecases, JSONObject json) throws ParseException, CustomException {
        IAllnodes_stargatePK allnodes_stargatePK = (IAllnodes_stargatePK)JSONAllnodes_stargate.toAllnodes_stargatePK((JSONObject)json.get("allnodes_stargatepk"));
	return JSONAllnodes_stargate.toJSON(allnodes_stargateusecases.get_allnodes_stargate_by_primarykey(allnodes_stargatePK)).toJSONString();
    }
    
    private String search_allnodes_stargate(Allnodes_stargate_usecases allnodes_stargateusecases, JSONObject json) throws ParseException, CustomException {
        IAllnodes_stargatesearch search = (IAllnodes_stargatesearch)JSONAllnodes_stargate.toAllnodes_stargatesearch((JSONObject)json.get("search"));
        return JSONAllnodes_stargate.toJSONArray(allnodes_stargateusecases.search_allnodes_stargate(search)).toJSONString();
    }
    
    private String search_allnodes_stargate_count(Allnodes_stargate_usecases allnodes_stargateusecases, JSONObject json) throws ParseException, CustomException {
        IAllnodes_stargatesearch allnodes_stargatesearch = (IAllnodes_stargatesearch)JSONAllnodes_stargate.toAllnodes_stargatesearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", allnodes_stargateusecases.search_allnodes_stargate_count(allnodes_stargatesearch));
        return jsonsearchcount.toJSONString();
    }
}

