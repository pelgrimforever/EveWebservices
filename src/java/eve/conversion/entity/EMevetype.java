/*
 * Created on Okt 8, 2021
 * Generated on 9.9.2021 15:35
 */
package eve.conversion.entity;

import data.interfaces.db.LogicEntity;
import eve.conversion.entity.def.EMevetype_default;
import eve.logicentity.Evetype;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Franky Laseure
 */
public class EMevetype extends EMevetype_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    public static final String SQLSelectAll = SQLSelect + OrderBy;
    public static final String SQLSelect4typegroupCount = "select count(*) as count from evetype where " + SQLWheretypegroup;
    public static final String SQLSelect4configuredbp = SQLSelect + " where configuredbp";
    
    public static final String SQLUpdateSellprices = 
        "update evetype set avg_sellorder = orders.avgprice, min_selorder = orders.min_price, max_selorder = orders.max_price " +
        "from (select o.evetype as evetype, sum(o.volume_remain*o.price)/sum(o.volume_remain) as avgprice, " +
        "min(o.price) as min_price, max(o.price) as max_price " + 
        "from orders o " +
        "inner join system s on o.system = s.id and s.security_island = 1 " +
        "where not o.is_buy_order group by o.evetype) as orders " +
        "where evetype.id = orders.evetype";
    public static final String SQLUpdateBuyprices = 
        "update evetype set avg_buyorder = orders.avgprice, min_buyorder = orders.min_price, max_buyorder = orders.max_price " +
        "from (select o.evetype as evetype, sum(o.volume_remain*o.price)/sum(o.volume_remain) as avgprice, " +
        "min(o.price) as min_price, max(o.price) as max_price " + 
        "from orders o " +
        "inner join system s on o.system = s.id and s.security_island = 1 " +
        "where o.is_buy_order group by o.evetype) as orders " +
        "where evetype.id = orders.evetype";
    
    public static final String SQLUpdateAverages = 
        "update evetype e set average = oh.average, highest = oh.highest, lowest = oh.lowest, order_count = oh.order_count " +
        "from (select evetype, sum(average * volume)/sum(volume) as average , max(highest) as highest , min(lowest) as lowest , sum(volume) as volume , sum(order_count) as order_count " +
        "from order_history_month " +
        "where year = :year: and month = :month: " +
        "group by evetype) oh " +
        "where e.id = oh.evetype";

    @Override
    public LogicEntity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Evetype evetype = (Evetype)super.mapResultSet2Entity(dbresult);
        return evetype;
    }    
    
}

