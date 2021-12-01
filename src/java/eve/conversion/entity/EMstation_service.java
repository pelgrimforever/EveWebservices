/*
 * EMstation_service.java
 *
 * Created on Okt 8, 2021
 * Generated on 9.9.2021 15:35
 *
 */
package eve.conversion.entity;

import data.interfaces.db.LogicEntity;
import eve.conversion.entity.def.EMstation_service_default;
import eve.logicentity.Station_service;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMstation_service
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMstation_service extends EMstation_service_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    public static final String SQLSelectAll = SQLSelect + OrderBy;

    /**
     * Map ResultSet Field values to Station_service
     * @param dbresult: Database ResultSet
     * @return 
     * @throws java.sql.SQLException
     */
    @Override
    public LogicEntity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Station_service station_service = (Station_service)super.mapResultSet2Entity(dbresult);
        return station_service;
    }    
    
}

