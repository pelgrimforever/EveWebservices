/*
 * EMroute.java
 *
 * Created on Okt 8, 2021
 * Generated on 9.9.2021 15:35
 *
 */
package eve.conversion.entity;

import data.interfaces.db.LogicEntity;
import eve.conversion.entity.def.EMroute_default;
import eve.logicentity.Route;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMroute
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMroute extends EMroute_default {
//ProjectGenerator: NO AUTHOMATIC UPDATE
    
    public static final String SQLSelectAll = SQLSelect + OrderBy;

    /**
     * Map ResultSet Field values to Route
     * @param dbresult: Database ResultSet
     * @return 
     * @throws java.sql.SQLException
     */
    @Override
    public LogicEntity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Route route = (Route)super.mapResultSet2Entity(dbresult);
        return route;
    }    
    
}
