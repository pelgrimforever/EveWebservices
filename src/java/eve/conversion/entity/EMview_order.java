/*
 * EMview_order.java
 *
 * Created on Okt 8, 2021
 * Generated on 9.9.2021 18:23
 *
 */
package eve.conversion.entity;

import data.interfaces.db.LogicEntity;
import eve.conversion.entity.def.EMview_order_default;
import eve.logicview.View_order;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMview_order
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMview_order extends EMview_order_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    public static final String SQLSelectOne = SQLSelectAll + " where view_order.id = :orders.id:";

    public static final String SQLorderbyprice_asc = " order by view_order.price asc";
    public static final String SQLorderbyprice_desc = " order by view_order.price desc";
    public static final String SQLSelect4Evetypebuy = SQLSelectAll + " where view_order.evetype = :evetype.id: and view_order.is_buy_order" + SQLorderbyprice_desc;
    public static final String SQLSelect4Evetypesell = SQLSelectAll + " where view_order.evetype = :evetype.id: and not view_order.is_buy_order" + SQLorderbyprice_asc;

    /**
     * Map ResultSet Field values to View_order
     * @param dbresult: Database ResultSet
     * @return 
     * @throws java.sql.SQLException
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_order view_order = (View_order)super.mapResultSet2Entity(dbresult);
        return view_order;
    }    
    
}

