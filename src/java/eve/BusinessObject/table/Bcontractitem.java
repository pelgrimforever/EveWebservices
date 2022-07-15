/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 13.6.2022 11:21
 */

package eve.BusinessObject.table;

import general.exception.*;
import java.util.ArrayList;
import db.*;
import data.interfaces.db.*;
import eve.conversion.entity.EMcontractitem;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.IContractitemsearch;
import eve.logicentity.Contractitem;

/**
 * @author Franky Laseure
 */
public abstract class Bcontractitem extends TableBusinessrules {

    public Bcontractitem(SQLreader sqlreader) {
        super(new TableIO(sqlreader, new EMcontractitem()));
    }

    public Bcontractitem(TableBusinessrules businessrules) {
        super(new TableIO(businessrules.getTableio(), new EMcontractitem()));
        this.tableio.setAuthenticated(tableio!=null && tableio.isAuthenticated());
    }

    public IContractitem newContractitem() {
    	return new Contractitem();
    }
    
    public IContractitem newContractitem(long id) {
        return new Contractitem(id);
    }

    public IContractitem newContractitem(IContractitemPK contractitemPK) {
        return new Contractitem((ContractitemPK)contractitemPK);
    }

    public IContractitemPK newContractitemPK() {
        return new ContractitemPK();
    }

    public IContractitemPK newContractitemPK(long id) {
        return new ContractitemPK(id);
    }

    public ArrayList<Contractitem> getContractitems() throws DBException {
        return (ArrayList<Contractitem>)tableio.getEntities(EMcontractitem.SQLSelectAll);
    }

    public Contractitem getContractitem(IContractitemPK contractitemPK) throws DBException {
        return (Contractitem)tableio.getEntity((ContractitemPK)contractitemPK);
    }

    public ArrayList<Contractitem> searchcontractitems(IContractitemsearch search) throws DBException {
        return (ArrayList<Contractitem>)tableio.search(search);
    }

    public ArrayList<Contractitem> searchcontractitems(IContractitemsearch search, String orderby) throws DBException {
        return (ArrayList<Contractitem>)tableio.search(search, orderby);
    }

    public boolean getContractitemExists(IContractitemPK contractitemPK) throws DBException {
        return tableio.getEntityExists((ContractitemPK)contractitemPK);
    }

    public Contractitem getEntity(String sql) throws DBException {
        return (Contractitem)tableio.getEntity(sql);
    }
    
    public Contractitem getEntity(String sql, SQLparameters parameters) throws DBException {
        return (Contractitem)tableio.getEntity(sql, parameters);
    }
    
    public ArrayList<Contractitem> getEntities(String sql) throws DBException {
        return tableio.getEntities(sql);
    }
    
    public ArrayList<Contractitem> getEntities(String sql, SQLparameters parameters) throws DBException {
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

    public ArrayList<Contractitem> search(Tablesearcher search) throws DBException {
        return tableio.search(search);
    }

    public ArrayList<Contractitem> search(Tablesearcher search, String orderby) throws DBException {
        return tableio.search(search, orderby);
    }

    public long searchcount(Tablesearcher search) throws DBException {
        return tableio.searchcount(search);
    }

    public void insertContractitem(SQLTqueue transactionqueue, IContractitem contractitem) throws DBException, DataException {
        tableio.insertEntity(transactionqueue, contractitem);
    }

    public void insertupdateContractitem(SQLTqueue transactionqueue, IContractitem contractitem) throws DBException, DataException {
    	checkDATA(contractitem);
        if(this.getContractitemExists(contractitem.getPrimaryKey())) {
            tableio.updateEntity(transactionqueue, contractitem);
        } else {
            tableio.insertEntity(transactionqueue, contractitem);
        }
    }

    public void updateContractitem(SQLTqueue transactionqueue, IContractitem contractitem) throws DBException, DataException {
    	checkDATA(contractitem);
        tableio.updateEntity(transactionqueue, contractitem);
    }

    public void deleteContractitem(SQLTqueue transactionqueue, IContractitem contractitem) throws DBException {
        cascadedeleteContractitem(transactionqueue, contractitem.getPrimaryKey());
        tableio.deleteEntity(transactionqueue, contractitem);
    }

    private void checkDATA(IContractitem contractitem) throws DataException, DBException {
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
    public void cascadedeleteContractitem(SQLTqueue transactionqueue, IContractitemPK contractitemPK) {
    }

    public void delete4evetype(SQLTqueue transactionqueue, IEvetypePK evetypePK) {
        tableio.addStatement(transactionqueue, EMcontractitem.SQLDelete4evetype, evetypePK.getSQLprimarykey());
    }

    public ArrayList<Contractitem> getContractitems4evetype(IEvetypePK evetypePK) throws CustomException {
        return tableio.getEntities(EMcontractitem.SQLSelect4evetype, evetypePK.getSQLprimarykey());
    }
    public void delete4contract(SQLTqueue transactionqueue, IContractPK contractPK) {
        tableio.addStatement(transactionqueue, EMcontractitem.SQLDelete4contract, contractPK.getSQLprimarykey());
    }

    public ArrayList<Contractitem> getContractitems4contract(IContractPK contractPK) throws CustomException {
        return tableio.getEntities(EMcontractitem.SQLSelect4contract, contractPK.getSQLprimarykey());
    }

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
        return (ArrayList<Contractitem>)tableio.getEntities(sql.toString(), sqlparameters);
    }

    public void delContractitem(SQLTqueue transactionqueue, SQLparameters sqlparameters, String andoroperator) throws DBException {
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
        tableio.addStatement(transactionqueue, sql.toString(), sqlparameters);
    }


}
