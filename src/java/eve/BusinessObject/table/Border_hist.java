/*
 * Border_hist.java
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
import eve.conversion.json.JSONOrder_hist;
import eve.conversion.entity.EMorder_hist;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.IOrder_histsearch;
import eve.logicentity.Order_hist;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Business Entity class Border_hist
 *
 * Superclass for manipulating data- and database objects
 * for Entity Order_hist and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Border_hist extends BLtable {

    /**
     * Constructor, sets Order_hist as default Entity
     */
    public Border_hist() {
        super(new Order_hist(), new EMorder_hist());
    }

    /**
     * Constructor, sets Order_hist as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Border_hist(BLtable transactionobject) {
        super(transactionobject, new Order_hist(), new EMorder_hist());
    }

    /**
     * create new empty Order_hist object
     * @return empty IOrder_hist
     */
    public IOrder_hist newOrder_hist() {
    	return new Order_hist();
    }
    
    /**
     * create new empty Order_hist object
     * create new primary key with given parameters
     * @param id primary key field
     * @return IOrder_hist with primary key
     */
    public IOrder_hist newOrder_hist(long id) {
        return new Order_hist(id);
    }

    /**
     * create new empty Order_hist object with given primary key
     * @param order_histPK: primary key for Order_hist
     * @return IOrder_hist with primary key
     */
    public IOrder_hist newOrder_hist(IOrder_histPK order_histPK) {
        return new Order_hist((Order_histPK)order_histPK);
    }

    /**
     * create new empty primary key
     * @return empty Order_histPK
     */
    public IOrder_histPK newOrder_histPK() {
        return new Order_histPK();
    }

    /**
     * create new primary key with given parameters
     * @param id primary key field
     * @return new IOrder_histPK
     */
    public IOrder_histPK newOrder_histPK(long id) {
        return new Order_histPK(id);
    }

    /**
     * get all Order_hist objects from database
     * @return ArrayList of Order_hist objects
     * @throws DBException
     */
    public ArrayList<Order_hist> getOrder_hists() throws DBException {
        return (ArrayList<Order_hist>)super.getEntities(EMorder_hist.SQLSelectAll);
    }

    /**
     * search Order_hist for primary key
     * @param order_histPK: Order_hist primary key
     * @return Order_hist object
     * @throws DBException
     */
    public Order_hist getOrder_hist(IOrder_histPK order_histPK) throws DBException {
        return (Order_hist)super.getEntity((Order_histPK)order_histPK);
    }

    /**
     * search order_hist with IOrder_histsearch parameters
     * @param search IOrder_histsearch
     * @return ArrayList of Order_hist
     * @throws DBException 
     */
    public ArrayList<Order_hist> searchorder_hists(IOrder_histsearch search) throws DBException {
        return (ArrayList<Order_hist>)this.search(search);
    }

    /**
     * search order_hist with IOrder_histsearch parameters, order by orderby sql clause
     * @param search IOrder_histsearch
     * @param orderby sql order by string
     * @return ArrayList of Order_hist
     * @throws DBException 
     */
    public ArrayList<Order_hist> searchorder_hists(IOrder_histsearch search, String orderby) throws DBException {
        return (ArrayList<Order_hist>)this.search(search, orderby);
    }

    /**
     * Search order_hist in database for order_histPK:
     * @param order_histPK: Order_hist Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getOrder_histExists(IOrder_histPK order_histPK) throws DBException {
        return super.getEntityExists((Order_histPK)order_histPK);
    }

    /**
     * try to insert Order_hist in database
     * @param order_hist Order_hist object
     * @throws DBException
     * @throws DataException
     */
    public void insertOrder_hist(IOrder_hist order_hist) throws DBException, DataException {
        super.insertEntity(order_hist);
    }

    /**
     * check if Order_histPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param order_hist Order_hist object
     * @throws DBException
     * @throws DataException
     */
    public void insertupdateOrder_hist(IOrder_hist order_hist) throws DBException, DataException {
        if(this.getOrder_histExists(order_hist.getPrimaryKey())) {
            super.updateEntity(order_hist);
        } else {
            super.insertEntity(order_hist);
        }
    }

    /**
     * try to update Order_hist in database
     * @param order_hist Order_hist object
     * @throws DBException
     * @throws DataException
     */
    public void updateOrder_hist(IOrder_hist order_hist) throws DBException, DataException {
        super.updateEntity(order_hist);
    }

    /**
     * try to delete Order_hist in database
     * @param order_hist Order_hist object
     * @throws DBException
     */
    public void deleteOrder_hist(IOrder_hist order_hist) throws DBException {
        cascadedeleteOrder_hist(order_hist.getPrimaryKey());
        super.deleteEntity(order_hist);
    }

    /**
     * check data rules in Order_hist, throw DataException with customized message if rules do not apply
     * @param order_hist Order_hist object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(IOrder_hist order_hist) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        if(order_hist.getRange()!=null && order_hist.getRange().length()>IOrder_hist.SIZE_RANGE) {
            message.append("Range is langer dan toegestaan. Max aantal karakters: ").append(IOrder_hist.SIZE_RANGE).append("\n");
        }
        if(order_hist.getRange()==null) {
            message.append("Range mag niet leeg zijn.\n");
        }
        if(order_hist.getIssued()==null) {
            message.append("Issued mag niet leeg zijn.\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where order_histPK is used in a primary key
     * @param order_histPK: Order_hist primary key
     */
    public void cascadedeleteOrder_hist(IOrder_histPK order_histPK) {
    }

    /**
     * @param evetypePK: foreign key for Evetype
     * @delete all Order_hist Entity objects for Evetype in database
     */
    public void delete4evetype(IEvetypePK evetypePK) {
        super.addStatement(EMorder_hist.SQLDelete4evetype, evetypePK.getSQLprimarykey());
    }

    /**
     * @param evetypePK: foreign key for Evetype
     * @return all Order_hist Entity objects for Evetype
     * @throws CustomException
     */
    public ArrayList<Order_hist> getOrder_hists4evetype(IEvetypePK evetypePK) throws CustomException {
        return super.getEntities(EMorder_hist.SQLSelect4evetype, evetypePK.getSQLprimarykey());
    }
    /**
     * @param systemPK: foreign key for System
     * @delete all Order_hist Entity objects for System in database
     */
    public void delete4system(ISystemPK systemPK) {
        super.addStatement(EMorder_hist.SQLDelete4system, systemPK.getSQLprimarykey());
    }

    /**
     * @param systemPK: foreign key for System
     * @return all Order_hist Entity objects for System
     * @throws CustomException
     */
    public ArrayList<Order_hist> getOrder_hists4system(ISystemPK systemPK) throws CustomException {
        return super.getEntities(EMorder_hist.SQLSelect4system, systemPK.getSQLprimarykey());
    }

    /**
     * get all Order_hist objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @param sortlist sql sort string
     * @param sortoperator asc/desc
     * @return ArrayList of Order_hist objects
     * @throws DBException
     */
    public ArrayList<Order_hist> getOrder_hists(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMorder_hist.SQLSelect);
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
        return (ArrayList<Order_hist>)super.getEntities(sql.toString(), sqlparameters);
    }

    /**
     * delete all Order_hist objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @throws DBException
     */
    public void delOrder_hist(SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Order_hist.table);
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
