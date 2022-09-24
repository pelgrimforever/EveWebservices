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
import eve.logicview.View_stocktrade_orders;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class EMview_stocktrade_orders_default implements eveDatabaseproperties, ViewMapper {
    
    public static final String SQLSelectAll = "select view_stocktrade_orders.* from view_stocktrade_orders";
	  
    @Override
    public String getDbtool() { return databasetool; }
    
    @Override
    public String getConnectionpool() { return connectionpool; }
    
    @Override
    public String getTable() { return "view_stocktrade_orders"; }

    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    @Override
    public View mapResultSet2Entity(ResultSet dbresult) throws SQLException {
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
                view_stocktrade_orders.setOrderid(dbresult.getLong("orderid"));
                view_stocktrade_orders.setSellamount(dbresult.getLong("sellamount"));
                view_stocktrade_orders.setPrice(dbresult.getDouble("price"));
                view_stocktrade_orders.setTotalprice(dbresult.getDouble("totalprice"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return view_stocktrade_orders;
    }

}

