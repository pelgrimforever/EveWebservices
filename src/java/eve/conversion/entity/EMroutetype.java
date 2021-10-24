/*
 * EMroutetype.java
 *
 * Created on Okt 8, 2021
 * Generated on 9.9.2021 15:35
 *
 */
package eve.conversion.entity;

import data.interfaces.db.LogicEntity;
import eve.conversion.entity.def.EMroutetype_default;
import eve.logicentity.Routetype;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMroutetype
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMroutetype extends EMroutetype_default {
//ProjectGenerator: NO AUTHOMATIC UPDATE
    
    public static final String SQLSelectAll = SQLSelect + OrderBy;

    /**
     * Map ResultSet Field values to Routetype
     * @param dbresult: Database ResultSet
     * @return 
     * @throws java.sql.SQLException
     */
    @Override
    public LogicEntity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Routetype routetype = (Routetype)super.mapResultSet2Entity(dbresult);
        return routetype;
    }    
    
}

