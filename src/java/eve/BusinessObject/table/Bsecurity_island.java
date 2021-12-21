/*
 * Bsecurity_island.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 16.11.2021 15:46
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
import eve.conversion.json.JSONSecurity_island;
import eve.conversion.entity.EMsecurity_island;
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
public abstract class Bsecurity_island extends BLtable {

    /**
     * Constructor, sets Security_island as default Entity
     */
    public Bsecurity_island() {
        super(new Security_island(), new EMsecurity_island());
    }

    /**
     * Constructor, sets Security_island as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bsecurity_island(BLtable transactionobject) {
        super(transactionobject, new Security_island(), new EMsecurity_island());
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
     * @param id primary key field
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
     * @param id primary key field
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
    public ArrayList<Security_island> getSecurity_islands() throws DBException {
        return (ArrayList<Security_island>)super.getEntities(EMsecurity_island.SQLSelectAll);
    }

    /**
     * search Security_island for primary key
     * @param security_islandPK: Security_island primary key
     * @return Security_island object
     * @throws DBException
     */
    public Security_island getSecurity_island(ISecurity_islandPK security_islandPK) throws DBException {
        return (Security_island)super.getEntity((Security_islandPK)security_islandPK);
    }

    /**
     * search security_island with ISecurity_islandsearch parameters
     * @param search ISecurity_islandsearch
     * @return ArrayList of Security_island
     * @throws DBException 
     */
    public ArrayList<Security_island> searchsecurity_islands(ISecurity_islandsearch search) throws DBException {
        return (ArrayList<Security_island>)this.search(search);
    }

    /**
     * search security_island with ISecurity_islandsearch parameters, order by orderby sql clause
     * @param search ISecurity_islandsearch
     * @param orderby sql order by string
     * @return ArrayList of Security_island
     * @throws DBException 
     */
    public ArrayList<Security_island> searchsecurity_islands(ISecurity_islandsearch search, String orderby) throws DBException {
        return (ArrayList<Security_island>)this.search(search, orderby);
    }

    /**
     * Search security_island in database for security_islandPK:
     * @param security_islandPK: Security_island Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getSecurity_islandExists(ISecurity_islandPK security_islandPK) throws DBException {
        return super.getEntityExists((Security_islandPK)security_islandPK);
    }

    /**
     * try to insert Security_island in database
     * @param security_island Security_island object
     * @throws DBException
     * @throws DataException
     */
    public void insertSecurity_island(ISecurity_island security_island) throws DBException, DataException {
        super.insertEntity(security_island);
    }

    /**
     * check if Security_islandPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param security_island Security_island object
     * @throws DBException
     * @throws DataException
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
     * @param security_island Security_island object
     * @throws DBException
     * @throws DataException
     */
    public void updateSecurity_island(ISecurity_island security_island) throws DBException, DataException {
        super.updateEntity(security_island);
    }

    /**
     * try to delete Security_island in database
     * @param security_island Security_island object
     * @throws DBException
     */
    public void deleteSecurity_island(ISecurity_island security_island) throws DBException {
        cascadedeleteSecurity_island(security_island.getPrimaryKey());
        super.deleteEntity(security_island);
    }

    /**
     * check data rules in Security_island, throw DataException with customized message if rules do not apply
     * @param security_island Security_island object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(ISecurity_island security_island) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        if(security_island.getName()!=null && security_island.getName().length()>ISecurity_island.SIZE_NAME) {
            message.append("Name is langer dan toegestaan. Max aantal karakters: ").append(ISecurity_island.SIZE_NAME).append("\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where security_islandPK is used in a primary key
     * @param security_islandPK: Security_island primary key
     */
    public void cascadedeleteSecurity_island(ISecurity_islandPK security_islandPK) {
    }


    /**
     * get all Security_island objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @param sortlist sql sort string
     * @param sortoperator asc/desc
     * @return ArrayList of Security_island objects
     * @throws DBException
     */
    public ArrayList<Security_island> getSecurity_islands(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMsecurity_island.SQLSelect);
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
        return (ArrayList<Security_island>)super.getEntities(sql.toString(), sqlparameters);
    }

    /**
     * delete all Security_island objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @throws DBException
     */
    public void delSecurity_island(SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Security_island.table);
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
