/*
 * Generated on 17.6.2022 13:4
 */

package eve.restservices.stock;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.usecases.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.IStocksearch;
import eve.interfaces.servlet.IStockOperation;
import eve.logicentity.Stock;
import eve.searchentity.Stocksearch;
import eve.servlets.DataServlet;
import eve.usecases.*;
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
@Path("rsstock_update")
public class RSStock_update extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Stock_usecases stockusecases = new Stock_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IStockOperation.UPDATE_STOCK:
                    update_stock(stockusecases, json);
                    break;
//Custom code, do not change this line
//add here custom operations
                case IStockOperation.UPDATE_ADDSTOCK:
                    add_to_stock(stockusecases, json);
                    break;
                case IStockOperation.UPDATE_REMOVESTOCK:
                    remove_from_stock(stockusecases, json);
                    break;
                case IStockOperation.UPDATE_SELLSTOCKTRADE:
                    sell_from_Stocktrade(stockusecases, json);
                    break;
                case IStockOperation.UPDATE_SELLALL4SYSTEM:
                    sell_all_Stock_from_system(stockusecases, json);
                    break;                    
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
    private void add_to_stock(Stock_usecases stockusecases, JSONObject json) throws ParseException, CustomException {
        JSONObject jsonaddstock = (JSONObject)json.get("stock");
        IStock stock = JSONStock.toStock(jsonaddstock);
        stockusecases.add_to_stock(stock);
        setReturnstatus("OK");
    }

    private void remove_from_stock(Stock_usecases stockusecases, JSONObject json) throws ParseException, CustomException {
        JSONObject jsonremovestock = (JSONObject)json.get("stock");
        IStock stock = JSONStock.toStock(jsonremovestock);
        stockusecases.remove_from_stock(stock);
        setReturnstatus("OK");
    }

    private void sell_from_Stocktrade(Stock_usecases stockusecases, JSONObject json) throws ParseException, CustomException {
        IStocktrade stocktrade = (IStocktrade)JSONStocktrade.toStocktrade((JSONObject)json.get("stocktrade"));
        stockusecases.sell_from_Stocktrade(stocktrade);
        setReturnstatus("OK");
    }

    private void sell_all_Stock_from_system(Stock_usecases stockusecases, JSONObject json) throws ParseException, CustomException {
        String username = JSONConversion.getString(json, "username");
        long system = JSONConversion.getlong(json, "system");
        stockusecases.sell_all_Stock_from_system(username, system);
        setReturnstatus("OK");
    }
//Custom code, do not change this line   

    private void update_stock(Stock_usecases stockusecases, JSONObject json) throws ParseException, CustomException {
        IStock stock = (IStock)JSONStock.toStock((JSONObject)json.get("stock"));
        stockusecases.updateStock(stock);
        setReturnstatus("OK");
    }
}

