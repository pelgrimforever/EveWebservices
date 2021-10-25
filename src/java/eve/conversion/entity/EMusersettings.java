/*
 * EMusersettings.java
 *
 * Created on Okt 8, 2021
 * Generated on 25.9.2021 14:57
 *
 */
package eve.conversion.entity;

import data.interfaces.db.LogicEntity;
import eve.conversion.entity.def.EMusersettings_default;
import eve.logicentity.Usersettings;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMusersettings
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMusersettings extends EMusersettings_default {
//ProjectGenerator: NO AUTHOMATIC UPDATE
    
//Custom code, do not change this line
    public static final String SQLSelectAll = SQLSelect + OrderBy;
//Custom code, do not change this line

    /**
     * Map ResultSet Field values to Usersettings
     * @param dbresult: Database ResultSet
     * @return Usersettings
     * @throws java.sql.SQLException
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Usersettings usersettings = (Usersettings)super.mapResultSet2Entity(dbresult);
        return usersettings;
    }    
    
}

