/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */

package eve.BusinessObject.table;

import general.exception.*;
import java.util.ArrayList;
import db.*;
import data.interfaces.db.*;
import eve.conversion.entity.EMstation_service;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.IStation_servicesearch;
import eve.logicentity.Station_service;

public abstract class Bstation_service extends TableBusinessrules {

    public Bstation_service(SQLreader sqlreader) {
        super(new TableIO(sqlreader, new EMstation_service()));
    }

    public Bstation_service(TableBusinessrules businessrules) {
        super(new TableIO(businessrules.getTableio(), new EMstation_service()));
        this.tableio.setAuthenticated(tableio!=null && tableio.isAuthenticated());
    }

    public IStation_service newStation_service() {
    	return new Station_service();
    }
    
    public IStation_service newStation_service(long station, java.lang.String service) {
        return new Station_service(station, service);
    }

    public IStation_service newStation_service(IStation_servicePK station_servicePK) {
        return new Station_service((Station_servicePK)station_servicePK);
    }

    public IStation_servicePK newStation_servicePK() {
        return new Station_servicePK();
    }

    public IStation_servicePK newStation_servicePK(long station, java.lang.String service) {
        return new Station_servicePK(station, service);
    }

    public ArrayList<Station_service> getStation_services() throws DBException {
        return (ArrayList<Station_service>)tableio.getEntities(EMstation_service.SQLSelectAll);
    }

    public Station_service getStation_service(IStation_servicePK station_servicePK) throws DBException {
        return (Station_service)tableio.getEntity((Station_servicePK)station_servicePK);
    }

    public ArrayList<Station_service> searchstation_services(IStation_servicesearch search) throws DBException {
        return (ArrayList<Station_service>)tableio.search(search);
    }

    public ArrayList<Station_service> searchstation_services(IStation_servicesearch search, String orderby) throws DBException {
        return (ArrayList<Station_service>)tableio.search(search, orderby);
    }

    public boolean getStation_serviceExists(IStation_servicePK station_servicePK) throws DBException {
        return tableio.getEntityExists((Station_servicePK)station_servicePK);
    }

    public Station_service getEntity(String sql) throws DBException {
        return (Station_service)tableio.getEntity(sql);
    }
    
    public Station_service getEntity(String sql, SQLparameters parameters) throws DBException {
        return (Station_service)tableio.getEntity(sql, parameters);
    }
    
    public ArrayList<Station_service> getEntities(String sql) throws DBException {
        return tableio.getEntities(sql);
    }
    
    public ArrayList<Station_service> getEntities(String sql, SQLparameters parameters) throws DBException {
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

    public ArrayList<Station_service> search(Tablesearcher search) throws DBException {
        return tableio.search(search);
    }

    public ArrayList<Station_service> search(Tablesearcher search, String orderby) throws DBException {
        return tableio.search(search, orderby);
    }

    public long searchcount(Tablesearcher search) throws DBException {
        return tableio.searchcount(search);
    }

    public void insertStation_service(SQLTqueue transactionqueue, IStation_service station_service) throws DBException, DataException {
        tableio.insertEntity(transactionqueue, station_service);
    }

    public void insertupdateStation_service(SQLTqueue transactionqueue, IStation_service station_service) throws DBException, DataException {
    	checkDATA(station_service);
        if(this.getStation_serviceExists(station_service.getPrimaryKey())) {
            tableio.updateEntity(transactionqueue, station_service);
        } else {
            tableio.insertEntity(transactionqueue, station_service);
        }
    }

    public void updateStation_service(SQLTqueue transactionqueue, IStation_service station_service) throws DBException, DataException {
    	checkDATA(station_service);
        tableio.updateEntity(transactionqueue, station_service);
    }

    public void deleteStation_service(SQLTqueue transactionqueue, IStation_service station_service) throws DBException {
        cascadedeleteStation_service(transactionqueue, station_service.getPrimaryKey());
        tableio.deleteEntity(transactionqueue, station_service);
    }

    private void checkDATA(IStation_service station_service) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //foreign key Station_service.Station - Station.Id
        //Primary key
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    public void cascadedeleteStation_service(SQLTqueue transactionqueue, IStation_servicePK station_servicePK) {
    }

    public void delete4station(SQLTqueue transactionqueue, IStationPK stationPK) {
        tableio.addStatement(transactionqueue, EMstation_service.SQLDelete4station, stationPK.getSQLprimarykey());
    }

    public ArrayList<Station_service> getStation_services4station(IStationPK stationPK) throws CustomException {
        return tableio.getEntities(EMstation_service.SQLSelect4station, stationPK.getSQLprimarykey());
    }

    public ArrayList<Station_service> getStation_services(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMstation_service.SQLSelect);
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
        return (ArrayList<Station_service>)tableio.getEntities(sql.toString(), sqlparameters);
    }

    public void delStation_service(SQLTqueue transactionqueue, SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Station_service.table);
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
