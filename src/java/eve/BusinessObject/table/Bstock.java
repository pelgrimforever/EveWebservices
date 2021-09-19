/*
 * Bstock.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 18.8.2021 11:31
 *
 */

package eve.BusinessObject.table;

import BusinessObject.GeneralEntityInterface;
import BusinessObject.GeneralEntityObject;
import general.exception.*;
import java.util.ArrayList;

import data.gis.shape.*;
import data.json.piJson;
import data.json.psqlJsonobject;
import db.SQLMapper_pgsql;
import data.interfaces.db.Filedata;
import eve.BusinessObject.Logic.*;
import eve.conversion.json.JSONStock;
import eve.data.ProjectConstants;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.IStocksearch;
import eve.logicentity.Stock;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Business Entity class Bstock
 *
 * Superclass for manipulating data- and database objects
 * for Entity Stock and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bstock extends GeneralEntityObject implements ProjectConstants {

    /**
     * Constructor, sets Stock as default Entity
     */
    public Bstock() {
        super(new SQLMapper_pgsql(connectionpool, "Stock"), new Stock());
    }

    /**
     * Constructor, sets Stock as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bstock(GeneralEntityInterface transactionobject) {
        super(transactionobject, new Stock());
    }

    /**
     * Map ResultSet Field values to Stock
     * @param dbresult: Database ResultSet
     */
    public Stock mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        StockPK stockPK = null;
        Stock stock;
        if(dbresult==null) {
            stock = new Stock(stockPK);
        } else {
            try {
                stockPK = new StockPK(dbresult.getString("username"), dbresult.getLong("evetype"));
                stock = new Stock(stockPK);
                stock.initAmount(dbresult.getLong("amount"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        this.loadExtra(dbresult, stock);
        return stock;
    }

    /**
     * create new empty Stock object
     * @return empty IStock
     */
    public IStock newStock() {
    	return new Stock();
    }
    
    /**
     * create new empty Stock object
     * create new primary key with given parameters
     * @return IStock with primary key
     */
    public IStock newStock(java.lang.String username, long evetype) {
        return new Stock(username, evetype);
    }

    /**
     * create new empty Stock object with given primary key
     * @param stockPK: primary key for Stock
     * @return IStock with primary key
     */
    public IStock newStock(IStockPK stockPK) {
        return new Stock((StockPK)stockPK);
    }

    /**
     * create new empty primary key
     * @return empty StockPK
     */
    public IStockPK newStockPK() {
        return new StockPK();
    }

    /**
     * create new primary key with given parameters
     * @return new IStockPK
     */
    public IStockPK newStockPK(java.lang.String username, long evetype) {
        return new StockPK(username, evetype);
    }

    /**
     * get all Stock objects from database
     * @return ArrayList of Stock objects
     * @throws DBException
     */
    public ArrayList getStocks() throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Stock.SQLSelectAll);
        } else return new ArrayList();
    }

    /**
     * search Stock for primary key
     * @param stockPK: Stock primary key
     * @return Stock object
     * @throws DBException
     */
    public Stock getStock(IStockPK stockPK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return (Stock)super.getEntity((StockPK)stockPK);
        } else return null;
    }

    public ArrayList searchstocks(IStocksearch search) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return this.search(search);
        } else return new ArrayList();
    }

    public ArrayList searchstocks(IStocksearch search, String orderby) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return this.search(search, orderby);
        } else return new ArrayList();
    }

    /**
     * Search stock in database for stockPK:
     * @param stockPK: Stock Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getStockExists(IStockPK stockPK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return super.getEntityExists((StockPK)stockPK);
        } else return false;
    }

    /**
     * try to insert Stock in database
     * @param film: Stock object
     * @throws DBException
     */
    public void insertStock(IStock stock) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.insertEntity(stock);
        }
    }

    /**
     * check if StockPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param film: Stock object
     * @throws DBException
     */
    public void insertupdateStock(IStock stock) throws DBException, DataException {
        if(this.getStockExists(stock.getPrimaryKey())) {
            super.updateEntity(stock);
        } else {
            super.insertEntity(stock);
        }
    }

    /**
     * try to update Stock in database
     * @param film: Stock object
     * @throws DBException
     */
    public void updateStock(IStock stock) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.updateEntity(stock);
        }
    }

    /**
     * try to delete Stock in database
     * @param film: Stock object
     * @throws DBException
     */
    public void deleteStock(IStock stock) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            cascadedeleteStock(stock.getOwnerobject(), stock.getPrimaryKey());
            super.deleteEntity(stock);
        }
    }

    /**
     * check data rules in Stock, throw DataException with customized message if rules do not apply
     * @param film: Stock object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(IStock stock) throws DataException, DBException {
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
    public void cascadedeleteStock(String senderobject, IStockPK stockPK) {
        BLstocktrade blstocktrade = new BLstocktrade(this);
        blstocktrade.delete4stock(senderobject, stockPK);
    }

    /**
     * @param evetypePK: foreign key for Evetype
     * @delete all Stock Entity objects for Evetype in database
     * @throws eve.general.exception.CustomException
     */
    public void delete4evetype(String senderobject, IEvetypePK evetypePK) {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.addStatement(senderobject, Stock.SQLDelete4evetype, evetypePK.getKeyFields());
        }
    }

    /**
     * @param evetypePK: foreign key for Evetype
     * @return all Stock Entity objects for Evetype
     * @throws eve.general.exception.CustomException
     */
    public ArrayList getStocks4evetype(IEvetypePK evetypePK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Stock.SQLSelect4evetype, evetypePK.getKeyFields());
        } else return new ArrayList();
    }
    /**
     * @param stocktradePK: parent Stocktrade for child object Stock Entity
     * @return child Stock Entity object
     * @throws eve.general.exception.CustomException
     */
    public IStock getStocktrade(IStocktradePK stocktradePK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            StockPK stockPK = new StockPK(stocktradePK.getUsername(), stocktradePK.getEvetype());
            return this.getStock(stockPK);
        } else return null;
    }


    /**
     * get all Stock objects for sqlparameters
     * @return ArrayList of Stock objects
     * @throws DBException
     */
    public ArrayList getStocks(Object[][] sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        String sql =  Stock.SQLSelect;
        int l = sqlparameters.length;
        if(sqlparameters.length>0) {
            sql += " where ";
            for(int i=0; i<l; i++) {
                sql += String.valueOf(sqlparameters[i][0]) + " = :" + String.valueOf(sqlparameters[i][0]) + ": ";
                if(i<l-1) sql += " " + andoroperator + " ";
            }
        }
        if(sortlist.length()>0) {
            sql += " order by " + sortlist + " " + sortoperator;
        }
        return getMapper().loadEntityVector(this, sql, sqlparameters);
    }

    /**
     * delete all Stock objects for sqlparameters
     * @throws DBException
     */
    public void delStock(String senderobject, Object[][] sqlparameters, String andoroperator) throws DBException {
        String sql =  "Delete from " + Stock.table;
        int l = sqlparameters.length;
        if(sqlparameters.length>0) {
            sql += " where ";
            for(int i=0; i<l; i++) {
                sql += String.valueOf(sqlparameters[i][0]) + " = :" + String.valueOf(sqlparameters[i][0]) + ": ";
                if(i<l-1) sql += " " + andoroperator + " ";
            }
        }
        this.addStatement(senderobject, sql, sqlparameters);
    }


}
