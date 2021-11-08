/*
 * EMalliance_default.java
 *
 * Created on Okt 8, 2021
 * Generated on 8.10.2021 7:21
 *
 */
package eve.conversion.entity.def;

import data.gis.shape.*;
import data.interfaces.db.LogicEntity;
import data.json.piJson;
import db.TableMapper;
import eve.entity.pk.*;
import eve.logicentity.Systemtrade_order;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMsystemtrade_order_default
 * Maps SQL ResultSet to eve.logicentity objects
 * @author Franky Laseure
 */
public class EMsystemtrade_order_default implements TableMapper {
    
    public static final String SQLWhere1 = "sell_system = :systemtrade_order.sell_system: and buy_system = :systemtrade_order.buy_system: and sell_order = :systemtrade_order.sell_order: and buy_order = :systemtrade_order.buy_order:";
    public static final String SQLSelect1 = "select systemtrade_order.* from systemtrade_order where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from systemtrade_order where " + SQLWhere1;
    public static final String SQLSelectAll = "select systemtrade_order.* from systemtrade_order";

    public static final String SQLSelect = "select systemtrade_order.* from systemtrade_order";
    public static final String SQLWhereordersBuy_order = "buy_order = :orders.id:";
    public static final String SQLWhereordersSell_order = "sell_order = :orders.id:";
    public static final String SQLWheresystemtrade = "buy_system = :systemtrade.buy_system: and sell_system = :systemtrade.sell_system:";

//Custom code, do not change this line
    public static final String OrderBy = " order by sell_system, buy_system, sell_order, buy_order";
//Custom code, do not change this line

    public static final String SQLSelect4ordersBuy_order = "select * from systemtrade_order where " + SQLWhereordersBuy_order + OrderBy;
    public static final String SQLDelete4ordersBuy_order = "delete from systemtrade_order where " + SQLWhereordersBuy_order;
    public static final String SQLSelect4ordersSell_order = "select * from systemtrade_order where " + SQLWhereordersSell_order + OrderBy;
    public static final String SQLDelete4ordersSell_order = "delete from systemtrade_order where " + SQLWhereordersSell_order;
    public static final String SQLSelect4systemtrade = "select * from systemtrade_order where " + SQLWheresystemtrade + OrderBy;
    public static final String SQLDelete4systemtrade = "delete from systemtrade_order where " + SQLWheresystemtrade;

    /**
     * 
     * @return SQL where clause for one Systemtrade_order (=Primarykey)
     */
    @Override
    public String getSQLWhere1() { return SQLWhere1; };

    /**
     * 
     * @return SQL select statement for one Systemtrade_order (=Primarykey)
     */
    @Override
    public String getSQLSelect1() { return SQLSelect1; };

    /**
     * @return Select statement for Primary key, with count field as result
     * count = 1: exists
     * count = 0: not found
     */
    @Override
    public String getSQLPKExcists() { return SQLSelectPKexists; };
    
    /**
     * 
     * @return SQL select statement for all Systemtrade_orders
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to Systemtrade_order
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Systemtrade_orderPK systemtrade_orderPK = null;
        Systemtrade_order systemtrade_order;
        if(dbresult==null) {
            systemtrade_order = new Systemtrade_order(systemtrade_orderPK);
        } else {
            try {
                systemtrade_orderPK = new Systemtrade_orderPK(dbresult.getLong("sell_system"), dbresult.getLong("buy_system"), dbresult.getLong("sell_order"), dbresult.getLong("buy_order"));
                systemtrade_order = new Systemtrade_order(systemtrade_orderPK);
                systemtrade_order.initAmount(dbresult.getLong("amount"));
                systemtrade_order.initSellprice(dbresult.getDouble("sellprice"));
                systemtrade_order.initBuyprice(dbresult.getDouble("buyprice"));
                systemtrade_order.initProfit(dbresult.getDouble("profit"));
                systemtrade_order.initCargovolume(dbresult.getDouble("cargovolume"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return systemtrade_order;
    }

}

