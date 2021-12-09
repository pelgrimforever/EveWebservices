/*
 * EMsystemjumps.java
 *
 * Created on Okt 8, 2021
 * Generated on 9.9.2021 15:35
 *
 */
package eve.conversion.entity;

import data.interfaces.db.LogicEntity;
import eve.conversion.entity.def.EMsystemjumps_default;
import eve.logicentity.Systemjumps;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMsystemjumps
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMsystemjumps extends EMsystemjumps_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    public static final String SQLSelectAll = SQLSelect + OrderBy;
    
    public static final String SQLDeleteall = "truncate systemjumps";
    
    public static final String SQLset0jumpsto1 = "update systemjumps set jumps = 1 where jumps = 0";

    public static final String SQLcreatesystemjumpslowsec = "insert into systemjumps " +
        "select s1.id, s2.id, 0, 0, 0, 0, 0, 0 from "+
        "(select id from system where not noaccess and security_status > 0) as s1, " +
        "(select id from system where not noaccess and security_status > 0) as s2";
        
    /**
     * Map ResultSet Field values to Systemjumps
     * @param dbresult: Database ResultSet
     * @return 
     * @throws java.sql.SQLException
     */
    @Override
    public LogicEntity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Systemjumps systemjumps = (Systemjumps)super.mapResultSet2Entity(dbresult);
        return systemjumps;
    }    
    
}

