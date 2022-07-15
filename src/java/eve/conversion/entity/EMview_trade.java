/*
 * Created on Okt 8, 2021
 * Generated on 9.9.2021 18:23
 */
package eve.conversion.entity;

import data.interfaces.db.View;
import eve.conversion.entity.def.EMview_trade_default;
import eve.logicview.View_trade;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Franky Laseure
 */
public class EMview_trade extends EMview_trade_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    public static final String SQLSelectAll4Startingsystem = "select starts.id AS startsystem_id, sj.jumps AS startsystem_jumps, view_trade.* from view_trade " + 
        "inner join systemjumps sj on view_trade.sell_systemid = sj.system_end " +
        "inner join system starts on sj.system_start = starts.id " + 
        "where starts.id = :system.id:";
    
    public static final String SQLSelectAll4Startendsystem = "select view_trade.* from view_trade " + 
        "where view_trade.sell_systemid = :startsystemid: and view_trade.buy_systemid = :endsystemid:";
    
    @Override
    public View mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_trade view_trade = (View_trade)super.mapResultSet2Entity(dbresult);
        try {
            view_trade.setStart_system(dbresult.getLong("startsystem_id"));
            view_trade.setStart_system_jumps(dbresult.getInt("startsystem_jumps"));
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        return view_trade;
    }    
    
}

