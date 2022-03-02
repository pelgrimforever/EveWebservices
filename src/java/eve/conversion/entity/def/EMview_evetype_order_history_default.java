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
import eve.logicview.View_evetype_order_history;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMview_evetype_order_history_default
 * Maps SQL ResultSet to eve.logicentity objects
 * @author Franky Laseure
 */
public class EMview_evetype_order_history_default implements ViewMapper {
    
    public static final String SQLSelectAll = "select view_evetype_order_history.* from view_evetype_order_history";
	  
    /**
     * 
     * @return SQL select statement for all View_evetype_order_historys
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to View_evetype_order_history
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_evetype_order_history view_evetype_order_history = new View_evetype_order_history();
        if(dbresult!=null) {
            try {
                view_evetype_order_history.setEvetype(dbresult.getLong("evetype"));
                view_evetype_order_history.setDate(dbresult.getDate("date"));
                view_evetype_order_history.setAverage(dbresult.getDouble("average"));
                view_evetype_order_history.setHighest(dbresult.getDouble("highest"));
                view_evetype_order_history.setLowest(dbresult.getDouble("lowest"));
                view_evetype_order_history.setVolume(dbresult.getLong("volume"));
                view_evetype_order_history.setOrdercount(dbresult.getLong("ordercount"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return view_evetype_order_history;
    }

}

