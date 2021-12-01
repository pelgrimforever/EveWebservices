/*
 * EMalliance.java
 *
 * Created on Okt 8, 2021
 * Generated on 9.9.2021 15:35
 *
 */
package eve.conversion.entity;

import data.interfaces.db.LogicEntity;
import eve.conversion.entity.def.EMalliance_default;
import eve.logicentity.Alliance;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMalliance
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMalliance extends EMalliance_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    /**
     * Map ResultSet Field values to Alliance
     * @param dbresult: Database ResultSet
     * @return 
     * @throws java.sql.SQLException
     */
    @Override
    public LogicEntity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Alliance alliance = (Alliance)super.mapResultSet2Entity(dbresult);
        return alliance;
    }    
    
}

