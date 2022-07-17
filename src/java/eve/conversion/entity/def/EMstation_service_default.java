/*
 * Created on Okt 8, 2021
 * Generated on 17.6.2022 13:4
 */
package eve.conversion.entity.def;

import data.interfaces.db.*;
import data.gis.shape.*;
import data.json.piJson;
import db.TableMapper;
import eve.eveDatabaseproperties;
import eve.entity.pk.*;
import eve.logicentity.Station_service;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class EMstation_service_default implements eveDatabaseproperties, TableMapper {
    
    public static final String SQLWhere1 = "station = :station_service.station: and service = :station_service.service:";
    public static final String SQLSelect1 = "select station_service.* from station_service where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from station_service where " + SQLWhere1;
    public static final String SQLSelectAll = "select station_service.* from station_service";

    public static final String SQLSelect = "select station_service.* from station_service";
    public static final String SQLWherestation = "station = :station.id:";

//Custom code, do not change this line
    public static final String OrderBy = " order by station";
//Custom code, do not change this line

    public static final String SQLSelect4station = "select * from station_service where " + SQLWherestation + OrderBy;
    public static final String SQLDelete4station = "delete from station_service where " + SQLWherestation;

    @Override
    public String getDbtool() { return databasetool; }
    
    @Override
    public String getConnectionpool() { return connectionpool; }
    
    @Override
    public String getTable() { return "station_service"; }

    /**
     * 
     * @return SQL where clause for one Station_service (=Primarykey)
     */
    @Override
    public String getSQLWhere1() { return SQLWhere1; };

    /**
     * 
     * @return SQL select statement for one Station_service (=Primarykey)
     */
    @Override
    public String getSQLSelect1() { return SQLSelect1; };

    @Override
    public String getSQLPKExcists() { return SQLSelectPKexists; };
    
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    @Override
    public Entity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Station_servicePK station_servicePK = null;
        Station_service station_service;
        if(dbresult==null) {
            station_service = new Station_service(station_servicePK);
        } else {
            try {
                station_servicePK = new Station_servicePK(dbresult.getLong("station"), dbresult.getString("service"));
                station_service = new Station_service(station_servicePK);
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return station_service;
    }

}

