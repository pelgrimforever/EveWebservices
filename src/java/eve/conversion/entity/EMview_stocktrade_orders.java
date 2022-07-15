/*
 * Created on Okt 8, 2021
 * Generated on 9.9.2021 18:23
 */
package eve.conversion.entity;

import data.interfaces.db.View;
import eve.conversion.entity.def.EMview_stocktrade_orders_default;
import eve.logicview.View_stocktrade_orders;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Franky Laseure
 */
public class EMview_stocktrade_orders extends EMview_stocktrade_orders_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    public static final String SQLSelect4usernamesystem = SQLSelectAll + " where username = :username: and system = :system:";

    @Override
    public View mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_stocktrade_orders view_stocktrade_orders = (View_stocktrade_orders)super.mapResultSet2Entity(dbresult);
        return view_stocktrade_orders;
    }    
    
}

