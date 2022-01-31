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
import eve.logicview.View_materialinputavg;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMview_materialinputavg_default
 * Maps SQL ResultSet to eve.logicentity objects
 * @author Franky Laseure
 */
public class EMview_materialinputavg_default implements ViewMapper {
    
    public static final String SQLSelectAll = "select view_materialinputavg.* from view_materialinputavg";
	  
    /**
     * 
     * @return SQL select statement for all View_materialinputavgs
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to View_materialinputavg
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_materialinputavg view_materialinputavg = new View_materialinputavg();
        if(dbresult!=null) {
            try {
                view_materialinputavg.setUsername(dbresult.getString("username"));
                view_materialinputavg.setEvetype(dbresult.getLong("evetype"));
                view_materialinputavg.setLastbuytimestamp(dbresult.getTimestamp("lastbuytimestamp"));
                view_materialinputavg.setTotalamount(dbresult.getFloat("totalamount"));
                view_materialinputavg.setAvgunitprice(dbresult.getDouble("avgunitprice"));
                view_materialinputavg.setTotalusedamount(dbresult.getFloat("totalusedamount"));
                view_materialinputavg.setName(dbresult.getString("name"));
                view_materialinputavg.setPackaged_volume(dbresult.getDouble("packaged_volume"));
                view_materialinputavg.setAverage(dbresult.getDouble("average"));
                view_materialinputavg.setHighest(dbresult.getDouble("highest"));
                view_materialinputavg.setLowest(dbresult.getDouble("lowest"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return view_materialinputavg;
    }

}

