/*
 * Bsystemtrade_order.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 8.10.2021 7:21
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
import eve.conversion.json.JSONSystemtrade_order;
import eve.conversion.entity.EMsystemtrade_order;
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
public abstract class Bsystemtrade_order extends BLtable {

    /**
     * Constructor, sets Systemtrade_order as default Entity
     */
    public Bsystemtrade_order() {
        super(new Systemtrade_order(), new EMsystemtrade_order());
    }

    /**
     * Constructor, sets Systemtrade_order as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bsystemtrade_order(BLtable transactionobject) {
        super(transactionobject, new Systemtrade_order(), new EMsystemtrade_order());
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
     * @param sell_system primary key field
     * @param buy_system primary key field
     * @param sell_order primary key field
     * @param buy_order primary key field
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
     * @param sell_system primary key field
     * @param buy_system primary key field
     * @param sell_order primary key field
     * @param buy_order primary key field
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
    public ArrayList<Systemtrade_order> getSystemtrade_orders() throws DBException {
        return (ArrayList<Systemtrade_order>)super.getEntities(EMsystemtrade_order.SQLSelectAll);
    }

    /**
     * search Systemtrade_order for primary key
     * @param systemtrade_orderPK: Systemtrade_order primary key
     * @return Systemtrade_order object
     * @throws DBException
     */
    public Systemtrade_order getSystemtrade_order(ISystemtrade_orderPK systemtrade_orderPK) throws DBException {
        return (Systemtrade_order)super.getEntity((Systemtrade_orderPK)systemtrade_orderPK);
    }

    /**
     * search systemtrade_order with ISystemtrade_ordersearch parameters
     * @param search ISystemtrade_ordersearch
     * @return ArrayList of Systemtrade_order
     * @throws DBException 
     */
    public ArrayList<Systemtrade_order> searchsystemtrade_orders(ISystemtrade_ordersearch search) throws DBException {
        return (ArrayList<Systemtrade_order>)this.search(search);
    }

    /**
     * search systemtrade_order with ISystemtrade_ordersearch parameters, order by orderby sql clause
     * @param search ISystemtrade_ordersearch
     * @param orderby sql order by string
     * @return ArrayList of Systemtrade_order
     * @throws DBException 
     */
    public ArrayList<Systemtrade_order> searchsystemtrade_orders(ISystemtrade_ordersearch search, String orderby) throws DBException {
        return (ArrayList<Systemtrade_order>)this.search(search, orderby);
    }

    /**
     * Search systemtrade_order in database for systemtrade_orderPK:
     * @param systemtrade_orderPK: Systemtrade_order Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getSystemtrade_orderExists(ISystemtrade_orderPK systemtrade_orderPK) throws DBException {
        return super.getEntityExists((Systemtrade_orderPK)systemtrade_orderPK);
    }

    /**
     * try to insert Systemtrade_order in database
     * @param systemtrade_order Systemtrade_order object
     * @throws DBException
     * @throws DataException
     */
    public void insertSystemtrade_order(ISystemtrade_order systemtrade_order) throws DBException, DataException {
        super.insertEntity(systemtrade_order);
    }

    /**
     * check if Systemtrade_orderPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param systemtrade_order Systemtrade_order object
     * @throws DBException
     * @throws DataException
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
     * @param systemtrade_order Systemtrade_order object
     * @throws DBException
     * @throws DataException
     */
    public void updateSystemtrade_order(ISystemtrade_order systemtrade_order) throws DBException, DataException {
        super.updateEntity(systemtrade_order);
    }

    /**
     * try to delete Systemtrade_order in database
     * @param systemtrade_order Systemtrade_order object
     * @throws DBException
     */
    public void deleteSystemtrade_order(ISystemtrade_order systemtrade_order) throws DBException {
        cascadedeleteSystemtrade_order(systemtrade_order.getPrimaryKey());
        super.deleteEntity(systemtrade_order);
    }

    /**
     * check data rules in Systemtrade_order, throw DataException with customized message if rules do not apply
     * @param systemtrade_order Systemtrade_order object
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
    public void cascadedeleteSystemtrade_order(ISystemtrade_orderPK systemtrade_orderPK) {
    }

    /**
     * @param ordersPK: foreign key for Orders
     * @delete all Systemtrade_order Entity objects for Orders in database
     */
    public void delete4ordersBuy_order(IOrdersPK ordersPK) {
        super.addStatement(EMsystemtrade_order.SQLDelete4ordersBuy_order, ordersPK.getSQLprimarykey());
    }

    /**
     * @param ordersPK: foreign key for Orders
     * @return all Systemtrade_order Entity objects for Orders
     * @throws CustomException
     */
    public ArrayList<Systemtrade_order> getSystemtrade_orders4ordersBuy_order(IOrdersPK ordersPK) throws CustomException {
        return super.getEntities(EMsystemtrade_order.SQLSelect4ordersBuy_order, ordersPK.getSQLprimarykey());
    }
    /**
     * @param ordersPK: foreign key for Orders
     * @delete all Systemtrade_order Entity objects for Orders in database
     */
    public void delete4ordersSell_order(IOrdersPK ordersPK) {
        super.addStatement(EMsystemtrade_order.SQLDelete4ordersSell_order, ordersPK.getSQLprimarykey());
    }

    /**
     * @param ordersPK: foreign key for Orders
     * @return all Systemtrade_order Entity objects for Orders
     * @throws CustomException
     */
    public ArrayList<Systemtrade_order> getSystemtrade_orders4ordersSell_order(IOrdersPK ordersPK) throws CustomException {
        return super.getEntities(EMsystemtrade_order.SQLSelect4ordersSell_order, ordersPK.getSQLprimarykey());
    }
    /**
     * @param systemtradePK: foreign key for Systemtrade
     * @delete all Systemtrade_order Entity objects for Systemtrade in database
     */
    public void delete4systemtrade(ISystemtradePK systemtradePK) {
        super.addStatement(EMsystemtrade_order.SQLDelete4systemtrade, systemtradePK.getSQLprimarykey());
    }

    /**
     * @param systemtradePK: foreign key for Systemtrade
     * @return all Systemtrade_order Entity objects for Systemtrade
     * @throws CustomException
     */
    public ArrayList<Systemtrade_order> getSystemtrade_orders4systemtrade(ISystemtradePK systemtradePK) throws CustomException {
        return super.getEntities(EMsystemtrade_order.SQLSelect4systemtrade, systemtradePK.getSQLprimarykey());
    }

    /**
     * get all Systemtrade_order objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @param sortlist sql sort string
     * @param sortoperator asc/desc
     * @return ArrayList of Systemtrade_order objects
     * @throws DBException
     */
    public ArrayList<Systemtrade_order> getSystemtrade_orders(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMsystemtrade_order.SQLSelect);
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
        return (ArrayList<Systemtrade_order>)super.getEntities(sql.toString(), sqlparameters);
    }

    /**
     * delete all Systemtrade_order objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @throws DBException
     */
    public void delSystemtrade_order(SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Systemtrade_order.table);
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
