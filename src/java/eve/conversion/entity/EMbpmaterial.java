/*
 * EMbpmaterial.java
 *
 * Created on Okt 8, 2021
 * Generated on 24.0.2022 16:47
 *
 */
package eve.conversion.entity;

import data.interfaces.db.LogicEntity;
import eve.conversion.entity.def.EMbpmaterial_default;
import eve.logicentity.Bpmaterial;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMbpmaterial
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMbpmaterial extends EMbpmaterial_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
//Custom code, do not change this line
    public static final String SQLSelectAll = SQLSelect + OrderBy;
//Custom code, do not change this line

    /**
     * Map ResultSet Field values to Bpmaterial
     * @param dbresult: Database ResultSet
     * @return Bpmaterial
     * @throws java.sql.SQLException
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Bpmaterial bpmaterial = (Bpmaterial)super.mapResultSet2Entity(dbresult);
        return bpmaterial;
    }    
    
}

