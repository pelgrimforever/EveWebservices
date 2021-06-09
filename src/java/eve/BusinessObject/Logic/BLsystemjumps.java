/*
 * BLsystemjumps.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 3.5.2021 14:39
 *
 */

package eve.BusinessObject.Logic;

import data.interfaces.db.LogicEntity;
import BusinessObject.GeneralEntityObject;
import eve.BusinessObject.table.Bsystemjumps;
import eve.entity.pk.SystemPK;
import eve.interfaces.BusinessObject.IBLsystemjumps;
import eve.interfaces.logicentity.ISystemjumps;
import eve.logicentity.Systemjumps;
import general.exception.DBException;
import general.exception.DataException;
import java.sql.ResultSet;
import java.sql.SQLException;

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
public class BLsystemjumps extends Bsystemjumps implements IBLsystemjumps {
//ProjectGenerator: NO AUTHOMATIC UPDATE
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
    public BLsystemjumps(GeneralEntityObject transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }

    /**
     * load extra fields from adjusted sql statement
     */
    @Override
    public void loadExtra(ResultSet dbresult, LogicEntity systemjumps) throws SQLException {
        
    }
    
    /**
     * @delete all systemjumps
     * @throws eve.general.exception.CustomException
     */
    public void deleteall() throws DBException {
        super.addStatement(this.getClass().getName(), Systemjumps.SQLDeleteall, null);
        super.Commit2DB();
    }

    /**
     * @copy all results in tmp_system_jumps to Systemjumps with given system as starting point
     * @throws eve.general.exception.CustomException
     */
    public void copy_Tmp_system_jumps(long systemid) throws DBException {
        Object[][] parameter = { { "system.id", systemid } };
        super.addStatement(this.getClass().getName(), Systemjumps.SQLcopy_from_tmpjups, parameter);
        super.Commit2DB();
    }

    /**
     * @set all starting points to 1 jump
     * @throws eve.general.exception.CustomException
     */
    public void set0jumpsto1() throws DBException {
        super.addStatement(this.getClass().getName(), Systemjumps.SQLset0jumpsto1, null);
        super.Commit2DB();
    }

    /**
     * try to insert Systemjumps object in database
     * commit transaction
     * @param systemjumps: Systemjumps Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
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
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void secureinsertSystemjumps(ISystemjumps systemjumps) throws DBException, DataException {
        trans_insertSystemjumps(systemjumps);
        super.Commit2DB();
    }
    
    /**
     * try to update Systemjumps object in database
     * commit transaction
     * @param systemjumps: Systemjumps Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
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
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void secureupdateSystemjumps(ISystemjumps systemjumps) throws DBException, DataException {
        trans_updateSystemjumps(systemjumps);
        super.Commit2DB();
    }
    
    /**
     * try to delete Systemjumps object in database
     * commit transaction
     * @param systemjumps: Systemjumps Entity Object
     * @throws eve.general.exception.CustomException
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
     * @throws eve.general.exception.CustomException
     */
    public void securedeleteSystemjumps(ISystemjumps systemjumps) throws DBException {
        trans_deleteSystemjumps(systemjumps);
        super.Commit2DB();
    }

    /**
     * try to insert Systemjumps object in database
     * do not commit transaction
     * @param systemjumps: Systemjumps Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void trans_insertSystemjumps(ISystemjumps systemjumps) throws DBException, DataException {
        super.checkDATA(systemjumps);
        super.insertSystemjumps((Systemjumps)systemjumps);
    }
    
    /**
     * try to update Systemjumps object in database
     * do not commit transaction
     * @param systemjumps: Systemjumps Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void trans_updateSystemjumps(ISystemjumps systemjumps) throws DBException, DataException {
        super.checkDATA(systemjumps);
        super.updateSystemjumps((Systemjumps)systemjumps);
    }
    
    /**
     * try to delete Systemjumps object in database
     * do not commit transaction
     * @param systemjumps: Systemjumps Entity Object
     * @throws eve.general.exception.CustomException
     */
    public void trans_deleteSystemjumps(ISystemjumps systemjumps) throws DBException {
        super.deleteSystemjumps((Systemjumps)systemjumps);
    }
}
