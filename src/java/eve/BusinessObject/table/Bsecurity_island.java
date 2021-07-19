/*
 * Bsecurity_island.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 18.6.2021 14:35
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
import eve.conversion.json.JSONSecurity_island;
import eve.data.ProjectConstants;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.ISecurity_islandsearch;
import eve.logicentity.Security_island;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Business Entity class Bsecurity_island
 *
 * Superclass for manipulating data- and database objects
 * for Entity Security_island and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bsecurity_island extends GeneralEntityObject implements ProjectConstants {

    /**
     * Constructor, sets Security_island as default Entity
     */
    public Bsecurity_island() {
        super(new SQLMapper_pgsql(connectionpool, "Security_island"), new Security_island());
    }

    /**
     * Constructor, sets Security_island as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bsecurity_island(GeneralEntityInterface transactionobject) {
        super(transactionobject, new Security_island());
    }

    /**
     * Map ResultSet Field values to Security_island
     * @param dbresult: Database ResultSet
     */
    public Security_island mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Security_islandPK security_islandPK = null;
        Security_island security_island;
        if(dbresult==null) {
            security_island = new Security_island(security_islandPK);
        } else {
            try {
                security_islandPK = new Security_islandPK(dbresult.getLong("id"));
                security_island = new Security_island(security_islandPK);
                security_island.initName(dbresult.getString("name"));
                security_island.initSecurity_status(dbresult.getDouble("security_status"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        this.loadExtra(dbresult, security_island);
        return security_island;
    }

    /**
     * create new empty Security_island object
     * @return empty ISecurity_island
     */
    public ISecurity_island newSecurity_island() {
    	return new Security_island();
    }
    
    /**
     * create new empty Security_island object
     * create new primary key with given parameters
     * @return ISecurity_island with primary key
     */
    public ISecurity_island newSecurity_island(long id) {
        return new Security_island(id);
    }

    /**
     * create new empty Security_island object with given primary key
     * @param security_islandPK: primary key for Security_island
     * @return ISecurity_island with primary key
     */
    public ISecurity_island newSecurity_island(ISecurity_islandPK security_islandPK) {
        return new Security_island((Security_islandPK)security_islandPK);
    }

    /**
     * create new empty primary key
     * @return empty Security_islandPK
     */
    public ISecurity_islandPK newSecurity_islandPK() {
        return new Security_islandPK();
    }

    /**
     * create new primary key with given parameters
     * @return new ISecurity_islandPK
     */
    public ISecurity_islandPK newSecurity_islandPK(long id) {
        return new Security_islandPK(id);
    }

    /**
     * get all Security_island objects from database
     * @return ArrayList of Security_island objects
     * @throws DBException
     */
    public ArrayList getSecurity_islands() throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Security_island.SQLSelectAll);
        } else return new ArrayList();
    }

    /**
     * search Security_island for primary key
     * @param security_islandPK: Security_island primary key
     * @return Security_island object
     * @throws DBException
     */
    public Security_island getSecurity_island(ISecurity_islandPK security_islandPK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return (Security_island)super.getEntity((Security_islandPK)security_islandPK);
        } else return null;
    }

    public ArrayList searchsecurity_islands(ISecurity_islandsearch search) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return this.search(search);
        } else return new ArrayList();
    }

    public ArrayList searchsecurity_islands(ISecurity_islandsearch search, String orderby) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return this.search(search, orderby);
        } else return new ArrayList();
    }

    /**
     * Search security_island in database for security_islandPK:
     * @param security_islandPK: Security_island Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getSecurity_islandExists(ISecurity_islandPK security_islandPK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return super.getEntityExists((Security_islandPK)security_islandPK);
        } else return false;
    }

    /**
     * try to insert Security_island in database
     * @param film: Security_island object
     * @throws DBException
     */
    public void insertSecurity_island(ISecurity_island security_island) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.insertEntity(security_island);
        }
    }

    /**
     * check if Security_islandPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param film: Security_island object
     * @throws DBException
     */
    public void insertupdateSecurity_island(ISecurity_island security_island) throws DBException, DataException {
        if(this.getSecurity_islandExists(security_island.getPrimaryKey())) {
            super.updateEntity(security_island);
        } else {
            super.insertEntity(security_island);
        }
    }

    /**
     * try to update Security_island in database
     * @param film: Security_island object
     * @throws DBException
     */
    public void updateSecurity_island(ISecurity_island security_island) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.updateEntity(security_island);
        }
    }

    /**
     * try to delete Security_island in database
     * @param film: Security_island object
     * @throws DBException
     */
    public void deleteSecurity_island(ISecurity_island security_island) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            cascadedeleteSecurity_island(security_island.getOwnerobject(), security_island.getPrimaryKey());
            super.deleteEntity(security_island);
        }
    }

    /**
     * check data rules in Security_island, throw DataException with customized message if rules do not apply
     * @param film: Security_island object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(ISecurity_island security_island) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        if(security_island.getName()!=null && security_island.getName().length()>ISecurity_island.SIZE_NAME) {
            message.append("Name is langer dan toegestaan. Max aantal karakters: " + ISecurity_island.SIZE_NAME + "\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where security_islandPK is used in a primary key
     * @param security_islandPK: Security_island primary key
     */
    public void cascadedeleteSecurity_island(String senderobject, ISecurity_islandPK security_islandPK) {
    }


    /**
     * get all Security_island objects for sqlparameters
     * @return ArrayList of Security_island objects
     * @throws DBException
     */
    public ArrayList getSecurity_islands(Object[][] sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        String sql =  Security_island.SQLSelect;
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
     * delete all Security_island objects for sqlparameters
     * @throws DBException
     */
    public void delSecurity_island(String senderobject, Object[][] sqlparameters, String andoroperator) throws DBException {
        String sql =  "Delete from " + Security_island.table;
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
