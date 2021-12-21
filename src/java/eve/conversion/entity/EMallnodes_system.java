/*
 * EMallnodes_system.java
 *
 * Created on Okt 8, 2021
 * Generated on 15.11.2021 15:1
 *
 */
package eve.conversion.entity;

import data.interfaces.db.LogicEntity;
import eve.conversion.entity.def.EMallnodes_system_default;
import eve.logicentity.Allnodes_system;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMallnodes_system
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMallnodes_system extends EMallnodes_system_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
//Custom code, do not change this line
    public static final String SQLSelectAll = SQLSelect + OrderBy;
    public static final String SQLdeleteAll = "truncate allnodes_stargate, allnodes_system";
    public static final String SQLcopySystems = "insert into allnodes_system select id, false from system where not noaccess and security_status > 0";
    public static final String SQLmarkdeadends = "update allnodes_system set deadend = true where id in (select system from allnodes_stargate where not deadend group by system having count(system) = 1)";
    public static final String SQLgetdeadends = "select count(id) as count from allnodes_system where deadend";
//Custom code, do not change this line

    /**
     * Map ResultSet Field values to Allnodes_system
     * @param dbresult: Database ResultSet
     * @return Allnodes_system
     * @throws java.sql.SQLException
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Allnodes_system allnodes_system = (Allnodes_system)super.mapResultSet2Entity(dbresult);
        return allnodes_system;
    }    
    
}

