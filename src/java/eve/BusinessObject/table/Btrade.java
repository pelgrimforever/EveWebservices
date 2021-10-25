/*
 * Btrade.java
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
import eve.conversion.json.JSONTrade;
import eve.conversion.entity.EMtrade;
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
public abstract class Btrade extends BLtable {

    /**
     * Constructor, sets Trade as default Entity
     */
    public Btrade() {
        super(new Trade(), new EMtrade());
    }

    /**
     * Constructor, sets Trade as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Btrade(BLtable transactionobject) {
        super(transactionobject, new Trade(), new EMtrade());
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
     * @param sell_order_id primary key field
     * @param buy_order_id primary key field
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
     * @param sell_order_id primary key field
     * @param buy_order_id primary key field
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
    public ArrayList<Trade> getTrades() throws DBException {
        return (ArrayList<Trade>)super.getEntities(EMtrade.SQLSelectAll);
    }

    /**
     * search Trade for primary key
     * @param tradePK: Trade primary key
     * @return Trade object
     * @throws DBException
     */
    public Trade getTrade(ITradePK tradePK) throws DBException {
        return (Trade)super.getEntity((TradePK)tradePK);
    }

    /**
     * search trade with ITradesearch parameters
     * @param search ITradesearch
     * @return ArrayList of Trade
     * @throws DBException 
     */
    public ArrayList<Trade> searchtrades(ITradesearch search) throws DBException {
        return (ArrayList<Trade>)this.search(search);
    }

    /**
     * search trade with ITradesearch parameters, order by orderby sql clause
     * @param search ITradesearch
     * @param orderby sql order by string
     * @return ArrayList of Trade
     * @throws DBException 
     */
    public ArrayList<Trade> searchtrades(ITradesearch search, String orderby) throws DBException {
        return (ArrayList<Trade>)this.search(search, orderby);
    }

    /**
     * Search trade in database for tradePK:
     * @param tradePK: Trade Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getTradeExists(ITradePK tradePK) throws DBException {
        return super.getEntityExists((TradePK)tradePK);
    }

    /**
     * try to insert Trade in database
     * @param trade Trade object
     * @throws DBException
     * @throws DataException
     */
    public void insertTrade(ITrade trade) throws DBException, DataException {
        super.insertEntity(trade);
    }

    /**
     * check if TradePK exists
     * insert if not, update if found
     * do not commit transaction
     * @param trade Trade object
     * @throws DBException
     * @throws DataException
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
     * @param trade Trade object
     * @throws DBException
     * @throws DataException
     */
    public void updateTrade(ITrade trade) throws DBException, DataException {
        super.updateEntity(trade);
    }

    /**
     * try to delete Trade in database
     * @param trade Trade object
     * @throws DBException
     */
    public void deleteTrade(ITrade trade) throws DBException {
        cascadedeleteTrade(trade.getPrimaryKey());
        super.deleteEntity(trade);
    }

    /**
     * check data rules in Trade, throw DataException with customized message if rules do not apply
     * @param trade Trade object
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
    public void cascadedeleteTrade(ITradePK tradePK) {
    }

    /**
     * @param ordersPK: foreign key for Orders
     * @delete all Trade Entity objects for Orders in database
     */
    public void delete4ordersSell_order_id(IOrdersPK ordersPK) {
        super.addStatement(EMtrade.SQLDelete4ordersSell_order_id, ordersPK.getSQLprimarykey());
    }

    /**
     * @param ordersPK: foreign key for Orders
     * @return all Trade Entity objects for Orders
     * @throws CustomException
     */
    public ArrayList<Trade> getTrades4ordersSell_order_id(IOrdersPK ordersPK) throws CustomException {
        return super.getEntities(EMtrade.SQLSelect4ordersSell_order_id, ordersPK.getSQLprimarykey());
    }
    /**
     * @param ordersPK: foreign key for Orders
     * @delete all Trade Entity objects for Orders in database
     */
    public void delete4ordersBuy_order_id(IOrdersPK ordersPK) {
        super.addStatement(EMtrade.SQLDelete4ordersBuy_order_id, ordersPK.getSQLprimarykey());
    }

    /**
     * @param ordersPK: foreign key for Orders
     * @return all Trade Entity objects for Orders
     * @throws CustomException
     */
    public ArrayList<Trade> getTrades4ordersBuy_order_id(IOrdersPK ordersPK) throws CustomException {
        return super.getEntities(EMtrade.SQLSelect4ordersBuy_order_id, ordersPK.getSQLprimarykey());
    }

    /**
     * get all Trade objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @param sortlist sql sort string
     * @param sortoperator asc/desc
     * @return ArrayList of Trade objects
     * @throws DBException
     */
    public ArrayList<Trade> getTrades(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMtrade.SQLSelect);
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
        return (ArrayList<Trade>)super.getEntities(sql.toString(), sqlparameters);
    }

    /**
     * delete all Trade objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @throws DBException
     */
    public void delTrade(SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Trade.table);
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
