/*
 * Created on Okt 8, 2021
 * Generated on 9.9.2021 18:23
 */
package eve.conversion.entity;

import data.interfaces.db.View;
import eve.conversion.entity.def.EMview_stocktrade_system_default;
import eve.logicview.View_stocktrade_system;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Franky Laseure
 */
public class EMview_stocktrade_system extends EMview_stocktrade_system_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    public static final String SQLSelect4username = SQLSelectAll + " where username = :username: order by sellprice";
    public static final String SQLSelect4usernamestartsystem = "select starts.id AS startsystem_id, sj.jumps AS startsystem_jumps, view_stocktrade_system.* from view_stocktrade_system " +
        "inner join systemjumps sj on view_stocktrade_system.id = sj.system_end " +
        "inner join system starts on sj.system_start = starts.id " + 
        "where starts.id = :stocksystemid: " +
        "and view_stocktrade_system.username = :username: order by view_stocktrade_system.sellprice desc";

    @Override
    public View mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_stocktrade_system view_stocktrade_system = (View_stocktrade_system)super.mapResultSet2Entity(dbresult);
        try {
            view_stocktrade_system.setStart_system(dbresult.getLong("startsystem_id"));
            view_stocktrade_system.setStart_system_jumps(dbresult.getInt("startsystem_jumps"));
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        return view_stocktrade_system;
    }    
    
}

