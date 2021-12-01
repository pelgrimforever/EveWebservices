/*
 * BLtradecombined.java
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
import eve.interfaces.logicentity.ITradecombined;
import eve.logicentity.Tradecombined;
import eve.BusinessObject.table.Btradecombined;
import general.exception.DataException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Business Logic Entity class BLtradecombined
 *
 * Class for manipulating data- and database objects
 * for Entity Tradecombined and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLtradecombined extends Btradecombined {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    /**
     * Constructor, sets Tradecombined as default Entity
     */
    public BLtradecombined() {
        this.setLogginrequired(isprivatetable);
    }

    /**
     * Constructor, sets Tradecombined as default Entity
     * sets transaction queue from given GeneralObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralObjects that holds the transaction queue
     */
    public BLtradecombined(BLtable transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }

    /**
     * try to insert Tradecombined object in database
     * commit transaction
     * @param tradecombined: Tradecombined Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void insertTradecombined(ITradecombined tradecombined) throws DBException, DataException {
        trans_insertTradecombined(tradecombined);
        super.Commit2DB();
    }
    
    /**
     * try to insert Tradecombined object in database
     * an alternative to insertTradecombined, which can be made an empty function
     * commit transaction
     * @param tradecombined: Tradecombined Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureinsertTradecombined(ITradecombined tradecombined) throws DBException, DataException {
        trans_insertTradecombined(tradecombined);
        super.Commit2DB();
    }
    
    /**
     * try to update Tradecombined object in database
     * commit transaction
     * @param tradecombined: Tradecombined Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void updateTradecombined(ITradecombined tradecombined) throws DBException, DataException {
        trans_updateTradecombined(tradecombined);
        super.Commit2DB();
    }
    
    /**
     * try to update Tradecombined object in database
     * an alternative to updateTradecombined, which can be made an empty function
     * commit transaction
     * @param tradecombined: Tradecombined Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureupdateTradecombined(ITradecombined tradecombined) throws DBException, DataException {
        trans_updateTradecombined(tradecombined);
        super.Commit2DB();
    }
    
    /**
     * try to delete Tradecombined object in database
     * commit transaction
     * @param tradecombined: Tradecombined Entity Object
     * @throws general.exception.DBException
     */
    @Override
    public void deleteTradecombined(ITradecombined tradecombined) throws DBException {
        trans_deleteTradecombined(tradecombined);
        super.Commit2DB();
    }

    /**
     * try to delete Tradecombined object in database
     * an alternative to deleteTradecombined, which can be made an empty function
     * commit transaction
     * @param tradecombined: Tradecombined Entity Object
     * @throws general.exception.DBException
     */
    public void securedeleteTradecombined(ITradecombined tradecombined) throws DBException {
        trans_deleteTradecombined(tradecombined);
        super.Commit2DB();
    }

    /**
     * try to insert Tradecombined object in database
     * do not commit transaction
     * @param tradecombined: Tradecombined Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_insertTradecombined(ITradecombined tradecombined) throws DBException, DataException {
        super.checkDATA(tradecombined);
        super.insertTradecombined((Tradecombined)tradecombined);
    }
    
    /**
     * try to update Tradecombined object in database
     * do not commit transaction
     * @param tradecombined: Tradecombined Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_updateTradecombined(ITradecombined tradecombined) throws DBException, DataException {
        super.checkDATA(tradecombined);
        super.updateTradecombined((Tradecombined)tradecombined);
    }
    
    /**
     * try to delete Tradecombined object in database
     * do not commit transaction
     * @param tradecombined: Tradecombined Entity Object
     * @throws general.exception.DBException
     */
    public void trans_deleteTradecombined(ITradecombined tradecombined) throws DBException {
        super.deleteTradecombined((Tradecombined)tradecombined);
    }
}
