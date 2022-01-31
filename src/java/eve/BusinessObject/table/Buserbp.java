/*
 * Buserbp.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 28.0.2022 15:59
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
import eve.conversion.json.JSONUserbp;
import eve.conversion.entity.EMuserbp;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.IUserbpsearch;
import eve.logicentity.Userbp;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Business Entity class Buserbp
 *
 * Superclass for manipulating data- and database objects
 * for Entity Userbp and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Buserbp extends BLtable {

    /**
     * Constructor, sets Userbp as default Entity
     */
    public Buserbp() {
        super(new Userbp(), new EMuserbp());
    }

    /**
     * Constructor, sets Userbp as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Buserbp(BLtable transactionobject) {
        super(transactionobject, new Userbp(), new EMuserbp());
    }

    /**
     * create new empty Userbp object
     * @return empty IUserbp
     */
    public IUserbp newUserbp() {
    	return new Userbp();
    }
    
    /**
     * create new empty Userbp object
     * create new primary key with given parameters
     * @param username primary key field
     * @param bp primary key field
     * @param serialnumber primary key field
     * @return IUserbp with primary key
     */
    public IUserbp newUserbp(java.lang.String username, long bp, int serialnumber) {
        return new Userbp(username, bp, serialnumber);
    }

    /**
     * create new empty Userbp object with given primary key
     * @param userbpPK: primary key for Userbp
     * @return IUserbp with primary key
     */
    public IUserbp newUserbp(IUserbpPK userbpPK) {
        return new Userbp((UserbpPK)userbpPK);
    }

    /**
     * create new empty primary key
     * @return empty UserbpPK
     */
    public IUserbpPK newUserbpPK() {
        return new UserbpPK();
    }

    /**
     * create new primary key with given parameters
     * @param username primary key field
     * @param bp primary key field
     * @param serialnumber primary key field
     * @return new IUserbpPK
     */
    public IUserbpPK newUserbpPK(java.lang.String username, long bp, int serialnumber) {
        return new UserbpPK(username, bp, serialnumber);
    }

    /**
     * get all Userbp objects from database
     * @return ArrayList of Userbp objects
     * @throws DBException
     */
    public ArrayList<Userbp> getUserbps() throws DBException {
        return (ArrayList<Userbp>)super.getEntities(EMuserbp.SQLSelectAll);
    }

    /**
     * search Userbp for primary key
     * @param userbpPK: Userbp primary key
     * @return Userbp object
     * @throws DBException
     */
    public Userbp getUserbp(IUserbpPK userbpPK) throws DBException {
        return (Userbp)super.getEntity((UserbpPK)userbpPK);
    }

    /**
     * search userbp with IUserbpsearch parameters
     * @param search IUserbpsearch
     * @return ArrayList of Userbp
     * @throws DBException 
     */
    public ArrayList<Userbp> searchuserbps(IUserbpsearch search) throws DBException {
        return (ArrayList<Userbp>)this.search(search);
    }

    /**
     * search userbp with IUserbpsearch parameters, order by orderby sql clause
     * @param search IUserbpsearch
     * @param orderby sql order by string
     * @return ArrayList of Userbp
     * @throws DBException 
     */
    public ArrayList<Userbp> searchuserbps(IUserbpsearch search, String orderby) throws DBException {
        return (ArrayList<Userbp>)this.search(search, orderby);
    }

    /**
     * Search userbp in database for userbpPK:
     * @param userbpPK: Userbp Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getUserbpExists(IUserbpPK userbpPK) throws DBException {
        return super.getEntityExists((UserbpPK)userbpPK);
    }

    /**
     * try to insert Userbp in database
     * @param userbp Userbp object
     * @throws DBException
     * @throws DataException
     */
    public void insertUserbp(IUserbp userbp) throws DBException, DataException {
        super.insertEntity(userbp);
    }

    /**
     * check if UserbpPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param userbp Userbp object
     * @throws DBException
     * @throws DataException
     */
    public void insertupdateUserbp(IUserbp userbp) throws DBException, DataException {
        if(this.getUserbpExists(userbp.getPrimaryKey())) {
            super.updateEntity(userbp);
        } else {
            super.insertEntity(userbp);
        }
    }

    /**
     * try to update Userbp in database
     * @param userbp Userbp object
     * @throws DBException
     * @throws DataException
     */
    public void updateUserbp(IUserbp userbp) throws DBException, DataException {
        super.updateEntity(userbp);
    }

    /**
     * try to delete Userbp in database
     * @param userbp Userbp object
     * @throws DBException
     */
    public void deleteUserbp(IUserbp userbp) throws DBException {
        cascadedeleteUserbp(userbp.getPrimaryKey());
        super.deleteEntity(userbp);
    }

    /**
     * check data rules in Userbp, throw DataException with customized message if rules do not apply
     * @param userbp Userbp object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(IUserbp userbp) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //foreign key Userbp.Bp - Evetype.Id
        //Primary key
        //Primary key
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where userbpPK is used in a primary key
     * @param userbpPK: Userbp primary key
     */
    public void cascadedeleteUserbp(IUserbpPK userbpPK) {
    }

    /**
     * @param evetypePK: foreign key for Evetype
     * @delete all Userbp Entity objects for Evetype in database
     */
    public void delete4evetype(IEvetypePK evetypePK) {
        super.addStatement(EMuserbp.SQLDelete4evetype, evetypePK.getSQLprimarykey());
    }

    /**
     * @param evetypePK: foreign key for Evetype
     * @return all Userbp Entity objects for Evetype
     * @throws CustomException
     */
    public ArrayList<Userbp> getUserbps4evetype(IEvetypePK evetypePK) throws CustomException {
        return super.getEntities(EMuserbp.SQLSelect4evetype, evetypePK.getSQLprimarykey());
    }

    /**
     * get all Userbp objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @param sortlist sql sort string
     * @param sortoperator asc/desc
     * @return ArrayList of Userbp objects
     * @throws DBException
     */
    public ArrayList<Userbp> getUserbps(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMuserbp.SQLSelect);
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
        return (ArrayList<Userbp>)super.getEntities(sql.toString(), sqlparameters);
    }

    /**
     * delete all Userbp objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @throws DBException
     */
    public void delUserbp(SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Userbp.table);
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
