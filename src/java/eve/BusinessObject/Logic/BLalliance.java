/*
 * BLalliance.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 15.4.2021 19:21
 *
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import eve.interfaces.logicentity.IAlliance;
import eve.logicentity.Alliance;
import BusinessObject.BLtable;
import data.conversion.JSONConversion;
import eve.BusinessObject.table.Balliance;
import eve.data.Swagger;
import eve.entity.pk.CorporationPK;
import general.exception.DataException;
import org.json.simple.JSONObject;

/**
 * Business Logic Entity class BLalliance
 *
 * Class for manipulating data- and database objects
 * for Entity Alliance and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLalliance extends Balliance {
//ProjectGenerator: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    /**
     * Constructor, sets Alliance as default Entity
     */
    public BLalliance() {
        this.setLogginrequired(isprivatetable);
    }

    /**
     * Constructor, sets Alliance as default Entity
     * sets transaction queue from given GeneralObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralObjects that holds the transaction queue
     */
    public BLalliance(BLtable transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }

    public void updateAlliance(JSONObject jsonalliancedetails) throws DBException, DataException {
        Alliance alliance = new Alliance(JSONConversion.getLong(jsonalliancedetails, "alliance_id"));
        alliance.setName(JSONConversion.getString(jsonalliancedetails, "name"));
        alliance.setTicker(JSONConversion.getString(jsonalliancedetails, "ticker"));
        alliance.setCreator(JSONConversion.getLong(jsonalliancedetails, "creator_id"));
        alliance.setCorporationcreator_corporationPK(new CorporationPK(JSONConversion.getLong(jsonalliancedetails, "creator_corporation_id")));
        String stringdatefounded = JSONConversion.getString(jsonalliancedetails, "date_founded");
        alliance.setDate_founded(Swagger.datetimestring2Timestamp(stringdatefounded));
        if(jsonalliancedetails.containsKey("executor_corporation_id")) alliance.setCorporationexecutor_corporationPK(new CorporationPK(JSONConversion.getLong(jsonalliancedetails, "executor_corporation_id")));
        if(jsonalliancedetails.containsKey("faction_id")) alliance.setFaction_id(JSONConversion.getLong(jsonalliancedetails, "faction_id"));
        this.insertupdateAlliance(alliance);
    }

    /**
     * try to insert Alliance object in database
     * commit transaction
     * @param alliance: Alliance Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    @Override
    public void insertAlliance(IAlliance alliance) throws DBException, DataException {
        trans_insertAlliance(alliance);
        super.Commit2DB();
    }
    
    /**
     * try to insert Alliance object in database
     * an alternative to insertAlliance, which can be made an empty function
     * commit transaction
     * @param alliance: Alliance Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void secureinsertAlliance(IAlliance alliance) throws DBException, DataException {
        trans_insertAlliance(alliance);
        super.Commit2DB();
    }
    
    /**
     * try to update Alliance object in database
     * commit transaction
     * @param alliance: Alliance Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    @Override
    public void updateAlliance(IAlliance alliance) throws DBException, DataException {
        trans_updateAlliance(alliance);
        super.Commit2DB();
    }
    
    /**
     * try to update Alliance object in database
     * an alternative to updateAlliance, which can be made an empty function
     * commit transaction
     * @param alliance: Alliance Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void secureupdateAlliance(IAlliance alliance) throws DBException, DataException {
        trans_updateAlliance(alliance);
        super.Commit2DB();
    }
    
    /**
     * try to delete Alliance object in database
     * commit transaction
     * @param alliance: Alliance Entity Object
     * @throws eve.general.exception.CustomException
     */
    @Override
    public void deleteAlliance(IAlliance alliance) throws DBException {
        trans_deleteAlliance(alliance);
        super.Commit2DB();
    }

    /**
     * try to delete Alliance object in database
     * an alternative to deleteAlliance, which can be made an empty function
     * commit transaction
     * @param alliance: Alliance Entity Object
     * @throws eve.general.exception.CustomException
     */
    public void securedeleteAlliance(IAlliance alliance) throws DBException {
        trans_deleteAlliance(alliance);
        super.Commit2DB();
    }

    /**
     * try to insert Alliance object in database
     * do not commit transaction
     * @param alliance: Alliance Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void trans_insertAlliance(IAlliance alliance) throws DBException, DataException {
        super.checkDATA(alliance);
        super.insertAlliance((Alliance)alliance);
    }
    
    /**
     * try to update Alliance object in database
     * do not commit transaction
     * @param alliance: Alliance Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void trans_updateAlliance(IAlliance alliance) throws DBException, DataException {
        super.checkDATA(alliance);
        super.updateAlliance((Alliance)alliance);
    }
    
    /**
     * try to delete Alliance object in database
     * do not commit transaction
     * @param alliance: Alliance Entity Object
     * @throws eve.general.exception.CustomException
     */
    public void trans_deleteAlliance(IAlliance alliance) throws DBException {
        super.deleteAlliance((Alliance)alliance);
    }
}
