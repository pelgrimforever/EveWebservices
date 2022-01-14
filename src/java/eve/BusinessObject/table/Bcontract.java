/*
 * Bcontract.java
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
import eve.conversion.json.JSONContract;
import eve.conversion.entity.EMcontract;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.IContractsearch;
import eve.logicentity.Contract;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Business Entity class Bcontract
 *
 * Superclass for manipulating data- and database objects
 * for Entity Contract and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bcontract extends BLtable {

    /**
     * Constructor, sets Contract as default Entity
     */
    public Bcontract() {
        super(new Contract(), new EMcontract());
    }

    /**
     * Constructor, sets Contract as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bcontract(BLtable transactionobject) {
        super(transactionobject, new Contract(), new EMcontract());
    }

    /**
     * create new empty Contract object
     * @return empty IContract
     */
    public IContract newContract() {
    	return new Contract();
    }
    
    /**
     * create new empty Contract object
     * create new primary key with given parameters
     * @param id primary key field
     * @return IContract with primary key
     */
    public IContract newContract(long id) {
        return new Contract(id);
    }

    /**
     * create new empty Contract object with given primary key
     * @param contractPK: primary key for Contract
     * @return IContract with primary key
     */
    public IContract newContract(IContractPK contractPK) {
        return new Contract((ContractPK)contractPK);
    }

    /**
     * create new empty primary key
     * @return empty ContractPK
     */
    public IContractPK newContractPK() {
        return new ContractPK();
    }

    /**
     * create new primary key with given parameters
     * @param id primary key field
     * @return new IContractPK
     */
    public IContractPK newContractPK(long id) {
        return new ContractPK(id);
    }

    /**
     * get all Contract objects from database
     * @return ArrayList of Contract objects
     * @throws DBException
     */
    public ArrayList<Contract> getContracts() throws DBException {
        return (ArrayList<Contract>)super.getEntities(EMcontract.SQLSelectAll);
    }

    /**
     * search Contract for primary key
     * @param contractPK: Contract primary key
     * @return Contract object
     * @throws DBException
     */
    public Contract getContract(IContractPK contractPK) throws DBException {
        return (Contract)super.getEntity((ContractPK)contractPK);
    }

    /**
     * search contract with IContractsearch parameters
     * @param search IContractsearch
     * @return ArrayList of Contract
     * @throws DBException 
     */
    public ArrayList<Contract> searchcontracts(IContractsearch search) throws DBException {
        return (ArrayList<Contract>)this.search(search);
    }

    /**
     * search contract with IContractsearch parameters, order by orderby sql clause
     * @param search IContractsearch
     * @param orderby sql order by string
     * @return ArrayList of Contract
     * @throws DBException 
     */
    public ArrayList<Contract> searchcontracts(IContractsearch search, String orderby) throws DBException {
        return (ArrayList<Contract>)this.search(search, orderby);
    }

    /**
     * Search contract in database for contractPK:
     * @param contractPK: Contract Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getContractExists(IContractPK contractPK) throws DBException {
        return super.getEntityExists((ContractPK)contractPK);
    }

    /**
     * try to insert Contract in database
     * @param contract Contract object
     * @throws DBException
     * @throws DataException
     */
    public void insertContract(IContract contract) throws DBException, DataException {
        super.insertEntity(contract);
    }

    /**
     * check if ContractPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param contract Contract object
     * @throws DBException
     * @throws DataException
     */
    public void insertupdateContract(IContract contract) throws DBException, DataException {
        if(this.getContractExists(contract.getPrimaryKey())) {
            super.updateEntity(contract);
        } else {
            super.insertEntity(contract);
        }
    }

    /**
     * try to update Contract in database
     * @param contract Contract object
     * @throws DBException
     * @throws DataException
     */
    public void updateContract(IContract contract) throws DBException, DataException {
        super.updateEntity(contract);
    }

    /**
     * try to delete Contract in database
     * @param contract Contract object
     * @throws DBException
     */
    public void deleteContract(IContract contract) throws DBException {
        cascadedeleteContract(contract.getPrimaryKey());
        super.deleteEntity(contract);
    }

    /**
     * check data rules in Contract, throw DataException with customized message if rules do not apply
     * @param contract Contract object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(IContract contract) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        if(contract.getDate_expired()==null) {
            message.append("Date_expired mag niet leeg zijn.\n");
        }
        if(contract.getDate_issued()==null) {
            message.append("Date_issued mag niet leeg zijn.\n");
        }
        if(contract.getTitle()!=null && contract.getTitle().length()>IContract.SIZE_TITLE) {
            message.append("Title is langer dan toegestaan. Max aantal karakters: ").append(IContract.SIZE_TITLE).append("\n");
        }
        if(contract.getTitle()==null) {
            message.append("Title mag niet leeg zijn.\n");
        }
        if(contract.getType()!=null && contract.getType().length()>IContract.SIZE_TYPE) {
            message.append("Type is langer dan toegestaan. Max aantal karakters: ").append(IContract.SIZE_TYPE).append("\n");
        }
        if(contract.getType()==null) {
            message.append("Type mag niet leeg zijn.\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where contractPK is used in a primary key
     * @param contractPK: Contract primary key
     */
    public void cascadedeleteContract(IContractPK contractPK) {
    }


    /**
     * get all Contract objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @param sortlist sql sort string
     * @param sortoperator asc/desc
     * @return ArrayList of Contract objects
     * @throws DBException
     */
    public ArrayList<Contract> getContracts(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMcontract.SQLSelect);
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
        return (ArrayList<Contract>)super.getEntities(sql.toString(), sqlparameters);
    }

    /**
     * delete all Contract objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @throws DBException
     */
    public void delContract(SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Contract.table);
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
