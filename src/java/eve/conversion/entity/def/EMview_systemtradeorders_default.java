/*
 * EMalliance_default.java
 *
 * Created on Okt 8, 2021
 * Generated on 25.9.2021 15:16
 *
 */
package eve.conversion.entity.def;

import data.gis.shape.*;
import data.interfaces.db.View;
import data.json.piJson;
import db.ViewMapper;
import eve.logicview.View_systemtradeorders;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMview_systemtradeorders_default
 * Maps SQL ResultSet to eve.logicentity objects
 * @author Franky Laseure
 */
public class EMview_systemtradeorders_default implements ViewMapper {
    
    public static final String SQLSelectAll = "select view_systemtradeorders.* from view_systemtradeorders";
	  
    /**
     * 
     * @return SQL select statement for all View_systemtradeorderss
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to View_systemtradeorders
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_systemtradeorders view_systemtradeorders = new View_systemtradeorders();
        if(dbresult!=null) {
            try {
                view_systemtradeorders.setBuy_totalprice(dbresult.getDouble("buy_totalprice"));
                view_systemtradeorders.setSell_totalprice(dbresult.getDouble("sell_totalprice"));
                view_systemtradeorders.setCargo_volume(dbresult.getDouble("cargo_volume"));
                view_systemtradeorders.setSellorderid(dbresult.getLong("sellorderid"));
                view_systemtradeorders.setBuyorderid(dbresult.getLong("buyorderid"));
                view_systemtradeorders.setEvetype(dbresult.getLong("evetype"));
                view_systemtradeorders.setPackaged_volume(dbresult.getDouble("packaged_volume"));
                view_systemtradeorders.setSecurity_island(dbresult.getLong("security_island"));
                view_systemtradeorders.setSell_system(dbresult.getLong("sell_system"));
                view_systemtradeorders.setBuy_system(dbresult.getLong("buy_system"));
                view_systemtradeorders.setJumps(dbresult.getInt("jumps"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return view_systemtradeorders;
    }

}

