/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 8.4.2021 13:20
 * @author Franky Laseure
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import eve.interfaces.logicentity.IStation_service;
import eve.logicentity.Station_service;
import db.*;
import db.SQLTqueue;
import eve.BusinessObject.table.Bstation_service;
import eve.entity.pk.StationPK;
import eve.entity.pk.Station_servicePK;
import general.exception.DataException;

public class BLstation_service extends Bstation_service {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    public BLstation_service(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(true);
    }

    public BLstation_service(TableBusinessrules businessrules) {
        super(businessrules);
        tableio.setLogginrequired(isprivatetable);
    }

    public void updateStation_service(SQLTqueue transactionqueue, StationPK stationpk, String service) throws DBException, DataException {
        Station_servicePK stationservicepk = new Station_servicePK();
        stationservicepk.setStationPK(stationpk);
        stationservicepk.setService(service);
        Station_service stationservice = new Station_service(stationservicepk);
        this.insertupdateStation_service(transactionqueue, stationservice);
    }

}
