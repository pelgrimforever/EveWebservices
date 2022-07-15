/*
 * Created on Okt 8, 2021
 * Generated on 13.6.2022 11:21
 */
package eve.conversion.entity.def;

import data.gis.shape.*;
import data.interfaces.db.*;
import data.json.piJson;
import db.ViewMapper;
import eve.eveDatabaseproperties;
import eve.logicview.View_evetype_order_history_region_month;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class EMview_evetype_order_history_region_month_default implements eveDatabaseproperties, ViewMapper {
    
    public static final String SQLSelectAll = "select view_evetype_order_history_region_month.* from view_evetype_order_history_region_month";
	  
    @Override
    public String getDbtool() { return databasetool; }
    
    @Override
    public String getConnectionpool() { return connectionpool; }
    
    @Override
    public String getTable() { return "view_evetype_order_history_region_month"; }

    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    @Override
    public View mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_evetype_order_history_region_month view_evetype_order_history_region_month = new View_evetype_order_history_region_month();
        if(dbresult!=null) {
            try {
                view_evetype_order_history_region_month.setRegion(dbresult.getLong("region"));
                view_evetype_order_history_region_month.setRegionname(dbresult.getString("regionname"));
                view_evetype_order_history_region_month.setEvetype(dbresult.getLong("evetype"));
                view_evetype_order_history_region_month.setYear(dbresult.getInt("year"));
                view_evetype_order_history_region_month.setMonth(dbresult.getInt("month"));
                view_evetype_order_history_region_month.setAverage(dbresult.getDouble("average"));
                view_evetype_order_history_region_month.setHighest(dbresult.getDouble("highest"));
                view_evetype_order_history_region_month.setLowest(dbresult.getDouble("lowest"));
                view_evetype_order_history_region_month.setVolume(dbresult.getFloat("volume"));
                view_evetype_order_history_region_month.setOrdercount(dbresult.getFloat("ordercount"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return view_evetype_order_history_region_month;
    }

}

