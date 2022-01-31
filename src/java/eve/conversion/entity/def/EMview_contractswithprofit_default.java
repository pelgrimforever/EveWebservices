/*
 * EMalliance_default.java
 *
 * Created on Okt 8, 2021
 * Generated on 31.0.2022 17:49
 *
 */
package eve.conversion.entity.def;

import data.gis.shape.*;
import data.interfaces.db.View;
import data.json.piJson;
import db.ViewMapper;
import eve.logicview.View_contractswithprofit;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMview_contractswithprofit_default
 * Maps SQL ResultSet to eve.logicentity objects
 * @author Franky Laseure
 */
public class EMview_contractswithprofit_default implements ViewMapper {
    
    public static final String SQLSelectAll = "select view_contractswithprofit.* from view_contractswithprofit";
	  
    /**
     * 
     * @return SQL select statement for all View_contractswithprofits
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to View_contractswithprofit
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_contractswithprofit view_contractswithprofit = new View_contractswithprofit();
        if(dbresult!=null) {
            try {
                view_contractswithprofit.setId(dbresult.getLong("id"));
                view_contractswithprofit.setDate_expired(dbresult.getTimestamp("date_expired"));
                view_contractswithprofit.setDate_issued(dbresult.getTimestamp("date_issued"));
                view_contractswithprofit.setDays_to_complete(dbresult.getInt("days_to_complete"));
                view_contractswithprofit.setEnd_location_id(dbresult.getLong("end_location_id"));
                view_contractswithprofit.setPrice(dbresult.getDouble("price"));
                view_contractswithprofit.setReward(dbresult.getDouble("reward"));
                view_contractswithprofit.setStart_location_id(dbresult.getLong("start_location_id"));
                view_contractswithprofit.setName(dbresult.getString("name"));
                view_contractswithprofit.setSystemname(dbresult.getString("systemname"));
                view_contractswithprofit.setRegionname(dbresult.getString("regionname"));
                view_contractswithprofit.setTitle(dbresult.getString("title"));
                view_contractswithprofit.setVolume(dbresult.getDouble("volume"));
                view_contractswithprofit.setSellprice(dbresult.getDouble("sellprice"));
                view_contractswithprofit.setBuyprice(dbresult.getDouble("buyprice"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return view_contractswithprofit;
    }

}

