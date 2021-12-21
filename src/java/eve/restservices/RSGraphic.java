/*
 * RSGraphic.java
 *
 * Generated on 16.11.2021 15:46
 *
 */

package eve.restservices;

import base.servlets.Securitycheck;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import eve.BusinessObject.Logic.*;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.IGraphicsearch;
import eve.interfaces.servlet.IGraphicOperation;
import eve.logicentity.Graphic;
import eve.searchentity.Graphicsearch;
import eve.servlets.DataServlet;
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
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * REST Web Service
 *
 * @author Franky Laseure
 */
@Path("rsgraphic")
public class RSGraphic {

    /**
     * Creates a new instance of HelloWorld
     */
    public RSGraphic() {
    }

    /**
     * Retrieves representation of an instance of graphic.restservices.RSGraphic
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLgraphic blgraphic = new BLgraphic();
            ArrayList graphics = blgraphic.getAll();
            JSONArray jsongraphics = JSONGraphic.toJSONArray(graphics);
            return jsongraphics.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of graphic.restservices.RSGraphic
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLgraphic blgraphic = new BLgraphic();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            IGraphicPK graphicPK;
            IGraphic graphic;
//Security parameters
            boolean loggedin = RSsecurity.check(json);
            blgraphic.setAuthenticated(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case IGraphicOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blgraphic.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IGraphicOperation.SELECT_ALL:
                            result = JSONGraphic.toJSONArray(blgraphic.getGraphics()).toJSONString();
                            break;
                        case IGraphicOperation.SELECT_GRAPHIC:
                            graphicPK = (IGraphicPK)JSONGraphic.toGraphicPK((JSONObject)json.get("graphicpk"));
                            result = JSONGraphic.toJSON(blgraphic.getGraphic(graphicPK)).toJSONString();
                            break;
                        case IGraphicOperation.SELECT_SEARCH:
                            IGraphicsearch search = (IGraphicsearch)JSONGraphic.toGraphicsearch((JSONObject)json.get("search"));
                            result = JSONGraphic.toJSONArray(blgraphic.search(search)).toJSONString();
                            break;
                        case IGraphicOperation.SELECT_SEARCHCOUNT:
                            IGraphicsearch graphicsearch = (IGraphicsearch)JSONGraphic.toGraphicsearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blgraphic.searchcount(graphicsearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(operation) {
                        case IGraphicOperation.INSERT_GRAPHIC:
                            graphic = (IGraphic)JSONGraphic.toGraphic((JSONObject)json.get("graphic"));
                            blgraphic.insertGraphic(graphic);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(operation) {
                        case IGraphicOperation.UPDATE_GRAPHIC:
                            JSONObject jsongraphic = (JSONObject)json.get("graphic");
                            graphicPK = JSONGraphic.toGraphicPK((JSONObject)jsongraphic.get("PK"));
                            graphic = blgraphic.getGraphic(graphicPK);
                            JSONGraphic.updateGraphic(graphic, jsongraphic);
                            blgraphic.updateGraphic(graphic);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(operation) {
                        case IGraphicOperation.DELETE_GRAPHIC:
                            graphic = (IGraphic)JSONGraphic.toGraphic((JSONObject)json.get("graphic"));
                            blgraphic.deleteGraphic(graphic);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECURESELECT:
                    switch(operation) {
                        case IGraphicOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blgraphic.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IGraphicOperation.SELECT_ALL:
                            result = JSONGraphic.toJSONArray(blgraphic.getGraphics()).toJSONString();
                            break;
                        case IGraphicOperation.SELECT_GRAPHIC:
                            graphicPK = (IGraphicPK)JSONGraphic.toGraphicPK((JSONObject)json.get("graphicpk"));
                            result = JSONGraphic.toJSON(blgraphic.getGraphic(graphicPK)).toJSONString();
                            break;
                        case IGraphicOperation.SELECT_SEARCH:
                            IGraphicsearch search = (IGraphicsearch)JSONGraphic.toGraphicsearch((JSONObject)json.get("search"));
                            result = JSONGraphic.toJSONArray(blgraphic.search(search)).toJSONString();
                            break;
                        case IGraphicOperation.SELECT_SEARCHCOUNT:
                            IGraphicsearch graphicsearch = (IGraphicsearch)JSONGraphic.toGraphicsearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blgraphic.searchcount(graphicsearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREINSERT:
                    switch(operation) {
                        case IGraphicOperation.INSERT_GRAPHIC:
                            graphic = (IGraphic)JSONGraphic.toGraphic((JSONObject)json.get("graphic"));
                            blgraphic.secureinsertGraphic(graphic);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREUPDATE:
                    switch(operation) {
                        case IGraphicOperation.UPDATE_GRAPHIC:
                            JSONObject jsongraphic = (JSONObject)json.get("graphic");
                            graphicPK = JSONGraphic.toGraphicPK((JSONObject)jsongraphic.get("PK"));
                            graphic = blgraphic.getGraphic(graphicPK);
                            JSONGraphic.updateGraphic(graphic, jsongraphic);
                            blgraphic.secureupdateGraphic(graphic);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREDELETE:
                    switch(operation) {
                        case IGraphicOperation.DELETE_GRAPHIC:
                            graphic = (IGraphic)JSONGraphic.toGraphic((JSONObject)json.get("graphic"));
                            blgraphic.securedeleteGraphic(graphic);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
            }
        }
        catch(ParseException e) {
            result = returnstatus(e.getMessage());
        }
        catch(CustomException e) {
            result = returnstatus(e.getMessage());
        }
        return result;
    }

    private String returnstatus(String status) {
        JSONObject json = new JSONObject();
        json.put("status", status);
        return json.toJSONString();
    }

    /**
     * PUT method for updating or creating an instance of RSGraphic
     * @param content representation for the resource
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

