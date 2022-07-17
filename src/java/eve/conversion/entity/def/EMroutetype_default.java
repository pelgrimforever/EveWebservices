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
import eve.logicentity.Routetype;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class EMroutetype_default implements eveDatabaseproperties, TableMapper {
    
    public static final String SQLWhere1 = "id = :routetype.id:";
    public static final String SQLSelect1 = "select routetype.* from routetype where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from routetype where " + SQLWhere1;
    public static final String SQLSelectAll = "select routetype.* from routetype";

    public static final String SQLSelect = "select routetype.* from routetype";
    public static final String SQLWheresecurity_island = "security_island = :security_island.id:";

//Custom code, do not change this line
    public static final String OrderBy = " order by id";
//Custom code, do not change this line

    public static final String SQLSelect4security_island = "select * from routetype where " + SQLWheresecurity_island + OrderBy;
    public static final String SQLDelete4security_island = "delete from routetype where " + SQLWheresecurity_island;

    @Override
    public String getDbtool() { return databasetool; }
    
    @Override
    public String getConnectionpool() { return connectionpool; }
    
    @Override
    public String getTable() { return "routetype"; }

    /**
     * 
     * @return SQL where clause for one Routetype (=Primarykey)
     */
    @Override
    public String getSQLWhere1() { return SQLWhere1; };

    /**
     * 
     * @return SQL select statement for one Routetype (=Primarykey)
     */
    @Override
    public String getSQLSelect1() { return SQLSelect1; };

    @Override
    public String getSQLPKExcists() { return SQLSelectPKexists; };
    
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    @Override
    public Entity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        RoutetypePK routetypePK = null;
        Routetype routetype;
        if(dbresult==null) {
            routetype = new Routetype(routetypePK);
        } else {
            try {
                routetypePK = new RoutetypePK(dbresult.getLong("id"));
                routetype = new Routetype(routetypePK);
                routetype.initSecurity_islandPK(new Security_islandPK(dbresult.getLong("security_island")));
                if(dbresult.wasNull()) routetype.setSecurity_islandPK(null);                
                routetype.initName(dbresult.getString("name"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return routetype;
    }

}

