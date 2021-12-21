/*
 * BLwishlist.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 16.11.2021 15:46
 *
 */

package eve.BusinessObject.Logic;

import BusinessObject.BLtable;
import general.exception.DBException;
import eve.interfaces.logicentity.IWishlist;
import eve.logicentity.Wishlist;
import eve.BusinessObject.table.Bwishlist;
import eve.interfaces.logicentity.IStock;
import general.exception.DataException;

/**
 * Business Logic Entity class BLwishlist
 *
 * Class for manipulating data- and database objects
 * for Entity Wishlist and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLwishlist extends Bwishlist {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    /**
     * Constructor, sets Wishlist as default Entity
     */
    public BLwishlist() {
        this.setLogginrequired(isprivatetable);
    }

    /**
     * Constructor, sets Wishlist as default Entity
     * sets transaction queue from given GeneralObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralObjects that holds the transaction queue
     */
    public BLwishlist(BLtable transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }

    /**
     * Check if wishlist is already there
     * if not, insert new wishlist
     * if so, add volume to existing wishlist
     * @param wishlist: wishlist with maxprice to add
     * @throws DBException
     * @throws DataException 
     */
    public void addWishlist(IWishlist newwishlist) throws DBException, DataException {
        Wishlist wishlist = getWishlist(newwishlist.getPrimaryKey());
        if(wishlist==null) {
            this.trans_insertWishlist(newwishlist);
        } else {
            this.trans_updateWishlist(newwishlist);
        }
        Commit2DB();
    }
    
    /**
     * try to insert Wishlist object in database
     * commit transaction
     * @param wishlist: Wishlist Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void insertWishlist(IWishlist wishlist) throws DBException, DataException {
        trans_insertWishlist(wishlist);
        super.Commit2DB();
    }
    
    /**
     * try to insert Wishlist object in database
     * an alternative to insertWishlist, which can be made an empty function
     * commit transaction
     * @param wishlist: Wishlist Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureinsertWishlist(IWishlist wishlist) throws DBException, DataException {
        trans_insertWishlist(wishlist);
        super.Commit2DB();
    }
    
    /**
     * try to update Wishlist object in database
     * commit transaction
     * @param wishlist: Wishlist Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void updateWishlist(IWishlist wishlist) throws DBException, DataException {
        trans_updateWishlist(wishlist);
        super.Commit2DB();
    }
    
    /**
     * try to update Wishlist object in database
     * an alternative to updateWishlist, which can be made an empty function
     * commit transaction
     * @param wishlist: Wishlist Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureupdateWishlist(IWishlist wishlist) throws DBException, DataException {
        trans_updateWishlist(wishlist);
        super.Commit2DB();
    }
    
    /**
     * try to delete Wishlist object in database
     * commit transaction
     * @param wishlist: Wishlist Entity Object
     * @throws general.exception.DBException
     */
    @Override
    public void deleteWishlist(IWishlist wishlist) throws DBException {
        trans_deleteWishlist(wishlist);
        super.Commit2DB();
    }

    /**
     * try to delete Wishlist object in database
     * an alternative to deleteWishlist, which can be made an empty function
     * commit transaction
     * @param wishlist: Wishlist Entity Object
     * @throws general.exception.DBException
     */
    public void securedeleteWishlist(IWishlist wishlist) throws DBException {
        trans_deleteWishlist(wishlist);
        super.Commit2DB();
    }

    /**
     * try to insert Wishlist object in database
     * do not commit transaction
     * @param wishlist: Wishlist Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_insertWishlist(IWishlist wishlist) throws DBException, DataException {
        super.checkDATA(wishlist);
        super.insertWishlist((Wishlist)wishlist);
    }
    
    /**
     * try to update Wishlist object in database
     * do not commit transaction
     * @param wishlist: Wishlist Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_updateWishlist(IWishlist wishlist) throws DBException, DataException {
        super.checkDATA(wishlist);
        super.updateWishlist((Wishlist)wishlist);
    }
    
    /**
     * try to delete Wishlist object in database
     * do not commit transaction
     * @param wishlist: Wishlist Entity Object
     * @throws general.exception.DBException
     */
    public void trans_deleteWishlist(IWishlist wishlist) throws DBException {
        super.deleteWishlist((Wishlist)wishlist);
    }
}
