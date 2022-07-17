/*
 * Created on Okt 8, 2021
 * Generated on 17.6.2022 13:4
 */
package eve.conversion.entity.def;

import data.gis.shape.*;
import data.interfaces.db.*;
import data.json.piJson;
import db.ViewMapper;
import eve.eveDatabaseproperties;
import eve.logicview.View_stocktrade_system;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class EMview_stocktrade_system_default implements eveDatabaseproperties, ViewMapper {
    
    public static final String SQLSelectAll = "select view_stocktrade_system.* from view_stocktrade_system";
	  
    @Override
    public String getDbtool() { return databasetool; }
    
    @Override
    public String getConnectionpool() { return connectionpool; }
    
    @Override
    public String getTable() { return "view_stocktrade_system"; }

    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    @Override
    public View mapResultSet2Entity(ResultSet dbresult) throws SQLException {
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

