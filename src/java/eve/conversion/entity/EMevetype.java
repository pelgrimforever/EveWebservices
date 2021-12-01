/*
 * EMevetype.java
 *
 * Created on Okt 8, 2021
 * Generated on 9.9.2021 15:35
 *
 */
package eve.conversion.entity;

import data.interfaces.db.LogicEntity;
import eve.conversion.entity.def.EMevetype_default;
import eve.logicentity.Evetype;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMevetype
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMevetype extends EMevetype_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    public static final String SQLSelectAll = SQLSelect + OrderBy;
    public static final String SQLSelect4typegroupCount = "select count(*) as count from evetype where " + SQLWheretypegroup;
    
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

    /**
     * Map ResultSet Field values to Evetype
     * @param dbresult: Database ResultSet
     * @return 
     * @throws java.sql.SQLException
     */
    @Override
    public LogicEntity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Evetype evetype = (Evetype)super.mapResultSet2Entity(dbresult);
        return evetype;
    }    
    
}

