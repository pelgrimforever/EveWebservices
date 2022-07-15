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
import eve.logicentity.Stargate;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class EMstargate_default implements eveDatabaseproperties, TableMapper {
    
    public static final String SQLWhere1 = "id = :stargate.id:";
    public static final String SQLSelect1 = "select stargate.* from stargate where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from stargate where " + SQLWhere1;
    public static final String SQLSelectAll = "select stargate.* from stargate";

    public static final String SQLSelect = "select stargate.* from stargate";
    public static final String SQLWheresystemSystem = "system = :system.id:";
    public static final String SQLWheresystemTo_system = "to_system = :system.id:";

//Custom code, do not change this line
    public static final String OrderBy = " order by id";
//Custom code, do not change this line

    public static final String SQLSelect4systemSystem = "select * from stargate where " + SQLWheresystemSystem + OrderBy;
    public static final String SQLDelete4systemSystem = "delete from stargate where " + SQLWheresystemSystem;
    public static final String SQLSelect4systemTo_system = "select * from stargate where " + SQLWheresystemTo_system + OrderBy;
    public static final String SQLDelete4systemTo_system = "delete from stargate where " + SQLWheresystemTo_system;

    @Override
    public String getDbtool() { return databasetool; }
    
    @Override
    public String getConnectionpool() { return connectionpool; }
    
    @Override
    public String getTable() { return "stargate"; }

    /**
     * 
     * @return SQL where clause for one Stargate (=Primarykey)
     */
    @Override
    public String getSQLWhere1() { return SQLWhere1; };

    /**
     * 
     * @return SQL select statement for one Stargate (=Primarykey)
     */
    @Override
    public String getSQLSelect1() { return SQLSelect1; };

    @Override
    public String getSQLPKExcists() { return SQLSelectPKexists; };
    
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    @Override
    public Entity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        StargatePK stargatePK = null;
        Stargate stargate;
        if(dbresult==null) {
            stargate = new Stargate(stargatePK);
        } else {
            try {
                stargatePK = new StargatePK(dbresult.getLong("id"));
                stargate = new Stargate(stargatePK);
                stargate.initSystemsystemPK(new SystemPK(dbresult.getLong("system")));
                if(dbresult.wasNull()) stargate.setSystemsystemPK(null);                
                stargate.initSystemto_systemPK(new SystemPK(dbresult.getLong("to_system")));
                if(dbresult.wasNull()) stargate.setSystemto_systemPK(null);                
                stargate.initTo_stargate(dbresult.getLong("to_stargate"));
                stargate.initName(dbresult.getString("name"));
                stargate.initX(dbresult.getDouble("x"));
                stargate.initY(dbresult.getDouble("y"));
                stargate.initZ(dbresult.getDouble("z"));
                stargate.initIsconstellationborder(dbresult.getBoolean("isconstellationborder"));
                stargate.initIsregionborder(dbresult.getBoolean("isregionborder"));
                stargate.initDownloaddate(dbresult.getDate("downloaddate"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return stargate;
    }

}

