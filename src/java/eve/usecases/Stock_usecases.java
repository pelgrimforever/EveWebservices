/*
 * Generated on 13.4.2022 19:13
 */

package eve.usecases;

import data.conversion.JSONConversion;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.*;
import eve.interfaces.entity.pk.*;
import eve.logicentity.Stock;
import eve.logicview.*;
import general.exception.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class Stock_usecases {

    private boolean loggedin = false;
    private BLstock blstock = new BLstock();
    
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
        blstock.add_to_Stock(stock);
    }

    public void remove_from_stock(IStock stock) throws DBException, DataException {
        blstock.remove_from_stock(stock);
        blstock.Commit2DB();
    }
    
    public void sell_from_Stocktrade(IStocktrade stocktrade) throws DBException, DataException {
        blstock.sell_from_Stocktrade(stocktrade);
        blstock.Commit2DB();
    }
    
    public void sell_all_Stock_from_system(String username, long system) throws DBException, DataException {
        blstock.sellall4System(username, system);
    }
//Custom code, do not change this line   

    public long count() throws DBException {
        return blstock.count();
    }
    
    public ArrayList<Stock> get_all() throws DBException {
        return blstock.getStocks();
    }
    
    public boolean getStockExists(IStockPK stockPK) throws DBException {
        return blstock.getEntityExists(stockPK);
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
    
    public ArrayList<Stock> search_stock(IStocksearch stocksearch) throws ParseException, CustomException {
        return blstock.search(stocksearch);
    }
    
    public long search_stock_count(IStocksearch stocksearch) throws ParseException, CustomException {
        return blstock.searchcount(stocksearch);
    }

    public void secureinsertStock(IStock stock) throws DBException, DataException {
        blstock.secureinsertStock(stock);
    }

    public void secureupdateStock(IStock stock) throws DBException, DataException {
        blstock.secureupdateStock(stock);
    }

    public void securedeleteStock(IStock stock) throws DBException, DataException {
        blstock.securedeleteStock(stock);
    }
}

