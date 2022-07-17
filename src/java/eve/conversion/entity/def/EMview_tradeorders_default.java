/*
 * Created on Okt 8, 2021
 * Generated on 17.6.2022 13:4
 */
package eve.conversion.entity.def;

import data.gis.shape.*;
import data.interfaces.db.*;
import data.json.piJson;
import db.ViewMapper;
import eve.eveDatabaseproperties;
import eve.logicview.View_tradeorders;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class EMview_tradeorders_default implements eveDatabaseproperties, ViewMapper {
    
    public static final String SQLSelectAll = "select view_tradeorders.* from view_tradeorders";
	  
    @Override
    public String getDbtool() { return databasetool; }
    
    @Override
    public String getConnectionpool() { return connectionpool; }
    
    @Override
    public String getTable() { return "view_tradeorders"; }

    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    @Override
    public View mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_tradeorders view_tradeorders = new View_tradeorders();
        if(dbresult!=null) {
            try {
                view_tradeorders.setTradevolume(dbresult.getLong("tradevolume"));
                view_tradeorders.setBuy_totalprice(dbresult.getDouble("buy_totalprice"));
                view_tradeorders.setSell_totalprice(dbresult.getDouble("sell_totalprice"));
                view_tradeorders.setCargo_volume(dbresult.getDouble("cargo_volume"));
                view_tradeorders.setSell_id(dbresult.getLong("sell_id"));
                view_tradeorders.setSell_system(dbresult.getLong("sell_system"));
                view_tradeorders.setSell_location(dbresult.getLong("sell_location"));
                view_tradeorders.setSell_evetype(dbresult.getLong("sell_evetype"));
                view_tradeorders.setSell_packaged_volume(dbresult.getDouble("sell_packaged_volume"));
                view_tradeorders.setSell_volume_remain(dbresult.getLong("sell_volume_remain"));
                view_tradeorders.setSell_price(dbresult.getDouble("sell_price"));
                view_tradeorders.setSecurity_island(dbresult.getLong("security_island"));
                view_tradeorders.setBuy_id(dbresult.getLong("buy_id"));
                view_tradeorders.setBuy_system(dbresult.getLong("buy_system"));
                view_tradeorders.setBuy_location(dbresult.getLong("buy_location"));
                view_tradeorders.setBuy_volume_remain(dbresult.getLong("buy_volume_remain"));
                view_tradeorders.setBuy_price(dbresult.getDouble("buy_price"));
                view_tradeorders.setJumps(dbresult.getInt("jumps"));
                view_tradeorders.setJumpslowsec(dbresult.getInt("jumpslowsec"));
                view_tradeorders.setJumpsnullsec(dbresult.getInt("jumpsnullsec"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return view_tradeorders;
    }

}

