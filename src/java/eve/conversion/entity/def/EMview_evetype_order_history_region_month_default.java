/*
 * EMalliance_default.java
 *
 * Created on Okt 8, 2021
 * Generated on 22.1.2022 10:55
 *
 */
package eve.conversion.entity.def;

import data.gis.shape.*;
import data.interfaces.db.View;
import data.json.piJson;
import db.ViewMapper;
import eve.logicview.View_evetype_order_history_region_month;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMview_evetype_order_history_region_month_default
 * Maps SQL ResultSet to eve.logicentity objects
 * @author Franky Laseure
 */
public class EMview_evetype_order_history_region_month_default implements ViewMapper {
    
    public static final String SQLSelectAll = "select view_evetype_order_history_region_month.* from view_evetype_order_history_region_month";
	  
    /**
     * 
     * @return SQL select statement for all View_evetype_order_history_region_months
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to View_evetype_order_history_region_month
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
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

