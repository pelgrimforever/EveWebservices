/*
 * BLallnodes_system.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 15.11.2021 15:0
 *
 */

package eve.BusinessObject.Logic;

import BusinessObject.BLtable;
import general.exception.DBException;
import eve.interfaces.logicentity.IAllnodes_system;
import eve.logicentity.Allnodes_system;
import eve.BusinessObject.table.Ballnodes_system;
import eve.conversion.entity.EMallnodes_system;
import general.exception.DataException;

/**
 * Business Logic Entity class BLallnodes_system
 *
 * Class for manipulating data- and database objects
 * for Entity Allnodes_system and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLallnodes_system extends Ballnodes_system {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    /**
     * Constructor, sets Allnodes_system as default Entity
     */
    public BLallnodes_system() {
        this.setLogginrequired(isprivatetable);
    }

    public void reload() {
        this.addStatement(EMallnodes_system.SQLdeleteAll);
        this.addStatement(EMallnodes_system.SQLcopySystems);
    }
    
    public void markdeadends() {
        this.addStatement(EMallnodes_system.SQLmarkdeadends);
    }
    
    public long getDeadendscount() throws DBException {
        return this.count(EMallnodes_system.SQLgetdeadends, null);
    }
    
    /**
     * Constructor, sets Allnodes_system as default Entity
     * sets transaction queue from given GeneralObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralObjects that holds the transaction queue
     */
    public BLallnodes_system(BLtable transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }

    /**
     * try to insert Allnodes_system object in database
     * commit transaction
     * @param allnodes_system: Allnodes_system Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void insertAllnodes_system(IAllnodes_system allnodes_system) throws DBException, DataException {
        trans_insertAllnodes_system(allnodes_system);
        super.Commit2DB();
    }
    
    /**
     * try to insert Allnodes_system object in database
     * an alternative to insertAllnodes_system, which can be made an empty function
     * commit transaction
     * @param allnodes_system: Allnodes_system Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureinsertAllnodes_system(IAllnodes_system allnodes_system) throws DBException, DataException {
        trans_insertAllnodes_system(allnodes_system);
        super.Commit2DB();
    }
    
    /**
     * try to update Allnodes_system object in database
     * commit transaction
     * @param allnodes_system: Allnodes_system Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void updateAllnodes_system(IAllnodes_system allnodes_system) throws DBException, DataException {
        trans_updateAllnodes_system(allnodes_system);
        super.Commit2DB();
    }
    
    /**
     * try to update Allnodes_system object in database
     * an alternative to updateAllnodes_system, which can be made an empty function
     * commit transaction
     * @param allnodes_system: Allnodes_system Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureupdateAllnodes_system(IAllnodes_system allnodes_system) throws DBException, DataException {
        trans_updateAllnodes_system(allnodes_system);
        super.Commit2DB();
    }
    
    /**
     * try to delete Allnodes_system object in database
     * commit transaction
     * @param allnodes_system: Allnodes_system Entity Object
     * @throws general.exception.DBException
     */
    @Override
    public void deleteAllnodes_system(IAllnodes_system allnodes_system) throws DBException {
        trans_deleteAllnodes_system(allnodes_system);
        super.Commit2DB();
    }

    /**
     * try to delete Allnodes_system object in database
     * an alternative to deleteAllnodes_system, which can be made an empty function
     * commit transaction
     * @param allnodes_system: Allnodes_system Entity Object
     * @throws general.exception.DBException
     */
    public void securedeleteAllnodes_system(IAllnodes_system allnodes_system) throws DBException {
        trans_deleteAllnodes_system(allnodes_system);
        super.Commit2DB();
    }

    /**
     * try to insert Allnodes_system object in database
     * do not commit transaction
     * @param allnodes_system: Allnodes_system Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_insertAllnodes_system(IAllnodes_system allnodes_system) throws DBException, DataException {
        super.checkDATA(allnodes_system);
        super.insertAllnodes_system((Allnodes_system)allnodes_system);
    }
    
    /**
     * try to update Allnodes_system object in database
     * do not commit transaction
     * @param allnodes_system: Allnodes_system Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_updateAllnodes_system(IAllnodes_system allnodes_system) throws DBException, DataException {
        super.checkDATA(allnodes_system);
        super.updateAllnodes_system((Allnodes_system)allnodes_system);
    }
    
    /**
     * try to delete Allnodes_system object in database
     * do not commit transaction
     * @param allnodes_system: Allnodes_system Entity Object
     * @throws general.exception.DBException
     */
    public void trans_deleteAllnodes_system(IAllnodes_system allnodes_system) throws DBException {
        super.deleteAllnodes_system((Allnodes_system)allnodes_system);
    }
}
