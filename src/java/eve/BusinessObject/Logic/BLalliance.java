/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 15.4.2021 19:21
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import eve.logicentity.Alliance;
import db.*;
import data.conversion.JSONConversion;
import db.SQLTqueue;
import db.SQLreader;
import eve.BusinessObject.table.Balliance;
import eve.data.Swagger;
import eve.entity.pk.CorporationPK;
import general.exception.DataException;
import org.json.simple.JSONObject;

/**
 * @author Franky Laseure
 */
public class BLalliance extends Balliance {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    public BLalliance(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(isprivatetable);
    }

    public BLalliance(TableBusinessrules businessrules) {
        super(businessrules);
        tableio.setLogginrequired(isprivatetable);
    }

    public Alliance updateAlliance(SQLTqueue transactionqueue, JSONObject jsonalliancedetails) throws DBException, DataException {
        Alliance alliance = new Alliance(JSONConversion.getLong(jsonalliancedetails, "alliance_id"));
        alliance.setName(JSONConversion.getString(jsonalliancedetails, "name"));
        alliance.setTicker(JSONConversion.getString(jsonalliancedetails, "ticker"));
        alliance.setCreator(JSONConversion.getLong(jsonalliancedetails, "creator_id"));
        alliance.setCorporationcreator_corporationPK(new CorporationPK(JSONConversion.getLong(jsonalliancedetails, "creator_corporation_id")));
        String stringdatefounded = JSONConversion.getString(jsonalliancedetails, "date_founded");
        alliance.setDate_founded(Swagger.datetimestring2Timestamp(stringdatefounded));
        if(jsonalliancedetails.containsKey("executor_corporation_id")) alliance.setCorporationexecutor_corporationPK(new CorporationPK(JSONConversion.getLong(jsonalliancedetails, "executor_corporation_id")));
        if(jsonalliancedetails.containsKey("faction_id")) alliance.setFaction_id(JSONConversion.getLong(jsonalliancedetails, "faction_id"));
        insertupdateAlliance(transactionqueue, alliance);
        return alliance;
    }

}
