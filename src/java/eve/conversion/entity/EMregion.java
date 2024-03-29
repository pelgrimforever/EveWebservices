/*
 * Created on Okt 8, 2021
 * Generated on 9.9.2021 15:35
 */
package eve.conversion.entity;

import data.interfaces.db.LogicEntity;
import eve.conversion.entity.def.EMregion_default;
import eve.logicentity.Region;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Franky Laseure
 */
public class EMregion extends EMregion_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    public static final String OrderByPages = " order by orderpages desc";
    public static final String OrderByContractpages = " order by contractpages desc";
    public static final String SQLwhereaccess = "not noaccess";
    public static final String SQLSelectAllaccessOrderpages = SQLSelect + " where " + SQLwhereaccess + OrderByPages;
    public static final String SQLSelectAllaccessContractpages = SQLSelect + " where " + SQLwhereaccess + OrderByContractpages;

    public static final String updateNoaccess1 = "update region set noaccess = :noaccess: where id not in (select region from constellation where noaccess = :constellationnoaccess: group by region)";
    public static final String updateNoaccess2 = "update region set noaccess = :noaccess: where id in (select region from constellation where noaccess = :constellationnoaccess: group by region)";

    @Override
    public LogicEntity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Region region = (Region)super.mapResultSet2Entity(dbresult);
        return region;
    }    
    
}

