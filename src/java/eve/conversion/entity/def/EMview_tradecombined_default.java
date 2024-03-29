/*
 * Created on Okt 8, 2021
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */
package eve.conversion.entity.def;

import data.gis.shape.*;
import data.interfaces.db.*;
import data.json.piJson;
import db.ViewMapper;
import eve.eveDatabaseproperties;
import eve.logicview.View_tradecombined;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class EMview_tradecombined_default implements eveDatabaseproperties, ViewMapper {
    
    public static final String SQLSelectAll = "select view_tradecombined.* from view_tradecombined";
	  
    @Override
    public String getDbtool() { return databasetool; }
    
    @Override
    public String getConnectionpool() { return connectionpool; }
    
    @Override
    public String getTable() { return "view_tradecombined"; }

    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    @Override
    public View mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_tradecombined view_tradecombined = new View_tradecombined();
        if(dbresult!=null) {
            try {
                view_tradecombined.setSell_regionid(dbresult.getLong("sell_regionid"));
                view_tradecombined.setSell_regionname(dbresult.getString("sell_regionname"));
                view_tradecombined.setSell_systemid(dbresult.getLong("sell_systemid"));
                view_tradecombined.setSell_systemname(dbresult.getString("sell_systemname"));
                view_tradecombined.setEvetype_id(dbresult.getLong("evetype_id"));
                view_tradecombined.setEvetype_name(dbresult.getString("evetype_name"));
                view_tradecombined.setPackaged_volume(dbresult.getDouble("packaged_volume"));
                view_tradecombined.setOrders(dbresult.getLong("orders"));
                view_tradecombined.setTotalamount(dbresult.getFloat("totalamount"));
                view_tradecombined.setBuy_order_total(dbresult.getDouble("buy_order_total"));
                view_tradecombined.setSell_order_total(dbresult.getDouble("sell_order_total"));
                view_tradecombined.setTotalprofit(dbresult.getDouble("totalprofit"));
                view_tradecombined.setBuy_systemid(dbresult.getLong("buy_systemid"));
                view_tradecombined.setBuy_systemname(dbresult.getString("buy_systemname"));
                view_tradecombined.setTrade_jumps(dbresult.getInt("trade_jumps"));
                view_tradecombined.setTrade_jumpslowsec(dbresult.getInt("trade_jumpslowsec"));
                view_tradecombined.setTrade_jumpsnullsec(dbresult.getInt("trade_jumpsnullsec"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return view_tradecombined;
    }

}

