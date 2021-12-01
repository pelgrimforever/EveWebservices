/*
 * BLsystemtrade.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 27.5.2021 17:5
 *
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import eve.interfaces.logicentity.ISystemtrade;
import eve.logicentity.Systemtrade;
import BusinessObject.BLtable;
import db.SQLparameters;
import db.TransactionOutput;
import eve.BusinessObject.table.Bsystemtrade;
import eve.conversion.entity.EMsystemtrade;
import eve.conversion.entity.EMsystemtrade_order;
import eve.entity.pk.Security_islandPK;
import general.exception.DataException;
import java.util.ArrayList;

/**
 * Business Logic Entity class BLsystemtrade
 *
 * Class for manipulating data- and database objects
 * for Entity Systemtrade and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLsystemtrade extends Bsystemtrade {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    /**
     * Constructor, sets Systemtrade as default Entity
     */
    public BLsystemtrade() {
        this.setLogginrequired(isprivatetable);
    }

    /**
     * Constructor, sets Systemtrade as default Entity
     * sets transaction queue from given GeneralObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralObjects that holds the transaction queue
     */
    public BLsystemtrade(BLtable transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }

    /**
     * delete all from systemtrade and systemtrade_order
     * @throws DBException
     * @throws DataException 
     */
    public void deletesystemtrade() throws DBException, DataException {
        this.addStatement(EMsystemtrade_order.SQLdeleteall);
        this.addStatement(EMsystemtrade.SQLdeleteall);
        this.Commit2DB();
    }
    
    /**
     * copy tradeorders from view_systemtradeorders to systemtrade for next parameters
     * @param security_islandPK: security island primary key
     * @param max_cargovolume: max allowed cargo volume
     * @param net_perc: net percentage of buy order price
     * @param min_profit_per_jump
     * @return TransactionOutput
     * @throws DBException 
     */
    public TransactionOutput copySystemtradeorders(Security_islandPK security_islandPK, float max_cargovolume, float net_perc, long min_profit_per_jump) throws DBException {
        Object[][] parameter = { { "max_cargovolume", max_cargovolume }, { "net_perc", net_perc }, { "min_profit_per_jump", min_profit_per_jump } };
        SQLparameters sqlparameters = new SQLparameters(parameter);
        sqlparameters.add(security_islandPK.getSQLprimarykey());
        this.addStatement(EMsystemtrade.SQLInsertSystemtrade, sqlparameters);
        return this.Commit2DB();
    }
    
    /**
     * get tradeorders from view_systemtradeorders for next parameters
     * ordered by sell_system, for algorithm convenience
     * @param security_islandPK: security island primary key
     * @param max_cargovolume: max allowed cargo volume
     * @param net_perc: net percentage of buy order price
     * @param min_profit: min profit condition to copy
     * @return TransactionOutput
     * @throws DBException 
     */
    public ArrayList getSystemtradeorders(Security_islandPK security_islandPK, float max_cargovolume, float net_perc, long min_profit) throws DBException {
        Object[][] parameter = { { "max_cargovolume", max_cargovolume }, { "net_perc", net_perc }, { "min_profit", min_profit } };
        SQLparameters sqlparameters = new SQLparameters(parameter);
        sqlparameters.add(security_islandPK.getSQLprimarykey());
        return getEntities(EMsystemtrade.SQLSelectSystemtrade, sqlparameters);
    }
    
    /**
     * try to insert Systemtrade object in database
     * commit transaction
     * @param systemtrade: Systemtrade Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void insertSystemtrade(ISystemtrade systemtrade) throws DBException, DataException {
        trans_insertSystemtrade(systemtrade);
        super.Commit2DB();
    }
    
    /**
     * try to insert Systemtrade object in database
     * an alternative to insertSystemtrade, which can be made an empty function
     * commit transaction
     * @param systemtrade: Systemtrade Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureinsertSystemtrade(ISystemtrade systemtrade) throws DBException, DataException {
        trans_insertSystemtrade(systemtrade);
        super.Commit2DB();
    }
    
    /**
     * try to update Systemtrade object in database
     * commit transaction
     * @param systemtrade: Systemtrade Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void updateSystemtrade(ISystemtrade systemtrade) throws DBException, DataException {
        trans_updateSystemtrade(systemtrade);
        super.Commit2DB();
    }
    
    /**
     * try to update Systemtrade object in database
     * an alternative to updateSystemtrade, which can be made an empty function
     * commit transaction
     * @param systemtrade: Systemtrade Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureupdateSystemtrade(ISystemtrade systemtrade) throws DBException, DataException {
        trans_updateSystemtrade(systemtrade);
        super.Commit2DB();
    }
    
    /**
     * try to delete Systemtrade object in database
     * commit transaction
     * @param systemtrade: Systemtrade Entity Object
     * @throws general.exception.DBException
     */
    @Override
    public void deleteSystemtrade(ISystemtrade systemtrade) throws DBException {
        trans_deleteSystemtrade(systemtrade);
        super.Commit2DB();
    }

    /**
     * try to delete Systemtrade object in database
     * an alternative to deleteSystemtrade, which can be made an empty function
     * commit transaction
     * @param systemtrade: Systemtrade Entity Object
     * @throws general.exception.DBException
     */
    public void securedeleteSystemtrade(ISystemtrade systemtrade) throws DBException {
        trans_deleteSystemtrade(systemtrade);
        super.Commit2DB();
    }

    /**
     * try to insert Systemtrade object in database
     * do not commit transaction
     * @param systemtrade: Systemtrade Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_insertSystemtrade(ISystemtrade systemtrade) throws DBException, DataException {
        super.checkDATA(systemtrade);
        super.insertSystemtrade((Systemtrade)systemtrade);
    }
    
    /**
     * try to update Systemtrade object in database
     * do not commit transaction
     * @param systemtrade: Systemtrade Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_updateSystemtrade(ISystemtrade systemtrade) throws DBException, DataException {
        super.checkDATA(systemtrade);
        super.updateSystemtrade((Systemtrade)systemtrade);
    }
    
    /**
     * try to delete Systemtrade object in database
     * do not commit transaction
     * @param systemtrade: Systemtrade Entity Object
     * @throws general.exception.DBException
     */
    public void trans_deleteSystemtrade(ISystemtrade systemtrade) throws DBException {
        super.deleteSystemtrade((Systemtrade)systemtrade);
    }
}
