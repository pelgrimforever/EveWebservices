/*
 * Created on Okt 8, 2021
 * Generated on 9.9.2021 15:35
 */
package eve.conversion.entity;

import data.interfaces.db.LogicEntity;
import eve.conversion.entity.def.EMsystem_default;
import eve.logicentity.System;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Franky Laseure
 */
public class EMsystem extends EMsystem_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    public static final String WhereAccess = "not noaccess";
    public static final String SQLSelectAll = SQLSelect + " where " + WhereAccess + OrderBy;
    public static final String SQLSelectHiLowSec = SQLSelect + " where security_status>0 and not noaccess";
    
    public static final String SQLupdateconstellationborders = "update system set isconstellationborder = :isborder: where id in (select system from stargate where isconstellationborder group by system)";
    public static final String SQLupdateregionborders = "update system set isregionborder = :isborder: where id in (select system from stargate where isregionborder group by system)";

    public static final String updateNoaccess1 = "update system set noaccess = :noaccess: where id not in (select system from stargate)";
    public static final String updateNoaccess2 = "update system set noaccess = :noaccess: where id in (select system from stargate)";

    public static final String SQLRemoveSecurityIslands = "update system set security_island = null";
    public static final String SQLSelectHiSecNoIsland = "select s.* from system s where not noaccess and security_status >= :highsec: and security_island is null order by id";
    public static final String SQLSelectHiSecSystemsConnected = "select s_to.* from stargate sg " +
        "inner join system on sg.system = system.id " +
        "inner join system s_to on sg.to_system = s_to.id " +
        "where system.security_island = :security_island.id: " +
        "and s_to.security_island is null and s_to.security_status >= :highsec:";

    public static final String SQLSelect4shipfitorderselected = "select * from system where id in " +
        "(select orders.system from orders inner join shipfitorderselected on orders.id = shipfitorderselected.orderid and shipfitorderselected.username = :username:) " +
        "group by id, name, constellation, security_class, security_status, star_id, noaccess, isconstellationborder, isregionborder, security_island, downloaddate";
    
    @Override
    public LogicEntity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        System system = (System)super.mapResultSet2Entity(dbresult);
        return system;
    }    
    
}

