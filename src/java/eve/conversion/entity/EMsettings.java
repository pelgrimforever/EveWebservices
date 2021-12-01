/*
 * EMsettings.java
 *
 * Created on Okt 8, 2021
 * Generated on 25.9.2021 14:36
 *
 */
package eve.conversion.entity;

import data.interfaces.db.LogicEntity;
import eve.conversion.entity.def.EMsettings_default;
import eve.logicentity.Settings;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMsettings
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMsettings extends EMsettings_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
//Custom code, do not change this line
    public static final String SQLSelectAll = SQLSelect + OrderBy;
//Custom code, do not change this line

    /**
     * Map ResultSet Field values to Settings
     * @param dbresult: Database ResultSet
     * @return Settings
     * @throws java.sql.SQLException
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Settings settings = (Settings)super.mapResultSet2Entity(dbresult);
        return settings;
    }    
    
}

