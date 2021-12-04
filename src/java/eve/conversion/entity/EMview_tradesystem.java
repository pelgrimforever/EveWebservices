/*
 * EMview_tradesystem.java
 *
 * Created on Okt 8, 2021
 * Generated on 2.11.2021 21:14
 *
 */
package eve.conversion.entity;

import data.interfaces.db.LogicEntity;
import eve.conversion.entity.def.EMview_tradesystem_default;
import eve.logicview.View_tradesystem;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMview_tradesystem
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMview_tradesystem extends EMview_tradesystem_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    public static final String SQLSelectAll4Startingsystem = "select starts.id AS startsystem_id, sj.jumps AS startsystem_jumps, view_tradesystem.* from view_tradesystem " + 
        "inner join systemjumps sj on view_tradesystem.sell_systemid = sj.system_end " +
        "inner join system starts on sj.system_start = starts.id " + 
        "where starts.id = :system.id:";
    public static final String SQLSelectAll4sellbuysystem = "select view_tradesystem.* from view_tradesystem " +
        "where sell_systemid = :sell_systemid: and buy_systemid = :buy_systemid:";

    /**
     * Map ResultSet Field values to View_tradesystem
     * @param dbresult: Database ResultSet
     * @return View_tradesystem
     * @throws java.sql.SQLException
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_tradesystem view_tradesystem = (View_tradesystem)super.mapResultSet2Entity(dbresult);
        try {
            view_tradesystem.setStart_system(dbresult.getLong("startsystem_id"));
            view_tradesystem.setStart_system_jumps(dbresult.getInt("startsystem_jumps"));
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        return view_tradesystem;
    }    
    
}

