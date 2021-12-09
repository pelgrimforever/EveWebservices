/*
 * EMalliance_default.java
 *
 * Created on Okt 8, 2021
 * Generated on 9.11.2021 14:30
 *
 */
package eve.conversion.entity.def;

import data.gis.shape.*;
import data.interfaces.db.View;
import data.json.piJson;
import db.ViewMapper;
import eve.logicview.View_trade;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMview_trade_default
 * Maps SQL ResultSet to eve.logicentity objects
 * @author Franky Laseure
 */
public class EMview_trade_default implements ViewMapper {
    
    public static final String SQLSelectAll = "select view_trade.* from view_trade";
	  
    /**
     * 
     * @return SQL select statement for all View_trades
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to View_trade
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_trade view_trade = new View_trade();
        if(dbresult!=null) {
            try {
                view_trade.setSell_regionid(dbresult.getLong("sell_regionid"));
                view_trade.setSell_regionname(dbresult.getString("sell_regionname"));
                view_trade.setSell_systemid(dbresult.getLong("sell_systemid"));
                view_trade.setSell_systemname(dbresult.getString("sell_systemname"));
                view_trade.setSell_locationid(dbresult.getLong("sell_locationid"));
                view_trade.setSell_stationname(dbresult.getString("sell_stationname"));
                view_trade.setEvetype_id(dbresult.getLong("evetype_id"));
                view_trade.setEvetype_name(dbresult.getString("evetype_name"));
                view_trade.setPackaged_volume(dbresult.getDouble("packaged_volume"));
                view_trade.setSell_id(dbresult.getLong("sell_id"));
                view_trade.setBuy_id(dbresult.getLong("buy_id"));
                view_trade.setSell_volume_remain(dbresult.getLong("sell_volume_remain"));
                view_trade.setSell_price(dbresult.getDouble("sell_price"));
                view_trade.setBuy_price(dbresult.getDouble("buy_price"));
                view_trade.setBuy_systemid(dbresult.getLong("buy_systemid"));
                view_trade.setBuy_systemname(dbresult.getString("buy_systemname"));
                view_trade.setBuy_locationid(dbresult.getLong("buy_locationid"));
                view_trade.setBuy_stationname(dbresult.getString("buy_stationname"));
                view_trade.setBuy_volume_remain(dbresult.getLong("buy_volume_remain"));
                view_trade.setTotal_volume(dbresult.getDouble("total_volume"));
                view_trade.setSell_total(dbresult.getDouble("sell_total"));
                view_trade.setBuy_total(dbresult.getDouble("buy_total"));
                view_trade.setTrade_profit(dbresult.getDouble("trade_profit"));
                view_trade.setTrade_jumps(dbresult.getInt("trade_jumps"));
                view_trade.setTrade_jumpslowsec(dbresult.getInt("trade_jumpslowsec"));
                view_trade.setTrade_jumpsnullsec(dbresult.getInt("trade_jumpsnullsec"));
                view_trade.setTrade_profit_per_jump(dbresult.getDouble("trade_profit_per_jump"));
                view_trade.setTrade_runs(dbresult.getInt("trade_runs"));
                view_trade.setTrade_total_jumps(dbresult.getInt("trade_total_jumps"));
                view_trade.setTrade_singlerunprofit(dbresult.getDouble("trade_singlerunprofit"));
                view_trade.setTrade_maxunits_per_run(dbresult.getInt("trade_maxunits_per_run"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return view_trade;
    }

}

