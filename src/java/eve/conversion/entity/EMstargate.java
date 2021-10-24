/*
 * EMstargate.java
 *
 * Created on Okt 8, 2021
 * Generated on 9.9.2021 15:35
 *
 */
package eve.conversion.entity;

import data.interfaces.db.LogicEntity;
import eve.conversion.entity.def.EMstargate_default;
import eve.logicentity.Stargate;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMstargate
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMstargate extends EMstargate_default {
//ProjectGenerator: NO AUTHOMATIC UPDATE
    
    public static final String SQLSelectAll = SQLSelect + OrderBy;

    public static final String SQLSelect4systemCount = "select count(*) as count from stargate where " + SQLWheresystemSystem;
    
    public static final String SQLupdateconstellationborders = "update stargate set isconstellationborder = :isborder: from stargate sg " +
        "inner join system on system.id = sg.system " +
        "inner join system systemto on systemto.id = sg.to_system " +
        "inner join constellation on constellation.id = system.constellation " +
        "inner join constellation constellationto on constellationto.id = systemto.constellation " +
        "where constellation.id <> constellationto.id";
    public static final String SQLupdateregionborders = "update stargate set isregionborder = :isborder: from stargate sg " +
        "inner join system on system.id = sg.system " +
        "inner join system systemto on systemto.id = sg.to_system " +
        "inner join constellation on constellation.id = system.constellation " +
        "inner join constellation constellationto on constellationto.id = systemto.constellation " +
        "where constellation.region <> constellationto.region";
    
    //select only 1 stargate prevous to the given system id in the tmp_system_jumps configuration
    public static final String SQLselectpreviousTMP = "select sg.* from tmp_system_jumps tmp " +
        "inner join stargate sg on sg.to_system = tmp.system " +
        "inner join tmp_system_jumps tmp2 on tmp2.system = sg.system and tmp2.jump+1 = tmp.jump " +
        "where tmp.system = :system.id: " +
        "limit 1";

    /**
     * Map ResultSet Field values to Stargate
     * @param dbresult: Database ResultSet
     * @return 
     * @throws java.sql.SQLException
     */
    @Override
    public LogicEntity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Stargate stargate = (Stargate)super.mapResultSet2Entity(dbresult);
        return stargate;
    }    
    
}

