/*
 * EMview_systemtrade_order.java
 *
 * Created on Okt 8, 2021
 * Generated on 9.9.2021 18:23
 *
 */
package eve.conversion.entity;

import data.interfaces.db.LogicEntity;
import eve.conversion.entity.def.EMview_systemtrade_order_default;
import eve.logicview.View_systemtrade_order;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMview_systemtrade_order
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMview_systemtrade_order extends EMview_systemtrade_order_default {
//ProjectGenerator: NO AUTHOMATIC UPDATE
    
    public final static String SQLSelectAll4systemtrade = "select * from view_systemtrade_order " +
        "where sell_system = :systemtrade.sell_system: and buy_system = :systemtrade.buy_system:";

    /**
     * Map ResultSet Field values to View_systemtrade_order
     * @param dbresult: Database ResultSet
     * @return 
     * @throws java.sql.SQLException
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_systemtrade_order view_systemtrade_order = (View_systemtrade_order)super.mapResultSet2Entity(dbresult);
        return view_systemtrade_order;
    }    
    
}

