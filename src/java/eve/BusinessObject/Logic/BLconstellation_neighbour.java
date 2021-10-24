/*
 * BLconstellation_neighbour.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 24.4.2021 15:45
 *
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import eve.interfaces.logicentity.IConstellation_neighbour;
import eve.logicentity.Constellation_neighbour;
import BusinessObject.BLtable;
import eve.BusinessObject.table.Bconstellation_neighbour;
import eve.conversion.entity.EMconstellation_neighbour;
import general.exception.DataException;

/**
 * Business Logic Entity class BLconstellation_neighbour
 *
 * Class for manipulating data- and database objects
 * for Entity Constellation_neighbour and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLconstellation_neighbour extends Bconstellation_neighbour {
//ProjectGenerator: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    /**
     * Constructor, sets Constellation_neighbour as default Entity
     */
    public BLconstellation_neighbour() {
        this.setLogginrequired(isprivatetable);
    }

    /**
     * Constructor, sets Constellation_neighbour as default Entity
     * sets transaction queue from given GeneralObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralObjects that holds the transaction queue
     */
    public BLconstellation_neighbour(BLtable transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }

    /**
     * Delete constellation_neighbour table
     * Add lines based on stargate data
     * @throws DBException
     * @throws DataException 
     */
    public void createneighbours() throws DBException, DataException {
        this.addStatement(EMconstellation_neighbour.SQLDeleteAll);
        this.addStatement(EMconstellation_neighbour.SQLcreateneighours);
        this.Commit2DB();
    }

    /**
     * try to insert Constellation_neighbour object in database
     * commit transaction
     * @param constellation_neighbour: Constellation_neighbour Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void insertConstellation_neighbour(IConstellation_neighbour constellation_neighbour) throws DBException, DataException {
        trans_insertConstellation_neighbour(constellation_neighbour);
        super.Commit2DB();
    }
    
    /**
     * try to insert Constellation_neighbour object in database
     * an alternative to insertConstellation_neighbour, which can be made an empty function
     * commit transaction
     * @param constellation_neighbour: Constellation_neighbour Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureinsertConstellation_neighbour(IConstellation_neighbour constellation_neighbour) throws DBException, DataException {
        trans_insertConstellation_neighbour(constellation_neighbour);
        super.Commit2DB();
    }
    
    /**
     * try to update Constellation_neighbour object in database
     * commit transaction
     * @param constellation_neighbour: Constellation_neighbour Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void updateConstellation_neighbour(IConstellation_neighbour constellation_neighbour) throws DBException, DataException {
        trans_updateConstellation_neighbour(constellation_neighbour);
        super.Commit2DB();
    }
    
    /**
     * try to update Constellation_neighbour object in database
     * an alternative to updateConstellation_neighbour, which can be made an empty function
     * commit transaction
     * @param constellation_neighbour: Constellation_neighbour Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureupdateConstellation_neighbour(IConstellation_neighbour constellation_neighbour) throws DBException, DataException {
        trans_updateConstellation_neighbour(constellation_neighbour);
        super.Commit2DB();
    }
    
    /**
     * try to delete Constellation_neighbour object in database
     * commit transaction
     * @param constellation_neighbour: Constellation_neighbour Entity Object
     * @throws general.exception.DBException
     */
    @Override
    public void deleteConstellation_neighbour(IConstellation_neighbour constellation_neighbour) throws DBException {
        trans_deleteConstellation_neighbour(constellation_neighbour);
        super.Commit2DB();
    }

    /**
     * try to delete Constellation_neighbour object in database
     * an alternative to deleteConstellation_neighbour, which can be made an empty function
     * commit transaction
     * @param constellation_neighbour: Constellation_neighbour Entity Object
     * @throws general.exception.DBException
     */
    public void securedeleteConstellation_neighbour(IConstellation_neighbour constellation_neighbour) throws DBException {
        trans_deleteConstellation_neighbour(constellation_neighbour);
        super.Commit2DB();
    }

    /**
     * try to insert Constellation_neighbour object in database
     * do not commit transaction
     * @param constellation_neighbour: Constellation_neighbour Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_insertConstellation_neighbour(IConstellation_neighbour constellation_neighbour) throws DBException, DataException {
        super.checkDATA(constellation_neighbour);
        super.insertConstellation_neighbour((Constellation_neighbour)constellation_neighbour);
    }
    
    /**
     * try to update Constellation_neighbour object in database
     * do not commit transaction
     * @param constellation_neighbour: Constellation_neighbour Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_updateConstellation_neighbour(IConstellation_neighbour constellation_neighbour) throws DBException, DataException {
        super.checkDATA(constellation_neighbour);
        super.updateConstellation_neighbour((Constellation_neighbour)constellation_neighbour);
    }
    
    /**
     * try to delete Constellation_neighbour object in database
     * do not commit transaction
     * @param constellation_neighbour: Constellation_neighbour Entity Object
     * @throws general.exception.DBException
     */
    public void trans_deleteConstellation_neighbour(IConstellation_neighbour constellation_neighbour) throws DBException {
        super.deleteConstellation_neighbour((Constellation_neighbour)constellation_neighbour);
    }
}
