/*
 * Created on Okt 8, 2021
 * Generated on 13.6.2022 11:21
 */
package eve.conversion.entity.def;

import data.interfaces.db.*;
import data.gis.shape.*;
import data.json.piJson;
import db.TableMapper;
import eve.eveDatabaseproperties;
import eve.entity.pk.*;
import eve.logicentity.Allnodes_system;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class EMallnodes_system_default implements eveDatabaseproperties, TableMapper {
    
    public static final String SQLWhere1 = "id = :allnodes_system.id:";
    public static final String SQLSelect1 = "select allnodes_system.* from allnodes_system where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from allnodes_system where " + SQLWhere1;
    public static final String SQLSelectAll = "select allnodes_system.* from allnodes_system";

    public static final String SQLSelect = "select allnodes_system.* from allnodes_system";

//Custom code, do not change this line
    public static final String OrderBy = " order by id";
//Custom code, do not change this line


    @Override
    public String getDbtool() { return databasetool; }
    
    @Override
    public String getConnectionpool() { return connectionpool; }
    
    @Override
    public String getTable() { return "allnodes_system"; }

    /**
     * 
     * @return SQL where clause for one Allnodes_system (=Primarykey)
     */
    @Override
    public String getSQLWhere1() { return SQLWhere1; };

    /**
     * 
     * @return SQL select statement for one Allnodes_system (=Primarykey)
     */
    @Override
    public String getSQLSelect1() { return SQLSelect1; };

    @Override
    public String getSQLPKExcists() { return SQLSelectPKexists; };
    
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    @Override
    public Entity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Allnodes_systemPK allnodes_systemPK = null;
        Allnodes_system allnodes_system;
        if(dbresult==null) {
            allnodes_system = new Allnodes_system(allnodes_systemPK);
        } else {
            try {
                allnodes_systemPK = new Allnodes_systemPK(dbresult.getLong("id"));
                allnodes_system = new Allnodes_system(allnodes_systemPK);
                allnodes_system.initDeadend(dbresult.getBoolean("deadend"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return allnodes_system;
    }

}

