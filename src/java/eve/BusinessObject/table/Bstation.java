/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 17.6.2022 13:4
 */

package eve.BusinessObject.table;

import general.exception.*;
import java.util.ArrayList;
import db.*;
import data.interfaces.db.*;
import eve.conversion.entity.EMstation;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.IStationsearch;
import eve.logicentity.Station;

/**
 * @author Franky Laseure
 */
public abstract class Bstation extends TableBusinessrules {

    public Bstation(SQLreader sqlreader) {
        super(new TableIO(sqlreader, new EMstation()));
    }

    public Bstation(TableBusinessrules businessrules) {
        super(new TableIO(businessrules.getTableio(), new EMstation()));
        this.tableio.setAuthenticated(tableio!=null && tableio.isAuthenticated());
    }

    public IStation newStation() {
    	return new Station();
    }
    
    public IStation newStation(long id) {
        return new Station(id);
    }

    public IStation newStation(IStationPK stationPK) {
        return new Station((StationPK)stationPK);
    }

    public IStationPK newStationPK() {
        return new StationPK();
    }

    public IStationPK newStationPK(long id) {
        return new StationPK(id);
    }

    public ArrayList<Station> getStations() throws DBException {
        return (ArrayList<Station>)tableio.getEntities(EMstation.SQLSelectAll);
    }

    public Station getStation(IStationPK stationPK) throws DBException {
        return (Station)tableio.getEntity((StationPK)stationPK);
    }

    public ArrayList<Station> searchstations(IStationsearch search) throws DBException {
        return (ArrayList<Station>)tableio.search(search);
    }

    public ArrayList<Station> searchstations(IStationsearch search, String orderby) throws DBException {
        return (ArrayList<Station>)tableio.search(search, orderby);
    }

    public boolean getStationExists(IStationPK stationPK) throws DBException {
        return tableio.getEntityExists((StationPK)stationPK);
    }

    public Station getEntity(String sql) throws DBException {
        return (Station)tableio.getEntity(sql);
    }
    
    public Station getEntity(String sql, SQLparameters parameters) throws DBException {
        return (Station)tableio.getEntity(sql, parameters);
    }
    
    public ArrayList<Station> getEntities(String sql) throws DBException {
        return tableio.getEntities(sql);
    }
    
    public ArrayList<Station> getEntities(String sql, SQLparameters parameters) throws DBException {
        return tableio.getEntities(sql, parameters);
    }

    public long count() throws DBException {
        long count = 0;
        if(tableio.isReadAllowed())
            count = tableio.count();
        return count;
    }
    
    public long count(String sql, SQLparameters parameters) throws DBException {
        long count = 0;
        if(tableio.isReadAllowed())
            count = tableio.count();
        return count;
    }

    public ArrayList<Station> search(Tablesearcher search) throws DBException {
        return tableio.search(search);
    }

    public ArrayList<Station> search(Tablesearcher search, String orderby) throws DBException {
        return tableio.search(search, orderby);
    }

    public long searchcount(Tablesearcher search) throws DBException {
        return tableio.searchcount(search);
    }

    public void insertStation(SQLTqueue transactionqueue, IStation station) throws DBException, DataException {
        tableio.insertEntity(transactionqueue, station);
    }

    public void insertupdateStation(SQLTqueue transactionqueue, IStation station) throws DBException, DataException {
    	checkDATA(station);
        if(this.getStationExists(station.getPrimaryKey())) {
            tableio.updateEntity(transactionqueue, station);
        } else {
            tableio.insertEntity(transactionqueue, station);
        }
    }

    public void updateStation(SQLTqueue transactionqueue, IStation station) throws DBException, DataException {
    	checkDATA(station);
        tableio.updateEntity(transactionqueue, station);
    }

    public void deleteStation(SQLTqueue transactionqueue, IStation station) throws DBException {
        cascadedeleteStation(transactionqueue, station.getPrimaryKey());
        tableio.deleteEntity(transactionqueue, station);
    }

    private void checkDATA(IStation station) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        if(station.getName()!=null && station.getName().length()>IStation.SIZE_NAME) {
            message.append("Name is langer dan toegestaan. Max aantal karakters: ").append(IStation.SIZE_NAME).append("\n");
        }
        if(station.getName()==null) {
            message.append("Name mag niet leeg zijn.\n");
        }
        if(station.getDownloaddate()==null) {
            message.append("Downloaddate mag niet leeg zijn.\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where stationPK is used in a primary key
     * @param stationPK: Station primary key
     */
    public void cascadedeleteStation(SQLTqueue transactionqueue, IStationPK stationPK) {
        BLstation_service blstation_service = new BLstation_service(this);
        blstation_service.setAuthenticated(isAuthenticated());
        blstation_service.delete4station(transactionqueue, stationPK);
    }

    public void delete4race(SQLTqueue transactionqueue, IRacePK racePK) {
        tableio.addStatement(transactionqueue, EMstation.SQLDelete4race, racePK.getSQLprimarykey());
    }

    public ArrayList<Station> getStations4race(IRacePK racePK) throws CustomException {
        return tableio.getEntities(EMstation.SQLSelect4race, racePK.getSQLprimarykey());
    }
    public void delete4evetype(SQLTqueue transactionqueue, IEvetypePK evetypePK) {
        tableio.addStatement(transactionqueue, EMstation.SQLDelete4evetype, evetypePK.getSQLprimarykey());
    }

    public ArrayList<Station> getStations4evetype(IEvetypePK evetypePK) throws CustomException {
        return tableio.getEntities(EMstation.SQLSelect4evetype, evetypePK.getSQLprimarykey());
    }
    public void delete4system(SQLTqueue transactionqueue, ISystemPK systemPK) {
        tableio.addStatement(transactionqueue, EMstation.SQLDelete4system, systemPK.getSQLprimarykey());
    }

    public ArrayList<Station> getStations4system(ISystemPK systemPK) throws CustomException {
        return tableio.getEntities(EMstation.SQLSelect4system, systemPK.getSQLprimarykey());
    }
    public Station getStation_service(IStation_servicePK station_servicePK) throws CustomException {
        StationPK stationPK = new StationPK(station_servicePK.getStation());
        return this.getStation(stationPK);
    }


    public ArrayList<Station> getStations(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMstation.SQLSelect);
        ArrayList<Object[]> parameters = sqlparameters.getParameters();
        int l = parameters.size();
        if(l>0) {
            sql.append(" where ");
            for(int i=0; i<l; i++) {
                sql.append(String.valueOf(parameters.get(i)[0])).append(" = :").append(String.valueOf(parameters.get(i)[0])).append(": ");
                if(i<l-1) sql.append(" ").append(andoroperator).append(" ");
            }
        }
        if(sortlist.length()>0) {
            sql.append(" order by ").append(sortlist).append(" ").append(sortoperator);
        }
        return (ArrayList<Station>)tableio.getEntities(sql.toString(), sqlparameters);
    }

    public void delStation(SQLTqueue transactionqueue, SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Station.table);
        ArrayList<Object[]> parameters = sqlparameters.getParameters();
        int l = parameters.size();
        if(l>0) {
            sql.append(" where ");
            for(int i=0; i<l; i++) {
                sql.append(String.valueOf(parameters.get(i)[0])).append(" = :").append(String.valueOf(parameters.get(i)[0])).append(": ");
                if(i<l-1) sql.append(" ").append(andoroperator).append(" ");
            }
        }
        tableio.addStatement(transactionqueue, sql.toString(), sqlparameters);
    }


}
