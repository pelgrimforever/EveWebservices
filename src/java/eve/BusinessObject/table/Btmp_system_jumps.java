/*
 * Btmp_system_jumps.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 12.6.2021 13:57
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
import eve.conversion.json.JSONTmp_system_jumps;
import eve.data.ProjectConstants;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.ITmp_system_jumpssearch;
import eve.logicentity.Tmp_system_jumps;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Business Entity class Btmp_system_jumps
 *
 * Superclass for manipulating data- and database objects
 * for Entity Tmp_system_jumps and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Btmp_system_jumps extends GeneralEntityObject implements ProjectConstants {

    /**
     * Constructor, sets Tmp_system_jumps as default Entity
     */
    public Btmp_system_jumps() {
        super(new SQLMapper_pgsql(connectionpool, "Tmp_system_jumps"), new Tmp_system_jumps());
    }

    /**
     * Constructor, sets Tmp_system_jumps as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Btmp_system_jumps(GeneralEntityInterface transactionobject) {
        super(transactionobject, new Tmp_system_jumps());
    }

    /**
     * Map ResultSet Field values to Tmp_system_jumps
     * @param dbresult: Database ResultSet
     */
    public Tmp_system_jumps mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Tmp_system_jumpsPK tmp_system_jumpsPK = null;
        Tmp_system_jumps tmp_system_jumps;
        if(dbresult==null) {
            tmp_system_jumps = new Tmp_system_jumps(tmp_system_jumpsPK);
        } else {
            try {
                tmp_system_jumpsPK = new Tmp_system_jumpsPK(dbresult.getLong("system"));
                tmp_system_jumps = new Tmp_system_jumps(tmp_system_jumpsPK);
                tmp_system_jumps.initJump(dbresult.getInt("jump"));
                tmp_system_jumps.initMaxjumps(dbresult.getInt("maxjumps"));
                tmp_system_jumps.initPrevioussystem(dbresult.getLong("previoussystem"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        this.loadExtra(dbresult, tmp_system_jumps);
        return tmp_system_jumps;
    }

    /**
     * create new empty Tmp_system_jumps object
     * @return empty ITmp_system_jumps
     */
    public ITmp_system_jumps newTmp_system_jumps() {
    	return new Tmp_system_jumps();
    }
    
    /**
     * create new empty Tmp_system_jumps object
     * create new primary key with given parameters
     * @return ITmp_system_jumps with primary key
     */
    public ITmp_system_jumps newTmp_system_jumps(long system) {
        return new Tmp_system_jumps(system);
    }

    /**
     * create new empty Tmp_system_jumps object with given primary key
     * @param tmp_system_jumpsPK: primary key for Tmp_system_jumps
     * @return ITmp_system_jumps with primary key
     */
    public ITmp_system_jumps newTmp_system_jumps(ITmp_system_jumpsPK tmp_system_jumpsPK) {
        return new Tmp_system_jumps((Tmp_system_jumpsPK)tmp_system_jumpsPK);
    }

    /**
     * create new empty primary key
     * @return empty Tmp_system_jumpsPK
     */
    public ITmp_system_jumpsPK newTmp_system_jumpsPK() {
        return new Tmp_system_jumpsPK();
    }

    /**
     * create new primary key with given parameters
     * @return new ITmp_system_jumpsPK
     */
    public ITmp_system_jumpsPK newTmp_system_jumpsPK(long system) {
        return new Tmp_system_jumpsPK(system);
    }

    /**
     * get all Tmp_system_jumps objects from database
     * @return ArrayList of Tmp_system_jumps objects
     * @throws DBException
     */
    public ArrayList getTmp_system_jumpss() throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Tmp_system_jumps.SQLSelectAll);
        } else return new ArrayList();
    }

    /**
     * search Tmp_system_jumps for primary key
     * @param tmp_system_jumpsPK: Tmp_system_jumps primary key
     * @return Tmp_system_jumps object
     * @throws DBException
     */
    public Tmp_system_jumps getTmp_system_jumps(ITmp_system_jumpsPK tmp_system_jumpsPK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return (Tmp_system_jumps)super.getEntity((Tmp_system_jumpsPK)tmp_system_jumpsPK);
        } else return null;
    }

    public ArrayList searchtmp_system_jumpss(ITmp_system_jumpssearch search) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return this.search(search);
        } else return new ArrayList();
    }

    public ArrayList searchtmp_system_jumpss(ITmp_system_jumpssearch search, String orderby) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return this.search(search, orderby);
        } else return new ArrayList();
    }

    /**
     * Search tmp_system_jumps in database for tmp_system_jumpsPK:
     * @param tmp_system_jumpsPK: Tmp_system_jumps Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getTmp_system_jumpsExists(ITmp_system_jumpsPK tmp_system_jumpsPK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return super.getEntityExists((Tmp_system_jumpsPK)tmp_system_jumpsPK);
        } else return false;
    }

    /**
     * try to insert Tmp_system_jumps in database
     * @param film: Tmp_system_jumps object
     * @throws DBException
     */
    public void insertTmp_system_jumps(ITmp_system_jumps tmp_system_jumps) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.insertEntity(tmp_system_jumps);
        }
    }

    /**
     * check if Tmp_system_jumpsPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param film: Tmp_system_jumps object
     * @throws DBException
     */
    public void insertupdateTmp_system_jumps(ITmp_system_jumps tmp_system_jumps) throws DBException, DataException {
        if(this.getTmp_system_jumpsExists(tmp_system_jumps.getPrimaryKey())) {
            super.updateEntity(tmp_system_jumps);
        } else {
            super.insertEntity(tmp_system_jumps);
        }
    }

    /**
     * try to update Tmp_system_jumps in database
     * @param film: Tmp_system_jumps object
     * @throws DBException
     */
    public void updateTmp_system_jumps(ITmp_system_jumps tmp_system_jumps) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.updateEntity(tmp_system_jumps);
        }
    }

    /**
     * try to delete Tmp_system_jumps in database
     * @param film: Tmp_system_jumps object
     * @throws DBException
     */
    public void deleteTmp_system_jumps(ITmp_system_jumps tmp_system_jumps) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            cascadedeleteTmp_system_jumps(tmp_system_jumps.getOwnerobject(), tmp_system_jumps.getPrimaryKey());
            super.deleteEntity(tmp_system_jumps);
        }
    }

    /**
     * check data rules in Tmp_system_jumps, throw DataException with customized message if rules do not apply
     * @param film: Tmp_system_jumps object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(ITmp_system_jumps tmp_system_jumps) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where tmp_system_jumpsPK is used in a primary key
     * @param tmp_system_jumpsPK: Tmp_system_jumps primary key
     */
    public void cascadedeleteTmp_system_jumps(String senderobject, ITmp_system_jumpsPK tmp_system_jumpsPK) {
    }


    /**
     * get all Tmp_system_jumps objects for sqlparameters
     * @return ArrayList of Tmp_system_jumps objects
     * @throws DBException
     */
    public ArrayList getTmp_system_jumpss(Object[][] sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        String sql =  Tmp_system_jumps.SQLSelect;
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
     * delete all Tmp_system_jumps objects for sqlparameters
     * @throws DBException
     */
    public void delTmp_system_jumps(String senderobject, Object[][] sqlparameters, String andoroperator) throws DBException {
        String sql =  "Delete from " + Tmp_system_jumps.table;
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
