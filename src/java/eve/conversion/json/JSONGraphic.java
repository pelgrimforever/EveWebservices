/*
 * JSONGraphic.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 25.9.2021 15:16
 *
 */
 
package eve.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.interfaces.db.EntityPK;
import data.interfaces.db.Fieldsearcher;
import data.json.piJson;
import eve.entity.pk.GraphicPK;
import eve.interfaces.entity.pk.IGraphicPK;
import eve.interfaces.logicentity.IGraphic;
import eve.logicentity.Graphic;
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
public class JSONGraphic {
    
    public static JSONArray toJSONArray(ArrayList graphics) {
        JSONArray jsongraphics = new JSONArray();
        Iterator graphicsI = graphics.iterator();
        while(graphicsI.hasNext()) {
            jsongraphics.add(toJSON((Graphic)graphicsI.next()));
        }
        return jsongraphics;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(IGraphicPK graphicPK) {
        JSONObject json = null;
        if(graphicPK!=null) {
            json = new JSONObject();
            json.put("id", String.valueOf(graphicPK.getId()));
        }
        return json;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(IGraphic graphic) {
        JSONObject json = new JSONObject();
        json.put("PK", toJSON(graphic.getPrimaryKey()));
        json.put("collision_file", graphic.getCollision_file());
        json.put("graphic_file", graphic.getGraphic_file());
        json.put("icon_folder", graphic.getIcon_folder());
        json.put("sof_dna", graphic.getSof_dna());
        json.put("sof_fation_name", graphic.getSof_fation_name());
        json.put("sof_hull_name", graphic.getSof_hull_name());
        json.put("sof_race_name", graphic.getSof_race_name());
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(Graphicsearch graphicsearch) {
        JSONObject json = new JSONObject();
        if(graphicsearch.used()) {
            byte andoroperator = graphicsearch.getAndoroperator();
            int maxresults = graphicsearch.getMaxresults();
            boolean docount = graphicsearch.getDocount();
            Iterator<EntityPK> primarykeysI = graphicsearch.getPrimarykeys().iterator();
            Iterator<Fieldsearcher> fieldsearchersI = graphicsearch.getFieldsearchers().iterator();
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
            json.put("keysearch", kss);
        }
        return json;
    }

    /**
     * 
     * @param json: JSONObject with the Filmsearch parameters
     * @return 
     */
    public static Graphicsearch toGraphicsearch(JSONObject json) {
        Graphicsearch graphicsearch = new Graphicsearch();
        graphicsearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        graphicsearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        graphicsearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONArray pks = (JSONArray)json.get("primarykeys");
        for(int i=0; i<pks.size(); i++) {
            graphicsearch.addPrimarykey(GraphicPK.getKey((String)pks.get(i)));
        }
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("id");
        if(field!=null) {
            long[] valuearray = JSONConversion.getLongvalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            graphicsearch.id(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("collision_file");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            graphicsearch.collision_file(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("graphic_file");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            graphicsearch.graphic_file(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("icon_folder");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            graphicsearch.icon_folder(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("sof_dna");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            graphicsearch.sof_dna(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("sof_fation_name");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            graphicsearch.sof_fation_name(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("sof_hull_name");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            graphicsearch.sof_hull_name(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("sof_race_name");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            graphicsearch.sof_race_name(valuearray, compareoperator, andor);
        }
        JSONObject kss = (JSONObject)json.get("keysearch");
        JSONArray keysearch;
        return graphicsearch;
    }
    
    public static GraphicPK toGraphicPK(JSONObject json) {
        GraphicPK graphicPK = null;
        if(json!=null) {
            graphicPK = new GraphicPK(JSONConversion.getlong(json, "id"));
        }
        return graphicPK;
    }

    public static Graphic toGraphic(JSONObject json) {
        Graphic graphic = new Graphic(toGraphicPK((JSONObject)json.get("PK")));
        updateGraphic(graphic, json);
        return graphic;
    }

    public static void updateGraphic(IGraphic graphic, JSONObject json) {
        graphic.setCollision_file(JSONConversion.getString(json, "collision_file"));
        graphic.setGraphic_file(JSONConversion.getString(json, "graphic_file"));
        graphic.setIcon_folder(JSONConversion.getString(json, "icon_folder"));
        graphic.setSof_dna(JSONConversion.getString(json, "sof_dna"));
        graphic.setSof_fation_name(JSONConversion.getString(json, "sof_fation_name"));
        graphic.setSof_hull_name(JSONConversion.getString(json, "sof_hull_name"));
        graphic.setSof_race_name(JSONConversion.getString(json, "sof_race_name"));
    }

    public static Graphic initGraphic(JSONObject json) {
        Graphic graphic = new Graphic(toGraphicPK((JSONObject)json.get("PK")));
        graphic.initCollision_file(JSONConversion.getString(json, "collision_file"));
        graphic.initGraphic_file(JSONConversion.getString(json, "graphic_file"));
        graphic.initIcon_folder(JSONConversion.getString(json, "icon_folder"));
        graphic.initSof_dna(JSONConversion.getString(json, "sof_dna"));
        graphic.initSof_fation_name(JSONConversion.getString(json, "sof_fation_name"));
        graphic.initSof_hull_name(JSONConversion.getString(json, "sof_hull_name"));
        graphic.initSof_race_name(JSONConversion.getString(json, "sof_race_name"));
        return graphic;
    }
}

