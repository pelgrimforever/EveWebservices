/*
 * BLstation.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 5.4.2021 17:46
 *
 */

package eve.BusinessObject.Logic;

import BusinessObject.BLRecordcount;
import general.exception.DBException;
import data.interfaces.db.LogicEntity;
import eve.interfaces.logicentity.IStation;
import eve.logicentity.Station;
import BusinessObject.GeneralEntityObject;
import data.conversion.JSONConversion;
import data.interfaces.db.Recordcount;
import db.AbstractSQLMapper;
import db.ViewMapper;
import eve.BusinessObject.table.Bstation;
import eve.entity.pk.EvetypePK;
import eve.entity.pk.RacePK;
import eve.entity.pk.SystemPK;
import general.exception.DataException;
import eve.interfaces.BusinessObject.IBLstation;
import eve.interfaces.entity.pk.ISystemPK;
import general.exception.CustomException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.json.simple.JSONObject;

/**
 * Business Logic Entity class BLstation
 *
 * Class for manipulating data- and database objects
 * for Entity Station and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLstation extends Bstation implements IBLstation {
//ProjectGenerator: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    /**
     * Constructor, sets Station as default Entity
     */
    public BLstation() {
        this.setLogginrequired(isprivatetable);
    }

    /**
     * Constructor, sets Station as default Entity
     * sets transaction queue from given GeneralObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralObjects that holds the transaction queue
     */
    public BLstation(GeneralEntityObject transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }

    /**
     * load extra fields from adjusted sql statement
     */
    @Override
    public void loadExtra(ResultSet dbresult, LogicEntity station) throws SQLException {
        
    }
    
    public void updateStation(JSONObject jsonstationdetails) throws DBException, DataException {
        System.out.println("Station " + JSONConversion.getLong(jsonstationdetails, "station_id"));
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
        java.lang.System.out.println("       " + station.getName());
        this.insertupdateStation(station);
    }

    /**
     * @param systemPK: foreign key for System
     * @return all Station Entity objects for System
     * @throws eve.general.exception.CustomException
     */
    public long getStations4systemcount(ISystemPK systemPK) throws CustomException {
        AbstractSQLMapper sqlmapper = entitymapper.resetSQLMapper("");
        BLRecordcount blrecordcount = new BLRecordcount(sqlmapper);
        ViewMapper viewmapper = new ViewMapper(sqlmapper);
        Recordcount recordcount = (Recordcount)viewmapper.loadView(blrecordcount, Station.SQLSelect4systemCount, systemPK.getKeyFields());
        return recordcount.getCount();
    }

    /**
     * try to insert Station object in database
     * commit transaction
     * @param station: Station Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    @Override
    public void insertStation(IStation station) throws DBException, DataException {
        trans_insertStation(station);
        super.Commit2DB();
    }
    
    /**
     * try to insert Station object in database
     * an alternative to insertStation, which can be made an empty function
     * commit transaction
     * @param station: Station Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void secureinsertStation(IStation station) throws DBException, DataException {
        trans_insertStation(station);
        super.Commit2DB();
    }
    
    /**
     * try to update Station object in database
     * commit transaction
     * @param station: Station Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    @Override
    public void updateStation(IStation station) throws DBException, DataException {
        trans_updateStation(station);
        super.Commit2DB();
    }
    
    /**
     * try to update Station object in database
     * an alternative to updateStation, which can be made an empty function
     * commit transaction
     * @param station: Station Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void secureupdateStation(IStation station) throws DBException, DataException {
        trans_updateStation(station);
        super.Commit2DB();
    }
    
    /**
     * try to delete Station object in database
     * commit transaction
     * @param station: Station Entity Object
     * @throws eve.general.exception.CustomException
     */
    @Override
    public void deleteStation(IStation station) throws DBException {
        trans_deleteStation(station);
        super.Commit2DB();
    }

    /**
     * try to delete Station object in database
     * an alternative to deleteStation, which can be made an empty function
     * commit transaction
     * @param station: Station Entity Object
     * @throws eve.general.exception.CustomException
     */
    public void securedeleteStation(IStation station) throws DBException {
        trans_deleteStation(station);
        super.Commit2DB();
    }

    /**
     * try to insert Station object in database
     * do not commit transaction
     * @param station: Station Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void trans_insertStation(IStation station) throws DBException, DataException {
        super.checkDATA(station);
        super.insertStation((Station)station);
    }
    
    /**
     * try to update Station object in database
     * do not commit transaction
     * @param station: Station Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void trans_updateStation(IStation station) throws DBException, DataException {
        super.checkDATA(station);
        super.updateStation((Station)station);
    }
    
    /**
     * try to delete Station object in database
     * do not commit transaction
     * @param station: Station Entity Object
     * @throws eve.general.exception.CustomException
     */
    public void trans_deleteStation(IStation station) throws DBException {
        super.deleteStation((Station)station);
    }
}
