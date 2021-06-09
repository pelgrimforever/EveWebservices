/*
 * BLroutetype.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 29.4.2021 10:38
 *
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import general.exception.DataException;
import data.interfaces.db.LogicEntity;
import eve.interfaces.logicentity.IRoutetype;
import eve.logicentity.Routetype;
import BusinessObject.GeneralEntityObject;
import eve.BusinessObject.table.Broutetype;
import general.exception.DataException;
import eve.interfaces.BusinessObject.IBLroutetype;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Business Logic Entity class BLroutetype
 *
 * Class for manipulating data- and database objects
 * for Entity Routetype and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLroutetype extends Broutetype implements IBLroutetype {
//ProjectGenerator: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    /**
     * Constructor, sets Routetype as default Entity
     */
    public BLroutetype() {
        this.setLogginrequired(isprivatetable);
    }

    /**
     * Constructor, sets Routetype as default Entity
     * sets transaction queue from given GeneralObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralObjects that holds the transaction queue
     */
    public BLroutetype(GeneralEntityObject transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }

    /**
     * load extra fields from adjusted sql statement
     */
    @Override
    public void loadExtra(ResultSet dbresult, LogicEntity routetype) throws SQLException {
        
    }
    
    /**
     * try to insert Routetype object in database
     * commit transaction
     * @param routetype: Routetype Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    @Override
    public void insertRoutetype(IRoutetype routetype) throws DBException, DataException {
        trans_insertRoutetype(routetype);
        super.Commit2DB();
    }
    
    /**
     * try to insert Routetype object in database
     * an alternative to insertRoutetype, which can be made an empty function
     * commit transaction
     * @param routetype: Routetype Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void secureinsertRoutetype(IRoutetype routetype) throws DBException, DataException {
        trans_insertRoutetype(routetype);
        super.Commit2DB();
    }
    
    /**
     * try to update Routetype object in database
     * commit transaction
     * @param routetype: Routetype Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    @Override
    public void updateRoutetype(IRoutetype routetype) throws DBException, DataException {
        trans_updateRoutetype(routetype);
        super.Commit2DB();
    }
    
    /**
     * try to update Routetype object in database
     * an alternative to updateRoutetype, which can be made an empty function
     * commit transaction
     * @param routetype: Routetype Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void secureupdateRoutetype(IRoutetype routetype) throws DBException, DataException {
        trans_updateRoutetype(routetype);
        super.Commit2DB();
    }
    
    /**
     * try to delete Routetype object in database
     * commit transaction
     * @param routetype: Routetype Entity Object
     * @throws eve.general.exception.CustomException
     */
    @Override
    public void deleteRoutetype(IRoutetype routetype) throws DBException {
        trans_deleteRoutetype(routetype);
        super.Commit2DB();
    }

    /**
     * try to delete Routetype object in database
     * an alternative to deleteRoutetype, which can be made an empty function
     * commit transaction
     * @param routetype: Routetype Entity Object
     * @throws eve.general.exception.CustomException
     */
    public void securedeleteRoutetype(IRoutetype routetype) throws DBException {
        trans_deleteRoutetype(routetype);
        super.Commit2DB();
    }

    /**
     * try to insert Routetype object in database
     * do not commit transaction
     * @param routetype: Routetype Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void trans_insertRoutetype(IRoutetype routetype) throws DBException, DataException {
        super.checkDATA(routetype);
        super.insertRoutetype((Routetype)routetype);
    }
    
    /**
     * try to update Routetype object in database
     * do not commit transaction
     * @param routetype: Routetype Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void trans_updateRoutetype(IRoutetype routetype) throws DBException, DataException {
        super.checkDATA(routetype);
        super.updateRoutetype((Routetype)routetype);
    }
    
    /**
     * try to delete Routetype object in database
     * do not commit transaction
     * @param routetype: Routetype Entity Object
     * @throws eve.general.exception.CustomException
     */
    public void trans_deleteRoutetype(IRoutetype routetype) throws DBException {
        super.deleteRoutetype((Routetype)routetype);
    }
}
