/*
 * EMalliance_default.java
 *
 * Created on Okt 8, 2021
 * Generated on 13.4.2022 19:13
 *
 */
package eve.conversion.entity.def;

import data.gis.shape.*;
import data.interfaces.db.View;
import data.json.piJson;
import db.ViewMapper;
import eve.logicview.View_evetype_order_history_month;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMview_evetype_order_history_month_default
 * Maps SQL ResultSet to eve.logicentity objects
 * @author Franky Laseure
 */
public class EMview_evetype_order_history_month_default implements ViewMapper {
    
    public static final String SQLSelectAll = "select view_evetype_order_history_month.* from view_evetype_order_history_month";
	  
    /**
     * 
     * @return SQL select statement for all View_evetype_order_history_months
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to View_evetype_order_history_month
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_evetype_order_history_month view_evetype_order_history_month = new View_evetype_order_history_month();
        if(dbresult!=null) {
            try {
                view_evetype_order_history_month.setEvetype(dbresult.getLong("evetype"));
                view_evetype_order_history_month.setYear(dbresult.getInt("year"));
                view_evetype_order_history_month.setMonth(dbresult.getInt("month"));
                view_evetype_order_history_month.setAverage(dbresult.getDouble("average"));
                view_evetype_order_history_month.setHighest(dbresult.getDouble("highest"));
                view_evetype_order_history_month.setLowest(dbresult.getDouble("lowest"));
                view_evetype_order_history_month.setVolume(dbresult.getFloat("volume"));
                view_evetype_order_history_month.setOrdercount(dbresult.getFloat("ordercount"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return view_evetype_order_history_month;
    }

}

