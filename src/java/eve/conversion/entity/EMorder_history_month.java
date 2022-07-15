/*
 * Created on Okt 8, 2021
 * Generated on 13.11.2021 15:8
 */
package eve.conversion.entity;

import data.interfaces.db.LogicEntity;
import eve.conversion.entity.def.EMorder_history_month_default;
import eve.logicentity.Order_history_month;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Franky Laseure
 */
public class EMorder_history_month extends EMorder_history_month_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    public static final String SQLSelectAll = SQLSelect + OrderBy;
    public static final String SQLdeleteAll = "truncate order_history_month";    
    public static final String SQLcopymarkethistory = "insert into order_history_month " +
        "select region, evetype, extract(year from date), extract(month from date), avg(average), max(highest), min(lowest), sum(volume), sum(order_count) " +
        "from order_history " +
        "group by region, evetype, extract(year from date), extract(month from date)";

    @Override
    public LogicEntity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Order_history_month order_history_month = (Order_history_month)super.mapResultSet2Entity(dbresult);
        return order_history_month;
    }    
    
}

