/*
 * Ballnodes_stargate.java
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
import eve.conversion.json.JSONAllnodes_stargate;
import eve.conversion.entity.EMallnodes_stargate;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.IAllnodes_stargatesearch;
import eve.logicentity.Allnodes_stargate;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Business Entity class Ballnodes_stargate
 *
 * Superclass for manipulating data- and database objects
 * for Entity Allnodes_stargate and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Ballnodes_stargate extends BLtable {

    /**
     * Constructor, sets Allnodes_stargate as default Entity
     */
    public Ballnodes_stargate() {
        super(new Allnodes_stargate(), new EMallnodes_stargate());
    }

    /**
     * Constructor, sets Allnodes_stargate as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Ballnodes_stargate(BLtable transactionobject) {
        super(transactionobject, new Allnodes_stargate(), new EMallnodes_stargate());
    }

    /**
     * create new empty Allnodes_stargate object
     * @return empty IAllnodes_stargate
     */
    public IAllnodes_stargate newAllnodes_stargate() {
    	return new Allnodes_stargate();
    }
    
    /**
     * create new empty Allnodes_stargate object
     * create new primary key with given parameters
     * @param id primary key field
     * @return IAllnodes_stargate with primary key
     */
    public IAllnodes_stargate newAllnodes_stargate(long id) {
        return new Allnodes_stargate(id);
    }

    /**
     * create new empty Allnodes_stargate object with given primary key
     * @param allnodes_stargatePK: primary key for Allnodes_stargate
     * @return IAllnodes_stargate with primary key
     */
    public IAllnodes_stargate newAllnodes_stargate(IAllnodes_stargatePK allnodes_stargatePK) {
        return new Allnodes_stargate((Allnodes_stargatePK)allnodes_stargatePK);
    }

    /**
     * create new empty primary key
     * @return empty Allnodes_stargatePK
     */
    public IAllnodes_stargatePK newAllnodes_stargatePK() {
        return new Allnodes_stargatePK();
    }

    /**
     * create new primary key with given parameters
     * @param id primary key field
     * @return new IAllnodes_stargatePK
     */
    public IAllnodes_stargatePK newAllnodes_stargatePK(long id) {
        return new Allnodes_stargatePK(id);
    }

    /**
     * get all Allnodes_stargate objects from database
     * @return ArrayList of Allnodes_stargate objects
     * @throws DBException
     */
    public ArrayList<Allnodes_stargate> getAllnodes_stargates() throws DBException {
        return (ArrayList<Allnodes_stargate>)super.getEntities(EMallnodes_stargate.SQLSelectAll);
    }

    /**
     * search Allnodes_stargate for primary key
     * @param allnodes_stargatePK: Allnodes_stargate primary key
     * @return Allnodes_stargate object
     * @throws DBException
     */
    public Allnodes_stargate getAllnodes_stargate(IAllnodes_stargatePK allnodes_stargatePK) throws DBException {
        return (Allnodes_stargate)super.getEntity((Allnodes_stargatePK)allnodes_stargatePK);
    }

    /**
     * search allnodes_stargate with IAllnodes_stargatesearch parameters
     * @param search IAllnodes_stargatesearch
     * @return ArrayList of Allnodes_stargate
     * @throws DBException 
     */
    public ArrayList<Allnodes_stargate> searchallnodes_stargates(IAllnodes_stargatesearch search) throws DBException {
        return (ArrayList<Allnodes_stargate>)this.search(search);
    }

    /**
     * search allnodes_stargate with IAllnodes_stargatesearch parameters, order by orderby sql clause
     * @param search IAllnodes_stargatesearch
     * @param orderby sql order by string
     * @return ArrayList of Allnodes_stargate
     * @throws DBException 
     */
    public ArrayList<Allnodes_stargate> searchallnodes_stargates(IAllnodes_stargatesearch search, String orderby) throws DBException {
        return (ArrayList<Allnodes_stargate>)this.search(search, orderby);
    }

    /**
     * Search allnodes_stargate in database for allnodes_stargatePK:
     * @param allnodes_stargatePK: Allnodes_stargate Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getAllnodes_stargateExists(IAllnodes_stargatePK allnodes_stargatePK) throws DBException {
        return super.getEntityExists((Allnodes_stargatePK)allnodes_stargatePK);
    }

    /**
     * try to insert Allnodes_stargate in database
     * @param allnodes_stargate Allnodes_stargate object
     * @throws DBException
     * @throws DataException
     */
    public void insertAllnodes_stargate(IAllnodes_stargate allnodes_stargate) throws DBException, DataException {
        super.insertEntity(allnodes_stargate);
    }

    /**
     * check if Allnodes_stargatePK exists
     * insert if not, update if found
     * do not commit transaction
     * @param allnodes_stargate Allnodes_stargate object
     * @throws DBException
     * @throws DataException
     */
    public void insertupdateAllnodes_stargate(IAllnodes_stargate allnodes_stargate) throws DBException, DataException {
        if(this.getAllnodes_stargateExists(allnodes_stargate.getPrimaryKey())) {
            super.updateEntity(allnodes_stargate);
        } else {
            super.insertEntity(allnodes_stargate);
        }
    }

    /**
     * try to update Allnodes_stargate in database
     * @param allnodes_stargate Allnodes_stargate object
     * @throws DBException
     * @throws DataException
     */
    public void updateAllnodes_stargate(IAllnodes_stargate allnodes_stargate) throws DBException, DataException {
        super.updateEntity(allnodes_stargate);
    }

    /**
     * try to delete Allnodes_stargate in database
     * @param allnodes_stargate Allnodes_stargate object
     * @throws DBException
     */
    public void deleteAllnodes_stargate(IAllnodes_stargate allnodes_stargate) throws DBException {
        cascadedeleteAllnodes_stargate(allnodes_stargate.getPrimaryKey());
        super.deleteEntity(allnodes_stargate);
    }

    /**
     * check data rules in Allnodes_stargate, throw DataException with customized message if rules do not apply
     * @param allnodes_stargate Allnodes_stargate object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(IAllnodes_stargate allnodes_stargate) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where allnodes_stargatePK is used in a primary key
     * @param allnodes_stargatePK: Allnodes_stargate primary key
     */
    public void cascadedeleteAllnodes_stargate(IAllnodes_stargatePK allnodes_stargatePK) {
    }


    /**
     * get all Allnodes_stargate objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @param sortlist sql sort string
     * @param sortoperator asc/desc
     * @return ArrayList of Allnodes_stargate objects
     * @throws DBException
     */
    public ArrayList<Allnodes_stargate> getAllnodes_stargates(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMallnodes_stargate.SQLSelect);
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
        return (ArrayList<Allnodes_stargate>)super.getEntities(sql.toString(), sqlparameters);
    }

    /**
     * delete all Allnodes_stargate objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @throws DBException
     */
    public void delAllnodes_stargate(SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Allnodes_stargate.table);
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
