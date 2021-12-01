/*
 * EMview_systemtrade.java
 *
 * Created on Okt 8, 2021
 * Generated on 9.9.2021 18:23
 *
 */
package eve.conversion.entity;

import data.interfaces.db.LogicEntity;
import eve.conversion.entity.def.EMview_systemtrade_default;
import eve.logicview.View_systemtrade;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMview_systemtrade
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMview_systemtrade extends EMview_systemtrade_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    public static final String SQLSelectAll4Startingsystem = "select starts.id AS startsystem_id, sj.jumps AS startsystem_jumps, view_systemtrade.* from view_systemtrade " + 
        "inner join systemjumps sj on view_systemtrade.sell_system = sj.system_end " +
        "inner join system starts on sj.system_start = starts.id " + 
        "where starts.id = :system.id:";
    
    /**
     * Map ResultSet Field values to View_systemtrade
     * @param dbresult: Database ResultSet
     * @return 
     * @throws java.sql.SQLException
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_systemtrade view_systemtrade = (View_systemtrade)super.mapResultSet2Entity(dbresult);
        try {
            view_systemtrade.setStart_system(dbresult.getLong("startsystem_id"));
            view_systemtrade.setStart_system_jumps(dbresult.getInt("startsystem_jumps"));
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        return view_systemtrade;
    }    
    
}

