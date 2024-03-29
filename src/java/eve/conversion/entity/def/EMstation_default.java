/*
 * Created on Okt 8, 2021
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */
package eve.conversion.entity.def;

import data.interfaces.db.*;
import data.gis.shape.*;
import data.json.piJson;
import db.TableMapper;
import eve.eveDatabaseproperties;
import eve.entity.pk.*;
import eve.logicentity.Station;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class EMstation_default implements eveDatabaseproperties, TableMapper {
    
    public static final String SQLWhere1 = "id = :station.id:";
    public static final String SQLSelect1 = "select station.* from station where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from station where " + SQLWhere1;
    public static final String SQLSelectAll = "select station.* from station";

    public static final String SQLSelect = "select station.* from station";
    public static final String SQLWhererace = "race_id = :race.id:";
    public static final String SQLWhereevetype = "type_id = :evetype.id:";
    public static final String SQLWheresystem = "system_id = :system.id:";

//Custom code, do not change this line
    public static final String OrderBy = " order by id";
//Custom code, do not change this line

    public static final String SQLSelect4race = "select * from station where " + SQLWhererace + OrderBy;
    public static final String SQLDelete4race = "delete from station where " + SQLWhererace;
    public static final String SQLSelect4evetype = "select * from station where " + SQLWhereevetype + OrderBy;
    public static final String SQLDelete4evetype = "delete from station where " + SQLWhereevetype;
    public static final String SQLSelect4system = "select * from station where " + SQLWheresystem + OrderBy;
    public static final String SQLDelete4system = "delete from station where " + SQLWheresystem;

    @Override
    public String getDbtool() { return databasetool; }
    
    @Override
    public String getConnectionpool() { return connectionpool; }
    
    @Override
    public String getTable() { return "station"; }

    /**
     * 
     * @return SQL where clause for one Station (=Primarykey)
     */
    @Override
    public String getSQLWhere1() { return SQLWhere1; };

    /**
     * 
     * @return SQL select statement for one Station (=Primarykey)
     */
    @Override
    public String getSQLSelect1() { return SQLSelect1; };

    @Override
    public String getSQLPKExcists() { return SQLSelectPKexists; };
    
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    @Override
    public Entity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        StationPK stationPK = null;
        Station station;
        if(dbresult==null) {
            station = new Station(stationPK);
        } else {
            try {
                stationPK = new StationPK(dbresult.getLong("id"));
                station = new Station(stationPK);
                station.initRacePK(new RacePK(dbresult.getLong("race_id")));
                if(dbresult.wasNull()) station.setRacePK(null);                
                station.initEvetypePK(new EvetypePK(dbresult.getLong("type_id")));
                if(dbresult.wasNull()) station.setEvetypePK(null);                
                station.initSystemPK(new SystemPK(dbresult.getLong("system_id")));
                if(dbresult.wasNull()) station.setSystemPK(null);                
                station.initName(dbresult.getString("name"));
                station.initOffice_rental_cost(dbresult.getDouble("office_rental_cost"));
                station.initReprocessing_efficiency(dbresult.getDouble("reprocessing_efficiency"));
                station.initReprocessing_stations_take(dbresult.getDouble("reprocessing_stations_take"));
                station.initMax_dockable_ship_volume(dbresult.getDouble("max_dockable_ship_volume"));
                station.initOwner(dbresult.getLong("owner"));
                station.initDownloaddate(dbresult.getDate("downloaddate"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return station;
    }

}

