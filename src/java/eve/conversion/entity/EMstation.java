/*
 * EMstation.java
 *
 * Created on Okt 8, 2021
 * Generated on 9.9.2021 15:35
 *
 */
package eve.conversion.entity;

import data.interfaces.db.LogicEntity;
import eve.conversion.entity.def.EMstation_default;
import eve.logicentity.Station;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMstation
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMstation extends EMstation_default {
//Metacoder: NO AUTHOMATIC UPDATE

    public static final String SQLSelectAll = SQLSelect + OrderBy;
    
    public static final String SQLSelect4systemCount = "select count(*) as count from station where " + SQLWheresystem;
    
    /**
     * Map ResultSet Field values to Station
     * @param dbresult: Database ResultSet
     * @return 
     * @throws java.sql.SQLException
     */
    @Override
    public LogicEntity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Station station = (Station)super.mapResultSet2Entity(dbresult);
        return station;
    }    
    
}

