/*
 * EMfrontendpage_auth.java
 *
 * Created on Okt 8, 2021
 * Generated on 16.1.2022 20:54
 *
 */
package eve.conversion.entity;

import data.interfaces.db.LogicEntity;
import eve.conversion.entity.def.EMfrontendpage_auth_default;
import eve.logicentity.Frontendpage_auth;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMfrontendpage_auth
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMfrontendpage_auth extends EMfrontendpage_auth_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
//Custom code, do not change this line
    public static final String SQLSelectAll = SQLSelect + OrderBy;
//Custom code, do not change this line

    /**
     * Map ResultSet Field values to Frontendpage_auth
     * @param dbresult: Database ResultSet
     * @return Frontendpage_auth
     * @throws java.sql.SQLException
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Frontendpage_auth frontendpage_auth = (Frontendpage_auth)super.mapResultSet2Entity(dbresult);
        return frontendpage_auth;
    }    
    
}

