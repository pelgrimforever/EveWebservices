/*
 * BLsystemtrade.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 27.5.2021 17:5
 *
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import data.interfaces.db.LogicEntity;
import eve.interfaces.logicentity.ISystemtrade;
import eve.logicentity.Systemtrade;
import BusinessObject.GeneralEntityObject;
import db.AbstractSQLMapper;
import db.TransactionOutput;
import eve.BusinessObject.table.Bsystemtrade;
import eve.entity.pk.Security_islandPK;
import general.exception.DataException;
import eve.interfaces.BusinessObject.IBLsystemtrade;
import eve.logicentity.Systemtrade_order;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class BLsystemtrade extends Bsystemtrade implements IBLsystemtrade {
//ProjectGenerator: NO AUTHOMATIC UPDATE
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
    public BLsystemtrade(GeneralEntityObject transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }

    /**
     * load extra fields from adjusted sql statement
     */
    @Override
    public void loadExtra(ResultSet dbresult, LogicEntity systemtrade) throws SQLException {
        
    }
    
    /**
     * delete all from systemtrade and systemtrade_order
     * @throws DBException
     * @throws DataException 
     */
    public void deletesystemtrade() throws DBException, DataException {
        this.transactionqueue.addStatement(this.getClass().getSimpleName(), Systemtrade_order.SQLdeleteall, null);
        this.transactionqueue.addStatement(this.getClass().getSimpleName(), Systemtrade.SQLdeleteall, null);
        this.Commit2DB();
    }
    
    /**
     * copy tradeorders from view_systemtradeorders to systemtrade for next parameters
     * @param security_islandPK: security island primary key
     * @param max_cargovolume: max allowed cargo volume
     * @param net_perc: net percentage of buy order price
     * @param min_profit: min profit condition to copy
     * @return TransactionOutput
     * @throws DBException 
     */
    public TransactionOutput copySystemtradeorders(Security_islandPK security_islandPK, float max_cargovolume, float net_perc, long min_profit_per_jump) throws DBException {
        Object[][] parameter = { { "max_cargovolume", max_cargovolume }, { "net_perc", net_perc }, { "min_profit_per_jump", min_profit_per_jump } };
        parameter = AbstractSQLMapper.addKeyArrays(parameter, security_islandPK.getKeyFields());
        transactionqueue.addStatement(this.getClass().getName(), Systemtrade.SQLInsertSystemtrade, parameter);
        return this.Commit2DB_returnSQL();
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
        parameter = AbstractSQLMapper.addKeyArrays(parameter, security_islandPK.getKeyFields());
        return this.getMapper().loadEntityVector(this, Systemtrade.SQLSelectSystemtrade, parameter);
    }
    
    /**
     * try to insert Systemtrade object in database
     * commit transaction
     * @param systemtrade: Systemtrade Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
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
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void secureinsertSystemtrade(ISystemtrade systemtrade) throws DBException, DataException {
        trans_insertSystemtrade(systemtrade);
        super.Commit2DB();
    }
    
    /**
     * try to update Systemtrade object in database
     * commit transaction
     * @param systemtrade: Systemtrade Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
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
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void secureupdateSystemtrade(ISystemtrade systemtrade) throws DBException, DataException {
        trans_updateSystemtrade(systemtrade);
        super.Commit2DB();
    }
    
    /**
     * try to delete Systemtrade object in database
     * commit transaction
     * @param systemtrade: Systemtrade Entity Object
     * @throws eve.general.exception.CustomException
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
     * @throws eve.general.exception.CustomException
     */
    public void securedeleteSystemtrade(ISystemtrade systemtrade) throws DBException {
        trans_deleteSystemtrade(systemtrade);
        super.Commit2DB();
    }

    /**
     * try to insert Systemtrade object in database
     * do not commit transaction
     * @param systemtrade: Systemtrade Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void trans_insertSystemtrade(ISystemtrade systemtrade) throws DBException, DataException {
        super.checkDATA(systemtrade);
        super.insertSystemtrade((Systemtrade)systemtrade);
    }
    
    /**
     * try to update Systemtrade object in database
     * do not commit transaction
     * @param systemtrade: Systemtrade Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void trans_updateSystemtrade(ISystemtrade systemtrade) throws DBException, DataException {
        super.checkDATA(systemtrade);
        super.updateSystemtrade((Systemtrade)systemtrade);
    }
    
    /**
     * try to delete Systemtrade object in database
     * do not commit transaction
     * @param systemtrade: Systemtrade Entity Object
     * @throws eve.general.exception.CustomException
     */
    public void trans_deleteSystemtrade(ISystemtrade systemtrade) throws DBException {
        super.deleteSystemtrade((Systemtrade)systemtrade);
    }
}
