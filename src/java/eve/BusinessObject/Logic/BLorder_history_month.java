/*
 * BLorder_history_month.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 13.11.2021 15:8
 *
 */

package eve.BusinessObject.Logic;

import BusinessObject.BLtable;
import general.exception.DBException;
import general.exception.DataException;
import data.interfaces.db.LogicEntity;
import eve.interfaces.logicentity.IOrder_history_month;
import eve.logicentity.Order_history_month;
import eve.BusinessObject.table.Border_history_month;
import eve.conversion.entity.EMorder_history_month;
import general.exception.DataException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Business Logic Entity class BLorder_history_month
 *
 * Class for manipulating data- and database objects
 * for Entity Order_history_month and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLorder_history_month extends Border_history_month {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    /**
     * Constructor, sets Order_history_month as default Entity
     */
    public BLorder_history_month() {
        this.setLogginrequired(isprivatetable);
    }

    /**
     * Constructor, sets Order_history_month as default Entity
     * sets transaction queue from given GeneralObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralObjects that holds the transaction queue
     */
    public BLorder_history_month(BLtable transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }

    public void deleteall() {
        this.addStatement(EMorder_history_month.SQLdeleteAll);
    }
    
    public void buildfromMarkethistory() {
        this.addStatement(EMorder_history_month.SQLcopymarkethistory);
    }
    
    /**
     * try to insert Order_history_month object in database
     * commit transaction
     * @param order_history_month: Order_history_month Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void insertOrder_history_month(IOrder_history_month order_history_month) throws DBException, DataException {
        trans_insertOrder_history_month(order_history_month);
        super.Commit2DB();
    }
    
    /**
     * try to insert Order_history_month object in database
     * an alternative to insertOrder_history_month, which can be made an empty function
     * commit transaction
     * @param order_history_month: Order_history_month Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureinsertOrder_history_month(IOrder_history_month order_history_month) throws DBException, DataException {
        trans_insertOrder_history_month(order_history_month);
        super.Commit2DB();
    }
    
    /**
     * try to update Order_history_month object in database
     * commit transaction
     * @param order_history_month: Order_history_month Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void updateOrder_history_month(IOrder_history_month order_history_month) throws DBException, DataException {
        trans_updateOrder_history_month(order_history_month);
        super.Commit2DB();
    }
    
    /**
     * try to update Order_history_month object in database
     * an alternative to updateOrder_history_month, which can be made an empty function
     * commit transaction
     * @param order_history_month: Order_history_month Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureupdateOrder_history_month(IOrder_history_month order_history_month) throws DBException, DataException {
        trans_updateOrder_history_month(order_history_month);
        super.Commit2DB();
    }
    
    /**
     * try to delete Order_history_month object in database
     * commit transaction
     * @param order_history_month: Order_history_month Entity Object
     * @throws general.exception.DBException
     */
    @Override
    public void deleteOrder_history_month(IOrder_history_month order_history_month) throws DBException {
        trans_deleteOrder_history_month(order_history_month);
        super.Commit2DB();
    }

    /**
     * try to delete Order_history_month object in database
     * an alternative to deleteOrder_history_month, which can be made an empty function
     * commit transaction
     * @param order_history_month: Order_history_month Entity Object
     * @throws general.exception.DBException
     */
    public void securedeleteOrder_history_month(IOrder_history_month order_history_month) throws DBException {
        trans_deleteOrder_history_month(order_history_month);
        super.Commit2DB();
    }

    /**
     * try to insert Order_history_month object in database
     * do not commit transaction
     * @param order_history_month: Order_history_month Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_insertOrder_history_month(IOrder_history_month order_history_month) throws DBException, DataException {
        super.checkDATA(order_history_month);
        super.insertOrder_history_month((Order_history_month)order_history_month);
    }
    
    /**
     * try to update Order_history_month object in database
     * do not commit transaction
     * @param order_history_month: Order_history_month Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_updateOrder_history_month(IOrder_history_month order_history_month) throws DBException, DataException {
        super.checkDATA(order_history_month);
        super.updateOrder_history_month((Order_history_month)order_history_month);
    }
    
    /**
     * try to delete Order_history_month object in database
     * do not commit transaction
     * @param order_history_month: Order_history_month Entity Object
     * @throws general.exception.DBException
     */
    public void trans_deleteOrder_history_month(IOrder_history_month order_history_month) throws DBException {
        super.deleteOrder_history_month((Order_history_month)order_history_month);
    }
}
