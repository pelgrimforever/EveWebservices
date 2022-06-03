/*
 * EMalliance_default.java
 *
 * Created on Okt 8, 2021
 * Generated on 20.4.2022 10:3
 *
 */
package eve.conversion.entity.def;

import data.gis.shape.*;
import data.interfaces.db.View;
import data.json.piJson;
import db.ViewMapper;
import eve.logicview.View_activemodules;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMview_activemodules_default
 * Maps SQL ResultSet to eve.logicentity objects
 * @author Franky Laseure
 */
public class EMview_activemodules_default implements ViewMapper {
    
    public static final String SQLSelectAll = "select view_activemodules.* from view_activemodules";
	  
    /**
     * 
     * @return SQL select statement for all View_activemoduless
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to View_activemodules
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_activemodules view_activemodules = new View_activemodules();
        if(dbresult!=null) {
            try {
                view_activemodules.setTypegroupid(dbresult.getLong("typegroupid"));
                view_activemodules.setTypegroupname(dbresult.getString("typegroupname"));
                view_activemodules.setId(dbresult.getLong("id"));
                view_activemodules.setName(dbresult.getString("name"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return view_activemodules;
    }

}

