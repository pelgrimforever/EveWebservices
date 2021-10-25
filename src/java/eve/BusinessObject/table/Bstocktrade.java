/*
 * Bstocktrade.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 25.9.2021 15:16
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
import eve.conversion.json.JSONStocktrade;
import eve.conversion.entity.EMstocktrade;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.IStocktradesearch;
import eve.logicentity.Stocktrade;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Business Entity class Bstocktrade
 *
 * Superclass for manipulating data- and database objects
 * for Entity Stocktrade and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bstocktrade extends BLtable {

    /**
     * Constructor, sets Stocktrade as default Entity
     */
    public Bstocktrade() {
        super(new Stocktrade(), new EMstocktrade());
    }

    /**
     * Constructor, sets Stocktrade as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bstocktrade(BLtable transactionobject) {
        super(transactionobject, new Stocktrade(), new EMstocktrade());
    }

    /**
     * create new empty Stocktrade object
     * @return empty IStocktrade
     */
    public IStocktrade newStocktrade() {
    	return new Stocktrade();
    }
    
    /**
     * create new empty Stocktrade object
     * create new primary key with given parameters
     * @param username primary key field
     * @param evetype primary key field
     * @param orderid primary key field
     * @return IStocktrade with primary key
     */
    public IStocktrade newStocktrade(java.lang.String username, long evetype, long orderid) {
        return new Stocktrade(username, evetype, orderid);
    }

    /**
     * create new empty Stocktrade object with given primary key
     * @param stocktradePK: primary key for Stocktrade
     * @return IStocktrade with primary key
     */
    public IStocktrade newStocktrade(IStocktradePK stocktradePK) {
        return new Stocktrade((StocktradePK)stocktradePK);
    }

    /**
     * create new empty primary key
     * @return empty StocktradePK
     */
    public IStocktradePK newStocktradePK() {
        return new StocktradePK();
    }

    /**
     * create new primary key with given parameters
     * @param username primary key field
     * @param evetype primary key field
     * @param orderid primary key field
     * @return new IStocktradePK
     */
    public IStocktradePK newStocktradePK(java.lang.String username, long evetype, long orderid) {
        return new StocktradePK(username, evetype, orderid);
    }

    /**
     * get all Stocktrade objects from database
     * @return ArrayList of Stocktrade objects
     * @throws DBException
     */
    public ArrayList<Stocktrade> getStocktrades() throws DBException {
        return (ArrayList<Stocktrade>)super.getEntities(EMstocktrade.SQLSelectAll);
    }

    /**
     * search Stocktrade for primary key
     * @param stocktradePK: Stocktrade primary key
     * @return Stocktrade object
     * @throws DBException
     */
    public Stocktrade getStocktrade(IStocktradePK stocktradePK) throws DBException {
        return (Stocktrade)super.getEntity((StocktradePK)stocktradePK);
    }

    /**
     * search stocktrade with IStocktradesearch parameters
     * @param search IStocktradesearch
     * @return ArrayList of Stocktrade
     * @throws DBException 
     */
    public ArrayList<Stocktrade> searchstocktrades(IStocktradesearch search) throws DBException {
        return (ArrayList<Stocktrade>)this.search(search);
    }

    /**
     * search stocktrade with IStocktradesearch parameters, order by orderby sql clause
     * @param search IStocktradesearch
     * @param orderby sql order by string
     * @return ArrayList of Stocktrade
     * @throws DBException 
     */
    public ArrayList<Stocktrade> searchstocktrades(IStocktradesearch search, String orderby) throws DBException {
        return (ArrayList<Stocktrade>)this.search(search, orderby);
    }

    /**
     * Search stocktrade in database for stocktradePK:
     * @param stocktradePK: Stocktrade Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getStocktradeExists(IStocktradePK stocktradePK) throws DBException {
        return super.getEntityExists((StocktradePK)stocktradePK);
    }

    /**
     * try to insert Stocktrade in database
     * @param stocktrade Stocktrade object
     * @throws DBException
     * @throws DataException
     */
    public void insertStocktrade(IStocktrade stocktrade) throws DBException, DataException {
        super.insertEntity(stocktrade);
    }

    /**
     * check if StocktradePK exists
     * insert if not, update if found
     * do not commit transaction
     * @param stocktrade Stocktrade object
     * @throws DBException
     * @throws DataException
     */
    public void insertupdateStocktrade(IStocktrade stocktrade) throws DBException, DataException {
        if(this.getStocktradeExists(stocktrade.getPrimaryKey())) {
            super.updateEntity(stocktrade);
        } else {
            super.insertEntity(stocktrade);
        }
    }

    /**
     * try to update Stocktrade in database
     * @param stocktrade Stocktrade object
     * @throws DBException
     * @throws DataException
     */
    public void updateStocktrade(IStocktrade stocktrade) throws DBException, DataException {
        super.updateEntity(stocktrade);
    }

    /**
     * try to delete Stocktrade in database
     * @param stocktrade Stocktrade object
     * @throws DBException
     */
    public void deleteStocktrade(IStocktrade stocktrade) throws DBException {
        cascadedeleteStocktrade(stocktrade.getPrimaryKey());
        super.deleteEntity(stocktrade);
    }

    /**
     * check data rules in Stocktrade, throw DataException with customized message if rules do not apply
     * @param stocktrade Stocktrade object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(IStocktrade stocktrade) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //foreign key Stocktrade.Username - Stock.Username
        //foreign key Stocktrade.Evetype - Stock.Evetype
        //Primary key
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where stocktradePK is used in a primary key
     * @param stocktradePK: Stocktrade primary key
     */
    public void cascadedeleteStocktrade(IStocktradePK stocktradePK) {
    }

    /**
     * @param stockPK: foreign key for Stock
     * @delete all Stocktrade Entity objects for Stock in database
     */
    public void delete4stock(IStockPK stockPK) {
        super.addStatement(EMstocktrade.SQLDelete4stock, stockPK.getSQLprimarykey());
    }

    /**
     * @param stockPK: foreign key for Stock
     * @return all Stocktrade Entity objects for Stock
     * @throws CustomException
     */
    public ArrayList<Stocktrade> getStocktrades4stock(IStockPK stockPK) throws CustomException {
        return super.getEntities(EMstocktrade.SQLSelect4stock, stockPK.getSQLprimarykey());
    }

    /**
     * get all Stocktrade objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @param sortlist sql sort string
     * @param sortoperator asc/desc
     * @return ArrayList of Stocktrade objects
     * @throws DBException
     */
    public ArrayList<Stocktrade> getStocktrades(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMstocktrade.SQLSelect);
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
        return (ArrayList<Stocktrade>)super.getEntities(sql.toString(), sqlparameters);
    }

    /**
     * delete all Stocktrade objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @throws DBException
     */
    public void delStocktrade(SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Stocktrade.table);
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
