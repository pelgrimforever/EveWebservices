/*
 * EMshipfit.java
 *
 * Created on Okt 8, 2021
 * Generated on 17.11.2021 15:28
 *
 */
package eve.conversion.entity;

import data.interfaces.db.LogicEntity;
import eve.conversion.entity.def.EMshipfit_default;
import eve.logicentity.Shipfit;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMshipfit
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMshipfit extends EMshipfit_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
//Custom code, do not change this line
    public static final String SQLSelectAll = SQLSelect + OrderBy;
//Custom code, do not change this line

    /**
     * Map ResultSet Field values to Shipfit
     * @param dbresult: Database ResultSet
     * @return Shipfit
     * @throws java.sql.SQLException
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Shipfit shipfit = (Shipfit)super.mapResultSet2Entity(dbresult);
        return shipfit;
    }    
    
}

