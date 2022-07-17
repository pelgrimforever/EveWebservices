/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 17.6.2022 13:4
 */

package eve.BusinessObject.table;

import general.exception.*;
import java.util.ArrayList;
import db.*;
import data.interfaces.db.*;
import eve.conversion.entity.EMorder_history_month;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.IOrder_history_monthsearch;
import eve.logicentity.Order_history_month;

/**
 * @author Franky Laseure
 */
public abstract class Border_history_month extends TableBusinessrules {

    public Border_history_month(SQLreader sqlreader) {
        super(new TableIO(sqlreader, new EMorder_history_month()));
    }

    public Border_history_month(TableBusinessrules businessrules) {
        super(new TableIO(businessrules.getTableio(), new EMorder_history_month()));
        this.tableio.setAuthenticated(tableio!=null && tableio.isAuthenticated());
    }

    public IOrder_history_month newOrder_history_month() {
    	return new Order_history_month();
    }
    
    public IOrder_history_month newOrder_history_month(long region, long evetype, int year, int month) {
        return new Order_history_month(region, evetype, year, month);
    }

    public IOrder_history_month newOrder_history_month(IOrder_history_monthPK order_history_monthPK) {
        return new Order_history_month((Order_history_monthPK)order_history_monthPK);
    }

    public IOrder_history_monthPK newOrder_history_monthPK() {
        return new Order_history_monthPK();
    }

    public IOrder_history_monthPK newOrder_history_monthPK(long region, long evetype, int year, int month) {
        return new Order_history_monthPK(region, evetype, year, month);
    }

    public ArrayList<Order_history_month> getOrder_history_months() throws DBException {
        return (ArrayList<Order_history_month>)tableio.getEntities(EMorder_history_month.SQLSelectAll);
    }

    public Order_history_month getOrder_history_month(IOrder_history_monthPK order_history_monthPK) throws DBException {
        return (Order_history_month)tableio.getEntity((Order_history_monthPK)order_history_monthPK);
    }

    public ArrayList<Order_history_month> searchorder_history_months(IOrder_history_monthsearch search) throws DBException {
        return (ArrayList<Order_history_month>)tableio.search(search);
    }

    public ArrayList<Order_history_month> searchorder_history_months(IOrder_history_monthsearch search, String orderby) throws DBException {
        return (ArrayList<Order_history_month>)tableio.search(search, orderby);
    }

    public boolean getOrder_history_monthExists(IOrder_history_monthPK order_history_monthPK) throws DBException {
        return tableio.getEntityExists((Order_history_monthPK)order_history_monthPK);
    }

    public Order_history_month getEntity(String sql) throws DBException {
        return (Order_history_month)tableio.getEntity(sql);
    }
    
    public Order_history_month getEntity(String sql, SQLparameters parameters) throws DBException {
        return (Order_history_month)tableio.getEntity(sql, parameters);
    }
    
    public ArrayList<Order_history_month> getEntities(String sql) throws DBException {
        return tableio.getEntities(sql);
    }
    
    public ArrayList<Order_history_month> getEntities(String sql, SQLparameters parameters) throws DBException {
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

    public ArrayList<Order_history_month> search(Tablesearcher search) throws DBException {
        return tableio.search(search);
    }

    public ArrayList<Order_history_month> search(Tablesearcher search, String orderby) throws DBException {
        return tableio.search(search, orderby);
    }

    public long searchcount(Tablesearcher search) throws DBException {
        return tableio.searchcount(search);
    }

    public void insertOrder_history_month(SQLTqueue transactionqueue, IOrder_history_month order_history_month) throws DBException, DataException {
        tableio.insertEntity(transactionqueue, order_history_month);
    }

    public void insertupdateOrder_history_month(SQLTqueue transactionqueue, IOrder_history_month order_history_month) throws DBException, DataException {
    	checkDATA(order_history_month);
        if(this.getOrder_history_monthExists(order_history_month.getPrimaryKey())) {
            tableio.updateEntity(transactionqueue, order_history_month);
        } else {
            tableio.insertEntity(transactionqueue, order_history_month);
        }
    }

    public void updateOrder_history_month(SQLTqueue transactionqueue, IOrder_history_month order_history_month) throws DBException, DataException {
    	checkDATA(order_history_month);
        tableio.updateEntity(transactionqueue, order_history_month);
    }

    public void deleteOrder_history_month(SQLTqueue transactionqueue, IOrder_history_month order_history_month) throws DBException {
        cascadedeleteOrder_history_month(transactionqueue, order_history_month.getPrimaryKey());
        tableio.deleteEntity(transactionqueue, order_history_month);
    }

    private void checkDATA(IOrder_history_month order_history_month) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //foreign key Order_history_month.Region - Region.Id
        //foreign key Order_history_month.Evetype - Evetype.Id
        //Primary key
        //Primary key
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where order_history_monthPK is used in a primary key
     * @param order_history_monthPK: Order_history_month primary key
     */
    public void cascadedeleteOrder_history_month(SQLTqueue transactionqueue, IOrder_history_monthPK order_history_monthPK) {
    }

    public void delete4evetype(SQLTqueue transactionqueue, IEvetypePK evetypePK) {
        tableio.addStatement(transactionqueue, EMorder_history_month.SQLDelete4evetype, evetypePK.getSQLprimarykey());
    }

    public ArrayList<Order_history_month> getOrder_history_months4evetype(IEvetypePK evetypePK) throws CustomException {
        return tableio.getEntities(EMorder_history_month.SQLSelect4evetype, evetypePK.getSQLprimarykey());
    }
    public void delete4region(SQLTqueue transactionqueue, IRegionPK regionPK) {
        tableio.addStatement(transactionqueue, EMorder_history_month.SQLDelete4region, regionPK.getSQLprimarykey());
    }

    public ArrayList<Order_history_month> getOrder_history_months4region(IRegionPK regionPK) throws CustomException {
        return tableio.getEntities(EMorder_history_month.SQLSelect4region, regionPK.getSQLprimarykey());
    }

    public ArrayList<Order_history_month> getOrder_history_months(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMorder_history_month.SQLSelect);
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
        return (ArrayList<Order_history_month>)tableio.getEntities(sql.toString(), sqlparameters);
    }

    public void delOrder_history_month(SQLTqueue transactionqueue, SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Order_history_month.table);
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
