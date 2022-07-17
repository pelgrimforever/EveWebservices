/*
 * Generated on 17.6.2022 13:4
 */

package eve.restservices.contractitem;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.usecases.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.IContractitemsearch;
import eve.interfaces.servlet.IContractitemOperation;
import eve.logicentity.Contractitem;
import eve.searchentity.Contractitemsearch;
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
@Path("rscontractitem_delete")
public class RSContractitem_delete extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Contractitem_usecases contractitemusecases = new Contractitem_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IContractitemOperation.DELETE_CONTRACTITEM:
                    delete_contractitem(contractitemusecases, json);
                    break;
                case IContractitemOperation.DELETE_Evetype:
                    delete_contractitem(contractitemusecases, json);
                    break;
                case IContractitemOperation.DELETE_Contract:
                    delete_contractitem(contractitemusecases, json);
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

    private void delete_contractitem(Contractitem_usecases contractitemusecases, JSONObject json) throws ParseException, CustomException {
        IContractitem contractitem = (IContractitem)JSONContractitem.toContractitem((JSONObject)json.get("contractitem"));
        contractitemusecases.deleteContractitem(contractitem);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Evetype(Contractitem_usecases contractitemusecases, JSONObject json) throws ParseException, CustomException {
        IEvetypePK evetypePK = (IEvetypePK)JSONEvetype.toEvetypePK((JSONObject)json.get("evetypepk"));
        contractitemusecases.delete_all_containing_Evetype(evetypePK);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Contract(Contractitem_usecases contractitemusecases, JSONObject json) throws ParseException, CustomException {
        IContractPK contractPK = (IContractPK)JSONContract.toContractPK((JSONObject)json.get("contractpk"));
        contractitemusecases.delete_all_containing_Contract(contractPK);
        setReturnstatus("OK");
    }

}

