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
import eve.logicentity.Station_service;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMstation_service_default
 * Maps SQL ResultSet to eve.logicentity objects
 * @author Franky Laseure
 */
public class EMstation_service_default implements TableMapper {
    
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

    /**
     * @return Select statement for Primary key, with count field as result
     * count = 1: exists
     * count = 0: not found
     */
    @Override
    public String getSQLPKExcists() { return SQLSelectPKexists; };
    
    /**
     * 
     * @return SQL select statement for all Station_services
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to Station_service
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
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

