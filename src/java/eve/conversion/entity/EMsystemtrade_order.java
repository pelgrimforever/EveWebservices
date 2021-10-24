/*
 * EMsystemtrade_order.java
 *
 * Created on Okt 8, 2021
 * Generated on 9.9.2021 15:35
 *
 */
package eve.conversion.entity;

import data.interfaces.db.LogicEntity;
import eve.conversion.entity.def.EMsystemtrade_order_default;
import eve.logicentity.Systemtrade_order;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMsystemtrade_order
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMsystemtrade_order extends EMsystemtrade_order_default {
//ProjectGenerator: NO AUTHOMATIC UPDATE
    
    public static final String SQLSelectAll = SQLSelect + OrderBy;
    public static final String SQLdeleteall = "delete from systemtrade_order";

    /**
     * Map ResultSet Field values to Systemtrade_order
     * @param dbresult: Database ResultSet
     * @return 
     * @throws java.sql.SQLException
     */
    @Override
    public LogicEntity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Systemtrade_order systemtrade_order = (Systemtrade_order)super.mapResultSet2Entity(dbresult);
        return systemtrade_order;
    }    
    
}

