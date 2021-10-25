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
import eve.logicentity.Location;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMlocation_default
 * Maps SQL ResultSet to eve.logicentity objects
 * @author Franky Laseure
 */
public class EMlocation_default implements TableMapper {
    
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

    /**
     * @return Select statement for Primary key, with count field as result
     * count = 1: exists
     * count = 0: not found
     */
    @Override
    public String getSQLPKExcists() { return SQLSelectPKexists; };
    
    /**
     * 
     * @return SQL select statement for all Locations
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to Location
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
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

