/*
 * BLregion_neighbour.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 24.4.2021 15:45
 *
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import eve.interfaces.logicentity.IRegion_neighbour;
import eve.logicentity.Region_neighbour;
import BusinessObject.BLtable;
import eve.BusinessObject.table.Bregion_neighbour;
import eve.conversion.entity.EMregion_neighbour;
import general.exception.DataException;

/**
 * Business Logic Entity class BLregion_neighbour
 *
 * Class for manipulating data- and database objects
 * for Entity Region_neighbour and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLregion_neighbour extends Bregion_neighbour {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    /**
     * Constructor, sets Region_neighbour as default Entity
     */
    public BLregion_neighbour() {
        this.setLogginrequired(isprivatetable);
    }

    /**
     * Constructor, sets Region_neighbour as default Entity
     * sets transaction queue from given GeneralObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralObjects that holds the transaction queue
     */
    public BLregion_neighbour(BLtable transactionobject) {
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
        this.addStatement(EMregion_neighbour.SQLDeleteAll);
        this.addStatement(EMregion_neighbour.SQLcreateneighours);
        this.Commit2DB();
    }

    /**
     * try to insert Region_neighbour object in database
     * commit transaction
     * @param region_neighbour: Region_neighbour Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void insertRegion_neighbour(IRegion_neighbour region_neighbour) throws DBException, DataException {
        trans_insertRegion_neighbour(region_neighbour);
        super.Commit2DB();
    }
    
    /**
     * try to insert Region_neighbour object in database
     * an alternative to insertRegion_neighbour, which can be made an empty function
     * commit transaction
     * @param region_neighbour: Region_neighbour Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureinsertRegion_neighbour(IRegion_neighbour region_neighbour) throws DBException, DataException {
        trans_insertRegion_neighbour(region_neighbour);
        super.Commit2DB();
    }
    
    /**
     * try to update Region_neighbour object in database
     * commit transaction
     * @param region_neighbour: Region_neighbour Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void updateRegion_neighbour(IRegion_neighbour region_neighbour) throws DBException, DataException {
        trans_updateRegion_neighbour(region_neighbour);
        super.Commit2DB();
    }
    
    /**
     * try to update Region_neighbour object in database
     * an alternative to updateRegion_neighbour, which can be made an empty function
     * commit transaction
     * @param region_neighbour: Region_neighbour Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureupdateRegion_neighbour(IRegion_neighbour region_neighbour) throws DBException, DataException {
        trans_updateRegion_neighbour(region_neighbour);
        super.Commit2DB();
    }
    
    /**
     * try to delete Region_neighbour object in database
     * commit transaction
     * @param region_neighbour: Region_neighbour Entity Object
     * @throws general.exception.DBException
     */
    @Override
    public void deleteRegion_neighbour(IRegion_neighbour region_neighbour) throws DBException {
        trans_deleteRegion_neighbour(region_neighbour);
        super.Commit2DB();
    }

    /**
     * try to delete Region_neighbour object in database
     * an alternative to deleteRegion_neighbour, which can be made an empty function
     * commit transaction
     * @param region_neighbour: Region_neighbour Entity Object
     * @throws general.exception.DBException
     */
    public void securedeleteRegion_neighbour(IRegion_neighbour region_neighbour) throws DBException {
        trans_deleteRegion_neighbour(region_neighbour);
        super.Commit2DB();
    }

    /**
     * try to insert Region_neighbour object in database
     * do not commit transaction
     * @param region_neighbour: Region_neighbour Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_insertRegion_neighbour(IRegion_neighbour region_neighbour) throws DBException, DataException {
        super.checkDATA(region_neighbour);
        super.insertRegion_neighbour((Region_neighbour)region_neighbour);
    }
    
    /**
     * try to update Region_neighbour object in database
     * do not commit transaction
     * @param region_neighbour: Region_neighbour Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_updateRegion_neighbour(IRegion_neighbour region_neighbour) throws DBException, DataException {
        super.checkDATA(region_neighbour);
        super.updateRegion_neighbour((Region_neighbour)region_neighbour);
    }
    
    /**
     * try to delete Region_neighbour object in database
     * do not commit transaction
     * @param region_neighbour: Region_neighbour Entity Object
     * @throws general.exception.DBException
     */
    public void trans_deleteRegion_neighbour(IRegion_neighbour region_neighbour) throws DBException {
        super.deleteRegion_neighbour((Region_neighbour)region_neighbour);
    }
}
