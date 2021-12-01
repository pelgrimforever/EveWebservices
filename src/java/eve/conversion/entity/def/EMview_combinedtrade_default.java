/*
 * EMalliance_default.java
 *
 * Created on Okt 8, 2021
 * Generated on 30.10.2021 10:3
 *
 */
package eve.conversion.entity.def;

import data.gis.shape.*;
import data.interfaces.db.View;
import data.json.piJson;
import db.ViewMapper;
import eve.logicview.View_combinedtrade;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMview_combinedtrade_default
 * Maps SQL ResultSet to eve.logicentity objects
 * @author Franky Laseure
 */
public class EMview_combinedtrade_default implements ViewMapper {
    
    public static final String SQLSelectAll = "select view_combinedtrade.* from view_combinedtrade";
	  
    /**
     * 
     * @return SQL select statement for all View_combinedtrades
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to View_combinedtrade
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_combinedtrade view_combinedtrade = new View_combinedtrade();
        if(dbresult!=null) {
            try {
                view_combinedtrade.setSellregion(dbresult.getString("sellregion"));
                view_combinedtrade.setBuyregion(dbresult.getString("buyregion"));
                view_combinedtrade.setSell_systemid(dbresult.getLong("sell_systemid"));
                view_combinedtrade.setSellsystem(dbresult.getString("sellsystem"));
                view_combinedtrade.setBuy_systemid(dbresult.getLong("buy_systemid"));
                view_combinedtrade.setBuysystem(dbresult.getString("buysystem"));
                view_combinedtrade.setTotal_volume(dbresult.getDouble("total_volume"));
                view_combinedtrade.setBuy_order_value(dbresult.getDouble("buy_order_value"));
                view_combinedtrade.setSell_order_value(dbresult.getDouble("sell_order_value"));
                view_combinedtrade.setProfit(dbresult.getDouble("profit"));
                view_combinedtrade.setJumps(dbresult.getInt("jumps"));
                view_combinedtrade.setRuns(dbresult.getLong("runs"));
                view_combinedtrade.setOrdercount(dbresult.getLong("ordercount"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return view_combinedtrade;
    }

}

