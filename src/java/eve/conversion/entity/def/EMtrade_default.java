/*
 * Created on Okt 8, 2021
 * Generated on 13.6.2022 11:21
 */
package eve.conversion.entity.def;

import data.interfaces.db.*;
import data.gis.shape.*;
import data.json.piJson;
import db.TableMapper;
import eve.eveDatabaseproperties;
import eve.entity.pk.*;
import eve.logicentity.Trade;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class EMtrade_default implements eveDatabaseproperties, TableMapper {
    
    public static final String SQLWhere1 = "sell_order_id = :trade.sell_order_id: and buy_order_id = :trade.buy_order_id:";
    public static final String SQLSelect1 = "select trade.* from trade where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from trade where " + SQLWhere1;
    public static final String SQLSelectAll = "select trade.* from trade";

    public static final String SQLSelect = "select trade.* from trade";
    public static final String SQLWhereordersSell_order_id = "sell_order_id = :orders.id:";
    public static final String SQLWhereordersBuy_order_id = "buy_order_id = :orders.id:";

//Custom code, do not change this line
    public static final String OrderBy = " order by sell_order_id, buy_order_id";
//Custom code, do not change this line

    public static final String SQLSelect4ordersSell_order_id = "select * from trade where " + SQLWhereordersSell_order_id + OrderBy;
    public static final String SQLDelete4ordersSell_order_id = "delete from trade where " + SQLWhereordersSell_order_id;
    public static final String SQLSelect4ordersBuy_order_id = "select * from trade where " + SQLWhereordersBuy_order_id + OrderBy;
    public static final String SQLDelete4ordersBuy_order_id = "delete from trade where " + SQLWhereordersBuy_order_id;

    @Override
    public String getDbtool() { return databasetool; }
    
    @Override
    public String getConnectionpool() { return connectionpool; }
    
    @Override
    public String getTable() { return "trade"; }

    /**
     * 
     * @return SQL where clause for one Trade (=Primarykey)
     */
    @Override
    public String getSQLWhere1() { return SQLWhere1; };

    /**
     * 
     * @return SQL select statement for one Trade (=Primarykey)
     */
    @Override
    public String getSQLSelect1() { return SQLSelect1; };

    @Override
    public String getSQLPKExcists() { return SQLSelectPKexists; };
    
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    @Override
    public Entity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        TradePK tradePK = null;
        Trade trade;
        if(dbresult==null) {
            trade = new Trade(tradePK);
        } else {
            try {
                tradePK = new TradePK(dbresult.getLong("sell_order_id"), dbresult.getLong("buy_order_id"));
                trade = new Trade(tradePK);
                trade.initTotal_volume(dbresult.getDouble("total_volume"));
                trade.initBuy_order_value(dbresult.getDouble("buy_order_value"));
                trade.initSell_order_value(dbresult.getDouble("sell_order_value"));
                trade.initProfit(dbresult.getDouble("profit"));
                trade.initJumps(dbresult.getInt("jumps"));
                trade.initRuns(dbresult.getInt("runs"));
                trade.initTotal_jumps(dbresult.getInt("total_jumps"));
                trade.initProfit_per_jump(dbresult.getDouble("profit_per_jump"));
                trade.initSinglerun_profit_per_jump(dbresult.getDouble("singlerun_profit_per_jump"));
                trade.initMaxunits_per_run(dbresult.getInt("maxunits_per_run"));
                trade.initJumpslowsec(dbresult.getInt("jumpslowsec"));
                trade.initJumpsnullsec(dbresult.getInt("jumpsnullsec"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return trade;
    }

}

