/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 5.4.2021 17:46
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import eve.interfaces.logicentity.IStation;
import eve.logicentity.Station;
import db.*;
import data.conversion.JSONConversion;
import db.SQLTqueue;
import eve.BusinessObject.table.Bstation;
import eve.conversion.entity.EMstation;
import eve.entity.pk.EvetypePK;
import eve.entity.pk.RacePK;
import eve.entity.pk.SystemPK;
import general.exception.DataException;
import eve.interfaces.entity.pk.ISystemPK;
import general.exception.CustomException;
import java.sql.Date;
import org.json.simple.JSONObject;

/**
 * @author Franky Laseure
 */
public class BLstation extends Bstation {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    public BLstation(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(true);
    }

    public BLstation(TableBusinessrules businessrules) {
        super(businessrules);
        tableio.setLogginrequired(isprivatetable);
    }

    public Station updateStation(SQLTqueue transactionqueue, JSONObject jsonstationdetails) throws DBException, DataException {
        Station station = new Station(JSONConversion.getLong(jsonstationdetails, "station_id"));
        station.setName(JSONConversion.getString(jsonstationdetails, "name"));
        station.setEvetypePK(new EvetypePK(JSONConversion.getLong(jsonstationdetails, "type_id")));
        station.setOffice_rental_cost(JSONConversion.getDouble(jsonstationdetails, "office_rental_cost"));
        if(jsonstationdetails.containsKey("owner")) station.setOwner(JSONConversion.getLong(jsonstationdetails, "owner"));
        if(jsonstationdetails.containsKey("race_id")) station.setRacePK(new RacePK(JSONConversion.getLong(jsonstationdetails, "race_id")));
        station.setReprocessing_efficiency(JSONConversion.getDouble(jsonstationdetails, "reprocessing_efficiency"));
        station.setReprocessing_stations_take(JSONConversion.getDouble(jsonstationdetails, "reprocessing_stations_take"));
        station.setSystemPK(new SystemPK(JSONConversion.getLong(jsonstationdetails, "system_id")));
        station.setMax_dockable_ship_volume(JSONConversion.getDouble(jsonstationdetails, "max_dockable_ship_volume"));
        station.setDownloaddate(new Date(System.currentTimeMillis()));
        insertupdateStation(transactionqueue, station);
        return station;
    }

    public long getStations4systemcount(ISystemPK systemPK) throws CustomException {
        return count(EMstation.SQLSelect4systemCount, systemPK.getSQLprimarykey());
    }

}
