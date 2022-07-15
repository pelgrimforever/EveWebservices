/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 13.6.2022 11:21
 */

package eve.BusinessObject.table;

import general.exception.*;
import java.util.ArrayList;
import db.*;
import data.interfaces.db.*;
import eve.conversion.entity.EMallnodes_stargate;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.IAllnodes_stargatesearch;
import eve.logicentity.Allnodes_stargate;

/**
 * @author Franky Laseure
 */
public abstract class Ballnodes_stargate extends TableBusinessrules {

    public Ballnodes_stargate(SQLreader sqlreader) {
        super(new TableIO(sqlreader, new EMallnodes_stargate()));
    }

    public Ballnodes_stargate(TableBusinessrules businessrules) {
        super(new TableIO(businessrules.getTableio(), new EMallnodes_stargate()));
        this.tableio.setAuthenticated(tableio!=null && tableio.isAuthenticated());
    }

    public IAllnodes_stargate newAllnodes_stargate() {
    	return new Allnodes_stargate();
    }
    
    public IAllnodes_stargate newAllnodes_stargate(long id) {
        return new Allnodes_stargate(id);
    }

    public IAllnodes_stargate newAllnodes_stargate(IAllnodes_stargatePK allnodes_stargatePK) {
        return new Allnodes_stargate((Allnodes_stargatePK)allnodes_stargatePK);
    }

    public IAllnodes_stargatePK newAllnodes_stargatePK() {
        return new Allnodes_stargatePK();
    }

    public IAllnodes_stargatePK newAllnodes_stargatePK(long id) {
        return new Allnodes_stargatePK(id);
    }

    public ArrayList<Allnodes_stargate> getAllnodes_stargates() throws DBException {
        return (ArrayList<Allnodes_stargate>)tableio.getEntities(EMallnodes_stargate.SQLSelectAll);
    }

    public Allnodes_stargate getAllnodes_stargate(IAllnodes_stargatePK allnodes_stargatePK) throws DBException {
        return (Allnodes_stargate)tableio.getEntity((Allnodes_stargatePK)allnodes_stargatePK);
    }

    public ArrayList<Allnodes_stargate> searchallnodes_stargates(IAllnodes_stargatesearch search) throws DBException {
        return (ArrayList<Allnodes_stargate>)tableio.search(search);
    }

    public ArrayList<Allnodes_stargate> searchallnodes_stargates(IAllnodes_stargatesearch search, String orderby) throws DBException {
        return (ArrayList<Allnodes_stargate>)tableio.search(search, orderby);
    }

    public boolean getAllnodes_stargateExists(IAllnodes_stargatePK allnodes_stargatePK) throws DBException {
        return tableio.getEntityExists((Allnodes_stargatePK)allnodes_stargatePK);
    }

    public Allnodes_stargate getEntity(String sql) throws DBException {
        return (Allnodes_stargate)tableio.getEntity(sql);
    }
    
    public Allnodes_stargate getEntity(String sql, SQLparameters parameters) throws DBException {
        return (Allnodes_stargate)tableio.getEntity(sql, parameters);
    }
    
    public ArrayList<Allnodes_stargate> getEntities(String sql) throws DBException {
        return tableio.getEntities(sql);
    }
    
    public ArrayList<Allnodes_stargate> getEntities(String sql, SQLparameters parameters) throws DBException {
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

    public ArrayList<Allnodes_stargate> search(Tablesearcher search) throws DBException {
        return tableio.search(search);
    }

    public ArrayList<Allnodes_stargate> search(Tablesearcher search, String orderby) throws DBException {
        return tableio.search(search, orderby);
    }

    public long searchcount(Tablesearcher search) throws DBException {
        return tableio.searchcount(search);
    }

    public void insertAllnodes_stargate(SQLTqueue transactionqueue, IAllnodes_stargate allnodes_stargate) throws DBException, DataException {
        tableio.insertEntity(transactionqueue, allnodes_stargate);
    }

    public void insertupdateAllnodes_stargate(SQLTqueue transactionqueue, IAllnodes_stargate allnodes_stargate) throws DBException, DataException {
    	checkDATA(allnodes_stargate);
        if(this.getAllnodes_stargateExists(allnodes_stargate.getPrimaryKey())) {
            tableio.updateEntity(transactionqueue, allnodes_stargate);
        } else {
            tableio.insertEntity(transactionqueue, allnodes_stargate);
        }
    }

    public void updateAllnodes_stargate(SQLTqueue transactionqueue, IAllnodes_stargate allnodes_stargate) throws DBException, DataException {
    	checkDATA(allnodes_stargate);
        tableio.updateEntity(transactionqueue, allnodes_stargate);
    }

    public void deleteAllnodes_stargate(SQLTqueue transactionqueue, IAllnodes_stargate allnodes_stargate) throws DBException {
        cascadedeleteAllnodes_stargate(transactionqueue, allnodes_stargate.getPrimaryKey());
        tableio.deleteEntity(transactionqueue, allnodes_stargate);
    }

    private void checkDATA(IAllnodes_stargate allnodes_stargate) throws DataException, DBException {
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
    public void cascadedeleteAllnodes_stargate(SQLTqueue transactionqueue, IAllnodes_stargatePK allnodes_stargatePK) {
    }


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
        return (ArrayList<Allnodes_stargate>)tableio.getEntities(sql.toString(), sqlparameters);
    }

    public void delAllnodes_stargate(SQLTqueue transactionqueue, SQLparameters sqlparameters, String andoroperator) throws DBException {
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
        tableio.addStatement(transactionqueue, sql.toString(), sqlparameters);
    }


}
