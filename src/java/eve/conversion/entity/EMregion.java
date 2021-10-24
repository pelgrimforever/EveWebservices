/*
 * EMregion.java
 *
 * Created on Okt 8, 2021
 * Generated on 9.9.2021 15:35
 *
 */
package eve.conversion.entity;

import data.interfaces.db.LogicEntity;
import eve.conversion.entity.def.EMregion_default;
import eve.logicentity.Region;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMregion
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMregion extends EMregion_default {
//ProjectGenerator: NO AUTHOMATIC UPDATE
    
    public static final String OrderByPages = " order by orderpages desc";
    public static final String SQLwhereaccess = "not noaccess";
    public static final String SQLSelectAllaccess = SQLSelect + " where " + SQLwhereaccess + OrderByPages;

    public static final String updateNoaccess1 = "update region set noaccess = :noaccess: where id not in (select region from constellation where noaccess = :constellationnoaccess: group by region)";
    public static final String updateNoaccess2 = "update region set noaccess = :noaccess: where id in (select region from constellation where noaccess = :constellationnoaccess: group by region)";

    /**
     * Map ResultSet Field values to Region
     * @param dbresult: Database ResultSet
     * @return 
     * @throws java.sql.SQLException
     */
    @Override
    public LogicEntity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Region region = (Region)super.mapResultSet2Entity(dbresult);
        return region;
    }    
    
}

