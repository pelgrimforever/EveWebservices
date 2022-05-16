/*
 * Generated on 13.4.2022 19:13
 */

package eve.restservices.stargate;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.usecases.Stargate_usecases;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.IStargatesearch;
import eve.interfaces.servlet.IStargateOperation;
import eve.logicentity.Stargate;
import eve.searchentity.Stargatesearch;
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
@Path("rsstargate_select")
public class RSStargate_select extends RS_json_login {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(Security_usecases.check_authorization(authorisationstring));
            IStargatePK stargatePK;
            IStargate stargate;
            Stargate_usecases stargateusecases = new Stargate_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IStargateOperation.SELECT_COUNT:
                    result = count_records(stargateusecases);
                    break;
                case IStargateOperation.SELECT_ALL:
                    result = get_all_stargate(stargateusecases);
                    break;
                case IStargateOperation.SELECT_STARGATE:
                    result = get_stargate_with_primarykey(stargateusecases, json);
                    break;
                case IStargateOperation.SELECT_Systemsystem:
                    result = get_stargate_with_foreignkey_systemSystem(stargateusecases, json);
                    break;
                case IStargateOperation.SELECT_Systemto_system:
                    result = get_stargate_with_foreignkey_systemTo_system(stargateusecases, json);
                    break;
                case IStargateOperation.SELECT_SEARCH:
                    result = search_stargate(stargateusecases, json);
                    break;
                case IStargateOperation.SELECT_SEARCHCOUNT:
                    result = search_stargate_count(stargateusecases, json);
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

    private String count_records(Stargate_usecases stargateusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", stargateusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_stargate(Stargate_usecases stargateusecases) throws ParseException, CustomException {
    	return JSONStargate.toJSONArray(stargateusecases.get_all()).toJSONString();
    }
    
    private String get_stargate_with_primarykey(Stargate_usecases stargateusecases, JSONObject json) throws ParseException, CustomException {
        IStargatePK stargatePK = (IStargatePK)JSONStargate.toStargatePK((JSONObject)json.get("stargatepk"));
	return JSONStargate.toJSON(stargateusecases.get_stargate_by_primarykey(stargatePK)).toJSONString();
    }
    
    private String get_stargate_with_foreignkey_systemSystem(Stargate_usecases stargateusecases, JSONObject json) throws ParseException, CustomException {
        ISystemPK systemSystemPK = (ISystemPK)JSONSystem.toSystemPK((JSONObject)json.get("systempk"));
        return JSONStargate.toJSONArray(stargateusecases.get_stargate_with_foreignkey_systemSystem(systemSystemPK)).toJSONString();
    }
    
    private String get_stargate_with_foreignkey_systemTo_system(Stargate_usecases stargateusecases, JSONObject json) throws ParseException, CustomException {
        ISystemPK systemTo_systemPK = (ISystemPK)JSONSystem.toSystemPK((JSONObject)json.get("systempk"));
        return JSONStargate.toJSONArray(stargateusecases.get_stargate_with_foreignkey_systemTo_system(systemTo_systemPK)).toJSONString();
    }
    
    private String search_stargate(Stargate_usecases stargateusecases, JSONObject json) throws ParseException, CustomException {
        IStargatesearch search = (IStargatesearch)JSONStargate.toStargatesearch((JSONObject)json.get("search"));
        return JSONStargate.toJSONArray(stargateusecases.search_stargate(search)).toJSONString();
    }
    
    private String search_stargate_count(Stargate_usecases stargateusecases, JSONObject json) throws ParseException, CustomException {
        IStargatesearch stargatesearch = (IStargatesearch)JSONStargate.toStargatesearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", stargateusecases.search_stargate_count(stargatesearch));
        return jsonsearchcount.toJSONString();
    }
}

