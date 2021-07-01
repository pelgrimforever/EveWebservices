/*
 * Btrade.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 30.5.2021 15:39
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
import eve.conversion.json.JSONTrade;
import eve.data.ProjectConstants;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.ITradesearch;
import eve.logicentity.Trade;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Business Entity class Btrade
 *
 * Superclass for manipulating data- and database objects
 * for Entity Trade and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Btrade extends GeneralEntityObject implements ProjectConstants {

    /**
     * Constructor, sets Trade as default Entity
     */
    public Btrade() {
        super(new SQLMapper_pgsql(connectionpool, "Trade"), new Trade());
    }

    /**
     * Constructor, sets Trade as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Btrade(GeneralEntityInterface transactionobject) {
        super(transactionobject, new Trade());
    }

    /**
     * Map ResultSet Field values to Trade
     * @param dbresult: Database ResultSet
     */
    public Trade mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        TradePK tradePK = null;
        Trade trade;
        if(dbresult==null) {
            trade = new Trade(tradePK);
        } else {
            try {
                tradePK = new TradePK(dbresult.getLong("sell_order_id"), dbresult.getLong("buy_order_id"));
                trade = new Trade(tradePK);
                trade.initTotal_volume(dbresult.getDouble("total_volume"));
                trade.initBuy_order_value(dbresult.getDouble("buy_order_value"));
                trade.initSell_order_value(dbresult.getDouble("sell_order_value"));
                trade.initProfit(dbresult.getDouble("profit"));
                trade.initJumps(dbresult.getInt("jumps"));
                trade.initRuns(dbresult.getInt("runs"));
                trade.initTotal_jumps(dbresult.getInt("total_jumps"));
                trade.initProfit_per_jump(dbresult.getDouble("profit_per_jump"));
                trade.initSinglerun_profit_per_jump(dbresult.getDouble("singlerun_profit_per_jump"));
                trade.initMaxunits_per_run(dbresult.getInt("maxunits_per_run"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        this.loadExtra(dbresult, trade);
        return trade;
    }

    /**
     * create new empty Trade object
     * @return empty ITrade
     */
    public ITrade newTrade() {
    	return new Trade();
    }
    
    /**
     * create new empty Trade object
     * create new primary key with given parameters
     * @return ITrade with primary key
     */
    public ITrade newTrade(long sell_order_id, long buy_order_id) {
        return new Trade(sell_order_id, buy_order_id);
    }

    /**
     * create new empty Trade object with given primary key
     * @param tradePK: primary key for Trade
     * @return ITrade with primary key
     */
    public ITrade newTrade(ITradePK tradePK) {
        return new Trade((TradePK)tradePK);
    }

    /**
     * create new empty primary key
     * @return empty TradePK
     */
    public ITradePK newTradePK() {
        return new TradePK();
    }

    /**
     * create new primary key with given parameters
     * @return new ITradePK
     */
    public ITradePK newTradePK(long sell_order_id, long buy_order_id) {
        return new TradePK(sell_order_id, buy_order_id);
    }

    /**
     * get all Trade objects from database
     * @return ArrayList of Trade objects
     * @throws DBException
     */
    public ArrayList getTrades() throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Trade.SQLSelectAll);
        } else return new ArrayList();
    }

    /**
     * search Trade for primary key
     * @param tradePK: Trade primary key
     * @return Trade object
     * @throws DBException
     */
    public Trade getTrade(ITradePK tradePK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return (Trade)super.getEntity((TradePK)tradePK);
        } else return null;
    }

    public ArrayList searchtrades(ITradesearch search) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return this.search(search);
        } else return new ArrayList();
    }

    public ArrayList searchtrades(ITradesearch search, String orderby) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return this.search(search, orderby);
        } else return new ArrayList();
    }

    /**
     * Search trade in database for tradePK:
     * @param tradePK: Trade Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getTradeExists(ITradePK tradePK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return super.getEntityExists((TradePK)tradePK);
        } else return false;
    }

    /**
     * try to insert Trade in database
     * @param film: Trade object
     * @throws DBException
     */
    public void insertTrade(ITrade trade) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.insertEntity(trade);
        }
    }

    /**
     * check if TradePK exists
     * insert if not, update if found
     * do not commit transaction
     * @param film: Trade object
     * @throws DBException
     */
    public void insertupdateTrade(ITrade trade) throws DBException, DataException {
        if(this.getTradeExists(trade.getPrimaryKey())) {
            super.updateEntity(trade);
        } else {
            super.insertEntity(trade);
        }
    }

    /**
     * try to update Trade in database
     * @param film: Trade object
     * @throws DBException
     */
    public void updateTrade(ITrade trade) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.updateEntity(trade);
        }
    }

    /**
     * try to delete Trade in database
     * @param film: Trade object
     * @throws DBException
     */
    public void deleteTrade(ITrade trade) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            cascadedeleteTrade(trade.getOwnerobject(), trade.getPrimaryKey());
            super.deleteEntity(trade);
        }
    }

    /**
     * check data rules in Trade, throw DataException with customized message if rules do not apply
     * @param film: Trade object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(ITrade trade) throws DataException, DBException {
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
    public void cascadedeleteTrade(String senderobject, ITradePK tradePK) {
    }

    /**
     * @param ordersPK: foreign key for Orders
     * @delete all Trade Entity objects for Orders in database
     * @throws eve.general.exception.CustomException
     */
    public void delete4ordersSell_order_id(String senderobject, IOrdersPK ordersPK) {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.addStatement(senderobject, Trade.SQLDelete4ordersSell_order_id, ordersPK.getKeyFields());
        }
    }

    /**
     * @param ordersPK: foreign key for Orders
     * @return all Trade Entity objects for Orders
     * @throws eve.general.exception.CustomException
     */
    public ArrayList getTrades4ordersSell_order_id(IOrdersPK ordersPK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Trade.SQLSelect4ordersSell_order_id, ordersPK.getKeyFields());
        } else return new ArrayList();
    }
    /**
     * @param ordersPK: foreign key for Orders
     * @delete all Trade Entity objects for Orders in database
     * @throws eve.general.exception.CustomException
     */
    public void delete4ordersBuy_order_id(String senderobject, IOrdersPK ordersPK) {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.addStatement(senderobject, Trade.SQLDelete4ordersBuy_order_id, ordersPK.getKeyFields());
        }
    }

    /**
     * @param ordersPK: foreign key for Orders
     * @return all Trade Entity objects for Orders
     * @throws eve.general.exception.CustomException
     */
    public ArrayList getTrades4ordersBuy_order_id(IOrdersPK ordersPK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Trade.SQLSelect4ordersBuy_order_id, ordersPK.getKeyFields());
        } else return new ArrayList();
    }

    /**
     * get all Trade objects for sqlparameters
     * @return ArrayList of Trade objects
     * @throws DBException
     */
    public ArrayList getTrades(Object[][] sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        String sql =  Trade.SQLSelect;
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
     * delete all Trade objects for sqlparameters
     * @throws DBException
     */
    public void delTrade(String senderobject, Object[][] sqlparameters, String andoroperator) throws DBException {
        String sql =  "Delete from " + Trade.table;
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
