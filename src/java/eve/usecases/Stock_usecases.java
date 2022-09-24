/*
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */

package eve.usecases;

import db.*;
import data.conversion.JSONConversion;
import data.interfaces.db.Filedata;
import data.gis.shape.piPoint;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.*;
import eve.interfaces.entity.pk.*;
import eve.logicentity.*;
import eve.logicentity.Stock;
import eve.logicview.*;
import eve.usecases.custom.*;
import general.exception.*;
import java.sql.Date;
import java.io.*;
import java.util.*;
import java.io.IOException;
import org.json.simple.parser.ParseException;

public class Stock_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private SQLTwriter sqlwriter = new SQLTwriter();
    private BLstock blstock = new BLstock(sqlreader);
    
    public Stock_usecases() {
        this(false);
    }
    
    public Stock_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blstock.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
    public void add_to_stock(IStock stock) throws DBException, DataException {
        SQLTqueue transactionqueue = new SQLTqueue();
        blstock.add_to_Stock(transactionqueue, stock);
        sqlwriter.Commit2DB(transactionqueue);
    }

    public void remove_from_stock(IStock stock) throws DBException, DataException {
        SQLTqueue transactionqueue = new SQLTqueue();
        blstock.remove_from_stock(transactionqueue, stock);
        sqlwriter.Commit2DB(transactionqueue);
    }
    
    public void sell_from_Stocktrade(IStocktrade stocktrade) throws DBException, DataException {
        SQLTqueue transactionqueue = new SQLTqueue();
        blstock.sell_from_Stocktrade(transactionqueue, stocktrade);
        sqlwriter.Commit2DB(transactionqueue);
    }
    
    public void sell_all_Stock_from_system(String username, long system) throws DBException, DataException {
        SQLTqueue transactionqueue = new SQLTqueue();
        blstock.sellall4System(transactionqueue, username, system);
        sqlwriter.Commit2DB(transactionqueue);
    }
//Custom code, do not change this line   

    public long count() throws DBException {
        return blstock.count();
    }
    
    public ArrayList<Stock> get_all() throws DBException {
        return blstock.getStocks();
    }
    
    public boolean getStockExists(IStockPK stockPK) throws DBException {
        return blstock.getStockExists(stockPK);
    }
    
    public Stock get_stock_by_primarykey(IStockPK stockPK) throws DBException {
        return blstock.getStock(stockPK);
    }

    public ArrayList<Stock> get_stock_with_foreignkey_evetype(IEvetypePK evetypePK) throws CustomException {
        return blstock.getStocks4evetype(evetypePK);
    }
    
    public Stock get_stock_with_externalforeignkey_stocktrade(IStocktradePK stocktradePK) throws CustomException {
        return blstock.getStocktrade(stocktradePK);
    }
    
    public ArrayList<Stock> search_stock(IStocksearch stocksearch) throws CustomException {
        return blstock.search(stocksearch);
    }
    
    public long search_stock_count(IStocksearch stocksearch) throws CustomException {
        return blstock.searchcount(stocksearch);
    }

    public void insertStock(IStock stock) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blstock.insertStock(tq, stock);
        sqlwriter.Commit2DB(tq);
    }

    public void updateStock(IStock stock) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blstock.updateStock(tq, stock);
        sqlwriter.Commit2DB(tq);
    }

    public void deleteStock(IStock stock) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blstock.deleteStock(tq, stock);
        sqlwriter.Commit2DB(tq);
    }

    public void delete_all_containing_Evetype(IEvetypePK evetypePK) throws CustomException {
        SQLTqueue tq = new SQLTqueue();
        blstock.delete4evetype(tq, evetypePK);
        sqlwriter.Commit2DB(tq);
    }
    
}

