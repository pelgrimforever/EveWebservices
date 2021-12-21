/*
 * EMalliance_default.java
 *
 * Created on Okt 8, 2021
 * Generated on 16.11.2021 15:46
 *
 */
package eve.conversion.entity.def;

import data.gis.shape.*;
import data.interfaces.db.View;
import data.json.piJson;
import db.ViewMapper;
import eve.logicview.View_tradecombined_sell;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMview_tradecombined_sell_default
 * Maps SQL ResultSet to eve.logicentity objects
 * @author Franky Laseure
 */
public class EMview_tradecombined_sell_default implements ViewMapper {
    
    public static final String SQLSelectAll = "select view_tradecombined_sell.* from view_tradecombined_sell";
	  
    /**
     * 
     * @return SQL select statement for all View_tradecombined_sells
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to View_tradecombined_sell
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_tradecombined_sell view_tradecombined_sell = new View_tradecombined_sell();
        if(dbresult!=null) {
            try {
                view_tradecombined_sell.setSell_system(dbresult.getLong("sell_system"));
                view_tradecombined_sell.setBuy_system(dbresult.getLong("buy_system"));
                view_tradecombined_sell.setOrderamount(dbresult.getLong("orderamount"));
                view_tradecombined_sell.setBuy_order_value(dbresult.getDouble("buy_order_value"));
                view_tradecombined_sell.setSell_order_value(dbresult.getDouble("sell_order_value"));
                view_tradecombined_sell.setProfit(dbresult.getDouble("profit"));
                view_tradecombined_sell.setSell_locationid(dbresult.getLong("sell_locationid"));
                view_tradecombined_sell.setSell_stationname(dbresult.getString("sell_stationname"));
                view_tradecombined_sell.setEvetype_id(dbresult.getLong("evetype_id"));
                view_tradecombined_sell.setEvetype_name(dbresult.getString("evetype_name"));
                view_tradecombined_sell.setPackaged_volume(dbresult.getDouble("packaged_volume"));
                view_tradecombined_sell.setSell_id(dbresult.getLong("sell_id"));
                view_tradecombined_sell.setSell_volume_total(dbresult.getLong("sell_volume_total"));
                view_tradecombined_sell.setSell_volume_remain(dbresult.getLong("sell_volume_remain"));
                view_tradecombined_sell.setSell_min_volume(dbresult.getInt("sell_min_volume"));
                view_tradecombined_sell.setSell_updated(dbresult.getLong("sell_updated"));
                view_tradecombined_sell.setBuy_id(dbresult.getLong("buy_id"));
                view_tradecombined_sell.setSell_price(dbresult.getDouble("sell_price"));
                view_tradecombined_sell.setBuy_volume_total(dbresult.getLong("buy_volume_total"));
                view_tradecombined_sell.setBuy_volume_remain(dbresult.getLong("buy_volume_remain"));
                view_tradecombined_sell.setBuy_min_volume(dbresult.getInt("buy_min_volume"));
                view_tradecombined_sell.setBuy_updated(dbresult.getLong("buy_updated"));
                view_tradecombined_sell.setBuy_price(dbresult.getDouble("buy_price"));
                view_tradecombined_sell.setBuy_locationid(dbresult.getLong("buy_locationid"));
                view_tradecombined_sell.setBuy_stationname(dbresult.getString("buy_stationname"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return view_tradecombined_sell;
    }

}

