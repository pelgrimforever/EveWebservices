/*
 * Bstock.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 14.0.2022 16:56
 *
 */

package eve.BusinessObject.table;

import BusinessObject.BLtable;
import general.exception.*;
import java.util.ArrayList;
import db.SQLMapperFactory;
import db.SQLparameters;
import data.gis.shape.*;
import data.json.piJson;
import data.json.psqlJsonobject;
import db.SQLMapper_pgsql;
import data.interfaces.db.Filedata;
import eve.BusinessObject.Logic.*;
import eve.conversion.json.JSONStock;
import eve.conversion.entity.EMstock;
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
public abstract class Bstock extends BLtable {

    /**
     * Constructor, sets Stock as default Entity
     */
    public Bstock() {
        super(new Stock(), new EMstock());
    }

    /**
     * Constructor, sets Stock as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bstock(BLtable transactionobject) {
        super(transactionobject, new Stock(), new EMstock());
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
     * @param username primary key field
     * @param evetype primary key field
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
     * @param username primary key field
     * @param evetype primary key field
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
    public ArrayList<Stock> getStocks() throws DBException {
        return (ArrayList<Stock>)super.getEntities(EMstock.SQLSelectAll);
    }

    /**
     * search Stock for primary key
     * @param stockPK: Stock primary key
     * @return Stock object
     * @throws DBException
     */
    public Stock getStock(IStockPK stockPK) throws DBException {
        return (Stock)super.getEntity((StockPK)stockPK);
    }

    /**
     * search stock with IStocksearch parameters
     * @param search IStocksearch
     * @return ArrayList of Stock
     * @throws DBException 
     */
    public ArrayList<Stock> searchstocks(IStocksearch search) throws DBException {
        return (ArrayList<Stock>)this.search(search);
    }

    /**
     * search stock with IStocksearch parameters, order by orderby sql clause
     * @param search IStocksearch
     * @param orderby sql order by string
     * @return ArrayList of Stock
     * @throws DBException 
     */
    public ArrayList<Stock> searchstocks(IStocksearch search, String orderby) throws DBException {
        return (ArrayList<Stock>)this.search(search, orderby);
    }

    /**
     * Search stock in database for stockPK:
     * @param stockPK: Stock Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getStockExists(IStockPK stockPK) throws DBException {
        return super.getEntityExists((StockPK)stockPK);
    }

    /**
     * try to insert Stock in database
     * @param stock Stock object
     * @throws DBException
     * @throws DataException
     */
    public void insertStock(IStock stock) throws DBException, DataException {
        super.insertEntity(stock);
    }

    /**
     * check if StockPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param stock Stock object
     * @throws DBException
     * @throws DataException
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
     * @param stock Stock object
     * @throws DBException
     * @throws DataException
     */
    public void updateStock(IStock stock) throws DBException, DataException {
        super.updateEntity(stock);
    }

    /**
     * try to delete Stock in database
     * @param stock Stock object
     * @throws DBException
     */
    public void deleteStock(IStock stock) throws DBException {
        cascadedeleteStock(stock.getPrimaryKey());
        super.deleteEntity(stock);
    }

    /**
     * check data rules in Stock, throw DataException with customized message if rules do not apply
     * @param stock Stock object
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
    public void cascadedeleteStock(IStockPK stockPK) {
        BLstocktrade blstocktrade = new BLstocktrade(this);
        blstocktrade.delete4stock(stockPK);
    }

    /**
     * @param evetypePK: foreign key for Evetype
     * @delete all Stock Entity objects for Evetype in database
     */
    public void delete4evetype(IEvetypePK evetypePK) {
        super.addStatement(EMstock.SQLDelete4evetype, evetypePK.getSQLprimarykey());
    }

    /**
     * @param evetypePK: foreign key for Evetype
     * @return all Stock Entity objects for Evetype
     * @throws CustomException
     */
    public ArrayList<Stock> getStocks4evetype(IEvetypePK evetypePK) throws CustomException {
        return super.getEntities(EMstock.SQLSelect4evetype, evetypePK.getSQLprimarykey());
    }
    /**
     * @param stocktradePK: parent Stocktrade for child object Stock Entity
     * @return child Stock Entity object
     * @throws CustomException
     */
    public Stock getStocktrade(IStocktradePK stocktradePK) throws CustomException {
        StockPK stockPK = new StockPK(stocktradePK.getUsername(), stocktradePK.getEvetype());
        return this.getStock(stockPK);
    }


    /**
     * get all Stock objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @param sortlist sql sort string
     * @param sortoperator asc/desc
     * @return ArrayList of Stock objects
     * @throws DBException
     */
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
        return (ArrayList<Stock>)super.getEntities(sql.toString(), sqlparameters);
    }

    /**
     * delete all Stock objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @throws DBException
     */
    public void delStock(SQLparameters sqlparameters, String andoroperator) throws DBException {
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
        this.addStatement(sql.toString(), sqlparameters);
    }


}
