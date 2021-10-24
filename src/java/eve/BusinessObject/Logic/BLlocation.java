/*
 * BLlocation.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 3.5.2021 16:27
 *
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import eve.interfaces.logicentity.ILocation;
import eve.logicentity.Location;
import BusinessObject.BLtable;
import eve.BusinessObject.table.Blocation;
import general.exception.DataException;

/**
 * Business Logic Entity class BLlocation
 *
 * Class for manipulating data- and database objects
 * for Entity Location and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLlocation extends Blocation {
//ProjectGenerator: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    /**
     * Constructor, sets Location as default Entity
     */
    public BLlocation() {
        this.setLogginrequired(isprivatetable);
    }

    /**
     * Constructor, sets Location as default Entity
     * sets transaction queue from given GeneralObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralObjects that holds the transaction queue
     */
    public BLlocation(BLtable transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }

    /**
     * try to insert Location object in database
     * commit transaction
     * @param location: Location Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    @Override
    public void insertLocation(ILocation location) throws DBException, DataException {
        trans_insertLocation(location);
        super.Commit2DB();
    }
    
    /**
     * try to insert Location object in database
     * an alternative to insertLocation, which can be made an empty function
     * commit transaction
     * @param location: Location Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void secureinsertLocation(ILocation location) throws DBException, DataException {
        trans_insertLocation(location);
        super.Commit2DB();
    }
    
    /**
     * try to update Location object in database
     * commit transaction
     * @param location: Location Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    @Override
    public void updateLocation(ILocation location) throws DBException, DataException {
        trans_updateLocation(location);
        super.Commit2DB();
    }
    
    /**
     * try to update Location object in database
     * an alternative to updateLocation, which can be made an empty function
     * commit transaction
     * @param location: Location Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void secureupdateLocation(ILocation location) throws DBException, DataException {
        trans_updateLocation(location);
        super.Commit2DB();
    }
    
    /**
     * try to delete Location object in database
     * commit transaction
     * @param location: Location Entity Object
     * @throws eve.general.exception.CustomException
     */
    @Override
    public void deleteLocation(ILocation location) throws DBException {
        trans_deleteLocation(location);
        super.Commit2DB();
    }

    /**
     * try to delete Location object in database
     * an alternative to deleteLocation, which can be made an empty function
     * commit transaction
     * @param location: Location Entity Object
     * @throws eve.general.exception.CustomException
     */
    public void securedeleteLocation(ILocation location) throws DBException {
        trans_deleteLocation(location);
        super.Commit2DB();
    }

    /**
     * try to insert Location object in database
     * do not commit transaction
     * @param location: Location Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void trans_insertLocation(ILocation location) throws DBException, DataException {
        super.checkDATA(location);
        super.insertLocation((Location)location);
    }
    
    /**
     * try to update Location object in database
     * do not commit transaction
     * @param location: Location Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void trans_updateLocation(ILocation location) throws DBException, DataException {
        super.checkDATA(location);
        super.updateLocation((Location)location);
    }
    
    /**
     * try to delete Location object in database
     * do not commit transaction
     * @param location: Location Entity Object
     * @throws eve.general.exception.CustomException
     */
    public void trans_deleteLocation(ILocation location) throws DBException {
        super.deleteLocation((Location)location);
    }
}
