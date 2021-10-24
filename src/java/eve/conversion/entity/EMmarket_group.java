/*
 * EMmarket_group.java
 *
 * Created on Okt 8, 2021
 * Generated on 9.9.2021 15:35
 *
 */
package eve.conversion.entity;

import data.interfaces.db.LogicEntity;
import eve.conversion.entity.def.EMmarket_group_default;
import eve.logicentity.Market_group;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMmarket_group
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMmarket_group extends EMmarket_group_default {
//ProjectGenerator: NO AUTHOMATIC UPDATE
    
    /**
     * Map ResultSet Field values to Market_group
     * @param dbresult: Database ResultSet
     * @return 
     * @throws java.sql.SQLException
     */
    @Override
    public LogicEntity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Market_group market_group = (Market_group)super.mapResultSet2Entity(dbresult);
        return market_group;
    }    
    
}

