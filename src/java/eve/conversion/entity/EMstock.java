/*
 * EMstock.java
 *
 * Created on Okt 8, 2021
 * Generated on 9.9.2021 15:35
 *
 */
package eve.conversion.entity;

import data.interfaces.db.LogicEntity;
import eve.conversion.entity.def.EMstock_default;
import eve.logicentity.Stock;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMstock
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMstock extends EMstock_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    public static final String SQLSelectAll = SQLSelect + OrderBy;

    /**
     * Map ResultSet Field values to Stock
     * @param dbresult: Database ResultSet
     * @return 
     * @throws java.sql.SQLException
     */
    @Override
    public LogicEntity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Stock stock = (Stock)super.mapResultSet2Entity(dbresult);
        return stock;
    }    
    
}

