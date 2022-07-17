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
import eve.logicview.View_tradeorders_lowsec;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class EMview_tradeorders_lowsec_default implements eveDatabaseproperties, ViewMapper {
    
    public static final String SQLSelectAll = "select view_tradeorders_lowsec.* from view_tradeorders_lowsec";
	  
    @Override
    public String getDbtool() { return databasetool; }
    
    @Override
    public String getConnectionpool() { return connectionpool; }
    
    @Override
    public String getTable() { return "view_tradeorders_lowsec"; }

    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    @Override
    public View mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_tradeorders_lowsec view_tradeorders_lowsec = new View_tradeorders_lowsec();
        if(dbresult!=null) {
            try {
                view_tradeorders_lowsec.setTradevolume(dbresult.getLong("tradevolume"));
                view_tradeorders_lowsec.setBuy_totalprice(dbresult.getDouble("buy_totalprice"));
                view_tradeorders_lowsec.setSell_totalprice(dbresult.getDouble("sell_totalprice"));
                view_tradeorders_lowsec.setCargo_volume(dbresult.getDouble("cargo_volume"));
                view_tradeorders_lowsec.setSell_id(dbresult.getLong("sell_id"));
                view_tradeorders_lowsec.setSell_system(dbresult.getLong("sell_system"));
                view_tradeorders_lowsec.setSell_location(dbresult.getLong("sell_location"));
                view_tradeorders_lowsec.setSell_evetype(dbresult.getLong("sell_evetype"));
                view_tradeorders_lowsec.setSell_packaged_volume(dbresult.getDouble("sell_packaged_volume"));
                view_tradeorders_lowsec.setSell_volume_remain(dbresult.getLong("sell_volume_remain"));
                view_tradeorders_lowsec.setSell_price(dbresult.getDouble("sell_price"));
                view_tradeorders_lowsec.setSecurity_island(dbresult.getLong("security_island"));
                view_tradeorders_lowsec.setBuy_id(dbresult.getLong("buy_id"));
                view_tradeorders_lowsec.setBuy_system(dbresult.getLong("buy_system"));
                view_tradeorders_lowsec.setBuy_location(dbresult.getLong("buy_location"));
                view_tradeorders_lowsec.setBuy_volume_remain(dbresult.getLong("buy_volume_remain"));
                view_tradeorders_lowsec.setBuy_price(dbresult.getDouble("buy_price"));
                view_tradeorders_lowsec.setJumps(dbresult.getInt("jumps"));
                view_tradeorders_lowsec.setJumpslowsec(dbresult.getInt("jumpslowsec"));
                view_tradeorders_lowsec.setJumpsnullsec(dbresult.getInt("jumpsnullsec"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return view_tradeorders_lowsec;
    }

}

