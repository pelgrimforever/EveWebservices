/*
 * Bcontractitem.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 14.0.2022 16:56
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
import eve.conversion.json.JSONContractitem;
import eve.conversion.entity.EMcontractitem;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.IContractitemsearch;
import eve.logicentity.Contractitem;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Business Entity class Bcontractitem
 *
 * Superclass for manipulating data- and database objects
 * for Entity Contractitem and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bcontractitem extends BLtable {

    /**
     * Constructor, sets Contractitem as default Entity
     */
    public Bcontractitem() {
        super(new Contractitem(), new EMcontractitem());
    }

    /**
     * Constructor, sets Contractitem as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bcontractitem(BLtable transactionobject) {
        super(transactionobject, new Contractitem(), new EMcontractitem());
    }

    /**
     * create new empty Contractitem object
     * @return empty IContractitem
     */
    public IContractitem newContractitem() {
    	return new Contractitem();
    }
    
    /**
     * create new empty Contractitem object
     * create new primary key with given parameters
     * @param id primary key field
     * @return IContractitem with primary key
     */
    public IContractitem newContractitem(long id) {
        return new Contractitem(id);
    }

    /**
     * create new empty Contractitem object with given primary key
     * @param contractitemPK: primary key for Contractitem
     * @return IContractitem with primary key
     */
    public IContractitem newContractitem(IContractitemPK contractitemPK) {
        return new Contractitem((ContractitemPK)contractitemPK);
    }

    /**
     * create new empty primary key
     * @return empty ContractitemPK
     */
    public IContractitemPK newContractitemPK() {
        return new ContractitemPK();
    }

    /**
     * create new primary key with given parameters
     * @param id primary key field
     * @return new IContractitemPK
     */
    public IContractitemPK newContractitemPK(long id) {
        return new ContractitemPK(id);
    }

    /**
     * get all Contractitem objects from database
     * @return ArrayList of Contractitem objects
     * @throws DBException
     */
    public ArrayList<Contractitem> getContractitems() throws DBException {
        return (ArrayList<Contractitem>)super.getEntities(EMcontractitem.SQLSelectAll);
    }

    /**
     * search Contractitem for primary key
     * @param contractitemPK: Contractitem primary key
     * @return Contractitem object
     * @throws DBException
     */
    public Contractitem getContractitem(IContractitemPK contractitemPK) throws DBException {
        return (Contractitem)super.getEntity((ContractitemPK)contractitemPK);
    }

    /**
     * search contractitem with IContractitemsearch parameters
     * @param search IContractitemsearch
     * @return ArrayList of Contractitem
     * @throws DBException 
     */
    public ArrayList<Contractitem> searchcontractitems(IContractitemsearch search) throws DBException {
        return (ArrayList<Contractitem>)this.search(search);
    }

    /**
     * search contractitem with IContractitemsearch parameters, order by orderby sql clause
     * @param search IContractitemsearch
     * @param orderby sql order by string
     * @return ArrayList of Contractitem
     * @throws DBException 
     */
    public ArrayList<Contractitem> searchcontractitems(IContractitemsearch search, String orderby) throws DBException {
        return (ArrayList<Contractitem>)this.search(search, orderby);
    }

    /**
     * Search contractitem in database for contractitemPK:
     * @param contractitemPK: Contractitem Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getContractitemExists(IContractitemPK contractitemPK) throws DBException {
        return super.getEntityExists((ContractitemPK)contractitemPK);
    }

    /**
     * try to insert Contractitem in database
     * @param contractitem Contractitem object
     * @throws DBException
     * @throws DataException
     */
    public void insertContractitem(IContractitem contractitem) throws DBException, DataException {
        super.insertEntity(contractitem);
    }

    /**
     * check if ContractitemPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param contractitem Contractitem object
     * @throws DBException
     * @throws DataException
     */
    public void insertupdateContractitem(IContractitem contractitem) throws DBException, DataException {
        if(this.getContractitemExists(contractitem.getPrimaryKey())) {
            super.updateEntity(contractitem);
        } else {
            super.insertEntity(contractitem);
        }
    }

    /**
     * try to update Contractitem in database
     * @param contractitem Contractitem object
     * @throws DBException
     * @throws DataException
     */
    public void updateContractitem(IContractitem contractitem) throws DBException, DataException {
        super.updateEntity(contractitem);
    }

    /**
     * try to delete Contractitem in database
     * @param contractitem Contractitem object
     * @throws DBException
     */
    public void deleteContractitem(IContractitem contractitem) throws DBException {
        cascadedeleteContractitem(contractitem.getPrimaryKey());
        super.deleteEntity(contractitem);
    }

    /**
     * check data rules in Contractitem, throw DataException with customized message if rules do not apply
     * @param contractitem Contractitem object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(IContractitem contractitem) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where contractitemPK is used in a primary key
     * @param contractitemPK: Contractitem primary key
     */
    public void cascadedeleteContractitem(IContractitemPK contractitemPK) {
    }

    /**
     * @param evetypePK: foreign key for Evetype
     * @delete all Contractitem Entity objects for Evetype in database
     */
    public void delete4evetype(IEvetypePK evetypePK) {
        super.addStatement(EMcontractitem.SQLDelete4evetype, evetypePK.getSQLprimarykey());
    }

    /**
     * @param evetypePK: foreign key for Evetype
     * @return all Contractitem Entity objects for Evetype
     * @throws CustomException
     */
    public ArrayList<Contractitem> getContractitems4evetype(IEvetypePK evetypePK) throws CustomException {
        return super.getEntities(EMcontractitem.SQLSelect4evetype, evetypePK.getSQLprimarykey());
    }
    /**
     * @param contractPK: foreign key for Contract
     * @delete all Contractitem Entity objects for Contract in database
     */
    public void delete4contract(IContractPK contractPK) {
        super.addStatement(EMcontractitem.SQLDelete4contract, contractPK.getSQLprimarykey());
    }

    /**
     * @param contractPK: foreign key for Contract
     * @return all Contractitem Entity objects for Contract
     * @throws CustomException
     */
    public ArrayList<Contractitem> getContractitems4contract(IContractPK contractPK) throws CustomException {
        return super.getEntities(EMcontractitem.SQLSelect4contract, contractPK.getSQLprimarykey());
    }

    /**
     * get all Contractitem objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @param sortlist sql sort string
     * @param sortoperator asc/desc
     * @return ArrayList of Contractitem objects
     * @throws DBException
     */
    public ArrayList<Contractitem> getContractitems(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMcontractitem.SQLSelect);
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
        return (ArrayList<Contractitem>)super.getEntities(sql.toString(), sqlparameters);
    }

    /**
     * delete all Contractitem objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @throws DBException
     */
    public void delContractitem(SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Contractitem.table);
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
