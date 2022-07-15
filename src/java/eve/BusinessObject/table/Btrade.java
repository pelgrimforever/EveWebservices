/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 13.6.2022 11:21
 */

package eve.BusinessObject.table;

import general.exception.*;
import java.util.ArrayList;
import db.*;
import data.interfaces.db.*;
import eve.conversion.entity.EMtrade;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.ITradesearch;
import eve.logicentity.Trade;

/**
 * @author Franky Laseure
 */
public abstract class Btrade extends TableBusinessrules {

    public Btrade(SQLreader sqlreader) {
        super(new TableIO(sqlreader, new EMtrade()));
    }

    public Btrade(TableBusinessrules businessrules) {
        super(new TableIO(businessrules.getTableio(), new EMtrade()));
        this.tableio.setAuthenticated(tableio!=null && tableio.isAuthenticated());
    }

    public ITrade newTrade() {
    	return new Trade();
    }
    
    public ITrade newTrade(long sell_order_id, long buy_order_id) {
        return new Trade(sell_order_id, buy_order_id);
    }

    public ITrade newTrade(ITradePK tradePK) {
        return new Trade((TradePK)tradePK);
    }

    public ITradePK newTradePK() {
        return new TradePK();
    }

    public ITradePK newTradePK(long sell_order_id, long buy_order_id) {
        return new TradePK(sell_order_id, buy_order_id);
    }

    public ArrayList<Trade> getTrades() throws DBException {
        return (ArrayList<Trade>)tableio.getEntities(EMtrade.SQLSelectAll);
    }

    public Trade getTrade(ITradePK tradePK) throws DBException {
        return (Trade)tableio.getEntity((TradePK)tradePK);
    }

    public ArrayList<Trade> searchtrades(ITradesearch search) throws DBException {
        return (ArrayList<Trade>)tableio.search(search);
    }

    public ArrayList<Trade> searchtrades(ITradesearch search, String orderby) throws DBException {
        return (ArrayList<Trade>)tableio.search(search, orderby);
    }

    public boolean getTradeExists(ITradePK tradePK) throws DBException {
        return tableio.getEntityExists((TradePK)tradePK);
    }

    public Trade getEntity(String sql) throws DBException {
        return (Trade)tableio.getEntity(sql);
    }
    
    public Trade getEntity(String sql, SQLparameters parameters) throws DBException {
        return (Trade)tableio.getEntity(sql, parameters);
    }
    
    public ArrayList<Trade> getEntities(String sql) throws DBException {
        return tableio.getEntities(sql);
    }
    
    public ArrayList<Trade> getEntities(String sql, SQLparameters parameters) throws DBException {
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

    public ArrayList<Trade> search(Tablesearcher search) throws DBException {
        return tableio.search(search);
    }

    public ArrayList<Trade> search(Tablesearcher search, String orderby) throws DBException {
        return tableio.search(search, orderby);
    }

    public long searchcount(Tablesearcher search) throws DBException {
        return tableio.searchcount(search);
    }

    public void insertTrade(SQLTqueue transactionqueue, ITrade trade) throws DBException, DataException {
        tableio.insertEntity(transactionqueue, trade);
    }

    public void insertupdateTrade(SQLTqueue transactionqueue, ITrade trade) throws DBException, DataException {
    	checkDATA(trade);
        if(this.getTradeExists(trade.getPrimaryKey())) {
            tableio.updateEntity(transactionqueue, trade);
        } else {
            tableio.insertEntity(transactionqueue, trade);
        }
    }

    public void updateTrade(SQLTqueue transactionqueue, ITrade trade) throws DBException, DataException {
    	checkDATA(trade);
        tableio.updateEntity(transactionqueue, trade);
    }

    public void deleteTrade(SQLTqueue transactionqueue, ITrade trade) throws DBException {
        cascadedeleteTrade(transactionqueue, trade.getPrimaryKey());
        tableio.deleteEntity(transactionqueue, trade);
    }

    private void checkDATA(ITrade trade) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //foreign key Trade.Sell_order_id - Orders.Id
        //foreign key Trade.Buy_order_id - Orders.Id
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where tradePK is used in a primary key
     * @param tradePK: Trade primary key
     */
    public void cascadedeleteTrade(SQLTqueue transactionqueue, ITradePK tradePK) {
    }

    public void delete4ordersSell_order_id(SQLTqueue transactionqueue, IOrdersPK ordersPK) {
        tableio.addStatement(transactionqueue, EMtrade.SQLDelete4ordersSell_order_id, ordersPK.getSQLprimarykey());
    }

    public ArrayList<Trade> getTrades4ordersSell_order_id(IOrdersPK ordersPK) throws CustomException {
        return tableio.getEntities(EMtrade.SQLSelect4ordersSell_order_id, ordersPK.getSQLprimarykey());
    }
    public void delete4ordersBuy_order_id(SQLTqueue transactionqueue, IOrdersPK ordersPK) {
        tableio.addStatement(transactionqueue, EMtrade.SQLDelete4ordersBuy_order_id, ordersPK.getSQLprimarykey());
    }

    public ArrayList<Trade> getTrades4ordersBuy_order_id(IOrdersPK ordersPK) throws CustomException {
        return tableio.getEntities(EMtrade.SQLSelect4ordersBuy_order_id, ordersPK.getSQLprimarykey());
    }

    public ArrayList<Trade> getTrades(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMtrade.SQLSelect);
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
        return (ArrayList<Trade>)tableio.getEntities(sql.toString(), sqlparameters);
    }

    public void delTrade(SQLTqueue transactionqueue, SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Trade.table);
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
