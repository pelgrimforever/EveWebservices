/*
 * Beveuser.java
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
import eve.conversion.json.JSONEveuser;
import eve.conversion.entity.EMeveuser;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.IEveusersearch;
import eve.logicentity.Eveuser;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Business Entity class Beveuser
 *
 * Superclass for manipulating data- and database objects
 * for Entity Eveuser and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Beveuser extends BLtable {

    /**
     * Constructor, sets Eveuser as default Entity
     */
    public Beveuser() {
        super(new Eveuser(), new EMeveuser());
    }

    /**
     * Constructor, sets Eveuser as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Beveuser(BLtable transactionobject) {
        super(transactionobject, new Eveuser(), new EMeveuser());
    }

    /**
     * create new empty Eveuser object
     * @return empty IEveuser
     */
    public IEveuser newEveuser() {
    	return new Eveuser();
    }
    
    /**
     * create new empty Eveuser object
     * create new primary key with given parameters
     * @param username primary key field
     * @return IEveuser with primary key
     */
    public IEveuser newEveuser(java.lang.String username) {
        return new Eveuser(username);
    }

    /**
     * create new empty Eveuser object with given primary key
     * @param eveuserPK: primary key for Eveuser
     * @return IEveuser with primary key
     */
    public IEveuser newEveuser(IEveuserPK eveuserPK) {
        return new Eveuser((EveuserPK)eveuserPK);
    }

    /**
     * create new empty primary key
     * @return empty EveuserPK
     */
    public IEveuserPK newEveuserPK() {
        return new EveuserPK();
    }

    /**
     * create new primary key with given parameters
     * @param username primary key field
     * @return new IEveuserPK
     */
    public IEveuserPK newEveuserPK(java.lang.String username) {
        return new EveuserPK(username);
    }

    /**
     * get all Eveuser objects from database
     * @return ArrayList of Eveuser objects
     * @throws DBException
     */
    public ArrayList<Eveuser> getEveusers() throws DBException {
        return (ArrayList<Eveuser>)super.getEntities(EMeveuser.SQLSelectAll);
    }

    /**
     * search Eveuser for primary key
     * @param eveuserPK: Eveuser primary key
     * @return Eveuser object
     * @throws DBException
     */
    public Eveuser getEveuser(IEveuserPK eveuserPK) throws DBException {
        return (Eveuser)super.getEntity((EveuserPK)eveuserPK);
    }

    /**
     * search eveuser with IEveusersearch parameters
     * @param search IEveusersearch
     * @return ArrayList of Eveuser
     * @throws DBException 
     */
    public ArrayList<Eveuser> searcheveusers(IEveusersearch search) throws DBException {
        return (ArrayList<Eveuser>)this.search(search);
    }

    /**
     * search eveuser with IEveusersearch parameters, order by orderby sql clause
     * @param search IEveusersearch
     * @param orderby sql order by string
     * @return ArrayList of Eveuser
     * @throws DBException 
     */
    public ArrayList<Eveuser> searcheveusers(IEveusersearch search, String orderby) throws DBException {
        return (ArrayList<Eveuser>)this.search(search, orderby);
    }

    /**
     * Search eveuser in database for eveuserPK:
     * @param eveuserPK: Eveuser Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getEveuserExists(IEveuserPK eveuserPK) throws DBException {
        return super.getEntityExists((EveuserPK)eveuserPK);
    }

    /**
     * try to insert Eveuser in database
     * @param eveuser Eveuser object
     * @throws DBException
     * @throws DataException
     */
    public void insertEveuser(IEveuser eveuser) throws DBException, DataException {
        super.insertEntity(eveuser);
    }

    /**
     * check if EveuserPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param eveuser Eveuser object
     * @throws DBException
     * @throws DataException
     */
    public void insertupdateEveuser(IEveuser eveuser) throws DBException, DataException {
        if(this.getEveuserExists(eveuser.getPrimaryKey())) {
            super.updateEntity(eveuser);
        } else {
            super.insertEntity(eveuser);
        }
    }

    /**
     * try to update Eveuser in database
     * @param eveuser Eveuser object
     * @throws DBException
     * @throws DataException
     */
    public void updateEveuser(IEveuser eveuser) throws DBException, DataException {
        super.updateEntity(eveuser);
    }

    /**
     * try to delete Eveuser in database
     * @param eveuser Eveuser object
     * @throws DBException
     */
    public void deleteEveuser(IEveuser eveuser) throws DBException {
        cascadedeleteEveuser(eveuser.getPrimaryKey());
        super.deleteEntity(eveuser);
    }

    /**
     * check data rules in Eveuser, throw DataException with customized message if rules do not apply
     * @param eveuser Eveuser object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(IEveuser eveuser) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        if(eveuser.getCreatedat()==null) {
            message.append("Createdat mag niet leeg zijn.\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where eveuserPK is used in a primary key
     * @param eveuserPK: Eveuser primary key
     */
    public void cascadedeleteEveuser(IEveuserPK eveuserPK) {
        BLfrontendpage_auth blfrontendpage_auth = new BLfrontendpage_auth(this);
        blfrontendpage_auth.delete4eveuser(eveuserPK);
    }

    /**
     * @param frontendpage_authPK: parent Frontendpage_auth for child object Eveuser Entity
     * @return child Eveuser Entity object
     * @throws CustomException
     */
    public Eveuser getFrontendpage_auth(IFrontendpage_authPK frontendpage_authPK) throws CustomException {
        EveuserPK eveuserPK = new EveuserPK(frontendpage_authPK.getUsername());
        return this.getEveuser(eveuserPK);
    }


    /**
     * get all Eveuser objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @param sortlist sql sort string
     * @param sortoperator asc/desc
     * @return ArrayList of Eveuser objects
     * @throws DBException
     */
    public ArrayList<Eveuser> getEveusers(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMeveuser.SQLSelect);
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
        return (ArrayList<Eveuser>)super.getEntities(sql.toString(), sqlparameters);
    }

    /**
     * delete all Eveuser objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @throws DBException
     */
    public void delEveuser(SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Eveuser.table);
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
