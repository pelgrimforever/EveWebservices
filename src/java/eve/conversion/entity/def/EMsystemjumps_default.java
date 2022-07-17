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
import eve.logicentity.Systemjumps;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class EMsystemjumps_default implements eveDatabaseproperties, TableMapper {
    
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

    @Override
    public String getDbtool() { return databasetool; }
    
    @Override
    public String getConnectionpool() { return connectionpool; }
    
    @Override
    public String getTable() { return "systemjumps"; }

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

    @Override
    public String getSQLPKExcists() { return SQLSelectPKexists; };
    
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    @Override
    public Entity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
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

