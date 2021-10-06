/*
 * Border_history.java
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
import eve.conversion.json.JSONOrder_history;
import eve.data.ProjectConstants;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.IOrder_historysearch;
import eve.logicentity.Order_history;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Business Entity class Border_history
 *
 * Superclass for manipulating data- and database objects
 * for Entity Order_history and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Border_history extends GeneralEntityObject implements ProjectConstants {

    /**
     * Constructor, sets Order_history as default Entity
     */
    public Border_history() {
        super(new SQLMapper_pgsql(connectionpool, "Order_history"), new Order_history());
    }

    /**
     * Constructor, sets Order_history as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Border_history(GeneralEntityInterface transactionobject) {
        super(transactionobject, new Order_history());
    }

    /**
     * Map ResultSet Field values to Order_history
     * @param dbresult: Database ResultSet
     */
    public Order_history mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Order_historyPK order_historyPK = null;
        Order_history order_history;
        if(dbresult==null) {
            order_history = new Order_history(order_historyPK);
        } else {
            try {
                order_historyPK = new Order_historyPK(dbresult.getLong("region"), dbresult.getLong("evetype"), dbresult.getDate("date"));
                order_history = new Order_history(order_historyPK);
                order_history.initAverage(dbresult.getDouble("average"));
                order_history.initHighest(dbresult.getDouble("highest"));
                order_history.initLowest(dbresult.getDouble("lowest"));
                order_history.initVolume(dbresult.getInt("volume"));
                order_history.initOrder_count(dbresult.getInt("order_count"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        this.loadExtra(dbresult, order_history);
        return order_history;
    }

    /**
     * create new empty Order_history object
     * @return empty IOrder_history
     */
    public IOrder_history newOrder_history() {
    	return new Order_history();
    }
    
    /**
     * create new empty Order_history object
     * create new primary key with given parameters
     * @return IOrder_history with primary key
     */
    public IOrder_history newOrder_history(long region, long evetype, java.sql.Date date) {
        return new Order_history(region, evetype, date);
    }

    /**
     * create new empty Order_history object with given primary key
     * @param order_historyPK: primary key for Order_history
     * @return IOrder_history with primary key
     */
    public IOrder_history newOrder_history(IOrder_historyPK order_historyPK) {
        return new Order_history((Order_historyPK)order_historyPK);
    }

    /**
     * create new empty primary key
     * @return empty Order_historyPK
     */
    public IOrder_historyPK newOrder_historyPK() {
        return new Order_historyPK();
    }

    /**
     * create new primary key with given parameters
     * @return new IOrder_historyPK
     */
    public IOrder_historyPK newOrder_historyPK(long region, long evetype, java.sql.Date date) {
        return new Order_historyPK(region, evetype, date);
    }

    /**
     * get all Order_history objects from database
     * @return ArrayList of Order_history objects
     * @throws DBException
     */
    public ArrayList getOrder_historys() throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Order_history.SQLSelectAll);
        } else return new ArrayList();
    }

    /**
     * search Order_history for primary key
     * @param order_historyPK: Order_history primary key
     * @return Order_history object
     * @throws DBException
     */
    public Order_history getOrder_history(IOrder_historyPK order_historyPK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return (Order_history)super.getEntity((Order_historyPK)order_historyPK);
        } else return null;
    }

    public ArrayList searchorder_historys(IOrder_historysearch search) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return this.search(search);
        } else return new ArrayList();
    }

    public ArrayList searchorder_historys(IOrder_historysearch search, String orderby) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return this.search(search, orderby);
        } else return new ArrayList();
    }

    /**
     * Search order_history in database for order_historyPK:
     * @param order_historyPK: Order_history Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getOrder_historyExists(IOrder_historyPK order_historyPK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return super.getEntityExists((Order_historyPK)order_historyPK);
        } else return false;
    }

    /**
     * try to insert Order_history in database
     * @param film: Order_history object
     * @throws DBException
     */
    public void insertOrder_history(IOrder_history order_history) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.insertEntity(order_history);








        }
    }

    /**
     * check if Order_historyPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param film: Order_history object
     * @throws DBException
     */
    public void insertupdateOrder_history(IOrder_history order_history) throws DBException, DataException {
        if(this.getOrder_historyExists(order_history.getPrimaryKey())) {
            super.updateEntity(order_history);
        } else {
            super.insertEntity(order_history);
        }
    }

    /**
     * try to update Order_history in database
     * @param film: Order_history object
     * @throws DBException
     */
    public void updateOrder_history(IOrder_history order_history) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.updateEntity(order_history);








        }
    }

    /**
     * try to delete Order_history in database
     * @param film: Order_history object
     * @throws DBException
     */
    public void deleteOrder_history(IOrder_history order_history) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            cascadedeleteOrder_history(order_history.getOwnerobject(), order_history.getPrimaryKey());
            super.deleteEntity(order_history);
        }
    }

    /**
     * check data rules in Order_history, throw DataException with customized message if rules do not apply
     * @param film: Order_history object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(IOrder_history order_history) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //foreign key Order_history.Region - Region.Id
        //foreign key Order_history.Evetype - Evetype.Id
        //Primary key





        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where order_historyPK is used in a primary key
     * @param order_historyPK: Order_history primary key
     */
    public void cascadedeleteOrder_history(String senderobject, IOrder_historyPK order_historyPK) {
    }

    /**
     * @param evetypePK: foreign key for Evetype
     * @delete all Order_history Entity objects for Evetype in database
     * @throws eve.general.exception.CustomException
     */
    public void delete4evetype(String senderobject, IEvetypePK evetypePK) {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.addStatement(senderobject, Order_history.SQLDelete4evetype, evetypePK.getKeyFields());
        }
    }

    /**
     * @param evetypePK: foreign key for Evetype
     * @return all Order_history Entity objects for Evetype
     * @throws eve.general.exception.CustomException
     */
    public ArrayList getOrder_historys4evetype(IEvetypePK evetypePK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Order_history.SQLSelect4evetype, evetypePK.getKeyFields());
        } else return new ArrayList();
    }
    /**
     * @param regionPK: foreign key for Region
     * @delete all Order_history Entity objects for Region in database
     * @throws eve.general.exception.CustomException
     */
    public void delete4region(String senderobject, IRegionPK regionPK) {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.addStatement(senderobject, Order_history.SQLDelete4region, regionPK.getKeyFields());
        }
    }

    /**
     * @param regionPK: foreign key for Region
     * @return all Order_history Entity objects for Region
     * @throws eve.general.exception.CustomException
     */
    public ArrayList getOrder_historys4region(IRegionPK regionPK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Order_history.SQLSelect4region, regionPK.getKeyFields());
        } else return new ArrayList();
    }

    /**
     * get all Order_history objects for sqlparameters
     * @return ArrayList of Order_history objects
     * @throws DBException
     */
    public ArrayList getOrder_historys(Object[][] sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        String sql =  Order_history.SQLSelect;
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
     * delete all Order_history objects for sqlparameters
     * @throws DBException
     */
    public void delOrder_history(String senderobject, Object[][] sqlparameters, String andoroperator) throws DBException {
        String sql =  "Delete from " + Order_history.table;
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
