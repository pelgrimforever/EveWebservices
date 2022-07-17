/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 17.6.2022 13:4
 */

package eve.BusinessObject.table;

import general.exception.*;
import java.util.ArrayList;
import db.*;
import data.interfaces.db.*;
import eve.conversion.entity.EMstock;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.IStocksearch;
import eve.logicentity.Stock;

/**
 * @author Franky Laseure
 */
public abstract class Bstock extends TableBusinessrules {

    public Bstock(SQLreader sqlreader) {
        super(new TableIO(sqlreader, new EMstock()));
    }

    public Bstock(TableBusinessrules businessrules) {
        super(new TableIO(businessrules.getTableio(), new EMstock()));
        this.tableio.setAuthenticated(tableio!=null && tableio.isAuthenticated());
    }

    public IStock newStock() {
    	return new Stock();
    }
    
    public IStock newStock(java.lang.String username, long evetype) {
        return new Stock(username, evetype);
    }

    public IStock newStock(IStockPK stockPK) {
        return new Stock((StockPK)stockPK);
    }

    public IStockPK newStockPK() {
        return new StockPK();
    }

    public IStockPK newStockPK(java.lang.String username, long evetype) {
        return new StockPK(username, evetype);
    }

    public ArrayList<Stock> getStocks() throws DBException {
        return (ArrayList<Stock>)tableio.getEntities(EMstock.SQLSelectAll);
    }

    public Stock getStock(IStockPK stockPK) throws DBException {
        return (Stock)tableio.getEntity((StockPK)stockPK);
    }

    public ArrayList<Stock> searchstocks(IStocksearch search) throws DBException {
        return (ArrayList<Stock>)tableio.search(search);
    }

    public ArrayList<Stock> searchstocks(IStocksearch search, String orderby) throws DBException {
        return (ArrayList<Stock>)tableio.search(search, orderby);
    }

    public boolean getStockExists(IStockPK stockPK) throws DBException {
        return tableio.getEntityExists((StockPK)stockPK);
    }

    public Stock getEntity(String sql) throws DBException {
        return (Stock)tableio.getEntity(sql);
    }
    
    public Stock getEntity(String sql, SQLparameters parameters) throws DBException {
        return (Stock)tableio.getEntity(sql, parameters);
    }
    
    public ArrayList<Stock> getEntities(String sql) throws DBException {
        return tableio.getEntities(sql);
    }
    
    public ArrayList<Stock> getEntities(String sql, SQLparameters parameters) throws DBException {
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

    public ArrayList<Stock> search(Tablesearcher search) throws DBException {
        return tableio.search(search);
    }

    public ArrayList<Stock> search(Tablesearcher search, String orderby) throws DBException {
        return tableio.search(search, orderby);
    }

    public long searchcount(Tablesearcher search) throws DBException {
        return tableio.searchcount(search);
    }

    public void insertStock(SQLTqueue transactionqueue, IStock stock) throws DBException, DataException {
        tableio.insertEntity(transactionqueue, stock);
    }

    public void insertupdateStock(SQLTqueue transactionqueue, IStock stock) throws DBException, DataException {
    	checkDATA(stock);
        if(this.getStockExists(stock.getPrimaryKey())) {
            tableio.updateEntity(transactionqueue, stock);
        } else {
            tableio.insertEntity(transactionqueue, stock);
        }
    }

    public void updateStock(SQLTqueue transactionqueue, IStock stock) throws DBException, DataException {
    	checkDATA(stock);
        tableio.updateEntity(transactionqueue, stock);
    }

    public void deleteStock(SQLTqueue transactionqueue, IStock stock) throws DBException {
        cascadedeleteStock(transactionqueue, stock.getPrimaryKey());
        tableio.deleteEntity(transactionqueue, stock);
    }

    private void checkDATA(IStock stock) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //foreign key Stock.Evetype - Evetype.Id
        //Primary key
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where stockPK is used in a primary key
     * @param stockPK: Stock primary key
     */
    public void cascadedeleteStock(SQLTqueue transactionqueue, IStockPK stockPK) {
        BLstocktrade blstocktrade = new BLstocktrade(this);
        blstocktrade.setAuthenticated(isAuthenticated());
        blstocktrade.delete4stock(transactionqueue, stockPK);
    }

    public void delete4evetype(SQLTqueue transactionqueue, IEvetypePK evetypePK) {
        tableio.addStatement(transactionqueue, EMstock.SQLDelete4evetype, evetypePK.getSQLprimarykey());
    }

    public ArrayList<Stock> getStocks4evetype(IEvetypePK evetypePK) throws CustomException {
        return tableio.getEntities(EMstock.SQLSelect4evetype, evetypePK.getSQLprimarykey());
    }
    public Stock getStocktrade(IStocktradePK stocktradePK) throws CustomException {
        StockPK stockPK = new StockPK(stocktradePK.getUsername(), stocktradePK.getEvetype());
        return this.getStock(stockPK);
    }


    public ArrayList<Stock> getStocks(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMstock.SQLSelect);
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
        return (ArrayList<Stock>)tableio.getEntities(sql.toString(), sqlparameters);
    }

    public void delStock(SQLTqueue transactionqueue, SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Stock.table);
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
