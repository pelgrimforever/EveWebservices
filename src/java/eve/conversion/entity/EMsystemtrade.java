/*
 * EMsystemtrade.java
 *
 * Created on Okt 8, 2021
 * Generated on 9.9.2021 15:35
 *
 */
package eve.conversion.entity;

import data.interfaces.db.LogicEntity;
import eve.conversion.entity.def.EMsystemtrade_default;
import eve.logicentity.Systemtrade;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMsystemtrade
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMsystemtrade extends EMsystemtrade_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    public static final String SQLSelectAll = SQLSelect + OrderBy;
    public static final String SQLdeleteall = "delete from systemtrade";
    public static final String SQLSelectSystemtrade = "select sell_system, buy_system, sum(buy_totalprice * :net_perc: - sell_totalprice) as profit, " +
        "sum(cargo_volume) as total_cargo_volume, max(jumps) as jumps from view_systemtradeorders " +
        "where packaged_volume <= :max_cargovolume: and security_island = :security_island.id: and " +
        "buy_totalprice * :net_perc: > sell_totalprice " +
        "group by sell_system, buy_system " +
        "having sum(buy_totalprice * :net_perc: - sell_totalprice) > :min_profit: " +
        "order by sell_system";
    public static final String SQLInsertSystemtrade = "insert into systemtrade " +
        SQLSelectSystemtrade;

    /**
     * Map ResultSet Field values to Systemtrade
     * @param dbresult: Database ResultSet
     * @return 
     * @throws java.sql.SQLException
     */
    @Override
    public LogicEntity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Systemtrade systemtrade = (Systemtrade)super.mapResultSet2Entity(dbresult);
        return systemtrade;
    }    
    
}

