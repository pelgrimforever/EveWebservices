/*
 * Borders.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 12.6.2021 13:57
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
import eve.conversion.json.JSONOrders;
import eve.data.ProjectConstants;
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
public abstract class Borders extends GeneralEntityObject implements ProjectConstants {

    /**
     * Constructor, sets Orders as default Entity
     */
    public Borders() {
        super(new SQLMapper_pgsql(connectionpool, "Orders"), new Orders());
    }

    /**
     * Constructor, sets Orders as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Borders(GeneralEntityInterface transactionobject) {
        super(transactionobject, new Orders());
    }

    /**
     * Map ResultSet Field values to Orders
     * @param dbresult: Database ResultSet
     */
    public Orders mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        OrdersPK ordersPK = null;
        Orders orders;
        if(dbresult==null) {
            orders = new Orders(ordersPK);
        } else {
            try {
                ordersPK = new OrdersPK(dbresult.getLong("id"));
                orders = new Orders(ordersPK);
                orders.initEvetypePK(new EvetypePK(dbresult.getLong("evetype")));
                if(dbresult.wasNull()) orders.setEvetypePK(null);                
                orders.initSystemPK(new SystemPK(dbresult.getLong("system")));
                if(dbresult.wasNull()) orders.setSystemPK(null);                
                orders.initIsopen(dbresult.getBoolean("isopen"));
                orders.initVolume_total(dbresult.getLong("volume_total"));
                orders.initVolume_remain(dbresult.getLong("volume_remain"));
                orders.initRange(dbresult.getString("range"));
                orders.initRange_number(dbresult.getInt("range_number"));
                orders.initPrice(dbresult.getDouble("price"));
                orders.initMin_volume(dbresult.getInt("min_volume"));
                orders.initLocation(dbresult.getLong("location"));
                orders.initIs_buy_order(dbresult.getBoolean("is_buy_order"));
                orders.initIssued(dbresult.getTimestamp("issued"));
                orders.initDuration(dbresult.getInt("duration"));
                orders.initPage(dbresult.getInt("page"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        this.loadExtra(dbresult, orders);
        return orders;
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
    public ArrayList getOrderss() throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Orders.SQLSelectAll);
        } else return new ArrayList();
    }

    /**
     * search Orders for primary key
     * @param ordersPK: Orders primary key
     * @return Orders object
     * @throws DBException
     */
    public Orders getOrders(IOrdersPK ordersPK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return (Orders)super.getEntity((OrdersPK)ordersPK);
        } else return null;
    }

    public ArrayList searchorderss(IOrderssearch search) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return this.search(search);
        } else return new ArrayList();
    }

    public ArrayList searchorderss(IOrderssearch search, String orderby) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return this.search(search, orderby);
        } else return new ArrayList();
    }

    /**
     * Search orders in database for ordersPK:
     * @param ordersPK: Orders Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getOrdersExists(IOrdersPK ordersPK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return super.getEntityExists((OrdersPK)ordersPK);
        } else return false;
    }

    /**
     * try to insert Orders in database
     * @param film: Orders object
     * @throws DBException
     */
    public void insertOrders(IOrders orders) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.insertEntity(orders);
        }
    }

    /**
     * check if OrdersPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param film: Orders object
     * @throws DBException
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
     * @param film: Orders object
     * @throws DBException
     */
    public void updateOrders(IOrders orders) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.updateEntity(orders);
        }
    }

    /**
     * try to delete Orders in database
     * @param film: Orders object
     * @throws DBException
     */
    public void deleteOrders(IOrders orders) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            cascadedeleteOrders(orders.getOwnerobject(), orders.getPrimaryKey());
            super.deleteEntity(orders);
        }
    }

    /**
     * check data rules in Orders, throw DataException with customized message if rules do not apply
     * @param film: Orders object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(IOrders orders) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key


        if(orders.getRange()!=null && orders.getRange().length()>IOrders.SIZE_RANGE) {
            message.append("Range is langer dan toegestaan. Max aantal karakters: " + IOrders.SIZE_RANGE + "\n");
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
    public void cascadedeleteOrders(String senderobject, IOrdersPK ordersPK) {
        BLsystemtrade_order blsystemtrade_orderBuy_order = new BLsystemtrade_order(this);
        blsystemtrade_orderBuy_order.delete4ordersBuy_order(senderobject, ordersPK);
        BLsystemtrade_order blsystemtrade_orderSell_order = new BLsystemtrade_order(this);
        blsystemtrade_orderSell_order.delete4ordersSell_order(senderobject, ordersPK);
        BLtrade bltradeSell_order_id = new BLtrade(this);
        bltradeSell_order_id.delete4ordersSell_order_id(senderobject, ordersPK);
        BLtrade bltradeBuy_order_id = new BLtrade(this);
        bltradeBuy_order_id.delete4ordersBuy_order_id(senderobject, ordersPK);
    }

    /**
     * @param evetypePK: foreign key for Evetype
     * @delete all Orders Entity objects for Evetype in database
     * @throws eve.general.exception.CustomException
     */
    public void delete4evetype(String senderobject, IEvetypePK evetypePK) {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.addStatement(senderobject, Orders.SQLDelete4evetype, evetypePK.getKeyFields());
        }
    }

    /**
     * @param evetypePK: foreign key for Evetype
     * @return all Orders Entity objects for Evetype
     * @throws eve.general.exception.CustomException
     */
    public ArrayList getOrderss4evetype(IEvetypePK evetypePK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Orders.SQLSelect4evetype, evetypePK.getKeyFields());
        } else return new ArrayList();
    }
    /**
     * @param systemPK: foreign key for System
     * @delete all Orders Entity objects for System in database
     * @throws eve.general.exception.CustomException
     */
    public void delete4system(String senderobject, ISystemPK systemPK) {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.addStatement(senderobject, Orders.SQLDelete4system, systemPK.getKeyFields());
        }
    }

    /**
     * @param systemPK: foreign key for System
     * @return all Orders Entity objects for System
     * @throws eve.general.exception.CustomException
     */
    public ArrayList getOrderss4system(ISystemPK systemPK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Orders.SQLSelect4system, systemPK.getKeyFields());
        } else return new ArrayList();
    }
    /**
     * @param systemtrade_orderPK: parent Systemtrade_order for child object Orders Entity
     * @return child Orders Entity object
     * @throws eve.general.exception.CustomException
     */
    public IOrders getSystemtrade_orderbuy_order(ISystemtrade_orderPK systemtrade_orderPK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            OrdersPK ordersPK = new OrdersPK(systemtrade_orderPK.getBuy_order());
            return this.getOrders(ordersPK);
        } else return null;
    }

    /**
     * @param systemtrade_orderPK: parent Systemtrade_order for child object Orders Entity
     * @return child Orders Entity object
     * @throws eve.general.exception.CustomException
     */
    public IOrders getSystemtrade_ordersell_order(ISystemtrade_orderPK systemtrade_orderPK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            OrdersPK ordersPK = new OrdersPK(systemtrade_orderPK.getSell_order());
            return this.getOrders(ordersPK);
        } else return null;
    }

    /**
     * @param tradePK: parent Trade for child object Orders Entity
     * @return child Orders Entity object
     * @throws eve.general.exception.CustomException
     */
    public IOrders getTradesell_order_id(ITradePK tradePK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            OrdersPK ordersPK = new OrdersPK(tradePK.getSell_order_id());
            return this.getOrders(ordersPK);
        } else return null;
    }

    /**
     * @param tradePK: parent Trade for child object Orders Entity
     * @return child Orders Entity object
     * @throws eve.general.exception.CustomException
     */
    public IOrders getTradebuy_order_id(ITradePK tradePK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            OrdersPK ordersPK = new OrdersPK(tradePK.getBuy_order_id());
            return this.getOrders(ordersPK);
        } else return null;
    }


    /**
     * get all Orders objects for sqlparameters
     * @return ArrayList of Orders objects
     * @throws DBException
     */
    public ArrayList getOrderss(Object[][] sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        String sql =  Orders.SQLSelect;
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
     * delete all Orders objects for sqlparameters
     * @throws DBException
     */
    public void delOrders(String senderobject, Object[][] sqlparameters, String andoroperator) throws DBException {
        String sql =  "Delete from " + Orders.table;
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
