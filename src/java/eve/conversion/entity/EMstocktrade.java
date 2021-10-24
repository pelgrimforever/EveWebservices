/*
 * EMstocktrade.java
 *
 * Created on Okt 8, 2021
 * Generated on 9.9.2021 15:35
 *
 */
package eve.conversion.entity;

import data.interfaces.db.LogicEntity;
import eve.conversion.entity.def.EMstocktrade_default;
import eve.logicentity.Stocktrade;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMstocktrade
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMstocktrade extends EMstocktrade_default {
//ProjectGenerator: NO AUTHOMATIC UPDATE
    
    public static final String SQLSelectAll = SQLSelect + OrderBy;
    public static final String SQLdeleteall = "delete from stocktrade";

    /**
     * Map ResultSet Field values to Stocktrade
     * @param dbresult: Database ResultSet
     * @return 
     * @throws java.sql.SQLException
     */
    @Override
    public LogicEntity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Stocktrade stocktrade = (Stocktrade)super.mapResultSet2Entity(dbresult);
        return stocktrade;
    }    
    
}

