/*
 * Bsystemjumps.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 18.8.2021 11:31
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
import eve.conversion.json.JSONSystemjumps;
import eve.data.ProjectConstants;
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
public abstract class Bsystemjumps extends GeneralEntityObject implements ProjectConstants {

    /**
     * Constructor, sets Systemjumps as default Entity
     */
    public Bsystemjumps() {
        super(new SQLMapper_pgsql(connectionpool, "Systemjumps"), new Systemjumps());
    }

    /**
     * Constructor, sets Systemjumps as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bsystemjumps(GeneralEntityInterface transactionobject) {
        super(transactionobject, new Systemjumps());
    }

    /**
     * Map ResultSet Field values to Systemjumps
     * @param dbresult: Database ResultSet
     */
    public Systemjumps mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        SystemjumpsPK systemjumpsPK = null;
        Systemjumps systemjumps;
        if(dbresult==null) {
            systemjumps = new Systemjumps(systemjumpsPK);
        } else {
            try {
                systemjumpsPK = new SystemjumpsPK(dbresult.getLong("system_start"), dbresult.getLong("system_end"));
                systemjumps = new Systemjumps(systemjumpsPK);
                systemjumps.initJumps(dbresult.getInt("jumps"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        this.loadExtra(dbresult, systemjumps);
        return systemjumps;
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
    public ArrayList getSystemjumpss() throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Systemjumps.SQLSelectAll);
        } else return new ArrayList();
    }

    /**
     * search Systemjumps for primary key
     * @param systemjumpsPK: Systemjumps primary key
     * @return Systemjumps object
     * @throws DBException
     */
    public Systemjumps getSystemjumps(ISystemjumpsPK systemjumpsPK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return (Systemjumps)super.getEntity((SystemjumpsPK)systemjumpsPK);
        } else return null;
    }

    public ArrayList searchsystemjumpss(ISystemjumpssearch search) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return this.search(search);
        } else return new ArrayList();
    }

    public ArrayList searchsystemjumpss(ISystemjumpssearch search, String orderby) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return this.search(search, orderby);
        } else return new ArrayList();
    }

    /**
     * Search systemjumps in database for systemjumpsPK:
     * @param systemjumpsPK: Systemjumps Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getSystemjumpsExists(ISystemjumpsPK systemjumpsPK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return super.getEntityExists((SystemjumpsPK)systemjumpsPK);
        } else return false;
    }

    /**
     * try to insert Systemjumps in database
     * @param film: Systemjumps object
     * @throws DBException
     */
    public void insertSystemjumps(ISystemjumps systemjumps) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.insertEntity(systemjumps);
        }
    }

    /**
     * check if SystemjumpsPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param film: Systemjumps object
     * @throws DBException
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
     * @param film: Systemjumps object
     * @throws DBException
     */
    public void updateSystemjumps(ISystemjumps systemjumps) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.updateEntity(systemjumps);
        }
    }

    /**
     * try to delete Systemjumps in database
     * @param film: Systemjumps object
     * @throws DBException
     */
    public void deleteSystemjumps(ISystemjumps systemjumps) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            cascadedeleteSystemjumps(systemjumps.getOwnerobject(), systemjumps.getPrimaryKey());
            super.deleteEntity(systemjumps);
        }
    }

    /**
     * check data rules in Systemjumps, throw DataException with customized message if rules do not apply
     * @param film: Systemjumps object
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
    public void cascadedeleteSystemjumps(String senderobject, ISystemjumpsPK systemjumpsPK) {
    }

    /**
     * @param systemPK: foreign key for System
     * @delete all Systemjumps Entity objects for System in database
     * @throws eve.general.exception.CustomException
     */
    public void delete4systemSystem_end(String senderobject, ISystemPK systemPK) {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.addStatement(senderobject, Systemjumps.SQLDelete4systemSystem_end, systemPK.getKeyFields());
        }
    }

    /**
     * @param systemPK: foreign key for System
     * @return all Systemjumps Entity objects for System
     * @throws eve.general.exception.CustomException
     */
    public ArrayList getSystemjumpss4systemSystem_end(ISystemPK systemPK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Systemjumps.SQLSelect4systemSystem_end, systemPK.getKeyFields());
        } else return new ArrayList();
    }
    /**
     * @param systemPK: foreign key for System
     * @delete all Systemjumps Entity objects for System in database
     * @throws eve.general.exception.CustomException
     */
    public void delete4systemSystem_start(String senderobject, ISystemPK systemPK) {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.addStatement(senderobject, Systemjumps.SQLDelete4systemSystem_start, systemPK.getKeyFields());
        }
    }

    /**
     * @param systemPK: foreign key for System
     * @return all Systemjumps Entity objects for System
     * @throws eve.general.exception.CustomException
     */
    public ArrayList getSystemjumpss4systemSystem_start(ISystemPK systemPK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Systemjumps.SQLSelect4systemSystem_start, systemPK.getKeyFields());
        } else return new ArrayList();
    }

    /**
     * get all Systemjumps objects for sqlparameters
     * @return ArrayList of Systemjumps objects
     * @throws DBException
     */
    public ArrayList getSystemjumpss(Object[][] sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        String sql =  Systemjumps.SQLSelect;
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
     * delete all Systemjumps objects for sqlparameters
     * @throws DBException
     */
    public void delSystemjumps(String senderobject, Object[][] sqlparameters, String andoroperator) throws DBException {
        String sql =  "Delete from " + Systemjumps.table;
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
