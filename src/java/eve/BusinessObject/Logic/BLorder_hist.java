/*
 * BLorder_hist.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 21.4.2021 7:35
 *
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import general.exception.DataException;
import data.interfaces.db.LogicEntity;
import eve.interfaces.logicentity.IOrder_hist;
import eve.logicentity.Order_hist;
import BusinessObject.GeneralEntityObject;
import eve.BusinessObject.table.Border_hist;
import general.exception.DataException;
import eve.interfaces.BusinessObject.IBLorder_hist;
import eve.logicentity.Orders;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Business Logic Entity class BLorder_hist
 *
 * Class for manipulating data- and database objects
 * for Entity Order_hist and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLorder_hist extends Border_hist implements IBLorder_hist {
//ProjectGenerator: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    /**
     * Constructor, sets Order_hist as default Entity
     */
    public BLorder_hist() {
        this.setLogginrequired(isprivatetable);
    }

    /**
     * Constructor, sets Order_hist as default Entity
     * sets transaction queue from given GeneralObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralObjects that holds the transaction queue
     */
    public BLorder_hist(GeneralEntityObject transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }

    /**
     * load extra fields from adjusted sql statement
     */
    @Override
    public void loadExtra(ResultSet dbresult, LogicEntity order_hist) throws SQLException {
        
    }
    
    public void deleteorders() throws DBException, DataException {
        this.transactionqueue.addStatement(this.getClass().getSimpleName(), Order_hist.SQLdeleteall, null);
        this.Commit2DB();
    }
    
    public void copyorders() throws DBException, DataException {
        this.transactionqueue.addStatement(this.getClass().getSimpleName(), Order_hist.SQLcopyorders, null);
        this.Commit2DB();
    }
    
    /**
     * try to insert Order_hist object in database
     * commit transaction
     * @param order_hist: Order_hist Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    @Override
    public void insertOrder_hist(IOrder_hist order_hist) throws DBException, DataException {
        trans_insertOrder_hist(order_hist);
        super.Commit2DB();
    }
    
    /**
     * try to insert Order_hist object in database
     * an alternative to insertOrder_hist, which can be made an empty function
     * commit transaction
     * @param order_hist: Order_hist Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void secureinsertOrder_hist(IOrder_hist order_hist) throws DBException, DataException {
        trans_insertOrder_hist(order_hist);
        super.Commit2DB();
    }
    
    /**
     * try to update Order_hist object in database
     * commit transaction
     * @param order_hist: Order_hist Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    @Override
    public void updateOrder_hist(IOrder_hist order_hist) throws DBException, DataException {
        trans_updateOrder_hist(order_hist);
        super.Commit2DB();
    }
    
    /**
     * try to update Order_hist object in database
     * an alternative to updateOrder_hist, which can be made an empty function
     * commit transaction
     * @param order_hist: Order_hist Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void secureupdateOrder_hist(IOrder_hist order_hist) throws DBException, DataException {
        trans_updateOrder_hist(order_hist);
        super.Commit2DB();
    }
    
    /**
     * try to delete Order_hist object in database
     * commit transaction
     * @param order_hist: Order_hist Entity Object
     * @throws eve.general.exception.CustomException
     */
    @Override
    public void deleteOrder_hist(IOrder_hist order_hist) throws DBException {
        trans_deleteOrder_hist(order_hist);
        super.Commit2DB();
    }

    /**
     * try to delete Order_hist object in database
     * an alternative to deleteOrder_hist, which can be made an empty function
     * commit transaction
     * @param order_hist: Order_hist Entity Object
     * @throws eve.general.exception.CustomException
     */
    public void securedeleteOrder_hist(IOrder_hist order_hist) throws DBException {
        trans_deleteOrder_hist(order_hist);
        super.Commit2DB();
    }

    /**
     * try to insert Order_hist object in database
     * do not commit transaction
     * @param order_hist: Order_hist Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void trans_insertOrder_hist(IOrder_hist order_hist) throws DBException, DataException {
        super.checkDATA(order_hist);
        super.insertOrder_hist((Order_hist)order_hist);
    }
    
    /**
     * try to update Order_hist object in database
     * do not commit transaction
     * @param order_hist: Order_hist Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void trans_updateOrder_hist(IOrder_hist order_hist) throws DBException, DataException {
        super.checkDATA(order_hist);
        super.updateOrder_hist((Order_hist)order_hist);
    }
    
    /**
     * try to delete Order_hist object in database
     * do not commit transaction
     * @param order_hist: Order_hist Entity Object
     * @throws eve.general.exception.CustomException
     */
    public void trans_deleteOrder_hist(IOrder_hist order_hist) throws DBException {
        super.deleteOrder_hist((Order_hist)order_hist);
    }
}
