/*
 * Generated on 13.6.2022 18:20
 */

package eve.restservices.constellation_neighbour;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.usecases.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.IConstellation_neighboursearch;
import eve.interfaces.servlet.IConstellation_neighbourOperation;
import eve.logicentity.Constellation_neighbour;
import eve.searchentity.Constellation_neighboursearch;
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
@Path("rsconstellation_neighbour_select")
public class RSConstellation_neighbour_select extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Constellation_neighbour_usecases constellation_neighbourusecases = new Constellation_neighbour_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IConstellation_neighbourOperation.SELECT_COUNT:
                    result = count_records(constellation_neighbourusecases);
                    break;
                case IConstellation_neighbourOperation.SELECT_ALL:
                    result = get_all_constellation_neighbour(constellation_neighbourusecases);
                    break;
                case IConstellation_neighbourOperation.SELECT_CONSTELLATION_NEIGHBOUR:
                    result = get_constellation_neighbour_with_primarykey(constellation_neighbourusecases, json);
                    break;
                case IConstellation_neighbourOperation.SELECT_Constellationneighbour:
                    result = get_constellation_neighbour_with_foreignkey_constellationNeighbour(constellation_neighbourusecases, json);
                    break;
                case IConstellation_neighbourOperation.SELECT_Constellationconstellation:
                    result = get_constellation_neighbour_with_foreignkey_constellationConstellation(constellation_neighbourusecases, json);
                    break;
                case IConstellation_neighbourOperation.SELECT_SEARCH:
                    result = search_constellation_neighbour(constellation_neighbourusecases, json);
                    break;
                case IConstellation_neighbourOperation.SELECT_SEARCHCOUNT:
                    result = search_constellation_neighbour_count(constellation_neighbourusecases, json);
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

    private String count_records(Constellation_neighbour_usecases constellation_neighbourusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", constellation_neighbourusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_constellation_neighbour(Constellation_neighbour_usecases constellation_neighbourusecases) throws ParseException, CustomException {
    	return JSONConstellation_neighbour.toJSONArray(constellation_neighbourusecases.get_all()).toJSONString();
    }
    
    private String get_constellation_neighbour_with_primarykey(Constellation_neighbour_usecases constellation_neighbourusecases, JSONObject json) throws ParseException, CustomException {
        IConstellation_neighbourPK constellation_neighbourPK = (IConstellation_neighbourPK)JSONConstellation_neighbour.toConstellation_neighbourPK((JSONObject)json.get("constellation_neighbourpk"));
	return JSONConstellation_neighbour.toJSON(constellation_neighbourusecases.get_constellation_neighbour_by_primarykey(constellation_neighbourPK)).toJSONString();
    }
    
    private String get_constellation_neighbour_with_foreignkey_constellationNeighbour(Constellation_neighbour_usecases constellation_neighbourusecases, JSONObject json) throws ParseException, CustomException {
        IConstellationPK constellationNeighbourPK = (IConstellationPK)JSONConstellation.toConstellationPK((JSONObject)json.get("constellationpk"));
        return JSONConstellation_neighbour.toJSONArray(constellation_neighbourusecases.get_constellation_neighbour_with_foreignkey_constellationNeighbour(constellationNeighbourPK)).toJSONString();
    }
    
    private String get_constellation_neighbour_with_foreignkey_constellationConstellation(Constellation_neighbour_usecases constellation_neighbourusecases, JSONObject json) throws ParseException, CustomException {
        IConstellationPK constellationConstellationPK = (IConstellationPK)JSONConstellation.toConstellationPK((JSONObject)json.get("constellationpk"));
        return JSONConstellation_neighbour.toJSONArray(constellation_neighbourusecases.get_constellation_neighbour_with_foreignkey_constellationConstellation(constellationConstellationPK)).toJSONString();
    }
    
    private String search_constellation_neighbour(Constellation_neighbour_usecases constellation_neighbourusecases, JSONObject json) throws ParseException, CustomException {
        IConstellation_neighboursearch search = (IConstellation_neighboursearch)JSONConstellation_neighbour.toConstellation_neighboursearch((JSONObject)json.get("search"));
        return JSONConstellation_neighbour.toJSONArray(constellation_neighbourusecases.search_constellation_neighbour(search)).toJSONString();
    }
    
    private String search_constellation_neighbour_count(Constellation_neighbour_usecases constellation_neighbourusecases, JSONObject json) throws ParseException, CustomException {
        IConstellation_neighboursearch constellation_neighboursearch = (IConstellation_neighboursearch)JSONConstellation_neighbour.toConstellation_neighboursearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", constellation_neighbourusecases.search_constellation_neighbour_count(constellation_neighboursearch));
        return jsonsearchcount.toJSONString();
    }
}

