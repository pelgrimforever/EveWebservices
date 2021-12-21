/*
 * EMview_evetype_order_history_month.java
 *
 * Created on Okt 8, 2021
 * Generated on 14.11.2021 16:21
 *
 */
package eve.conversion.entity;

import data.interfaces.db.LogicEntity;
import eve.conversion.entity.def.EMview_evetype_order_history_month_default;
import eve.logicview.View_evetype_order_history_month;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMview_evetype_order_history_month
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMview_evetype_order_history_month extends EMview_evetype_order_history_month_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    public static final String SQLselect4evetype = SQLSelectAll + " where evetype = :evetype.id: order by year, month";
    
    /**
     * Map ResultSet Field values to View_evetype_order_history_month
     * @param dbresult: Database ResultSet
     * @return View_evetype_order_history_month
     * @throws java.sql.SQLException
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_evetype_order_history_month view_evetype_order_history_month = (View_evetype_order_history_month)super.mapResultSet2Entity(dbresult);
        return view_evetype_order_history_month;
    }    
    
}

