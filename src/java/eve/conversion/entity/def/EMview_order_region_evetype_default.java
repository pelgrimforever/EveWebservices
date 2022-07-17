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
import eve.logicview.View_order_region_evetype;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class EMview_order_region_evetype_default implements eveDatabaseproperties, ViewMapper {
    
    public static final String SQLSelectAll = "select view_order_region_evetype.* from view_order_region_evetype";
	  
    @Override
    public String getDbtool() { return databasetool; }
    
    @Override
    public String getConnectionpool() { return connectionpool; }
    
    @Override
    public String getTable() { return "view_order_region_evetype"; }

    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    @Override
    public View mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_order_region_evetype view_order_region_evetype = new View_order_region_evetype();
        if(dbresult!=null) {
            try {
                view_order_region_evetype.setRegion(dbresult.getLong("region"));
                view_order_region_evetype.setEvetype(dbresult.getLong("evetype"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return view_order_region_evetype;
    }

}

