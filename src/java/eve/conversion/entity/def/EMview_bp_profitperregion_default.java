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
import eve.logicview.View_bp_profitperregion;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMview_bp_profitperregion_default
 * Maps SQL ResultSet to eve.logicentity objects
 * @author Franky Laseure
 */
public class EMview_bp_profitperregion_default implements ViewMapper {
    
    public static final String SQLSelectAll = "select view_bp_profitperregion.* from view_bp_profitperregion";
	  
    /**
     * 
     * @return SQL select statement for all View_bp_profitperregions
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to View_bp_profitperregion
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_bp_profitperregion view_bp_profitperregion = new View_bp_profitperregion();
        if(dbresult!=null) {
            try {
                view_bp_profitperregion.setCategoryid(dbresult.getLong("categoryid"));
                view_bp_profitperregion.setCategoryname(dbresult.getString("categoryname"));
                view_bp_profitperregion.setTypegroupid(dbresult.getLong("typegroupid"));
                view_bp_profitperregion.setTypegroupname(dbresult.getString("typegroupname"));
                view_bp_profitperregion.setId(dbresult.getLong("id"));
                view_bp_profitperregion.setName(dbresult.getString("name"));
                view_bp_profitperregion.setEstimatedproductioncost(dbresult.getDouble("estimatedproductioncost"));
                view_bp_profitperregion.setRegion(dbresult.getLong("region"));
                view_bp_profitperregion.setRegionname(dbresult.getString("regionname"));
                view_bp_profitperregion.setYear(dbresult.getInt("year"));
                view_bp_profitperregion.setMonth(dbresult.getInt("month"));
                view_bp_profitperregion.setAverage(dbresult.getDouble("average"));
                view_bp_profitperregion.setHighest(dbresult.getDouble("highest"));
                view_bp_profitperregion.setLowest(dbresult.getDouble("lowest"));
                view_bp_profitperregion.setVolume(dbresult.getFloat("volume"));
                view_bp_profitperregion.setOrdercount(dbresult.getFloat("ordercount"));
                view_bp_profitperregion.setPercprofit(dbresult.getDouble("percprofit"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return view_bp_profitperregion;
    }

}

