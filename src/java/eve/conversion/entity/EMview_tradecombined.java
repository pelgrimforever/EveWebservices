/*
 * EMview_tradecombined.java
 *
 * Created on Okt 8, 2021
 * Generated on 23.10.2021 18:1
 *
 */
package eve.conversion.entity;

import data.interfaces.db.LogicEntity;
import eve.conversion.entity.def.EMview_tradecombined_default;
import eve.logicview.View_tradecombined;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMview_tradecombined
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMview_tradecombined extends EMview_tradecombined_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    public static final String SQLSelectAll4Startingsystem = "select starts.id AS startsystem_id, sj.jumps AS startsystem_jumps, view_tradecombined.* from view_tradecombined " + 
        "inner join systemjumps sj on view_tradecombined.sell_systemid = sj.system_end " +
        "inner join system starts on sj.system_start = starts.id " + 
        "where starts.id = :system.id:";
    public static final String SQLSelectAll4Tradecombined = "select view_tradecombined.* from view_tradecombined " +
        "where sell_systemid = :tradecombined.sell_system: and buy_systemid = :tradecombined.buy_system: and evetype_id = :tradecombined.evetype:";
    
    /**
     * Map ResultSet Field values to View_tradecombined
     * @param dbresult: Database ResultSet
     * @return View_tradecombined
     * @throws java.sql.SQLException
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_tradecombined view_tradecombined = (View_tradecombined)super.mapResultSet2Entity(dbresult);
        try {
            view_tradecombined.setStart_system(dbresult.getLong("startsystem_id"));
            view_tradecombined.setStart_system_jumps(dbresult.getInt("startsystem_jumps"));
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        return view_tradecombined;
    }    
    
}

