/*
 * EMfaction.java
 *
 * Created on Okt 8, 2021
 * Generated on 9.9.2021 15:35
 *
 */
package eve.conversion.entity;

import data.interfaces.db.LogicEntity;
import eve.conversion.entity.def.EMfaction_default;
import eve.logicentity.Faction;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMfaction
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMfaction extends EMfaction_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    /**
     * Map ResultSet Field values to Faction
     * @param dbresult: Database ResultSet
     * @return 
     * @throws java.sql.SQLException
     */
    @Override
    public LogicEntity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Faction faction = (Faction)super.mapResultSet2Entity(dbresult);
        return faction;
    }    
    
}

