/*
 * EMalliance_default.java
 *
 * Created on Okt 8, 2021
 * Generated on 13.4.2022 19:13
 *
 */
package eve.conversion.entity.def;

import data.gis.shape.*;
import data.interfaces.db.LogicEntity;
import data.json.piJson;
import db.TableMapper;
import eve.entity.pk.*;
import eve.logicentity.Eveuser;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMeveuser_default
 * Maps SQL ResultSet to eve.logicentity objects
 * @author Franky Laseure
 */
public class EMeveuser_default implements TableMapper {
    
    public static final String SQLWhere1 = "username = :eveuser.username:";
    public static final String SQLSelect1 = "select eveuser.* from eveuser where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from eveuser where " + SQLWhere1;
    public static final String SQLSelectAll = "select eveuser.* from eveuser";

    public static final String SQLSelect = "select eveuser.* from eveuser";

//Custom code, do not change this line
    public static final String OrderBy = " order by username";
//Custom code, do not change this line


    /**
     * 
     * @return SQL where clause for one Eveuser (=Primarykey)
     */
    @Override
    public String getSQLWhere1() { return SQLWhere1; };

    /**
     * 
     * @return SQL select statement for one Eveuser (=Primarykey)
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
     * @return SQL select statement for all Eveusers
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to Eveuser
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        EveuserPK eveuserPK = null;
        Eveuser eveuser;
        if(dbresult==null) {
            eveuser = new Eveuser(eveuserPK);
        } else {
            try {
                eveuserPK = new EveuserPK(dbresult.getString("username"));
                eveuser = new Eveuser(eveuserPK);
                eveuser.initCreatedat(dbresult.getDate("createdat"));
                eveuser.initAdmin(dbresult.getBoolean("admin"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return eveuser;
    }

}

