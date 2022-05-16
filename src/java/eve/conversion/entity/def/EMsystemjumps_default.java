/*
 * EMalliance_default.java
 *
 * Created on Okt 8, 2021
 * Generated on 13.4.2022 19:13
 *
 */
package eve.conversion.entity.def;

import data.gis.shape.*;
import data.interfaces.db.LogicEntity;
import data.json.piJson;
import db.TableMapper;
import eve.entity.pk.*;
import eve.logicentity.Systemjumps;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMsystemjumps_default
 * Maps SQL ResultSet to eve.logicentity objects
 * @author Franky Laseure
 */
public class EMsystemjumps_default implements TableMapper {
    
    public static final String SQLWhere1 = "system_start = :systemjumps.system_start: and system_end = :systemjumps.system_end:";
    public static final String SQLSelect1 = "select systemjumps.* from systemjumps where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from systemjumps where " + SQLWhere1;
    public static final String SQLSelectAll = "select systemjumps.* from systemjumps";

    public static final String SQLSelect = "select systemjumps.* from systemjumps";
    public static final String SQLWheresystemSystem_end = "system_end = :system.id:";
    public static final String SQLWheresystemSystem_start = "system_start = :system.id:";

//Custom code, do not change this line
    public static final String OrderBy = " order by system_start, system_end";
//Custom code, do not change this line

    public static final String SQLSelect4systemSystem_end = "select * from systemjumps where " + SQLWheresystemSystem_end + OrderBy;
    public static final String SQLDelete4systemSystem_end = "delete from systemjumps where " + SQLWheresystemSystem_end;
    public static final String SQLSelect4systemSystem_start = "select * from systemjumps where " + SQLWheresystemSystem_start + OrderBy;
    public static final String SQLDelete4systemSystem_start = "delete from systemjumps where " + SQLWheresystemSystem_start;

    /**
     * 
     * @return SQL where clause for one Systemjumps (=Primarykey)
     */
    @Override
    public String getSQLWhere1() { return SQLWhere1; };

    /**
     * 
     * @return SQL select statement for one Systemjumps (=Primarykey)
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
     * @return SQL select statement for all Systemjumpss
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to Systemjumps
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        SystemjumpsPK systemjumpsPK = null;
        Systemjumps systemjumps;
        if(dbresult==null) {
            systemjumps = new Systemjumps(systemjumpsPK);
        } else {
            try {
                systemjumpsPK = new SystemjumpsPK(dbresult.getLong("system_start"), dbresult.getLong("system_end"));
                systemjumps = new Systemjumps(systemjumpsPK);
                systemjumps.initJumps(dbresult.getInt("jumps"));
                systemjumps.initJumpslowsec(dbresult.getInt("jumpslowsec"));
                systemjumps.initJumpsnullsec(dbresult.getInt("jumpsnullsec"));
                systemjumps.initJumpssafe(dbresult.getInt("jumpssafe"));
                systemjumps.initJumpssafelowsec(dbresult.getInt("jumpssafelowsec"));
                systemjumps.initJumpssafenullsec(dbresult.getInt("jumpssafenullsec"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return systemjumps;
    }

}

