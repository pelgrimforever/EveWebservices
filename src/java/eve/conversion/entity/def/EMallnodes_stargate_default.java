/*
 * EMalliance_default.java
 *
 * Created on Okt 8, 2021
 * Generated on 19.0.2022 22:13
 *
 */
package eve.conversion.entity.def;

import data.gis.shape.*;
import data.interfaces.db.LogicEntity;
import data.json.piJson;
import db.TableMapper;
import eve.entity.pk.*;
import eve.logicentity.Allnodes_stargate;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMallnodes_stargate_default
 * Maps SQL ResultSet to eve.logicentity objects
 * @author Franky Laseure
 */
public class EMallnodes_stargate_default implements TableMapper {
    
    public static final String SQLWhere1 = "id = :allnodes_stargate.id:";
    public static final String SQLSelect1 = "select allnodes_stargate.* from allnodes_stargate where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from allnodes_stargate where " + SQLWhere1;
    public static final String SQLSelectAll = "select allnodes_stargate.* from allnodes_stargate";

    public static final String SQLSelect = "select allnodes_stargate.* from allnodes_stargate";

//Custom code, do not change this line
    public static final String OrderBy = " order by id";
//Custom code, do not change this line


    /**
     * 
     * @return SQL where clause for one Allnodes_stargate (=Primarykey)
     */
    @Override
    public String getSQLWhere1() { return SQLWhere1; };

    /**
     * 
     * @return SQL select statement for one Allnodes_stargate (=Primarykey)
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
     * @return SQL select statement for all Allnodes_stargates
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to Allnodes_stargate
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Allnodes_stargatePK allnodes_stargatePK = null;
        Allnodes_stargate allnodes_stargate;
        if(dbresult==null) {
            allnodes_stargate = new Allnodes_stargate(allnodes_stargatePK);
        } else {
            try {
                allnodes_stargatePK = new Allnodes_stargatePK(dbresult.getLong("id"));
                allnodes_stargate = new Allnodes_stargate(allnodes_stargatePK);
                allnodes_stargate.initTo_stargate(dbresult.getLong("to_stargate"));
                allnodes_stargate.initSystem(dbresult.getLong("system"));
                allnodes_stargate.initTo_system(dbresult.getLong("to_system"));
                allnodes_stargate.initDeadend(dbresult.getBoolean("deadend"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return allnodes_stargate;
    }

}

