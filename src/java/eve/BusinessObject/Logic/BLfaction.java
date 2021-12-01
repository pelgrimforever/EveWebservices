/*
 * BLfaction.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 17.4.2021 16:19
 *
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import eve.interfaces.logicentity.IFaction;
import eve.logicentity.Faction;
import BusinessObject.BLtable;
import data.conversion.JSONConversion;
import eve.BusinessObject.table.Bfaction;
import eve.entity.pk.SystemPK;
import general.exception.DataException;
import org.json.simple.JSONObject;

/**
 * Business Logic Entity class BLfaction
 *
 * Class for manipulating data- and database objects
 * for Entity Faction and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLfaction extends Bfaction {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    /**
     * Constructor, sets Faction as default Entity
     */
    public BLfaction() {
        this.setLogginrequired(isprivatetable);
    }

    /**
     * Constructor, sets Faction as default Entity
     * sets transaction queue from given GeneralObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralObjects that holds the transaction queue
     */
    public BLfaction(BLtable transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }

    public void updateFaction(JSONObject jsonfactiondetails) throws DBException, DataException {
        Faction faction = new Faction(JSONConversion.getLong(jsonfactiondetails, "faction_id"));
        faction.setName(JSONConversion.getString(jsonfactiondetails, "name"));
        faction.setDescription(JSONConversion.getString(jsonfactiondetails, "description"));
        faction.setIs_unique(JSONConversion.getboolean(jsonfactiondetails, "is_unique"));
        faction.setSize_factor(JSONConversion.getDouble(jsonfactiondetails, "size_factor"));
        faction.setStation_count(JSONConversion.getint(jsonfactiondetails, "station_count"));
        faction.setStation_system_count(JSONConversion.getint(jsonfactiondetails, "station_system_count"));
        if(jsonfactiondetails.containsKey("corporation_id")) faction.setCorporation(JSONConversion.getLong(jsonfactiondetails, "corporation_id"));
        if(jsonfactiondetails.containsKey("militia_corporation_id")) faction.setMilitia_corporation(JSONConversion.getLong(jsonfactiondetails, "militia_corporation_id"));
        if(jsonfactiondetails.containsKey("solar_system_id")) faction.setSystemPK(new SystemPK(JSONConversion.getLong(jsonfactiondetails, "solar_system_id")));
        this.insertupdateFaction(faction);
    }

    /**
     * try to insert Faction object in database
     * commit transaction
     * @param faction: Faction Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    @Override
    public void insertFaction(IFaction faction) throws DBException, DataException {
        trans_insertFaction(faction);
        super.Commit2DB();
    }
    
    /**
     * try to insert Faction object in database
     * an alternative to insertFaction, which can be made an empty function
     * commit transaction
     * @param faction: Faction Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void secureinsertFaction(IFaction faction) throws DBException, DataException {
        trans_insertFaction(faction);
        super.Commit2DB();
    }
    
    /**
     * try to update Faction object in database
     * commit transaction
     * @param faction: Faction Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    @Override
    public void updateFaction(IFaction faction) throws DBException, DataException {
        trans_updateFaction(faction);
        super.Commit2DB();
    }
    
    /**
     * try to update Faction object in database
     * an alternative to updateFaction, which can be made an empty function
     * commit transaction
     * @param faction: Faction Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void secureupdateFaction(IFaction faction) throws DBException, DataException {
        trans_updateFaction(faction);
        super.Commit2DB();
    }
    
    /**
     * try to delete Faction object in database
     * commit transaction
     * @param faction: Faction Entity Object
     * @throws eve.general.exception.CustomException
     */
    @Override
    public void deleteFaction(IFaction faction) throws DBException {
        trans_deleteFaction(faction);
        super.Commit2DB();
    }

    /**
     * try to delete Faction object in database
     * an alternative to deleteFaction, which can be made an empty function
     * commit transaction
     * @param faction: Faction Entity Object
     * @throws eve.general.exception.CustomException
     */
    public void securedeleteFaction(IFaction faction) throws DBException {
        trans_deleteFaction(faction);
        super.Commit2DB();
    }

    /**
     * try to insert Faction object in database
     * do not commit transaction
     * @param faction: Faction Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void trans_insertFaction(IFaction faction) throws DBException, DataException {
        super.checkDATA(faction);
        super.insertFaction((Faction)faction);
    }
    
    /**
     * try to update Faction object in database
     * do not commit transaction
     * @param faction: Faction Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void trans_updateFaction(IFaction faction) throws DBException, DataException {
        super.checkDATA(faction);
        super.updateFaction((Faction)faction);
    }
    
    /**
     * try to delete Faction object in database
     * do not commit transaction
     * @param faction: Faction Entity Object
     * @throws eve.general.exception.CustomException
     */
    public void trans_deleteFaction(IFaction faction) throws DBException {
        super.deleteFaction((Faction)faction);
    }
}
