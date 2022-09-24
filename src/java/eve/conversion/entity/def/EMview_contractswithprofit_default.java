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
import eve.logicview.View_contractswithprofit;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class EMview_contractswithprofit_default implements eveDatabaseproperties, ViewMapper {
    
    public static final String SQLSelectAll = "select view_contractswithprofit.* from view_contractswithprofit";
	  
    @Override
    public String getDbtool() { return databasetool; }
    
    @Override
    public String getConnectionpool() { return connectionpool; }
    
    @Override
    public String getTable() { return "view_contractswithprofit"; }

    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    @Override
    public View mapResultSet2Entity(ResultSet dbresult) throws SQLException {
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

