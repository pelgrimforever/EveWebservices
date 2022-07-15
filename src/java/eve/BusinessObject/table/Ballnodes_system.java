/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 13.6.2022 11:21
 */

package eve.BusinessObject.table;

import general.exception.*;
import java.util.ArrayList;
import db.*;
import data.interfaces.db.*;
import eve.conversion.entity.EMallnodes_system;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.IAllnodes_systemsearch;
import eve.logicentity.Allnodes_system;

/**
 * @author Franky Laseure
 */
public abstract class Ballnodes_system extends TableBusinessrules {

    public Ballnodes_system(SQLreader sqlreader) {
        super(new TableIO(sqlreader, new EMallnodes_system()));
    }

    public Ballnodes_system(TableBusinessrules businessrules) {
        super(new TableIO(businessrules.getTableio(), new EMallnodes_system()));
        this.tableio.setAuthenticated(tableio!=null && tableio.isAuthenticated());
    }

    public IAllnodes_system newAllnodes_system() {
    	return new Allnodes_system();
    }
    
    public IAllnodes_system newAllnodes_system(long id) {
        return new Allnodes_system(id);
    }

    public IAllnodes_system newAllnodes_system(IAllnodes_systemPK allnodes_systemPK) {
        return new Allnodes_system((Allnodes_systemPK)allnodes_systemPK);
    }

    public IAllnodes_systemPK newAllnodes_systemPK() {
        return new Allnodes_systemPK();
    }

    public IAllnodes_systemPK newAllnodes_systemPK(long id) {
        return new Allnodes_systemPK(id);
    }

    public ArrayList<Allnodes_system> getAllnodes_systems() throws DBException {
        return (ArrayList<Allnodes_system>)tableio.getEntities(EMallnodes_system.SQLSelectAll);
    }

    public Allnodes_system getAllnodes_system(IAllnodes_systemPK allnodes_systemPK) throws DBException {
        return (Allnodes_system)tableio.getEntity((Allnodes_systemPK)allnodes_systemPK);
    }

    public ArrayList<Allnodes_system> searchallnodes_systems(IAllnodes_systemsearch search) throws DBException {
        return (ArrayList<Allnodes_system>)tableio.search(search);
    }

    public ArrayList<Allnodes_system> searchallnodes_systems(IAllnodes_systemsearch search, String orderby) throws DBException {
        return (ArrayList<Allnodes_system>)tableio.search(search, orderby);
    }

    public boolean getAllnodes_systemExists(IAllnodes_systemPK allnodes_systemPK) throws DBException {
        return tableio.getEntityExists((Allnodes_systemPK)allnodes_systemPK);
    }

    public Allnodes_system getEntity(String sql) throws DBException {
        return (Allnodes_system)tableio.getEntity(sql);
    }
    
    public Allnodes_system getEntity(String sql, SQLparameters parameters) throws DBException {
        return (Allnodes_system)tableio.getEntity(sql, parameters);
    }
    
    public ArrayList<Allnodes_system> getEntities(String sql) throws DBException {
        return tableio.getEntities(sql);
    }
    
    public ArrayList<Allnodes_system> getEntities(String sql, SQLparameters parameters) throws DBException {
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

    public ArrayList<Allnodes_system> search(Tablesearcher search) throws DBException {
        return tableio.search(search);
    }

    public ArrayList<Allnodes_system> search(Tablesearcher search, String orderby) throws DBException {
        return tableio.search(search, orderby);
    }

    public long searchcount(Tablesearcher search) throws DBException {
        return tableio.searchcount(search);
    }

    public void insertAllnodes_system(SQLTqueue transactionqueue, IAllnodes_system allnodes_system) throws DBException, DataException {
        tableio.insertEntity(transactionqueue, allnodes_system);
    }

    public void insertupdateAllnodes_system(SQLTqueue transactionqueue, IAllnodes_system allnodes_system) throws DBException, DataException {
    	checkDATA(allnodes_system);
        if(this.getAllnodes_systemExists(allnodes_system.getPrimaryKey())) {
            tableio.updateEntity(transactionqueue, allnodes_system);
        } else {
            tableio.insertEntity(transactionqueue, allnodes_system);
        }
    }

    public void updateAllnodes_system(SQLTqueue transactionqueue, IAllnodes_system allnodes_system) throws DBException, DataException {
    	checkDATA(allnodes_system);
        tableio.updateEntity(transactionqueue, allnodes_system);
    }

    public void deleteAllnodes_system(SQLTqueue transactionqueue, IAllnodes_system allnodes_system) throws DBException {
        cascadedeleteAllnodes_system(transactionqueue, allnodes_system.getPrimaryKey());
        tableio.deleteEntity(transactionqueue, allnodes_system);
    }

    private void checkDATA(IAllnodes_system allnodes_system) throws DataException, DBException {
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
    public void cascadedeleteAllnodes_system(SQLTqueue transactionqueue, IAllnodes_systemPK allnodes_systemPK) {
    }


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
        return (ArrayList<Allnodes_system>)tableio.getEntities(sql.toString(), sqlparameters);
    }

    public void delAllnodes_system(SQLTqueue transactionqueue, SQLparameters sqlparameters, String andoroperator) throws DBException {
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
        tableio.addStatement(transactionqueue, sql.toString(), sqlparameters);
    }


}
