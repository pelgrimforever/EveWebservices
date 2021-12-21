/*
 * BLallnodes_stargate.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 15.11.2021 15:0
 *
 */

package eve.BusinessObject.Logic;

import BusinessObject.BLtable;
import general.exception.DBException;
import eve.interfaces.logicentity.IAllnodes_stargate;
import eve.logicentity.Allnodes_stargate;
import eve.BusinessObject.table.Ballnodes_stargate;
import eve.conversion.entity.EMallnodes_stargate;
import general.exception.DataException;

/**
 * Business Logic Entity class BLallnodes_stargate
 *
 * Class for manipulating data- and database objects
 * for Entity Allnodes_stargate and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLallnodes_stargate extends Ballnodes_stargate {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    /**
     * Constructor, sets Allnodes_stargate as default Entity
     */
    public BLallnodes_stargate() {
        this.setLogginrequired(isprivatetable);
    }

    public void reload() {
        this.addStatement(EMallnodes_stargate.SQLcopyStargates);
    }
    
    public void markdeadends() {
        this.addStatement(EMallnodes_stargate.SQLmarkdeadends);
    }
    
    /**
     * Constructor, sets Allnodes_stargate as default Entity
     * sets transaction queue from given GeneralObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralObjects that holds the transaction queue
     */
    public BLallnodes_stargate(BLtable transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }

    /**
     * try to insert Allnodes_stargate object in database
     * commit transaction
     * @param allnodes_stargate: Allnodes_stargate Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void insertAllnodes_stargate(IAllnodes_stargate allnodes_stargate) throws DBException, DataException {
        trans_insertAllnodes_stargate(allnodes_stargate);
        super.Commit2DB();
    }
    
    /**
     * try to insert Allnodes_stargate object in database
     * an alternative to insertAllnodes_stargate, which can be made an empty function
     * commit transaction
     * @param allnodes_stargate: Allnodes_stargate Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureinsertAllnodes_stargate(IAllnodes_stargate allnodes_stargate) throws DBException, DataException {
        trans_insertAllnodes_stargate(allnodes_stargate);
        super.Commit2DB();
    }
    
    /**
     * try to update Allnodes_stargate object in database
     * commit transaction
     * @param allnodes_stargate: Allnodes_stargate Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void updateAllnodes_stargate(IAllnodes_stargate allnodes_stargate) throws DBException, DataException {
        trans_updateAllnodes_stargate(allnodes_stargate);
        super.Commit2DB();
    }
    
    /**
     * try to update Allnodes_stargate object in database
     * an alternative to updateAllnodes_stargate, which can be made an empty function
     * commit transaction
     * @param allnodes_stargate: Allnodes_stargate Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureupdateAllnodes_stargate(IAllnodes_stargate allnodes_stargate) throws DBException, DataException {
        trans_updateAllnodes_stargate(allnodes_stargate);
        super.Commit2DB();
    }
    
    /**
     * try to delete Allnodes_stargate object in database
     * commit transaction
     * @param allnodes_stargate: Allnodes_stargate Entity Object
     * @throws general.exception.DBException
     */
    @Override
    public void deleteAllnodes_stargate(IAllnodes_stargate allnodes_stargate) throws DBException {
        trans_deleteAllnodes_stargate(allnodes_stargate);
        super.Commit2DB();
    }

    /**
     * try to delete Allnodes_stargate object in database
     * an alternative to deleteAllnodes_stargate, which can be made an empty function
     * commit transaction
     * @param allnodes_stargate: Allnodes_stargate Entity Object
     * @throws general.exception.DBException
     */
    public void securedeleteAllnodes_stargate(IAllnodes_stargate allnodes_stargate) throws DBException {
        trans_deleteAllnodes_stargate(allnodes_stargate);
        super.Commit2DB();
    }

    /**
     * try to insert Allnodes_stargate object in database
     * do not commit transaction
     * @param allnodes_stargate: Allnodes_stargate Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_insertAllnodes_stargate(IAllnodes_stargate allnodes_stargate) throws DBException, DataException {
        super.checkDATA(allnodes_stargate);
        super.insertAllnodes_stargate((Allnodes_stargate)allnodes_stargate);
    }
    
    /**
     * try to update Allnodes_stargate object in database
     * do not commit transaction
     * @param allnodes_stargate: Allnodes_stargate Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_updateAllnodes_stargate(IAllnodes_stargate allnodes_stargate) throws DBException, DataException {
        super.checkDATA(allnodes_stargate);
        super.updateAllnodes_stargate((Allnodes_stargate)allnodes_stargate);
    }
    
    /**
     * try to delete Allnodes_stargate object in database
     * do not commit transaction
     * @param allnodes_stargate: Allnodes_stargate Entity Object
     * @throws general.exception.DBException
     */
    public void trans_deleteAllnodes_stargate(IAllnodes_stargate allnodes_stargate) throws DBException {
        super.deleteAllnodes_stargate((Allnodes_stargate)allnodes_stargate);
    }
}
