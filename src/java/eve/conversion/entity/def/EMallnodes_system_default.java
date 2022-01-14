/*
 * EMalliance_default.java
 *
 * Created on Okt 8, 2021
 * Generated on 14.0.2022 16:56
 *
 */
package eve.conversion.entity.def;

import data.gis.shape.*;
import data.interfaces.db.LogicEntity;
import data.json.piJson;
import db.TableMapper;
import eve.entity.pk.*;
import eve.logicentity.Allnodes_system;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMallnodes_system_default
 * Maps SQL ResultSet to eve.logicentity objects
 * @author Franky Laseure
 */
public class EMallnodes_system_default implements TableMapper {
    
    public static final String SQLWhere1 = "id = :allnodes_system.id:";
    public static final String SQLSelect1 = "select allnodes_system.* from allnodes_system where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from allnodes_system where " + SQLWhere1;
    public static final String SQLSelectAll = "select allnodes_system.* from allnodes_system";

    public static final String SQLSelect = "select allnodes_system.* from allnodes_system";

//Custom code, do not change this line
    public static final String OrderBy = " order by id";
//Custom code, do not change this line


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

    /**
     * @return Select statement for Primary key, with count field as result
     * count = 1: exists
     * count = 0: not found
     */
    @Override
    public String getSQLPKExcists() { return SQLSelectPKexists; };
    
    /**
     * 
     * @return SQL select statement for all Allnodes_systems
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to Allnodes_system
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
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

