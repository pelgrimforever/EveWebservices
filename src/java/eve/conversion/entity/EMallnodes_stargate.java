/*
 * Created on Okt 8, 2021
 * Generated on 15.11.2021 15:1
 */
package eve.conversion.entity;

import data.interfaces.db.LogicEntity;
import eve.conversion.entity.def.EMallnodes_stargate_default;
import eve.logicentity.Allnodes_stargate;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Franky Laseure
 */
public class EMallnodes_stargate extends EMallnodes_stargate_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    public static final String SQLSelectAll = SQLSelect + OrderBy;
    public static final String SQLcopyStargates = "insert into allnodes_stargate select stargate.id, to_stargate, system, to_system, false from stargate " +
        "where system in (select id from allnodes_system) and " +
        "to_system in (select id from allnodes_system)";
    public static final String SQLmarkdeadends = "update allnodes_stargate set deadend = true where system in (select id from allnodes_system where deadend) or to_system in (select id from allnodes_system where deadend)";

    @Override
    public LogicEntity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Allnodes_stargate allnodes_stargate = (Allnodes_stargate)super.mapResultSet2Entity(dbresult);
        return allnodes_stargate;
    }    
    
}

