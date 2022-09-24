/*
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */

package eve.restservices.constellation;

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
import eve.interfaces.searchentity.IConstellationsearch;
import eve.interfaces.servlet.IConstellationOperation;
import eve.logicentity.Constellation;
import eve.searchentity.Constellationsearch;
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

@Path("rsconstellation_select")
public class RSConstellation_select extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Constellation_usecases constellationusecases = new Constellation_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IConstellationOperation.SELECT_COUNT:
                    result = count_records(constellationusecases);
                    break;
                case IConstellationOperation.SELECT_ALL:
                    result = get_all_constellation(constellationusecases);
                    break;
                case IConstellationOperation.SELECT_CONSTELLATION:
                    result = get_constellation_with_primarykey(constellationusecases, json);
                    break;
                case IConstellationOperation.SELECT_Region:
                    result = get_constellation_with_foreignkey_region(constellationusecases, json);
                    break;
                case IConstellationOperation.SELECT_Constellation_neighbourneighbour:
                    result = get_constellation_with_externalforeignkey_constellation_neighbourNeighbour(constellationusecases, json);
                    break;
                case IConstellationOperation.SELECT_Constellation_neighbourconstellation:
                    result = get_constellation_with_externalforeignkey_constellation_neighbourConstellation(constellationusecases, json);
                    break;
                case IConstellationOperation.SELECT_SEARCH:
                    result = search_constellation(constellationusecases, json);
                    break;
                case IConstellationOperation.SELECT_SEARCHCOUNT:
                    result = search_constellation_count(constellationusecases, json);
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

    private String count_records(Constellation_usecases constellationusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", constellationusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_constellation(Constellation_usecases constellationusecases) throws ParseException, CustomException {
    	return JSONConstellation.toJSONArray(constellationusecases.get_all()).toJSONString();
    }
    
    private String get_constellation_with_primarykey(Constellation_usecases constellationusecases, JSONObject json) throws ParseException, CustomException {
        IConstellationPK constellationPK = (IConstellationPK)JSONConstellation.toConstellationPK((JSONObject)json.get("constellationpk"));
	return JSONConstellation.toJSON(constellationusecases.get_constellation_by_primarykey(constellationPK)).toJSONString();
    }
    
    private String get_constellation_with_foreignkey_region(Constellation_usecases constellationusecases, JSONObject json) throws ParseException, CustomException {
        IRegionPK regionPK = (IRegionPK)JSONRegion.toRegionPK((JSONObject)json.get("regionpk"));
        return JSONConstellation.toJSONArray(constellationusecases.get_constellation_with_foreignkey_region(regionPK)).toJSONString();
    }
    
    private String get_constellation_with_externalforeignkey_constellation_neighbourNeighbour(Constellation_usecases constellationusecases, JSONObject json) throws ParseException, CustomException {
        IConstellation_neighbourPK constellation_neighbourNeighbourPK = (IConstellation_neighbourPK)JSONConstellation_neighbour.toConstellation_neighbourPK((JSONObject)json.get("constellation_neighbourpk"));
        return JSONConstellation.toJSON(constellationusecases.get_constellation_with_externalforeignkey_constellation_neighbourNeighbour(constellation_neighbourNeighbourPK)).toJSONString();
    }
    
    private String get_constellation_with_externalforeignkey_constellation_neighbourConstellation(Constellation_usecases constellationusecases, JSONObject json) throws ParseException, CustomException {
        IConstellation_neighbourPK constellation_neighbourConstellationPK = (IConstellation_neighbourPK)JSONConstellation_neighbour.toConstellation_neighbourPK((JSONObject)json.get("constellation_neighbourpk"));
        return JSONConstellation.toJSON(constellationusecases.get_constellation_with_externalforeignkey_constellation_neighbourConstellation(constellation_neighbourConstellationPK)).toJSONString();
    }
    
    private String search_constellation(Constellation_usecases constellationusecases, JSONObject json) throws ParseException, CustomException {
        IConstellationsearch search = (IConstellationsearch)JSONConstellation.toConstellationsearch((JSONObject)json.get("search"));
        return JSONConstellation.toJSONArray(constellationusecases.search_constellation(search)).toJSONString();
    }
    
    private String search_constellation_count(Constellation_usecases constellationusecases, JSONObject json) throws ParseException, CustomException {
        IConstellationsearch constellationsearch = (IConstellationsearch)JSONConstellation.toConstellationsearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", constellationusecases.search_constellation_count(constellationsearch));
        return jsonsearchcount.toJSONString();
    }
}

