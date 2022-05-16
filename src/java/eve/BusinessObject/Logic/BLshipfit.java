/*
 * BLshipfit.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 17.11.2021 15:28
 *
 */

package eve.BusinessObject.Logic;

import BusinessObject.BLtable;
import general.exception.DBException;
import eve.interfaces.logicentity.IShipfit;
import eve.logicentity.Shipfit;
import eve.BusinessObject.table.Bshipfit;
import eve.entity.pk.ShipfitorderPK;
import eve.interfaces.entity.pk.IShipfitPK;
import eve.logicentity.Shipfitmodule;
import eve.logicentity.Shipfitorder;
import general.exception.CustomException;
import general.exception.DataException;
import java.util.ArrayList;

/**
 * Business Logic Entity class BLshipfit
 *
 * Class for manipulating data- and database objects
 * for Entity Shipfit and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLshipfit extends Bshipfit {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = true; //set this to true if only a loggin account has access to this data
	
    /**
     * Constructor, sets Shipfit as default Entity
     */
    public BLshipfit() {
        this.setLogginrequired(isprivatetable);
    }

    /**
     * Constructor, sets Shipfit as default Entity
     * sets transaction queue from given GeneralObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralObjects that holds the transaction queue
     */
    public BLshipfit(BLtable transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }

    public void order_ship_and_all_modules(IShipfitPK shipfitPK) throws CustomException {
        BLshipfitmodule blshipfitmodule = new BLshipfitmodule();
        blshipfitmodule.setAuthenticated(this.isAuthenticated());
        BLshipfitorder blshipfitorder = new BLshipfitorder();
        blshipfitorder.setAuthenticated(this.isAuthenticated());
        Shipfitorder shipfitorder;
        
        //order ship
        Shipfit shipfit = this.getShipfit(shipfitPK);
        ShipfitorderPK shipfitorderPK = new ShipfitorderPK();
        shipfitorderPK.setShipfitPK(shipfitPK);
        shipfitorderPK.setEvetypePK(shipfit.getEvetypePK());
        shipfitorder = blshipfitorder.getShipfitorder(shipfitorderPK);
        if(shipfitorder==null) {
            shipfitorder = new Shipfitorder(shipfitorderPK);
            shipfitorder.setAmountinstock(0);
            shipfitorder.setAmountwanted(1);
            blshipfitorder.trans_insertShipfitorder(shipfitorder);
        } else {
            shipfitorder.incAmountwanted(1);
            blshipfitorder.trans_updateShipfitorder(shipfitorder);
        }
        
        //order modules
        ArrayList<Shipfitmodule> modules = blshipfitmodule.getShipfitmodules4shipfit(shipfitPK);
        for(Shipfitmodule module: modules) {
            shipfitorderPK = new ShipfitorderPK();
            shipfitorderPK.setShipfitPK(module.getPrimaryKey().getShipfitPK());
            shipfitorderPK.setEvetypePK(module.getPrimaryKey().getEvetypePK());
            shipfitorder = blshipfitorder.getShipfitorder(shipfitorderPK);
            if(shipfitorder==null) {
                shipfitorder = new Shipfitorder(shipfitorderPK);
                shipfitorder.setAmountinstock(0);
                shipfitorder.setAmountwanted(module.getAmount());
                blshipfitorder.trans_insertShipfitorder(shipfitorder);
            } else {
                shipfitorder.incAmountwanted(module.getAmount());
                blshipfitorder.trans_updateShipfitorder(shipfitorder);
            }
        }
        
        blshipfitorder.Commit2DB();
    }
    
    /**
     * try to insert Shipfit object in database
     * commit transaction
     * @param shipfit: Shipfit Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void insertShipfit(IShipfit shipfit) throws DBException, DataException {
        if(!super.getShipfitExists(shipfit.getPrimaryKey())) {
            trans_insertShipfit(shipfit);
            super.Commit2DB();
        }
    }
    
    /**
     * try to insert Shipfit object in database
     * an alternative to insertShipfit, which can be made an empty function
     * commit transaction
     * @param shipfit: Shipfit Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureinsertShipfit(IShipfit shipfit) throws DBException, DataException {
        trans_insertShipfit(shipfit);
        super.Commit2DB();
    }
    
    /**
     * try to update Shipfit object in database
     * commit transaction
     * @param shipfit: Shipfit Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void updateShipfit(IShipfit shipfit) throws DBException, DataException {
        trans_updateShipfit(shipfit);
        super.Commit2DB();
    }
    
    /**
     * try to update Shipfit object in database
     * an alternative to updateShipfit, which can be made an empty function
     * commit transaction
     * @param shipfit: Shipfit Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureupdateShipfit(IShipfit shipfit) throws DBException, DataException {
        trans_updateShipfit(shipfit);
        super.Commit2DB();
    }
    
    /**
     * try to delete Shipfit object in database
     * commit transaction
     * @param shipfit: Shipfit Entity Object
     * @throws general.exception.DBException
     */
    @Override
    public void deleteShipfit(IShipfit shipfit) throws DBException {
        trans_deleteShipfit(shipfit);
        super.Commit2DB();
    }

    /**
     * try to delete Shipfit object in database
     * an alternative to deleteShipfit, which can be made an empty function
     * commit transaction
     * @param shipfit: Shipfit Entity Object
     * @throws general.exception.DBException
     */
    public void securedeleteShipfit(IShipfit shipfit) throws DBException {
        trans_deleteShipfit(shipfit);
        super.Commit2DB();
    }

    /**
     * try to insert Shipfit object in database
     * do not commit transaction
     * @param shipfit: Shipfit Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_insertShipfit(IShipfit shipfit) throws DBException, DataException {
        super.checkDATA(shipfit);
        super.insertShipfit((Shipfit)shipfit);
    }
    
    /**
     * try to update Shipfit object in database
     * do not commit transaction
     * @param shipfit: Shipfit Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_updateShipfit(IShipfit shipfit) throws DBException, DataException {
        super.checkDATA(shipfit);
        super.updateShipfit((Shipfit)shipfit);
    }
    
    /**
     * try to delete Shipfit object in database
     * do not commit transaction
     * @param shipfit: Shipfit Entity Object
     * @throws general.exception.DBException
     */
    public void trans_deleteShipfit(IShipfit shipfit) throws DBException {
        super.deleteShipfit((Shipfit)shipfit);
    }
}
