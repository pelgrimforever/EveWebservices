/*
 * BLorder_history.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 21.4.2021 21:43
 *
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import eve.interfaces.logicentity.IOrder_history;
import eve.logicentity.Order_history;
import BusinessObject.BLtable;
import data.conversion.JSONConversion;
import eve.BusinessObject.table.Border_history;
import eve.conversion.entity.EMorder_history;
import eve.data.Swagger;
import general.exception.DataException;
import org.json.simple.JSONObject;

/**
 * Business Logic Entity class BLorder_history
 *
 * Class for manipulating data- and database objects
 * for Entity Order_history and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLorder_history extends Border_history {
//ProjectGenerator: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    /**
     * Constructor, sets Order_history as default Entity
     */
    public BLorder_history() {
        this.setLogginrequired(isprivatetable);
    }

    /**
     * Constructor, sets Order_history as default Entity
     * sets transaction queue from given GeneralObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralObjects that holds the transaction queue
     */
    public BLorder_history(BLtable transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }

    public void deleteorders() throws DBException, DataException {
        this.addStatement(EMorder_history.SQLdeleteall);
        this.Commit2DB();
    }
    
    public void updateOrder_history(long regionid, long evetypeid, JSONObject jsonhistory) throws DBException, DataException {
        String stringdate = JSONConversion.getString(jsonhistory, "date");
        Order_history history = new Order_history(regionid, evetypeid, Swagger.datestring2Date(stringdate));
        history.setAverage(JSONConversion.getDouble(jsonhistory, "average"));
        history.setHighest(JSONConversion.getDouble(jsonhistory, "highest"));
        history.setLowest(JSONConversion.getDouble(jsonhistory, "lowest"));
        history.setOrder_count(JSONConversion.getint(jsonhistory, "order_count"));
        history.setVolume(JSONConversion.getint(jsonhistory, "volume"));
        this.insertupdateOrder_history(history);
    }

    /**
     * try to insert Order_history object in database
     * commit transaction
     * @param order_history: Order_history Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void insertOrder_history(IOrder_history order_history) throws DBException, DataException {
        trans_insertOrder_history(order_history);
        super.Commit2DB();
    }
    
    /**
     * try to insert Order_history object in database
     * an alternative to insertOrder_history, which can be made an empty function
     * commit transaction
     * @param order_history: Order_history Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureinsertOrder_history(IOrder_history order_history) throws DBException, DataException {
        trans_insertOrder_history(order_history);
        super.Commit2DB();
    }
    
    /**
     * try to update Order_history object in database
     * commit transaction
     * @param order_history: Order_history Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void updateOrder_history(IOrder_history order_history) throws DBException, DataException {
        trans_updateOrder_history(order_history);
        super.Commit2DB();
    }
    
    /**
     * try to update Order_history object in database
     * an alternative to updateOrder_history, which can be made an empty function
     * commit transaction
     * @param order_history: Order_history Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureupdateOrder_history(IOrder_history order_history) throws DBException, DataException {
        trans_updateOrder_history(order_history);
        super.Commit2DB();
    }
    
    /**
     * try to delete Order_history object in database
     * commit transaction
     * @param order_history: Order_history Entity Object
     * @throws general.exception.DBException
     */
    @Override
    public void deleteOrder_history(IOrder_history order_history) throws DBException {
        trans_deleteOrder_history(order_history);
        super.Commit2DB();
    }

    /**
     * try to delete Order_history object in database
     * an alternative to deleteOrder_history, which can be made an empty function
     * commit transaction
     * @param order_history: Order_history Entity Object
     * @throws general.exception.DBException
     */
    public void securedeleteOrder_history(IOrder_history order_history) throws DBException {
        trans_deleteOrder_history(order_history);
        super.Commit2DB();
    }

    /**
     * try to insert Order_history object in database
     * do not commit transaction
     * @param order_history: Order_history Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_insertOrder_history(IOrder_history order_history) throws DBException, DataException {
        super.checkDATA(order_history);
        super.insertOrder_history((Order_history)order_history);
    }
    
    /**
     * try to update Order_history object in database
     * do not commit transaction
     * @param order_history: Order_history Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_updateOrder_history(IOrder_history order_history) throws DBException, DataException {
        super.checkDATA(order_history);
        super.updateOrder_history((Order_history)order_history);
    }
    
    /**
     * try to delete Order_history object in database
     * do not commit transaction
     * @param order_history: Order_history Entity Object
     * @throws general.exception.DBException
     */
    public void trans_deleteOrder_history(IOrder_history order_history) throws DBException {
        super.deleteOrder_history((Order_history)order_history);
    }
}
