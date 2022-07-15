/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 13.6.2022 11:21
 */

package eve.BusinessObject.table;

import general.exception.*;
import java.util.ArrayList;
import db.*;
import data.interfaces.db.*;
import eve.conversion.entity.EMtradecombined_sell;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.ITradecombined_sellsearch;
import eve.logicentity.Tradecombined_sell;

/**
 * @author Franky Laseure
 */
public abstract class Btradecombined_sell extends TableBusinessrules {

    public Btradecombined_sell(SQLreader sqlreader) {
        super(new TableIO(sqlreader, new EMtradecombined_sell()));
    }

    public Btradecombined_sell(TableBusinessrules businessrules) {
        super(new TableIO(businessrules.getTableio(), new EMtradecombined_sell()));
        this.tableio.setAuthenticated(tableio!=null && tableio.isAuthenticated());
    }

    public ITradecombined_sell newTradecombined_sell() {
    	return new Tradecombined_sell();
    }
    
    public ITradecombined_sell newTradecombined_sell(long sell_system, long buy_system, long evetype, long buy_order_id, long sell_order_id) {
        return new Tradecombined_sell(sell_system, buy_system, evetype, buy_order_id, sell_order_id);
    }

    public ITradecombined_sell newTradecombined_sell(ITradecombined_sellPK tradecombined_sellPK) {
        return new Tradecombined_sell((Tradecombined_sellPK)tradecombined_sellPK);
    }

    public ITradecombined_sellPK newTradecombined_sellPK() {
        return new Tradecombined_sellPK();
    }

    public ITradecombined_sellPK newTradecombined_sellPK(long sell_system, long buy_system, long evetype, long buy_order_id, long sell_order_id) {
        return new Tradecombined_sellPK(sell_system, buy_system, evetype, buy_order_id, sell_order_id);
    }

    public ArrayList<Tradecombined_sell> getTradecombined_sells() throws DBException {
        return (ArrayList<Tradecombined_sell>)tableio.getEntities(EMtradecombined_sell.SQLSelectAll);
    }

    public Tradecombined_sell getTradecombined_sell(ITradecombined_sellPK tradecombined_sellPK) throws DBException {
        return (Tradecombined_sell)tableio.getEntity((Tradecombined_sellPK)tradecombined_sellPK);
    }

    public ArrayList<Tradecombined_sell> searchtradecombined_sells(ITradecombined_sellsearch search) throws DBException {
        return (ArrayList<Tradecombined_sell>)tableio.search(search);
    }

    public ArrayList<Tradecombined_sell> searchtradecombined_sells(ITradecombined_sellsearch search, String orderby) throws DBException {
        return (ArrayList<Tradecombined_sell>)tableio.search(search, orderby);
    }

    public boolean getTradecombined_sellExists(ITradecombined_sellPK tradecombined_sellPK) throws DBException {
        return tableio.getEntityExists((Tradecombined_sellPK)tradecombined_sellPK);
    }

    public Tradecombined_sell getEntity(String sql) throws DBException {
        return (Tradecombined_sell)tableio.getEntity(sql);
    }
    
    public Tradecombined_sell getEntity(String sql, SQLparameters parameters) throws DBException {
        return (Tradecombined_sell)tableio.getEntity(sql, parameters);
    }
    
    public ArrayList<Tradecombined_sell> getEntities(String sql) throws DBException {
        return tableio.getEntities(sql);
    }
    
    public ArrayList<Tradecombined_sell> getEntities(String sql, SQLparameters parameters) throws DBException {
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

    public ArrayList<Tradecombined_sell> search(Tablesearcher search) throws DBException {
        return tableio.search(search);
    }

    public ArrayList<Tradecombined_sell> search(Tablesearcher search, String orderby) throws DBException {
        return tableio.search(search, orderby);
    }

    public long searchcount(Tablesearcher search) throws DBException {
        return tableio.searchcount(search);
    }

    public void insertTradecombined_sell(SQLTqueue transactionqueue, ITradecombined_sell tradecombined_sell) throws DBException, DataException {
        tableio.insertEntity(transactionqueue, tradecombined_sell);
    }

    public void insertupdateTradecombined_sell(SQLTqueue transactionqueue, ITradecombined_sell tradecombined_sell) throws DBException, DataException {
    	checkDATA(tradecombined_sell);
        if(this.getTradecombined_sellExists(tradecombined_sell.getPrimaryKey())) {
            tableio.updateEntity(transactionqueue, tradecombined_sell);
        } else {
            tableio.insertEntity(transactionqueue, tradecombined_sell);
        }
    }

    public void updateTradecombined_sell(SQLTqueue transactionqueue, ITradecombined_sell tradecombined_sell) throws DBException, DataException {
    	checkDATA(tradecombined_sell);
        tableio.updateEntity(transactionqueue, tradecombined_sell);
    }

    public void deleteTradecombined_sell(SQLTqueue transactionqueue, ITradecombined_sell tradecombined_sell) throws DBException {
        cascadedeleteTradecombined_sell(transactionqueue, tradecombined_sell.getPrimaryKey());
        tableio.deleteEntity(transactionqueue, tradecombined_sell);
    }

    private void checkDATA(ITradecombined_sell tradecombined_sell) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //foreign key Tradecombined_sell.Sell_system - Tradecombined.Sell_system
        //foreign key Tradecombined_sell.Buy_system - Tradecombined.Buy_system
        //foreign key Tradecombined_sell.Evetype - Tradecombined.Evetype
        //foreign key Tradecombined_sell.Buy_order_id - Orders.Id
        //foreign key Tradecombined_sell.Sell_order_id - Orders.Id
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where tradecombined_sellPK is used in a primary key
     * @param tradecombined_sellPK: Tradecombined_sell primary key
     */
    public void cascadedeleteTradecombined_sell(SQLTqueue transactionqueue, ITradecombined_sellPK tradecombined_sellPK) {
    }

    public void delete4ordersBuy_order_id(SQLTqueue transactionqueue, IOrdersPK ordersPK) {
        tableio.addStatement(transactionqueue, EMtradecombined_sell.SQLDelete4ordersBuy_order_id, ordersPK.getSQLprimarykey());
    }

    public ArrayList<Tradecombined_sell> getTradecombined_sells4ordersBuy_order_id(IOrdersPK ordersPK) throws CustomException {
        return tableio.getEntities(EMtradecombined_sell.SQLSelect4ordersBuy_order_id, ordersPK.getSQLprimarykey());
    }
    public void delete4ordersSell_order_id(SQLTqueue transactionqueue, IOrdersPK ordersPK) {
        tableio.addStatement(transactionqueue, EMtradecombined_sell.SQLDelete4ordersSell_order_id, ordersPK.getSQLprimarykey());
    }

    public ArrayList<Tradecombined_sell> getTradecombined_sells4ordersSell_order_id(IOrdersPK ordersPK) throws CustomException {
        return tableio.getEntities(EMtradecombined_sell.SQLSelect4ordersSell_order_id, ordersPK.getSQLprimarykey());
    }
    public void delete4tradecombined(SQLTqueue transactionqueue, ITradecombinedPK tradecombinedPK) {
        tableio.addStatement(transactionqueue, EMtradecombined_sell.SQLDelete4tradecombined, tradecombinedPK.getSQLprimarykey());
    }

    public ArrayList<Tradecombined_sell> getTradecombined_sells4tradecombined(ITradecombinedPK tradecombinedPK) throws CustomException {
        return tableio.getEntities(EMtradecombined_sell.SQLSelect4tradecombined, tradecombinedPK.getSQLprimarykey());
    }

    public ArrayList<Tradecombined_sell> getTradecombined_sells(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMtradecombined_sell.SQLSelect);
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
        return (ArrayList<Tradecombined_sell>)tableio.getEntities(sql.toString(), sqlparameters);
    }

    public void delTradecombined_sell(SQLTqueue transactionqueue, SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Tradecombined_sell.table);
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
