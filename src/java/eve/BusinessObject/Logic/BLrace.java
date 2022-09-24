/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 7.4.2021 18:56
 * @author Franky Laseure
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import eve.interfaces.logicentity.IRace;
import eve.logicentity.Race;
import db.*;
import data.conversion.JSONConversion;
import db.SQLTqueue;
import eve.BusinessObject.table.Brace;
import eve.entity.pk.FactionPK;
import general.exception.DataException;
import org.json.simple.JSONObject;

public class BLrace extends Brace {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    public BLrace(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(true);
    }

    public BLrace(TableBusinessrules businessrules) {
        super(businessrules);
        setLogginrequired(isprivatetable);
    }

    public Race updateRace(SQLTqueue transactionqueue, JSONObject jsonracedetails) throws DBException, DataException {
        Race race = new Race(JSONConversion.getLong(jsonracedetails, "race_id"));
        race.setName(JSONConversion.getString(jsonracedetails, "name"));
        race.setDescription(JSONConversion.getString(jsonracedetails, "description"));
        race.setFactionPK(new FactionPK(JSONConversion.getLong(jsonracedetails, "alliance_id")));
        this.insertupdateRace(transactionqueue, race);
        return race;
    }

}
