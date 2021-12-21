/*
 * EMview_evetype_order_history.java
 *
 * Created on Okt 8, 2021
 * Generated on 13.11.2021 18:30
 *
 */
package eve.conversion.entity;

import data.interfaces.db.LogicEntity;
import eve.conversion.entity.def.EMview_evetype_order_history_default;
import eve.logicview.View_evetype_order_history;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMview_evetype_order_history
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMview_evetype_order_history extends EMview_evetype_order_history_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    public static final String SQLselect4evetype = SQLSelectAll + " where evetype = :evetype.id: order by date";
    
    /**
     * Map ResultSet Field values to View_evetype_order_history
     * @param dbresult: Database ResultSet
     * @return View_evetype_order_history
     * @throws java.sql.SQLException
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_evetype_order_history view_evetype_order_history = (View_evetype_order_history)super.mapResultSet2Entity(dbresult);
        return view_evetype_order_history;
    }    
    
}

