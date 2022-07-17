/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 17.6.2022 13:4
 */

package eve.BusinessObject.table;

import general.exception.*;
import java.util.ArrayList;
import db.*;
import data.interfaces.db.*;
import eve.conversion.entity.EMlocation;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.ILocationsearch;
import eve.logicentity.Location;

/**
 * @author Franky Laseure
 */
public abstract class Blocation extends TableBusinessrules {

    public Blocation(SQLreader sqlreader) {
        super(new TableIO(sqlreader, new EMlocation()));
    }

    public Blocation(TableBusinessrules businessrules) {
        super(new TableIO(businessrules.getTableio(), new EMlocation()));
        this.tableio.setAuthenticated(tableio!=null && tableio.isAuthenticated());
    }

    public ILocation newLocation() {
    	return new Location();
    }
    
    public ILocation newLocation(long id) {
        return new Location(id);
    }

    public ILocation newLocation(ILocationPK locationPK) {
        return new Location((LocationPK)locationPK);
    }

    public ILocationPK newLocationPK() {
        return new LocationPK();
    }

    public ILocationPK newLocationPK(long id) {
        return new LocationPK(id);
    }

    public ArrayList<Location> getLocations() throws DBException {
        return (ArrayList<Location>)tableio.getEntities(EMlocation.SQLSelectAll);
    }

    public Location getLocation(ILocationPK locationPK) throws DBException {
        return (Location)tableio.getEntity((LocationPK)locationPK);
    }

    public ArrayList<Location> searchlocations(ILocationsearch search) throws DBException {
        return (ArrayList<Location>)tableio.search(search);
    }

    public ArrayList<Location> searchlocations(ILocationsearch search, String orderby) throws DBException {
        return (ArrayList<Location>)tableio.search(search, orderby);
    }

    public boolean getLocationExists(ILocationPK locationPK) throws DBException {
        return tableio.getEntityExists((LocationPK)locationPK);
    }

    public Location getEntity(String sql) throws DBException {
        return (Location)tableio.getEntity(sql);
    }
    
    public Location getEntity(String sql, SQLparameters parameters) throws DBException {
        return (Location)tableio.getEntity(sql, parameters);
    }
    
    public ArrayList<Location> getEntities(String sql) throws DBException {
        return tableio.getEntities(sql);
    }
    
    public ArrayList<Location> getEntities(String sql, SQLparameters parameters) throws DBException {
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

    public ArrayList<Location> search(Tablesearcher search) throws DBException {
        return tableio.search(search);
    }

    public ArrayList<Location> search(Tablesearcher search, String orderby) throws DBException {
        return tableio.search(search, orderby);
    }

    public long searchcount(Tablesearcher search) throws DBException {
        return tableio.searchcount(search);
    }

    public void insertLocation(SQLTqueue transactionqueue, ILocation location) throws DBException, DataException {
        tableio.insertEntity(transactionqueue, location);
    }

    public void insertupdateLocation(SQLTqueue transactionqueue, ILocation location) throws DBException, DataException {
    	checkDATA(location);
        if(this.getLocationExists(location.getPrimaryKey())) {
            tableio.updateEntity(transactionqueue, location);
        } else {
            tableio.insertEntity(transactionqueue, location);
        }
    }

    public void updateLocation(SQLTqueue transactionqueue, ILocation location) throws DBException, DataException {
    	checkDATA(location);
        tableio.updateEntity(transactionqueue, location);
    }

    public void deleteLocation(SQLTqueue transactionqueue, ILocation location) throws DBException {
        cascadedeleteLocation(transactionqueue, location.getPrimaryKey());
        tableio.deleteEntity(transactionqueue, location);
    }

    private void checkDATA(ILocation location) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        if(location.getName()!=null && location.getName().length()>ILocation.SIZE_NAME) {
            message.append("Name is langer dan toegestaan. Max aantal karakters: ").append(ILocation.SIZE_NAME).append("\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where locationPK is used in a primary key
     * @param locationPK: Location primary key
     */
    public void cascadedeleteLocation(SQLTqueue transactionqueue, ILocationPK locationPK) {
    }

    public void delete4system(SQLTqueue transactionqueue, ISystemPK systemPK) {
        tableio.addStatement(transactionqueue, EMlocation.SQLDelete4system, systemPK.getSQLprimarykey());
    }

    public ArrayList<Location> getLocations4system(ISystemPK systemPK) throws CustomException {
        return tableio.getEntities(EMlocation.SQLSelect4system, systemPK.getSQLprimarykey());
    }

    public ArrayList<Location> getLocations(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMlocation.SQLSelect);
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
        return (ArrayList<Location>)tableio.getEntities(sql.toString(), sqlparameters);
    }

    public void delLocation(SQLTqueue transactionqueue, SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Location.table);
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
