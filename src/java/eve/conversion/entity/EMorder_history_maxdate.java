/*
 * Created on Okt 8, 2021
 * Generated on 12.11.2021 17:9
 */
package eve.conversion.entity;

import data.interfaces.db.View;
import eve.conversion.entity.def.EMorder_history_maxdate_default;
import eve.logicview.Order_history_maxdate;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Franky Laseure
 */
public class EMorder_history_maxdate extends EMorder_history_maxdate_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    @Override
    public View mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Order_history_maxdate order_history_maxdate = (Order_history_maxdate)super.mapResultSet2Entity(dbresult);
        return order_history_maxdate;
    }    
    
}

