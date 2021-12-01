/*
 * BLtradecombined_sell.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 22.10.2021 17:25
 *
 */

package eve.BusinessObject.Logic;

import BusinessObject.BLtable;
import general.exception.DBException;
import general.exception.DataException;
import data.interfaces.db.LogicEntity;
import eve.interfaces.logicentity.ITradecombined_sell;
import eve.logicentity.Tradecombined_sell;
import eve.BusinessObject.table.Btradecombined_sell;
import general.exception.DataException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Business Logic Entity class BLtradecombined_sell
 *
 * Class for manipulating data- and database objects
 * for Entity Tradecombined_sell and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLtradecombined_sell extends Btradecombined_sell {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    /**
     * Constructor, sets Tradecombined_sell as default Entity
     */
    public BLtradecombined_sell() {
        this.setLogginrequired(isprivatetable);
    }

    /**
     * Constructor, sets Tradecombined_sell as default Entity
     * sets transaction queue from given GeneralObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralObjects that holds the transaction queue
     */
    public BLtradecombined_sell(BLtable transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }

    /**
     * try to insert Tradecombined_sell object in database
     * commit transaction
     * @param tradecombined_sell: Tradecombined_sell Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void insertTradecombined_sell(ITradecombined_sell tradecombined_sell) throws DBException, DataException {
        trans_insertTradecombined_sell(tradecombined_sell);
        super.Commit2DB();
    }
    
    /**
     * try to insert Tradecombined_sell object in database
     * an alternative to insertTradecombined_sell, which can be made an empty function
     * commit transaction
     * @param tradecombined_sell: Tradecombined_sell Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureinsertTradecombined_sell(ITradecombined_sell tradecombined_sell) throws DBException, DataException {
        trans_insertTradecombined_sell(tradecombined_sell);
        super.Commit2DB();
    }
    
    /**
     * try to update Tradecombined_sell object in database
     * commit transaction
     * @param tradecombined_sell: Tradecombined_sell Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void updateTradecombined_sell(ITradecombined_sell tradecombined_sell) throws DBException, DataException {
        trans_updateTradecombined_sell(tradecombined_sell);
        super.Commit2DB();
    }
    
    /**
     * try to update Tradecombined_sell object in database
     * an alternative to updateTradecombined_sell, which can be made an empty function
     * commit transaction
     * @param tradecombined_sell: Tradecombined_sell Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureupdateTradecombined_sell(ITradecombined_sell tradecombined_sell) throws DBException, DataException {
        trans_updateTradecombined_sell(tradecombined_sell);
        super.Commit2DB();
    }
    
    /**
     * try to delete Tradecombined_sell object in database
     * commit transaction
     * @param tradecombined_sell: Tradecombined_sell Entity Object
     * @throws general.exception.DBException
     */
    @Override
    public void deleteTradecombined_sell(ITradecombined_sell tradecombined_sell) throws DBException {
        trans_deleteTradecombined_sell(tradecombined_sell);
        super.Commit2DB();
    }

    /**
     * try to delete Tradecombined_sell object in database
     * an alternative to deleteTradecombined_sell, which can be made an empty function
     * commit transaction
     * @param tradecombined_sell: Tradecombined_sell Entity Object
     * @throws general.exception.DBException
     */
    public void securedeleteTradecombined_sell(ITradecombined_sell tradecombined_sell) throws DBException {
        trans_deleteTradecombined_sell(tradecombined_sell);
        super.Commit2DB();
    }

    /**
     * try to insert Tradecombined_sell object in database
     * do not commit transaction
     * @param tradecombined_sell: Tradecombined_sell Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_insertTradecombined_sell(ITradecombined_sell tradecombined_sell) throws DBException, DataException {
        super.checkDATA(tradecombined_sell);
        super.insertTradecombined_sell((Tradecombined_sell)tradecombined_sell);
    }
    
    /**
     * try to update Tradecombined_sell object in database
     * do not commit transaction
     * @param tradecombined_sell: Tradecombined_sell Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_updateTradecombined_sell(ITradecombined_sell tradecombined_sell) throws DBException, DataException {
        super.checkDATA(tradecombined_sell);
        super.updateTradecombined_sell((Tradecombined_sell)tradecombined_sell);
    }
    
    /**
     * try to delete Tradecombined_sell object in database
     * do not commit transaction
     * @param tradecombined_sell: Tradecombined_sell Entity Object
     * @throws general.exception.DBException
     */
    public void trans_deleteTradecombined_sell(ITradecombined_sell tradecombined_sell) throws DBException {
        super.deleteTradecombined_sell((Tradecombined_sell)tradecombined_sell);
    }
}
