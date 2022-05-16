/*
 * BLsystemactivity.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 5.3.2022 17:21
 *
 */

package eve.BusinessObject.Logic;

import BusinessObject.BLtable;
import general.exception.DBException;
import general.exception.DataException;
import data.interfaces.db.LogicEntity;
import eve.interfaces.logicentity.ISystemactivity;
import eve.logicentity.Systemactivity;
import eve.BusinessObject.table.Bsystemactivity;
import general.exception.DataException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Business Logic Entity class BLsystemactivity
 *
 * Class for manipulating data- and database objects
 * for Entity Systemactivity and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLsystemactivity extends Bsystemactivity {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    /**
     * Constructor, sets Systemactivity as default Entity
     */
    public BLsystemactivity() {
        this.setLogginrequired(isprivatetable);
    }

    /**
     * Constructor, sets Systemactivity as default Entity
     * sets transaction queue from given GeneralObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralObjects that holds the transaction queue
     */
    public BLsystemactivity(BLtable transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }

    /**
     * try to insert Systemactivity object in database
     * commit transaction
     * @param systemactivity: Systemactivity Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void insertSystemactivity(ISystemactivity systemactivity) throws DBException, DataException {
        trans_insertSystemactivity(systemactivity);
        super.Commit2DB();
    }
    
    /**
     * try to insert Systemactivity object in database
     * an alternative to insertSystemactivity, which can be made an empty function
     * commit transaction
     * @param systemactivity: Systemactivity Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureinsertSystemactivity(ISystemactivity systemactivity) throws DBException, DataException {
        trans_insertSystemactivity(systemactivity);
        super.Commit2DB();
    }
    
    /**
     * try to update Systemactivity object in database
     * commit transaction
     * @param systemactivity: Systemactivity Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void updateSystemactivity(ISystemactivity systemactivity) throws DBException, DataException {
        trans_updateSystemactivity(systemactivity);
        super.Commit2DB();
    }
    
    /**
     * try to update Systemactivity object in database
     * an alternative to updateSystemactivity, which can be made an empty function
     * commit transaction
     * @param systemactivity: Systemactivity Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureupdateSystemactivity(ISystemactivity systemactivity) throws DBException, DataException {
        trans_updateSystemactivity(systemactivity);
        super.Commit2DB();
    }
    
    /**
     * try to delete Systemactivity object in database
     * commit transaction
     * @param systemactivity: Systemactivity Entity Object
     * @throws general.exception.DBException
     */
    @Override
    public void deleteSystemactivity(ISystemactivity systemactivity) throws DBException {
        trans_deleteSystemactivity(systemactivity);
        super.Commit2DB();
    }

    /**
     * try to delete Systemactivity object in database
     * an alternative to deleteSystemactivity, which can be made an empty function
     * commit transaction
     * @param systemactivity: Systemactivity Entity Object
     * @throws general.exception.DBException
     */
    public void securedeleteSystemactivity(ISystemactivity systemactivity) throws DBException {
        trans_deleteSystemactivity(systemactivity);
        super.Commit2DB();
    }

    /**
     * try to insert Systemactivity object in database
     * do not commit transaction
     * @param systemactivity: Systemactivity Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_insertSystemactivity(ISystemactivity systemactivity) throws DBException, DataException {
        super.checkDATA(systemactivity);
        super.insertSystemactivity((Systemactivity)systemactivity);
    }
    
    /**
     * try to update Systemactivity object in database
     * do not commit transaction
     * @param systemactivity: Systemactivity Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_updateSystemactivity(ISystemactivity systemactivity) throws DBException, DataException {
        super.checkDATA(systemactivity);
        super.updateSystemactivity((Systemactivity)systemactivity);
    }
    
    /**
     * try to delete Systemactivity object in database
     * do not commit transaction
     * @param systemactivity: Systemactivity Entity Object
     * @throws general.exception.DBException
     */
    public void trans_deleteSystemactivity(ISystemactivity systemactivity) throws DBException {
        super.deleteSystemactivity((Systemactivity)systemactivity);
    }
}
