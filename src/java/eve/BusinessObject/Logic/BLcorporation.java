/*
 * BLcorporation.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 17.4.2021 16:19
 *
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import data.interfaces.db.LogicEntity;
import eve.interfaces.logicentity.ICorporation;
import eve.logicentity.Corporation;
import BusinessObject.GeneralEntityObject;
import data.conversion.JSONConversion;
import eve.BusinessObject.table.Bcorporation;
import eve.data.Swagger;
import eve.entity.pk.AlliancePK;
import eve.entity.pk.FactionPK;
import eve.entity.pk.StationPK;
import general.exception.DataException;
import eve.interfaces.BusinessObject.IBLcorporation;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import org.json.simple.JSONObject;

/**
 * Business Logic Entity class BLcorporation
 *
 * Class for manipulating data- and database objects
 * for Entity Corporation and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLcorporation extends Bcorporation implements IBLcorporation {
//ProjectGenerator: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    /**
     * Constructor, sets Corporation as default Entity
     */
    public BLcorporation() {
        this.setLogginrequired(isprivatetable);
    }

    /**
     * Constructor, sets Corporation as default Entity
     * sets transaction queue from given GeneralObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralObjects that holds the transaction queue
     */
    public BLcorporation(GeneralEntityObject transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }

    /**
     * load extra fields from adjusted sql statement
     */
    @Override
    public void loadExtra(ResultSet dbresult, LogicEntity corporation) throws SQLException {
        
    }
    
    public void updateCorporation(JSONObject jsoncorporationdetails) throws DBException, DataException {
        System.out.println("Corporation " + JSONConversion.getLong(jsoncorporationdetails, "corporation_id"));
        Corporation corporation = new Corporation(JSONConversion.getLong(jsoncorporationdetails, "corporation_id"));
        corporation.setName(JSONConversion.getString(jsoncorporationdetails, "name"));
        corporation.setTicker(JSONConversion.getString(jsoncorporationdetails, "ticker"));
        if(jsoncorporationdetails.containsKey("description")) corporation.setDescription(JSONConversion.getString(jsoncorporationdetails, "description"));
        corporation.setCreator(JSONConversion.getLong(jsoncorporationdetails, "creator_id"));
        corporation.setCeo(JSONConversion.getLong(jsoncorporationdetails, "ceo_id"));
        corporation.setMember_count(JSONConversion.getint(jsoncorporationdetails, "member_count"));
        corporation.setTax_rate(JSONConversion.getDouble(jsoncorporationdetails, "tax_rate"));
        if(jsoncorporationdetails.containsKey("alliance_id")) corporation.setAlliancePK(new AlliancePK(JSONConversion.getLong(jsoncorporationdetails, "alliance_id")));
        if(jsoncorporationdetails.containsKey("date_founded")) {
            String stringdatefounded = JSONConversion.getString(jsoncorporationdetails, "date_founded");
            corporation.setDate_founded(Swagger.datetimestring2Timestamp(stringdatefounded));
        }
        if(jsoncorporationdetails.containsKey("faction_id")) corporation.setFactionPK(new FactionPK(JSONConversion.getLong(jsoncorporationdetails, "faction_id")));
        if(jsoncorporationdetails.containsKey("home_station_id")) corporation.setStationPK(new StationPK(JSONConversion.getLong(jsoncorporationdetails, "home_station_id")));
        if(jsoncorporationdetails.containsKey("shares")) corporation.setMember_count(JSONConversion.getint(jsoncorporationdetails, "shares"));
        if(jsoncorporationdetails.containsKey("url")) corporation.setUrl(JSONConversion.getString(jsoncorporationdetails, "url"));
        if(jsoncorporationdetails.containsKey("war_eligible")) corporation.setWar_eligible(JSONConversion.getboolean(jsoncorporationdetails, "war_eligible"));
        System.out.println("       " + corporation.getName());
        this.insertupdateCorporation(corporation);
    }

    /**
     * try to insert Corporation object in database
     * commit transaction
     * @param corporation: Corporation Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    @Override
    public void insertCorporation(ICorporation corporation) throws DBException, DataException {
        trans_insertCorporation(corporation);
        super.Commit2DB();
    }
    
    /**
     * try to insert Corporation object in database
     * an alternative to insertCorporation, which can be made an empty function
     * commit transaction
     * @param corporation: Corporation Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void secureinsertCorporation(ICorporation corporation) throws DBException, DataException {
        trans_insertCorporation(corporation);
        super.Commit2DB();
    }
    
    /**
     * try to update Corporation object in database
     * commit transaction
     * @param corporation: Corporation Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    @Override
    public void updateCorporation(ICorporation corporation) throws DBException, DataException {
        trans_updateCorporation(corporation);
        super.Commit2DB();
    }
    
    /**
     * try to update Corporation object in database
     * an alternative to updateCorporation, which can be made an empty function
     * commit transaction
     * @param corporation: Corporation Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void secureupdateCorporation(ICorporation corporation) throws DBException, DataException {
        trans_updateCorporation(corporation);
        super.Commit2DB();
    }
    
    /**
     * try to delete Corporation object in database
     * commit transaction
     * @param corporation: Corporation Entity Object
     * @throws eve.general.exception.CustomException
     */
    @Override
    public void deleteCorporation(ICorporation corporation) throws DBException {
        trans_deleteCorporation(corporation);
        super.Commit2DB();
    }

    /**
     * try to delete Corporation object in database
     * an alternative to deleteCorporation, which can be made an empty function
     * commit transaction
     * @param corporation: Corporation Entity Object
     * @throws eve.general.exception.CustomException
     */
    public void securedeleteCorporation(ICorporation corporation) throws DBException {
        trans_deleteCorporation(corporation);
        super.Commit2DB();
    }

    /**
     * try to insert Corporation object in database
     * do not commit transaction
     * @param corporation: Corporation Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void trans_insertCorporation(ICorporation corporation) throws DBException, DataException {
        super.checkDATA(corporation);
        super.insertCorporation((Corporation)corporation);
    }
    
    /**
     * try to update Corporation object in database
     * do not commit transaction
     * @param corporation: Corporation Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void trans_updateCorporation(ICorporation corporation) throws DBException, DataException {
        super.checkDATA(corporation);
        super.updateCorporation((Corporation)corporation);
    }
    
    /**
     * try to delete Corporation object in database
     * do not commit transaction
     * @param corporation: Corporation Entity Object
     * @throws eve.general.exception.CustomException
     */
    public void trans_deleteCorporation(ICorporation corporation) throws DBException {
        super.deleteCorporation((Corporation)corporation);
    }
}
