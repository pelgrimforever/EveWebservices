/*
 * EMlocation.java
 *
 * Created on Okt 8, 2021
 * Generated on 9.9.2021 15:35
 *
 */
package eve.conversion.entity;

import data.interfaces.db.LogicEntity;
import eve.conversion.entity.def.EMlocation_default;
import eve.logicentity.Location;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMlocation
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMlocation extends EMlocation_default {
//ProjectGenerator: NO AUTHOMATIC UPDATE
    
    /**
     * Map ResultSet Field values to Location
     * @param dbresult: Database ResultSet
     * @return 
     * @throws java.sql.SQLException
     */
    @Override
    public LogicEntity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Location location = (Location)super.mapResultSet2Entity(dbresult);
        return location;
    }    
    
}
