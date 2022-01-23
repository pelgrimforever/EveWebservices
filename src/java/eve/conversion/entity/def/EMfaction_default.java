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
import eve.logicentity.Faction;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMfaction_default
 * Maps SQL ResultSet to eve.logicentity objects
 * @author Franky Laseure
 */
public class EMfaction_default implements TableMapper {
    
    public static final String SQLWhere1 = "id = :faction.id:";
    public static final String SQLSelect1 = "select faction.* from faction where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from faction where " + SQLWhere1;
    public static final String SQLSelectAll = "select faction.* from faction";

    public static final String SQLSelect = "select faction.* from faction";
    public static final String SQLWheresystem = "solar_system = :system.id:";

//Custom code, do not change this line
    public static final String OrderBy = " order by id";
//Custom code, do not change this line

    public static final String SQLSelect4system = "select * from faction where " + SQLWheresystem + OrderBy;
    public static final String SQLDelete4system = "delete from faction where " + SQLWheresystem;

    /**
     * 
     * @return SQL where clause for one Faction (=Primarykey)
     */
    @Override
    public String getSQLWhere1() { return SQLWhere1; };

    /**
     * 
     * @return SQL select statement for one Faction (=Primarykey)
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
     * @return SQL select statement for all Factions
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to Faction
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        FactionPK factionPK = null;
        Faction faction;
        if(dbresult==null) {
            faction = new Faction(factionPK);
        } else {
            try {
                factionPK = new FactionPK(dbresult.getLong("id"));
                faction = new Faction(factionPK);
                faction.initSystemPK(new SystemPK(dbresult.getLong("solar_system")));
                if(dbresult.wasNull()) faction.setSystemPK(null);                
                faction.initName(dbresult.getString("name"));
                faction.initDescription(dbresult.getString("description"));
                faction.initIs_unique(dbresult.getBoolean("is_unique"));
                faction.initSize_factor(dbresult.getDouble("size_factor"));
                faction.initStation_count(dbresult.getInt("station_count"));
                faction.initStation_system_count(dbresult.getInt("station_system_count"));
                faction.initCorporation(dbresult.getLong("corporation"));
                faction.initMilitia_corporation(dbresult.getLong("militia_corporation"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return faction;
    }

}

