/*
 * Border_history.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 11.4.2022 9:13
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
import eve.conversion.json.JSONOrder_history;
import eve.conversion.entity.EMorder_history;
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
public abstract class Border_history extends BLtable {

    /**
     * Constructor, sets Order_history as default Entity
     */
    public Border_history() {
        super(new Order_history(), new EMorder_history());
    }

    /**
     * Constructor, sets Order_history as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Border_history(BLtable transactionobject) {
        super(transactionobject, new Order_history(), new EMorder_history());
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
     * @param region primary key field
     * @param evetype primary key field
     * @param date primary key field
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
     * @param region primary key field
     * @param evetype primary key field
     * @param date primary key field
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
    public ArrayList<Order_history> getOrder_historys() throws DBException {
        return (ArrayList<Order_history>)super.getEntities(EMorder_history.SQLSelectAll);
    }

    /**
     * search Order_history for primary key
     * @param order_historyPK: Order_history primary key
     * @return Order_history object
     * @throws DBException
     */
    public Order_history getOrder_history(IOrder_historyPK order_historyPK) throws DBException {
        return (Order_history)super.getEntity((Order_historyPK)order_historyPK);
    }

    /**
     * search order_history with IOrder_historysearch parameters
     * @param search IOrder_historysearch
     * @return ArrayList of Order_history
     * @throws DBException 
     */
    public ArrayList<Order_history> searchorder_historys(IOrder_historysearch search) throws DBException {
        return (ArrayList<Order_history>)this.search(search);
    }

    /**
     * search order_history with IOrder_historysearch parameters, order by orderby sql clause
     * @param search IOrder_historysearch
     * @param orderby sql order by string
     * @return ArrayList of Order_history
     * @throws DBException 
     */
    public ArrayList<Order_history> searchorder_historys(IOrder_historysearch search, String orderby) throws DBException {
        return (ArrayList<Order_history>)this.search(search, orderby);
    }

    /**
     * Search order_history in database for order_historyPK:
     * @param order_historyPK: Order_history Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getOrder_historyExists(IOrder_historyPK order_historyPK) throws DBException {
        return super.getEntityExists((Order_historyPK)order_historyPK);
    }

    /**
     * try to insert Order_history in database
     * @param order_history Order_history object
     * @throws DBException
     * @throws DataException
     */
    public void insertOrder_history(IOrder_history order_history) throws DBException, DataException {
        super.insertEntity(order_history);
    }

    /**
     * check if Order_historyPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param order_history Order_history object
     * @throws DBException
     * @throws DataException
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
     * @param order_history Order_history object
     * @throws DBException
     * @throws DataException
     */
    public void updateOrder_history(IOrder_history order_history) throws DBException, DataException {
        super.updateEntity(order_history);
    }

    /**
     * try to delete Order_history in database
     * @param order_history Order_history object
     * @throws DBException
     */
    public void deleteOrder_history(IOrder_history order_history) throws DBException {
        cascadedeleteOrder_history(order_history.getPrimaryKey());
        super.deleteEntity(order_history);
    }

    /**
     * check data rules in Order_history, throw DataException with customized message if rules do not apply
     * @param order_history Order_history object
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
    public void cascadedeleteOrder_history(IOrder_historyPK order_historyPK) {
    }

    /**
     * @param evetypePK: foreign key for Evetype
     * @delete all Order_history Entity objects for Evetype in database
     */
    public void delete4evetype(IEvetypePK evetypePK) {
        super.addStatement(EMorder_history.SQLDelete4evetype, evetypePK.getSQLprimarykey());
    }

    /**
     * @param evetypePK: foreign key for Evetype
     * @return all Order_history Entity objects for Evetype
     * @throws CustomException
     */
    public ArrayList<Order_history> getOrder_historys4evetype(IEvetypePK evetypePK) throws CustomException {
        return super.getEntities(EMorder_history.SQLSelect4evetype, evetypePK.getSQLprimarykey());
    }
    /**
     * @param regionPK: foreign key for Region
     * @delete all Order_history Entity objects for Region in database
     */
    public void delete4region(IRegionPK regionPK) {
        super.addStatement(EMorder_history.SQLDelete4region, regionPK.getSQLprimarykey());
    }

    /**
     * @param regionPK: foreign key for Region
     * @return all Order_history Entity objects for Region
     * @throws CustomException
     */
    public ArrayList<Order_history> getOrder_historys4region(IRegionPK regionPK) throws CustomException {
        return super.getEntities(EMorder_history.SQLSelect4region, regionPK.getSQLprimarykey());
    }

    /**
     * get all Order_history objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @param sortlist sql sort string
     * @param sortoperator asc/desc
     * @return ArrayList of Order_history objects
     * @throws DBException
     */
    public ArrayList<Order_history> getOrder_historys(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMorder_history.SQLSelect);
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
        return (ArrayList<Order_history>)super.getEntities(sql.toString(), sqlparameters);
    }

    /**
     * delete all Order_history objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @throws DBException
     */
    public void delOrder_history(SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Order_history.table);
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
