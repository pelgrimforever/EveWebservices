/*
 * EMalliance_default.java
 *
 * Created on Okt 8, 2021
 * Generated on 30.10.2021 10:3
 *
 */
package eve.conversion.entity.def;

import data.gis.shape.*;
import data.interfaces.db.View;
import data.json.piJson;
import db.ViewMapper;
import eve.logicview.View_security_island_systemcount;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMview_security_island_systemcount_default
 * Maps SQL ResultSet to eve.logicentity objects
 * @author Franky Laseure
 */
public class EMview_security_island_systemcount_default implements ViewMapper {
    
    public static final String SQLSelectAll = "select view_security_island_systemcount.* from view_security_island_systemcount";
	  
    /**
     * 
     * @return SQL select statement for all View_security_island_systemcounts
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to View_security_island_systemcount
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
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

