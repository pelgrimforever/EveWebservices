/*
 * BLcontractitem.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 2.0.2022 18:23
 *
 */

package eve.BusinessObject.Logic;

import BusinessObject.BLtable;
import general.exception.DBException;
import general.exception.DataException;
import data.interfaces.db.LogicEntity;
import eve.interfaces.logicentity.IContractitem;
import eve.logicentity.Contractitem;
import eve.BusinessObject.table.Bcontractitem;
import general.exception.DataException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Business Logic Entity class BLcontractitem
 *
 * Class for manipulating data- and database objects
 * for Entity Contractitem and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLcontractitem extends Bcontractitem {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    /**
     * Constructor, sets Contractitem as default Entity
     */
    public BLcontractitem() {
        this.setLogginrequired(isprivatetable);
    }

    /**
     * Constructor, sets Contractitem as default Entity
     * sets transaction queue from given GeneralObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralObjects that holds the transaction queue
     */
    public BLcontractitem(BLtable transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }

    /**
     * try to insert Contractitem object in database
     * commit transaction
     * @param contractitem: Contractitem Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void insertContractitem(IContractitem contractitem) throws DBException, DataException {
        trans_insertContractitem(contractitem);
        super.Commit2DB();
    }
    
    /**
     * try to insert Contractitem object in database
     * an alternative to insertContractitem, which can be made an empty function
     * commit transaction
     * @param contractitem: Contractitem Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureinsertContractitem(IContractitem contractitem) throws DBException, DataException {
        trans_insertContractitem(contractitem);
        super.Commit2DB();
    }
    
    /**
     * try to update Contractitem object in database
     * commit transaction
     * @param contractitem: Contractitem Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void updateContractitem(IContractitem contractitem) throws DBException, DataException {
        trans_updateContractitem(contractitem);
        super.Commit2DB();
    }
    
    /**
     * try to update Contractitem object in database
     * an alternative to updateContractitem, which can be made an empty function
     * commit transaction
     * @param contractitem: Contractitem Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureupdateContractitem(IContractitem contractitem) throws DBException, DataException {
        trans_updateContractitem(contractitem);
        super.Commit2DB();
    }
    
    /**
     * try to delete Contractitem object in database
     * commit transaction
     * @param contractitem: Contractitem Entity Object
     * @throws general.exception.DBException
     */
    @Override
    public void deleteContractitem(IContractitem contractitem) throws DBException {
        trans_deleteContractitem(contractitem);
        super.Commit2DB();
    }

    /**
     * try to delete Contractitem object in database
     * an alternative to deleteContractitem, which can be made an empty function
     * commit transaction
     * @param contractitem: Contractitem Entity Object
     * @throws general.exception.DBException
     */
    public void securedeleteContractitem(IContractitem contractitem) throws DBException {
        trans_deleteContractitem(contractitem);
        super.Commit2DB();
    }

    /**
     * try to insert Contractitem object in database
     * do not commit transaction
     * @param contractitem: Contractitem Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_insertContractitem(IContractitem contractitem) throws DBException, DataException {
        super.checkDATA(contractitem);
        super.insertContractitem((Contractitem)contractitem);
    }
    
    /**
     * try to update Contractitem object in database
     * do not commit transaction
     * @param contractitem: Contractitem Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_updateContractitem(IContractitem contractitem) throws DBException, DataException {
        super.checkDATA(contractitem);
        super.updateContractitem((Contractitem)contractitem);
    }
    
    /**
     * try to delete Contractitem object in database
     * do not commit transaction
     * @param contractitem: Contractitem Entity Object
     * @throws general.exception.DBException
     */
    public void trans_deleteContractitem(IContractitem contractitem) throws DBException {
        super.deleteContractitem((Contractitem)contractitem);
    }
}
