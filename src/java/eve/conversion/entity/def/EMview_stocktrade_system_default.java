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
import eve.logicview.View_stocktrade_system;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMview_stocktrade_system_default
 * Maps SQL ResultSet to eve.logicentity objects
 * @author Franky Laseure
 */
public class EMview_stocktrade_system_default implements ViewMapper {
    
    public static final String SQLSelectAll = "select view_stocktrade_system.* from view_stocktrade_system";
	  
    /**
     * 
     * @return SQL select statement for all View_stocktrade_systems
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to View_stocktrade_system
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_stocktrade_system view_stocktrade_system = new View_stocktrade_system();
        if(dbresult!=null) {
            try {
                view_stocktrade_system.setUsername(dbresult.getString("username"));
                view_stocktrade_system.setId(dbresult.getLong("id"));
                view_stocktrade_system.setName(dbresult.getString("name"));
                view_stocktrade_system.setRegion(dbresult.getString("region"));
                view_stocktrade_system.setSellprice(dbresult.getDouble("sellprice"));
                view_stocktrade_system.setTotalvolume(dbresult.getDouble("totalvolume"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return view_stocktrade_system;
    }

}

