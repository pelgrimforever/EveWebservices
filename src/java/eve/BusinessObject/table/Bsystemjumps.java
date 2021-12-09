/*
 * Bsystemjumps.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 9.11.2021 14:30
 *
 */

package eve.BusinessObject.table;

import BusinessObject.BLtable;
import general.exception.*;
import java.util.ArrayList;
import db.SQLMapperFactory;
import db.SQLparameters;
import data.gis.shape.*;
import data.json.piJson;
import data.json.psqlJsonobject;
import db.SQLMapper_pgsql;
import data.interfaces.db.Filedata;
import eve.BusinessObject.Logic.*;
import eve.conversion.json.JSONSystemjumps;
import eve.conversion.entity.EMsystemjumps;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.ISystemjumpssearch;
import eve.logicentity.Systemjumps;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Business Entity class Bsystemjumps
 *
 * Superclass for manipulating data- and database objects
 * for Entity Systemjumps and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bsystemjumps extends BLtable {

    /**
     * Constructor, sets Systemjumps as default Entity
     */
    public Bsystemjumps() {
        super(new Systemjumps(), new EMsystemjumps());
    }

    /**
     * Constructor, sets Systemjumps as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bsystemjumps(BLtable transactionobject) {
        super(transactionobject, new Systemjumps(), new EMsystemjumps());
    }

    /**
     * create new empty Systemjumps object
     * @return empty ISystemjumps
     */
    public ISystemjumps newSystemjumps() {
    	return new Systemjumps();
    }
    
    /**
     * create new empty Systemjumps object
     * create new primary key with given parameters
     * @param system_start primary key field
     * @param system_end primary key field
     * @return ISystemjumps with primary key
     */
    public ISystemjumps newSystemjumps(long system_start, long system_end) {
        return new Systemjumps(system_start, system_end);
    }

    /**
     * create new empty Systemjumps object with given primary key
     * @param systemjumpsPK: primary key for Systemjumps
     * @return ISystemjumps with primary key
     */
    public ISystemjumps newSystemjumps(ISystemjumpsPK systemjumpsPK) {
        return new Systemjumps((SystemjumpsPK)systemjumpsPK);
    }

    /**
     * create new empty primary key
     * @return empty SystemjumpsPK
     */
    public ISystemjumpsPK newSystemjumpsPK() {
        return new SystemjumpsPK();
    }

    /**
     * create new primary key with given parameters
     * @param system_start primary key field
     * @param system_end primary key field
     * @return new ISystemjumpsPK
     */
    public ISystemjumpsPK newSystemjumpsPK(long system_start, long system_end) {
        return new SystemjumpsPK(system_start, system_end);
    }

    /**
     * get all Systemjumps objects from database
     * @return ArrayList of Systemjumps objects
     * @throws DBException
     */
    public ArrayList<Systemjumps> getSystemjumpss() throws DBException {
        return (ArrayList<Systemjumps>)super.getEntities(EMsystemjumps.SQLSelectAll);
    }

    /**
     * search Systemjumps for primary key
     * @param systemjumpsPK: Systemjumps primary key
     * @return Systemjumps object
     * @throws DBException
     */
    public Systemjumps getSystemjumps(ISystemjumpsPK systemjumpsPK) throws DBException {
        return (Systemjumps)super.getEntity((SystemjumpsPK)systemjumpsPK);
    }

    /**
     * search systemjumps with ISystemjumpssearch parameters
     * @param search ISystemjumpssearch
     * @return ArrayList of Systemjumps
     * @throws DBException 
     */
    public ArrayList<Systemjumps> searchsystemjumpss(ISystemjumpssearch search) throws DBException {
        return (ArrayList<Systemjumps>)this.search(search);
    }

    /**
     * search systemjumps with ISystemjumpssearch parameters, order by orderby sql clause
     * @param search ISystemjumpssearch
     * @param orderby sql order by string
     * @return ArrayList of Systemjumps
     * @throws DBException 
     */
    public ArrayList<Systemjumps> searchsystemjumpss(ISystemjumpssearch search, String orderby) throws DBException {
        return (ArrayList<Systemjumps>)this.search(search, orderby);
    }

    /**
     * Search systemjumps in database for systemjumpsPK:
     * @param systemjumpsPK: Systemjumps Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getSystemjumpsExists(ISystemjumpsPK systemjumpsPK) throws DBException {
        return super.getEntityExists((SystemjumpsPK)systemjumpsPK);
    }

    /**
     * try to insert Systemjumps in database
     * @param systemjumps Systemjumps object
     * @throws DBException
     * @throws DataException
     */
    public void insertSystemjumps(ISystemjumps systemjumps) throws DBException, DataException {
        super.insertEntity(systemjumps);
    }

    /**
     * check if SystemjumpsPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param systemjumps Systemjumps object
     * @throws DBException
     * @throws DataException
     */
    public void insertupdateSystemjumps(ISystemjumps systemjumps) throws DBException, DataException {
        if(this.getSystemjumpsExists(systemjumps.getPrimaryKey())) {
            super.updateEntity(systemjumps);
        } else {
            super.insertEntity(systemjumps);
        }
    }

    /**
     * try to update Systemjumps in database
     * @param systemjumps Systemjumps object
     * @throws DBException
     * @throws DataException
     */
    public void updateSystemjumps(ISystemjumps systemjumps) throws DBException, DataException {
        super.updateEntity(systemjumps);
    }

    /**
     * try to delete Systemjumps in database
     * @param systemjumps Systemjumps object
     * @throws DBException
     */
    public void deleteSystemjumps(ISystemjumps systemjumps) throws DBException {
        cascadedeleteSystemjumps(systemjumps.getPrimaryKey());
        super.deleteEntity(systemjumps);
    }

    /**
     * check data rules in Systemjumps, throw DataException with customized message if rules do not apply
     * @param systemjumps Systemjumps object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(ISystemjumps systemjumps) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //foreign key Systemjumps.System_start - System.Id
        //foreign key Systemjumps.System_end - System.Id
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where systemjumpsPK is used in a primary key
     * @param systemjumpsPK: Systemjumps primary key
     */
    public void cascadedeleteSystemjumps(ISystemjumpsPK systemjumpsPK) {
    }

    /**
     * @param systemPK: foreign key for System
     * @delete all Systemjumps Entity objects for System in database
     */
    public void delete4systemSystem_end(ISystemPK systemPK) {
        super.addStatement(EMsystemjumps.SQLDelete4systemSystem_end, systemPK.getSQLprimarykey());
    }

    /**
     * @param systemPK: foreign key for System
     * @return all Systemjumps Entity objects for System
     * @throws CustomException
     */
    public ArrayList<Systemjumps> getSystemjumpss4systemSystem_end(ISystemPK systemPK) throws CustomException {
        return super.getEntities(EMsystemjumps.SQLSelect4systemSystem_end, systemPK.getSQLprimarykey());
    }
    /**
     * @param systemPK: foreign key for System
     * @delete all Systemjumps Entity objects for System in database
     */
    public void delete4systemSystem_start(ISystemPK systemPK) {
        super.addStatement(EMsystemjumps.SQLDelete4systemSystem_start, systemPK.getSQLprimarykey());
    }

    /**
     * @param systemPK: foreign key for System
     * @return all Systemjumps Entity objects for System
     * @throws CustomException
     */
    public ArrayList<Systemjumps> getSystemjumpss4systemSystem_start(ISystemPK systemPK) throws CustomException {
        return super.getEntities(EMsystemjumps.SQLSelect4systemSystem_start, systemPK.getSQLprimarykey());
    }

    /**
     * get all Systemjumps objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @param sortlist sql sort string
     * @param sortoperator asc/desc
     * @return ArrayList of Systemjumps objects
     * @throws DBException
     */
    public ArrayList<Systemjumps> getSystemjumpss(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMsystemjumps.SQLSelect);
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
        return (ArrayList<Systemjumps>)super.getEntities(sql.toString(), sqlparameters);
    }

    /**
     * delete all Systemjumps objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @throws DBException
     */
    public void delSystemjumps(SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Systemjumps.table);
        ArrayList<Object[]> parameters = sqlparameters.getParameters();
        int l = parameters.size();
        if(l>0) {
            sql.append(" where ");
            for(int i=0; i<l; i++) {
                sql.append(String.valueOf(parameters.get(i)[0])).append(" = :").append(String.valueOf(parameters.get(i)[0])).append(": ");
                if(i<l-1) sql.append(" ").append(andoroperator).append(" ");
            }
        }
        this.addStatement(sql.toString(), sqlparameters);
    }


}
