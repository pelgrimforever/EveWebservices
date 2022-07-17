/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 17.6.2022 13:4
 */

package eve.BusinessObject.table;

import general.exception.*;
import java.util.ArrayList;
import db.*;
import data.interfaces.db.*;
import eve.conversion.entity.EMsecurity_island;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.ISecurity_islandsearch;
import eve.logicentity.Security_island;

/**
 * @author Franky Laseure
 */
public abstract class Bsecurity_island extends TableBusinessrules {

    public Bsecurity_island(SQLreader sqlreader) {
        super(new TableIO(sqlreader, new EMsecurity_island()));
    }

    public Bsecurity_island(TableBusinessrules businessrules) {
        super(new TableIO(businessrules.getTableio(), new EMsecurity_island()));
        this.tableio.setAuthenticated(tableio!=null && tableio.isAuthenticated());
    }

    public ISecurity_island newSecurity_island() {
    	return new Security_island();
    }
    
    public ISecurity_island newSecurity_island(long id) {
        return new Security_island(id);
    }

    public ISecurity_island newSecurity_island(ISecurity_islandPK security_islandPK) {
        return new Security_island((Security_islandPK)security_islandPK);
    }

    public ISecurity_islandPK newSecurity_islandPK() {
        return new Security_islandPK();
    }

    public ISecurity_islandPK newSecurity_islandPK(long id) {
        return new Security_islandPK(id);
    }

    public ArrayList<Security_island> getSecurity_islands() throws DBException {
        return (ArrayList<Security_island>)tableio.getEntities(EMsecurity_island.SQLSelectAll);
    }

    public Security_island getSecurity_island(ISecurity_islandPK security_islandPK) throws DBException {
        return (Security_island)tableio.getEntity((Security_islandPK)security_islandPK);
    }

    public ArrayList<Security_island> searchsecurity_islands(ISecurity_islandsearch search) throws DBException {
        return (ArrayList<Security_island>)tableio.search(search);
    }

    public ArrayList<Security_island> searchsecurity_islands(ISecurity_islandsearch search, String orderby) throws DBException {
        return (ArrayList<Security_island>)tableio.search(search, orderby);
    }

    public boolean getSecurity_islandExists(ISecurity_islandPK security_islandPK) throws DBException {
        return tableio.getEntityExists((Security_islandPK)security_islandPK);
    }

    public Security_island getEntity(String sql) throws DBException {
        return (Security_island)tableio.getEntity(sql);
    }
    
    public Security_island getEntity(String sql, SQLparameters parameters) throws DBException {
        return (Security_island)tableio.getEntity(sql, parameters);
    }
    
    public ArrayList<Security_island> getEntities(String sql) throws DBException {
        return tableio.getEntities(sql);
    }
    
    public ArrayList<Security_island> getEntities(String sql, SQLparameters parameters) throws DBException {
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

    public ArrayList<Security_island> search(Tablesearcher search) throws DBException {
        return tableio.search(search);
    }

    public ArrayList<Security_island> search(Tablesearcher search, String orderby) throws DBException {
        return tableio.search(search, orderby);
    }

    public long searchcount(Tablesearcher search) throws DBException {
        return tableio.searchcount(search);
    }

    public void insertSecurity_island(SQLTqueue transactionqueue, ISecurity_island security_island) throws DBException, DataException {
        tableio.insertEntity(transactionqueue, security_island);
    }

    public void insertupdateSecurity_island(SQLTqueue transactionqueue, ISecurity_island security_island) throws DBException, DataException {
    	checkDATA(security_island);
        if(this.getSecurity_islandExists(security_island.getPrimaryKey())) {
            tableio.updateEntity(transactionqueue, security_island);
        } else {
            tableio.insertEntity(transactionqueue, security_island);
        }
    }

    public void updateSecurity_island(SQLTqueue transactionqueue, ISecurity_island security_island) throws DBException, DataException {
    	checkDATA(security_island);
        tableio.updateEntity(transactionqueue, security_island);
    }

    public void deleteSecurity_island(SQLTqueue transactionqueue, ISecurity_island security_island) throws DBException {
        cascadedeleteSecurity_island(transactionqueue, security_island.getPrimaryKey());
        tableio.deleteEntity(transactionqueue, security_island);
    }

    private void checkDATA(ISecurity_island security_island) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        if(security_island.getName()!=null && security_island.getName().length()>ISecurity_island.SIZE_NAME) {
            message.append("Name is langer dan toegestaan. Max aantal karakters: ").append(ISecurity_island.SIZE_NAME).append("\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where security_islandPK is used in a primary key
     * @param security_islandPK: Security_island primary key
     */
    public void cascadedeleteSecurity_island(SQLTqueue transactionqueue, ISecurity_islandPK security_islandPK) {
    }


    public ArrayList<Security_island> getSecurity_islands(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMsecurity_island.SQLSelect);
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
        return (ArrayList<Security_island>)tableio.getEntities(sql.toString(), sqlparameters);
    }

    public void delSecurity_island(SQLTqueue transactionqueue, SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Security_island.table);
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
