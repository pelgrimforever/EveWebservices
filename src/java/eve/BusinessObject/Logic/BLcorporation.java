/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 17.4.2021 16:19
 * @author Franky Laseure
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import eve.interfaces.logicentity.ICorporation;
import eve.logicentity.Corporation;
import db.*;
import data.conversion.JSONConversion;
import db.SQLTqueue;
import eve.BusinessObject.table.Bcorporation;
import eve.data.Swagger;
import eve.entity.pk.FactionPK;
import eve.entity.pk.StationPK;
import general.exception.DataException;
import org.json.simple.JSONObject;

public class BLcorporation extends Bcorporation {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    public BLcorporation(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(true);
    }

    public BLcorporation(TableBusinessrules businessrules) {
        super(businessrules);
        tableio.setLogginrequired(isprivatetable);
    }

    public Corporation updateCorporation(SQLTqueue transactionqueue, JSONObject jsoncorporationdetails) throws DBException, DataException {
        Corporation corporation = new Corporation(JSONConversion.getLong(jsoncorporationdetails, "corporation_id"));
        corporation.setName(JSONConversion.getString(jsoncorporationdetails, "name"));
        corporation.setTicker(JSONConversion.getString(jsoncorporationdetails, "ticker"));
        if(jsoncorporationdetails.containsKey("description")) corporation.setDescription(JSONConversion.getString(jsoncorporationdetails, "description"));
        corporation.setCreator(JSONConversion.getLong(jsoncorporationdetails, "creator_id"));
        corporation.setCeo(JSONConversion.getLong(jsoncorporationdetails, "ceo_id"));
        corporation.setMember_count(JSONConversion.getint(jsoncorporationdetails, "member_count"));
        corporation.setTax_rate(JSONConversion.getDouble(jsoncorporationdetails, "tax_rate"));
        //alliance may not exist yet, fill in after alliances are downloaded
        //if(jsoncorporationdetails.containsKey("alliance_id")) corporation.setAlliancePK(new AlliancePK(JSONConversion.getLong(jsoncorporationdetails, "alliance_id")));
        if(jsoncorporationdetails.containsKey("date_founded")) {
            String stringdatefounded = JSONConversion.getString(jsoncorporationdetails, "date_founded");
            corporation.setDate_founded(Swagger.datetimestring2Timestamp(stringdatefounded));
        }
        if(jsoncorporationdetails.containsKey("faction_id")) corporation.setFactionPK(new FactionPK(JSONConversion.getLong(jsoncorporationdetails, "faction_id")));
        if(jsoncorporationdetails.containsKey("home_station_id")) corporation.setStationPK(new StationPK(JSONConversion.getLong(jsoncorporationdetails, "home_station_id")));
        if(jsoncorporationdetails.containsKey("shares")) corporation.setShares(JSONConversion.getint(jsoncorporationdetails, "shares"));
        if(jsoncorporationdetails.containsKey("url")) corporation.setUrl(JSONConversion.getString(jsoncorporationdetails, "url"));
        if(jsoncorporationdetails.containsKey("war_eligible")) corporation.setWar_eligible(JSONConversion.getboolean(jsoncorporationdetails, "war_eligible"));
        insertupdateCorporation(transactionqueue, corporation);
        return corporation;
    }

}
