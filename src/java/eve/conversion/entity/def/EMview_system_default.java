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
import eve.logicview.View_system;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMview_system_default
 * Maps SQL ResultSet to eve.logicentity objects
 * @author Franky Laseure
 */
public class EMview_system_default implements ViewMapper {
    
    public static final String SQLSelectAll = "select view_system.* from view_system";
	  
    /**
     * 
     * @return SQL select statement for all View_systems
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to View_system
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_system view_system = new View_system();
        if(dbresult!=null) {
            try {
                view_system.setJumpssafe(dbresult.getInt("jumpssafe"));
                view_system.setJumpssafelowsec(dbresult.getInt("jumpssafelowsec"));
                view_system.setJumpssafenullsec(dbresult.getInt("jumpssafenullsec"));
                view_system.setRegionname(dbresult.getString("regionname"));
                view_system.setSystem_start(dbresult.getLong("system_start"));
                view_system.setSystem_end(dbresult.getLong("system_end"));
                view_system.setId(dbresult.getLong("id"));
                view_system.setName(dbresult.getString("name"));
                view_system.setConstellation(dbresult.getLong("constellation"));
                view_system.setSecurity_class(dbresult.getString("security_class"));
                view_system.setSecurity_status(dbresult.getDouble("security_status"));
                view_system.setStar_id(dbresult.getLong("star_id"));
                view_system.setNoaccess(dbresult.getBoolean("noaccess"));
                view_system.setIsconstellationborder(dbresult.getBoolean("isconstellationborder"));
                view_system.setIsregionborder(dbresult.getBoolean("isregionborder"));
                view_system.setSecurity_island(dbresult.getLong("security_island"));
                view_system.setDownloaddate(dbresult.getDate("downloaddate"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return view_system;
    }

}

