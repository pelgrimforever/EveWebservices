/*
 * EMrace.java
 *
 * Created on Okt 8, 2021
 * Generated on 9.9.2021 15:35
 *
 */
package eve.conversion.entity;

import data.interfaces.db.LogicEntity;
import eve.conversion.entity.def.EMrace_default;
import eve.logicentity.Race;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMrace
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMrace extends EMrace_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    public static final String SQLSelectAll = SQLSelect + OrderBy;

    /**
     * Map ResultSet Field values to Race
     * @param dbresult: Database ResultSet
     * @return 
     * @throws java.sql.SQLException
     */
    @Override
    public LogicEntity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Race race = (Race)super.mapResultSet2Entity(dbresult);
        return race;
    }    
    
}

