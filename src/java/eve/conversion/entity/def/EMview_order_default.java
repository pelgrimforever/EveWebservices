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
import eve.logicview.View_order;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class EMview_order_default implements eveDatabaseproperties, ViewMapper {
    
    public static final String SQLSelectAll = "select view_order.* from view_order";
	  
    @Override
    public String getDbtool() { return databasetool; }
    
    @Override
    public String getConnectionpool() { return connectionpool; }
    
    @Override
    public String getTable() { return "view_order"; }

    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    @Override
    public View mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_order view_order = new View_order();
        if(dbresult!=null) {
            try {
                view_order.setId(dbresult.getLong("id"));
                view_order.setIsopen(dbresult.getBoolean("isopen"));
                view_order.setSystem(dbresult.getLong("system"));
                view_order.setEvetype(dbresult.getLong("evetype"));
                view_order.setVolume_total(dbresult.getLong("volume_total"));
                view_order.setVolume_remain(dbresult.getLong("volume_remain"));
                view_order.setRange(dbresult.getString("range"));
                view_order.setRange_number(dbresult.getInt("range_number"));
                view_order.setPrice(dbresult.getDouble("price"));
                view_order.setMin_volume(dbresult.getInt("min_volume"));
                view_order.setLocation(dbresult.getLong("location"));
                view_order.setIs_buy_order(dbresult.getBoolean("is_buy_order"));
                view_order.setIssued(dbresult.getTimestamp("issued"));
                view_order.setDuration(dbresult.getInt("duration"));
                view_order.setPage(dbresult.getInt("page"));
                view_order.setStationid(dbresult.getLong("stationid"));
                view_order.setStationname(dbresult.getString("stationname"));
                view_order.setLocationid(dbresult.getLong("locationid"));
                view_order.setLocationname(dbresult.getString("locationname"));
                view_order.setSystemname(dbresult.getString("systemname"));
                view_order.setSecurity_status(dbresult.getDouble("security_status"));
                view_order.setConstellation(dbresult.getLong("constellation"));
                view_order.setConstellationname(dbresult.getString("constellationname"));
                view_order.setRegion(dbresult.getLong("region"));
                view_order.setRegionname(dbresult.getString("regionname"));
                view_order.setEvetypename(dbresult.getString("evetypename"));
                view_order.setPackaged_volume(dbresult.getDouble("packaged_volume"));
                view_order.setAvg_buyorder(dbresult.getDouble("avg_buyorder"));
                view_order.setAvg_sellorder(dbresult.getDouble("avg_sellorder"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return view_order;
    }

}

