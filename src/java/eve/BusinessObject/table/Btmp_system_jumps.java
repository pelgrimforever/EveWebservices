/*
 * Btmp_system_jumps.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 4.11.2021 14:51
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
import eve.conversion.json.JSONTmp_system_jumps;
import eve.conversion.entity.EMtmp_system_jumps;
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
public abstract class Btmp_system_jumps extends BLtable {

    /**
     * Constructor, sets Tmp_system_jumps as default Entity
     */
    public Btmp_system_jumps() {
        super(new Tmp_system_jumps(), new EMtmp_system_jumps());
    }

    /**
     * Constructor, sets Tmp_system_jumps as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Btmp_system_jumps(BLtable transactionobject) {
        super(transactionobject, new Tmp_system_jumps(), new EMtmp_system_jumps());
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
     * @param system primary key field
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
     * @param system primary key field
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
    public ArrayList<Tmp_system_jumps> getTmp_system_jumpss() throws DBException {
        return (ArrayList<Tmp_system_jumps>)super.getEntities(EMtmp_system_jumps.SQLSelectAll);
    }

    /**
     * search Tmp_system_jumps for primary key
     * @param tmp_system_jumpsPK: Tmp_system_jumps primary key
     * @return Tmp_system_jumps object
     * @throws DBException
     */
    public Tmp_system_jumps getTmp_system_jumps(ITmp_system_jumpsPK tmp_system_jumpsPK) throws DBException {
        return (Tmp_system_jumps)super.getEntity((Tmp_system_jumpsPK)tmp_system_jumpsPK);
    }

    /**
     * search tmp_system_jumps with ITmp_system_jumpssearch parameters
     * @param search ITmp_system_jumpssearch
     * @return ArrayList of Tmp_system_jumps
     * @throws DBException 
     */
    public ArrayList<Tmp_system_jumps> searchtmp_system_jumpss(ITmp_system_jumpssearch search) throws DBException {
        return (ArrayList<Tmp_system_jumps>)this.search(search);
    }

    /**
     * search tmp_system_jumps with ITmp_system_jumpssearch parameters, order by orderby sql clause
     * @param search ITmp_system_jumpssearch
     * @param orderby sql order by string
     * @return ArrayList of Tmp_system_jumps
     * @throws DBException 
     */
    public ArrayList<Tmp_system_jumps> searchtmp_system_jumpss(ITmp_system_jumpssearch search, String orderby) throws DBException {
        return (ArrayList<Tmp_system_jumps>)this.search(search, orderby);
    }

    /**
     * Search tmp_system_jumps in database for tmp_system_jumpsPK:
     * @param tmp_system_jumpsPK: Tmp_system_jumps Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getTmp_system_jumpsExists(ITmp_system_jumpsPK tmp_system_jumpsPK) throws DBException {
        return super.getEntityExists((Tmp_system_jumpsPK)tmp_system_jumpsPK);
    }

    /**
     * try to insert Tmp_system_jumps in database
     * @param tmp_system_jumps Tmp_system_jumps object
     * @throws DBException
     * @throws DataException
     */
    public void insertTmp_system_jumps(ITmp_system_jumps tmp_system_jumps) throws DBException, DataException {
        super.insertEntity(tmp_system_jumps);
    }

    /**
     * check if Tmp_system_jumpsPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param tmp_system_jumps Tmp_system_jumps object
     * @throws DBException
     * @throws DataException
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
     * @param tmp_system_jumps Tmp_system_jumps object
     * @throws DBException
     * @throws DataException
     */
    public void updateTmp_system_jumps(ITmp_system_jumps tmp_system_jumps) throws DBException, DataException {
        super.updateEntity(tmp_system_jumps);
    }

    /**
     * try to delete Tmp_system_jumps in database
     * @param tmp_system_jumps Tmp_system_jumps object
     * @throws DBException
     */
    public void deleteTmp_system_jumps(ITmp_system_jumps tmp_system_jumps) throws DBException {
        cascadedeleteTmp_system_jumps(tmp_system_jumps.getPrimaryKey());
        super.deleteEntity(tmp_system_jumps);
    }

    /**
     * check data rules in Tmp_system_jumps, throw DataException with customized message if rules do not apply
     * @param tmp_system_jumps Tmp_system_jumps object
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
    public void cascadedeleteTmp_system_jumps(ITmp_system_jumpsPK tmp_system_jumpsPK) {
    }


    /**
     * get all Tmp_system_jumps objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @param sortlist sql sort string
     * @param sortoperator asc/desc
     * @return ArrayList of Tmp_system_jumps objects
     * @throws DBException
     */
    public ArrayList<Tmp_system_jumps> getTmp_system_jumpss(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMtmp_system_jumps.SQLSelect);
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
        return (ArrayList<Tmp_system_jumps>)super.getEntities(sql.toString(), sqlparameters);
    }

    /**
     * delete all Tmp_system_jumps objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @throws DBException
     */
    public void delTmp_system_jumps(SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Tmp_system_jumps.table);
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
