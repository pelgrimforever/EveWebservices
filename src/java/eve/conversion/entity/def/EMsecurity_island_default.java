/*
 * EMalliance_default.java
 *
 * Created on Okt 8, 2021
 * Generated on 25.9.2021 15:16
 *
 */
package eve.conversion.entity.def;

import data.gis.shape.*;
import data.interfaces.db.LogicEntity;
import data.json.piJson;
import db.TableMapper;
import eve.entity.pk.*;
import eve.logicentity.Security_island;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMsecurity_island_default
 * Maps SQL ResultSet to eve.logicentity objects
 * @author Franky Laseure
 */
public class EMsecurity_island_default implements TableMapper {
    
    public static final String SQLWhere1 = "id = :security_island.id:";
    public static final String SQLSelect1 = "select security_island.* from security_island where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from security_island where " + SQLWhere1;
    public static final String SQLSelectAll = "select security_island.* from security_island";

    public static final String SQLSelect = "select security_island.* from security_island";

//Custom code, do not change this line
    public static final String OrderBy = " order by id";
//Custom code, do not change this line


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

    /**
     * @return Select statement for Primary key, with count field as result
     * count = 1: exists
     * count = 0: not found
     */
    @Override
    public String getSQLPKExcists() { return SQLSelectPKexists; };
    
    /**
     * 
     * @return SQL select statement for all Security_islands
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to Security_island
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
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

