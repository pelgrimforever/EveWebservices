/*
 * EMfrontendpage.java
 *
 * Created on Okt 8, 2021
 * Generated on 13.1.2022 17:48
 *
 */
package eve.conversion.entity;

import data.interfaces.db.LogicEntity;
import eve.conversion.entity.def.EMfrontendpage_default;
import eve.logicentity.Frontendpage;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMfrontendpage
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMfrontendpage extends EMfrontendpage_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
//Custom code, do not change this line
    public static final String SQLSelectAll = SQLSelect + OrderBy;
//Custom code, do not change this line

    /**
     * Map ResultSet Field values to Frontendpage
     * @param dbresult: Database ResultSet
     * @return Frontendpage
     * @throws java.sql.SQLException
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Frontendpage frontendpage = (Frontendpage)super.mapResultSet2Entity(dbresult);
        return frontendpage;
    }    
    
}

