/*
 * BLstargate.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 18.4.2021 16:59
 *
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import eve.interfaces.logicentity.IStargate;
import eve.logicentity.Stargate;
import BusinessObject.BLtable;
import data.conversion.JSONConversion;
import eve.BusinessObject.table.Bstargate;
import eve.conversion.entity.EMstargate;
import eve.entity.pk.SystemPK;
import general.exception.DataException;
import eve.interfaces.entity.pk.ISystemPK;
import general.exception.CustomException;
import java.util.ArrayList;
import org.json.simple.JSONObject;

/**
 * Business Logic Entity class BLstargate
 *
 * Class for manipulating data- and database objects
 * for Entity Stargate and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLstargate extends Bstargate {
//ProjectGenerator: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    /**
     * Constructor, sets Stargate as default Entity
     */
    public BLstargate() {
        this.setLogginrequired(isprivatetable);
    }

    /**
     * Constructor, sets Stargate as default Entity
     * sets transaction queue from given GeneralObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralObjects that holds the transaction queue
     */
    public BLstargate(BLtable transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }

    public void updateStargate(JSONObject jsonstargatedetails) throws DBException, DataException {
        if(jsonstargatedetails==null) {
            System.out.print("stargate data null");
        }
        Stargate stargate = new Stargate(JSONConversion.getLong(jsonstargatedetails, "stargate_id"));
        stargate.setName(JSONConversion.getString(jsonstargatedetails, "name"));
        stargate.setSystemsystemPK(new SystemPK(JSONConversion.getLong(jsonstargatedetails, "system_id")));
        JSONObject jsondestination = (JSONObject)jsonstargatedetails.get("destination");
        if(jsondestination==null) {
            System.out.print("destination null");
        }
        stargate.setTo_stargate(JSONConversion.getLong(jsondestination, "stargate_id"));
        stargate.setSystemto_systemPK(new SystemPK(JSONConversion.getLong(jsondestination, "system_id")));
        JSONObject jsonposition = (JSONObject)jsonstargatedetails.get("position");
        if(jsondestination==null) {
            System.out.print("jsonposition null");
        }
        stargate.setX(JSONConversion.getDouble(jsonposition, "x"));
        stargate.setY(JSONConversion.getDouble(jsonposition, "y"));
        stargate.setZ(JSONConversion.getDouble(jsonposition, "z"));
        this.insertupdateStargate(stargate);
    }

    public void updateborders() throws DBException, DataException {
        Object[][] parameter = { { "isborder", true } };
        this.addStatement(sqlmapper.insertParameters(EMstargate.SQLupdateconstellationborders, parameter));
        this.addStatement(sqlmapper.insertParameters(EMstargate.SQLupdateregionborders, parameter));
        this.Commit2DB();
    }
    
    /**
     * @param systemPK: foreign key for System
     * @return all Stargate Entity objects for System
     * @throws general.exception.CustomException
     */
    public long getStargates4systemcount(ISystemPK systemPK) throws CustomException {
        return count(EMstargate.SQLSelect4systemCount, systemPK.getSQLprimarykey());
    }
    
    /**
     * find a previous stargate for given system in the tmp configuration
     * @param systemPK
     * @return stargate or null
     * @throws CustomException 
     */
    public Stargate getPreviousGate(SystemPK systemPK) throws CustomException {
        Stargate stargate = null;
        ArrayList stargates = getEntities(EMstargate.SQLselectpreviousTMP, systemPK.getSQLprimarykey());
        if(stargates.size()>0) {
            stargate = (Stargate)stargates.get(0);
        }
        return stargate;
    }

    /**
     * try to insert Stargate object in database
     * commit transaction
     * @param stargate: Stargate Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void insertStargate(IStargate stargate) throws DBException, DataException {
        trans_insertStargate(stargate);
        super.Commit2DB();
    }
    
    /**
     * try to insert Stargate object in database
     * an alternative to insertStargate, which can be made an empty function
     * commit transaction
     * @param stargate: Stargate Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureinsertStargate(IStargate stargate) throws DBException, DataException {
        trans_insertStargate(stargate);
        super.Commit2DB();
    }
    
    /**
     * try to update Stargate object in database
     * commit transaction
     * @param stargate: Stargate Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void updateStargate(IStargate stargate) throws DBException, DataException {
        trans_updateStargate(stargate);
        super.Commit2DB();
    }
    
    /**
     * try to update Stargate object in database
     * an alternative to updateStargate, which can be made an empty function
     * commit transaction
     * @param stargate: Stargate Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureupdateStargate(IStargate stargate) throws DBException, DataException {
        trans_updateStargate(stargate);
        super.Commit2DB();
    }
    
    /**
     * try to delete Stargate object in database
     * commit transaction
     * @param stargate: Stargate Entity Object
     * @throws eve.general.exception.CustomException
     */
    @Override
    public void deleteStargate(IStargate stargate) throws DBException {
        trans_deleteStargate(stargate);
        super.Commit2DB();
    }

    /**
     * try to delete Stargate object in database
     * an alternative to deleteStargate, which can be made an empty function
     * commit transaction
     * @param stargate: Stargate Entity Object
     * @throws general.exception.DBException
     */
    public void securedeleteStargate(IStargate stargate) throws DBException {
        trans_deleteStargate(stargate);
        super.Commit2DB();
    }

    /**
     * try to insert Stargate object in database
     * do not commit transaction
     * @param stargate: Stargate Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_insertStargate(IStargate stargate) throws DBException, DataException {
        super.checkDATA(stargate);
        super.insertStargate((Stargate)stargate);
    }
    
    /**
     * try to update Stargate object in database
     * do not commit transaction
     * @param stargate: Stargate Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_updateStargate(IStargate stargate) throws DBException, DataException {
        super.checkDATA(stargate);
        super.updateStargate((Stargate)stargate);
    }
    
    /**
     * try to delete Stargate object in database
     * do not commit transaction
     * @param stargate: Stargate Entity Object
     * @throws general.exception.DBException
     */
    public void trans_deleteStargate(IStargate stargate) throws DBException {
        super.deleteStargate((Stargate)stargate);
    }
}
