/*
 * Bsystemtrade_order.java
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
import eve.conversion.json.JSONSystemtrade_order;
import eve.data.ProjectConstants;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.ISystemtrade_ordersearch;
import eve.logicentity.Systemtrade_order;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Business Entity class Bsystemtrade_order
 *
 * Superclass for manipulating data- and database objects
 * for Entity Systemtrade_order and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bsystemtrade_order extends GeneralEntityObject implements ProjectConstants {

    /**
     * Constructor, sets Systemtrade_order as default Entity
     */
    public Bsystemtrade_order() {
        super(new SQLMapper_pgsql(connectionpool, "Systemtrade_order"), new Systemtrade_order());
    }

    /**
     * Constructor, sets Systemtrade_order as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bsystemtrade_order(GeneralEntityInterface transactionobject) {
        super(transactionobject, new Systemtrade_order());
    }

    /**
     * Map ResultSet Field values to Systemtrade_order
     * @param dbresult: Database ResultSet
     */
    public Systemtrade_order mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Systemtrade_orderPK systemtrade_orderPK = null;
        Systemtrade_order systemtrade_order;
        if(dbresult==null) {
            systemtrade_order = new Systemtrade_order(systemtrade_orderPK);
        } else {
            try {
                systemtrade_orderPK = new Systemtrade_orderPK(dbresult.getLong("sell_system"), dbresult.getLong("buy_system"), dbresult.getLong("sell_order"), dbresult.getLong("buy_order"));
                systemtrade_order = new Systemtrade_order(systemtrade_orderPK);
                systemtrade_order.initAmount(dbresult.getLong("amount"));
                systemtrade_order.initSellprice(dbresult.getDouble("sellprice"));
                systemtrade_order.initBuyprice(dbresult.getDouble("buyprice"));
                systemtrade_order.initProfit(dbresult.getDouble("profit"));
                systemtrade_order.initCargovolume(dbresult.getDouble("cargovolume"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        this.loadExtra(dbresult, systemtrade_order);
        return systemtrade_order;
    }

    /**
     * create new empty Systemtrade_order object
     * @return empty ISystemtrade_order
     */
    public ISystemtrade_order newSystemtrade_order() {
    	return new Systemtrade_order();
    }
    
    /**
     * create new empty Systemtrade_order object
     * create new primary key with given parameters
     * @return ISystemtrade_order with primary key
     */
    public ISystemtrade_order newSystemtrade_order(long sell_system, long buy_system, long sell_order, long buy_order) {
        return new Systemtrade_order(sell_system, buy_system, sell_order, buy_order);
    }

    /**
     * create new empty Systemtrade_order object with given primary key
     * @param systemtrade_orderPK: primary key for Systemtrade_order
     * @return ISystemtrade_order with primary key
     */
    public ISystemtrade_order newSystemtrade_order(ISystemtrade_orderPK systemtrade_orderPK) {
        return new Systemtrade_order((Systemtrade_orderPK)systemtrade_orderPK);
    }

    /**
     * create new empty primary key
     * @return empty Systemtrade_orderPK
     */
    public ISystemtrade_orderPK newSystemtrade_orderPK() {
        return new Systemtrade_orderPK();
    }

    /**
     * create new primary key with given parameters
     * @return new ISystemtrade_orderPK
     */
    public ISystemtrade_orderPK newSystemtrade_orderPK(long sell_system, long buy_system, long sell_order, long buy_order) {
        return new Systemtrade_orderPK(sell_system, buy_system, sell_order, buy_order);
    }

    /**
     * get all Systemtrade_order objects from database
     * @return ArrayList of Systemtrade_order objects
     * @throws DBException
     */
    public ArrayList getSystemtrade_orders() throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Systemtrade_order.SQLSelectAll);
        } else return new ArrayList();
    }

    /**
     * search Systemtrade_order for primary key
     * @param systemtrade_orderPK: Systemtrade_order primary key
     * @return Systemtrade_order object
     * @throws DBException
     */
    public Systemtrade_order getSystemtrade_order(ISystemtrade_orderPK systemtrade_orderPK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return (Systemtrade_order)super.getEntity((Systemtrade_orderPK)systemtrade_orderPK);
        } else return null;
    }

    public ArrayList searchsystemtrade_orders(ISystemtrade_ordersearch search) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return this.search(search);
        } else return new ArrayList();
    }

    public ArrayList searchsystemtrade_orders(ISystemtrade_ordersearch search, String orderby) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return this.search(search, orderby);
        } else return new ArrayList();
    }

    /**
     * Search systemtrade_order in database for systemtrade_orderPK:
     * @param systemtrade_orderPK: Systemtrade_order Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getSystemtrade_orderExists(ISystemtrade_orderPK systemtrade_orderPK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return super.getEntityExists((Systemtrade_orderPK)systemtrade_orderPK);
        } else return false;
    }

    /**
     * try to insert Systemtrade_order in database
     * @param film: Systemtrade_order object
     * @throws DBException
     */
    public void insertSystemtrade_order(ISystemtrade_order systemtrade_order) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.insertEntity(systemtrade_order);









        }
    }

    /**
     * check if Systemtrade_orderPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param film: Systemtrade_order object
     * @throws DBException
     */
    public void insertupdateSystemtrade_order(ISystemtrade_order systemtrade_order) throws DBException, DataException {
        if(this.getSystemtrade_orderExists(systemtrade_order.getPrimaryKey())) {
            super.updateEntity(systemtrade_order);
        } else {
            super.insertEntity(systemtrade_order);
        }
    }

    /**
     * try to update Systemtrade_order in database
     * @param film: Systemtrade_order object
     * @throws DBException
     */
    public void updateSystemtrade_order(ISystemtrade_order systemtrade_order) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.updateEntity(systemtrade_order);









        }
    }

    /**
     * try to delete Systemtrade_order in database
     * @param film: Systemtrade_order object
     * @throws DBException
     */
    public void deleteSystemtrade_order(ISystemtrade_order systemtrade_order) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            cascadedeleteSystemtrade_order(systemtrade_order.getOwnerobject(), systemtrade_order.getPrimaryKey());
            super.deleteEntity(systemtrade_order);
        }
    }

    /**
     * check data rules in Systemtrade_order, throw DataException with customized message if rules do not apply
     * @param film: Systemtrade_order object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(ISystemtrade_order systemtrade_order) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //foreign key Systemtrade_order.Sell_system - Systemtrade.Sell_system
        //foreign key Systemtrade_order.Buy_system - Systemtrade.Buy_system
        //foreign key Systemtrade_order.Sell_order - Orders.Id
        //foreign key Systemtrade_order.Buy_order - Orders.Id





        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where systemtrade_orderPK is used in a primary key
     * @param systemtrade_orderPK: Systemtrade_order primary key
     */
    public void cascadedeleteSystemtrade_order(String senderobject, ISystemtrade_orderPK systemtrade_orderPK) {
    }

    /**
     * @param ordersPK: foreign key for Orders
     * @delete all Systemtrade_order Entity objects for Orders in database
     * @throws eve.general.exception.CustomException
     */
    public void delete4ordersBuy_order(String senderobject, IOrdersPK ordersPK) {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.addStatement(senderobject, Systemtrade_order.SQLDelete4ordersBuy_order, ordersPK.getKeyFields());
        }
    }

    /**
     * @param ordersPK: foreign key for Orders
     * @return all Systemtrade_order Entity objects for Orders
     * @throws eve.general.exception.CustomException
     */
    public ArrayList getSystemtrade_orders4ordersBuy_order(IOrdersPK ordersPK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Systemtrade_order.SQLSelect4ordersBuy_order, ordersPK.getKeyFields());
        } else return new ArrayList();
    }
    /**
     * @param ordersPK: foreign key for Orders
     * @delete all Systemtrade_order Entity objects for Orders in database
     * @throws eve.general.exception.CustomException
     */
    public void delete4ordersSell_order(String senderobject, IOrdersPK ordersPK) {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.addStatement(senderobject, Systemtrade_order.SQLDelete4ordersSell_order, ordersPK.getKeyFields());
        }
    }

    /**
     * @param ordersPK: foreign key for Orders
     * @return all Systemtrade_order Entity objects for Orders
     * @throws eve.general.exception.CustomException
     */
    public ArrayList getSystemtrade_orders4ordersSell_order(IOrdersPK ordersPK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Systemtrade_order.SQLSelect4ordersSell_order, ordersPK.getKeyFields());
        } else return new ArrayList();
    }
    /**
     * @param systemtradePK: foreign key for Systemtrade
     * @delete all Systemtrade_order Entity objects for Systemtrade in database
     * @throws eve.general.exception.CustomException
     */
    public void delete4systemtrade(String senderobject, ISystemtradePK systemtradePK) {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.addStatement(senderobject, Systemtrade_order.SQLDelete4systemtrade, systemtradePK.getKeyFields());
        }
    }

    /**
     * @param systemtradePK: foreign key for Systemtrade
     * @return all Systemtrade_order Entity objects for Systemtrade
     * @throws eve.general.exception.CustomException
     */
    public ArrayList getSystemtrade_orders4systemtrade(ISystemtradePK systemtradePK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Systemtrade_order.SQLSelect4systemtrade, systemtradePK.getKeyFields());
        } else return new ArrayList();
    }

    /**
     * get all Systemtrade_order objects for sqlparameters
     * @return ArrayList of Systemtrade_order objects
     * @throws DBException
     */
    public ArrayList getSystemtrade_orders(Object[][] sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        String sql =  Systemtrade_order.SQLSelect;
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
     * delete all Systemtrade_order objects for sqlparameters
     * @throws DBException
     */
    public void delSystemtrade_order(String senderobject, Object[][] sqlparameters, String andoroperator) throws DBException {
        String sql =  "Delete from " + Systemtrade_order.table;
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
