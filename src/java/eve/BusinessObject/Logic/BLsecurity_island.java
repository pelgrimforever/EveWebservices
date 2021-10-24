/*
 * BLsecurity_island.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 24.4.2021 17:5
 *
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import eve.interfaces.logicentity.ISecurity_island;
import eve.logicentity.Security_island;
import BusinessObject.BLtable;
import eve.BusinessObject.table.Bsecurity_island;
import eve.conversion.entity.EMsecurity_island;
import eve.conversion.entity.EMsystem;
import general.exception.DataException;

/**
 * Business Logic Entity class BLsecurity_island
 *
 * Class for manipulating data- and database objects
 * for Entity Security_island and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLsecurity_island extends Bsecurity_island {
//ProjectGenerator: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    /**
     * Constructor, sets Security_island as default Entity
     */
    public BLsecurity_island() {
        this.setLogginrequired(isprivatetable);
    }

    /**
     * Constructor, sets Security_island as default Entity
     * sets transaction queue from given GeneralObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralObjects that holds the transaction queue
     */
    public BLsecurity_island(BLtable transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }

    public void deleteAll() throws DBException, DataException {
        this.addStatement(EMsystem.SQLRemoveSecurityIslands);
        this.addStatement(EMsecurity_island.SQLDeleteAll);
        this.Commit2DB();
    }
    
    /**
     * try to insert Security_island object in database
     * commit transaction
     * @param security_island: Security_island Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void insertSecurity_island(ISecurity_island security_island) throws DBException, DataException {
        trans_insertSecurity_island(security_island);
        super.Commit2DB();
    }
    
    /**
     * try to insert Security_island object in database
     * an alternative to insertSecurity_island, which can be made an empty function
     * commit transaction
     * @param security_island: Security_island Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureinsertSecurity_island(ISecurity_island security_island) throws DBException, DataException {
        trans_insertSecurity_island(security_island);
        super.Commit2DB();
    }
    
    /**
     * try to update Security_island object in database
     * commit transaction
     * @param security_island: Security_island Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void updateSecurity_island(ISecurity_island security_island) throws DBException, DataException {
        trans_updateSecurity_island(security_island);
        super.Commit2DB();
    }
    
    /**
     * try to update Security_island object in database
     * an alternative to updateSecurity_island, which can be made an empty function
     * commit transaction
     * @param security_island: Security_island Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureupdateSecurity_island(ISecurity_island security_island) throws DBException, DataException {
        trans_updateSecurity_island(security_island);
        super.Commit2DB();
    }
    
    /**
     * try to delete Security_island object in database
     * commit transaction
     * @param security_island: Security_island Entity Object
     * @throws general.exception.DBException
     */
    @Override
    public void deleteSecurity_island(ISecurity_island security_island) throws DBException {
        trans_deleteSecurity_island(security_island);
        super.Commit2DB();
    }

    /**
     * try to delete Security_island object in database
     * an alternative to deleteSecurity_island, which can be made an empty function
     * commit transaction
     * @param security_island: Security_island Entity Object
     * @throws general.exception.DBException
     */
    public void securedeleteSecurity_island(ISecurity_island security_island) throws DBException {
        trans_deleteSecurity_island(security_island);
        super.Commit2DB();
    }

    /**
     * try to insert Security_island object in database
     * do not commit transaction
     * @param security_island: Security_island Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_insertSecurity_island(ISecurity_island security_island) throws DBException, DataException {
        super.checkDATA(security_island);
        super.insertSecurity_island((Security_island)security_island);
    }
    
    /**
     * try to update Security_island object in database
     * do not commit transaction
     * @param security_island: Security_island Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_updateSecurity_island(ISecurity_island security_island) throws DBException, DataException {
        super.checkDATA(security_island);
        super.updateSecurity_island((Security_island)security_island);
    }
    
    /**
     * try to delete Security_island object in database
     * do not commit transaction
     * @param security_island: Security_island Entity Object
     * @throws general.exception.DBException
     */
    public void trans_deleteSecurity_island(ISecurity_island security_island) throws DBException {
        super.deleteSecurity_island((Security_island)security_island);
    }
}
