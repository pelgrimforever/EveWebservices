/*
 * BLfrontendpage.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 13.1.2022 17:48
 *
 */

package eve.BusinessObject.Logic;

import BusinessObject.BLtable;
import general.exception.DBException;
import general.exception.DataException;
import data.interfaces.db.LogicEntity;
import eve.interfaces.logicentity.IFrontendpage;
import eve.logicentity.Frontendpage;
import eve.BusinessObject.table.Bfrontendpage;
import general.exception.DataException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Business Logic Entity class BLfrontendpage
 *
 * Class for manipulating data- and database objects
 * for Entity Frontendpage and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLfrontendpage extends Bfrontendpage {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = true; //set this to true if only a loggin account has access to this data
    
    public static final String USERS = "users";
    public static final String DOWNLOADTRADE = "downloadtrade";
    public static final String DOWNLOADCONTRACT = "downloadcontract";
	
    /**
     * Constructor, sets Frontendpage as default Entity
     */
    public BLfrontendpage() {
        this.setLogginrequired(isprivatetable);
    }

    /**
     * Constructor, sets Frontendpage as default Entity
     * sets transaction queue from given GeneralObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralObjects that holds the transaction queue
     */
    public BLfrontendpage(BLtable transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }

    /**
     * try to insert Frontendpage object in database
     * commit transaction
     * @param frontendpage: Frontendpage Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void insertFrontendpage(IFrontendpage frontendpage) throws DBException, DataException {
        trans_insertFrontendpage(frontendpage);
        super.Commit2DB();
    }
    
    /**
     * try to insert Frontendpage object in database
     * an alternative to insertFrontendpage, which can be made an empty function
     * commit transaction
     * @param frontendpage: Frontendpage Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureinsertFrontendpage(IFrontendpage frontendpage) throws DBException, DataException {
        trans_insertFrontendpage(frontendpage);
        super.Commit2DB();
    }
    
    /**
     * try to update Frontendpage object in database
     * commit transaction
     * @param frontendpage: Frontendpage Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void updateFrontendpage(IFrontendpage frontendpage) throws DBException, DataException {
        trans_updateFrontendpage(frontendpage);
        super.Commit2DB();
    }
    
    /**
     * try to update Frontendpage object in database
     * an alternative to updateFrontendpage, which can be made an empty function
     * commit transaction
     * @param frontendpage: Frontendpage Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureupdateFrontendpage(IFrontendpage frontendpage) throws DBException, DataException {
        trans_updateFrontendpage(frontendpage);
        super.Commit2DB();
    }
    
    /**
     * try to delete Frontendpage object in database
     * commit transaction
     * @param frontendpage: Frontendpage Entity Object
     * @throws general.exception.DBException
     */
    @Override
    public void deleteFrontendpage(IFrontendpage frontendpage) throws DBException {
        trans_deleteFrontendpage(frontendpage);
        super.Commit2DB();
    }

    /**
     * try to delete Frontendpage object in database
     * an alternative to deleteFrontendpage, which can be made an empty function
     * commit transaction
     * @param frontendpage: Frontendpage Entity Object
     * @throws general.exception.DBException
     */
    public void securedeleteFrontendpage(IFrontendpage frontendpage) throws DBException {
        trans_deleteFrontendpage(frontendpage);
        super.Commit2DB();
    }

    /**
     * try to insert Frontendpage object in database
     * do not commit transaction
     * @param frontendpage: Frontendpage Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_insertFrontendpage(IFrontendpage frontendpage) throws DBException, DataException {
        super.checkDATA(frontendpage);
        super.insertFrontendpage((Frontendpage)frontendpage);
    }
    
    /**
     * try to update Frontendpage object in database
     * do not commit transaction
     * @param frontendpage: Frontendpage Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_updateFrontendpage(IFrontendpage frontendpage) throws DBException, DataException {
        super.checkDATA(frontendpage);
        super.updateFrontendpage((Frontendpage)frontendpage);
    }
    
    /**
     * try to delete Frontendpage object in database
     * do not commit transaction
     * @param frontendpage: Frontendpage Entity Object
     * @throws general.exception.DBException
     */
    public void trans_deleteFrontendpage(IFrontendpage frontendpage) throws DBException {
        super.deleteFrontendpage((Frontendpage)frontendpage);
    }
}
