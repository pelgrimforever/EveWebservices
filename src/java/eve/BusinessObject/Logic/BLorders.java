/*
 * BLorders.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 20.4.2021 16:1
 *
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import eve.interfaces.logicentity.IOrders;
import eve.logicentity.Orders;
import BusinessObject.BLtable;
import data.conversion.JSONConversion;
import db.SQLparameters;
import eve.BusinessObject.table.Borders;
import eve.conversion.entity.EMorders;
import eve.data.Swagger;
import eve.entity.pk.EvetypePK;
import eve.entity.pk.Security_islandPK;
import eve.entity.pk.SystemPK;
import general.exception.DataException;
import eve.interfaces.entity.pk.IEvetypePK;
import eve.interfaces.entity.pk.ISystemPK;
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
public class BLorders extends Borders {
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
    public BLorders(BLtable transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }

    public void resetorders() throws DBException, DataException {
        Object[][] parameter = {{ "isopen", false }};
        this.addStatement(sqlmapper.insertParameters(EMorders.SQLreset, parameter));
        this.Commit2DB();
    }
    
    public void deleteorders() throws DBException, DataException {
        this.addStatement(EMorders.Truncate);
        this.Commit2DB();
    }
    
    public void updateOrder(JSONObject jsonorderdetails) throws DBException, DataException {
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
     * load all sell orders from view_systemtradeorders in system, ordered by evetype and price
     * @param systemPK: system primary key
     * @param max_cargovolume: max allowed cargo volume
     * @param net_perc: net percentage of buy order price
     * @return
     * @throws DBException 
     */
    public ArrayList<Orders> load_sellorders4system(ISystemPK systemPK, double max_cargovolume, double net_perc) throws DBException {
        Object[][] parameter = { { "max_cargovolume", max_cargovolume }, { "net_perc", net_perc } };
        SQLparameters sqlparameters = new SQLparameters(parameter);
        sqlparameters.add(systemPK.getSQLprimarykey());
        return getEntities(EMorders.SQLgetSellorders4system2, sqlparameters);
    }

    /**
     * load all sell orders from view_systemtradeorders in system for evetype, ordered by evetype and price
     * @param systemPK: system primary key
     * @param evetypePK: evetype primary key
     * @param max_price: max price
     * @return
     * @throws DBException 
     */
    public ArrayList<Orders> load_sellorders4systemevetype(ISystemPK systemPK, IEvetypePK evetypePK, double max_price) throws DBException {
        Object[][] parameter = { { "max_price", max_price } };
        SQLparameters sqlparameters = new SQLparameters(parameter);
        sqlparameters.add(systemPK.getSQLprimarykey(), evetypePK.getSQLprimarykey());
        return getEntities(EMorders.SQLgetSellorders4systemevetype, sqlparameters);
    }

    /**
     * load all buy orders from view_systemtradeorders in system, ordered by evetype and price desc
     * @param systemPK: system primary key
     * @param max_cargovolume: max allowed cargo volume
     * @param net_perc: net percentage of buy order price
     * @return
     * @throws DBException 
     */
    public ArrayList<Orders> load_buyorders4system(ISystemPK systemPK, double max_cargovolume, double net_perc) throws DBException {
        Object[][] parameter = { { "max_cargovolume", max_cargovolume }, { "net_perc", net_perc } };
        SQLparameters sqlparameters = new SQLparameters(parameter);
        sqlparameters.add(systemPK.getSQLprimarykey(), systemPK.getSQLprimarykey());
        return getEntities(EMorders.SQLgetBuyorders4system2, sqlparameters);
    }    

    /**
     * Search buy orders for eve type, ordered by descending price
     * @param security_islandPK
     * @param evetypePK: evetype primary key
     * @return orders
     * @throws DBException 
     */
    public ArrayList<Orders> load_buyorders4evetype(Security_islandPK security_islandPK, IEvetypePK evetypePK) throws DBException {
        SQLparameters sqlparameters = new SQLparameters(security_islandPK.getSQLprimarykey(), evetypePK.getSQLprimarykey());
        return getEntities(EMorders.SQLgetBuyorders4evetype, sqlparameters);
    }    

    /**
     * try to insert Orders object in database
     * commit transaction
     * @param orders: Orders Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
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
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureinsertOrders(IOrders orders) throws DBException, DataException {
        trans_insertOrders(orders);
        super.Commit2DB();
    }
    
    /**
     * try to update Orders object in database
     * commit transaction
     * @param orders: Orders Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
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
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureupdateOrders(IOrders orders) throws DBException, DataException {
        trans_updateOrders(orders);
        super.Commit2DB();
    }
    
    /**
     * try to delete Orders object in database
     * commit transaction
     * @param orders: Orders Entity Object
     * @throws general.exception.DBException
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
     * @throws general.exception.DBException
     */
    public void securedeleteOrders(IOrders orders) throws DBException {
        trans_deleteOrders(orders);
        super.Commit2DB();
    }

    /**
     * try to insert Orders object in database
     * do not commit transaction
     * @param orders: Orders Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_insertOrders(IOrders orders) throws DBException, DataException {
        super.checkDATA(orders);
        super.insertOrders((Orders)orders);
    }
    
    /**
     * try to update Orders object in database
     * do not commit transaction
     * @param orders: Orders Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_updateOrders(IOrders orders) throws DBException, DataException {
        super.checkDATA(orders);
        super.updateOrders((Orders)orders);
    }
    
    /**
     * try to delete Orders object in database
     * do not commit transaction
     * @param orders: Orders Entity Object
     * @throws general.exception.DBException
     */
    public void trans_deleteOrders(IOrders orders) throws DBException {
        super.deleteOrders((Orders)orders);
    }
}
