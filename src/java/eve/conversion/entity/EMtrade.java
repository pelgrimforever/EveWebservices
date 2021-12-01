/*
 * EMtrade.java
 *
 * Created on Okt 8, 2021
 * Generated on 9.9.2021 15:35
 *
 */
package eve.conversion.entity;

import data.interfaces.db.LogicEntity;
import eve.conversion.entity.def.EMtrade_default;
import eve.logicentity.Trade;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMtrade
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMtrade extends EMtrade_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    public static final String SQLSelectAll = SQLSelect + OrderBy;
    public static final String SQLSellBuyOrders = SQLSelect + " where sell_order_id = :trade.sell_order_id: or buy_order_id = :trade.buy_order_id:";
    public static final String SQLdeleteall = "delete from trade";

    /**
     * Map ResultSet Field values to Trade
     * @param dbresult: Database ResultSet
     * @return 
     * @throws java.sql.SQLException
     */
    @Override
    public LogicEntity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Trade trade = (Trade)super.mapResultSet2Entity(dbresult);
        return trade;
    }    
    
}

