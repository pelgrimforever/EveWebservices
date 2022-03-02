/*
 * BLstock.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 24.7.2021 17:21
 *
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import eve.interfaces.logicentity.IStock;
import eve.logicentity.Stock;
import BusinessObject.BLtable;
import db.SQLparameters;
import eve.BusinessObject.table.Bstock;
import eve.conversion.entity.EMstock;
import eve.entity.pk.StockPK;
import eve.logicentity.Stocktrade;
import general.exception.DataException;
import java.util.ArrayList;

/**
 * Business Logic Entity class BLstock
 *
 * Class for manipulating data- and database objects
 * for Entity Stock and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLstock extends Bstock {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = true; //set this to true if only a loggin account has access to this data
	
    /**
     * Constructor, sets Stock as default Entity
     */
    public BLstock() {
        this.setLogginrequired(isprivatetable);
    }

    public ArrayList getStock4user(String username) throws DBException {
        Object[][] parameters = {{ "username", username }};
        SQLparameters sqlparameters = new SQLparameters(parameters);
        return getEntities(EMstock.SQLSelect4username, sqlparameters);
    }
    
    /**
     * Constructor, sets Stock as default Entity
     * sets transaction queue from given GeneralObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralObjects that holds the transaction queue
     */
    public BLstock(BLtable transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }

    /**
     * Check if stock is already there
     * if not, insert new stock
     * if so, add volume to existing stock
     * @param stock: stock with volume to add
     * @throws DBException
     * @throws DataException 
     */
    public void addStock(IStock newstock) throws DBException, DataException {
        Stock stock = getStock(newstock.getPrimaryKey());
        if(stock==null) {
            this.trans_insertStock(newstock);
        } else {
            stock.setAmount(stock.getAmount() + newstock.getAmount());
            this.trans_updateStock(stock);
        }
        Commit2DB();
    }
    
    /**
     * Check if stock is already there
     * if not, do nothing
     * if so, subtract volume from existing stock
     * @param stock: stock with volume to remove
     * @throws DBException
     * @throws DataException 
     */
    public void removeStock(IStock newstock) throws DBException, DataException {
        BLstocktrade blstocktrade = new BLstocktrade(this);
        Stock stock = getStock(newstock.getPrimaryKey());
        if(stock!=null) {
            stock.setAmount(stock.getAmount() - newstock.getAmount());
            if(stock.getAmount()==0) {
                blstocktrade.delete4stock(stock.getPrimaryKey());
                this.deleteStock(stock);
            } else {
                this.trans_updateStock(stock);
            }
        }
    }
    
    /**
     * Delete stock that is linked with the order in stocktrade, and stocktrade
     * @param stocktrade Stocktrade line
     * @throws DBException
     * @throws DataException 
     */
    public void sellStocktrade(Stocktrade stocktrade) throws DBException, DataException {
        BLstocktrade blstocktrade = new BLstocktrade(this);
        Stock newstock = new Stock((StockPK)stocktrade.getPrimaryKey().getStockPK());
        newstock.setAmount(stocktrade.getSellamount());
        this.removeStock(newstock);
        blstocktrade.trans_deleteStocktrade(stocktrade); 
        this.Commit2DB();
    }
    
    /**
     * Delete all Stock that is linked with orders from a system
     * @param username user name
     * @param systemid system pk
     * @throws DBException
     * @throws DataException 
     */
    public void sellall4System(String username, long systemid) throws DBException, DataException {
        //get all from stocktrade for username where linked orders are in system
        BLstocktrade blstocktrade = new BLstocktrade(this);
        ArrayList<Stocktrade> stocktradelist = blstocktrade.get4System(username, systemid);
        Stock newstock;
        for(Stocktrade stocktrade: stocktradelist) {
            newstock = new Stock((StockPK)stocktrade.getPrimaryKey().getStockPK());
            newstock.setAmount(stocktrade.getSellamount());
            this.removeStock(newstock);
            blstocktrade.trans_deleteStocktrade(stocktrade);
        }
        this.Commit2DB();
    }
    
    /**
     * try to insert Stock object in database
     * commit transaction
     * @param stock: Stock Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    @Override
    public void insertStock(IStock stock) throws DBException, DataException {
        trans_insertStock(stock);
        super.Commit2DB();
    }
    
    /**
     * try to insert Stock object in database
     * an alternative to insertStock, which can be made an empty function
     * commit transaction
     * @param stock: Stock Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void secureinsertStock(IStock stock) throws DBException, DataException {
        trans_insertStock(stock);
        super.Commit2DB();
    }
    
    /**
     * try to update Stock object in database
     * commit transaction
     * @param stock: Stock Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    @Override
    public void updateStock(IStock stock) throws DBException, DataException {
        trans_updateStock(stock);
        super.Commit2DB();
    }
    
    /**
     * try to update Stock object in database
     * an alternative to updateStock, which can be made an empty function
     * commit transaction
     * @param stock: Stock Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void secureupdateStock(IStock stock) throws DBException, DataException {
        trans_updateStock(stock);
        super.Commit2DB();
    }
    
    /**
     * try to delete Stock object in database
     * commit transaction
     * @param stock: Stock Entity Object
     * @throws eve.general.exception.CustomException
     */
    @Override
    public void deleteStock(IStock stock) throws DBException {
        trans_deleteStock(stock);
        super.Commit2DB();
    }

    /**
     * try to delete Stock object in database
     * an alternative to deleteStock, which can be made an empty function
     * commit transaction
     * @param stock: Stock Entity Object
     * @throws eve.general.exception.CustomException
     */
    public void securedeleteStock(IStock stock) throws DBException {
        trans_deleteStock(stock);
        super.Commit2DB();
    }

    /**
     * try to insert Stock object in database
     * do not commit transaction
     * @param stock: Stock Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void trans_insertStock(IStock stock) throws DBException, DataException {
        super.checkDATA(stock);
        super.insertStock((Stock)stock);
    }
    
    /**
     * try to update Stock object in database
     * do not commit transaction
     * @param stock: Stock Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void trans_updateStock(IStock stock) throws DBException, DataException {
        super.checkDATA(stock);
        super.updateStock((Stock)stock);
    }
    
    /**
     * try to delete Stock object in database
     * do not commit transaction
     * @param stock: Stock Entity Object
     * @throws eve.general.exception.CustomException
     */
    public void trans_deleteStock(IStock stock) throws DBException {
        super.deleteStock((Stock)stock);
    }
}
