/*
 * Created on Okt 8, 2021
 * Generated on 11.1.2022 21:46
 */
package eve.conversion.entity;

import data.interfaces.db.View;
import eve.conversion.entity.def.EMview_evetype_order_history_region_month_default;
import eve.logicview.View_evetype_order_history_region_month;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Franky Laseure
 */
public class EMview_evetype_order_history_region_month extends EMview_evetype_order_history_region_month_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    public static final String SQLselect4evetype = SQLSelectAll + " where evetype = :evetype.id: order by year, month";
    public static final String SQLselect4evetypeYM = SQLSelectAll + " where evetype = :evetype.id: and year = :year: and month = :month: order by average desc";
    
    @Override
    public View mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_evetype_order_history_region_month view_evetype_order_history_region_month = (View_evetype_order_history_region_month)super.mapResultSet2Entity(dbresult);
        return view_evetype_order_history_region_month;
    }    
    
}

