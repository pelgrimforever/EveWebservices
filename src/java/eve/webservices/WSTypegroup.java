/*
 * WSTypegroup.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 11.4.2022 9:13
 *
 */

package eve.webservices;

import eve.BusinessObject.Logic.*;
import eve.conversion.json.*;
import eve.entity.pk.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.webservice.WSITypegroup;
import eve.logicentity.Typegroup;
import eve.searchentity.Typegroupsearch;
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
@WebService(endpointInterface = "eve.interfaces.webservice.WSITypegroup")
public class WSTypegroup implements WSITypegroup {

    private JSONArray toJSONArray(ArrayList typegroups) {
        JSONArray jsontypegroups = new JSONArray();
        Iterator typegroupsI = typegroups.iterator();
        while(typegroupsI.hasNext()) {
            jsontypegroups.add(JSONTypegroup.toJSON((Typegroup)typegroupsI.next()));
        }
        return jsontypegroups;
    }

    /**
     * Web service operation
     */
    //@WebMethod(operationName = "getTypegroups")
    @Override
    public String getTypegroups() {
        try {
            BLtypegroup bltypegroup = new BLtypegroup();
            ArrayList typegroups = bltypegroup.getAll();
            JSONArray jsontypegroups = toJSONArray(typegroups);
            return jsontypegroups.toJSONString();
        }
        catch(DBException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String json) {
        BLtypegroup bltypegroup = new BLtypegroup();
        JSONParser parser = new JSONParser();
        String result = "";
        Typegroup typegroup;
        try {
            Typegroupsearch typegroupsearch = JSONTypegroup.toTypegroupsearch((JSONObject)parser.parse(json));
            ArrayList typegroups = bltypegroup.search(typegroupsearch);
            JSONArray jsontypegroups = toJSONArray(typegroups);
            result = jsontypegroups.toJSONString();
        }
        catch(ParseException e) {
            result = "";
        }
        catch(DBException e) {
            result = "";
        }
        return result;
    }

    //@WebMethod(operationName = "getTypegroup")
    @Override
    public String getTypegroup(String json) {
        BLtypegroup bltypegroup = new BLtypegroup();
        JSONParser parser = new JSONParser();
        String result = "";
        Typegroup typegroup;
        try {
            TypegroupPK typegroupPK = JSONTypegroup.toTypegroupPK((JSONObject)parser.parse(json));
            typegroup = bltypegroup.getTypegroup(typegroupPK);
            if(typegroup!=null) {
                result = JSONTypegroup.toJSON(typegroup).toJSONString();
            }
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
        return result;
    }

    //@WebMethod(operationName = "insertTypegroup")
    @Override
    public void insertTypegroup(String json) {
        BLtypegroup bltypegroup = new BLtypegroup();
        JSONParser parser = new JSONParser();
        try {
            ITypegroup typegroup = JSONTypegroup.toTypegroup((JSONObject)parser.parse(json));
            bltypegroup.insertTypegroup(typegroup);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "updateTypegroup")
    @Override
    public void updateTypegroup(String json) {
        BLtypegroup bltypegroup = new BLtypegroup();
        JSONParser parser = new JSONParser();
        try {
            ITypegroup typegroup = JSONTypegroup.toTypegroup((JSONObject)parser.parse(json));
            bltypegroup.updateTypegroup(typegroup);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "deleteTypegroup")
    @Override
    public void deleteTypegroup(String json) {
        BLtypegroup bltypegroup = new BLtypegroup();
        JSONParser parser = new JSONParser();
        try {
            ITypegroup typegroup = JSONTypegroup.toTypegroup((JSONObject)parser.parse(json));
            bltypegroup.deleteTypegroup(typegroup);
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "getTypegroups4category")
    @Override
    public String getTypegroups4category(String json) {
        BLtypegroup bltypegroup = new BLtypegroup();
        JSONParser parser = new JSONParser();
        Typegroup typegroup;
        try {
            ICategoryPK categoryPK = JSONCategory.toCategoryPK((JSONObject)parser.parse(json));
            ArrayList typegroups = bltypegroup.getTypegroups4category(categoryPK);
            JSONArray jsontypegroups = toJSONArray(typegroups);
            return jsontypegroups.toJSONString();
        }
        catch(ParseException e) {
            return null;
        }
        catch(DBException e) {
            return null;
        }
        catch(CustomException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4category")
    @Override
    public void delete4category(String json) {
        BLtypegroup bltypegroup = new BLtypegroup();
        JSONParser parser = new JSONParser();
        Typegroup typegroup;
        try {
            ICategoryPK categoryPK = JSONCategory.toCategoryPK((JSONObject)parser.parse(json));
            bltypegroup.delete4category(categoryPK);
        }
        catch(ParseException e) {
        }
    }


}

