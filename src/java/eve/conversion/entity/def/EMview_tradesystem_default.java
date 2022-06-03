/*
 * EMalliance_default.java
 *
 * Created on Okt 8, 2021
 * Generated on 20.4.2022 10:3
 *
 */
package eve.conversion.entity.def;

import data.gis.shape.*;
import data.interfaces.db.View;
import data.json.piJson;
import db.ViewMapper;
import eve.logicview.View_tradesystem;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMview_tradesystem_default
 * Maps SQL ResultSet to eve.logicentity objects
 * @author Franky Laseure
 */
public class EMview_tradesystem_default implements ViewMapper {
    
    public static final String SQLSelectAll = "select view_tradesystem.* from view_tradesystem";
	  
    /**
     * 
     * @return SQL select statement for all View_tradesystems
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to View_tradesystem
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_tradesystem view_tradesystem = new View_tradesystem();
        if(dbresult!=null) {
            try {
                view_tradesystem.setSell_regionid(dbresult.getLong("sell_regionid"));
                view_tradesystem.setSell_regionname(dbresult.getString("sell_regionname"));
                view_tradesystem.setSell_systemid(dbresult.getLong("sell_systemid"));
                view_tradesystem.setSell_systemname(dbresult.getString("sell_systemname"));
                view_tradesystem.setOrders(dbresult.getFloat("orders"));
                view_tradesystem.setBuy_total(dbresult.getDouble("buy_total"));
                view_tradesystem.setSell_total(dbresult.getDouble("sell_total"));
                view_tradesystem.setTotalprofit(dbresult.getDouble("totalprofit"));
                view_tradesystem.setTotalvolume(dbresult.getDouble("totalvolume"));
                view_tradesystem.setBuy_systemid(dbresult.getLong("buy_systemid"));
                view_tradesystem.setBuy_systemname(dbresult.getString("buy_systemname"));
                view_tradesystem.setTrade_jumps(dbresult.getInt("trade_jumps"));
                view_tradesystem.setTrade_jumpslowsec(dbresult.getInt("trade_jumpslowsec"));
                view_tradesystem.setTrade_jumpsnullsec(dbresult.getInt("trade_jumpsnullsec"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return view_tradesystem;
    }

}

