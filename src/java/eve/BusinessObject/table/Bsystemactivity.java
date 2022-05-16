/*
 * Bsystemactivity.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 5.3.2022 17:21
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
import eve.conversion.json.JSONSystemactivity;
import eve.conversion.entity.EMsystemactivity;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.ISystemactivitysearch;
import eve.logicentity.Systemactivity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Business Entity class Bsystemactivity
 *
 * Superclass for manipulating data- and database objects
 * for Entity Systemactivity and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bsystemactivity extends BLtable {

    /**
     * Constructor, sets Systemactivity as default Entity
     */
    public Bsystemactivity() {
        super(new Systemactivity(), new EMsystemactivity());
    }

    /**
     * Constructor, sets Systemactivity as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bsystemactivity(BLtable transactionobject) {
        super(transactionobject, new Systemactivity(), new EMsystemactivity());
    }

    /**
     * create new empty Systemactivity object
     * @return empty ISystemactivity
     */
    public ISystemactivity newSystemactivity() {
    	return new Systemactivity();
    }
    
    /**
     * create new empty Systemactivity object
     * create new primary key with given parameters
     * @param systemid primary key field
     * @param timeslot primary key field
     * @return ISystemactivity with primary key
     */
    public ISystemactivity newSystemactivity(long systemid, java.sql.Timestamp timeslot) {
        return new Systemactivity(systemid, timeslot);
    }

    /**
     * create new empty Systemactivity object with given primary key
     * @param systemactivityPK: primary key for Systemactivity
     * @return ISystemactivity with primary key
     */
    public ISystemactivity newSystemactivity(ISystemactivityPK systemactivityPK) {
        return new Systemactivity((SystemactivityPK)systemactivityPK);
    }

    /**
     * create new empty primary key
     * @return empty SystemactivityPK
     */
    public ISystemactivityPK newSystemactivityPK() {
        return new SystemactivityPK();
    }

    /**
     * create new primary key with given parameters
     * @param systemid primary key field
     * @param timeslot primary key field
     * @return new ISystemactivityPK
     */
    public ISystemactivityPK newSystemactivityPK(long systemid, java.sql.Timestamp timeslot) {
        return new SystemactivityPK(systemid, timeslot);
    }

    /**
     * get all Systemactivity objects from database
     * @return ArrayList of Systemactivity objects
     * @throws DBException
     */
    public ArrayList<Systemactivity> getSystemactivitys() throws DBException {
        return (ArrayList<Systemactivity>)super.getEntities(EMsystemactivity.SQLSelectAll);
    }

    /**
     * search Systemactivity for primary key
     * @param systemactivityPK: Systemactivity primary key
     * @return Systemactivity object
     * @throws DBException
     */
    public Systemactivity getSystemactivity(ISystemactivityPK systemactivityPK) throws DBException {
        return (Systemactivity)super.getEntity((SystemactivityPK)systemactivityPK);
    }

    /**
     * search systemactivity with ISystemactivitysearch parameters
     * @param search ISystemactivitysearch
     * @return ArrayList of Systemactivity
     * @throws DBException 
     */
    public ArrayList<Systemactivity> searchsystemactivitys(ISystemactivitysearch search) throws DBException {
        return (ArrayList<Systemactivity>)this.search(search);
    }

    /**
     * search systemactivity with ISystemactivitysearch parameters, order by orderby sql clause
     * @param search ISystemactivitysearch
     * @param orderby sql order by string
     * @return ArrayList of Systemactivity
     * @throws DBException 
     */
    public ArrayList<Systemactivity> searchsystemactivitys(ISystemactivitysearch search, String orderby) throws DBException {
        return (ArrayList<Systemactivity>)this.search(search, orderby);
    }

    /**
     * Search systemactivity in database for systemactivityPK:
     * @param systemactivityPK: Systemactivity Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getSystemactivityExists(ISystemactivityPK systemactivityPK) throws DBException {
        return super.getEntityExists((SystemactivityPK)systemactivityPK);
    }

    /**
     * try to insert Systemactivity in database
     * @param systemactivity Systemactivity object
     * @throws DBException
     * @throws DataException
     */
    public void insertSystemactivity(ISystemactivity systemactivity) throws DBException, DataException {
        super.insertEntity(systemactivity);
    }

    /**
     * check if SystemactivityPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param systemactivity Systemactivity object
     * @throws DBException
     * @throws DataException
     */
    public void insertupdateSystemactivity(ISystemactivity systemactivity) throws DBException, DataException {
        if(this.getSystemactivityExists(systemactivity.getPrimaryKey())) {
            super.updateEntity(systemactivity);
        } else {
            super.insertEntity(systemactivity);
        }
    }

    /**
     * try to update Systemactivity in database
     * @param systemactivity Systemactivity object
     * @throws DBException
     * @throws DataException
     */
    public void updateSystemactivity(ISystemactivity systemactivity) throws DBException, DataException {
        super.updateEntity(systemactivity);
    }

    /**
     * try to delete Systemactivity in database
     * @param systemactivity Systemactivity object
     * @throws DBException
     */
    public void deleteSystemactivity(ISystemactivity systemactivity) throws DBException {
        cascadedeleteSystemactivity(systemactivity.getPrimaryKey());
        super.deleteEntity(systemactivity);
    }

    /**
     * check data rules in Systemactivity, throw DataException with customized message if rules do not apply
     * @param systemactivity Systemactivity object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(ISystemactivity systemactivity) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //foreign key Systemactivity.Systemid - System.Id
        //Primary key
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where systemactivityPK is used in a primary key
     * @param systemactivityPK: Systemactivity primary key
     */
    public void cascadedeleteSystemactivity(ISystemactivityPK systemactivityPK) {
    }

    /**
     * @param systemPK: foreign key for System
     * @delete all Systemactivity Entity objects for System in database
     */
    public void delete4system(ISystemPK systemPK) {
        super.addStatement(EMsystemactivity.SQLDelete4system, systemPK.getSQLprimarykey());
    }

    /**
     * @param systemPK: foreign key for System
     * @return all Systemactivity Entity objects for System
     * @throws CustomException
     */
    public ArrayList<Systemactivity> getSystemactivitys4system(ISystemPK systemPK) throws CustomException {
        return super.getEntities(EMsystemactivity.SQLSelect4system, systemPK.getSQLprimarykey());
    }

    /**
     * get all Systemactivity objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @param sortlist sql sort string
     * @param sortoperator asc/desc
     * @return ArrayList of Systemactivity objects
     * @throws DBException
     */
    public ArrayList<Systemactivity> getSystemactivitys(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMsystemactivity.SQLSelect);
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
        return (ArrayList<Systemactivity>)super.getEntities(sql.toString(), sqlparameters);
    }

    /**
     * delete all Systemactivity objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @throws DBException
     */
    public void delSystemactivity(SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Systemactivity.table);
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
