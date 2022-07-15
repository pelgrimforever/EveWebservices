/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 18.4.2021 16:59
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import eve.interfaces.logicentity.IStargate;
import eve.logicentity.Stargate;
import db.*;
import data.conversion.JSONConversion;
import db.*;
import db.SQLTqueue;
import eve.BusinessObject.table.Bstargate;
import eve.conversion.entity.EMstargate;
import eve.entity.pk.SystemPK;
import general.exception.DataException;
import eve.interfaces.entity.pk.ISystemPK;
import general.exception.CustomException;
import java.sql.Date;
import java.util.ArrayList;
import org.json.simple.JSONObject;

/**
 * @author Franky Laseure
 */
public class BLstargate extends Bstargate {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    public BLstargate(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(true);
    }

    public BLstargate(TableBusinessrules businessrules) {
        super(businessrules);
        tableio.setLogginrequired(isprivatetable);
    }



    public Stargate updateStargate(SQLTqueue transactionqueue, JSONObject jsonstargatedetails) throws DBException, DataException {
        Stargate stargate = new Stargate(JSONConversion.getLong(jsonstargatedetails, "stargate_id"));
        stargate.setName(JSONConversion.getString(jsonstargatedetails, "name"));
        stargate.setSystemsystemPK(new SystemPK(JSONConversion.getLong(jsonstargatedetails, "system_id")));
        JSONObject jsondestination = (JSONObject)jsonstargatedetails.get("destination");
        stargate.setTo_stargate(JSONConversion.getLong(jsondestination, "stargate_id"));
        stargate.setSystemto_systemPK(new SystemPK(JSONConversion.getLong(jsondestination, "system_id")));
        JSONObject jsonposition = (JSONObject)jsonstargatedetails.get("position");
        stargate.setX(JSONConversion.getDouble(jsonposition, "x"));
        stargate.setY(JSONConversion.getDouble(jsonposition, "y"));
        stargate.setZ(JSONConversion.getDouble(jsonposition, "z"));
        stargate.setDownloaddate(new Date(System.currentTimeMillis()));
        this.insertupdateStargate(transactionqueue, stargate);
        return stargate;
    }

    public void updateborders(SQLTqueue transactionqueue) throws DBException, DataException {
        Object[][] parameter = { { "isborder", true } };
        SQLparameters sqlparameters = new SQLparameters(parameter);
        addStatement(transactionqueue, EMstargate.SQLupdateconstellationborders, sqlparameters);
        addStatement(transactionqueue, EMstargate.SQLupdateregionborders, sqlparameters);
    }
    
    public long getStargates4systemcount(ISystemPK systemPK) throws CustomException {
        return count(EMstargate.SQLSelect4systemCount, systemPK.getSQLprimarykey());
    }
    
    public Stargate getPreviousGate(SystemPK systemPK) throws CustomException {
        Stargate stargate = null;
        ArrayList stargates = getEntities(EMstargate.SQLselectpreviousTMP, systemPK.getSQLprimarykey());
        if(stargates.size()>0) {
            stargate = (Stargate)stargates.get(0);
        }
        return stargate;
    }

}
