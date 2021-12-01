/*
 * EMorder_history.java
 *
 * Created on Okt 8, 2021
 * Generated on 9.9.2021 15:35
 *
 */
package eve.conversion.entity;

import data.interfaces.db.LogicEntity;
import eve.conversion.entity.def.EMorder_history_default;
import eve.logicentity.Order_history;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMorder_history
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMorder_history extends EMorder_history_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    public static final String SQLdeleteall = "Delete from order_history";

    /**
     * Map ResultSet Field values to Order_history
     * @param dbresult: Database ResultSet
     * @return 
     * @throws java.sql.SQLException
     */
    @Override
    public LogicEntity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Order_history order_history = (Order_history)super.mapResultSet2Entity(dbresult);
        return order_history;
    }    
    
}

