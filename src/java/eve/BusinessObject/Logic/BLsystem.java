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
import db.AbstractSQLMapper;
import eve.BusinessObject.table.Bsystem;
import eve.data.Swagger;
import eve.entity.pk.ConstellationPK;
import general.exception.DataException;
import eve.interfaces.BusinessObject.IBLsystem;
import eve.interfaces.entity.pk.ISecurity_islandPK;
import general.exception.CustomException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        System system = new System(JSONConversion.getLong(jsonsystemdetails, "system_id"));
        system.setName(JSONConversion.getString(jsonsystemdetails, "name"));
        system.setConstellationPK(new ConstellationPK(JSONConversion.getLong(jsonsystemdetails, "constellation_id")));
        if(jsonsystemdetails.containsKey("security_class")) system.setSecurity_class(JSONConversion.getString(jsonsystemdetails, "security_class"));
        system.setSecurity_status(JSONConversion.getDouble(jsonsystemdetails, "security_status"));
        if(jsonsystemdetails.containsKey("star_id")) system.setStar_id(JSONConversion.getLong(jsonsystemdetails, "star_id"));
        this.insertupdateSystem(system);
    }

    public void updateborders() throws DBException, DataException {
        Object[][] parameter = { { "isborder", true } };
        this.transactionqueue.addStatement(this.getClass().getSimpleName(), System.SQLupdateconstellationborders, parameter);
        this.transactionqueue.addStatement(this.getClass().getSimpleName(), System.SQLupdateregionborders, parameter);
        this.Commit2DB();
    }

    /**
     * get all system from high security that needs to be assigned to an island
     * security_status >= Swagger.EVE_HIGHSEC_LIMIT
     * security_island = null
     * @return
     * @throws DBException 
     */
    public ArrayList GetSystems_HiSecNoislands() throws DBException {
        Object[][] parameter = { { "highsec", Swagger.EVE_HIGHSEC_LIMIT } };
        return getMapper().loadEntityVector(this, System.SQLSelectHiSecNoIsland, parameter);
    }
    
    /**
     * post process downloaded system data
     * set noaccess to true for all systems that have no stargate
     * set noaccess to false for all systems that have a stargate
     * @throws DBException
     * @throws DataException 
     */
    public void postprocess() throws DBException, DataException {
        Object[][] parameter1 = {{ "noaccess", true }};
        this.transactionqueue.addStatement(this.getClass().getSimpleName(), System.updateNoaccess1, parameter1);
        Object[][] parameter2 = {{ "noaccess", false }};
        this.transactionqueue.addStatement(this.getClass().getSimpleName(), System.updateNoaccess2, parameter2);
        this.Commit2DB();
    }
    
    /**
     * Select connected systems to security_island not assigned to a security_island
     * @param security_islandPK: foreign key for Security_island
     * @return all System Entity objects for Security_island
     * @throws eve.general.exception.CustomException
     */
    public ArrayList getHiSecConnectedSystems(ISecurity_islandPK security_islandPK) throws CustomException {
        Object[][] parameter = { { "highsec", Swagger.EVE_HIGHSEC_LIMIT } };
        parameter = AbstractSQLMapper.addKeyArrays(parameter, security_islandPK.getKeyFields());
        return getMapper().loadEntityVector(this, System.SQLSelectHiSecSystemsConnected, parameter);
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
