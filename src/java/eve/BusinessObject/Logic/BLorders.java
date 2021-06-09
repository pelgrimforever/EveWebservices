/*
 * BLorders.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 20.4.2021 16:1
 *
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import data.interfaces.db.LogicEntity;
import eve.interfaces.logicentity.IOrders;
import eve.logicentity.Orders;
import BusinessObject.GeneralEntityObject;
import data.conversion.JSONConversion;
import db.AbstractSQLMapper;
import eve.BusinessObject.table.Borders;
import eve.data.Swagger;
import eve.entity.pk.EvetypePK;
import eve.entity.pk.Security_islandPK;
import eve.entity.pk.SystemPK;
import general.exception.DataException;
import eve.interfaces.BusinessObject.IBLorders;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.json.simple.JSONObject;

/**
 * Business Logic Entity class BLorders
 *
 * Class for manipulating data- and database objects
 * for Entity Orders and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLorders extends Borders implements IBLorders {
//ProjectGenerator: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    /**
     * Constructor, sets Orders as default Entity
     */
    public BLorders() {
        this.setLogginrequired(isprivatetable);
    }

    /**
     * Constructor, sets Orders as default Entity
     * sets transaction queue from given GeneralObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralObjects that holds the transaction queue
     */
    public BLorders(GeneralEntityObject transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }

    /**
     * load extra fields from adjusted sql statement
     */
    @Override
    public void loadExtra(ResultSet dbresult, LogicEntity orders) throws SQLException {
        Orders order = (Orders)orders;
        try {
            order.setPackaged_volume(dbresult.getDouble("packaged_volume"));
        }
        catch(SQLException e) {
        }
    }
    
    public void resetorders() throws DBException, DataException {
        Object[][] parameter = {{ "isopen", false }};
        this.transactionqueue.addStatement(this.getClass().getSimpleName(), Orders.SQLreset, parameter);
        this.Commit2DB();
    }
    
    public void deleteorders() throws DBException, DataException {
        BLtrade bltrade = new BLtrade(this);
        bltrade.deletetrade();
        this.transactionqueue.addStatement(this.getClass().getSimpleName(), Orders.SQLdeleteall, null);
        this.Commit2DB();
    }
    
    public void updateOrder(JSONObject jsonorderdetails) throws DBException, DataException {
        System.out.println("Order " + JSONConversion.getLong(jsonorderdetails, "order_id"));
        Orders order = new Orders(JSONConversion.getLong(jsonorderdetails, "order_id"));
        order.setDuration(JSONConversion.getint(jsonorderdetails, "duration"));
        order.setEvetypePK(new EvetypePK(JSONConversion.getLong(jsonorderdetails, "type_id")));
        order.setIs_buy_order(JSONConversion.getboolean(jsonorderdetails, "is_buy_order"));
        order.setIsopen(true);
        String stringdateissued = JSONConversion.getString(jsonorderdetails, "issued");
        order.setIssued(Swagger.datetimestring2Timestamp(stringdateissued));
        order.setLocation(JSONConversion.getLong(jsonorderdetails, "location_id"));
        order.setMin_volume(JSONConversion.getint(jsonorderdetails, "min_volume"));
        order.setPrice(JSONConversion.getDouble(jsonorderdetails, "price"));
        order.setRange(JSONConversion.getString(jsonorderdetails, "range"));
        int rangenumber = 0;
        try {
            rangenumber = Integer.valueOf(order.getRange());
        }
        catch(Exception e) {
            //means range is not numeric, 0 will be used
        }
        order.setRange_number(rangenumber);
        order.setSystemPK(new SystemPK(JSONConversion.getLong(jsonorderdetails, "system_id")));
        order.setVolume_remain(JSONConversion.getint(jsonorderdetails, "volume_remain"));
        order.setVolume_total(JSONConversion.getint(jsonorderdetails, "volume_total"));
        this.insertupdateOrders(order);
    }

    /**
     * load all buy orders with
     * - price > min sel order price
     * - unit volume <= max_volume
     * - ordered by evetype, system
     * @param max_volume
     * @return
     * @throws DBException 
     */
    public ArrayList load_buy_orders(double max_volume, Security_islandPK security_islandPK) throws DBException {
        Object[][] parameter = { { "maxvolume", max_volume } };
        parameter = AbstractSQLMapper.addKeyArrays(parameter, security_islandPK.getKeyFields());
        return getMapper().loadEntityVector(this, Orders.SQLbuy_orders, parameter);
    }
    
    /**
     * load all buy orders for evetype with
     * - price > min sel order price
     * - unit volume <= max_volume
     * - ordered by evetype, system
     * @param max_volume
     * @return
     * @throws DBException 
     */
    public ArrayList load_buy_orders_4evetype(double max_volume, Security_islandPK security_islandPK, EvetypePK evetypePK) throws DBException {
        Object[][] parameter = { { "maxvolume", max_volume } };
        parameter = AbstractSQLMapper.addKeyArrays(parameter, evetypePK.getKeyFields());
        parameter = AbstractSQLMapper.addKeyArrays(parameter, security_islandPK.getKeyFields());
        return getMapper().loadEntityVector(this, Orders.SQLbuy_orders4evetype, parameter);
    }
    
    /**
     * load all sell orders with
     * - price < max buy order price
     * - unit volume <= max_volume
     * - ordered by evetype, system
     * @param max_volume
     * @return
     * @throws DBException 
     */
    public ArrayList load_sell_orders(double max_volume, Security_islandPK security_islandPK) throws DBException {
        Object[][] parameter = { { "maxvolume", max_volume } };
        parameter = AbstractSQLMapper.addKeyArrays(parameter, security_islandPK.getKeyFields());
        return getMapper().loadEntityVector(this, Orders.SQLsell_orders, parameter);
    }
    
    /**
     * try to insert Orders object in database
     * commit transaction
     * @param orders: Orders Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    @Override
    public void insertOrders(IOrders orders) throws DBException, DataException {
        trans_insertOrders(orders);
        super.Commit2DB();
    }
    
    /**
     * try to insert Orders object in database
     * an alternative to insertOrders, which can be made an empty function
     * commit transaction
     * @param orders: Orders Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void secureinsertOrders(IOrders orders) throws DBException, DataException {
        trans_insertOrders(orders);
        super.Commit2DB();
    }
    
    /**
     * try to update Orders object in database
     * commit transaction
     * @param orders: Orders Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    @Override
    public void updateOrders(IOrders orders) throws DBException, DataException {
        trans_updateOrders(orders);
        super.Commit2DB();
    }
    
    /**
     * try to update Orders object in database
     * an alternative to updateOrders, which can be made an empty function
     * commit transaction
     * @param orders: Orders Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void secureupdateOrders(IOrders orders) throws DBException, DataException {
        trans_updateOrders(orders);
        super.Commit2DB();
    }
    
    /**
     * try to delete Orders object in database
     * commit transaction
     * @param orders: Orders Entity Object
     * @throws eve.general.exception.CustomException
     */
    @Override
    public void deleteOrders(IOrders orders) throws DBException {
        trans_deleteOrders(orders);
        super.Commit2DB();
    }

    /**
     * try to delete Orders object in database
     * an alternative to deleteOrders, which can be made an empty function
     * commit transaction
     * @param orders: Orders Entity Object
     * @throws eve.general.exception.CustomException
     */
    public void securedeleteOrders(IOrders orders) throws DBException {
        trans_deleteOrders(orders);
        super.Commit2DB();
    }

    /**
     * try to insert Orders object in database
     * do not commit transaction
     * @param orders: Orders Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void trans_insertOrders(IOrders orders) throws DBException, DataException {
        super.checkDATA(orders);
        super.insertOrders((Orders)orders);
    }
    
    /**
     * try to update Orders object in database
     * do not commit transaction
     * @param orders: Orders Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void trans_updateOrders(IOrders orders) throws DBException, DataException {
        super.checkDATA(orders);
        super.updateOrders((Orders)orders);
    }
    
    /**
     * try to delete Orders object in database
     * do not commit transaction
     * @param orders: Orders Entity Object
     * @throws eve.general.exception.CustomException
     */
    public void trans_deleteOrders(IOrders orders) throws DBException {
        super.deleteOrders((Orders)orders);
    }
}
