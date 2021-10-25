/*
 * EMalliance_default.java
 *
 * Created on Okt 8, 2021
 * Generated on 25.9.2021 15:16
 *
 */
package eve.conversion.entity.def;

import data.gis.shape.*;
import data.interfaces.db.View;
import data.json.piJson;
import db.ViewMapper;
import eve.logicview.View_systemtrade_order;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMview_systemtrade_order_default
 * Maps SQL ResultSet to eve.logicentity objects
 * @author Franky Laseure
 */
public class EMview_systemtrade_order_default implements ViewMapper {
    
    public static final String SQLSelectAll = "select view_systemtrade_order.* from view_systemtrade_order";
	  
    /**
     * 
     * @return SQL select statement for all View_systemtrade_orders
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to View_systemtrade_order
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_systemtrade_order view_systemtrade_order = new View_systemtrade_order();
        if(dbresult!=null) {
            try {
                view_systemtrade_order.setSell_system(dbresult.getLong("sell_system"));
                view_systemtrade_order.setBuy_system(dbresult.getLong("buy_system"));
                view_systemtrade_order.setSell_order(dbresult.getLong("sell_order"));
                view_systemtrade_order.setBuy_order(dbresult.getLong("buy_order"));
                view_systemtrade_order.setAmount(dbresult.getLong("amount"));
                view_systemtrade_order.setSellprice(dbresult.getDouble("sellprice"));
                view_systemtrade_order.setBuyprice(dbresult.getDouble("buyprice"));
                view_systemtrade_order.setProfit(dbresult.getDouble("profit"));
                view_systemtrade_order.setCargovolume(dbresult.getDouble("cargovolume"));
                view_systemtrade_order.setEvetype(dbresult.getLong("evetype"));
                view_systemtrade_order.setEvetypename(dbresult.getString("evetypename"));
                view_systemtrade_order.setSell_volume_remain(dbresult.getLong("sell_volume_remain"));
                view_systemtrade_order.setSell_price(dbresult.getDouble("sell_price"));
                view_systemtrade_order.setSell_station(dbresult.getLong("sell_station"));
                view_systemtrade_order.setSell_stationname(dbresult.getString("sell_stationname"));
                view_systemtrade_order.setBuy_volume_remain(dbresult.getLong("buy_volume_remain"));
                view_systemtrade_order.setBuy_price(dbresult.getDouble("buy_price"));
                view_systemtrade_order.setBuy_station(dbresult.getLong("buy_station"));
                view_systemtrade_order.setBuy_stationname(dbresult.getString("buy_stationname"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return view_systemtrade_order;
    }

}

