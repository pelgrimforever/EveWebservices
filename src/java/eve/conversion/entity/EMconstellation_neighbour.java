/*
 * EMconstellation_neighbour.java
 *
 * Created on Okt 8, 2021
 * Generated on 9.9.2021 15:35
 *
 */
package eve.conversion.entity;

import data.interfaces.db.LogicEntity;
import eve.conversion.entity.def.EMconstellation_neighbour_default;
import eve.logicentity.Constellation_neighbour;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMconstellation_neighbour
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMconstellation_neighbour extends EMconstellation_neighbour_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    public static final String SQLSelectAll = SQLSelect + OrderBy;
    
    public static final String SQLDeleteAll = "delete from constellation_neighbour";
    public static final String SQLcreateneighours = "insert into constellation_neighbour " +
        "select s1.constellation, s2.constellation from stargate sg " +
        "inner join system s1 on sg.system = s1.id " +
        "inner join system s2 on sg.to_system = s2.id " +
        "where sg.isconstellationborder and s1.constellation <> s2.constellation " +
        "group by s1.constellation, s2.constellation";

    /**
     * Map ResultSet Field values to Constellation_neighbour
     * @param dbresult: Database ResultSet
     * @return 
     * @throws java.sql.SQLException
     */
    @Override
    public LogicEntity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Constellation_neighbour constellation_neighbour = (Constellation_neighbour)super.mapResultSet2Entity(dbresult);
        return constellation_neighbour;
    }    
    
}

