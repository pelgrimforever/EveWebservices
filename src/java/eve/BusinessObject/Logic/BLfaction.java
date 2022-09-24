/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 17.4.2021 16:19
 * @author Franky Laseure
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import eve.interfaces.logicentity.IFaction;
import eve.logicentity.Faction;
import db.*;
import data.conversion.JSONConversion;
import db.SQLTqueue;
import eve.BusinessObject.table.Bfaction;
import eve.entity.pk.SystemPK;
import general.exception.DataException;
import org.json.simple.JSONObject;

public class BLfaction extends Bfaction {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    public BLfaction(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(true);
    }

    public BLfaction(TableBusinessrules businessrules) {
        super(businessrules);
        tableio.setLogginrequired(isprivatetable);
    }

    public Faction updateFaction(SQLTqueue transactionqueue, JSONObject jsonfactiondetails) throws DBException, DataException {
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
        insertupdateFaction(transactionqueue, faction);
        return faction;
    }

}
