/*
 * EMalliance_default.java
 *
 * Created on Okt 8, 2021
 * Generated on 19.0.2022 22:13
 *
 */
package eve.conversion.entity.def;

import data.gis.shape.*;
import data.interfaces.db.LogicEntity;
import data.json.piJson;
import db.TableMapper;
import eve.entity.pk.*;
import eve.logicentity.Tradecombined_sell;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMtradecombined_sell_default
 * Maps SQL ResultSet to eve.logicentity objects
 * @author Franky Laseure
 */
public class EMtradecombined_sell_default implements TableMapper {
    
    public static final String SQLWhere1 = "sell_system = :tradecombined_sell.sell_system: and buy_system = :tradecombined_sell.buy_system: and evetype = :tradecombined_sell.evetype: and buy_order_id = :tradecombined_sell.buy_order_id: and sell_order_id = :tradecombined_sell.sell_order_id:";
    public static final String SQLSelect1 = "select tradecombined_sell.* from tradecombined_sell where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from tradecombined_sell where " + SQLWhere1;
    public static final String SQLSelectAll = "select tradecombined_sell.* from tradecombined_sell";

    public static final String SQLSelect = "select tradecombined_sell.* from tradecombined_sell";
    public static final String SQLWhereordersBuy_order_id = "buy_order_id = :orders.id:";
    public static final String SQLWhereordersSell_order_id = "sell_order_id = :orders.id:";
    public static final String SQLWheretradecombined = "sell_system = :tradecombined.sell_system: and buy_system = :tradecombined.buy_system: and evetype = :tradecombined.evetype:";

//Custom code, do not change this line
    public static final String OrderBy = " order by buy_order_id, sell_system, sell_order_id";
//Custom code, do not change this line

    public static final String SQLSelect4ordersBuy_order_id = "select * from tradecombined_sell where " + SQLWhereordersBuy_order_id + OrderBy;
    public static final String SQLDelete4ordersBuy_order_id = "delete from tradecombined_sell where " + SQLWhereordersBuy_order_id;
    public static final String SQLSelect4ordersSell_order_id = "select * from tradecombined_sell where " + SQLWhereordersSell_order_id + OrderBy;
    public static final String SQLDelete4ordersSell_order_id = "delete from tradecombined_sell where " + SQLWhereordersSell_order_id;
    public static final String SQLSelect4tradecombined = "select * from tradecombined_sell where " + SQLWheretradecombined + OrderBy;
    public static final String SQLDelete4tradecombined = "delete from tradecombined_sell where " + SQLWheretradecombined;

    /**
     * 
     * @return SQL where clause for one Tradecombined_sell (=Primarykey)
     */
    @Override
    public String getSQLWhere1() { return SQLWhere1; };

    /**
     * 
     * @return SQL select statement for one Tradecombined_sell (=Primarykey)
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
     * @return SQL select statement for all Tradecombined_sells
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to Tradecombined_sell
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Tradecombined_sellPK tradecombined_sellPK = null;
        Tradecombined_sell tradecombined_sell;
        if(dbresult==null) {
            tradecombined_sell = new Tradecombined_sell(tradecombined_sellPK);
        } else {
            try {
                tradecombined_sellPK = new Tradecombined_sellPK(dbresult.getLong("sell_system"), dbresult.getLong("buy_system"), dbresult.getLong("evetype"), dbresult.getLong("buy_order_id"), dbresult.getLong("sell_order_id"));
                tradecombined_sell = new Tradecombined_sell(tradecombined_sellPK);
                tradecombined_sell.initAmount(dbresult.getLong("amount"));
                tradecombined_sell.initBuy_order_value(dbresult.getDouble("buy_order_value"));
                tradecombined_sell.initSell_order_value(dbresult.getDouble("sell_order_value"));
                tradecombined_sell.initProfit(dbresult.getDouble("profit"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return tradecombined_sell;
    }

}

