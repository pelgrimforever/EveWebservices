/*
 * BLtrade.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 1.5.2021 17:54
 *
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import general.exception.DataException;
import data.interfaces.db.LogicEntity;
import eve.interfaces.logicentity.ITrade;
import eve.logicentity.Trade;
import BusinessObject.GeneralEntityObject;
import eve.BusinessObject.table.Btrade;
import general.exception.DataException;
import eve.interfaces.BusinessObject.IBLtrade;
import eve.logicentity.Orders;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Business Logic Entity class BLtrade
 *
 * Class for manipulating data- and database objects
 * for Entity Trade and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLtrade extends Btrade implements IBLtrade {
//ProjectGenerator: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    /**
     * Constructor, sets Trade as default Entity
     */
    public BLtrade() {
        this.setLogginrequired(isprivatetable);
    }

    /**
     * Constructor, sets Trade as default Entity
     * sets transaction queue from given GeneralObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralObjects that holds the transaction queue
     */
    public BLtrade(GeneralEntityObject transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }

    /**
     * load extra fields from adjusted sql statement
     */
    @Override
    public void loadExtra(ResultSet dbresult, LogicEntity trade) throws SQLException {
        
    }
    
    /**
     * delete all trade lines
     * @throws DBException
     * @throws DataException 
     */
    public void deletetrade() throws DBException, DataException {
        this.transactionqueue.addStatement(this.getClass().getSimpleName(), Trade.SQLdeleteall, null);
        this.Commit2DB();
    }
    
    /**
     * try to insert Trade object in database
     * commit transaction
     * @param trade: Trade Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    @Override
    public void insertTrade(ITrade trade) throws DBException, DataException {
        trans_insertTrade(trade);
        super.Commit2DB();
    }
    
    /**
     * try to insert Trade object in database
     * an alternative to insertTrade, which can be made an empty function
     * commit transaction
     * @param trade: Trade Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void secureinsertTrade(ITrade trade) throws DBException, DataException {
        trans_insertTrade(trade);
        super.Commit2DB();
    }
    
    /**
     * try to update Trade object in database
     * commit transaction
     * @param trade: Trade Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    @Override
    public void updateTrade(ITrade trade) throws DBException, DataException {
        trans_updateTrade(trade);
        super.Commit2DB();
    }
    
    /**
     * try to update Trade object in database
     * an alternative to updateTrade, which can be made an empty function
     * commit transaction
     * @param trade: Trade Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void secureupdateTrade(ITrade trade) throws DBException, DataException {
        trans_updateTrade(trade);
        super.Commit2DB();
    }
    
    /**
     * try to delete Trade object in database
     * commit transaction
     * @param trade: Trade Entity Object
     * @throws eve.general.exception.CustomException
     */
    @Override
    public void deleteTrade(ITrade trade) throws DBException {
        trans_deleteTrade(trade);
        super.Commit2DB();
    }

    /**
     * try to delete Trade object in database
     * an alternative to deleteTrade, which can be made an empty function
     * commit transaction
     * @param trade: Trade Entity Object
     * @throws eve.general.exception.CustomException
     */
    public void securedeleteTrade(ITrade trade) throws DBException {
        trans_deleteTrade(trade);
        super.Commit2DB();
    }

    /**
     * try to insert Trade object in database
     * do not commit transaction
     * @param trade: Trade Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void trans_insertTrade(ITrade trade) throws DBException, DataException {
        super.checkDATA(trade);
        super.insertTrade((Trade)trade);
    }
    
    /**
     * try to update Trade object in database
     * do not commit transaction
     * @param trade: Trade Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void trans_updateTrade(ITrade trade) throws DBException, DataException {
        super.checkDATA(trade);
        super.updateTrade((Trade)trade);
    }
    
    /**
     * try to delete Trade object in database
     * do not commit transaction
     * @param trade: Trade Entity Object
     * @throws eve.general.exception.CustomException
     */
    public void trans_deleteTrade(ITrade trade) throws DBException {
        super.deleteTrade((Trade)trade);
    }
}
