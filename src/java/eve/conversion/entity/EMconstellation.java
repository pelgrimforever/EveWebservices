/*
 * EMconstellation.java
 *
 * Created on Okt 8, 2021
 * Generated on 9.9.2021 15:35
 *
 */
package eve.conversion.entity;

import data.interfaces.db.LogicEntity;
import eve.conversion.entity.def.EMconstellation_default;
import eve.logicentity.Constellation;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMconstellation
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMconstellation extends EMconstellation_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    public static final String updateNoaccess1 = "update constellation set noaccess = :noaccess: where id not in (select constellation from system where noaccess = :systemnoaccess: group by constellation)";
    public static final String updateNoaccess2 = "update constellation set noaccess = :noaccess: where id in (select constellation from system where noaccess = :systemnoaccess: group by constellation)";

    /**
     * Map ResultSet Field values to Constellation
     * @param dbresult: Database ResultSet
     * @return 
     * @throws java.sql.SQLException
     */
    @Override
    public LogicEntity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Constellation constellation = (Constellation)super.mapResultSet2Entity(dbresult);
        return constellation;
    }    
    
}

