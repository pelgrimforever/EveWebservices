/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 17.6.2022 13:4
 */

package eve.BusinessObject.table;

import general.exception.*;
import java.util.ArrayList;
import db.*;
import data.interfaces.db.*;
import eve.conversion.entity.EMorder_history;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.IOrder_historysearch;
import eve.logicentity.Order_history;

/**
 * @author Franky Laseure
 */
public abstract class Border_history extends TableBusinessrules {

    public Border_history(SQLreader sqlreader) {
        super(new TableIO(sqlreader, new EMorder_history()));
    }

    public Border_history(TableBusinessrules businessrules) {
        super(new TableIO(businessrules.getTableio(), new EMorder_history()));
        this.tableio.setAuthenticated(tableio!=null && tableio.isAuthenticated());
    }

    public IOrder_history newOrder_history() {
    	return new Order_history();
    }
    
    public IOrder_history newOrder_history(long region, long evetype, java.sql.Date date) {
        return new Order_history(region, evetype, date);
    }

    public IOrder_history newOrder_history(IOrder_historyPK order_historyPK) {
        return new Order_history((Order_historyPK)order_historyPK);
    }

    public IOrder_historyPK newOrder_historyPK() {
        return new Order_historyPK();
    }

    public IOrder_historyPK newOrder_historyPK(long region, long evetype, java.sql.Date date) {
        return new Order_historyPK(region, evetype, date);
    }

    public ArrayList<Order_history> getOrder_historys() throws DBException {
        return (ArrayList<Order_history>)tableio.getEntities(EMorder_history.SQLSelectAll);
    }

    public Order_history getOrder_history(IOrder_historyPK order_historyPK) throws DBException {
        return (Order_history)tableio.getEntity((Order_historyPK)order_historyPK);
    }

    public ArrayList<Order_history> searchorder_historys(IOrder_historysearch search) throws DBException {
        return (ArrayList<Order_history>)tableio.search(search);
    }

    public ArrayList<Order_history> searchorder_historys(IOrder_historysearch search, String orderby) throws DBException {
        return (ArrayList<Order_history>)tableio.search(search, orderby);
    }

    public boolean getOrder_historyExists(IOrder_historyPK order_historyPK) throws DBException {
        return tableio.getEntityExists((Order_historyPK)order_historyPK);
    }

    public Order_history getEntity(String sql) throws DBException {
        return (Order_history)tableio.getEntity(sql);
    }
    
    public Order_history getEntity(String sql, SQLparameters parameters) throws DBException {
        return (Order_history)tableio.getEntity(sql, parameters);
    }
    
    public ArrayList<Order_history> getEntities(String sql) throws DBException {
        return tableio.getEntities(sql);
    }
    
    public ArrayList<Order_history> getEntities(String sql, SQLparameters parameters) throws DBException {
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

    public ArrayList<Order_history> search(Tablesearcher search) throws DBException {
        return tableio.search(search);
    }

    public ArrayList<Order_history> search(Tablesearcher search, String orderby) throws DBException {
        return tableio.search(search, orderby);
    }

    public long searchcount(Tablesearcher search) throws DBException {
        return tableio.searchcount(search);
    }

    public void insertOrder_history(SQLTqueue transactionqueue, IOrder_history order_history) throws DBException, DataException {
        tableio.insertEntity(transactionqueue, order_history);
    }

    public void insertupdateOrder_history(SQLTqueue transactionqueue, IOrder_history order_history) throws DBException, DataException {
    	checkDATA(order_history);
        if(this.getOrder_historyExists(order_history.getPrimaryKey())) {
            tableio.updateEntity(transactionqueue, order_history);
        } else {
            tableio.insertEntity(transactionqueue, order_history);
        }
    }

    public void updateOrder_history(SQLTqueue transactionqueue, IOrder_history order_history) throws DBException, DataException {
    	checkDATA(order_history);
        tableio.updateEntity(transactionqueue, order_history);
    }

    public void deleteOrder_history(SQLTqueue transactionqueue, IOrder_history order_history) throws DBException {
        cascadedeleteOrder_history(transactionqueue, order_history.getPrimaryKey());
        tableio.deleteEntity(transactionqueue, order_history);
    }

    private void checkDATA(IOrder_history order_history) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //foreign key Order_history.Region - Region.Id
        //foreign key Order_history.Evetype - Evetype.Id
        //Primary key
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where order_historyPK is used in a primary key
     * @param order_historyPK: Order_history primary key
     */
    public void cascadedeleteOrder_history(SQLTqueue transactionqueue, IOrder_historyPK order_historyPK) {
    }

    public void delete4evetype(SQLTqueue transactionqueue, IEvetypePK evetypePK) {
        tableio.addStatement(transactionqueue, EMorder_history.SQLDelete4evetype, evetypePK.getSQLprimarykey());
    }

    public ArrayList<Order_history> getOrder_historys4evetype(IEvetypePK evetypePK) throws CustomException {
        return tableio.getEntities(EMorder_history.SQLSelect4evetype, evetypePK.getSQLprimarykey());
    }
    public void delete4region(SQLTqueue transactionqueue, IRegionPK regionPK) {
        tableio.addStatement(transactionqueue, EMorder_history.SQLDelete4region, regionPK.getSQLprimarykey());
    }

    public ArrayList<Order_history> getOrder_historys4region(IRegionPK regionPK) throws CustomException {
        return tableio.getEntities(EMorder_history.SQLSelect4region, regionPK.getSQLprimarykey());
    }

    public ArrayList<Order_history> getOrder_historys(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMorder_history.SQLSelect);
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
        return (ArrayList<Order_history>)tableio.getEntities(sql.toString(), sqlparameters);
    }

    public void delOrder_history(SQLTqueue transactionqueue, SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Order_history.table);
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
