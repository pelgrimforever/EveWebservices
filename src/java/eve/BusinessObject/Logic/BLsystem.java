/*
 * BLsystem.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 4.4.2021 14:28
 *
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import data.interfaces.db.LogicEntity;
import eve.interfaces.logicentity.ISystem;
import eve.logicentity.System;
import BusinessObject.GeneralEntityObject;
import data.conversion.JSONConversion;
import eve.BusinessObject.table.Bsystem;
import eve.entity.pk.ConstellationPK;
import general.exception.DataException;
import eve.interfaces.BusinessObject.IBLsystem;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.json.simple.JSONObject;

/**
 * Business Logic Entity class BLsystem
 *
 * Class for manipulating data- and database objects
 * for Entity System and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLsystem extends Bsystem implements IBLsystem {
//ProjectGenerator: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    /**
     * Constructor, sets System as default Entity
     */
    public BLsystem() {
        this.setLogginrequired(isprivatetable);
    }

    /**
     * Constructor, sets System as default Entity
     * sets transaction queue from given GeneralObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralObjects that holds the transaction queue
     */
    public BLsystem(GeneralEntityObject transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }

    /**
     * load extra fields from adjusted sql statement
     */
    @Override
    public void loadExtra(ResultSet dbresult, LogicEntity system) throws SQLException {
        
    }
    
    public void updateSystem(JSONObject jsonsystemdetails) throws DBException, DataException {
        java.lang.System.out.println("System " + JSONConversion.getLong(jsonsystemdetails, "system_id"));
        System system = new System(JSONConversion.getLong(jsonsystemdetails, "system_id"));
        system.setName(JSONConversion.getString(jsonsystemdetails, "name"));
        system.setConstellationPK(new ConstellationPK(JSONConversion.getLong(jsonsystemdetails, "constellation_id")));
        if(jsonsystemdetails.containsKey("security_class")) system.setSecurity_class(JSONConversion.getString(jsonsystemdetails, "security_class"));
        system.setSecurity_status(JSONConversion.getDouble(jsonsystemdetails, "security_status"));
        if(jsonsystemdetails.containsKey("star_id")) system.setStar_id(JSONConversion.getLong(jsonsystemdetails, "star_id"));
        java.lang.System.out.println("       " + system.getName());
        this.insertupdateSystem(system);
    }

    /**
     * try to insert System object in database
     * commit transaction
     * @param system: System Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    @Override
    public void insertSystem(ISystem system) throws DBException, DataException {
        trans_insertSystem(system);
        super.Commit2DB();
    }
    
    /**
     * try to insert System object in database
     * an alternative to insertSystem, which can be made an empty function
     * commit transaction
     * @param system: System Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void secureinsertSystem(ISystem system) throws DBException, DataException {
        trans_insertSystem(system);
        super.Commit2DB();
    }
    
    /**
     * try to update System object in database
     * commit transaction
     * @param system: System Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    @Override
    public void updateSystem(ISystem system) throws DBException, DataException {
        trans_updateSystem(system);
        super.Commit2DB();
    }
    
    /**
     * try to update System object in database
     * an alternative to updateSystem, which can be made an empty function
     * commit transaction
     * @param system: System Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void secureupdateSystem(ISystem system) throws DBException, DataException {
        trans_updateSystem(system);
        super.Commit2DB();
    }
    
    /**
     * try to delete System object in database
     * commit transaction
     * @param system: System Entity Object
     * @throws eve.general.exception.CustomException
     */
    @Override
    public void deleteSystem(ISystem system) throws DBException {
        trans_deleteSystem(system);
        super.Commit2DB();
    }

    /**
     * try to delete System object in database
     * an alternative to deleteSystem, which can be made an empty function
     * commit transaction
     * @param system: System Entity Object
     * @throws eve.general.exception.CustomException
     */
    public void securedeleteSystem(ISystem system) throws DBException {
        trans_deleteSystem(system);
        super.Commit2DB();
    }

    /**
     * try to insert System object in database
     * do not commit transaction
     * @param system: System Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void trans_insertSystem(ISystem system) throws DBException, DataException {
        super.checkDATA(system);
        super.insertSystem((System)system);
    }
    
    /**
     * try to update System object in database
     * do not commit transaction
     * @param system: System Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void trans_updateSystem(ISystem system) throws DBException, DataException {
        super.checkDATA(system);
        super.updateSystem((System)system);
    }
    
    /**
     * try to delete System object in database
     * do not commit transaction
     * @param system: System Entity Object
     * @throws eve.general.exception.CustomException
     */
    public void trans_deleteSystem(ISystem system) throws DBException {
        super.deleteSystem((System)system);
    }
}
