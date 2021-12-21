/*
 * JSONTypegroup.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 16.11.2021 15:46
 *
 */
 
package eve.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.interfaces.db.EntityPK;
import data.interfaces.db.Fieldsearcher;
import data.json.piJson;
import eve.entity.pk.TypegroupPK;
import eve.interfaces.entity.pk.ITypegroupPK;
import eve.interfaces.logicentity.ITypegroup;
import eve.logicentity.Typegroup;
import eve.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * JSON fields are by default ignored
 * @author Franky Laseure
 */
public class JSONTypegroup {
    
    public static JSONArray toJSONArray(ArrayList typegroups) {
        JSONArray jsontypegroups = new JSONArray();
        Iterator typegroupsI = typegroups.iterator();
        while(typegroupsI.hasNext()) {
            jsontypegroups.add(toJSON((Typegroup)typegroupsI.next()));
        }
        return jsontypegroups;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(ITypegroupPK typegroupPK) {
        JSONObject json = null;
        if(typegroupPK!=null) {
            json = new JSONObject();
            json.put("id", String.valueOf(typegroupPK.getId()));
        }
        return json;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(ITypegroup typegroup) {
        JSONObject json = new JSONObject();
        json.put("PK", toJSON(typegroup.getPrimaryKey()));
        json.put("categoryPK", JSONCategory.toJSON(typegroup.getCategoryPK()));
        json.put("name", typegroup.getName());
        json.put("published", typegroup.getPublished());
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(Typegroupsearch typegroupsearch) {
        JSONObject json = new JSONObject();
        if(typegroupsearch.used()) {
            byte andoroperator = typegroupsearch.getAndoroperator();
            int maxresults = typegroupsearch.getMaxresults();
            boolean docount = typegroupsearch.getDocount();
            Iterator<EntityPK> primarykeysI = typegroupsearch.getPrimarykeys().iterator();
            Iterator<Fieldsearcher> fieldsearchersI = typegroupsearch.getFieldsearchers().iterator();
            EntityPK primarykey;
            Fieldsearcher fieldsearcher;
            
            json.put("andor", andoroperator);
            json.put("maxresults", maxresults);
            json.put("docount", docount);
            JSONArray pks = new JSONArray();
            int i = 0;
            while(primarykeysI.hasNext()) {
                primarykey = primarykeysI.next();
                pks.add(primarykey.getKeystring());
            }
            json.put("primarykeys", pks);
            JSONObject fss = new JSONObject();
            while(fieldsearchersI.hasNext()) {
                fieldsearcher = fieldsearchersI.next();
                if(fieldsearcher.used()) {
                    fss.put(fieldsearcher.getShortFieldname(), JSONConversion.toJSON(fieldsearcher));
                }
            }
            json.put("fields", fss);
            JSONObject kss = new JSONObject();
            if(typegroupsearch.getCategorysearch()!=null && typegroupsearch.getCategorysearch().used()) {
                kss.put("categorysearcher", JSONCategory.toJSON((Categorysearch)typegroupsearch.getCategorysearch()));
            }
            json.put("keysearch", kss);
        }
        return json;
    }

    /**
     * 
     * @param json: JSONObject with the Filmsearch parameters
     * @return 
     */
    public static Typegroupsearch toTypegroupsearch(JSONObject json) {
        Typegroupsearch typegroupsearch = new Typegroupsearch();
        typegroupsearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        typegroupsearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        typegroupsearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONArray pks = (JSONArray)json.get("primarykeys");
        for(int i=0; i<pks.size(); i++) {
            typegroupsearch.addPrimarykey(TypegroupPK.getKey((String)pks.get(i)));
        }
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("id");
        if(field!=null) {
            long[] valuearray = JSONConversion.getLongvalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            typegroupsearch.id(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("name");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            typegroupsearch.name(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("published");
        if(field!=null) {
            boolean value = JSONConversion.getBooleanvalue(field);
            typegroupsearch.published(value);
        }
        JSONObject kss = (JSONObject)json.get("keysearch");
        JSONArray keysearch;
        keysearch = (JSONArray)kss.get("categorysearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Categorysearch categorysearch = JSONCategory.toCategorysearch((JSONObject)keysearch.get(i));
                typegroupsearch.category(categorysearch);
            }
        }
        return typegroupsearch;
    }
    
    public static TypegroupPK toTypegroupPK(JSONObject json) {
        TypegroupPK typegroupPK = null;
        if(json!=null) {
            typegroupPK = new TypegroupPK(JSONConversion.getlong(json, "id"));
        }
        return typegroupPK;
    }

    public static Typegroup toTypegroup(JSONObject json) {
        Typegroup typegroup = new Typegroup(toTypegroupPK((JSONObject)json.get("PK")));
        updateTypegroup(typegroup, json);
        return typegroup;
    }

    public static void updateTypegroup(ITypegroup typegroup, JSONObject json) {
        typegroup.setCategoryPK(JSONCategory.toCategoryPK((JSONObject)json.get("categoryPK")));
        typegroup.setName(JSONConversion.getString(json, "name"));
        typegroup.setPublished(JSONConversion.getboolean(json, "published"));
    }

    public static Typegroup initTypegroup(JSONObject json) {
        Typegroup typegroup = new Typegroup(toTypegroupPK((JSONObject)json.get("PK")));
        typegroup.initCategoryPK(JSONCategory.toCategoryPK((JSONObject)json.get("categoryPK")));
        typegroup.initName(JSONConversion.getString(json, "name"));
        typegroup.initPublished(JSONConversion.getboolean(json, "published"));
        return typegroup;
    }
}

