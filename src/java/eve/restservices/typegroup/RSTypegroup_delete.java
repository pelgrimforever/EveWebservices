/*
 * Generated on 13.6.2022 18:20
 */

package eve.restservices.typegroup;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.usecases.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.ITypegroupsearch;
import eve.interfaces.servlet.ITypegroupOperation;
import eve.logicentity.Typegroup;
import eve.searchentity.Typegroupsearch;
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
@Path("rstypegroup_delete")
public class RSTypegroup_delete extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Typegroup_usecases typegroupusecases = new Typegroup_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case ITypegroupOperation.DELETE_TYPEGROUP:
                    delete_typegroup(typegroupusecases, json);
                    break;
                case ITypegroupOperation.DELETE_Category:
                    delete_typegroup(typegroupusecases, json);
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

    private void delete_typegroup(Typegroup_usecases typegroupusecases, JSONObject json) throws ParseException, CustomException {
        ITypegroup typegroup = (ITypegroup)JSONTypegroup.toTypegroup((JSONObject)json.get("typegroup"));
        typegroupusecases.deleteTypegroup(typegroup);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Category(Typegroup_usecases typegroupusecases, JSONObject json) throws ParseException, CustomException {
        ICategoryPK categoryPK = (ICategoryPK)JSONCategory.toCategoryPK((JSONObject)json.get("categorypk"));
        typegroupusecases.delete_all_containing_Category(categoryPK);
        setReturnstatus("OK");
    }

}

