/*
 * Bsystem.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 8.10.2021 7:21
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
import eve.conversion.json.JSONSystem;
import eve.conversion.entity.EMsystem;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.ISystemsearch;
import eve.logicentity.System;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Business Entity class Bsystem
 *
 * Superclass for manipulating data- and database objects
 * for Entity System and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bsystem extends BLtable {

    /**
     * Constructor, sets System as default Entity
     */
    public Bsystem() {
        super(new System(), new EMsystem());
    }

    /**
     * Constructor, sets System as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bsystem(BLtable transactionobject) {
        super(transactionobject, new System(), new EMsystem());
    }

    /**
     * create new empty System object
     * @return empty ISystem
     */
    public ISystem newSystem() {
    	return new System();
    }
    
    /**
     * create new empty System object
     * create new primary key with given parameters
     * @param id primary key field
     * @return ISystem with primary key
     */
    public ISystem newSystem(long id) {
        return new System(id);
    }

    /**
     * create new empty System object with given primary key
     * @param systemPK: primary key for System
     * @return ISystem with primary key
     */
    public ISystem newSystem(ISystemPK systemPK) {
        return new System((SystemPK)systemPK);
    }

    /**
     * create new empty primary key
     * @return empty SystemPK
     */
    public ISystemPK newSystemPK() {
        return new SystemPK();
    }

    /**
     * create new primary key with given parameters
     * @param id primary key field
     * @return new ISystemPK
     */
    public ISystemPK newSystemPK(long id) {
        return new SystemPK(id);
    }

    /**
     * get all System objects from database
     * @return ArrayList of System objects
     * @throws DBException
     */
    public ArrayList<System> getSystems() throws DBException {
        return (ArrayList<System>)super.getEntities(EMsystem.SQLSelectAll);
    }

    /**
     * search System for primary key
     * @param systemPK: System primary key
     * @return System object
     * @throws DBException
     */
    public System getSystem(ISystemPK systemPK) throws DBException {
        return (System)super.getEntity((SystemPK)systemPK);
    }

    /**
     * search system with ISystemsearch parameters
     * @param search ISystemsearch
     * @return ArrayList of System
     * @throws DBException 
     */
    public ArrayList<System> searchsystems(ISystemsearch search) throws DBException {
        return (ArrayList<System>)this.search(search);
    }

    /**
     * search system with ISystemsearch parameters, order by orderby sql clause
     * @param search ISystemsearch
     * @param orderby sql order by string
     * @return ArrayList of System
     * @throws DBException 
     */
    public ArrayList<System> searchsystems(ISystemsearch search, String orderby) throws DBException {
        return (ArrayList<System>)this.search(search, orderby);
    }

    /**
     * Search system in database for systemPK:
     * @param systemPK: System Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getSystemExists(ISystemPK systemPK) throws DBException {
        return super.getEntityExists((SystemPK)systemPK);
    }

    /**
     * try to insert System in database
     * @param system System object
     * @throws DBException
     * @throws DataException
     */
    public void insertSystem(ISystem system) throws DBException, DataException {
        super.insertEntity(system);
    }

    /**
     * check if SystemPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param system System object
     * @throws DBException
     * @throws DataException
     */
    public void insertupdateSystem(ISystem system) throws DBException, DataException {
        if(this.getSystemExists(system.getPrimaryKey())) {
            super.updateEntity(system);
        } else {
            super.insertEntity(system);
        }
    }

    /**
     * try to update System in database
     * @param system System object
     * @throws DBException
     * @throws DataException
     */
    public void updateSystem(ISystem system) throws DBException, DataException {
        super.updateEntity(system);
    }

    /**
     * try to delete System in database
     * @param system System object
     * @throws DBException
     */
    public void deleteSystem(ISystem system) throws DBException {
        cascadedeleteSystem(system.getPrimaryKey());
        super.deleteEntity(system);
    }

    /**
     * check data rules in System, throw DataException with customized message if rules do not apply
     * @param system System object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(ISystem system) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        if(system.getName()!=null && system.getName().length()>ISystem.SIZE_NAME) {
            message.append("Name is langer dan toegestaan. Max aantal karakters: ").append(ISystem.SIZE_NAME).append("\n");
        }
        if(system.getName()==null) {
            message.append("Name mag niet leeg zijn.\n");
        }
        if(system.getSecurity_class()!=null && system.getSecurity_class().length()>ISystem.SIZE_SECURITY_CLASS) {
            message.append("Security_class is langer dan toegestaan. Max aantal karakters: ").append(ISystem.SIZE_SECURITY_CLASS).append("\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where systemPK is used in a primary key
     * @param systemPK: System primary key
     */
    public void cascadedeleteSystem(ISystemPK systemPK) {
        BLsystemjumps blsystemjumpsSystem_end = new BLsystemjumps(this);
        blsystemjumpsSystem_end.delete4systemSystem_end(systemPK);
        BLsystemjumps blsystemjumpsSystem_start = new BLsystemjumps(this);
        blsystemjumpsSystem_start.delete4systemSystem_start(systemPK);
        BLroute blroute = new BLroute(this);
        blroute.delete4system(systemPK);
        BLsystemtrade blsystemtradeSell_system = new BLsystemtrade(this);
        blsystemtradeSell_system.delete4systemSell_system(systemPK);
        BLsystemtrade blsystemtradeBuy_system = new BLsystemtrade(this);
        blsystemtradeBuy_system.delete4systemBuy_system(systemPK);
    }

    /**
     * @param security_islandPK: foreign key for Security_island
     * @delete all System Entity objects for Security_island in database
     */
    public void delete4security_island(ISecurity_islandPK security_islandPK) {
        super.addStatement(EMsystem.SQLDelete4security_island, security_islandPK.getSQLprimarykey());
    }

    /**
     * @param security_islandPK: foreign key for Security_island
     * @return all System Entity objects for Security_island
     * @throws CustomException
     */
    public ArrayList<System> getSystems4security_island(ISecurity_islandPK security_islandPK) throws CustomException {
        return super.getEntities(EMsystem.SQLSelect4security_island, security_islandPK.getSQLprimarykey());
    }
    /**
     * @param constellationPK: foreign key for Constellation
     * @delete all System Entity objects for Constellation in database
     */
    public void delete4constellation(IConstellationPK constellationPK) {
        super.addStatement(EMsystem.SQLDelete4constellation, constellationPK.getSQLprimarykey());
    }

    /**
     * @param constellationPK: foreign key for Constellation
     * @return all System Entity objects for Constellation
     * @throws CustomException
     */
    public ArrayList<System> getSystems4constellation(IConstellationPK constellationPK) throws CustomException {
        return super.getEntities(EMsystem.SQLSelect4constellation, constellationPK.getSQLprimarykey());
    }
    /**
     * @param systemjumpsPK: parent Systemjumps for child object System Entity
     * @return child System Entity object
     * @throws CustomException
     */
    public System getSystemjumpssystem_end(ISystemjumpsPK systemjumpsPK) throws CustomException {
        SystemPK systemPK = new SystemPK(systemjumpsPK.getSystem_end());
        return this.getSystem(systemPK);
    }

    /**
     * @param systemjumpsPK: parent Systemjumps for child object System Entity
     * @return child System Entity object
     * @throws CustomException
     */
    public System getSystemjumpssystem_start(ISystemjumpsPK systemjumpsPK) throws CustomException {
        SystemPK systemPK = new SystemPK(systemjumpsPK.getSystem_start());
        return this.getSystem(systemPK);
    }

    /**
     * @param routePK: parent Route for child object System Entity
     * @return child System Entity object
     * @throws CustomException
     */
    public System getRoute(IRoutePK routePK) throws CustomException {
        SystemPK systemPK = new SystemPK(routePK.getSystem());
        return this.getSystem(systemPK);
    }

    /**
     * @param systemtradePK: parent Systemtrade for child object System Entity
     * @return child System Entity object
     * @throws CustomException
     */
    public System getSystemtradesell_system(ISystemtradePK systemtradePK) throws CustomException {
        SystemPK systemPK = new SystemPK(systemtradePK.getSell_system());
        return this.getSystem(systemPK);
    }

    /**
     * @param systemtradePK: parent Systemtrade for child object System Entity
     * @return child System Entity object
     * @throws CustomException
     */
    public System getSystemtradebuy_system(ISystemtradePK systemtradePK) throws CustomException {
        SystemPK systemPK = new SystemPK(systemtradePK.getBuy_system());
        return this.getSystem(systemPK);
    }


    /**
     * get all System objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @param sortlist sql sort string
     * @param sortoperator asc/desc
     * @return ArrayList of System objects
     * @throws DBException
     */
    public ArrayList<System> getSystems(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMsystem.SQLSelect);
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
        return (ArrayList<System>)super.getEntities(sql.toString(), sqlparameters);
    }

    /**
     * delete all System objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @throws DBException
     */
    public void delSystem(SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(System.table);
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
