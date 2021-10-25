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
import eve.logicview.View_systemtrade;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMview_systemtrade_default
 * Maps SQL ResultSet to eve.logicentity objects
 * @author Franky Laseure
 */
public class EMview_systemtrade_default implements ViewMapper {
    
    public static final String SQLSelectAll = "select view_systemtrade.* from view_systemtrade";
	  
    /**
     * 
     * @return SQL select statement for all View_systemtrades
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to View_systemtrade
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_systemtrade view_systemtrade = new View_systemtrade();
        if(dbresult!=null) {
            try {
                view_systemtrade.setSell_system(dbresult.getLong("sell_system"));
                view_systemtrade.setBuy_system(dbresult.getLong("buy_system"));
                view_systemtrade.setOrdercount(dbresult.getLong("ordercount"));
                view_systemtrade.setTotalsell(dbresult.getDouble("totalsell"));
                view_systemtrade.setTotalbuy(dbresult.getDouble("totalbuy"));
                view_systemtrade.setProfit(dbresult.getDouble("profit"));
                view_systemtrade.setTotal_cargo_volume(dbresult.getDouble("total_cargo_volume"));
                view_systemtrade.setJumps(dbresult.getInt("jumps"));
                view_systemtrade.setRegionsellname(dbresult.getString("regionsellname"));
                view_systemtrade.setSystemsellname(dbresult.getString("systemsellname"));
                view_systemtrade.setRegionbuyname(dbresult.getString("regionbuyname"));
                view_systemtrade.setSystembuyname(dbresult.getString("systembuyname"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return view_systemtrade;
    }

}

