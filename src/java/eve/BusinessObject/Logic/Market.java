/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eve.BusinessObject.Logic;

import data.conversion.JSONConversion;
import db.AbstractSQLMapper;
import eve.data.Swagger;
import eve.entity.pk.RoutetypePK;
import eve.entity.pk.Security_islandPK;
import eve.entity.pk.SystemPK;
import eve.logicentity.Orders;
import eve.logicentity.Region;
import eve.logicentity.Trade;
import eve.logicview.View_tradeorders;
import general.exception.DBException;
import general.exception.DataException;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author pelgrim
 */
public class Market {
    
    public static void downloadOrders() throws DataException, DBException {
        BLorders blorders = new BLorders();
        BLorder_hist blorderhist = new BLorder_hist();
        BLregion blregion = new BLregion();

        //more orders to order_hist
        System.out.print("Start downloadOrders");
        if(blorders.count()>0) {
            //blorderhist.deleteorders();
            //blorderhist.copyorders();
            blorders.deleteorders();
        }
        System.out.print("Orders deleted");
        System.out.print("Starting orders");
        long start = System.currentTimeMillis();
        //add market orders for each region
        int pagenr;
        Iterator<Region> regionsI = blregion.getAll().iterator();
        Region region;
        //performance:
        //to prevent a huge amount of object creations, JSON is directly translated to SQL
        JSONArray jsonorders;
        Iterator<JSONObject> jsonordersI;
        int ordercounter = 0;
        int orderbatch = 0;
        int rangenumber = 0;

        StringBuilder sqlb = new StringBuilder();
        JSONObject jsonorderdetails;
        while(regionsI.hasNext()) {
            region = regionsI.next();
            System.out.println("Region " + region.getPrimaryKey().getId() + " " + region.getName());
            pagenr = 1;
            do {
                //System.out.print("Page " + pagenr + " * ");
                jsonorders = Swagger.getMarket_region_orders(region.getPrimaryKey().getId(), pagenr);
                jsonordersI = jsonorders.iterator();
                ordercounter = 0;
                while(jsonordersI.hasNext()) {
                    jsonorderdetails = jsonordersI.next();
                    sqlb.delete(0, 200);
                    sqlb.append("insert into orders values (");
                    sqlb.append(JSONConversion.getLong(jsonorderdetails, "order_id")).append(",");
                    sqlb.append("true,");
                    sqlb.append(JSONConversion.getLong(jsonorderdetails, "system_id")).append(",");
                    sqlb.append(JSONConversion.getLong(jsonorderdetails, "type_id")).append(",");
                    sqlb.append(JSONConversion.getLong(jsonorderdetails, "volume_total")).append(",");
                    sqlb.append(JSONConversion.getLong(jsonorderdetails, "volume_remain")).append(",");
                    sqlb.append("'").append(JSONConversion.getString(jsonorderdetails, "range")).append("',");
                    sqlb.append("0,");
                    sqlb.append(JSONConversion.getDouble(jsonorderdetails, "price")).append(",");
                    sqlb.append(JSONConversion.getint(jsonorderdetails, "min_volume")).append(",");
                    sqlb.append(JSONConversion.getLong(jsonorderdetails, "location_id")).append(",");
                    sqlb.append(JSONConversion.getboolean(jsonorderdetails, "is_buy_order")).append(",");
                    sqlb.append("'").append(AbstractSQLMapper.datetimeformat.format(Swagger.datetimestring2Timestamp(JSONConversion.getString(jsonorderdetails, "issued")))).append("',");
                    sqlb.append(JSONConversion.getint(jsonorderdetails, "duration"));
                    sqlb.append(")");

                    blorders.addStatement(sqlb.toString(), null);

                    ordercounter++;
                    if(ordercounter==100) {
                        orderbatch = ordercounter;
                        ordercounter = 0;
                        blorders.Commit2DB();
                    }
                }
                blorders.Commit2DB();
                pagenr++;
            } while(jsonorders.size()>0);
            region.setOrderpages(pagenr);
            blregion.updateRegion(region);
        }         
        long end = System.currentTimeMillis();
        System.out.println("Download time Swagger -> orders " + ((end - start)/1000));
    }
    
    public static void downloadJsonorders() throws DataException, DBException {
        BLjson_orders bljsonorders = new BLjson_orders();
        BLorders blorders = new BLorders();
        BLregion blregion = new BLregion();

        //more orders to order_hist
        System.out.print("Start downloadJsonorders");
        if(blorders.count()>0) {
            //blorderhist.deleteorders();
            //blorderhist.copyorders();
            blorders.deleteorders();
        }
        System.out.print("Orders deleted");
        System.out.print("Starting json_orders");
        long start = System.currentTimeMillis();
        //add market orders for each region
        int pagenr;
        Iterator<Region> regionsI = blregion.getAll().iterator();
        Region region;
        //performance:
        //to prevent a huge amount of object creations, JSON is directly translated to SQL
        JSONArray jsonorders;
        Iterator<JSONObject> jsonordersI;
        int ordercounter = 0;
        int orderbatch = 0;
        int rangenumber = 0;

        StringBuilder sqlb = new StringBuilder();
        JSONObject jsonorderdetails;
        while(regionsI.hasNext()) {
            region = regionsI.next();
            System.out.println("Region " + region.getPrimaryKey().getId() + " " + region.getName());
            pagenr = 1;
            do {
                //System.out.print("Page " + pagenr + " * ");
                jsonorders = Swagger.getMarket_region_orders(region.getPrimaryKey().getId(), pagenr);
                jsonordersI = jsonorders.iterator();
                ordercounter = 0;
                while(jsonordersI.hasNext()) {
                    jsonorderdetails = jsonordersI.next();
                    sqlb.delete(0, sqlb.length());
                    sqlb.append("insert into json_orders (json) values ('").append(jsonorderdetails.toJSONString()).append("')");
                    blorders.addStatement(sqlb.toString(), null);

                    ordercounter++;
                    if(ordercounter==100) {
                        orderbatch = ordercounter;
                        ordercounter = 0;
                        blorders.Commit2DB();
                    }
                }
                blorders.Commit2DB();
                pagenr++;
            } while(jsonorders.size()>0);
        }         
        long end = System.currentTimeMillis();
        System.out.println("Download time Swagger -> orders " + ((end - start)/1000));
    }
    
    public static void processOrders() throws DataException, DBException {
        RouteHash routehash = new RouteHash(new RoutetypePK(1));
        BLorders blorders = new BLorders();
        BLorder_hist blorderhist = new BLorder_hist();
        BLregion blregion = new BLregion();
        BLevetype blevetype = new BLevetype();
        BLsystem blsystem = new BLsystem();
        BLroute blroute = new BLroute();
        BLtrade bltrade = new BLtrade();

        //calculate average, min and max price for buy/sell orders for each evetype
        blevetype.updateaverageprices();
        System.out.println("Evetype average prices");
        
        bltrade.deletetrade();
        double max_volume = 33980.4;
        long min_profit = 1000000;
        long min_profit_per_jump = 100000;
        float perc_tax = 0.05f;
        float perc_net = 1 - perc_tax;
        Security_islandPK security_islandPK = new Security_islandPK(1);
        //get all buy orders and sell orders that potentially can generate profit
        ArrayList buyorders = null;
        Iterator<Orders> buyordersI = null;
        Iterator<Orders> sellordersI = blorders.load_sell_orders(max_volume, security_islandPK).iterator();
        Orders buyorder = null;
        Orders sellorder;
        double buyordervalue;
        double sellordervalue;
        double totalvolume;
        int maxunits_per_run;
        double profit_per_unit;
        double profit; //total profit between buy and sell
        double profit_per_jump;
        double singlerun_profit_per_jump;
        int jumps; //jumps for a single trip between buy and sell station
        int totaljumps;
        int runs; //times to travel between buy and sell station to process total amount
        Trade trade;
        int count = 0;
        
        //loop all sell orders
        while(sellordersI.hasNext()) {
            sellorder = sellordersI.next();
            //if evetype has changed, load new buyorder list
            if(buyorder==null || !buyorder.getEvetypePK().equals(sellorder.getEvetypePK())) {
                buyorders = blorders.load_buy_orders_4evetype(max_volume, security_islandPK, sellorder.getEvetypePK());
            }
            buyordersI = buyorders.iterator();
            while(buyordersI.hasNext()) {
                buyorder = buyordersI.next();
                totalvolume = Math.min(buyorder.getVolume_remain(), sellorder.getVolume_remain());
                buyordervalue = buyorder.getPrice() * totalvolume;
                sellordervalue = sellorder.getPrice() * totalvolume;
                profit_per_unit = buyorder.getPrice() * perc_net - sellorder.getPrice();
                profit = buyordervalue * perc_net - sellordervalue;
                if(profit>=min_profit) {
                    jumps = (int)routehash.getRoutefinder(new SystemPK(sellorder.getSystemPK().getId())).getJumps(buyorder.getSystemPK().getId());
                    if(jumps==0) jumps = 1;
                    maxunits_per_run = (int)Math.floor(max_volume/sellorder.getPackaged_volume());
                    runs = (int)Math.ceil(totalvolume/maxunits_per_run);
                    totaljumps = jumps * (runs * 2 -1);
                    profit_per_jump = profit / totaljumps;
                    singlerun_profit_per_jump = profit_per_jump;
                    if(runs>1) {
                        singlerun_profit_per_jump = maxunits_per_run * (profit_per_unit) / jumps;
                    }
                    if(profit_per_jump >= min_profit_per_jump || singlerun_profit_per_jump >= min_profit_per_jump) {
                        trade = new Trade(sellorder.getPrimaryKey().getId(), buyorder.getPrimaryKey().getId());
                        trade.setBuy_order_value(buyordervalue);
                        trade.setJumps(jumps);
                        trade.setMaxunits_per_run(maxunits_per_run);
                        trade.setProfit(profit);
                        trade.setProfit_per_jump(profit_per_jump);
                        trade.setRuns(runs);
                        trade.setSell_order_value(sellordervalue);
                        trade.setSinglerun_profit_per_jump(singlerun_profit_per_jump);
                        trade.setTotal_jumps(totaljumps);
                        trade.setTotal_volume(totalvolume);
                        bltrade.trans_insertTrade(trade);
                        count++;
                        if(count==100) {
                            bltrade.Commit2DB();
                        }
                    }
                }
            }
            bltrade.Commit2DB();
        }
        
    }

    public static void processView_tradeorders() throws DataException, DBException {
        RouteHash routehash = new RouteHash(new RoutetypePK(1));
        BLorders blorders = new BLorders();
        BLorder_hist blorderhist = new BLorder_hist();
        BLregion blregion = new BLregion();
        BLevetype blevetype = new BLevetype();
        BLsystem blsystem = new BLsystem();
        BLroute blroute = new BLroute();
        BLtrade bltrade = new BLtrade();
        BLview_tradeorders blviewtradeorders = new BLview_tradeorders();

        //calculate average, min and max price for buy/sell orders for each evetype
        blevetype.updateaverageprices();
        System.out.println("Evetype average prices");
        
        bltrade.deletetrade();
        float max_cargo = 33980.4f;
        long min_profit = 1000000;
        long min_profit_per_jump = 100000;
        float perc_tax = 0.05f;
        float perc_net = 1 - perc_tax;
        Security_islandPK security_islandPK = new Security_islandPK(1);
        //get all view_tradeorders
        Iterator<View_tradeorders> tradeordersI = blviewtradeorders.getTradeorders(security_islandPK, max_cargo, perc_net, min_profit).iterator();
        View_tradeorders tradeorder;
        double buyordervalue;
        double sellordervalue;
        double totalvolume;
        int maxunits_per_run;
        double profit_per_unit;
        double profit; //total profit between buy and sell
        double profit_per_jump;
        double singlerun_profit_per_jump;
        int jumps; //jumps for a single trip between buy and sell station
        int totaljumps;
        int runs; //times to travel between buy and sell station to process total amount
        Trade trade;
        int count = 0;
        
        //loop all orders from view
        while(tradeordersI.hasNext()) {
            tradeorder = tradeordersI.next();
            totalvolume = tradeorder.getTradevolume();
            buyordervalue = tradeorder.getBuy_totalprice();
            sellordervalue = tradeorder.getSell_totalprice();
            profit_per_unit = tradeorder.getBuy_price() * perc_net - tradeorder.getSell_price();
            profit = buyordervalue * perc_net - sellordervalue;
            if(profit>=min_profit) {
                jumps = tradeorder.getJumps();
                if(jumps==0) jumps = 1;
                maxunits_per_run = (int)Math.floor(max_cargo/tradeorder.getSell_packaged_volume());
                runs = (int)Math.ceil(totalvolume/maxunits_per_run);
                totaljumps = jumps * (runs * 2 -1);
                profit_per_jump = profit / totaljumps;
                singlerun_profit_per_jump = profit_per_jump;
                if(runs>1) {
                    singlerun_profit_per_jump = maxunits_per_run * (profit_per_unit) / jumps;
                }
                if(profit_per_jump >= min_profit_per_jump || singlerun_profit_per_jump >= min_profit_per_jump) {
                    trade = new Trade(tradeorder.getSell_id(), tradeorder.getBuy_id());
                    trade.setBuy_order_value(buyordervalue);
                    trade.setJumps(jumps);
                    trade.setMaxunits_per_run(maxunits_per_run);
                    trade.setProfit(profit);
                    trade.setProfit_per_jump(profit_per_jump);
                    trade.setRuns(runs);
                    trade.setSell_order_value(sellordervalue);
                    trade.setSinglerun_profit_per_jump(singlerun_profit_per_jump);
                    trade.setTotal_jumps(totaljumps);
                    trade.setTotal_volume(totalvolume);
                    bltrade.trans_insertTrade(trade);
                    count++;
                    if(count==100) {
                        bltrade.Commit2DB();
                    }
                }
            }
            bltrade.Commit2DB();
        }
        
    }
}
