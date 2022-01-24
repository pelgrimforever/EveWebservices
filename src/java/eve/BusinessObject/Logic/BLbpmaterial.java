/*
 * BLbpmaterial.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 24.0.2022 16:47
 *
 */

package eve.BusinessObject.Logic;

import BusinessObject.BLtable;
import general.exception.DBException;
import general.exception.DataException;
import data.interfaces.db.LogicEntity;
import eve.interfaces.logicentity.IBpmaterial;
import eve.logicentity.Bpmaterial;
import eve.BusinessObject.table.Bbpmaterial;
import general.exception.DataException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Business Logic Entity class BLbpmaterial
 *
 * Class for manipulating data- and database objects
 * for Entity Bpmaterial and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLbpmaterial extends Bbpmaterial {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    /**
     * Constructor, sets Bpmaterial as default Entity
     */
    public BLbpmaterial() {
        this.setLogginrequired(isprivatetable);
    }

    /**
     * Constructor, sets Bpmaterial as default Entity
     * sets transaction queue from given GeneralObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralObjects that holds the transaction queue
     */
    public BLbpmaterial(BLtable transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }

    /**
     * try to insert Bpmaterial object in database
     * commit transaction
     * @param bpmaterial: Bpmaterial Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void insertBpmaterial(IBpmaterial bpmaterial) throws DBException, DataException {
        trans_insertBpmaterial(bpmaterial);
        super.Commit2DB();
    }
    
    /**
     * try to insert Bpmaterial object in database
     * an alternative to insertBpmaterial, which can be made an empty function
     * commit transaction
     * @param bpmaterial: Bpmaterial Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureinsertBpmaterial(IBpmaterial bpmaterial) throws DBException, DataException {
        trans_insertBpmaterial(bpmaterial);
        super.Commit2DB();
    }
    
    /**
     * try to update Bpmaterial object in database
     * commit transaction
     * @param bpmaterial: Bpmaterial Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void updateBpmaterial(IBpmaterial bpmaterial) throws DBException, DataException {
        trans_updateBpmaterial(bpmaterial);
        super.Commit2DB();
    }
    
    /**
     * try to update Bpmaterial object in database
     * an alternative to updateBpmaterial, which can be made an empty function
     * commit transaction
     * @param bpmaterial: Bpmaterial Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureupdateBpmaterial(IBpmaterial bpmaterial) throws DBException, DataException {
        trans_updateBpmaterial(bpmaterial);
        super.Commit2DB();
    }
    
    /**
     * try to delete Bpmaterial object in database
     * commit transaction
     * @param bpmaterial: Bpmaterial Entity Object
     * @throws general.exception.DBException
     */
    @Override
    public void deleteBpmaterial(IBpmaterial bpmaterial) throws DBException {
        trans_deleteBpmaterial(bpmaterial);
        super.Commit2DB();
    }

    /**
     * try to delete Bpmaterial object in database
     * an alternative to deleteBpmaterial, which can be made an empty function
     * commit transaction
     * @param bpmaterial: Bpmaterial Entity Object
     * @throws general.exception.DBException
     */
    public void securedeleteBpmaterial(IBpmaterial bpmaterial) throws DBException {
        trans_deleteBpmaterial(bpmaterial);
        super.Commit2DB();
    }

    /**
     * try to insert Bpmaterial object in database
     * do not commit transaction
     * @param bpmaterial: Bpmaterial Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_insertBpmaterial(IBpmaterial bpmaterial) throws DBException, DataException {
        super.checkDATA(bpmaterial);
        super.insertBpmaterial((Bpmaterial)bpmaterial);
    }
    
    /**
     * try to update Bpmaterial object in database
     * do not commit transaction
     * @param bpmaterial: Bpmaterial Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_updateBpmaterial(IBpmaterial bpmaterial) throws DBException, DataException {
        super.checkDATA(bpmaterial);
        super.updateBpmaterial((Bpmaterial)bpmaterial);
    }
    
    /**
     * try to delete Bpmaterial object in database
     * do not commit transaction
     * @param bpmaterial: Bpmaterial Entity Object
     * @throws general.exception.DBException
     */
    public void trans_deleteBpmaterial(IBpmaterial bpmaterial) throws DBException {
        super.deleteBpmaterial((Bpmaterial)bpmaterial);
    }
}
