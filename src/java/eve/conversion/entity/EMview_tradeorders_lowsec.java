/*
 * Created on Okt 8, 2021
 * Generated on 7.11.2021 16:10
 */
package eve.conversion.entity;

import data.interfaces.db.View;
import eve.conversion.entity.def.EMview_tradeorders_lowsec_default;
import eve.logicview.View_tradeorders_lowsec;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Franky Laseure
 */
public class EMview_tradeorders_lowsec extends EMview_tradeorders_lowsec_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    public final static String SQLSelect4tradevalues = "select * from view_tradeorders_lowsec " +
        "where sell_packaged_volume <= :max_cargovolume: and " +
        "buy_totalprice * :net_perc: - sell_totalprice > :min_profit:";

    @Override
    public View mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_tradeorders_lowsec view_tradeorders_lowsec = (View_tradeorders_lowsec)super.mapResultSet2Entity(dbresult);
        return view_tradeorders_lowsec;
    }    
    
}

