/*
 * BLfrontendpage_auth.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 16.1.2022 20:53
 *
 */

package eve.BusinessObject.Logic;

import BusinessObject.BLtable;
import general.exception.DBException;
import eve.interfaces.logicentity.IFrontendpage_auth;
import eve.logicentity.Frontendpage_auth;
import eve.BusinessObject.table.Bfrontendpage_auth;
import eve.entity.pk.Frontendpage_authPK;
import general.exception.DataException;

/**
 * Business Logic Entity class BLfrontendpage_auth
 *
 * Class for manipulating data- and database objects
 * for Entity Frontendpage_auth and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLfrontendpage_auth extends Bfrontendpage_auth {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = true; //set this to true if only a loggin account has access to this data
	
    /**
     * Constructor, sets Frontendpage_auth as default Entity
     */
    public BLfrontendpage_auth() {
        this.setLogginrequired(isprivatetable);
    }

    /**
     * check if authorization exist for a username/page
     * @param username user name
     * @param page front end page
     * @return true/false
     * @throws DBException
     */
    public boolean checkAuth(String username, String page) throws DBException {
        Frontendpage_authPK frontendpage_authpk = new Frontendpage_authPK(username, page);
        return this.getEntityExists(frontendpage_authpk);
    }
    
    /**
     * Constructor, sets Frontendpage_auth as default Entity
     * sets transaction queue from given GeneralObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralObjects that holds the transaction queue
     */
    public BLfrontendpage_auth(BLtable transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }

    /**
     * try to insert Frontendpage_auth object in database
     * commit transaction
     * @param frontendpage_auth: Frontendpage_auth Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void insertFrontendpage_auth(IFrontendpage_auth frontendpage_auth) throws DBException, DataException {
        trans_insertFrontendpage_auth(frontendpage_auth);
        super.Commit2DB();
    }
    
    /**
     * try to insert Frontendpage_auth object in database
     * an alternative to insertFrontendpage_auth, which can be made an empty function
     * commit transaction
     * @param frontendpage_auth: Frontendpage_auth Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureinsertFrontendpage_auth(IFrontendpage_auth frontendpage_auth) throws DBException, DataException {
        trans_insertFrontendpage_auth(frontendpage_auth);
        super.Commit2DB();
    }
    
    /**
     * try to update Frontendpage_auth object in database
     * commit transaction
     * @param frontendpage_auth: Frontendpage_auth Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void updateFrontendpage_auth(IFrontendpage_auth frontendpage_auth) throws DBException, DataException {
        trans_updateFrontendpage_auth(frontendpage_auth);
        super.Commit2DB();
    }
    
    /**
     * try to update Frontendpage_auth object in database
     * an alternative to updateFrontendpage_auth, which can be made an empty function
     * commit transaction
     * @param frontendpage_auth: Frontendpage_auth Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureupdateFrontendpage_auth(IFrontendpage_auth frontendpage_auth) throws DBException, DataException {
        trans_updateFrontendpage_auth(frontendpage_auth);
        super.Commit2DB();
    }
    
    /**
     * try to delete Frontendpage_auth object in database
     * commit transaction
     * @param frontendpage_auth: Frontendpage_auth Entity Object
     * @throws general.exception.DBException
     */
    @Override
    public void deleteFrontendpage_auth(IFrontendpage_auth frontendpage_auth) throws DBException {
        trans_deleteFrontendpage_auth(frontendpage_auth);
        super.Commit2DB();
    }

    /**
     * try to delete Frontendpage_auth object in database
     * an alternative to deleteFrontendpage_auth, which can be made an empty function
     * commit transaction
     * @param frontendpage_auth: Frontendpage_auth Entity Object
     * @throws general.exception.DBException
     */
    public void securedeleteFrontendpage_auth(IFrontendpage_auth frontendpage_auth) throws DBException {
        trans_deleteFrontendpage_auth(frontendpage_auth);
        super.Commit2DB();
    }

    /**
     * try to insert Frontendpage_auth object in database
     * do not commit transaction
     * @param frontendpage_auth: Frontendpage_auth Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_insertFrontendpage_auth(IFrontendpage_auth frontendpage_auth) throws DBException, DataException {
        super.checkDATA(frontendpage_auth);
        super.insertFrontendpage_auth((Frontendpage_auth)frontendpage_auth);
    }
    
    /**
     * try to update Frontendpage_auth object in database
     * do not commit transaction
     * @param frontendpage_auth: Frontendpage_auth Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_updateFrontendpage_auth(IFrontendpage_auth frontendpage_auth) throws DBException, DataException {
        super.checkDATA(frontendpage_auth);
        super.updateFrontendpage_auth((Frontendpage_auth)frontendpage_auth);
    }
    
    /**
     * try to delete Frontendpage_auth object in database
     * do not commit transaction
     * @param frontendpage_auth: Frontendpage_auth Entity Object
     * @throws general.exception.DBException
     */
    public void trans_deleteFrontendpage_auth(IFrontendpage_auth frontendpage_auth) throws DBException {
        super.deleteFrontendpage_auth((Frontendpage_auth)frontendpage_auth);
    }
}
