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
import eve.logicentity.Race;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class EMrace_default implements eveDatabaseproperties, TableMapper {
    
    public static final String SQLWhere1 = "id = :race.id:";
    public static final String SQLSelect1 = "select race.* from race where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from race where " + SQLWhere1;
    public static final String SQLSelectAll = "select race.* from race";

    public static final String SQLSelect = "select race.* from race";
    public static final String SQLWherefaction = "faction = :faction.id:";

//Custom code, do not change this line
    public static final String OrderBy = " order by id";
//Custom code, do not change this line

    public static final String SQLSelect4faction = "select * from race where " + SQLWherefaction + OrderBy;
    public static final String SQLDelete4faction = "delete from race where " + SQLWherefaction;

    @Override
    public String getDbtool() { return databasetool; }
    
    @Override
    public String getConnectionpool() { return connectionpool; }
    
    @Override
    public String getTable() { return "race"; }

    /**
     * 
     * @return SQL where clause for one Race (=Primarykey)
     */
    @Override
    public String getSQLWhere1() { return SQLWhere1; };

    /**
     * 
     * @return SQL select statement for one Race (=Primarykey)
     */
    @Override
    public String getSQLSelect1() { return SQLSelect1; };

    @Override
    public String getSQLPKExcists() { return SQLSelectPKexists; };
    
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    @Override
    public Entity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        RacePK racePK = null;
        Race race;
        if(dbresult==null) {
            race = new Race(racePK);
        } else {
            try {
                racePK = new RacePK(dbresult.getLong("id"));
                race = new Race(racePK);
                race.initFactionPK(new FactionPK(dbresult.getLong("faction")));
                if(dbresult.wasNull()) race.setFactionPK(null);                
                race.initName(dbresult.getString("name"));
                race.initDescription(dbresult.getString("description"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return race;
    }

}

