/*
 * EMview_stocktrade_system.java
 *
 * Created on Okt 8, 2021
 * Generated on 9.9.2021 18:23
 *
 */
package eve.conversion.entity;

import data.interfaces.db.LogicEntity;
import eve.conversion.entity.def.EMview_stocktrade_system_default;
import eve.logicview.View_stocktrade_system;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMview_stocktrade_system
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMview_stocktrade_system extends EMview_stocktrade_system_default {
//ProjectGenerator: NO AUTHOMATIC UPDATE
    
    public static final String SQLSelect4username = SQLSelectAll + " where username = :username: order by sellprice";

    /**
     * Map ResultSet Field values to View_stocktrade_system
     * @param dbresult: Database ResultSet
     * @return 
     * @throws java.sql.SQLException
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_stocktrade_system view_stocktrade_system = (View_stocktrade_system)super.mapResultSet2Entity(dbresult);
        return view_stocktrade_system;
    }    
    
}

