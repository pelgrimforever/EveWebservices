/*
 * Created on Okt 8, 2021
 * Generated on 13.6.2022 11:21
 */
package eve.conversion.entity.def;

import data.interfaces.db.*;
import data.gis.shape.*;
import data.json.piJson;
import db.TableMapper;
import eve.eveDatabaseproperties;
import eve.entity.pk.*;
import eve.logicentity.Location;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class EMlocation_default implements eveDatabaseproperties, TableMapper {
    
    public static final String SQLWhere1 = "id = :location.id:";
    public static final String SQLSelect1 = "select location.* from location where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from location where " + SQLWhere1;
    public static final String SQLSelectAll = "select location.* from location";

    public static final String SQLSelect = "select location.* from location";
    public static final String SQLWheresystem = "system = :system.id:";

//Custom code, do not change this line
    public static final String OrderBy = " order by id";
//Custom code, do not change this line

    public static final String SQLSelect4system = "select * from location where " + SQLWheresystem + OrderBy;
    public static final String SQLDelete4system = "delete from location where " + SQLWheresystem;

    @Override
    public String getDbtool() { return databasetool; }
    
    @Override
    public String getConnectionpool() { return connectionpool; }
    
    @Override
    public String getTable() { return "location"; }

    /**
     * 
     * @return SQL where clause for one Location (=Primarykey)
     */
    @Override
    public String getSQLWhere1() { return SQLWhere1; };

    /**
     * 
     * @return SQL select statement for one Location (=Primarykey)
     */
    @Override
    public String getSQLSelect1() { return SQLSelect1; };

    @Override
    public String getSQLPKExcists() { return SQLSelectPKexists; };
    
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    @Override
    public Entity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        LocationPK locationPK = null;
        Location location;
        if(dbresult==null) {
            location = new Location(locationPK);
        } else {
            try {
                locationPK = new LocationPK(dbresult.getLong("id"));
                location = new Location(locationPK);
                location.initSystemPK(new SystemPK(dbresult.getLong("system")));
                if(dbresult.wasNull()) location.setSystemPK(null);                
                location.initName(dbresult.getString("name"));
                location.initVisited(dbresult.getBoolean("visited"));
                location.initAccess(dbresult.getBoolean("access"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return location;
    }

}

