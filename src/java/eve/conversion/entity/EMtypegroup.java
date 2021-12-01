/*
 * EMtypegroup.java
 *
 * Created on Okt 8, 2021
 * Generated on 9.9.2021 15:35
 *
 */
package eve.conversion.entity;

import data.interfaces.db.LogicEntity;
import eve.conversion.entity.def.EMtypegroup_default;
import eve.logicentity.Typegroup;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMtypegroup
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMtypegroup extends EMtypegroup_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
//Custom code, do not change this line
    public static final String SQLSelectAll = SQLSelect + OrderBy;
    public static final String SQLSelect4categoryCount = "select count(*) as count from typegroup where " + SQLWherecategory;
//Custom code, do not change this line

    /**
     * Map ResultSet Field values to Typegroup
     * @param dbresult: Database ResultSet
     * @return 
     * @throws java.sql.SQLException
     */
    @Override
    public LogicEntity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Typegroup typegroup = (Typegroup)super.mapResultSet2Entity(dbresult);
        return typegroup;
    }    
    
}

