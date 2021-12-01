/*
 * BLstation_service.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 8.4.2021 13:20
 *
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import eve.interfaces.logicentity.IStation_service;
import eve.logicentity.Station_service;
import BusinessObject.BLtable;
import eve.BusinessObject.table.Bstation_service;
import eve.entity.pk.StationPK;
import eve.entity.pk.Station_servicePK;
import general.exception.DataException;

/**
 * Business Logic Entity class BLstation_service
 *
 * Class for manipulating data- and database objects
 * for Entity Station_service and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLstation_service extends Bstation_service {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    /**
     * Constructor, sets Station_service as default Entity
     */
    public BLstation_service() {
        this.setLogginrequired(isprivatetable);
    }

    /**
     * Constructor, sets Station_service as default Entity
     * sets transaction queue from given GeneralObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralObjects that holds the transaction queue
     */
    public BLstation_service(BLtable transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }

    public void updateStation_service(StationPK stationpk, String service) throws DBException, DataException {
        Station_servicePK stationservicepk = new Station_servicePK();
        stationservicepk.setStationPK(stationpk);
        stationservicepk.setService(service);
        Station_service stationservice = new Station_service(stationservicepk);
        this.insertupdateStation_service(stationservice);
    }
    /**
     * try to insert Station_service object in database
     * commit transaction
     * @param station_service: Station_service Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    @Override
    public void insertStation_service(IStation_service station_service) throws DBException, DataException {
        trans_insertStation_service(station_service);
        super.Commit2DB();
    }
    
    /**
     * try to insert Station_service object in database
     * an alternative to insertStation_service, which can be made an empty function
     * commit transaction
     * @param station_service: Station_service Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void secureinsertStation_service(IStation_service station_service) throws DBException, DataException {
        trans_insertStation_service(station_service);
        super.Commit2DB();
    }
    
    /**
     * try to update Station_service object in database
     * commit transaction
     * @param station_service: Station_service Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    @Override
    public void updateStation_service(IStation_service station_service) throws DBException, DataException {
        trans_updateStation_service(station_service);
        super.Commit2DB();
    }
    
    /**
     * try to update Station_service object in database
     * an alternative to updateStation_service, which can be made an empty function
     * commit transaction
     * @param station_service: Station_service Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void secureupdateStation_service(IStation_service station_service) throws DBException, DataException {
        trans_updateStation_service(station_service);
        super.Commit2DB();
    }
    
    /**
     * try to delete Station_service object in database
     * commit transaction
     * @param station_service: Station_service Entity Object
     * @throws eve.general.exception.CustomException
     */
    @Override
    public void deleteStation_service(IStation_service station_service) throws DBException {
        trans_deleteStation_service(station_service);
        super.Commit2DB();
    }

    /**
     * try to delete Station_service object in database
     * an alternative to deleteStation_service, which can be made an empty function
     * commit transaction
     * @param station_service: Station_service Entity Object
     * @throws eve.general.exception.CustomException
     */
    public void securedeleteStation_service(IStation_service station_service) throws DBException {
        trans_deleteStation_service(station_service);
        super.Commit2DB();
    }

    /**
     * try to insert Station_service object in database
     * do not commit transaction
     * @param station_service: Station_service Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void trans_insertStation_service(IStation_service station_service) throws DBException, DataException {
        super.checkDATA(station_service);
        super.insertStation_service((Station_service)station_service);
    }
    
    /**
     * try to update Station_service object in database
     * do not commit transaction
     * @param station_service: Station_service Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void trans_updateStation_service(IStation_service station_service) throws DBException, DataException {
        super.checkDATA(station_service);
        super.updateStation_service((Station_service)station_service);
    }
    
    /**
     * try to delete Station_service object in database
     * do not commit transaction
     * @param station_service: Station_service Entity Object
     * @throws eve.general.exception.CustomException
     */
    public void trans_deleteStation_service(IStation_service station_service) throws DBException {
        super.deleteStation_service((Station_service)station_service);
    }
}
