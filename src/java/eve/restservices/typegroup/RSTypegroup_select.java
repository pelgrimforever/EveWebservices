/*
 * Generated on 13.4.2022 19:13
 */

package eve.restservices.typegroup;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.usecases.Typegroup_usecases;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.ITypegroupsearch;
import eve.interfaces.servlet.ITypegroupOperation;
import eve.logicentity.Typegroup;
import eve.searchentity.Typegroupsearch;
import eve.servlets.DataServlet;
import eve.usecases.Security_usecases;
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
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
@Path("rstypegroup_select")
public class RSTypegroup_select extends RS_json_login {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(Security_usecases.check_authorization(authorisationstring));
            ITypegroupPK typegroupPK;
            ITypegroup typegroup;
            Typegroup_usecases typegroupusecases = new Typegroup_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case ITypegroupOperation.SELECT_COUNT:
                    result = count_records(typegroupusecases);
                    break;
                case ITypegroupOperation.SELECT_ALL:
                    result = get_all_typegroup(typegroupusecases);
                    break;
                case ITypegroupOperation.SELECT_TYPEGROUP:
                    result = get_typegroup_with_primarykey(typegroupusecases, json);
                    break;
                case ITypegroupOperation.SELECT_Category:
                    result = get_typegroup_with_foreignkey_category(typegroupusecases, json);
                    break;
                case ITypegroupOperation.SELECT_SEARCH:
                    result = search_typegroup(typegroupusecases, json);
                    break;
                case ITypegroupOperation.SELECT_SEARCHCOUNT:
                    result = search_typegroup_count(typegroupusecases, json);
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

    private String count_records(Typegroup_usecases typegroupusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", typegroupusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_typegroup(Typegroup_usecases typegroupusecases) throws ParseException, CustomException {
    	return JSONTypegroup.toJSONArray(typegroupusecases.get_all()).toJSONString();
    }
    
    private String get_typegroup_with_primarykey(Typegroup_usecases typegroupusecases, JSONObject json) throws ParseException, CustomException {
        ITypegroupPK typegroupPK = (ITypegroupPK)JSONTypegroup.toTypegroupPK((JSONObject)json.get("typegrouppk"));
	return JSONTypegroup.toJSON(typegroupusecases.get_typegroup_by_primarykey(typegroupPK)).toJSONString();
    }
    
    private String get_typegroup_with_foreignkey_category(Typegroup_usecases typegroupusecases, JSONObject json) throws ParseException, CustomException {
        ICategoryPK categoryPK = (ICategoryPK)JSONCategory.toCategoryPK((JSONObject)json.get("categorypk"));
        return JSONTypegroup.toJSONArray(typegroupusecases.get_typegroup_with_foreignkey_category(categoryPK)).toJSONString();
    }
    
    private String search_typegroup(Typegroup_usecases typegroupusecases, JSONObject json) throws ParseException, CustomException {
        ITypegroupsearch search = (ITypegroupsearch)JSONTypegroup.toTypegroupsearch((JSONObject)json.get("search"));
        return JSONTypegroup.toJSONArray(typegroupusecases.search_typegroup(search)).toJSONString();
    }
    
    private String search_typegroup_count(Typegroup_usecases typegroupusecases, JSONObject json) throws ParseException, CustomException {
        ITypegroupsearch typegroupsearch = (ITypegroupsearch)JSONTypegroup.toTypegroupsearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", typegroupusecases.search_typegroup_count(typegroupsearch));
        return jsonsearchcount.toJSONString();
    }
}

