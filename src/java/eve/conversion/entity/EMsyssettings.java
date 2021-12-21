/*
 * EMsyssettings.java
 *
 * Created on Okt 8, 2021
 * Generated on 11.11.2021 13:40
 *
 */
package eve.conversion.entity;

import data.interfaces.db.LogicEntity;
import eve.conversion.entity.def.EMsyssettings_default;
import eve.logicentity.Syssettings;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMsyssettings
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMsyssettings extends EMsyssettings_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
//Custom code, do not change this line
    public static final String SQLSelectAll = SQLSelect + OrderBy;
//Custom code, do not change this line

    /**
     * Map ResultSet Field values to Syssettings
     * @param dbresult: Database ResultSet
     * @return Syssettings
     * @throws java.sql.SQLException
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Syssettings syssettings = (Syssettings)super.mapResultSet2Entity(dbresult);
        return syssettings;
    }    
    
}

