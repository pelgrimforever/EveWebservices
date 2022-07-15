/*
 * Generated on 13.6.2022 18:20
 */

package eve.restservices.graphic;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.usecases.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.IGraphicsearch;
import eve.interfaces.servlet.IGraphicOperation;
import eve.logicentity.Graphic;
import eve.searchentity.Graphicsearch;
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
@Path("rsgraphic_select")
public class RSGraphic_select extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Graphic_usecases graphicusecases = new Graphic_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IGraphicOperation.SELECT_COUNT:
                    result = count_records(graphicusecases);
                    break;
                case IGraphicOperation.SELECT_ALL:
                    result = get_all_graphic(graphicusecases);
                    break;
                case IGraphicOperation.SELECT_GRAPHIC:
                    result = get_graphic_with_primarykey(graphicusecases, json);
                    break;
                case IGraphicOperation.SELECT_SEARCH:
                    result = search_graphic(graphicusecases, json);
                    break;
                case IGraphicOperation.SELECT_SEARCHCOUNT:
                    result = search_graphic_count(graphicusecases, json);
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

    private String count_records(Graphic_usecases graphicusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", graphicusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_graphic(Graphic_usecases graphicusecases) throws ParseException, CustomException {
    	return JSONGraphic.toJSONArray(graphicusecases.get_all()).toJSONString();
    }
    
    private String get_graphic_with_primarykey(Graphic_usecases graphicusecases, JSONObject json) throws ParseException, CustomException {
        IGraphicPK graphicPK = (IGraphicPK)JSONGraphic.toGraphicPK((JSONObject)json.get("graphicpk"));
	return JSONGraphic.toJSON(graphicusecases.get_graphic_by_primarykey(graphicPK)).toJSONString();
    }
    
    private String search_graphic(Graphic_usecases graphicusecases, JSONObject json) throws ParseException, CustomException {
        IGraphicsearch search = (IGraphicsearch)JSONGraphic.toGraphicsearch((JSONObject)json.get("search"));
        return JSONGraphic.toJSONArray(graphicusecases.search_graphic(search)).toJSONString();
    }
    
    private String search_graphic_count(Graphic_usecases graphicusecases, JSONObject json) throws ParseException, CustomException {
        IGraphicsearch graphicsearch = (IGraphicsearch)JSONGraphic.toGraphicsearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", graphicusecases.search_graphic_count(graphicsearch));
        return jsonsearchcount.toJSONString();
    }
}

