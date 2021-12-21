/*
 * EMshipfitmodule.java
 *
 * Created on Okt 8, 2021
 * Generated on 17.11.2021 15:31
 *
 */
package eve.conversion.entity;

import data.interfaces.db.LogicEntity;
import eve.conversion.entity.def.EMshipfitmodule_default;
import eve.logicentity.Shipfitmodule;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMshipfitmodule
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMshipfitmodule extends EMshipfitmodule_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
//Custom code, do not change this line
    public static final String SQLSelectAll = SQLSelect + OrderBy;
//Custom code, do not change this line

    /**
     * Map ResultSet Field values to Shipfitmodule
     * @param dbresult: Database ResultSet
     * @return Shipfitmodule
     * @throws java.sql.SQLException
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Shipfitmodule shipfitmodule = (Shipfitmodule)super.mapResultSet2Entity(dbresult);
        return shipfitmodule;
    }    
    
}

