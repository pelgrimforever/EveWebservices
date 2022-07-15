/*
 * EMalliance_default.java
 *
 * Created on Okt 8, 2021
 * Generated on 5.3.2022 17:21
 *
 */
package eve.conversion.entity.def;

import data.gis.shape.*;
import data.interfaces.db.LogicEntity;
import data.json.piJson;
import db.TableMapper;
import eve.entity.pk.*;
import static eve.eveDatabaseproperties.connectionpool;
import static eve.eveDatabaseproperties.databasetool;
import eve.logicentity.Systemactivity;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMsystemactivity_default
 * Maps SQL ResultSet to eve.logicentity objects
 * @author Franky Laseure
 */
public class EMsystemactivity_default implements TableMapper {
    
    public static final String SQLWhere1 = "systemid = :systemactivity.systemid: and timeslot = :systemactivity.timeslot:";
    public static final String SQLSelect1 = "select systemactivity.* from systemactivity where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from systemactivity where " + SQLWhere1;
    public static final String SQLSelectAll = "select systemactivity.* from systemactivity";

    public static final String SQLSelect = "select systemactivity.* from systemactivity";
    public static final String SQLWheresystem = "systemid = :system.id:";

//Custom code, do not change this line
    public static final String OrderBy = " order by systemid, timeslot";
//Custom code, do not change this line

    public static final String SQLSelect4system = "select * from systemactivity where " + SQLWheresystem + OrderBy;
    public static final String SQLDelete4system = "delete from systemactivity where " + SQLWheresystem;

    @Override
    public String getDbtool() { return databasetool; }
    
    @Override
    public String getConnectionpool() { return connectionpool; }
    
    @Override
    public String getTable() { return "systemactivity"; }

    /**
     * 
     * @return SQL where clause for one Systemactivity (=Primarykey)
     */
    @Override
    public String getSQLWhere1() { return SQLWhere1; };

    /**
     * 
     * @return SQL select statement for one Systemactivity (=Primarykey)
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
     * @return SQL select statement for all Systemactivitys
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to Systemactivity
     * @param dbresult: Database ResultSet
     */
    @Override
    public LogicEntity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        SystemactivityPK systemactivityPK = null;
        Systemactivity systemactivity;
        if(dbresult==null) {
            systemactivity = new Systemactivity(systemactivityPK);
        } else {
            try {
                systemactivityPK = new SystemactivityPK(dbresult.getLong("systemid"), dbresult.getTimestamp("timeslot"));
                systemactivity = new Systemactivity(systemactivityPK);
                systemactivity.initShip_jumps(dbresult.getLong("ship_jumps"));
                systemactivity.initNpc_kills(dbresult.getLong("npc_kills"));
                systemactivity.initShip_kills(dbresult.getLong("ship_kills"));
                systemactivity.initPod_kills(dbresult.getLong("pod_kills"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return systemactivity;
    }

}

