/*
 * Generated on 20.4.2022 10:3
 */

package eve.restservices.routetype;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.usecases.Routetype_usecases;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.IRoutetypesearch;
import eve.interfaces.servlet.IRoutetypeOperation;
import eve.logicentity.Routetype;
import eve.searchentity.Routetypesearch;
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
@Path("rsroutetype_select")
public class RSRoutetype_select extends RS_json_login {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(Security_usecases.check_authorization(authorisationstring));
            IRoutetypePK routetypePK;
            IRoutetype routetype;
            Routetype_usecases routetypeusecases = new Routetype_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IRoutetypeOperation.SELECT_COUNT:
                    result = count_records(routetypeusecases);
                    break;
                case IRoutetypeOperation.SELECT_ALL:
                    result = get_all_routetype(routetypeusecases);
                    break;
                case IRoutetypeOperation.SELECT_ROUTETYPE:
                    result = get_routetype_with_primarykey(routetypeusecases, json);
                    break;
                case IRoutetypeOperation.SELECT_Security_island:
                    result = get_routetype_with_foreignkey_security_island(routetypeusecases, json);
                    break;
                case IRoutetypeOperation.SELECT_SEARCH:
                    result = search_routetype(routetypeusecases, json);
                    break;
                case IRoutetypeOperation.SELECT_SEARCHCOUNT:
                    result = search_routetype_count(routetypeusecases, json);
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

    private String count_records(Routetype_usecases routetypeusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", routetypeusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_routetype(Routetype_usecases routetypeusecases) throws ParseException, CustomException {
    	return JSONRoutetype.toJSONArray(routetypeusecases.get_all()).toJSONString();
    }
    
    private String get_routetype_with_primarykey(Routetype_usecases routetypeusecases, JSONObject json) throws ParseException, CustomException {
        IRoutetypePK routetypePK = (IRoutetypePK)JSONRoutetype.toRoutetypePK((JSONObject)json.get("routetypepk"));
	return JSONRoutetype.toJSON(routetypeusecases.get_routetype_by_primarykey(routetypePK)).toJSONString();
    }
    
    private String get_routetype_with_foreignkey_security_island(Routetype_usecases routetypeusecases, JSONObject json) throws ParseException, CustomException {
        ISecurity_islandPK security_islandPK = (ISecurity_islandPK)JSONSecurity_island.toSecurity_islandPK((JSONObject)json.get("security_islandpk"));
        return JSONRoutetype.toJSONArray(routetypeusecases.get_routetype_with_foreignkey_security_island(security_islandPK)).toJSONString();
    }
    
    private String search_routetype(Routetype_usecases routetypeusecases, JSONObject json) throws ParseException, CustomException {
        IRoutetypesearch search = (IRoutetypesearch)JSONRoutetype.toRoutetypesearch((JSONObject)json.get("search"));
        return JSONRoutetype.toJSONArray(routetypeusecases.search_routetype(search)).toJSONString();
    }
    
    private String search_routetype_count(Routetype_usecases routetypeusecases, JSONObject json) throws ParseException, CustomException {
        IRoutetypesearch routetypesearch = (IRoutetypesearch)JSONRoutetype.toRoutetypesearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", routetypeusecases.search_routetype_count(routetypesearch));
        return jsonsearchcount.toJSONString();
    }
}

