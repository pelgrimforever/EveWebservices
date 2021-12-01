/*
 * BLtmp_system_jumps.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 25.4.2021 7:57
 *
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import eve.interfaces.logicentity.ITmp_system_jumps;
import eve.logicentity.Tmp_system_jumps;
import BusinessObject.BLtable;
import db.SQLparameters;
import eve.BusinessObject.table.Btmp_system_jumps;
import eve.conversion.entity.EMtmp_system_jumps;
import eve.entity.pk.Security_islandPK;
import eve.entity.pk.Tmp_system_jumpsPK;
import general.exception.DataException;
import java.util.ArrayList;

/**
 * Business Logic Entity class BLtmp_system_jumps
 *
 * Class for manipulating data- and database objects
 * for Entity Tmp_system_jumps and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLtmp_system_jumps extends Btmp_system_jumps {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    /**
     * Constructor, sets Tmp_system_jumps as default Entity
     */
    public BLtmp_system_jumps() {
        this.setLogginrequired(isprivatetable);
    }

    /**
     * Constructor, sets Tmp_system_jumps as default Entity
     * sets transaction queue from given GeneralObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralObjects that holds the transaction queue
     */
    public BLtmp_system_jumps(BLtable transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }

    /**
     * empty tmp_systems_jump
     * copy all system id's linked to security_island
     * @param security_islandPK
     * @throws DBException
     * @throws DataException 
     */
    public void copySystems(Security_islandPK security_islandPK) throws DBException, DataException {
        this.addStatement(EMtmp_system_jumps.SQLDeleteAll);
        this.addStatement(sqlmapper.insertParameters(EMtmp_system_jumps.SQLCopySystems4Security_island, security_islandPK.getSQLprimarykey()));
        this.Commit2DB();
    }
    
    /**
     * set jump field to null for all lines
     * Initiate starting system
     * @throws DBException
     * @throws DataException 
     */
    public void resetJumps(Tmp_system_jumpsPK tmp_system_jumpsPK) throws DBException, DataException {
        //reset all
        this.addStatement(EMtmp_system_jumps.SQLResetJump);
        //update jump field in database
        Tmp_system_jumps system = this.getTmp_system_jumps(tmp_system_jumpsPK);
        system.setJump(0);
        this.trans_updateTmp_system_jumps(system);
        this.Commit2DB();
    }

    /**
     * update max jumps
     * @param tmp_system_jumpsPK
     * @param maxjumps
     * @throws DBException
     * @throws DataException 
     */
    public void setMaxjumps(Tmp_system_jumpsPK tmp_system_jumpsPK, int maxjumps) throws DBException, DataException {
        Tmp_system_jumps system = this.getTmp_system_jumps(tmp_system_jumpsPK);
        system.setMaxjumps(maxjumps);
        this.updateTmp_system_jumps(system);
    }
    
    /**
     * count lines with jump = null
     * @return count
     * @throws DBException 
     */
    public long countNojump() throws DBException {
        return count(EMtmp_system_jumps.SQLSelectnojump, null);
    }
    
    /**
     * search connected systems with jump = null
     * starting systems: systems with matching jump number
     * update with next jump number
     * @param jump: last used jump number
     * @throws DBException
     * @throws DataException 
     */
    public void updateNextjump(int jump) throws DBException, DataException {
        Object[][] parameter = {{ "jump", jump} , { "nextjump", jump+1 } };
        this.addStatement(sqlmapper.insertParameters(EMtmp_system_jumps.SQLSetnextjump, parameter));
        this.Commit2DB();
    }
    
    /**
     * select systems with jump
     * @param jump
     * @return
     * @throws DBException 
     */
    public ArrayList getSystems4jump(int jump) throws DBException {
        Object[][] parameter = { { "jump", jump } };
        SQLparameters sqlparameters = new SQLparameters(parameter);
        return getEntities(EMtmp_system_jumps.SQLSelect4jump, sqlparameters);
    }    
    
    /**
     * try to insert Tmp_system_jumps object in database
     * commit transaction
     * @param tmp_system_jumps: Tmp_system_jumps Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void insertTmp_system_jumps(ITmp_system_jumps tmp_system_jumps) throws DBException, DataException {
        trans_insertTmp_system_jumps(tmp_system_jumps);
        super.Commit2DB();
    }
    
    /**
     * try to insert Tmp_system_jumps object in database
     * an alternative to insertTmp_system_jumps, which can be made an empty function
     * commit transaction
     * @param tmp_system_jumps: Tmp_system_jumps Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureinsertTmp_system_jumps(ITmp_system_jumps tmp_system_jumps) throws DBException, DataException {
        trans_insertTmp_system_jumps(tmp_system_jumps);
        super.Commit2DB();
    }
    
    /**
     * try to update Tmp_system_jumps object in database
     * commit transaction
     * @param tmp_system_jumps: Tmp_system_jumps Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void updateTmp_system_jumps(ITmp_system_jumps tmp_system_jumps) throws DBException, DataException {
        trans_updateTmp_system_jumps(tmp_system_jumps);
        super.Commit2DB();
    }
    
    /**
     * try to update Tmp_system_jumps object in database
     * an alternative to updateTmp_system_jumps, which can be made an empty function
     * commit transaction
     * @param tmp_system_jumps: Tmp_system_jumps Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureupdateTmp_system_jumps(ITmp_system_jumps tmp_system_jumps) throws DBException, DataException {
        trans_updateTmp_system_jumps(tmp_system_jumps);
        super.Commit2DB();
    }
    
    /**
     * try to delete Tmp_system_jumps object in database
     * commit transaction
     * @param tmp_system_jumps: Tmp_system_jumps Entity Object
     * @throws general.exception.DBException
     */
    @Override
    public void deleteTmp_system_jumps(ITmp_system_jumps tmp_system_jumps) throws DBException {
        trans_deleteTmp_system_jumps(tmp_system_jumps);
        super.Commit2DB();
    }

    /**
     * try to delete Tmp_system_jumps object in database
     * an alternative to deleteTmp_system_jumps, which can be made an empty function
     * commit transaction
     * @param tmp_system_jumps: Tmp_system_jumps Entity Object
     * @throws general.exception.DBException
     */
    public void securedeleteTmp_system_jumps(ITmp_system_jumps tmp_system_jumps) throws DBException {
        trans_deleteTmp_system_jumps(tmp_system_jumps);
        super.Commit2DB();
    }

    /**
     * try to insert Tmp_system_jumps object in database
     * do not commit transaction
     * @param tmp_system_jumps: Tmp_system_jumps Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_insertTmp_system_jumps(ITmp_system_jumps tmp_system_jumps) throws DBException, DataException {
        super.checkDATA(tmp_system_jumps);
        super.insertTmp_system_jumps((Tmp_system_jumps)tmp_system_jumps);
    }
    
    /**
     * try to update Tmp_system_jumps object in database
     * do not commit transaction
     * @param tmp_system_jumps: Tmp_system_jumps Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_updateTmp_system_jumps(ITmp_system_jumps tmp_system_jumps) throws DBException, DataException {
        super.checkDATA(tmp_system_jumps);
        super.updateTmp_system_jumps((Tmp_system_jumps)tmp_system_jumps);
    }
    
    /**
     * try to delete Tmp_system_jumps object in database
     * do not commit transaction
     * @param tmp_system_jumps: Tmp_system_jumps Entity Object
     * @throws general.exception.DBException
     */
    public void trans_deleteTmp_system_jumps(ITmp_system_jumps tmp_system_jumps) throws DBException {
        super.deleteTmp_system_jumps((Tmp_system_jumps)tmp_system_jumps);
    }
}
