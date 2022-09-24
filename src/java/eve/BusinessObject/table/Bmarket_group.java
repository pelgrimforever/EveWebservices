/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */

package eve.BusinessObject.table;

import general.exception.*;
import java.util.ArrayList;
import db.*;
import data.interfaces.db.*;
import eve.conversion.entity.EMmarket_group;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.IMarket_groupsearch;
import eve.logicentity.Market_group;

public abstract class Bmarket_group extends TableBusinessrules {

    public Bmarket_group(SQLreader sqlreader) {
        super(new TableIO(sqlreader, new EMmarket_group()));
    }

    public Bmarket_group(TableBusinessrules businessrules) {
        super(new TableIO(businessrules.getTableio(), new EMmarket_group()));
        this.tableio.setAuthenticated(tableio!=null && tableio.isAuthenticated());
    }

    public IMarket_group newMarket_group() {
    	return new Market_group();
    }
    
    public IMarket_group newMarket_group(long id) {
        return new Market_group(id);
    }

    public IMarket_group newMarket_group(IMarket_groupPK market_groupPK) {
        return new Market_group((Market_groupPK)market_groupPK);
    }

    public IMarket_groupPK newMarket_groupPK() {
        return new Market_groupPK();
    }

    public IMarket_groupPK newMarket_groupPK(long id) {
        return new Market_groupPK(id);
    }

    public ArrayList<Market_group> getMarket_groups() throws DBException {
        return (ArrayList<Market_group>)tableio.getEntities(EMmarket_group.SQLSelectAll);
    }

    public Market_group getMarket_group(IMarket_groupPK market_groupPK) throws DBException {
        return (Market_group)tableio.getEntity((Market_groupPK)market_groupPK);
    }

    public ArrayList<Market_group> searchmarket_groups(IMarket_groupsearch search) throws DBException {
        return (ArrayList<Market_group>)tableio.search(search);
    }

    public ArrayList<Market_group> searchmarket_groups(IMarket_groupsearch search, String orderby) throws DBException {
        return (ArrayList<Market_group>)tableio.search(search, orderby);
    }

    public boolean getMarket_groupExists(IMarket_groupPK market_groupPK) throws DBException {
        return tableio.getEntityExists((Market_groupPK)market_groupPK);
    }

    public Market_group getEntity(String sql) throws DBException {
        return (Market_group)tableio.getEntity(sql);
    }
    
    public Market_group getEntity(String sql, SQLparameters parameters) throws DBException {
        return (Market_group)tableio.getEntity(sql, parameters);
    }
    
    public ArrayList<Market_group> getEntities(String sql) throws DBException {
        return tableio.getEntities(sql);
    }
    
    public ArrayList<Market_group> getEntities(String sql, SQLparameters parameters) throws DBException {
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

    public ArrayList<Market_group> search(Tablesearcher search) throws DBException {
        return tableio.search(search);
    }

    public ArrayList<Market_group> search(Tablesearcher search, String orderby) throws DBException {
        return tableio.search(search, orderby);
    }

    public long searchcount(Tablesearcher search) throws DBException {
        return tableio.searchcount(search);
    }

    public void insertMarket_group(SQLTqueue transactionqueue, IMarket_group market_group) throws DBException, DataException {
        tableio.insertEntity(transactionqueue, market_group);
    }

    public void insertupdateMarket_group(SQLTqueue transactionqueue, IMarket_group market_group) throws DBException, DataException {
    	checkDATA(market_group);
        if(this.getMarket_groupExists(market_group.getPrimaryKey())) {
            tableio.updateEntity(transactionqueue, market_group);
        } else {
            tableio.insertEntity(transactionqueue, market_group);
        }
    }

    public void updateMarket_group(SQLTqueue transactionqueue, IMarket_group market_group) throws DBException, DataException {
    	checkDATA(market_group);
        tableio.updateEntity(transactionqueue, market_group);
    }

    public void deleteMarket_group(SQLTqueue transactionqueue, IMarket_group market_group) throws DBException {
        cascadedeleteMarket_group(transactionqueue, market_group.getPrimaryKey());
        tableio.deleteEntity(transactionqueue, market_group);
    }

    private void checkDATA(IMarket_group market_group) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        if(market_group.getName()!=null && market_group.getName().length()>IMarket_group.SIZE_NAME) {
            message.append("Name is langer dan toegestaan. Max aantal karakters: ").append(IMarket_group.SIZE_NAME).append("\n");
        }
        if(market_group.getName()==null) {
            message.append("Name mag niet leeg zijn.\n");
        }
        if(market_group.getDescription()!=null && market_group.getDescription().length()>IMarket_group.SIZE_DESCRIPTION) {
            message.append("Description is langer dan toegestaan. Max aantal karakters: ").append(IMarket_group.SIZE_DESCRIPTION).append("\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    public void cascadedeleteMarket_group(SQLTqueue transactionqueue, IMarket_groupPK market_groupPK) {
    }

    public void delete4market_groupParent_id(SQLTqueue transactionqueue, IMarket_groupPK market_groupPK) {
        tableio.addStatement(transactionqueue, EMmarket_group.SQLDelete4market_groupParent_id, market_groupPK.getSQLprimarykey());
    }

    public ArrayList<Market_group> getMarket_groups4market_groupParent_id(IMarket_groupPK market_groupPK) throws CustomException {
        return tableio.getEntities(EMmarket_group.SQLSelect4market_groupParent_id, market_groupPK.getSQLprimarykey());
    }

    public ArrayList<Market_group> getMarket_groups(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMmarket_group.SQLSelect);
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
        return (ArrayList<Market_group>)tableio.getEntities(sql.toString(), sqlparameters);
    }

    public void delMarket_group(SQLTqueue transactionqueue, SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Market_group.table);
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
