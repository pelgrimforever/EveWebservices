/*
 * Generated on 17.6.2022 13:4
 */

package eve.restservices.market_group;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.usecases.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.IMarket_groupsearch;
import eve.interfaces.servlet.IMarket_groupOperation;
import eve.logicentity.Market_group;
import eve.searchentity.Market_groupsearch;
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
@Path("rsmarket_group_delete")
public class RSMarket_group_delete extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Market_group_usecases market_groupusecases = new Market_group_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IMarket_groupOperation.DELETE_MARKET_GROUP:
                    delete_market_group(market_groupusecases, json);
                    break;
                case IMarket_groupOperation.DELETE_Market_groupparent_id:
                    delete_market_group(market_groupusecases, json);
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

    private void delete_market_group(Market_group_usecases market_groupusecases, JSONObject json) throws ParseException, CustomException {
        IMarket_group market_group = (IMarket_group)JSONMarket_group.toMarket_group((JSONObject)json.get("market_group"));
        market_groupusecases.deleteMarket_group(market_group);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Market_groupparent_id(Market_group_usecases market_groupusecases, JSONObject json) throws ParseException, CustomException {
        IMarket_groupPK market_groupParent_idPK = (IMarket_groupPK)JSONMarket_group.toMarket_groupPK((JSONObject)json.get("market_grouppk"));
        market_groupusecases.delete_all_containing_Market_groupparent_id(market_groupParent_idPK);
        setReturnstatus("OK");
    }

}

