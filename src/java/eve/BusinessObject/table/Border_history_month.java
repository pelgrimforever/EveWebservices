/*
 * Border_history_month.java
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
import eve.conversion.json.JSONOrder_history_month;
import eve.conversion.entity.EMorder_history_month;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.IOrder_history_monthsearch;
import eve.logicentity.Order_history_month;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Business Entity class Border_history_month
 *
 * Superclass for manipulating data- and database objects
 * for Entity Order_history_month and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Border_history_month extends BLtable {

    /**
     * Constructor, sets Order_history_month as default Entity
     */
    public Border_history_month() {
        super(new Order_history_month(), new EMorder_history_month());
    }

    /**
     * Constructor, sets Order_history_month as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Border_history_month(BLtable transactionobject) {
        super(transactionobject, new Order_history_month(), new EMorder_history_month());
    }

    /**
     * create new empty Order_history_month object
     * @return empty IOrder_history_month
     */
    public IOrder_history_month newOrder_history_month() {
    	return new Order_history_month();
    }
    
    /**
     * create new empty Order_history_month object
     * create new primary key with given parameters
     * @param region primary key field
     * @param evetype primary key field
     * @param year primary key field
     * @param month primary key field
     * @return IOrder_history_month with primary key
     */
    public IOrder_history_month newOrder_history_month(long region, long evetype, int year, int month) {
        return new Order_history_month(region, evetype, year, month);
    }

    /**
     * create new empty Order_history_month object with given primary key
     * @param order_history_monthPK: primary key for Order_history_month
     * @return IOrder_history_month with primary key
     */
    public IOrder_history_month newOrder_history_month(IOrder_history_monthPK order_history_monthPK) {
        return new Order_history_month((Order_history_monthPK)order_history_monthPK);
    }

    /**
     * create new empty primary key
     * @return empty Order_history_monthPK
     */
    public IOrder_history_monthPK newOrder_history_monthPK() {
        return new Order_history_monthPK();
    }

    /**
     * create new primary key with given parameters
     * @param region primary key field
     * @param evetype primary key field
     * @param year primary key field
     * @param month primary key field
     * @return new IOrder_history_monthPK
     */
    public IOrder_history_monthPK newOrder_history_monthPK(long region, long evetype, int year, int month) {
        return new Order_history_monthPK(region, evetype, year, month);
    }

    /**
     * get all Order_history_month objects from database
     * @return ArrayList of Order_history_month objects
     * @throws DBException
     */
    public ArrayList<Order_history_month> getOrder_history_months() throws DBException {
        return (ArrayList<Order_history_month>)super.getEntities(EMorder_history_month.SQLSelectAll);
    }

    /**
     * search Order_history_month for primary key
     * @param order_history_monthPK: Order_history_month primary key
     * @return Order_history_month object
     * @throws DBException
     */
    public Order_history_month getOrder_history_month(IOrder_history_monthPK order_history_monthPK) throws DBException {
        return (Order_history_month)super.getEntity((Order_history_monthPK)order_history_monthPK);
    }

    /**
     * search order_history_month with IOrder_history_monthsearch parameters
     * @param search IOrder_history_monthsearch
     * @return ArrayList of Order_history_month
     * @throws DBException 
     */
    public ArrayList<Order_history_month> searchorder_history_months(IOrder_history_monthsearch search) throws DBException {
        return (ArrayList<Order_history_month>)this.search(search);
    }

    /**
     * search order_history_month with IOrder_history_monthsearch parameters, order by orderby sql clause
     * @param search IOrder_history_monthsearch
     * @param orderby sql order by string
     * @return ArrayList of Order_history_month
     * @throws DBException 
     */
    public ArrayList<Order_history_month> searchorder_history_months(IOrder_history_monthsearch search, String orderby) throws DBException {
        return (ArrayList<Order_history_month>)this.search(search, orderby);
    }

    /**
     * Search order_history_month in database for order_history_monthPK:
     * @param order_history_monthPK: Order_history_month Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getOrder_history_monthExists(IOrder_history_monthPK order_history_monthPK) throws DBException {
        return super.getEntityExists((Order_history_monthPK)order_history_monthPK);
    }

    /**
     * try to insert Order_history_month in database
     * @param order_history_month Order_history_month object
     * @throws DBException
     * @throws DataException
     */
    public void insertOrder_history_month(IOrder_history_month order_history_month) throws DBException, DataException {
        super.insertEntity(order_history_month);
    }

    /**
     * check if Order_history_monthPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param order_history_month Order_history_month object
     * @throws DBException
     * @throws DataException
     */
    public void insertupdateOrder_history_month(IOrder_history_month order_history_month) throws DBException, DataException {
        if(this.getOrder_history_monthExists(order_history_month.getPrimaryKey())) {
            super.updateEntity(order_history_month);
        } else {
            super.insertEntity(order_history_month);
        }
    }

    /**
     * try to update Order_history_month in database
     * @param order_history_month Order_history_month object
     * @throws DBException
     * @throws DataException
     */
    public void updateOrder_history_month(IOrder_history_month order_history_month) throws DBException, DataException {
        super.updateEntity(order_history_month);
    }

    /**
     * try to delete Order_history_month in database
     * @param order_history_month Order_history_month object
     * @throws DBException
     */
    public void deleteOrder_history_month(IOrder_history_month order_history_month) throws DBException {
        cascadedeleteOrder_history_month(order_history_month.getPrimaryKey());
        super.deleteEntity(order_history_month);
    }

    /**
     * check data rules in Order_history_month, throw DataException with customized message if rules do not apply
     * @param order_history_month Order_history_month object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(IOrder_history_month order_history_month) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //foreign key Order_history_month.Region - Region.Id
        //foreign key Order_history_month.Evetype - Evetype.Id
        //Primary key
        //Primary key
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where order_history_monthPK is used in a primary key
     * @param order_history_monthPK: Order_history_month primary key
     */
    public void cascadedeleteOrder_history_month(IOrder_history_monthPK order_history_monthPK) {
    }

    /**
     * @param evetypePK: foreign key for Evetype
     * @delete all Order_history_month Entity objects for Evetype in database
     */
    public void delete4evetype(IEvetypePK evetypePK) {
        super.addStatement(EMorder_history_month.SQLDelete4evetype, evetypePK.getSQLprimarykey());
    }

    /**
     * @param evetypePK: foreign key for Evetype
     * @return all Order_history_month Entity objects for Evetype
     * @throws CustomException
     */
    public ArrayList<Order_history_month> getOrder_history_months4evetype(IEvetypePK evetypePK) throws CustomException {
        return super.getEntities(EMorder_history_month.SQLSelect4evetype, evetypePK.getSQLprimarykey());
    }
    /**
     * @param regionPK: foreign key for Region
     * @delete all Order_history_month Entity objects for Region in database
     */
    public void delete4region(IRegionPK regionPK) {
        super.addStatement(EMorder_history_month.SQLDelete4region, regionPK.getSQLprimarykey());
    }

    /**
     * @param regionPK: foreign key for Region
     * @return all Order_history_month Entity objects for Region
     * @throws CustomException
     */
    public ArrayList<Order_history_month> getOrder_history_months4region(IRegionPK regionPK) throws CustomException {
        return super.getEntities(EMorder_history_month.SQLSelect4region, regionPK.getSQLprimarykey());
    }

    /**
     * get all Order_history_month objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @param sortlist sql sort string
     * @param sortoperator asc/desc
     * @return ArrayList of Order_history_month objects
     * @throws DBException
     */
    public ArrayList<Order_history_month> getOrder_history_months(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMorder_history_month.SQLSelect);
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
        return (ArrayList<Order_history_month>)super.getEntities(sql.toString(), sqlparameters);
    }

    /**
     * delete all Order_history_month objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @throws DBException
     */
    public void delOrder_history_month(SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Order_history_month.table);
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
