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
import eve.logicentity.Syssettings;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class EMsyssettings_default implements eveDatabaseproperties, TableMapper {
    
    public static final String SQLWhere1 = "name = :syssettings.name:";
    public static final String SQLSelect1 = "select syssettings.* from syssettings where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from syssettings where " + SQLWhere1;
    public static final String SQLSelectAll = "select syssettings.* from syssettings";

    public static final String SQLSelect = "select syssettings.* from syssettings";

//Custom code, do not change this line
    public static final String OrderBy = " order by name";
//Custom code, do not change this line


    @Override
    public String getDbtool() { return databasetool; }
    
    @Override
    public String getConnectionpool() { return connectionpool; }
    
    @Override
    public String getTable() { return "syssettings"; }

    /**
     * 
     * @return SQL where clause for one Syssettings (=Primarykey)
     */
    @Override
    public String getSQLWhere1() { return SQLWhere1; };

    /**
     * 
     * @return SQL select statement for one Syssettings (=Primarykey)
     */
    @Override
    public String getSQLSelect1() { return SQLSelect1; };

    @Override
    public String getSQLPKExcists() { return SQLSelectPKexists; };
    
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    @Override
    public Entity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        SyssettingsPK syssettingsPK = null;
        Syssettings syssettings;
        if(dbresult==null) {
            syssettings = new Syssettings(syssettingsPK);
        } else {
            try {
                syssettingsPK = new SyssettingsPK(dbresult.getString("name"));
                syssettings = new Syssettings(syssettingsPK);
                syssettings.initValue(dbresult.getString("value"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return syssettings;
    }

}

