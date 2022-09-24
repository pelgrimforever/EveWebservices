/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 3.4.2021 17:22
 * @author Franky Laseure
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import eve.interfaces.logicentity.IRegion;
import eve.logicentity.Region;
import db.*;
import data.conversion.JSONConversion;
import db.*;
import db.SQLTqueue;
import eve.BusinessObject.table.Bregion;
import eve.conversion.entity.EMregion;
import general.exception.DataException;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class BLregion extends Bregion {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    public BLregion(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(true);
    }

    public BLregion(TableBusinessrules businessrules) {
        super(businessrules);
        tableio.setLogginrequired(isprivatetable);
    }

    public void updateRegions(SQLTqueue transactionqueue, JSONArray jsonregionnames) throws DBException, DataException {
        Iterator<JSONObject> regionsI = jsonregionnames.iterator();
        JSONObject jsonregion;
        Region region;
        while(regionsI.hasNext()) {
            jsonregion = (JSONObject)regionsI.next();
            region = new Region(JSONConversion.getLong(jsonregion, "id"));
            region.setName(JSONConversion.getString(jsonregion, "name"));
            insertupdateRegion(transactionqueue, region);
        }
    }
    
    public void postprocess(SQLTqueue transactionqueue) throws DBException, DataException {
        Object[][] parameter1 = {{ "noaccess", true }, { "constellationnoaccess", false }};
        SQLparameters sqlparameter1 = new SQLparameters(parameter1);
        addStatement(transactionqueue, EMregion.updateNoaccess1, sqlparameter1);
        Object[][] parameter2 = {{ "noaccess", false }, { "constellationnoaccess", false }};
        SQLparameters sqlparameter2 = new SQLparameters(parameter2);
        addStatement(transactionqueue, EMregion.updateNoaccess2, sqlparameter2);
    }
    
    public ArrayList getAll_Orderpages() throws DBException {
        return getEntities(EMregion.SQLSelectAllaccessOrderpages);
    }
    
    public ArrayList getAll_Contractpages() throws DBException {
        return getEntities(EMregion.SQLSelectAllaccessContractpages);
    }
    
}
