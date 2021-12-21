/*
 * BLsyssettings.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 11.11.2021 13:40
 *
 */

package eve.BusinessObject.Logic;

import BusinessObject.BLtable;
import general.exception.DBException;
import eve.interfaces.logicentity.ISyssettings;
import eve.logicentity.Syssettings;
import eve.BusinessObject.table.Bsyssettings;
import eve.entity.pk.SyssettingsPK;
import general.exception.DataException;

/**
 * Business Logic Entity class BLsyssettings
 *
 * Class for manipulating data- and database objects
 * for Entity Syssettings and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLsyssettings extends Bsyssettings {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    /**
     * Constructor, sets Syssettings as default Entity
     */
    public BLsyssettings() {
        this.setLogginrequired(isprivatetable);
    }

    /**
     * Constructor, sets Syssettings as default Entity
     * sets transaction queue from given GeneralObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralObjects that holds the transaction queue
     */
    public BLsyssettings(BLtable transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }

    /**
     * get system settings constant value
     * @param syssettingsconstant syssettings primary key value
     * @return syssettings
     * @throws DBException
     * @throws DataException 
     */
    public Syssettings getSyssettings(String syssettingsconstant) throws DBException, DataException {
        return this.getSyssettings(new SyssettingsPK(syssettingsconstant));
    }
    
    /**
     * try to insert Syssettings object in database
     * commit transaction
     * @param syssettings: Syssettings Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void insertSyssettings(ISyssettings syssettings) throws DBException, DataException {
        trans_insertSyssettings(syssettings);
        super.Commit2DB();
    }
    
    /**
     * try to insert Syssettings object in database
     * an alternative to insertSyssettings, which can be made an empty function
     * commit transaction
     * @param syssettings: Syssettings Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureinsertSyssettings(ISyssettings syssettings) throws DBException, DataException {
        trans_insertSyssettings(syssettings);
        super.Commit2DB();
    }
    
    /**
     * try to update Syssettings object in database
     * commit transaction
     * @param syssettings: Syssettings Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void updateSyssettings(ISyssettings syssettings) throws DBException, DataException {
        trans_updateSyssettings(syssettings);
        super.Commit2DB();
    }
    
    /**
     * try to update Syssettings object in database
     * an alternative to updateSyssettings, which can be made an empty function
     * commit transaction
     * @param syssettings: Syssettings Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureupdateSyssettings(ISyssettings syssettings) throws DBException, DataException {
        trans_updateSyssettings(syssettings);
        super.Commit2DB();
    }
    
    /**
     * try to delete Syssettings object in database
     * commit transaction
     * @param syssettings: Syssettings Entity Object
     * @throws general.exception.DBException
     */
    @Override
    public void deleteSyssettings(ISyssettings syssettings) throws DBException {
        trans_deleteSyssettings(syssettings);
        super.Commit2DB();
    }

    /**
     * try to delete Syssettings object in database
     * an alternative to deleteSyssettings, which can be made an empty function
     * commit transaction
     * @param syssettings: Syssettings Entity Object
     * @throws general.exception.DBException
     */
    public void securedeleteSyssettings(ISyssettings syssettings) throws DBException {
        trans_deleteSyssettings(syssettings);
        super.Commit2DB();
    }

    /**
     * try to insert Syssettings object in database
     * do not commit transaction
     * @param syssettings: Syssettings Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_insertSyssettings(ISyssettings syssettings) throws DBException, DataException {
        super.checkDATA(syssettings);
        super.insertSyssettings((Syssettings)syssettings);
    }
    
    /**
     * try to update Syssettings object in database
     * do not commit transaction
     * @param syssettings: Syssettings Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_updateSyssettings(ISyssettings syssettings) throws DBException, DataException {
        super.checkDATA(syssettings);
        super.updateSyssettings((Syssettings)syssettings);
    }
    
    /**
     * try to delete Syssettings object in database
     * do not commit transaction
     * @param syssettings: Syssettings Entity Object
     * @throws general.exception.DBException
     */
    public void trans_deleteSyssettings(ISyssettings syssettings) throws DBException {
        super.deleteSyssettings((Syssettings)syssettings);
    }
}
