/*
 * BLsystemtrade_order.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 29.5.2021 18:39
 *
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import data.interfaces.db.LogicEntity;
import eve.interfaces.logicentity.ISystemtrade_order;
import eve.logicentity.Systemtrade_order;
import BusinessObject.GeneralEntityObject;
import eve.BusinessObject.table.Bsystemtrade_order;
import general.exception.DataException;
import eve.interfaces.BusinessObject.IBLsystemtrade_order;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Business Logic Entity class BLsystemtrade_order
 *
 * Class for manipulating data- and database objects
 * for Entity Systemtrade_order and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLsystemtrade_order extends Bsystemtrade_order implements IBLsystemtrade_order {
//ProjectGenerator: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    /**
     * Constructor, sets Systemtrade_order as default Entity
     */
    public BLsystemtrade_order() {
        this.setLogginrequired(isprivatetable);
    }

    /**
     * Constructor, sets Systemtrade_order as default Entity
     * sets transaction queue from given GeneralObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralObjects that holds the transaction queue
     */
    public BLsystemtrade_order(GeneralEntityObject transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }

    /**
     * delete all tradeorder lines
     * @throws DBException
     * @throws DataException 
     */
    public void deletesystemtrade_order() throws DBException, DataException {
        this.transactionqueue.addStatement(this.getClass().getSimpleName(), Systemtrade_order.SQLdeleteall, null);
        this.Commit2DB();
    }
    
    /**
     * load extra fields from adjusted sql statement
     */
    @Override
    public void loadExtra(ResultSet dbresult, LogicEntity systemtrade_order) throws SQLException {
        
    }
    
    /**
     * try to insert Systemtrade_order object in database
     * commit transaction
     * @param systemtrade_order: Systemtrade_order Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    @Override
    public void insertSystemtrade_order(ISystemtrade_order systemtrade_order) throws DBException, DataException {
        trans_insertSystemtrade_order(systemtrade_order);
        super.Commit2DB();
    }
    
    /**
     * try to insert Systemtrade_order object in database
     * an alternative to insertSystemtrade_order, which can be made an empty function
     * commit transaction
     * @param systemtrade_order: Systemtrade_order Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void secureinsertSystemtrade_order(ISystemtrade_order systemtrade_order) throws DBException, DataException {
        trans_insertSystemtrade_order(systemtrade_order);
        super.Commit2DB();
    }
    
    /**
     * try to update Systemtrade_order object in database
     * commit transaction
     * @param systemtrade_order: Systemtrade_order Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    @Override
    public void updateSystemtrade_order(ISystemtrade_order systemtrade_order) throws DBException, DataException {
        trans_updateSystemtrade_order(systemtrade_order);
        super.Commit2DB();
    }
    
    /**
     * try to update Systemtrade_order object in database
     * an alternative to updateSystemtrade_order, which can be made an empty function
     * commit transaction
     * @param systemtrade_order: Systemtrade_order Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void secureupdateSystemtrade_order(ISystemtrade_order systemtrade_order) throws DBException, DataException {
        trans_updateSystemtrade_order(systemtrade_order);
        super.Commit2DB();
    }
    
    /**
     * try to delete Systemtrade_order object in database
     * commit transaction
     * @param systemtrade_order: Systemtrade_order Entity Object
     * @throws eve.general.exception.CustomException
     */
    @Override
    public void deleteSystemtrade_order(ISystemtrade_order systemtrade_order) throws DBException {
        trans_deleteSystemtrade_order(systemtrade_order);
        super.Commit2DB();
    }

    /**
     * try to delete Systemtrade_order object in database
     * an alternative to deleteSystemtrade_order, which can be made an empty function
     * commit transaction
     * @param systemtrade_order: Systemtrade_order Entity Object
     * @throws eve.general.exception.CustomException
     */
    public void securedeleteSystemtrade_order(ISystemtrade_order systemtrade_order) throws DBException {
        trans_deleteSystemtrade_order(systemtrade_order);
        super.Commit2DB();
    }

    /**
     * try to insert Systemtrade_order object in database
     * do not commit transaction
     * @param systemtrade_order: Systemtrade_order Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void trans_insertSystemtrade_order(ISystemtrade_order systemtrade_order) throws DBException, DataException {
        super.checkDATA(systemtrade_order);
        super.insertSystemtrade_order((Systemtrade_order)systemtrade_order);
    }
    
    /**
     * try to update Systemtrade_order object in database
     * do not commit transaction
     * @param systemtrade_order: Systemtrade_order Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void trans_updateSystemtrade_order(ISystemtrade_order systemtrade_order) throws DBException, DataException {
        super.checkDATA(systemtrade_order);
        super.updateSystemtrade_order((Systemtrade_order)systemtrade_order);
    }
    
    /**
     * try to delete Systemtrade_order object in database
     * do not commit transaction
     * @param systemtrade_order: Systemtrade_order Entity Object
     * @throws eve.general.exception.CustomException
     */
    public void trans_deleteSystemtrade_order(ISystemtrade_order systemtrade_order) throws DBException {
        super.deleteSystemtrade_order((Systemtrade_order)systemtrade_order);
    }
}
