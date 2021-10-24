/*
 * EMview_tradeorders.java
 *
 * Created on Okt 8, 2021
 * Generated on 9.9.2021 18:23
 *
 */
package eve.conversion.entity;

import data.interfaces.db.LogicEntity;
import eve.conversion.entity.def.EMview_tradeorders_default;
import eve.logicview.View_tradeorders;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMview_tradeorders
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMview_tradeorders extends EMview_tradeorders_default {
//ProjectGenerator: NO AUTHOMATIC UPDATE
    
    public final static String SQLSelect4tradevalues = "select * from view_tradeorders " +
        "where sell_packaged_volume <= :max_cargovolume: and security_island = :security_island.id: and " +
        "buy_totalprice * :net_perc: - sell_totalprice > :min_profit:";

    /**
     * Map ResultSet Field values to View_tradeorders
     * @param dbresult: Database ResultSet
     * @return 
     * @throws java.sql.SQLException
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_tradeorders view_tradeorders = (View_tradeorders)super.mapResultSet2Entity(dbresult);
        return view_tradeorders;
    }    
    
}

