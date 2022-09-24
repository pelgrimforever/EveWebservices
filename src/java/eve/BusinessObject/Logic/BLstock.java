/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 24.7.2021 17:21
 * @author Franky Laseure
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import eve.interfaces.logicentity.IStock;
import eve.logicentity.Stock;
import db.*;
import db.*;
import db.SQLTqueue;
import eve.BusinessObject.table.Bstock;
import eve.conversion.entity.EMstock;
import eve.entity.pk.StockPK;
import eve.interfaces.logicentity.IStocktrade;
import eve.logicentity.Stocktrade;
import general.exception.DataException;
import java.util.ArrayList;

public class BLstock extends Bstock {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = true; //set this to true if only a loggin account has access to this data
	
    public BLstock(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(true);
    }

    public ArrayList getStock4user(String username) throws DBException {
        Object[][] parameters = {{ "username", username }};
        SQLparameters sqlparameters = new SQLparameters(parameters);
        return getEntities(EMstock.SQLSelect4username, sqlparameters);
    }
    
    public BLstock(TableBusinessrules businessrules) {
        super(businessrules);
        tableio.setLogginrequired(isprivatetable);
    }



    public void add_to_Stock(SQLTqueue transactionqueue, IStock newstock) throws DBException, DataException {
        Stock stock = getStock(newstock.getPrimaryKey());
        if(stock==null) {
            this.insertStock(transactionqueue, newstock);
        } else {
            stock.setAmount(stock.getAmount() + newstock.getAmount());
            this.updateStock(transactionqueue, stock);
        }
    }
    
    public void remove_from_stock(SQLTqueue transactionqueue, IStock newstock) throws DBException, DataException {
        BLstocktrade blstocktrade = new BLstocktrade(this);
        Stock stock = getStock(newstock.getPrimaryKey());
        if(stock!=null) {
            stock.setAmount(stock.getAmount() - newstock.getAmount());
            if(stock.getAmount()==0) {
                blstocktrade.delete4stock(transactionqueue, stock.getPrimaryKey());
                this.deleteStock(transactionqueue, stock);
            } else {
                this.updateStock(transactionqueue, stock);
            }
        }
    }
    
    public void sell_from_Stocktrade(SQLTqueue transactionqueue, IStocktrade stocktrade) throws DBException, DataException {
        BLstocktrade blstocktrade = new BLstocktrade(this);
        Stock newstock = new Stock((StockPK)stocktrade.getPrimaryKey().getStockPK());
        newstock.setAmount(stocktrade.getSellamount());
        this.remove_from_stock(transactionqueue, newstock);
        blstocktrade.deleteStocktrade(transactionqueue, stocktrade); 
    }
    
    public void sellall4System(SQLTqueue transactionqueue, String username, long systemid) throws DBException, DataException {
        //get all from stocktrade for username where linked orders are in system
        BLstocktrade blstocktrade = new BLstocktrade(this);
        ArrayList<Stocktrade> stocktradelist = blstocktrade.get4System(username, systemid);
        for(Stocktrade stocktrade: stocktradelist)
            remove_stock_amount(transactionqueue, stocktrade, blstocktrade);
    }

    private void remove_stock_amount(SQLTqueue transactionqueue, Stocktrade stocktrade, BLstocktrade blstocktrade) throws DBException, DataException {
        Stock newstock = new Stock((StockPK)stocktrade.getPrimaryKey().getStockPK());
        newstock.setAmount(stocktrade.getSellamount());
        remove_from_stock(transactionqueue, newstock);
        blstocktrade.deleteStocktrade(transactionqueue, stocktrade);
    }
    
}
