/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 4.4.2021 14:28
 * @author Franky Laseure
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import eve.interfaces.logicentity.ISystem;
import eve.logicentity.System;
import db.*;
import data.conversion.JSONConversion;
import db.*;
import db.SQLTqueue;
import eve.BusinessObject.table.Bsystem;
import eve.conversion.entity.EMsystem;
import eve.data.Swagger;
import eve.entity.pk.ConstellationPK;
import general.exception.DataException;
import eve.interfaces.entity.pk.ISecurity_islandPK;
import general.exception.CustomException;
import java.sql.Date;
import java.util.ArrayList;
import org.json.simple.JSONObject;

public class BLsystem extends Bsystem {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    public BLsystem(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(true);
    }

    public BLsystem(TableBusinessrules businessrules) {
        super(businessrules);
        tableio.setLogginrequired(isprivatetable);
    }



    public ArrayList getSystems4shipfitorderselected(String username) throws DBException {
        Object[][] parameter = {{ "username", username }};
        SQLparameters sqlparameters = new SQLparameters(parameter);
        return getEntities(EMsystem.SQLSelect4shipfitorderselected, sqlparameters);
    }
    
    public System updateSystem(SQLTqueue transactionqueue, JSONObject jsonsystemdetails) throws DBException, DataException {
        System system = new System(JSONConversion.getLong(jsonsystemdetails, "system_id"));
        system.setName(JSONConversion.getString(jsonsystemdetails, "name"));
        system.setConstellationPK(new ConstellationPK(JSONConversion.getLong(jsonsystemdetails, "constellation_id")));
        if(jsonsystemdetails.containsKey("security_class")) system.setSecurity_class(JSONConversion.getString(jsonsystemdetails, "security_class"));
        system.setSecurity_status(JSONConversion.getDouble(jsonsystemdetails, "security_status"));
        if(jsonsystemdetails.containsKey("star_id")) system.setStar_id(JSONConversion.getLong(jsonsystemdetails, "star_id"));
        system.setDownloaddate(new Date(java.lang.System.currentTimeMillis()));
        insertupdateSystem(transactionqueue, system);
        return system;
    }

    public void updateborders(SQLTqueue transactionqueue) throws DBException, DataException {
        Object[][] parameter = { { "isborder", true } };
        addStatement(transactionqueue, EMsystem.SQLupdateconstellationborders);
        addStatement(transactionqueue, EMsystem.SQLupdateregionborders);
    }

    public ArrayList GetSystems_HiSecNoislands() throws DBException {
        Object[][] parameter = { { "highsec", Swagger.EVE_HIGHSEC_LIMIT } };
        SQLparameters sqlparameters = new SQLparameters(parameter);
        return getEntities(EMsystem.SQLSelectHiSecNoIsland, sqlparameters);
    }
    
    public void postprocess(SQLTqueue transactionqueue) throws DBException, DataException {
        Object[][] parameter1 = {{ "noaccess", true }};
        SQLparameters sqlparameters1 = new SQLparameters(parameter1);
        addStatement(transactionqueue, EMsystem.updateNoaccess1, sqlparameters1);
        Object[][] parameter2 = {{ "noaccess", false }};
        SQLparameters sqlparameters2 = new SQLparameters(parameter2);
        addStatement(transactionqueue, EMsystem.updateNoaccess2, sqlparameters2);
    }

    public ArrayList getSystemLowHisec() throws DBException {
        return getEntities(EMsystem.SQLSelectHiLowSec);
    }
    
    public ArrayList getHiSecConnectedSystems(ISecurity_islandPK security_islandPK) throws CustomException {
        Object[][] parameter = { { "highsec", Swagger.EVE_HIGHSEC_LIMIT } };
        SQLparameters sqlparameters = new SQLparameters(parameter);
        sqlparameters.add(security_islandPK.getSQLprimarykey());
        return getEntities(EMsystem.SQLSelectHiSecSystemsConnected, sqlparameters);
    }

}
