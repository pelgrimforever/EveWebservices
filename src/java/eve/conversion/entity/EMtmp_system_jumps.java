/*
 * EMtmp_system_jumps.java
 *
 * Created on Okt 8, 2021
 * Generated on 9.9.2021 15:35
 *
 */
package eve.conversion.entity;

import data.interfaces.db.LogicEntity;
import eve.conversion.entity.def.EMtmp_system_jumps_default;
import eve.logicentity.Tmp_system_jumps;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMtmp_system_jumps
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMtmp_system_jumps extends EMtmp_system_jumps_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    public static final String SQLDeleteAll = "delete from tmp_system_jumps";
    public static final String SQLCopySystems4Security_island = 
        "insert into tmp_system_jumps (system) " +
        "select id from system where " + EMsystem.SQLWheresecurity_island;
    public static final String SQLResetJump = "update tmp_system_jumps set jump = null";
    public static final String SQLSelectnojump = "select count(*) as count from tmp_system_jumps where jump is null";
    public static final String SQLSetnextjump = 
        "update tmp_system_jumps set jump = :nextjump: " +
        "where system in (" +
        "select sg.to_system from stargate sg " +
        "where sg.system in (select sj.system from tmp_system_jumps sj where sj.jump = :jump:) " +
        "and sg.to_system in (select sj.system from tmp_system_jumps sj where sj.jump is null))";
    public static final String SQLSelect4jump = SQLSelect + " where jump = :jump:";

    /**
     * Map ResultSet Field values to Tmp_system_jumps
     * @param dbresult: Database ResultSet
     * @return 
     * @throws java.sql.SQLException
     */
    @Override
    public LogicEntity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Tmp_system_jumps tmp_system_jumps = (Tmp_system_jumps)super.mapResultSet2Entity(dbresult);
        return tmp_system_jumps;
    }    
    
}

