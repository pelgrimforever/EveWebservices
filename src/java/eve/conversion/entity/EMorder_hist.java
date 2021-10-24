/*
 * EMorder_hist.java
 *
 * Created on Okt 8, 2021
 * Generated on 9.9.2021 15:35
 *
 */
package eve.conversion.entity;

import data.interfaces.db.LogicEntity;
import eve.conversion.entity.def.EMorder_hist_default;
import eve.logicentity.Order_hist;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMorder_hist
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMorder_hist extends EMorder_hist_default {
//ProjectGenerator: NO AUTHOMATIC UPDATE
    
    public static final String SQLdeleteall = "delete from order_hist";
    public static final String SQLcopyorders = "insert into order_hist select * from orders where id not in (select id from order_hist)";

    /**
     * Map ResultSet Field values to Order_hist
     * @param dbresult: Database ResultSet
     * @return 
     * @throws java.sql.SQLException
     */
    @Override
    public LogicEntity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Order_hist order_hist = (Order_hist)super.mapResultSet2Entity(dbresult);
        return order_hist;
    }    
    
}

