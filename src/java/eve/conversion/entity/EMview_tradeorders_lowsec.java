/*
 * EMview_tradeorders_lowsec.java
 *
 * Created on Okt 8, 2021
 * Generated on 7.11.2021 16:10
 *
 */
package eve.conversion.entity;

import data.interfaces.db.LogicEntity;
import eve.conversion.entity.def.EMview_tradeorders_lowsec_default;
import eve.logicview.View_tradeorders_lowsec;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMview_tradeorders_lowsec
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMview_tradeorders_lowsec extends EMview_tradeorders_lowsec_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    public final static String SQLSelect4tradevalues = "select * from view_tradeorders_lowsec " +
        "where sell_packaged_volume <= :max_cargovolume: and " +
        "buy_totalprice * :net_perc: - sell_totalprice > :min_profit:";

    /**
     * Map ResultSet Field values to View_tradeorders_lowsec
     * @param dbresult: Database ResultSet
     * @return View_tradeorders_lowsec
     * @throws java.sql.SQLException
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_tradeorders_lowsec view_tradeorders_lowsec = (View_tradeorders_lowsec)super.mapResultSet2Entity(dbresult);
        return view_tradeorders_lowsec;
    }    
    
}

