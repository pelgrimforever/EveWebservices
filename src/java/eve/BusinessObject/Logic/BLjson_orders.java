/*
 * BLjson_orders.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 5.5.2021 16:49
 *
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import eve.interfaces.logicentity.IJson_orders;
import eve.logicentity.Json_orders;
import BusinessObject.BLtable;
import eve.BusinessObject.table.Bjson_orders;
import general.exception.DataException;

/**
 * Business Logic Entity class BLjson_orders
 *
 * Class for manipulating data- and database objects
 * for Entity Json_orders and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLjson_orders extends Bjson_orders {
//ProjectGenerator: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    /**
     * Constructor, sets Json_orders as default Entity
     */
    public BLjson_orders() {
        this.setLogginrequired(isprivatetable);
    }

    /**
     * Constructor, sets Json_orders as default Entity
     * sets transaction queue from given GeneralObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralObjects that holds the transaction queue
     */
    public BLjson_orders(BLtable transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }

    /**
     * try to insert Json_orders object in database
     * commit transaction
     * @param json_orders: Json_orders Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    @Override
    public void insertJson_orders(IJson_orders json_orders) throws DBException, DataException {
        trans_insertJson_orders(json_orders);
        super.Commit2DB();
    }
    
    /**
     * try to insert Json_orders object in database
     * an alternative to insertJson_orders, which can be made an empty function
     * commit transaction
     * @param json_orders: Json_orders Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void secureinsertJson_orders(IJson_orders json_orders) throws DBException, DataException {
        trans_insertJson_orders(json_orders);
        super.Commit2DB();
    }
    
    /**
     * try to update Json_orders object in database
     * commit transaction
     * @param json_orders: Json_orders Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    @Override
    public void updateJson_orders(IJson_orders json_orders) throws DBException, DataException {
        trans_updateJson_orders(json_orders);
        super.Commit2DB();
    }
    
    /**
     * try to update Json_orders object in database
     * an alternative to updateJson_orders, which can be made an empty function
     * commit transaction
     * @param json_orders: Json_orders Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void secureupdateJson_orders(IJson_orders json_orders) throws DBException, DataException {
        trans_updateJson_orders(json_orders);
        super.Commit2DB();
    }
    
    /**
     * try to delete Json_orders object in database
     * commit transaction
     * @param json_orders: Json_orders Entity Object
     * @throws eve.general.exception.CustomException
     */
    @Override
    public void deleteJson_orders(IJson_orders json_orders) throws DBException {
        trans_deleteJson_orders(json_orders);
        super.Commit2DB();
    }

    /**
     * try to delete Json_orders object in database
     * an alternative to deleteJson_orders, which can be made an empty function
     * commit transaction
     * @param json_orders: Json_orders Entity Object
     * @throws eve.general.exception.CustomException
     */
    public void securedeleteJson_orders(IJson_orders json_orders) throws DBException {
        trans_deleteJson_orders(json_orders);
        super.Commit2DB();
    }

    /**
     * try to insert Json_orders object in database
     * do not commit transaction
     * @param json_orders: Json_orders Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void trans_insertJson_orders(IJson_orders json_orders) throws DBException, DataException {
        super.checkDATA(json_orders);
        super.insertJson_orders((Json_orders)json_orders);
    }
    
    /**
     * try to update Json_orders object in database
     * do not commit transaction
     * @param json_orders: Json_orders Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void trans_updateJson_orders(IJson_orders json_orders) throws DBException, DataException {
        super.checkDATA(json_orders);
        super.updateJson_orders((Json_orders)json_orders);
    }
    
    /**
     * try to delete Json_orders object in database
     * do not commit transaction
     * @param json_orders: Json_orders Entity Object
     * @throws eve.general.exception.CustomException
     */
    public void trans_deleteJson_orders(IJson_orders json_orders) throws DBException {
        super.deleteJson_orders((Json_orders)json_orders);
    }
}
