/*
 * BLshipfitorderselected.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 20.11.2021 17:22
 *
 */

package eve.BusinessObject.Logic;

import BusinessObject.BLtable;
import general.exception.DBException;
import eve.interfaces.logicentity.IShipfitorderselected;
import eve.logicentity.Shipfitorderselected;
import eve.BusinessObject.table.Bshipfitorderselected;
import eve.entity.pk.ShipfitorderselectedPK;
import eve.interfaces.entity.pk.IOrdersPK;
import eve.interfaces.entity.pk.IShipfitorderPK;
import eve.interfaces.entity.pk.IShipfitorderselectedPK;
import eve.logicentity.Orders;
import eve.logicentity.Shipfitorder;
import general.exception.CustomException;
import general.exception.DataException;
import java.util.ArrayList;

/**
 * Business Logic Entity class BLshipfitorderselected
 *
 * Class for manipulating data- and database objects
 * for Entity Shipfitorderselected and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLshipfitorderselected extends Bshipfitorderselected {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    /**
     * Constructor, sets Shipfitorderselected as default Entity
     */
    public BLshipfitorderselected() {
        this.setLogginrequired(isprivatetable);
    }

    public void addOrderid(IShipfitorderPK shipfitorderPK, IOrdersPK ordersPK) throws CustomException {
        BLorders blorders = new BLorders();
        Orders sellorder = blorders.getOrders(ordersPK);
        long availableamount = sellorder.getVolume_remain();
        
        //get the shipfitorder
        BLshipfitorder blshipfitorder = new BLshipfitorder();
        Shipfitorder shipfitorder = blshipfitorder.getShipfitorder(shipfitorderPK);
        int amountwanted = shipfitorder.getAmountwanted()-shipfitorder.getAmountinstock();
        
        //check if this order is not already used
        ShipfitorderselectedPK shipfitorderselectedPK = new ShipfitorderselectedPK();
        shipfitorderselectedPK.setShipfitorderPK(shipfitorderPK);
        shipfitorderselectedPK.setOrdersPK(ordersPK);
        Shipfitorderselected shipfitorderselected = this.getShipfitorderselected(shipfitorderselectedPK);
        //if already in use for this order, don't add
        if(shipfitorderselected==null) {
            //check if this order is in use for other fits
            ArrayList<Shipfitorderselected> usedorders = this.getShipfitorderselecteds4orders(ordersPK);
            long usedamount = 0;
            for(Shipfitorderselected usedshipfitorderselected: usedorders) {
                usedamount += usedshipfitorderselected.getAmount();
            }
            //count amount of ordered modules of this type for this fit
            ArrayList<Shipfitorderselected> orderedmodules = this.getShipfitorderselecteds4shipfitorder(shipfitorderPK);
            for(Shipfitorderselected usedshipfitorderselected: orderedmodules) {
                amountwanted -= usedshipfitorderselected.getAmount();
            }
            if(availableamount>usedamount) {
                long orderamount = Math.min(availableamount-usedamount, amountwanted);
                if(orderamount>0) {
                    shipfitorderselected = new Shipfitorderselected(shipfitorderselectedPK);
                    shipfitorderselected.setAmount((int)orderamount);
                    insertShipfitorderselected(shipfitorderselected);
                }
            }
        }    
    }
    
    /**
     * update the amount of an order by subtracting what is bought
     * if all is confirmed, delete this line
     * update the shipfitorder for this line, adding to the stock what is bought
     * @param shipfitorderselectedPK
     * @param amount
     * @throws DBException
     * @throws DataException 
     */
    public void confirmOrder(IShipfitorderselectedPK shipfitorderselectedPK, int amount) throws DBException, DataException, CustomException {
        Shipfitorderselected shipfitorderselected = this.getShipfitorderselected(shipfitorderselectedPK);
        int amountleft = Math.max(shipfitorderselected.getAmount()-amount, 0);
        if(amountleft>0) {
            shipfitorderselected.setAmount(Math.max(shipfitorderselected.getAmount()-amount, 0));
            this.trans_updateShipfitorderselected(shipfitorderselected);
        } else {
            this.trans_deleteShipfitorderselected(shipfitorderselected);
        }
        BLshipfitorder blshipfitorder = new BLshipfitorder(this);
        Shipfitorder shipfitorder = blshipfitorder.getShipfitorderselected(shipfitorderselectedPK);
        blshipfitorder.updateAmount(shipfitorderselectedPK.getShipfitorderPK(), amount);
        this.Commit2DB();
    }
    
    /**
     * Constructor, sets Shipfitorderselected as default Entity
     * sets transaction queue from given GeneralObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralObjects that holds the transaction queue
     */
    public BLshipfitorderselected(BLtable transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }

    /**
     * try to insert Shipfitorderselected object in database
     * commit transaction
     * @param shipfitorderselected: Shipfitorderselected Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void insertShipfitorderselected(IShipfitorderselected shipfitorderselected) throws DBException, DataException {
        trans_insertShipfitorderselected(shipfitorderselected);
        super.Commit2DB();
    }
    
    /**
     * try to insert Shipfitorderselected object in database
     * an alternative to insertShipfitorderselected, which can be made an empty function
     * commit transaction
     * @param shipfitorderselected: Shipfitorderselected Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureinsertShipfitorderselected(IShipfitorderselected shipfitorderselected) throws DBException, DataException {
        trans_insertShipfitorderselected(shipfitorderselected);
        super.Commit2DB();
    }
    
    /**
     * try to update Shipfitorderselected object in database
     * commit transaction
     * @param shipfitorderselected: Shipfitorderselected Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void updateShipfitorderselected(IShipfitorderselected shipfitorderselected) throws DBException, DataException {
        trans_updateShipfitorderselected(shipfitorderselected);
        super.Commit2DB();
    }
    
    /**
     * try to update Shipfitorderselected object in database
     * an alternative to updateShipfitorderselected, which can be made an empty function
     * commit transaction
     * @param shipfitorderselected: Shipfitorderselected Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureupdateShipfitorderselected(IShipfitorderselected shipfitorderselected) throws DBException, DataException {
        trans_updateShipfitorderselected(shipfitorderselected);
        super.Commit2DB();
    }
    
    /**
     * try to delete Shipfitorderselected object in database
     * commit transaction
     * @param shipfitorderselected: Shipfitorderselected Entity Object
     * @throws general.exception.DBException
     */
    @Override
    public void deleteShipfitorderselected(IShipfitorderselected shipfitorderselected) throws DBException {
        trans_deleteShipfitorderselected(shipfitorderselected);
        super.Commit2DB();
    }

    /**
     * try to delete Shipfitorderselected object in database
     * an alternative to deleteShipfitorderselected, which can be made an empty function
     * commit transaction
     * @param shipfitorderselected: Shipfitorderselected Entity Object
     * @throws general.exception.DBException
     */
    public void securedeleteShipfitorderselected(IShipfitorderselected shipfitorderselected) throws DBException {
        trans_deleteShipfitorderselected(shipfitorderselected);
        super.Commit2DB();
    }

    /**
     * try to insert Shipfitorderselected object in database
     * do not commit transaction
     * @param shipfitorderselected: Shipfitorderselected Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_insertShipfitorderselected(IShipfitorderselected shipfitorderselected) throws DBException, DataException {
        super.checkDATA(shipfitorderselected);
        super.insertShipfitorderselected((Shipfitorderselected)shipfitorderselected);
    }
    
    /**
     * try to update Shipfitorderselected object in database
     * do not commit transaction
     * @param shipfitorderselected: Shipfitorderselected Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_updateShipfitorderselected(IShipfitorderselected shipfitorderselected) throws DBException, DataException {
        super.checkDATA(shipfitorderselected);
        super.updateShipfitorderselected((Shipfitorderselected)shipfitorderselected);
    }
    
    /**
     * try to delete Shipfitorderselected object in database
     * do not commit transaction
     * @param shipfitorderselected: Shipfitorderselected Entity Object
     * @throws general.exception.DBException
     */
    public void trans_deleteShipfitorderselected(IShipfitorderselected shipfitorderselected) throws DBException {
        super.deleteShipfitorderselected((Shipfitorderselected)shipfitorderselected);
    }
}
