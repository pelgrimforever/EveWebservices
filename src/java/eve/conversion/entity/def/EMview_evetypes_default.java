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
import eve.logicview.View_evetypes;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMview_evetypes_default
 * Maps SQL ResultSet to eve.logicentity objects
 * @author Franky Laseure
 */
public class EMview_evetypes_default implements ViewMapper {
    
    public static final String SQLSelectAll = "select view_evetypes.* from view_evetypes";
	  
    /**
     * 
     * @return SQL select statement for all View_evetypess
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to View_evetypes
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_evetypes view_evetypes = new View_evetypes();
        if(dbresult!=null) {
            try {
                view_evetypes.setCategory(dbresult.getLong("category"));
                view_evetypes.setTypegroupid(dbresult.getLong("typegroupid"));
                view_evetypes.setTypegroupname(dbresult.getString("typegroupname"));
                view_evetypes.setId(dbresult.getLong("id"));
                view_evetypes.setName(dbresult.getString("name"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return view_evetypes;
    }

}

