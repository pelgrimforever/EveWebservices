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
import eve.logicview.View_security_island_systemcount;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class EMview_security_island_systemcount_default implements eveDatabaseproperties, ViewMapper {
    
    public static final String SQLSelectAll = "select view_security_island_systemcount.* from view_security_island_systemcount";
	  
    @Override
    public String getDbtool() { return databasetool; }
    
    @Override
    public String getConnectionpool() { return connectionpool; }
    
    @Override
    public String getTable() { return "view_security_island_systemcount"; }

    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    @Override
    public View mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_security_island_systemcount view_security_island_systemcount = new View_security_island_systemcount();
        if(dbresult!=null) {
            try {
                view_security_island_systemcount.setId(dbresult.getLong("id"));
                view_security_island_systemcount.setName(dbresult.getString("name"));
                view_security_island_systemcount.setSystems(dbresult.getLong("systems"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return view_security_island_systemcount;
    }

}

