/*
 * Borders.java
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
import eve.conversion.json.JSONOrders;
import eve.conversion.entity.EMorders;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.IOrderssearch;
import eve.logicentity.Orders;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Business Entity class Borders
 *
 * Superclass for manipulating data- and database objects
 * for Entity Orders and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Borders extends BLtable {

    /**
     * Constructor, sets Orders as default Entity
     */
    public Borders() {
        super(new Orders(), new EMorders());
    }

    /**
     * Constructor, sets Orders as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Borders(BLtable transactionobject) {
        super(transactionobject, new Orders(), new EMorders());
    }

    /**
     * create new empty Orders object
     * @return empty IOrders
     */
    public IOrders newOrders() {
    	return new Orders();
    }
    
    /**
     * create new empty Orders object
     * create new primary key with given parameters
     * @param id primary key field
     * @return IOrders with primary key
     */
    public IOrders newOrders(long id) {
        return new Orders(id);
    }

    /**
     * create new empty Orders object with given primary key
     * @param ordersPK: primary key for Orders
     * @return IOrders with primary key
     */
    public IOrders newOrders(IOrdersPK ordersPK) {
        return new Orders((OrdersPK)ordersPK);
    }

    /**
     * create new empty primary key
     * @return empty OrdersPK
     */
    public IOrdersPK newOrdersPK() {
        return new OrdersPK();
    }

    /**
     * create new primary key with given parameters
     * @param id primary key field
     * @return new IOrdersPK
     */
    public IOrdersPK newOrdersPK(long id) {
        return new OrdersPK(id);
    }

    /**
     * get all Orders objects from database
     * @return ArrayList of Orders objects
     * @throws DBException
     */
    public ArrayList<Orders> getOrderss() throws DBException {
        return (ArrayList<Orders>)super.getEntities(EMorders.SQLSelectAll);
    }

    /**
     * search Orders for primary key
     * @param ordersPK: Orders primary key
     * @return Orders object
     * @throws DBException
     */
    public Orders getOrders(IOrdersPK ordersPK) throws DBException {
        return (Orders)super.getEntity((OrdersPK)ordersPK);
    }

    /**
     * search orders with IOrderssearch parameters
     * @param search IOrderssearch
     * @return ArrayList of Orders
     * @throws DBException 
     */
    public ArrayList<Orders> searchorderss(IOrderssearch search) throws DBException {
        return (ArrayList<Orders>)this.search(search);
    }

    /**
     * search orders with IOrderssearch parameters, order by orderby sql clause
     * @param search IOrderssearch
     * @param orderby sql order by string
     * @return ArrayList of Orders
     * @throws DBException 
     */
    public ArrayList<Orders> searchorderss(IOrderssearch search, String orderby) throws DBException {
        return (ArrayList<Orders>)this.search(search, orderby);
    }

    /**
     * Search orders in database for ordersPK:
     * @param ordersPK: Orders Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getOrdersExists(IOrdersPK ordersPK) throws DBException {
        return super.getEntityExists((OrdersPK)ordersPK);
    }

    /**
     * try to insert Orders in database
     * @param orders Orders object
     * @throws DBException
     * @throws DataException
     */
    public void insertOrders(IOrders orders) throws DBException, DataException {
        super.insertEntity(orders);
    }

    /**
     * check if OrdersPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param orders Orders object
     * @throws DBException
     * @throws DataException
     */
    public void insertupdateOrders(IOrders orders) throws DBException, DataException {
        if(this.getOrdersExists(orders.getPrimaryKey())) {
            super.updateEntity(orders);
        } else {
            super.insertEntity(orders);
        }
    }

    /**
     * try to update Orders in database
     * @param orders Orders object
     * @throws DBException
     * @throws DataException
     */
    public void updateOrders(IOrders orders) throws DBException, DataException {
        super.updateEntity(orders);
    }

    /**
     * try to delete Orders in database
     * @param orders Orders object
     * @throws DBException
     */
    public void deleteOrders(IOrders orders) throws DBException {
        cascadedeleteOrders(orders.getPrimaryKey());
        super.deleteEntity(orders);
    }

    /**
     * check data rules in Orders, throw DataException with customized message if rules do not apply
     * @param orders Orders object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(IOrders orders) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        if(orders.getRange()!=null && orders.getRange().length()>IOrders.SIZE_RANGE) {
            message.append("Range is langer dan toegestaan. Max aantal karakters: ").append(IOrders.SIZE_RANGE).append("\n");
        }
        if(orders.getRange()==null) {
            message.append("Range mag niet leeg zijn.\n");
        }
        if(orders.getIssued()==null) {
            message.append("Issued mag niet leeg zijn.\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where ordersPK is used in a primary key
     * @param ordersPK: Orders primary key
     */
    public void cascadedeleteOrders(IOrdersPK ordersPK) {
        BLtradecombined_sell bltradecombined_sellBuy_order_id = new BLtradecombined_sell(this);
        bltradecombined_sellBuy_order_id.delete4ordersBuy_order_id(ordersPK);
        BLtradecombined_sell bltradecombined_sellSell_order_id = new BLtradecombined_sell(this);
        bltradecombined_sellSell_order_id.delete4ordersSell_order_id(ordersPK);
        BLshipfitorderselected blshipfitorderselected = new BLshipfitorderselected(this);
        blshipfitorderselected.delete4orders(ordersPK);
        BLtrade bltradeSell_order_id = new BLtrade(this);
        bltradeSell_order_id.delete4ordersSell_order_id(ordersPK);
        BLtrade bltradeBuy_order_id = new BLtrade(this);
        bltradeBuy_order_id.delete4ordersBuy_order_id(ordersPK);
    }

    /**
     * @param evetypePK: foreign key for Evetype
     * @delete all Orders Entity objects for Evetype in database
     */
    public void delete4evetype(IEvetypePK evetypePK) {
        super.addStatement(EMorders.SQLDelete4evetype, evetypePK.getSQLprimarykey());
    }

    /**
     * @param evetypePK: foreign key for Evetype
     * @return all Orders Entity objects for Evetype
     * @throws CustomException
     */
    public ArrayList<Orders> getOrderss4evetype(IEvetypePK evetypePK) throws CustomException {
        return super.getEntities(EMorders.SQLSelect4evetype, evetypePK.getSQLprimarykey());
    }
    /**
     * @param systemPK: foreign key for System
     * @delete all Orders Entity objects for System in database
     */
    public void delete4system(ISystemPK systemPK) {
        super.addStatement(EMorders.SQLDelete4system, systemPK.getSQLprimarykey());
    }

    /**
     * @param systemPK: foreign key for System
     * @return all Orders Entity objects for System
     * @throws CustomException
     */
    public ArrayList<Orders> getOrderss4system(ISystemPK systemPK) throws CustomException {
        return super.getEntities(EMorders.SQLSelect4system, systemPK.getSQLprimarykey());
    }
    /**
     * @param tradecombined_sellPK: parent Tradecombined_sell for child object Orders Entity
     * @return child Orders Entity object
     * @throws CustomException
     */
    public Orders getTradecombined_sellbuy_order_id(ITradecombined_sellPK tradecombined_sellPK) throws CustomException {
        OrdersPK ordersPK = new OrdersPK(tradecombined_sellPK.getBuy_order_id());
        return this.getOrders(ordersPK);
    }

    /**
     * @param tradecombined_sellPK: parent Tradecombined_sell for child object Orders Entity
     * @return child Orders Entity object
     * @throws CustomException
     */
    public Orders getTradecombined_sellsell_order_id(ITradecombined_sellPK tradecombined_sellPK) throws CustomException {
        OrdersPK ordersPK = new OrdersPK(tradecombined_sellPK.getSell_order_id());
        return this.getOrders(ordersPK);
    }

    /**
     * @param shipfitorderselectedPK: parent Shipfitorderselected for child object Orders Entity
     * @return child Orders Entity object
     * @throws CustomException
     */
    public Orders getShipfitorderselected(IShipfitorderselectedPK shipfitorderselectedPK) throws CustomException {
        OrdersPK ordersPK = new OrdersPK(shipfitorderselectedPK.getOrderid());
        return this.getOrders(ordersPK);
    }

    /**
     * @param tradePK: parent Trade for child object Orders Entity
     * @return child Orders Entity object
     * @throws CustomException
     */
    public Orders getTradesell_order_id(ITradePK tradePK) throws CustomException {
        OrdersPK ordersPK = new OrdersPK(tradePK.getSell_order_id());
        return this.getOrders(ordersPK);
    }

    /**
     * @param tradePK: parent Trade for child object Orders Entity
     * @return child Orders Entity object
     * @throws CustomException
     */
    public Orders getTradebuy_order_id(ITradePK tradePK) throws CustomException {
        OrdersPK ordersPK = new OrdersPK(tradePK.getBuy_order_id());
        return this.getOrders(ordersPK);
    }


    /**
     * get all Orders objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @param sortlist sql sort string
     * @param sortoperator asc/desc
     * @return ArrayList of Orders objects
     * @throws DBException
     */
    public ArrayList<Orders> getOrderss(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMorders.SQLSelect);
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
        return (ArrayList<Orders>)super.getEntities(sql.toString(), sqlparameters);
    }

    /**
     * delete all Orders objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @throws DBException
     */
    public void delOrders(SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Orders.table);
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
