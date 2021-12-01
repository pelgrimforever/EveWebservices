/*
 * EMview_combinedtrade.java
 *
 * Created on Okt 8, 2021
 * Generated on 9.9.2021 18:23
 *
 */
package eve.conversion.entity;

import data.interfaces.db.LogicEntity;
import eve.conversion.entity.def.EMview_combinedtrade_default;
import eve.logicview.View_combinedtrade;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMview_combinedtrade
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMview_combinedtrade extends EMview_combinedtrade_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    public static final String SQLSelectAll4Startingsystem = "select starts.id AS startsystem_id, sj.jumps AS startsystem_jumps, view_combinedtrade.* from view_combinedtrade " + 
        "inner join systemjumps sj on view_combinedtrade.sell_systemid = sj.system_end " +
        "inner join system starts on sj.system_start = starts.id " + 
        "where starts.id = :system.id:";
    
    public static final String SQLSelect4Startendsystem = "select starts.id AS startsystem_id, sj.jumps AS startsystem_jumps, view_combinedtrade.* from view_combinedtrade " + 
        "inner join systemjumps sj on view_combinedtrade.sell_systemid = sj.system_end " +
        "inner join system starts on sj.system_start = starts.id " + 
        "where starts.id = :system.id: and view_combinedtrade.sell_systemid = :startsystemid: and view_combinedtrade.buy_systemid = :endsystemid:";
    
    /**
     * Map ResultSet Field values to View_combinedtrade
     * @param dbresult: Database ResultSet
     * @return 
     * @throws java.sql.SQLException
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_combinedtrade view_combinedtrade = (View_combinedtrade)super.mapResultSet2Entity(dbresult);
        try {
            view_combinedtrade.setStart_system(dbresult.getLong("startsystem_id"));
            view_combinedtrade.setStart_system_jumps(dbresult.getInt("startsystem_jumps"));
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        return view_combinedtrade;
    }    
    
}

