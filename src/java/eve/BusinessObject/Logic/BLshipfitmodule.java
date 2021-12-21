/*
 * BLshipfitmodule.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 17.11.2021 15:31
 *
 */

package eve.BusinessObject.Logic;

import BusinessObject.BLtable;
import general.exception.DBException;
import general.exception.DataException;
import data.interfaces.db.LogicEntity;
import eve.interfaces.logicentity.IShipfitmodule;
import eve.logicentity.Shipfitmodule;
import eve.BusinessObject.table.Bshipfitmodule;
import general.exception.DataException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Business Logic Entity class BLshipfitmodule
 *
 * Class for manipulating data- and database objects
 * for Entity Shipfitmodule and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLshipfitmodule extends Bshipfitmodule {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    /**
     * Constructor, sets Shipfitmodule as default Entity
     */
    public BLshipfitmodule() {
        this.setLogginrequired(isprivatetable);
    }

    /**
     * Constructor, sets Shipfitmodule as default Entity
     * sets transaction queue from given GeneralObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralObjects that holds the transaction queue
     */
    public BLshipfitmodule(BLtable transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }

    /**
     * try to insert Shipfitmodule object in database
     * commit transaction
     * @param shipfitmodule: Shipfitmodule Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void insertShipfitmodule(IShipfitmodule shipfitmodule) throws DBException, DataException {
        trans_insertShipfitmodule(shipfitmodule);
        super.Commit2DB();
    }
    
    /**
     * try to insert Shipfitmodule object in database
     * an alternative to insertShipfitmodule, which can be made an empty function
     * commit transaction
     * @param shipfitmodule: Shipfitmodule Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureinsertShipfitmodule(IShipfitmodule shipfitmodule) throws DBException, DataException {
        trans_insertShipfitmodule(shipfitmodule);
        super.Commit2DB();
    }
    
    /**
     * try to update Shipfitmodule object in database
     * commit transaction
     * @param shipfitmodule: Shipfitmodule Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void updateShipfitmodule(IShipfitmodule shipfitmodule) throws DBException, DataException {
        trans_updateShipfitmodule(shipfitmodule);
        super.Commit2DB();
    }
    
    /**
     * try to update Shipfitmodule object in database
     * an alternative to updateShipfitmodule, which can be made an empty function
     * commit transaction
     * @param shipfitmodule: Shipfitmodule Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureupdateShipfitmodule(IShipfitmodule shipfitmodule) throws DBException, DataException {
        trans_updateShipfitmodule(shipfitmodule);
        super.Commit2DB();
    }
    
    /**
     * try to delete Shipfitmodule object in database
     * commit transaction
     * @param shipfitmodule: Shipfitmodule Entity Object
     * @throws general.exception.DBException
     */
    @Override
    public void deleteShipfitmodule(IShipfitmodule shipfitmodule) throws DBException {
        trans_deleteShipfitmodule(shipfitmodule);
        super.Commit2DB();
    }

    /**
     * try to delete Shipfitmodule object in database
     * an alternative to deleteShipfitmodule, which can be made an empty function
     * commit transaction
     * @param shipfitmodule: Shipfitmodule Entity Object
     * @throws general.exception.DBException
     */
    public void securedeleteShipfitmodule(IShipfitmodule shipfitmodule) throws DBException {
        trans_deleteShipfitmodule(shipfitmodule);
        super.Commit2DB();
    }

    /**
     * try to insert Shipfitmodule object in database
     * do not commit transaction
     * @param shipfitmodule: Shipfitmodule Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_insertShipfitmodule(IShipfitmodule shipfitmodule) throws DBException, DataException {
        super.checkDATA(shipfitmodule);
        super.insertShipfitmodule((Shipfitmodule)shipfitmodule);
    }
    
    /**
     * try to update Shipfitmodule object in database
     * do not commit transaction
     * @param shipfitmodule: Shipfitmodule Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_updateShipfitmodule(IShipfitmodule shipfitmodule) throws DBException, DataException {
        super.checkDATA(shipfitmodule);
        super.updateShipfitmodule((Shipfitmodule)shipfitmodule);
    }
    
    /**
     * try to delete Shipfitmodule object in database
     * do not commit transaction
     * @param shipfitmodule: Shipfitmodule Entity Object
     * @throws general.exception.DBException
     */
    public void trans_deleteShipfitmodule(IShipfitmodule shipfitmodule) throws DBException {
        super.deleteShipfitmodule((Shipfitmodule)shipfitmodule);
    }
}
