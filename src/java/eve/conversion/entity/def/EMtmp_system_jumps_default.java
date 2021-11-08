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
import eve.logicentity.Tmp_system_jumps;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMtmp_system_jumps_default
 * Maps SQL ResultSet to eve.logicentity objects
 * @author Franky Laseure
 */
public class EMtmp_system_jumps_default implements TableMapper {
    
    public static final String SQLWhere1 = "system = :tmp_system_jumps.system:";
    public static final String SQLSelect1 = "select tmp_system_jumps.* from tmp_system_jumps where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from tmp_system_jumps where " + SQLWhere1;
    public static final String SQLSelectAll = "select tmp_system_jumps.* from tmp_system_jumps";

    public static final String SQLSelect = "select tmp_system_jumps.* from tmp_system_jumps";

//Custom code, do not change this line
    public static final String OrderBy = " order by system";
//Custom code, do not change this line


    /**
     * 
     * @return SQL where clause for one Tmp_system_jumps (=Primarykey)
     */
    @Override
    public String getSQLWhere1() { return SQLWhere1; };

    /**
     * 
     * @return SQL select statement for one Tmp_system_jumps (=Primarykey)
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
     * @return SQL select statement for all Tmp_system_jumpss
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to Tmp_system_jumps
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Tmp_system_jumpsPK tmp_system_jumpsPK = null;
        Tmp_system_jumps tmp_system_jumps;
        if(dbresult==null) {
            tmp_system_jumps = new Tmp_system_jumps(tmp_system_jumpsPK);
        } else {
            try {
                tmp_system_jumpsPK = new Tmp_system_jumpsPK(dbresult.getLong("system"));
                tmp_system_jumps = new Tmp_system_jumps(tmp_system_jumpsPK);
                tmp_system_jumps.initJump(dbresult.getInt("jump"));
                tmp_system_jumps.initMaxjumps(dbresult.getInt("maxjumps"));
                tmp_system_jumps.initPrevioussystem(dbresult.getLong("previoussystem"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return tmp_system_jumps;
    }

}

