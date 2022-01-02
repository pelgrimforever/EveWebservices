/*
 * BLsystemjumps.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 3.5.2021 14:39
 *
 */

package eve.BusinessObject.Logic;

import BusinessObject.BLtable;
import db.SQLparameters;
import eve.BusinessObject.table.Bsystemjumps;
import eve.conversion.entity.EMsystemjumps;
import eve.interfaces.logicentity.ISystemjumps;
import eve.logicentity.Systemjumps;
import general.exception.DBException;
import general.exception.DataException;
import java.util.ArrayList;

/**
 * Business Logic Entity class BLsystemjumps
 *
 * Class for manipulating data- and database objects
 * for Entity Systemjumps and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLsystemjumps extends Bsystemjumps {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    /**
     * Constructor, sets Systemjumps as default Entity
     */
    public BLsystemjumps() {
        this.setLogginrequired(isprivatetable);
    }

    /**
     * Constructor, sets Systemjumps as default Entity
     * sets transaction queue from given GeneralObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralObjects that holds the transaction queue
     */
    public BLsystemjumps(BLtable transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }

    public void createsystemjumps() throws DBException {
        super.addStatement(EMsystemjumps.SQLDeleteall);
        super.addStatement(EMsystemjumps.SQLcreatesystemjumpslowsec);
        super.Commit2DB();
    }
    
    /**
     * @set all starting points to 1 jump
     * @throws general.exception.DBException
     */
    public void set0jumpsto1() throws DBException {
        super.addStatement(EMsystemjumps.SQLset0jumpsto1);
        super.Commit2DB();
    }

    /**
     * get all systemjump combinations for all systems used in shiporderselected
     * @return
     * @throws DBException 
     */
    public ArrayList getSystemjumps4shiporderselected(String username, long system1, long system2) throws DBException {
        Object[][] parameteruser = {{ "username", username }};
        SQLparameters sqlparameters = new SQLparameters(parameteruser);
        ArrayList systemjumpspermutations = this.getEntities(EMsystemjumps.SQLSelect4shipfitorderselectedpermutations, sqlparameters);
        Object[][] parametersystems = {{ "system1", system1 }, { "system2", system2 } };
        sqlparameters = new SQLparameters(parametersystems, parameteruser);
        ArrayList systemjumps = this.getEntities(EMsystemjumps.SQLSelect4shipfitorderselected, sqlparameters);
        systemjumpspermutations.addAll(systemjumps);
        return systemjumpspermutations;
    }
    
    /**
     * try to insert Systemjumps object in database
     * commit transaction
     * @param systemjumps: Systemjumps Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void insertSystemjumps(ISystemjumps systemjumps) throws DBException, DataException {
        trans_insertSystemjumps(systemjumps);
        super.Commit2DB();
    }
    
    /**
     * try to insert Systemjumps object in database
     * an alternative to insertSystemjumps, which can be made an empty function
     * commit transaction
     * @param systemjumps: Systemjumps Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureinsertSystemjumps(ISystemjumps systemjumps) throws DBException, DataException {
        trans_insertSystemjumps(systemjumps);
        super.Commit2DB();
    }
    
    /**
     * try to update Systemjumps object in database
     * commit transaction
     * @param systemjumps: Systemjumps Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void updateSystemjumps(ISystemjumps systemjumps) throws DBException, DataException {
        trans_updateSystemjumps(systemjumps);
        super.Commit2DB();
    }
    
    /**
     * try to update Systemjumps object in database
     * an alternative to updateSystemjumps, which can be made an empty function
     * commit transaction
     * @param systemjumps: Systemjumps Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureupdateSystemjumps(ISystemjumps systemjumps) throws DBException, DataException {
        trans_updateSystemjumps(systemjumps);
        super.Commit2DB();
    }
    
    /**
     * try to delete Systemjumps object in database
     * commit transaction
     * @param systemjumps: Systemjumps Entity Object
     * @throws general.exception.DBException
     */
    @Override
    public void deleteSystemjumps(ISystemjumps systemjumps) throws DBException {
        trans_deleteSystemjumps(systemjumps);
        super.Commit2DB();
    }

    /**
     * try to delete Systemjumps object in database
     * an alternative to deleteSystemjumps, which can be made an empty function
     * commit transaction
     * @param systemjumps: Systemjumps Entity Object
     * @throws general.exception.DBException
     */
    public void securedeleteSystemjumps(ISystemjumps systemjumps) throws DBException {
        trans_deleteSystemjumps(systemjumps);
        super.Commit2DB();
    }

    /**
     * try to insert Systemjumps object in database
     * do not commit transaction
     * @param systemjumps: Systemjumps Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_insertSystemjumps(ISystemjumps systemjumps) throws DBException, DataException {
        super.checkDATA(systemjumps);
        super.insertSystemjumps((Systemjumps)systemjumps);
    }
    
    /**
     * try to update Systemjumps object in database
     * do not commit transaction
     * @param systemjumps: Systemjumps Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_updateSystemjumps(ISystemjumps systemjumps) throws DBException, DataException {
        super.checkDATA(systemjumps);
        super.updateSystemjumps((Systemjumps)systemjumps);
    }
    
    /**
     * try to delete Systemjumps object in database
     * do not commit transaction
     * @param systemjumps: Systemjumps Entity Object
     * @throws general.exception.DBException
     */
    public void trans_deleteSystemjumps(ISystemjumps systemjumps) throws DBException {
        super.deleteSystemjumps((Systemjumps)systemjumps);
    }
}
