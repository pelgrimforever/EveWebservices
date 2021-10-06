/*
 * Bstocktrade.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 6.9.2021 16:29
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
import eve.conversion.json.JSONStocktrade;
import eve.data.ProjectConstants;
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
public abstract class Bstocktrade extends GeneralEntityObject implements ProjectConstants {

    /**
     * Constructor, sets Stocktrade as default Entity
     */
    public Bstocktrade() {
        super(new SQLMapper_pgsql(connectionpool, "Stocktrade"), new Stocktrade());
    }

    /**
     * Constructor, sets Stocktrade as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bstocktrade(GeneralEntityInterface transactionobject) {
        super(transactionobject, new Stocktrade());
    }

    /**
     * Map ResultSet Field values to Stocktrade
     * @param dbresult: Database ResultSet
     */
    public Stocktrade mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        StocktradePK stocktradePK = null;
        Stocktrade stocktrade;
        if(dbresult==null) {
            stocktrade = new Stocktrade(stocktradePK);
        } else {
            try {
                stocktradePK = new StocktradePK(dbresult.getString("username"), dbresult.getLong("evetype"), dbresult.getLong("orderid"));
                stocktrade = new Stocktrade(stocktradePK);
                stocktrade.initSellamount(dbresult.getLong("sellamount"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        this.loadExtra(dbresult, stocktrade);
        return stocktrade;
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
    public ArrayList getStocktrades() throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Stocktrade.SQLSelectAll);
        } else return new ArrayList();
    }

    /**
     * search Stocktrade for primary key
     * @param stocktradePK: Stocktrade primary key
     * @return Stocktrade object
     * @throws DBException
     */
    public Stocktrade getStocktrade(IStocktradePK stocktradePK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return (Stocktrade)super.getEntity((StocktradePK)stocktradePK);
        } else return null;
    }

    public ArrayList searchstocktrades(IStocktradesearch search) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return this.search(search);
        } else return new ArrayList();
    }

    public ArrayList searchstocktrades(IStocktradesearch search, String orderby) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return this.search(search, orderby);
        } else return new ArrayList();
    }

    /**
     * Search stocktrade in database for stocktradePK:
     * @param stocktradePK: Stocktrade Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getStocktradeExists(IStocktradePK stocktradePK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return super.getEntityExists((StocktradePK)stocktradePK);
        } else return false;
    }

    /**
     * try to insert Stocktrade in database
     * @param film: Stocktrade object
     * @throws DBException
     */
    public void insertStocktrade(IStocktrade stocktrade) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.insertEntity(stocktrade);




        }
    }

    /**
     * check if StocktradePK exists
     * insert if not, update if found
     * do not commit transaction
     * @param film: Stocktrade object
     * @throws DBException
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
     * @param film: Stocktrade object
     * @throws DBException
     */
    public void updateStocktrade(IStocktrade stocktrade) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.updateEntity(stocktrade);




        }
    }

    /**
     * try to delete Stocktrade in database
     * @param film: Stocktrade object
     * @throws DBException
     */
    public void deleteStocktrade(IStocktrade stocktrade) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            cascadedeleteStocktrade(stocktrade.getOwnerobject(), stocktrade.getPrimaryKey());
            super.deleteEntity(stocktrade);
        }
    }

    /**
     * check data rules in Stocktrade, throw DataException with customized message if rules do not apply
     * @param film: Stocktrade object
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
    public void cascadedeleteStocktrade(String senderobject, IStocktradePK stocktradePK) {
    }

    /**
     * @param stockPK: foreign key for Stock
     * @delete all Stocktrade Entity objects for Stock in database
     * @throws eve.general.exception.CustomException
     */
    public void delete4stock(String senderobject, IStockPK stockPK) {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.addStatement(senderobject, Stocktrade.SQLDelete4stock, stockPK.getKeyFields());
        }
    }

    /**
     * @param stockPK: foreign key for Stock
     * @return all Stocktrade Entity objects for Stock
     * @throws eve.general.exception.CustomException
     */
    public ArrayList getStocktrades4stock(IStockPK stockPK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Stocktrade.SQLSelect4stock, stockPK.getKeyFields());
        } else return new ArrayList();
    }

    /**
     * get all Stocktrade objects for sqlparameters
     * @return ArrayList of Stocktrade objects
     * @throws DBException
     */
    public ArrayList getStocktrades(Object[][] sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        String sql =  Stocktrade.SQLSelect;
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
     * delete all Stocktrade objects for sqlparameters
     * @throws DBException
     */
    public void delStocktrade(String senderobject, Object[][] sqlparameters, String andoroperator) throws DBException {
        String sql =  "Delete from " + Stocktrade.table;
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