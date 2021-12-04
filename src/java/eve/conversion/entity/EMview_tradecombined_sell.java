/*
 * EMview_tradecombined_sell.java
 *
 * Created on Okt 8, 2021
 * Generated on 27.10.2021 18:14
 *
 */
package eve.conversion.entity;

import data.interfaces.db.LogicEntity;
import eve.conversion.entity.def.EMview_tradecombined_sell_default;
import eve.logicview.View_tradecombined_sell;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMview_tradecombined_sell
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMview_tradecombined_sell extends EMview_tradecombined_sell_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    public static final String SQLSelect4Tradecombined_sell = SQLSelectAll + 
            " where sell_system = :tradecombined.sell_system: and buy_system = :tradecombined.buy_system: and evetype_id = :tradecombined.evetype:";
    public static final String SQLSelect4sellbuysystem = SQLSelectAll + 
            " where sell_system = :sell_system: and buy_system = :buy_system: order by evetype_id, profit desc";
    
    /**
     * Map ResultSet Field values to View_tradecombined_sell
     * @param dbresult: Database ResultSet
     * @return View_tradecombined_sell
     * @throws java.sql.SQLException
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_tradecombined_sell view_tradecombined_sell = (View_tradecombined_sell)super.mapResultSet2Entity(dbresult);
        return view_tradecombined_sell;
    }    
    
}

