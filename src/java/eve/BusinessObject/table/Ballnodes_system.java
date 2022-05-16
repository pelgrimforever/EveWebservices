/*
 * Ballnodes_system.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 11.4.2022 9:13
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
import eve.conversion.json.JSONAllnodes_system;
import eve.conversion.entity.EMallnodes_system;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.IAllnodes_systemsearch;
import eve.logicentity.Allnodes_system;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Business Entity class Ballnodes_system
 *
 * Superclass for manipulating data- and database objects
 * for Entity Allnodes_system and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Ballnodes_system extends BLtable {

    /**
     * Constructor, sets Allnodes_system as default Entity
     */
    public Ballnodes_system() {
        super(new Allnodes_system(), new EMallnodes_system());
    }

    /**
     * Constructor, sets Allnodes_system as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Ballnodes_system(BLtable transactionobject) {
        super(transactionobject, new Allnodes_system(), new EMallnodes_system());
    }

    /**
     * create new empty Allnodes_system object
     * @return empty IAllnodes_system
     */
    public IAllnodes_system newAllnodes_system() {
    	return new Allnodes_system();
    }
    
    /**
     * create new empty Allnodes_system object
     * create new primary key with given parameters
     * @param id primary key field
     * @return IAllnodes_system with primary key
     */
    public IAllnodes_system newAllnodes_system(long id) {
        return new Allnodes_system(id);
    }

    /**
     * create new empty Allnodes_system object with given primary key
     * @param allnodes_systemPK: primary key for Allnodes_system
     * @return IAllnodes_system with primary key
     */
    public IAllnodes_system newAllnodes_system(IAllnodes_systemPK allnodes_systemPK) {
        return new Allnodes_system((Allnodes_systemPK)allnodes_systemPK);
    }

    /**
     * create new empty primary key
     * @return empty Allnodes_systemPK
     */
    public IAllnodes_systemPK newAllnodes_systemPK() {
        return new Allnodes_systemPK();
    }

    /**
     * create new primary key with given parameters
     * @param id primary key field
     * @return new IAllnodes_systemPK
     */
    public IAllnodes_systemPK newAllnodes_systemPK(long id) {
        return new Allnodes_systemPK(id);
    }

    /**
     * get all Allnodes_system objects from database
     * @return ArrayList of Allnodes_system objects
     * @throws DBException
     */
    public ArrayList<Allnodes_system> getAllnodes_systems() throws DBException {
        return (ArrayList<Allnodes_system>)super.getEntities(EMallnodes_system.SQLSelectAll);
    }

    /**
     * search Allnodes_system for primary key
     * @param allnodes_systemPK: Allnodes_system primary key
     * @return Allnodes_system object
     * @throws DBException
     */
    public Allnodes_system getAllnodes_system(IAllnodes_systemPK allnodes_systemPK) throws DBException {
        return (Allnodes_system)super.getEntity((Allnodes_systemPK)allnodes_systemPK);
    }

    /**
     * search allnodes_system with IAllnodes_systemsearch parameters
     * @param search IAllnodes_systemsearch
     * @return ArrayList of Allnodes_system
     * @throws DBException 
     */
    public ArrayList<Allnodes_system> searchallnodes_systems(IAllnodes_systemsearch search) throws DBException {
        return (ArrayList<Allnodes_system>)this.search(search);
    }

    /**
     * search allnodes_system with IAllnodes_systemsearch parameters, order by orderby sql clause
     * @param search IAllnodes_systemsearch
     * @param orderby sql order by string
     * @return ArrayList of Allnodes_system
     * @throws DBException 
     */
    public ArrayList<Allnodes_system> searchallnodes_systems(IAllnodes_systemsearch search, String orderby) throws DBException {
        return (ArrayList<Allnodes_system>)this.search(search, orderby);
    }

    /**
     * Search allnodes_system in database for allnodes_systemPK:
     * @param allnodes_systemPK: Allnodes_system Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getAllnodes_systemExists(IAllnodes_systemPK allnodes_systemPK) throws DBException {
        return super.getEntityExists((Allnodes_systemPK)allnodes_systemPK);
    }

    /**
     * try to insert Allnodes_system in database
     * @param allnodes_system Allnodes_system object
     * @throws DBException
     * @throws DataException
     */
    public void insertAllnodes_system(IAllnodes_system allnodes_system) throws DBException, DataException {
        super.insertEntity(allnodes_system);
    }

    /**
     * check if Allnodes_systemPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param allnodes_system Allnodes_system object
     * @throws DBException
     * @throws DataException
     */
    public void insertupdateAllnodes_system(IAllnodes_system allnodes_system) throws DBException, DataException {
        if(this.getAllnodes_systemExists(allnodes_system.getPrimaryKey())) {
            super.updateEntity(allnodes_system);
        } else {
            super.insertEntity(allnodes_system);
        }
    }

    /**
     * try to update Allnodes_system in database
     * @param allnodes_system Allnodes_system object
     * @throws DBException
     * @throws DataException
     */
    public void updateAllnodes_system(IAllnodes_system allnodes_system) throws DBException, DataException {
        super.updateEntity(allnodes_system);
    }

    /**
     * try to delete Allnodes_system in database
     * @param allnodes_system Allnodes_system object
     * @throws DBException
     */
    public void deleteAllnodes_system(IAllnodes_system allnodes_system) throws DBException {
        cascadedeleteAllnodes_system(allnodes_system.getPrimaryKey());
        super.deleteEntity(allnodes_system);
    }

    /**
     * check data rules in Allnodes_system, throw DataException with customized message if rules do not apply
     * @param allnodes_system Allnodes_system object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(IAllnodes_system allnodes_system) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where allnodes_systemPK is used in a primary key
     * @param allnodes_systemPK: Allnodes_system primary key
     */
    public void cascadedeleteAllnodes_system(IAllnodes_systemPK allnodes_systemPK) {
    }


    /**
     * get all Allnodes_system objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @param sortlist sql sort string
     * @param sortoperator asc/desc
     * @return ArrayList of Allnodes_system objects
     * @throws DBException
     */
    public ArrayList<Allnodes_system> getAllnodes_systems(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMallnodes_system.SQLSelect);
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
        return (ArrayList<Allnodes_system>)super.getEntities(sql.toString(), sqlparameters);
    }

    /**
     * delete all Allnodes_system objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @throws DBException
     */
    public void delAllnodes_system(SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Allnodes_system.table);
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
