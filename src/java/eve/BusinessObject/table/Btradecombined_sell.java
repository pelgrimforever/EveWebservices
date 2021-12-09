/*
 * Btradecombined_sell.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 9.11.2021 14:30
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
import eve.conversion.json.JSONTradecombined_sell;
import eve.conversion.entity.EMtradecombined_sell;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.ITradecombined_sellsearch;
import eve.logicentity.Tradecombined_sell;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Business Entity class Btradecombined_sell
 *
 * Superclass for manipulating data- and database objects
 * for Entity Tradecombined_sell and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Btradecombined_sell extends BLtable {

    /**
     * Constructor, sets Tradecombined_sell as default Entity
     */
    public Btradecombined_sell() {
        super(new Tradecombined_sell(), new EMtradecombined_sell());
    }

    /**
     * Constructor, sets Tradecombined_sell as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Btradecombined_sell(BLtable transactionobject) {
        super(transactionobject, new Tradecombined_sell(), new EMtradecombined_sell());
    }

    /**
     * create new empty Tradecombined_sell object
     * @return empty ITradecombined_sell
     */
    public ITradecombined_sell newTradecombined_sell() {
    	return new Tradecombined_sell();
    }
    
    /**
     * create new empty Tradecombined_sell object
     * create new primary key with given parameters
     * @param sell_system primary key field
     * @param buy_system primary key field
     * @param evetype primary key field
     * @param buy_order_id primary key field
     * @param sell_order_id primary key field
     * @return ITradecombined_sell with primary key
     */
    public ITradecombined_sell newTradecombined_sell(long sell_system, long buy_system, long evetype, long buy_order_id, long sell_order_id) {
        return new Tradecombined_sell(sell_system, buy_system, evetype, buy_order_id, sell_order_id);
    }

    /**
     * create new empty Tradecombined_sell object with given primary key
     * @param tradecombined_sellPK: primary key for Tradecombined_sell
     * @return ITradecombined_sell with primary key
     */
    public ITradecombined_sell newTradecombined_sell(ITradecombined_sellPK tradecombined_sellPK) {
        return new Tradecombined_sell((Tradecombined_sellPK)tradecombined_sellPK);
    }

    /**
     * create new empty primary key
     * @return empty Tradecombined_sellPK
     */
    public ITradecombined_sellPK newTradecombined_sellPK() {
        return new Tradecombined_sellPK();
    }

    /**
     * create new primary key with given parameters
     * @param sell_system primary key field
     * @param buy_system primary key field
     * @param evetype primary key field
     * @param buy_order_id primary key field
     * @param sell_order_id primary key field
     * @return new ITradecombined_sellPK
     */
    public ITradecombined_sellPK newTradecombined_sellPK(long sell_system, long buy_system, long evetype, long buy_order_id, long sell_order_id) {
        return new Tradecombined_sellPK(sell_system, buy_system, evetype, buy_order_id, sell_order_id);
    }

    /**
     * get all Tradecombined_sell objects from database
     * @return ArrayList of Tradecombined_sell objects
     * @throws DBException
     */
    public ArrayList<Tradecombined_sell> getTradecombined_sells() throws DBException {
        return (ArrayList<Tradecombined_sell>)super.getEntities(EMtradecombined_sell.SQLSelectAll);
    }

    /**
     * search Tradecombined_sell for primary key
     * @param tradecombined_sellPK: Tradecombined_sell primary key
     * @return Tradecombined_sell object
     * @throws DBException
     */
    public Tradecombined_sell getTradecombined_sell(ITradecombined_sellPK tradecombined_sellPK) throws DBException {
        return (Tradecombined_sell)super.getEntity((Tradecombined_sellPK)tradecombined_sellPK);
    }

    /**
     * search tradecombined_sell with ITradecombined_sellsearch parameters
     * @param search ITradecombined_sellsearch
     * @return ArrayList of Tradecombined_sell
     * @throws DBException 
     */
    public ArrayList<Tradecombined_sell> searchtradecombined_sells(ITradecombined_sellsearch search) throws DBException {
        return (ArrayList<Tradecombined_sell>)this.search(search);
    }

    /**
     * search tradecombined_sell with ITradecombined_sellsearch parameters, order by orderby sql clause
     * @param search ITradecombined_sellsearch
     * @param orderby sql order by string
     * @return ArrayList of Tradecombined_sell
     * @throws DBException 
     */
    public ArrayList<Tradecombined_sell> searchtradecombined_sells(ITradecombined_sellsearch search, String orderby) throws DBException {
        return (ArrayList<Tradecombined_sell>)this.search(search, orderby);
    }

    /**
     * Search tradecombined_sell in database for tradecombined_sellPK:
     * @param tradecombined_sellPK: Tradecombined_sell Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getTradecombined_sellExists(ITradecombined_sellPK tradecombined_sellPK) throws DBException {
        return super.getEntityExists((Tradecombined_sellPK)tradecombined_sellPK);
    }

    /**
     * try to insert Tradecombined_sell in database
     * @param tradecombined_sell Tradecombined_sell object
     * @throws DBException
     * @throws DataException
     */
    public void insertTradecombined_sell(ITradecombined_sell tradecombined_sell) throws DBException, DataException {
        super.insertEntity(tradecombined_sell);
    }

    /**
     * check if Tradecombined_sellPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param tradecombined_sell Tradecombined_sell object
     * @throws DBException
     * @throws DataException
     */
    public void insertupdateTradecombined_sell(ITradecombined_sell tradecombined_sell) throws DBException, DataException {
        if(this.getTradecombined_sellExists(tradecombined_sell.getPrimaryKey())) {
            super.updateEntity(tradecombined_sell);
        } else {
            super.insertEntity(tradecombined_sell);
        }
    }

    /**
     * try to update Tradecombined_sell in database
     * @param tradecombined_sell Tradecombined_sell object
     * @throws DBException
     * @throws DataException
     */
    public void updateTradecombined_sell(ITradecombined_sell tradecombined_sell) throws DBException, DataException {
        super.updateEntity(tradecombined_sell);
    }

    /**
     * try to delete Tradecombined_sell in database
     * @param tradecombined_sell Tradecombined_sell object
     * @throws DBException
     */
    public void deleteTradecombined_sell(ITradecombined_sell tradecombined_sell) throws DBException {
        cascadedeleteTradecombined_sell(tradecombined_sell.getPrimaryKey());
        super.deleteEntity(tradecombined_sell);
    }

    /**
     * check data rules in Tradecombined_sell, throw DataException with customized message if rules do not apply
     * @param tradecombined_sell Tradecombined_sell object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(ITradecombined_sell tradecombined_sell) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //foreign key Tradecombined_sell.Sell_system - Tradecombined.Sell_system
        //foreign key Tradecombined_sell.Buy_system - Tradecombined.Buy_system
        //foreign key Tradecombined_sell.Evetype - Tradecombined.Evetype
        //foreign key Tradecombined_sell.Buy_order_id - Orders.Id
        //foreign key Tradecombined_sell.Sell_order_id - Orders.Id
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where tradecombined_sellPK is used in a primary key
     * @param tradecombined_sellPK: Tradecombined_sell primary key
     */
    public void cascadedeleteTradecombined_sell(ITradecombined_sellPK tradecombined_sellPK) {
    }

    /**
     * @param ordersPK: foreign key for Orders
     * @delete all Tradecombined_sell Entity objects for Orders in database
     */
    public void delete4ordersBuy_order_id(IOrdersPK ordersPK) {
        super.addStatement(EMtradecombined_sell.SQLDelete4ordersBuy_order_id, ordersPK.getSQLprimarykey());
    }

    /**
     * @param ordersPK: foreign key for Orders
     * @return all Tradecombined_sell Entity objects for Orders
     * @throws CustomException
     */
    public ArrayList<Tradecombined_sell> getTradecombined_sells4ordersBuy_order_id(IOrdersPK ordersPK) throws CustomException {
        return super.getEntities(EMtradecombined_sell.SQLSelect4ordersBuy_order_id, ordersPK.getSQLprimarykey());
    }
    /**
     * @param ordersPK: foreign key for Orders
     * @delete all Tradecombined_sell Entity objects for Orders in database
     */
    public void delete4ordersSell_order_id(IOrdersPK ordersPK) {
        super.addStatement(EMtradecombined_sell.SQLDelete4ordersSell_order_id, ordersPK.getSQLprimarykey());
    }

    /**
     * @param ordersPK: foreign key for Orders
     * @return all Tradecombined_sell Entity objects for Orders
     * @throws CustomException
     */
    public ArrayList<Tradecombined_sell> getTradecombined_sells4ordersSell_order_id(IOrdersPK ordersPK) throws CustomException {
        return super.getEntities(EMtradecombined_sell.SQLSelect4ordersSell_order_id, ordersPK.getSQLprimarykey());
    }
    /**
     * @param tradecombinedPK: foreign key for Tradecombined
     * @delete all Tradecombined_sell Entity objects for Tradecombined in database
     */
    public void delete4tradecombined(ITradecombinedPK tradecombinedPK) {
        super.addStatement(EMtradecombined_sell.SQLDelete4tradecombined, tradecombinedPK.getSQLprimarykey());
    }

    /**
     * @param tradecombinedPK: foreign key for Tradecombined
     * @return all Tradecombined_sell Entity objects for Tradecombined
     * @throws CustomException
     */
    public ArrayList<Tradecombined_sell> getTradecombined_sells4tradecombined(ITradecombinedPK tradecombinedPK) throws CustomException {
        return super.getEntities(EMtradecombined_sell.SQLSelect4tradecombined, tradecombinedPK.getSQLprimarykey());
    }

    /**
     * get all Tradecombined_sell objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @param sortlist sql sort string
     * @param sortoperator asc/desc
     * @return ArrayList of Tradecombined_sell objects
     * @throws DBException
     */
    public ArrayList<Tradecombined_sell> getTradecombined_sells(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMtradecombined_sell.SQLSelect);
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
        return (ArrayList<Tradecombined_sell>)super.getEntities(sql.toString(), sqlparameters);
    }

    /**
     * delete all Tradecombined_sell objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @throws DBException
     */
    public void delTradecombined_sell(SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Tradecombined_sell.table);
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
