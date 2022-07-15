/*
 * Created on Okt 8, 2021
 * Generated on 9.9.2021 15:35
 */
package eve.conversion.entity;

import data.interfaces.db.LogicEntity;
import eve.conversion.entity.def.EMsecurity_island_default;
import eve.logicentity.Security_island;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Franky Laseure
 */
public class EMsecurity_island extends EMsecurity_island_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    public static final String SQLSelectAll = SQLSelect + OrderBy;
    
    public static final String SQLDeleteAll = "delete from security_island";

    @Override
    public LogicEntity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Security_island security_island = (Security_island)super.mapResultSet2Entity(dbresult);
        return security_island;
    }    
    
}

