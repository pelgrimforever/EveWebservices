/*
 * Created on Okt 8, 2021
 * Generated on 9.9.2021 18:23
 */
package eve.conversion.entity;

import data.interfaces.db.View;
import eve.conversion.entity.def.EMview_tradeorders_default;
import eve.logicview.View_tradeorders;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Franky Laseure
 */
public class EMview_tradeorders extends EMview_tradeorders_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    public final static String SQLSelect4tradevalues = "select * from view_tradeorders " +
        "where sell_packaged_volume <= :max_cargovolume: and security_island = :security_island.id: and " +
        "buy_totalprice * :net_perc: - sell_totalprice > :min_profit:";

    @Override
    public View mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_tradeorders view_tradeorders = (View_tradeorders)super.mapResultSet2Entity(dbresult);
        return view_tradeorders;
    }    
    
}

