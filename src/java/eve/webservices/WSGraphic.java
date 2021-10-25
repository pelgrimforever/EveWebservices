/*
 * WSGraphic.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 25.9.2021 15:16
 *
 */

package eve.webservices;

import eve.BusinessObject.Logic.*;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.webservice.WSIGraphic;
import eve.logicentity.Graphic;
import eve.searchentity.Graphicsearch;
import general.exception.CustomException;
import general.exception.DataException;
import general.exception.DBException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.jws.WebMethod;
import javax.jws.WebService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Franky Laseure
 */
@WebService(endpointInterface = "eve.interfaces.webservice.WSIGraphic")
public class WSGraphic implements WSIGraphic {

    private JSONArray toJSONArray(ArrayList graphics) {
        JSONArray jsongraphics = new JSONArray();
        Iterator graphicsI = graphics.iterator();
        while(graphicsI.hasNext()) {
            jsongraphics.add(JSONGraphic.toJSON((Graphic)graphicsI.next()));
        }
        return jsongraphics;
    }

    /**
     * Web service operation
     */
    //@WebMethod(operationName = "getGraphics")
    @Override
    public String getGraphics() {
        try {
            BLgraphic blgraphic = new BLgraphic();
            ArrayList graphics = blgraphic.getAll();
            JSONArray jsongraphics = toJSONArray(graphics);
            return jsongraphics.toJSONString();
        }
        catch(DBException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String json) {
        BLgraphic blgraphic = new BLgraphic();
        JSONParser parser = new JSONParser();
        String result = "";
        Graphic graphic;
        try {
            Graphicsearch graphicsearch = JSONGraphic.toGraphicsearch((JSONObject)parser.parse(json));
            ArrayList graphics = blgraphic.search(graphicsearch);
            JSONArray jsongraphics = toJSONArray(graphics);
            result = jsongraphics.toJSONString();
        }
        catch(ParseException e) {
            result = "";
        }
        catch(DBException e) {
            result = "";
        }
        return result;
    }

    //@WebMethod(operationName = "getGraphic")
    @Override
    public String getGraphic(String json) {
        BLgraphic blgraphic = new BLgraphic();
        JSONParser parser = new JSONParser();
        String result = "";
        Graphic graphic;
        try {
            GraphicPK graphicPK = JSONGraphic.toGraphicPK((JSONObject)parser.parse(json));
            graphic = blgraphic.getGraphic(graphicPK);
            if(graphic!=null) {
                result = JSONGraphic.toJSON(graphic).toJSONString();
            }
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
        return result;
    }

    //@WebMethod(operationName = "insertGraphic")
    @Override
    public void insertGraphic(String json) {
        BLgraphic blgraphic = new BLgraphic();
        JSONParser parser = new JSONParser();
        try {
            IGraphic graphic = JSONGraphic.toGraphic((JSONObject)parser.parse(json));
            blgraphic.insertGraphic(graphic);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "updateGraphic")
    @Override
    public void updateGraphic(String json) {
        BLgraphic blgraphic = new BLgraphic();
        JSONParser parser = new JSONParser();
        try {
            IGraphic graphic = JSONGraphic.toGraphic((JSONObject)parser.parse(json));
            blgraphic.updateGraphic(graphic);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "deleteGraphic")
    @Override
    public void deleteGraphic(String json) {
        BLgraphic blgraphic = new BLgraphic();
        JSONParser parser = new JSONParser();
        try {
            IGraphic graphic = JSONGraphic.toGraphic((JSONObject)parser.parse(json));
            blgraphic.deleteGraphic(graphic);
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
    }


}

