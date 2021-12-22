/*
 * BLshipfitorder.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 19.11.2021 16:16
 *
 */

package eve.BusinessObject.Logic;

import BusinessObject.BLtable;
import general.exception.DBException;
import eve.interfaces.logicentity.IShipfitorder;
import eve.logicentity.Shipfitorder;
import eve.BusinessObject.table.Bshipfitorder;
import eve.interfaces.entity.pk.IShipfitorderPK;
import general.exception.DataException;

/**
 * Business Logic Entity class BLshipfitorder
 *
 * Class for manipulating data- and database objects
 * for Entity Shipfitorder and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLshipfitorder extends Bshipfitorder {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    /**
     * Constructor, sets Shipfitorder as default Entity
     */
    public BLshipfitorder() {
        this.setLogginrequired(isprivatetable);
    }

    /**
     * Constructor, sets Shipfitorder as default Entity
     * sets transaction queue from given GeneralObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralObjects that holds the transaction queue
     */
    public BLshipfitorder(BLtable transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }

    public void updateAmount(IShipfitorderPK shipfitorderPK, int amount) throws DBException, DataException {
        Shipfitorder shipfitorder = this.getShipfitorder(shipfitorderPK);
        shipfitorder.incAmountinstock(amount);
        trans_updateShipfitorder(shipfitorder);
    }
    
    /**
     * try to insert Shipfitorder object in database
     * commit transaction
     * @param shipfitorder: Shipfitorder Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void insertShipfitorder(IShipfitorder shipfitorder) throws DBException, DataException {
        trans_insertShipfitorder(shipfitorder);
        super.Commit2DB();
    }
    
    /**
     * try to insert Shipfitorder object in database
     * an alternative to insertShipfitorder, which can be made an empty function
     * commit transaction
     * @param shipfitorder: Shipfitorder Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureinsertShipfitorder(IShipfitorder shipfitorder) throws DBException, DataException {
        trans_insertShipfitorder(shipfitorder);
        super.Commit2DB();
    }
    
    /**
     * try to update Shipfitorder object in database
     * commit transaction
     * @param shipfitorder: Shipfitorder Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void updateShipfitorder(IShipfitorder shipfitorder) throws DBException, DataException {
        trans_updateShipfitorder(shipfitorder);
        super.Commit2DB();
    }
    
    /**
     * try to update Shipfitorder object in database
     * an alternative to updateShipfitorder, which can be made an empty function
     * commit transaction
     * @param shipfitorder: Shipfitorder Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureupdateShipfitorder(IShipfitorder shipfitorder) throws DBException, DataException {
        trans_updateShipfitorder(shipfitorder);
        super.Commit2DB();
    }
    
    /**
     * try to delete Shipfitorder object in database
     * commit transaction
     * @param shipfitorder: Shipfitorder Entity Object
     * @throws general.exception.DBException
     */
    @Override
    public void deleteShipfitorder(IShipfitorder shipfitorder) throws DBException {
        trans_deleteShipfitorder(shipfitorder);
        super.Commit2DB();
    }

    /**
     * try to delete Shipfitorder object in database
     * an alternative to deleteShipfitorder, which can be made an empty function
     * commit transaction
     * @param shipfitorder: Shipfitorder Entity Object
     * @throws general.exception.DBException
     */
    public void securedeleteShipfitorder(IShipfitorder shipfitorder) throws DBException {
        trans_deleteShipfitorder(shipfitorder);
        super.Commit2DB();
    }

    /**
     * try to insert Shipfitorder object in database
     * do not commit transaction
     * @param shipfitorder: Shipfitorder Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_insertShipfitorder(IShipfitorder shipfitorder) throws DBException, DataException {
        super.checkDATA(shipfitorder);
        super.insertShipfitorder((Shipfitorder)shipfitorder);
    }
    
    /**
     * try to update Shipfitorder object in database
     * do not commit transaction
     * @param shipfitorder: Shipfitorder Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_updateShipfitorder(IShipfitorder shipfitorder) throws DBException, DataException {
        super.checkDATA(shipfitorder);
        super.updateShipfitorder((Shipfitorder)shipfitorder);
    }
    
    /**
     * try to delete Shipfitorder object in database
     * do not commit transaction
     * @param shipfitorder: Shipfitorder Entity Object
     * @throws general.exception.DBException
     */
    public void trans_deleteShipfitorder(IShipfitorder shipfitorder) throws DBException {
        super.deleteShipfitorder((Shipfitorder)shipfitorder);
    }
}
