/*
 * Created on Okt 8, 2021
 * Generated on 9.9.2021 15:35
 */
package eve.conversion.entity;

import data.interfaces.db.LogicEntity;
import eve.conversion.entity.def.EMorders_default;
import eve.logicentity.Orders;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Franky Laseure
 */
public class EMorders extends EMorders_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    public static final String Truncate = "truncate shipfitorderselected, tradecombined_sell, tradecombined, trade, orders";
    
    public static final String SQLSelectAll = SQLSelect + OrderBy;

    public static final String SQLdeleteall = "delete from orders";
    public static final String SQLreset = "update orders set isopen = :isopen:";
    
    public static final String SQLgetSellorders4system = "select * from orders o " +
        "where o.system = :system.id: and o.id in " +
        "(select sellorderid from view_systemtradeorders " +
        "where packaged_volume <= :max_cargovolume: and buy_totalprice * :net_perc: > sell_totalprice) " +
        "order by evetype, price";
    public static final String SQLgetBuyorders4system = "select * from orders o " +
        "where o.system = :system.id: and o.id in " +
        "(select buyorderid from view_systemtradeorders " +
        "where packaged_volume <= :max_cargovolume: and buy_totalprice * :net_perc: > sell_totalprice) " +
        "order by evetype, price desc";
    public static final String SQLgetSellorders4system2 = "select * from orders o inner join evetype e on e.id = o.evetype " +
        "where not o.is_buy_order and o.system = :system.id: and e.packaged_volume <= :max_cargovolume: " +
        "order by evetype, price";
    public static final String SQLgetBuyorders4systemevetype = "select * from orders " +
        "where is_buy_order and system = :system.id: and evetype = :evetype.id: " +
        "order by price desc";
    public static final String SQLgetSellorders4systemevetype = "select * from orders " +
        "where not is_buy_order and system = :system.id: and evetype = :evetype.id: " +
        "order by price";
    public static final String SQLgetBuyorders4system2 = "select * from orders o inner join evetype e on e.id = o.evetype " +
        "where o.is_buy_order and o.system = :system.id: and e.packaged_volume <= :max_cargovolume: " +
        "order by evetype, price desc";
    public static final String SQLgetBuyorders4evetype = "select * from orders " +
            "inner join system on system.id = orders.system and system.security_island = :security_island.id: " +
            "where " + SQLWhereevetype + " and is_buy_order order by price desc";
    public static final String SQLgetClosestBuyorders4evetype = "select * from orders " +
            "inner join systemjumps sj on sj.system_end = orders.system and sj.system_start = :system.id: " +
            "where " + SQLWhereevetype + " and is_buy_order order by price desc, sj.jumps";
    public static final String SQLgetOrdersTradebuy = "select * from orders inner join " +
            "(select trade.buy_order_id from trade group by trade.buy_order_id) as tradeorders " +
            "on orders.id = tradeorders.buy_order_id " +
            "order by system, evetype, price desc";
    public static final String SQLgetOrdersTradesell4order = "select * from orders inner join " +
            "(select trade.sell_order_id from trade where trade.buy_order_id = :orders.id: group by trade.sell_order_id) as tradeorders " +
            "on orders.id = tradeorders.sell_order_id " +
            "order by system, evetype, price";
/*    
    public static final String SQLbuy_orders = "select o.*, e.packaged_volume from orders o " +
        "inner join evetype e on e.id = o.evetype and o.price > e.min_selorder and e.packaged_volume<=:maxvolume: " +
        "inner join system s on s.id = o.system and s.security_island = :security_island.id: " +
        "where o.is_buy_order " +
        "order by o.evetype, o.system, o.volume_remain*o.price desc";
    public static final String SQLbuy_orders4evetype = "select o.*, e.packaged_volume from orders o " +
        "inner join evetype e on e.id = o.evetype and e.id = :evetype.id: and o.price > e.min_selorder and e.packaged_volume<=:maxvolume: " +
        "inner join system s on s.id = o.system and s.security_island = :security_island.id: " +
        "where o.is_buy_order";
    public static final String SQLsell_orders = "select o.*, e.packaged_volume from orders o " +
        "inner join evetype e on e.id = o.evetype and o.price < e.max_buyorder and e.packaged_volume<=:maxvolume: " +
        "inner join system s on s.id = o.system and s.security_island = :security_island.id: " +
        "where not o.is_buy_order " +
        "order by o.evetype, o.system, o.volume_remain*o.price";
*/    

    @Override
    public LogicEntity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Orders orders = (Orders)super.mapResultSet2Entity(dbresult);
        //not all SQL statements will have packaged_volume in them, no error need to be raised.
        try {
            orders.setPackaged_volume(dbresult.getDouble("packaged_volume"));
        }
        catch(SQLException e) {
        }
        return orders;
    }    
    
}

