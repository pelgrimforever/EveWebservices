/*
 * EMshipfitorderselected.java
 *
 * Created on Okt 8, 2021
 * Generated on 20.11.2021 17:22
 *
 */
package eve.conversion.entity;

import data.interfaces.db.LogicEntity;
import eve.conversion.entity.def.EMshipfitorderselected_default;
import eve.logicentity.Shipfitorderselected;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMshipfitorderselected
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMshipfitorderselected extends EMshipfitorderselected_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
//Custom code, do not change this line
    public static final String SQLSelectAll = SQLSelect + OrderBy;
//Custom code, do not change this line

    /**
     * Map ResultSet Field values to Shipfitorderselected
     * @param dbresult: Database ResultSet
     * @return Shipfitorderselected
     * @throws java.sql.SQLException
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Shipfitorderselected shipfitorderselected = (Shipfitorderselected)super.mapResultSet2Entity(dbresult);
        return shipfitorderselected;
    }    
    
}

