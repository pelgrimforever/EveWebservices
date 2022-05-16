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
import eve.logicview.View_shipfitorderselected;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMview_shipfitorderselected_default
 * Maps SQL ResultSet to eve.logicentity objects
 * @author Franky Laseure
 */
public class EMview_shipfitorderselected_default implements ViewMapper {
    
    public static final String SQLSelectAll = "select view_shipfitorderselected.* from view_shipfitorderselected";
	  
    /**
     * 
     * @return SQL select statement for all View_shipfitorderselecteds
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to View_shipfitorderselected
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_shipfitorderselected view_shipfitorderselected = new View_shipfitorderselected();
        if(dbresult!=null) {
            try {
                view_shipfitorderselected.setUsername(dbresult.getString("username"));
                view_shipfitorderselected.setShipname(dbresult.getString("shipname"));
                view_shipfitorderselected.setAmountneeded(dbresult.getInt("amountneeded"));
                view_shipfitorderselected.setId(dbresult.getLong("id"));
                view_shipfitorderselected.setIsopen(dbresult.getBoolean("isopen"));
                view_shipfitorderselected.setSystem(dbresult.getLong("system"));
                view_shipfitorderselected.setEvetype(dbresult.getLong("evetype"));
                view_shipfitorderselected.setVolume_total(dbresult.getLong("volume_total"));
                view_shipfitorderselected.setVolume_remain(dbresult.getLong("volume_remain"));
                view_shipfitorderselected.setRange(dbresult.getString("range"));
                view_shipfitorderselected.setRange_number(dbresult.getInt("range_number"));
                view_shipfitorderselected.setPrice(dbresult.getDouble("price"));
                view_shipfitorderselected.setMin_volume(dbresult.getInt("min_volume"));
                view_shipfitorderselected.setLocation(dbresult.getLong("location"));
                view_shipfitorderselected.setIs_buy_order(dbresult.getBoolean("is_buy_order"));
                view_shipfitorderselected.setIssued(dbresult.getTimestamp("issued"));
                view_shipfitorderselected.setDuration(dbresult.getInt("duration"));
                view_shipfitorderselected.setPage(dbresult.getInt("page"));
                view_shipfitorderselected.setStationid(dbresult.getLong("stationid"));
                view_shipfitorderselected.setStationname(dbresult.getString("stationname"));
                view_shipfitorderselected.setLocationid(dbresult.getLong("locationid"));
                view_shipfitorderselected.setLocationname(dbresult.getString("locationname"));
                view_shipfitorderselected.setSystemname(dbresult.getString("systemname"));
                view_shipfitorderselected.setSecurity_status(dbresult.getDouble("security_status"));
                view_shipfitorderselected.setConstellation(dbresult.getLong("constellation"));
                view_shipfitorderselected.setConstellationname(dbresult.getString("constellationname"));
                view_shipfitorderselected.setRegion(dbresult.getLong("region"));
                view_shipfitorderselected.setRegionname(dbresult.getString("regionname"));
                view_shipfitorderselected.setEvetypename(dbresult.getString("evetypename"));
                view_shipfitorderselected.setPackaged_volume(dbresult.getDouble("packaged_volume"));
                view_shipfitorderselected.setAvg_buyorder(dbresult.getDouble("avg_buyorder"));
                view_shipfitorderselected.setAvg_sellorder(dbresult.getDouble("avg_sellorder"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return view_shipfitorderselected;
    }

}

