/*
 * EMalliance_default.java
 *
 * Created on Okt 8, 2021
 * Generated on 14.0.2022 16:56
 *
 */
package eve.conversion.entity.def;

import data.gis.shape.*;
import data.interfaces.db.View;
import data.json.piJson;
import db.ViewMapper;
import eve.logicview.View_order_region_evetype;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMview_order_region_evetype_default
 * Maps SQL ResultSet to eve.logicentity objects
 * @author Franky Laseure
 */
public class EMview_order_region_evetype_default implements ViewMapper {
    
    public static final String SQLSelectAll = "select view_order_region_evetype.* from view_order_region_evetype";
	  
    /**
     * 
     * @return SQL select statement for all View_order_region_evetypes
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to View_order_region_evetype
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
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

