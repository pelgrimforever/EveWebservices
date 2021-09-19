/*
 * BLstocktrade.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 24.7.2021 17:21
 *
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import general.exception.DataException;
import data.interfaces.db.LogicEntity;
import eve.interfaces.logicentity.IStocktrade;
import eve.logicentity.Stocktrade;
import BusinessObject.GeneralEntityObject;
import eve.BusinessObject.table.Bstocktrade;
import general.exception.DataException;
import eve.interfaces.BusinessObject.IBLstocktrade;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Business Logic Entity class BLstocktrade
 *
 * Class for manipulating data- and database objects
 * for Entity Stocktrade and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLstocktrade extends Bstocktrade implements IBLstocktrade {
//ProjectGenerator: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    /**
     * Constructor, sets Stocktrade as default Entity
     */
    public BLstocktrade() {
        this.setLogginrequired(isprivatetable);
    }

    /**
     * Constructor, sets Stocktrade as default Entity
     * sets transaction queue from given GeneralObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralObjects that holds the transaction queue
     */
    public BLstocktrade(GeneralEntityObject transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }

    /**
     * delete all stocktrade lines
     * @throws DBException
     * @throws DataException 
     */
    public void deletestocktrade() throws DBException, DataException {
        this.transactionqueue.addStatement(this.getClass().getSimpleName(), Stocktrade.SQLdeleteall, null);
        this.Commit2DB();
    }
    
    /**
     * load extra fields from adjusted sql statement
     */
    @Override
    public void loadExtra(ResultSet dbresult, LogicEntity stocktrade) throws SQLException {
        
    }
    
    /**
     * try to insert Stocktrade object in database
     * commit transaction
     * @param stocktrade: Stocktrade Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    @Override
    public void insertStocktrade(IStocktrade stocktrade) throws DBException, DataException {
        trans_insertStocktrade(stocktrade);
        super.Commit2DB();
    }
    
    /**
     * try to insert Stocktrade object in database
     * an alternative to insertStocktrade, which can be made an empty function
     * commit transaction
     * @param stocktrade: Stocktrade Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void secureinsertStocktrade(IStocktrade stocktrade) throws DBException, DataException {
        trans_insertStocktrade(stocktrade);
        super.Commit2DB();
    }
    
    /**
     * try to update Stocktrade object in database
     * commit transaction
     * @param stocktrade: Stocktrade Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    @Override
    public void updateStocktrade(IStocktrade stocktrade) throws DBException, DataException {
        trans_updateStocktrade(stocktrade);
        super.Commit2DB();
    }
    
    /**
     * try to update Stocktrade object in database
     * an alternative to updateStocktrade, which can be made an empty function
     * commit transaction
     * @param stocktrade: Stocktrade Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void secureupdateStocktrade(IStocktrade stocktrade) throws DBException, DataException {
        trans_updateStocktrade(stocktrade);
        super.Commit2DB();
    }
    
    /**
     * try to delete Stocktrade object in database
     * commit transaction
     * @param stocktrade: Stocktrade Entity Object
     * @throws eve.general.exception.CustomException
     */
    @Override
    public void deleteStocktrade(IStocktrade stocktrade) throws DBException {
        trans_deleteStocktrade(stocktrade);
        super.Commit2DB();
    }

    /**
     * try to delete Stocktrade object in database
     * an alternative to deleteStocktrade, which can be made an empty function
     * commit transaction
     * @param stocktrade: Stocktrade Entity Object
     * @throws eve.general.exception.CustomException
     */
    public void securedeleteStocktrade(IStocktrade stocktrade) throws DBException {
        trans_deleteStocktrade(stocktrade);
        super.Commit2DB();
    }

    /**
     * try to insert Stocktrade object in database
     * do not commit transaction
     * @param stocktrade: Stocktrade Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void trans_insertStocktrade(IStocktrade stocktrade) throws DBException, DataException {
        super.checkDATA(stocktrade);
        super.insertStocktrade((Stocktrade)stocktrade);
    }
    
    /**
     * try to update Stocktrade object in database
     * do not commit transaction
     * @param stocktrade: Stocktrade Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void trans_updateStocktrade(IStocktrade stocktrade) throws DBException, DataException {
        super.checkDATA(stocktrade);
        super.updateStocktrade((Stocktrade)stocktrade);
    }
    
    /**
     * try to delete Stocktrade object in database
     * do not commit transaction
     * @param stocktrade: Stocktrade Entity Object
     * @throws eve.general.exception.CustomException
     */
    public void trans_deleteStocktrade(IStocktrade stocktrade) throws DBException {
        super.deleteStocktrade((Stocktrade)stocktrade);
    }
}
