/*
 * Created on Okt 8, 2021
 * Generated on 13.6.2022 11:21
 */
package eve.conversion.entity.def;

import data.gis.shape.*;
import data.interfaces.db.*;
import data.json.piJson;
import db.ViewMapper;
import eve.eveDatabaseproperties;
import eve.logicview.View_evetypes;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class EMview_evetypes_default implements eveDatabaseproperties, ViewMapper {
    
    public static final String SQLSelectAll = "select view_evetypes.* from view_evetypes";
	  
    @Override
    public String getDbtool() { return databasetool; }
    
    @Override
    public String getConnectionpool() { return connectionpool; }
    
    @Override
    public String getTable() { return "view_evetypes"; }

    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    @Override
    public View mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_evetypes view_evetypes = new View_evetypes();
        if(dbresult!=null) {
            try {
                view_evetypes.setCategory(dbresult.getLong("category"));
                view_evetypes.setTypegroupid(dbresult.getLong("typegroupid"));
                view_evetypes.setTypegroupname(dbresult.getString("typegroupname"));
                view_evetypes.setId(dbresult.getLong("id"));
                view_evetypes.setName(dbresult.getString("name"));
                view_evetypes.setConfiguredbp(dbresult.getBoolean("configuredbp"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return view_evetypes;
    }

}

