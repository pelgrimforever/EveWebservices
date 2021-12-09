/*
 * EMalliance_default.java
 *
 * Created on Okt 8, 2021
 * Generated on 9.11.2021 14:30
 *
 */
package eve.conversion.entity.def;

import data.gis.shape.*;
import data.interfaces.db.View;
import data.json.piJson;
import db.ViewMapper;
import eve.logicview.View_order;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMview_order_default
 * Maps SQL ResultSet to eve.logicentity objects
 * @author Franky Laseure
 */
public class EMview_order_default implements ViewMapper {
    
    public static final String SQLSelectAll = "select view_order.* from view_order";
	  
    /**
     * 
     * @return SQL select statement for all View_orders
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to View_order
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
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
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return view_order;
    }

}

