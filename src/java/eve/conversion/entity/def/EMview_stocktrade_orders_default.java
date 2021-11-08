/*
 * EMalliance_default.java
 *
 * Created on Okt 8, 2021
 * Generated on 8.10.2021 7:21
 *
 */
package eve.conversion.entity.def;

import data.gis.shape.*;
import data.interfaces.db.View;
import data.json.piJson;
import db.ViewMapper;
import eve.logicview.View_stocktrade_orders;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMview_stocktrade_orders_default
 * Maps SQL ResultSet to eve.logicentity objects
 * @author Franky Laseure
 */
public class EMview_stocktrade_orders_default implements ViewMapper {
    
    public static final String SQLSelectAll = "select view_stocktrade_orders.* from view_stocktrade_orders";
	  
    /**
     * 
     * @return SQL select statement for all View_stocktrade_orderss
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to View_stocktrade_orders
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_stocktrade_orders view_stocktrade_orders = new View_stocktrade_orders();
        if(dbresult!=null) {
            try {
                view_stocktrade_orders.setUsername(dbresult.getString("username"));
                view_stocktrade_orders.setSystem(dbresult.getLong("system"));
                view_stocktrade_orders.setLocationid(dbresult.getLong("locationid"));
                view_stocktrade_orders.setStationname(dbresult.getString("stationname"));
                view_stocktrade_orders.setLocationname(dbresult.getString("locationname"));
                view_stocktrade_orders.setEvetypeid(dbresult.getLong("evetypeid"));
                view_stocktrade_orders.setEvetypename(dbresult.getString("evetypename"));
                view_stocktrade_orders.setPackaged_volume(dbresult.getDouble("packaged_volume"));
                view_stocktrade_orders.setMin_volume(dbresult.getInt("min_volume"));
                view_stocktrade_orders.setSellamount(dbresult.getLong("sellamount"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return view_stocktrade_orders;
    }

}

