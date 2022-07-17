/*
 * Created on Okt 8, 2021
 * Generated on 17.6.2022 13:4
 */
package eve.conversion.entity.def;

import data.interfaces.db.*;
import data.gis.shape.*;
import data.json.piJson;
import db.TableMapper;
import eve.eveDatabaseproperties;
import eve.entity.pk.*;
import eve.logicentity.Security_island;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class EMsecurity_island_default implements eveDatabaseproperties, TableMapper {
    
    public static final String SQLWhere1 = "id = :security_island.id:";
    public static final String SQLSelect1 = "select security_island.* from security_island where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from security_island where " + SQLWhere1;
    public static final String SQLSelectAll = "select security_island.* from security_island";

    public static final String SQLSelect = "select security_island.* from security_island";

//Custom code, do not change this line
    public static final String OrderBy = " order by id";
//Custom code, do not change this line


    @Override
    public String getDbtool() { return databasetool; }
    
    @Override
    public String getConnectionpool() { return connectionpool; }
    
    @Override
    public String getTable() { return "security_island"; }

    /**
     * 
     * @return SQL where clause for one Security_island (=Primarykey)
     */
    @Override
    public String getSQLWhere1() { return SQLWhere1; };

    /**
     * 
     * @return SQL select statement for one Security_island (=Primarykey)
     */
    @Override
    public String getSQLSelect1() { return SQLSelect1; };

    @Override
    public String getSQLPKExcists() { return SQLSelectPKexists; };
    
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    @Override
    public Entity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Security_islandPK security_islandPK = null;
        Security_island security_island;
        if(dbresult==null) {
            security_island = new Security_island(security_islandPK);
        } else {
            try {
                security_islandPK = new Security_islandPK(dbresult.getLong("id"));
                security_island = new Security_island(security_islandPK);
                security_island.initName(dbresult.getString("name"));
                security_island.initSecurity_status(dbresult.getDouble("security_status"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return security_island;
    }

}

