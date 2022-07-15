/*
 * WSGraphic.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 13.6.2022 18:20
 *
 */

package eve.webservices;

import base.restservices.RS_json_login;
import eve.BusinessObject.Logic.*;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.IGraphicsearch;
import eve.interfaces.webservice.WSIGraphic;
import eve.logicentity.Graphic;
import eve.searchentity.Graphicsearch;
import eve.usecases.*;
import general.exception.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.jws.WebMethod;
import javax.jws.WebService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import eve.usecases.custom.Security_usecases;

/**
 *
 * @author Franky Laseure
 */
@WebService(endpointInterface = "eve.interfaces.webservice.WSIGraphic")
public class WSGraphic extends RS_json_login implements WSIGraphic {

    private Security_usecases security_usecases = new Security_usecases();
    
    private JSONArray toJSONArray(ArrayList graphics) {
        JSONArray jsongraphics = new JSONArray();
        Iterator graphicsI = graphics.iterator();
        while(graphicsI.hasNext()) {
            jsongraphics.add(JSONGraphic.toJSON((Graphic)graphicsI.next()));
        }
        return jsongraphics;
    }

    //@WebMethod(operationName = "getGraphics")
    @Override
    public String getGraphics() {
        try {
            Graphic_usecases graphicusecases = new Graphic_usecases(loggedin);
            return get_all_graphic(graphicusecases);
        }
        catch(CustomException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Graphic_usecases graphicusecases = new Graphic_usecases(loggedin);
            return search_graphic(graphicusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getGraphic")
    @Override
    public String getGraphic(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Graphic_usecases graphicusecases = new Graphic_usecases(loggedin);
            return get_graphic_with_primarykey(graphicusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "insertGraphic")
    @Override
    public void insertGraphic(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Graphic_usecases graphicusecases = new Graphic_usecases(loggedin);
            insert_graphic(graphicusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "updateGraphic")
    @Override
    public void updateGraphic(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Graphic_usecases graphicusecases = new Graphic_usecases(loggedin);
            update_graphic(graphicusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "deleteGraphic")
    @Override
    public void deleteGraphic(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Graphic_usecases graphicusecases = new Graphic_usecases(loggedin);
            delete_graphic(graphicusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }


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

    private void insert_graphic(Graphic_usecases graphicusecases, JSONObject json) throws ParseException, CustomException {
        IGraphic graphic = (IGraphic)JSONGraphic.toGraphic((JSONObject)json.get("graphic"));
        graphicusecases.insertGraphic(graphic);
        setReturnstatus("OK");
    }

    private void update_graphic(Graphic_usecases graphicusecases, JSONObject json) throws ParseException, CustomException {
        IGraphic graphic = (IGraphic)JSONGraphic.toGraphic((JSONObject)json.get("graphic"));
        graphicusecases.updateGraphic(graphic);
        setReturnstatus("OK");
    }

    private void delete_graphic(Graphic_usecases graphicusecases, JSONObject json) throws ParseException, CustomException {
        IGraphic graphic = (IGraphic)JSONGraphic.toGraphic((JSONObject)json.get("graphic"));
        graphicusecases.deleteGraphic(graphic);
        setReturnstatus("OK");
    }

}

