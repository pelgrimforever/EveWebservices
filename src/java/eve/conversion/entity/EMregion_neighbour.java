/*
 * Created on Okt 8, 2021
 * Generated on 9.9.2021 15:35
 */
package eve.conversion.entity;

import data.interfaces.db.LogicEntity;
import eve.conversion.entity.def.EMregion_neighbour_default;
import eve.logicentity.Region_neighbour;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Franky Laseure
 */
public class EMregion_neighbour extends EMregion_neighbour_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    public static final String SQLSelectAll = SQLSelect + OrderBy;

    public static final String SQLDeleteAll = "delete from region_neighbour";
    public static final String SQLcreateneighours = "insert into region_neighbour " +
        "select c1.region, c2.region from stargate sg " +
        "inner join system s1 on sg.system = s1.id " +
        "inner join constellation c1 on s1.constellation = c1.id " +
        "inner join system s2 on sg.to_system = s2.id " +
        "inner join constellation c2 on s2.constellation = c2.id " +
        "where sg.isregionborder and c1.region <> c2.region " +
        "group by c1.region, c2.region";

    @Override
    public LogicEntity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Region_neighbour region_neighbour = (Region_neighbour)super.mapResultSet2Entity(dbresult);
        return region_neighbour;
    }    
    
}

