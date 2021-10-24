/*
 * EMcategory.java
 *
 * Created on Okt 8, 2021
 * Generated on 9.9.2021 15:35
 *
 */
package eve.conversion.entity;

import data.interfaces.db.LogicEntity;
import eve.conversion.entity.def.EMcategory_default;
import eve.logicentity.Category;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMcategory
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMcategory extends EMcategory_default {
//ProjectGenerator: NO AUTHOMATIC UPDATE
    
    /**
     * Map ResultSet Field values to Category
     * @param dbresult: Database ResultSet
     * @return 
     * @throws java.sql.SQLException
     */
    @Override
    public LogicEntity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Category category = (Category)super.mapResultSet2Entity(dbresult);
        return category;
    }    
    
}

