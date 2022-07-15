/*
 * Created on Okt 8, 2021
 * Generated on 22.10.2021 17:26
 */
package eve.conversion.entity;

import data.interfaces.db.LogicEntity;
import eve.conversion.entity.def.EMtradecombined_sell_default;
import eve.logicentity.Tradecombined_sell;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Franky Laseure
 */
public class EMtradecombined_sell extends EMtradecombined_sell_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    public static final String SQLSelectAll = SQLSelect + OrderBy;

    @Override
    public LogicEntity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Tradecombined_sell tradecombined_sell = (Tradecombined_sell)super.mapResultSet2Entity(dbresult);
        return tradecombined_sell;
    }    
    
}

