/*
 * BLeveuser.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 13.1.2022 17:48
 *
 */

package eve.BusinessObject.Logic;

import BusinessObject.BLtable;
import general.exception.DBException;
import eve.interfaces.logicentity.IEveuser;
import eve.logicentity.Eveuser;
import eve.BusinessObject.table.Beveuser;
import general.exception.DataException;
import java.sql.Date;

/**
 * Business Logic Entity class BLeveuser
 *
 * Class for manipulating data- and database objects
 * for Entity Eveuser and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLeveuser extends Beveuser {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = true; //set this to true if only a loggin account has access to this data
	
    /**
     * Constructor, sets Eveuser as default Entity
     */
    public BLeveuser() {
        this.setLogginrequired(isprivatetable);
    }

    /**
     * Constructor, sets Eveuser as default Entity
     * sets transaction queue from given GeneralObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralObjects that holds the transaction queue
     */
    public BLeveuser(BLtable transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }

    /**
     * try to insert Eveuser object in database
     * commit transaction
     * @param eveuser: Eveuser Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void insertEveuser(IEveuser eveuser) throws DBException, DataException {
        trans_insertEveuser(eveuser);
        super.Commit2DB();
    }
    
    /**
     * try to insert Eveuser object in database
     * an alternative to insertEveuser, which can be made an empty function
     * commit transaction
     * @param eveuser: Eveuser Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureinsertEveuser(IEveuser eveuser) throws DBException, DataException {
        eveuser.setCreatedat(new Date(System.currentTimeMillis()));
        trans_insertEveuser(eveuser);
        super.Commit2DB();
    }
    
    /**
     * try to update Eveuser object in database
     * commit transaction
     * @param eveuser: Eveuser Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void updateEveuser(IEveuser eveuser) throws DBException, DataException {
        trans_updateEveuser(eveuser);
        super.Commit2DB();
    }
    
    /**
     * try to update Eveuser object in database
     * an alternative to updateEveuser, which can be made an empty function
     * commit transaction
     * @param eveuser: Eveuser Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureupdateEveuser(IEveuser eveuser) throws DBException, DataException {
        trans_updateEveuser(eveuser);
        super.Commit2DB();
    }
    
    /**
     * try to delete Eveuser object in database
     * commit transaction
     * @param eveuser: Eveuser Entity Object
     * @throws general.exception.DBException
     */
    @Override
    public void deleteEveuser(IEveuser eveuser) throws DBException {
        trans_deleteEveuser(eveuser);
        super.Commit2DB();
    }

    /**
     * try to delete Eveuser object in database
     * an alternative to deleteEveuser, which can be made an empty function
     * commit transaction
     * @param eveuser: Eveuser Entity Object
     * @throws general.exception.DBException
     */
    public void securedeleteEveuser(IEveuser eveuser) throws DBException {
        trans_deleteEveuser(eveuser);
        super.Commit2DB();
    }

    /**
     * try to insert Eveuser object in database
     * do not commit transaction
     * @param eveuser: Eveuser Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_insertEveuser(IEveuser eveuser) throws DBException, DataException {
        super.checkDATA(eveuser);
        super.insertEveuser((Eveuser)eveuser);
    }
    
    /**
     * try to update Eveuser object in database
     * do not commit transaction
     * @param eveuser: Eveuser Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_updateEveuser(IEveuser eveuser) throws DBException, DataException {
        super.checkDATA(eveuser);
        super.updateEveuser((Eveuser)eveuser);
    }
    
    /**
     * try to delete Eveuser object in database
     * do not commit transaction
     * @param eveuser: Eveuser Entity Object
     * @throws general.exception.DBException
     */
    public void trans_deleteEveuser(IEveuser eveuser) throws DBException {
        super.deleteEveuser((Eveuser)eveuser);
    }
}
