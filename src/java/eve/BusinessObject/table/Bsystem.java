/*
 * Bsystem.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 6.9.2021 16:29
 *
 */

package eve.BusinessObject.table;

import BusinessObject.GeneralEntityInterface;
import BusinessObject.GeneralEntityObject;
import general.exception.*;
import java.util.ArrayList;

import data.gis.shape.*;
import data.json.piJson;
import data.json.psqlJsonobject;
import db.SQLMapper_pgsql;
import data.interfaces.db.Filedata;
import eve.BusinessObject.Logic.*;
import eve.conversion.json.JSONSystem;
import eve.data.ProjectConstants;
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
public abstract class Bsystem extends GeneralEntityObject implements ProjectConstants {

    /**
     * Constructor, sets System as default Entity
     */
    public Bsystem() {
        super(new SQLMapper_pgsql(connectionpool, "System"), new System());
    }

    /**
     * Constructor, sets System as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bsystem(GeneralEntityInterface transactionobject) {
        super(transactionobject, new System());
    }

    /**
     * Map ResultSet Field values to System
     * @param dbresult: Database ResultSet
     */
    public System mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        SystemPK systemPK = null;
        System system;
        if(dbresult==null) {
            system = new System(systemPK);
        } else {
            try {
                systemPK = new SystemPK(dbresult.getLong("id"));
                system = new System(systemPK);
                system.initSecurity_islandPK(new Security_islandPK(dbresult.getLong("security_island")));
                if(dbresult.wasNull()) system.setSecurity_islandPK(null);                
                system.initConstellationPK(new ConstellationPK(dbresult.getLong("constellation")));
                if(dbresult.wasNull()) system.setConstellationPK(null);                
                system.initName(dbresult.getString("name"));
                system.initSecurity_class(dbresult.getString("security_class"));
                system.initSecurity_status(dbresult.getDouble("security_status"));
                system.initStar_id(dbresult.getLong("star_id"));
                system.initNoaccess(dbresult.getBoolean("noaccess"));
                system.initIsconstellationborder(dbresult.getBoolean("isconstellationborder"));
                system.initIsregionborder(dbresult.getBoolean("isregionborder"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        this.loadExtra(dbresult, system);
        return system;
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
    public ArrayList getSystems() throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, System.SQLSelectAll);
        } else return new ArrayList();
    }

    /**
     * search System for primary key
     * @param systemPK: System primary key
     * @return System object
     * @throws DBException
     */
    public System getSystem(ISystemPK systemPK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return (System)super.getEntity((SystemPK)systemPK);
        } else return null;
    }

    public ArrayList searchsystems(ISystemsearch search) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return this.search(search);
        } else return new ArrayList();
    }

    public ArrayList searchsystems(ISystemsearch search, String orderby) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return this.search(search, orderby);
        } else return new ArrayList();
    }

    /**
     * Search system in database for systemPK:
     * @param systemPK: System Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getSystemExists(ISystemPK systemPK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return super.getEntityExists((SystemPK)systemPK);
        } else return false;
    }

    /**
     * try to insert System in database
     * @param film: System object
     * @throws DBException
     */
    public void insertSystem(ISystem system) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.insertEntity(system);










        }
    }

    /**
     * check if SystemPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param film: System object
     * @throws DBException
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
     * @param film: System object
     * @throws DBException
     */
    public void updateSystem(ISystem system) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.updateEntity(system);










        }
    }

    /**
     * try to delete System in database
     * @param film: System object
     * @throws DBException
     */
    public void deleteSystem(ISystem system) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            cascadedeleteSystem(system.getOwnerobject(), system.getPrimaryKey());
            super.deleteEntity(system);
        }
    }

    /**
     * check data rules in System, throw DataException with customized message if rules do not apply
     * @param film: System object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(ISystem system) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key




        if(system.getName()!=null && system.getName().length()>ISystem.SIZE_NAME) {
            message.append("Name is langer dan toegestaan. Max aantal karakters: " + ISystem.SIZE_NAME + "\n");
        }

        if(system.getName()==null) {
            message.append("Name mag niet leeg zijn.\n");
        }
        if(system.getSecurity_class()!=null && system.getSecurity_class().length()>ISystem.SIZE_SECURITY_CLASS) {
            message.append("Security_class is langer dan toegestaan. Max aantal karakters: " + ISystem.SIZE_SECURITY_CLASS + "\n");
        }






        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where systemPK is used in a primary key
     * @param systemPK: System primary key
     */
    public void cascadedeleteSystem(String senderobject, ISystemPK systemPK) {
        BLsystemjumps blsystemjumpsSystem_end = new BLsystemjumps(this);
        blsystemjumpsSystem_end.delete4systemSystem_end(senderobject, systemPK);
        BLsystemjumps blsystemjumpsSystem_start = new BLsystemjumps(this);
        blsystemjumpsSystem_start.delete4systemSystem_start(senderobject, systemPK);
        BLroute blroute = new BLroute(this);
        blroute.delete4system(senderobject, systemPK);
        BLsystemtrade blsystemtradeSell_system = new BLsystemtrade(this);
        blsystemtradeSell_system.delete4systemSell_system(senderobject, systemPK);
        BLsystemtrade blsystemtradeBuy_system = new BLsystemtrade(this);
        blsystemtradeBuy_system.delete4systemBuy_system(senderobject, systemPK);
    }

    /**
     * @param security_islandPK: foreign key for Security_island
     * @delete all System Entity objects for Security_island in database
     * @throws eve.general.exception.CustomException
     */
    public void delete4security_island(String senderobject, ISecurity_islandPK security_islandPK) {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.addStatement(senderobject, System.SQLDelete4security_island, security_islandPK.getKeyFields());
        }
    }

    /**
     * @param security_islandPK: foreign key for Security_island
     * @return all System Entity objects for Security_island
     * @throws eve.general.exception.CustomException
     */
    public ArrayList getSystems4security_island(ISecurity_islandPK security_islandPK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, System.SQLSelect4security_island, security_islandPK.getKeyFields());
        } else return new ArrayList();
    }
    /**
     * @param constellationPK: foreign key for Constellation
     * @delete all System Entity objects for Constellation in database
     * @throws eve.general.exception.CustomException
     */
    public void delete4constellation(String senderobject, IConstellationPK constellationPK) {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.addStatement(senderobject, System.SQLDelete4constellation, constellationPK.getKeyFields());
        }
    }

    /**
     * @param constellationPK: foreign key for Constellation
     * @return all System Entity objects for Constellation
     * @throws eve.general.exception.CustomException
     */
    public ArrayList getSystems4constellation(IConstellationPK constellationPK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, System.SQLSelect4constellation, constellationPK.getKeyFields());
        } else return new ArrayList();
    }
    /**
     * @param systemjumpsPK: parent Systemjumps for child object System Entity
     * @return child System Entity object
     * @throws eve.general.exception.CustomException
     */
    public ISystem getSystemjumpssystem_end(ISystemjumpsPK systemjumpsPK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            SystemPK systemPK = new SystemPK(systemjumpsPK.getSystem_end());
            return this.getSystem(systemPK);
        } else return null;
    }

    /**
     * @param systemjumpsPK: parent Systemjumps for child object System Entity
     * @return child System Entity object
     * @throws eve.general.exception.CustomException
     */
    public ISystem getSystemjumpssystem_start(ISystemjumpsPK systemjumpsPK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            SystemPK systemPK = new SystemPK(systemjumpsPK.getSystem_start());
            return this.getSystem(systemPK);
        } else return null;
    }

    /**
     * @param routePK: parent Route for child object System Entity
     * @return child System Entity object
     * @throws eve.general.exception.CustomException
     */
    public ISystem getRoute(IRoutePK routePK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            SystemPK systemPK = new SystemPK(routePK.getSystem());
            return this.getSystem(systemPK);
        } else return null;
    }

    /**
     * @param systemtradePK: parent Systemtrade for child object System Entity
     * @return child System Entity object
     * @throws eve.general.exception.CustomException
     */
    public ISystem getSystemtradesell_system(ISystemtradePK systemtradePK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            SystemPK systemPK = new SystemPK(systemtradePK.getSell_system());
            return this.getSystem(systemPK);
        } else return null;
    }

    /**
     * @param systemtradePK: parent Systemtrade for child object System Entity
     * @return child System Entity object
     * @throws eve.general.exception.CustomException
     */
    public ISystem getSystemtradebuy_system(ISystemtradePK systemtradePK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            SystemPK systemPK = new SystemPK(systemtradePK.getBuy_system());
            return this.getSystem(systemPK);
        } else return null;
    }


    /**
     * get all System objects for sqlparameters
     * @return ArrayList of System objects
     * @throws DBException
     */
    public ArrayList getSystems(Object[][] sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        String sql =  System.SQLSelect;
        int l = sqlparameters.length;
        if(sqlparameters.length>0) {
            sql += " where ";
            for(int i=0; i<l; i++) {
                sql += String.valueOf(sqlparameters[i][0]) + " = :" + String.valueOf(sqlparameters[i][0]) + ": ";
                if(i<l-1) sql += " " + andoroperator + " ";
            }
        }
        if(sortlist.length()>0) {
            sql += " order by " + sortlist + " " + sortoperator;
        }
        return getMapper().loadEntityVector(this, sql, sqlparameters);
    }

    /**
     * delete all System objects for sqlparameters
     * @throws DBException
     */
    public void delSystem(String senderobject, Object[][] sqlparameters, String andoroperator) throws DBException {
        String sql =  "Delete from " + System.table;
        int l = sqlparameters.length;
        if(sqlparameters.length>0) {
            sql += " where ";
            for(int i=0; i<l; i++) {
                sql += String.valueOf(sqlparameters[i][0]) + " = :" + String.valueOf(sqlparameters[i][0]) + ": ";
                if(i<l-1) sql += " " + andoroperator + " ";
            }
        }
        this.addStatement(senderobject, sql, sqlparameters);
    }


}
