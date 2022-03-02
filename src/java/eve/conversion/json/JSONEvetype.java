/*
 * JSONEvetype.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 21.1.2022 18:41
 *
 */
 
package eve.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.interfaces.db.EntityPK;
import data.interfaces.db.Fieldsearcher;
import data.json.piJson;
import eve.entity.pk.EvetypePK;
import eve.interfaces.entity.pk.IEvetypePK;
import eve.interfaces.logicentity.IEvetype;
import eve.logicentity.Evetype;
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
public class JSONEvetype {
    
    public static JSONArray toJSONArray(ArrayList evetypes) {
        JSONArray jsonevetypes = new JSONArray();
        Iterator evetypesI = evetypes.iterator();
        while(evetypesI.hasNext()) {
            jsonevetypes.add(toJSON((Evetype)evetypesI.next()));
        }
        return jsonevetypes;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(IEvetypePK evetypePK) {
        JSONObject json = null;
        if(evetypePK!=null) {
            json = new JSONObject();
            json.put("id", String.valueOf(evetypePK.getId()));
        }
        return json;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(IEvetype evetype) {
        JSONObject json = new JSONObject();
        json.put("PK", toJSON(evetype.getPrimaryKey()));
        json.put("market_groupPK", JSONMarket_group.toJSON(evetype.getMarket_groupPK()));
        json.put("typegroupPK", JSONTypegroup.toJSON(evetype.getTypegroupPK()));
        json.put("graphicPK", JSONGraphic.toJSON(evetype.getGraphicPK()));
        json.put("name", evetype.getName());
        json.put("published", evetype.getPublished());
        json.put("description", evetype.getDescription());
        json.put("capacity", evetype.getCapacity());
        json.put("icon", String.valueOf(evetype.getIcon()));
        json.put("mass", evetype.getMass());
        json.put("packaged_volume", evetype.getPackaged_volume());
        json.put("portion_size", evetype.getPortion_size());
        json.put("radius", evetype.getRadius());
        json.put("volume", evetype.getVolume());
        json.put("avg_buyorder", evetype.getAvg_buyorder());
        json.put("avg_sellorder", evetype.getAvg_sellorder());
        json.put("min_buyorder", evetype.getMin_buyorder());
        json.put("max_buyorder", evetype.getMax_buyorder());
        json.put("min_selorder", evetype.getMin_selorder());
        json.put("max_selorder", evetype.getMax_selorder());
        json.put("average", evetype.getAverage());
        json.put("highest", evetype.getHighest());
        json.put("lowest", evetype.getLowest());
        json.put("order_count", String.valueOf(evetype.getOrder_count()));
        json.put("configuredbp", evetype.getConfiguredbp());
        json.put("estimatedproductioncost", evetype.getEstimatedproductioncost());
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(Evetypesearch evetypesearch) {
        JSONObject json = new JSONObject();
        if(evetypesearch.used()) {
            byte andoroperator = evetypesearch.getAndoroperator();
            int maxresults = evetypesearch.getMaxresults();
            boolean docount = evetypesearch.getDocount();
            Iterator<EntityPK> primarykeysI = evetypesearch.getPrimarykeys().iterator();
            Iterator<Fieldsearcher> fieldsearchersI = evetypesearch.getFieldsearchers().iterator();
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
            if(evetypesearch.getMarket_groupsearch()!=null && evetypesearch.getMarket_groupsearch().used()) {
                kss.put("market_groupsearcher", JSONMarket_group.toJSON((Market_groupsearch)evetypesearch.getMarket_groupsearch()));
            }
            if(evetypesearch.getTypegroupsearch()!=null && evetypesearch.getTypegroupsearch().used()) {
                kss.put("typegroupsearcher", JSONTypegroup.toJSON((Typegroupsearch)evetypesearch.getTypegroupsearch()));
            }
            if(evetypesearch.getGraphicsearch()!=null && evetypesearch.getGraphicsearch().used()) {
                kss.put("graphicsearcher", JSONGraphic.toJSON((Graphicsearch)evetypesearch.getGraphicsearch()));
            }
            if(evetypesearch.getWishlistsearch()!=null && evetypesearch.getWishlistsearch().used()) {
                kss.put("wishlistsearcher", JSONWishlist.toJSON((Wishlistsearch)evetypesearch.getWishlistsearch()));
            }
            if(evetypesearch.getMaterialinputsearch()!=null && evetypesearch.getMaterialinputsearch().used()) {
                kss.put("materialinputsearcher", JSONMaterialinput.toJSON((Materialinputsearch)evetypesearch.getMaterialinputsearch()));
            }
            if(evetypesearch.getBpmaterialbpsearch()!=null && evetypesearch.getBpmaterialbpsearch().used()) {
                kss.put("bpmaterialBpsearcher", JSONBpmaterial.toJSON((Bpmaterialsearch)evetypesearch.getBpmaterialbpsearch()));
            }
            if(evetypesearch.getBpmaterialmaterialsearch()!=null && evetypesearch.getBpmaterialmaterialsearch().used()) {
                kss.put("bpmaterialMaterialsearcher", JSONBpmaterial.toJSON((Bpmaterialsearch)evetypesearch.getBpmaterialmaterialsearch()));
            }
            if(evetypesearch.getOrder_history_monthsearch()!=null && evetypesearch.getOrder_history_monthsearch().used()) {
                kss.put("order_history_monthsearcher", JSONOrder_history_month.toJSON((Order_history_monthsearch)evetypesearch.getOrder_history_monthsearch()));
            }
            if(evetypesearch.getRelRegion1search()!=null && evetypesearch.getRelRegion1search().used()) {
                kss.put("region1searcher", JSONOrder_history_month.toJSON((Order_history_monthsearch)evetypesearch.getRelRegion1search()));
            }
            if(evetypesearch.getStocksearch()!=null && evetypesearch.getStocksearch().used()) {
                kss.put("stocksearcher", JSONStock.toJSON((Stocksearch)evetypesearch.getStocksearch()));
            }
            if(evetypesearch.getOrder_historysearch()!=null && evetypesearch.getOrder_historysearch().used()) {
                kss.put("order_historysearcher", JSONOrder_history.toJSON((Order_historysearch)evetypesearch.getOrder_historysearch()));
            }
            if(evetypesearch.getRelRegion2search()!=null && evetypesearch.getRelRegion2search().used()) {
                kss.put("region2searcher", JSONOrder_history.toJSON((Order_historysearch)evetypesearch.getRelRegion2search()));
            }
            if(evetypesearch.getShipfitmodulesearch()!=null && evetypesearch.getShipfitmodulesearch().used()) {
                kss.put("shipfitmodulesearcher", JSONShipfitmodule.toJSON((Shipfitmodulesearch)evetypesearch.getShipfitmodulesearch()));
            }
            if(evetypesearch.getRelShipfit1search()!=null && evetypesearch.getRelShipfit1search().used()) {
                kss.put("shipfit1searcher", JSONShipfitmodule.toJSON((Shipfitmodulesearch)evetypesearch.getRelShipfit1search()));
            }
            if(evetypesearch.getShipfitordersearch()!=null && evetypesearch.getShipfitordersearch().used()) {
                kss.put("shipfitordersearcher", JSONShipfitorder.toJSON((Shipfitordersearch)evetypesearch.getShipfitordersearch()));
            }
            if(evetypesearch.getRelShipfit2search()!=null && evetypesearch.getRelShipfit2search().used()) {
                kss.put("shipfit2searcher", JSONShipfitorder.toJSON((Shipfitordersearch)evetypesearch.getRelShipfit2search()));
            }
            if(evetypesearch.getTradecombinedsearch()!=null && evetypesearch.getTradecombinedsearch().used()) {
                kss.put("tradecombinedsearcher", JSONTradecombined.toJSON((Tradecombinedsearch)evetypesearch.getTradecombinedsearch()));
            }
            if(evetypesearch.getRelSystem1search()!=null && evetypesearch.getRelSystem1search().used()) {
                kss.put("system1searcher", JSONTradecombined.toJSON((Tradecombinedsearch)evetypesearch.getRelSystem1search()));
            }
            if(evetypesearch.getRelSystem2search()!=null && evetypesearch.getRelSystem2search().used()) {
                kss.put("system2searcher", JSONTradecombined.toJSON((Tradecombinedsearch)evetypesearch.getRelSystem2search()));
            }
            if(evetypesearch.getUserbpsearch()!=null && evetypesearch.getUserbpsearch().used()) {
                kss.put("userbpsearcher", JSONUserbp.toJSON((Userbpsearch)evetypesearch.getUserbpsearch()));
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
    public static Evetypesearch toEvetypesearch(JSONObject json) {
        Evetypesearch evetypesearch = new Evetypesearch();
        evetypesearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        evetypesearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        evetypesearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONArray pks = (JSONArray)json.get("primarykeys");
        for(int i=0; i<pks.size(); i++) {
            evetypesearch.addPrimarykey(EvetypePK.getKey((String)pks.get(i)));
        }
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("id");
        if(field!=null) {
            long[] valuearray = JSONConversion.getLongvalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            evetypesearch.id(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("name");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            evetypesearch.name(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("published");
        if(field!=null) {
            boolean value = JSONConversion.getBooleanvalue(field);
            evetypesearch.published(value);
        }
        field = (JSONObject)fss.get("description");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            evetypesearch.description(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("capacity");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            evetypesearch.capacity(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("icon");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            evetypesearch.icon(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("mass");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            evetypesearch.mass(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("packaged_volume");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            evetypesearch.packaged_volume(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("portion_size");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            evetypesearch.portion_size(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("radius");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            evetypesearch.radius(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("volume");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            evetypesearch.volume(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("avg_buyorder");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            evetypesearch.avg_buyorder(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("avg_sellorder");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            evetypesearch.avg_sellorder(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("min_buyorder");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            evetypesearch.min_buyorder(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("max_buyorder");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            evetypesearch.max_buyorder(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("min_selorder");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            evetypesearch.min_selorder(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("max_selorder");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            evetypesearch.max_selorder(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("average");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            evetypesearch.average(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("highest");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            evetypesearch.highest(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("lowest");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            evetypesearch.lowest(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("order_count");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            evetypesearch.order_count(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("configuredbp");
        if(field!=null) {
            boolean value = JSONConversion.getBooleanvalue(field);
            evetypesearch.configuredbp(value);
        }
        field = (JSONObject)fss.get("estimatedproductioncost");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            evetypesearch.estimatedproductioncost(valuearray, operators, andor);
        }
        JSONObject kss = (JSONObject)json.get("keysearch");
        JSONArray keysearch;
        keysearch = (JSONArray)kss.get("market_groupsearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Market_groupsearch market_groupsearch = JSONMarket_group.toMarket_groupsearch((JSONObject)keysearch.get(i));
                evetypesearch.market_group(market_groupsearch);
            }
        }
        keysearch = (JSONArray)kss.get("typegroupsearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Typegroupsearch typegroupsearch = JSONTypegroup.toTypegroupsearch((JSONObject)keysearch.get(i));
                evetypesearch.typegroup(typegroupsearch);
            }
        }
        keysearch = (JSONArray)kss.get("graphicsearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Graphicsearch graphicsearch = JSONGraphic.toGraphicsearch((JSONObject)keysearch.get(i));
                evetypesearch.graphic(graphicsearch);
            }
        }
        keysearch = (JSONArray)kss.get("wishlistsearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Wishlistsearch wishlistsearch = JSONWishlist.toWishlistsearch((JSONObject)keysearch.get(i));
                evetypesearch.wishlist(wishlistsearch);
            }
        }
        keysearch = (JSONArray)kss.get("materialinputsearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Materialinputsearch materialinputsearch = JSONMaterialinput.toMaterialinputsearch((JSONObject)keysearch.get(i));
                evetypesearch.materialinput(materialinputsearch);
            }
        }
        keysearch = (JSONArray)kss.get("bpmaterialBpsearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Bpmaterialsearch bpmaterialBpsearch = JSONBpmaterial.toBpmaterialsearch((JSONObject)keysearch.get(i));
                evetypesearch.bpmaterialBp(bpmaterialBpsearch);
            }
        }
        keysearch = (JSONArray)kss.get("bpmaterialMaterialsearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Bpmaterialsearch bpmaterialMaterialsearch = JSONBpmaterial.toBpmaterialsearch((JSONObject)keysearch.get(i));
                evetypesearch.bpmaterialMaterial(bpmaterialMaterialsearch);
            }
        }
        keysearch = (JSONArray)kss.get("order_history_monthsearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Order_history_monthsearch order_history_monthsearch = JSONOrder_history_month.toOrder_history_monthsearch((JSONObject)keysearch.get(i));
                evetypesearch.order_history_month(order_history_monthsearch);
            }
        }
        keysearch = (JSONArray)kss.get("region1searcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Regionsearch region1search = JSONRegion.toRegionsearch((JSONObject)keysearch.get(i));
                evetypesearch.relregion1(region1search);
            }
        }
        keysearch = (JSONArray)kss.get("stocksearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Stocksearch stocksearch = JSONStock.toStocksearch((JSONObject)keysearch.get(i));
                evetypesearch.stock(stocksearch);
            }
        }
        keysearch = (JSONArray)kss.get("order_historysearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Order_historysearch order_historysearch = JSONOrder_history.toOrder_historysearch((JSONObject)keysearch.get(i));
                evetypesearch.order_history(order_historysearch);
            }
        }
        keysearch = (JSONArray)kss.get("region2searcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Regionsearch region2search = JSONRegion.toRegionsearch((JSONObject)keysearch.get(i));
                evetypesearch.relregion2(region2search);
            }
        }
        keysearch = (JSONArray)kss.get("shipfitmodulesearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Shipfitmodulesearch shipfitmodulesearch = JSONShipfitmodule.toShipfitmodulesearch((JSONObject)keysearch.get(i));
                evetypesearch.shipfitmodule(shipfitmodulesearch);
            }
        }
        keysearch = (JSONArray)kss.get("shipfit1searcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Shipfitsearch shipfit1search = JSONShipfit.toShipfitsearch((JSONObject)keysearch.get(i));
                evetypesearch.relshipfit1(shipfit1search);
            }
        }
        keysearch = (JSONArray)kss.get("shipfitordersearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Shipfitordersearch shipfitordersearch = JSONShipfitorder.toShipfitordersearch((JSONObject)keysearch.get(i));
                evetypesearch.shipfitorder(shipfitordersearch);
            }
        }
        keysearch = (JSONArray)kss.get("shipfit2searcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Shipfitsearch shipfit2search = JSONShipfit.toShipfitsearch((JSONObject)keysearch.get(i));
                evetypesearch.relshipfit2(shipfit2search);
            }
        }
        keysearch = (JSONArray)kss.get("tradecombinedsearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Tradecombinedsearch tradecombinedsearch = JSONTradecombined.toTradecombinedsearch((JSONObject)keysearch.get(i));
                evetypesearch.tradecombined(tradecombinedsearch);
            }
        }
        keysearch = (JSONArray)kss.get("system1searcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Systemsearch system1search = JSONSystem.toSystemsearch((JSONObject)keysearch.get(i));
                evetypesearch.relsystem1(system1search);
            }
        }
        keysearch = (JSONArray)kss.get("system2searcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Systemsearch system2search = JSONSystem.toSystemsearch((JSONObject)keysearch.get(i));
                evetypesearch.relsystem2(system2search);
            }
        }
        keysearch = (JSONArray)kss.get("userbpsearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Userbpsearch userbpsearch = JSONUserbp.toUserbpsearch((JSONObject)keysearch.get(i));
                evetypesearch.userbp(userbpsearch);
            }
        }
        return evetypesearch;
    }
    
    public static EvetypePK toEvetypePK(JSONObject json) {
        EvetypePK evetypePK = null;
        if(json!=null) {
            evetypePK = new EvetypePK(JSONConversion.getlong(json, "id"));
        }
        return evetypePK;
    }

    public static Evetype toEvetype(JSONObject json) {
        Evetype evetype = new Evetype(toEvetypePK((JSONObject)json.get("PK")));
        updateEvetype(evetype, json);
        return evetype;
    }

    public static void updateEvetype(IEvetype evetype, JSONObject json) {
        evetype.setMarket_groupPK(JSONMarket_group.toMarket_groupPK((JSONObject)json.get("market_groupPK")));
        evetype.setTypegroupPK(JSONTypegroup.toTypegroupPK((JSONObject)json.get("typegroupPK")));
        evetype.setGraphicPK(JSONGraphic.toGraphicPK((JSONObject)json.get("graphicPK")));
        evetype.setName(JSONConversion.getString(json, "name"));
        evetype.setPublished(JSONConversion.getboolean(json, "published"));
        evetype.setDescription(JSONConversion.getString(json, "description"));
        evetype.setCapacity(JSONConversion.getdouble(json, "capacity"));
        evetype.setIcon(JSONConversion.getlong(json, "icon"));
        evetype.setMass(JSONConversion.getdouble(json, "mass"));
        evetype.setPackaged_volume(JSONConversion.getdouble(json, "packaged_volume"));
        evetype.setPortion_size(JSONConversion.getint(json, "portion_size"));
        evetype.setRadius(JSONConversion.getdouble(json, "radius"));
        evetype.setVolume(JSONConversion.getdouble(json, "volume"));
        evetype.setAvg_buyorder(JSONConversion.getdouble(json, "avg_buyorder"));
        evetype.setAvg_sellorder(JSONConversion.getdouble(json, "avg_sellorder"));
        evetype.setMin_buyorder(JSONConversion.getdouble(json, "min_buyorder"));
        evetype.setMax_buyorder(JSONConversion.getdouble(json, "max_buyorder"));
        evetype.setMin_selorder(JSONConversion.getdouble(json, "min_selorder"));
        evetype.setMax_selorder(JSONConversion.getdouble(json, "max_selorder"));
        evetype.setAverage(JSONConversion.getdouble(json, "average"));
        evetype.setHighest(JSONConversion.getdouble(json, "highest"));
        evetype.setLowest(JSONConversion.getdouble(json, "lowest"));
        evetype.setOrder_count(JSONConversion.getlong(json, "order_count"));
        evetype.setConfiguredbp(JSONConversion.getboolean(json, "configuredbp"));
        evetype.setEstimatedproductioncost(JSONConversion.getdouble(json, "estimatedproductioncost"));
    }

    public static Evetype initEvetype(JSONObject json) {
        Evetype evetype = new Evetype(toEvetypePK((JSONObject)json.get("PK")));
        evetype.initMarket_groupPK(JSONMarket_group.toMarket_groupPK((JSONObject)json.get("market_groupPK")));
        evetype.initTypegroupPK(JSONTypegroup.toTypegroupPK((JSONObject)json.get("typegroupPK")));
        evetype.initGraphicPK(JSONGraphic.toGraphicPK((JSONObject)json.get("graphicPK")));
        evetype.initName(JSONConversion.getString(json, "name"));
        evetype.initPublished(JSONConversion.getboolean(json, "published"));
        evetype.initDescription(JSONConversion.getString(json, "description"));
        evetype.initCapacity(JSONConversion.getdouble(json, "capacity"));
        evetype.initIcon(JSONConversion.getlong(json, "icon"));
        evetype.initMass(JSONConversion.getdouble(json, "mass"));
        evetype.initPackaged_volume(JSONConversion.getdouble(json, "packaged_volume"));
        evetype.initPortion_size(JSONConversion.getint(json, "portion_size"));
        evetype.initRadius(JSONConversion.getdouble(json, "radius"));
        evetype.initVolume(JSONConversion.getdouble(json, "volume"));
        evetype.initAvg_buyorder(JSONConversion.getdouble(json, "avg_buyorder"));
        evetype.initAvg_sellorder(JSONConversion.getdouble(json, "avg_sellorder"));
        evetype.initMin_buyorder(JSONConversion.getdouble(json, "min_buyorder"));
        evetype.initMax_buyorder(JSONConversion.getdouble(json, "max_buyorder"));
        evetype.initMin_selorder(JSONConversion.getdouble(json, "min_selorder"));
        evetype.initMax_selorder(JSONConversion.getdouble(json, "max_selorder"));
        evetype.initAverage(JSONConversion.getdouble(json, "average"));
        evetype.initHighest(JSONConversion.getdouble(json, "highest"));
        evetype.initLowest(JSONConversion.getdouble(json, "lowest"));
        evetype.initOrder_count(JSONConversion.getlong(json, "order_count"));
        evetype.initConfiguredbp(JSONConversion.getboolean(json, "configuredbp"));
        evetype.initEstimatedproductioncost(JSONConversion.getdouble(json, "estimatedproductioncost"));
        return evetype;
    }
}

