/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 13.6.2022 11:21
 */

package eve.BusinessObject.table;

import general.exception.*;
import java.util.ArrayList;
import db.*;
import data.interfaces.db.*;
import eve.conversion.entity.EMcontract;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.IContractsearch;
import eve.logicentity.Contract;

/**
 * @author Franky Laseure
 */
public abstract class Bcontract extends TableBusinessrules {

    public Bcontract(SQLreader sqlreader) {
        super(new TableIO(sqlreader, new EMcontract()));
    }

    public Bcontract(TableBusinessrules businessrules) {
        super(new TableIO(businessrules.getTableio(), new EMcontract()));
        this.tableio.setAuthenticated(tableio!=null && tableio.isAuthenticated());
    }

    public IContract newContract() {
    	return new Contract();
    }
    
    public IContract newContract(long id) {
        return new Contract(id);
    }

    public IContract newContract(IContractPK contractPK) {
        return new Contract((ContractPK)contractPK);
    }

    public IContractPK newContractPK() {
        return new ContractPK();
    }

    public IContractPK newContractPK(long id) {
        return new ContractPK(id);
    }

    public ArrayList<Contract> getContracts() throws DBException {
        return (ArrayList<Contract>)tableio.getEntities(EMcontract.SQLSelectAll);
    }

    public Contract getContract(IContractPK contractPK) throws DBException {
        return (Contract)tableio.getEntity((ContractPK)contractPK);
    }

    public ArrayList<Contract> searchcontracts(IContractsearch search) throws DBException {
        return (ArrayList<Contract>)tableio.search(search);
    }

    public ArrayList<Contract> searchcontracts(IContractsearch search, String orderby) throws DBException {
        return (ArrayList<Contract>)tableio.search(search, orderby);
    }

    public boolean getContractExists(IContractPK contractPK) throws DBException {
        return tableio.getEntityExists((ContractPK)contractPK);
    }

    public Contract getEntity(String sql) throws DBException {
        return (Contract)tableio.getEntity(sql);
    }
    
    public Contract getEntity(String sql, SQLparameters parameters) throws DBException {
        return (Contract)tableio.getEntity(sql, parameters);
    }
    
    public ArrayList<Contract> getEntities(String sql) throws DBException {
        return tableio.getEntities(sql);
    }
    
    public ArrayList<Contract> getEntities(String sql, SQLparameters parameters) throws DBException {
        return tableio.getEntities(sql, parameters);
    }

    public long count() throws DBException {
        long count = 0;
        if(tableio.isReadAllowed())
            count = tableio.count();
        return count;
    }
    
    public long count(String sql, SQLparameters parameters) throws DBException {
        long count = 0;
        if(tableio.isReadAllowed())
            count = tableio.count();
        return count;
    }

    public ArrayList<Contract> search(Tablesearcher search) throws DBException {
        return tableio.search(search);
    }

    public ArrayList<Contract> search(Tablesearcher search, String orderby) throws DBException {
        return tableio.search(search, orderby);
    }

    public long searchcount(Tablesearcher search) throws DBException {
        return tableio.searchcount(search);
    }

    public void insertContract(SQLTqueue transactionqueue, IContract contract) throws DBException, DataException {
        tableio.insertEntity(transactionqueue, contract);
    }

    public void insertupdateContract(SQLTqueue transactionqueue, IContract contract) throws DBException, DataException {
    	checkDATA(contract);
        if(this.getContractExists(contract.getPrimaryKey())) {
            tableio.updateEntity(transactionqueue, contract);
        } else {
            tableio.insertEntity(transactionqueue, contract);
        }
    }

    public void updateContract(SQLTqueue transactionqueue, IContract contract) throws DBException, DataException {
    	checkDATA(contract);
        tableio.updateEntity(transactionqueue, contract);
    }

    public void deleteContract(SQLTqueue transactionqueue, IContract contract) throws DBException {
        cascadedeleteContract(transactionqueue, contract.getPrimaryKey());
        tableio.deleteEntity(transactionqueue, contract);
    }

    private void checkDATA(IContract contract) throws DataException, DBException {
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
    public void cascadedeleteContract(SQLTqueue transactionqueue, IContractPK contractPK) {
    }


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
        return (ArrayList<Contract>)tableio.getEntities(sql.toString(), sqlparameters);
    }

    public void delContract(SQLTqueue transactionqueue, SQLparameters sqlparameters, String andoroperator) throws DBException {
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
        tableio.addStatement(transactionqueue, sql.toString(), sqlparameters);
    }


}
