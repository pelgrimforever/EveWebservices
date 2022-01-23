/*
 * RSEvetype.java
 *
 * Generated on 17.0.2022 13:37
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
import eve.interfaces.searchentity.IEvetypesearch;
import eve.interfaces.servlet.IEvetypeOperation;
import eve.logicentity.Evetype;
import eve.searchentity.Evetypesearch;
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
@Path("rsevetype")
public class RSEvetype {

    /**
     * Creates a new instance of HelloWorld
     */
    public RSEvetype() {
    }

    /**
     * Retrieves representation of an instance of evetype.restservices.RSEvetype
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLevetype blevetype = new BLevetype();
            ArrayList evetypes = blevetype.getAll();
            JSONArray jsonevetypes = JSONEvetype.toJSONArray(evetypes);
            return jsonevetypes.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of evetype.restservices.RSEvetype
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLevetype blevetype = new BLevetype();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            IEvetypePK evetypePK;
            IEvetype evetype;
//Security parameters
            boolean loggedin = RSsecurity.check(json);
            blevetype.setAuthenticated(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case IEvetypeOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blevetype.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IEvetypeOperation.SELECT_ALL:
                            result = JSONEvetype.toJSONArray(blevetype.getEvetypes()).toJSONString();
                            break;
                        case IEvetypeOperation.SELECT_EVETYPE:
                            evetypePK = (IEvetypePK)JSONEvetype.toEvetypePK((JSONObject)json.get("evetypepk"));
                            result = JSONEvetype.toJSON(blevetype.getEvetype(evetypePK)).toJSONString();
                            break;
                        case IEvetypeOperation.SELECT_Market_group:
                            IMarket_groupPK market_groupPK = (IMarket_groupPK)JSONMarket_group.toMarket_groupPK((JSONObject)json.get("market_grouppk"));
                            result = JSONEvetype.toJSONArray(blevetype.getEvetypes4market_group(market_groupPK)).toJSONString();
                            break;
                        case IEvetypeOperation.SELECT_Typegroup:
                            ITypegroupPK typegroupPK = (ITypegroupPK)JSONTypegroup.toTypegroupPK((JSONObject)json.get("typegrouppk"));
                            result = JSONEvetype.toJSONArray(blevetype.getEvetypes4typegroup(typegroupPK)).toJSONString();
                            break;
                        case IEvetypeOperation.SELECT_Graphic:
                            IGraphicPK graphicPK = (IGraphicPK)JSONGraphic.toGraphicPK((JSONObject)json.get("graphicpk"));
                            result = JSONEvetype.toJSONArray(blevetype.getEvetypes4graphic(graphicPK)).toJSONString();
                            break;
                        case IEvetypeOperation.SELECT_Wishlist:
                            IWishlistPK wishlistPK = (IWishlistPK)JSONWishlist.toWishlistPK((JSONObject)json.get("wishlistpk"));
                            result = JSONEvetype.toJSON(blevetype.getWishlist(wishlistPK)).toJSONString();
                            break;
                        case IEvetypeOperation.SELECT_Materialinput:
                            IMaterialinputPK materialinputPK = (IMaterialinputPK)JSONMaterialinput.toMaterialinputPK((JSONObject)json.get("materialinputpk"));
                            result = JSONEvetype.toJSON(blevetype.getMaterialinput(materialinputPK)).toJSONString();
                            break;
                        case IEvetypeOperation.SELECT_Order_history_month:
                            IOrder_history_monthPK order_history_monthPK = (IOrder_history_monthPK)JSONOrder_history_month.toOrder_history_monthPK((JSONObject)json.get("order_history_monthpk"));
                            result = JSONEvetype.toJSON(blevetype.getOrder_history_month(order_history_monthPK)).toJSONString();
                            break;
                        case IEvetypeOperation.SELECT_Stock:
                            IStockPK stockPK = (IStockPK)JSONStock.toStockPK((JSONObject)json.get("stockpk"));
                            result = JSONEvetype.toJSON(blevetype.getStock(stockPK)).toJSONString();
                            break;
                        case IEvetypeOperation.SELECT_Order_history:
                            IOrder_historyPK order_historyPK = (IOrder_historyPK)JSONOrder_history.toOrder_historyPK((JSONObject)json.get("order_historypk"));
                            result = JSONEvetype.toJSON(blevetype.getOrder_history(order_historyPK)).toJSONString();
                            break;
                        case IEvetypeOperation.SELECT_Shipfitmodule:
                            IShipfitmodulePK shipfitmodulePK = (IShipfitmodulePK)JSONShipfitmodule.toShipfitmodulePK((JSONObject)json.get("shipfitmodulepk"));
                            result = JSONEvetype.toJSON(blevetype.getShipfitmodule(shipfitmodulePK)).toJSONString();
                            break;
                        case IEvetypeOperation.SELECT_Shipfitorder:
                            IShipfitorderPK shipfitorderPK = (IShipfitorderPK)JSONShipfitorder.toShipfitorderPK((JSONObject)json.get("shipfitorderpk"));
                            result = JSONEvetype.toJSON(blevetype.getShipfitorder(shipfitorderPK)).toJSONString();
                            break;
                        case IEvetypeOperation.SELECT_Tradecombined:
                            ITradecombinedPK tradecombinedPK = (ITradecombinedPK)JSONTradecombined.toTradecombinedPK((JSONObject)json.get("tradecombinedpk"));
                            result = JSONEvetype.toJSON(blevetype.getTradecombined(tradecombinedPK)).toJSONString();
                            break;
                        case IEvetypeOperation.SELECT_SEARCH:
                            IEvetypesearch search = (IEvetypesearch)JSONEvetype.toEvetypesearch((JSONObject)json.get("search"));
                            result = JSONEvetype.toJSONArray(blevetype.search(search)).toJSONString();
                            break;
                        case IEvetypeOperation.SELECT_SEARCHCOUNT:
                            IEvetypesearch evetypesearch = (IEvetypesearch)JSONEvetype.toEvetypesearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blevetype.searchcount(evetypesearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(operation) {
                        case IEvetypeOperation.INSERT_EVETYPE:
                            evetype = (IEvetype)JSONEvetype.toEvetype((JSONObject)json.get("evetype"));
                            blevetype.insertEvetype(evetype);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(operation) {
                        case IEvetypeOperation.UPDATE_EVETYPE:
                            JSONObject jsonevetype = (JSONObject)json.get("evetype");
                            evetypePK = JSONEvetype.toEvetypePK((JSONObject)jsonevetype.get("PK"));
                            evetype = blevetype.getEvetype(evetypePK);
                            JSONEvetype.updateEvetype(evetype, jsonevetype);
                            blevetype.updateEvetype(evetype);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(operation) {
                        case IEvetypeOperation.DELETE_EVETYPE:
                            evetype = (IEvetype)JSONEvetype.toEvetype((JSONObject)json.get("evetype"));
                            blevetype.deleteEvetype(evetype);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECURESELECT:
                    switch(operation) {
                        case IEvetypeOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blevetype.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IEvetypeOperation.SELECT_ALL:
                            result = JSONEvetype.toJSONArray(blevetype.getEvetypes()).toJSONString();
                            break;
                        case IEvetypeOperation.SELECT_EVETYPE:
                            evetypePK = (IEvetypePK)JSONEvetype.toEvetypePK((JSONObject)json.get("evetypepk"));
                            result = JSONEvetype.toJSON(blevetype.getEvetype(evetypePK)).toJSONString();
                            break;
                        case IEvetypeOperation.SELECT_Market_group:
                            IMarket_groupPK market_groupPK = (IMarket_groupPK)JSONMarket_group.toMarket_groupPK((JSONObject)json.get("market_grouppk"));
                            result = JSONEvetype.toJSONArray(blevetype.getEvetypes4market_group(market_groupPK)).toJSONString();
                            break;
                        case IEvetypeOperation.SELECT_Typegroup:
                            ITypegroupPK typegroupPK = (ITypegroupPK)JSONTypegroup.toTypegroupPK((JSONObject)json.get("typegrouppk"));
                            result = JSONEvetype.toJSONArray(blevetype.getEvetypes4typegroup(typegroupPK)).toJSONString();
                            break;
                        case IEvetypeOperation.SELECT_Graphic:
                            IGraphicPK graphicPK = (IGraphicPK)JSONGraphic.toGraphicPK((JSONObject)json.get("graphicpk"));
                            result = JSONEvetype.toJSONArray(blevetype.getEvetypes4graphic(graphicPK)).toJSONString();
                            break;
                        case IEvetypeOperation.SELECT_Wishlist:
                            IWishlistPK wishlistPK = (IWishlistPK)JSONWishlist.toWishlistPK((JSONObject)json.get("wishlistpk"));
                            result = JSONEvetype.toJSON(blevetype.getWishlist(wishlistPK)).toJSONString();
                            break;
                        case IEvetypeOperation.SELECT_Materialinput:
                            IMaterialinputPK materialinputPK = (IMaterialinputPK)JSONMaterialinput.toMaterialinputPK((JSONObject)json.get("materialinputpk"));
                            result = JSONEvetype.toJSON(blevetype.getMaterialinput(materialinputPK)).toJSONString();
                            break;
                        case IEvetypeOperation.SELECT_Order_history_month:
                            IOrder_history_monthPK order_history_monthPK = (IOrder_history_monthPK)JSONOrder_history_month.toOrder_history_monthPK((JSONObject)json.get("order_history_monthpk"));
                            result = JSONEvetype.toJSON(blevetype.getOrder_history_month(order_history_monthPK)).toJSONString();
                            break;
                        case IEvetypeOperation.SELECT_Stock:
                            IStockPK stockPK = (IStockPK)JSONStock.toStockPK((JSONObject)json.get("stockpk"));
                            result = JSONEvetype.toJSON(blevetype.getStock(stockPK)).toJSONString();
                            break;
                        case IEvetypeOperation.SELECT_Order_history:
                            IOrder_historyPK order_historyPK = (IOrder_historyPK)JSONOrder_history.toOrder_historyPK((JSONObject)json.get("order_historypk"));
                            result = JSONEvetype.toJSON(blevetype.getOrder_history(order_historyPK)).toJSONString();
                            break;
                        case IEvetypeOperation.SELECT_Shipfitmodule:
                            IShipfitmodulePK shipfitmodulePK = (IShipfitmodulePK)JSONShipfitmodule.toShipfitmodulePK((JSONObject)json.get("shipfitmodulepk"));
                            result = JSONEvetype.toJSON(blevetype.getShipfitmodule(shipfitmodulePK)).toJSONString();
                            break;
                        case IEvetypeOperation.SELECT_Shipfitorder:
                            IShipfitorderPK shipfitorderPK = (IShipfitorderPK)JSONShipfitorder.toShipfitorderPK((JSONObject)json.get("shipfitorderpk"));
                            result = JSONEvetype.toJSON(blevetype.getShipfitorder(shipfitorderPK)).toJSONString();
                            break;
                        case IEvetypeOperation.SELECT_Tradecombined:
                            ITradecombinedPK tradecombinedPK = (ITradecombinedPK)JSONTradecombined.toTradecombinedPK((JSONObject)json.get("tradecombinedpk"));
                            result = JSONEvetype.toJSON(blevetype.getTradecombined(tradecombinedPK)).toJSONString();
                            break;
                        case IEvetypeOperation.SELECT_SEARCH:
                            IEvetypesearch search = (IEvetypesearch)JSONEvetype.toEvetypesearch((JSONObject)json.get("search"));
                            result = JSONEvetype.toJSONArray(blevetype.search(search)).toJSONString();
                            break;
                        case IEvetypeOperation.SELECT_SEARCHCOUNT:
                            IEvetypesearch evetypesearch = (IEvetypesearch)JSONEvetype.toEvetypesearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blevetype.searchcount(evetypesearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREINSERT:
                    switch(operation) {
                        case IEvetypeOperation.INSERT_EVETYPE:
                            evetype = (IEvetype)JSONEvetype.toEvetype((JSONObject)json.get("evetype"));
                            blevetype.secureinsertEvetype(evetype);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREUPDATE:
                    switch(operation) {
                        case IEvetypeOperation.UPDATE_EVETYPE:
                            JSONObject jsonevetype = (JSONObject)json.get("evetype");
                            evetypePK = JSONEvetype.toEvetypePK((JSONObject)jsonevetype.get("PK"));
                            evetype = blevetype.getEvetype(evetypePK);
                            JSONEvetype.updateEvetype(evetype, jsonevetype);
                            blevetype.secureupdateEvetype(evetype);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREDELETE:
                    switch(operation) {
                        case IEvetypeOperation.DELETE_EVETYPE:
                            evetype = (IEvetype)JSONEvetype.toEvetype((JSONObject)json.get("evetype"));
                            blevetype.securedeleteEvetype(evetype);
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
     * PUT method for updating or creating an instance of RSEvetype
     * @param content representation for the resource
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

