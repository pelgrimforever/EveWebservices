/*
 * EMalliance_default.java
 *
 * Created on Okt 8, 2021
 * Generated on 8.10.2021 7:21
 *
 */
package eve.conversion.entity.def;

import data.gis.shape.*;
import data.interfaces.db.LogicEntity;
import data.json.piJson;
import db.TableMapper;
import eve.entity.pk.*;
import eve.logicentity.Usersettings;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMusersettings_default
 * Maps SQL ResultSet to eve.logicentity objects
 * @author Franky Laseure
 */
public class EMusersettings_default implements TableMapper {
    
    public static final String SQLWhere1 = "username = :usersettings.username: and name = :usersettings.name:";
    public static final String SQLSelect1 = "select usersettings.* from usersettings where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from usersettings where " + SQLWhere1;
    public static final String SQLSelectAll = "select usersettings.* from usersettings";

    public static final String SQLSelect = "select usersettings.* from usersettings";
    public static final String SQLWheresettings = "name = :settings.name:";

//Custom code, do not change this line
    public static final String OrderBy = " order by username, name";
//Custom code, do not change this line

    public static final String SQLSelect4settings = "select * from usersettings where " + SQLWheresettings + OrderBy;
    public static final String SQLDelete4settings = "delete from usersettings where " + SQLWheresettings;

    /**
     * 
     * @return SQL where clause for one Usersettings (=Primarykey)
     */
    @Override
    public String getSQLWhere1() { return SQLWhere1; };

    /**
     * 
     * @return SQL select statement for one Usersettings (=Primarykey)
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
     * @return SQL select statement for all Usersettingss
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to Usersettings
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        UsersettingsPK usersettingsPK = null;
        Usersettings usersettings;
        if(dbresult==null) {
            usersettings = new Usersettings(usersettingsPK);
        } else {
            try {
                usersettingsPK = new UsersettingsPK(dbresult.getString("username"), dbresult.getString("name"));
                usersettings = new Usersettings(usersettingsPK);
                usersettings.initValue(dbresult.getDouble("value"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return usersettings;
    }

}

