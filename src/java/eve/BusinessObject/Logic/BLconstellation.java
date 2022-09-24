/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 4.4.2021 14:28
 * @author Franky Laseure
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import eve.interfaces.logicentity.IConstellation;
import eve.logicentity.Constellation;
import db.*;
import data.conversion.JSONConversion;
import db.*;
import db.SQLTqueue;
import eve.BusinessObject.table.Bconstellation;
import eve.conversion.entity.EMconstellation;
import eve.entity.pk.RegionPK;
import general.exception.DataException;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class BLconstellation extends Bconstellation {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    public BLconstellation(SQLreader sqlreader) {
        super(sqlreader);
        tableio.setLogginrequired(true);
    }

    public BLconstellation(TableBusinessrules businessrules) {
        super(businessrules);
        tableio.setLogginrequired(isprivatetable);
    }

    public Constellation updateConstellation(SQLTqueue transactionqueue, JSONObject jsonconstellationdetails) throws DBException, DataException {
        Constellation constellation = new Constellation(JSONConversion.getLong(jsonconstellationdetails, "constellation_id"));
        constellation.setName(JSONConversion.getString(jsonconstellationdetails, "name"));
        constellation.setRegionPK(new RegionPK(JSONConversion.getLong(jsonconstellationdetails, "region_id")));
        insertupdateConstellation(transactionqueue, constellation);
        return constellation;
    }
    
    public void postprocess(SQLTqueue transactionqueue) throws DBException, DataException {
        Object[][] parameter1 = {{ "noaccess", true }, { "systemnoaccess", false }};
        SQLparameters sqlparameters1 = new SQLparameters(parameter1);
        tableio.addStatement(transactionqueue, EMconstellation.updateNoaccess1, sqlparameters1);
        Object[][] parameter2 = {{ "noaccess", false }, { "systemnoaccess", false }};
        SQLparameters sqlparameters2 = new SQLparameters(parameter2);
        tableio.addStatement(transactionqueue, EMconstellation.updateNoaccess2, sqlparameters2);
    }
    
}
