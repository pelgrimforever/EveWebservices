/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 6.4.2021 17:24
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import eve.interfaces.logicentity.IMarket_group;
import eve.logicentity.Market_group;
import db.*;
import data.conversion.JSONConversion;
import db.SQLTqueue;
import eve.BusinessObject.table.Bmarket_group;
import eve.entity.pk.Market_groupPK;
import general.exception.DataException;
import org.json.simple.JSONObject;

/**
 * @author Franky Laseure
 */
public class BLmarket_group extends Bmarket_group {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    public BLmarket_group(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(true);
    }

    public BLmarket_group(TableBusinessrules businessrules) {
        super(businessrules);
        tableio.setLogginrequired(isprivatetable);
    }

    public Market_group updateMarket_group(SQLTqueue transactionqueue, JSONObject jsonmarketgroupdetails) throws DBException, DataException {
        Market_group marketgroup = new Market_group(JSONConversion.getLong(jsonmarketgroupdetails, "market_group_id"));
        marketgroup.setName(JSONConversion.getString(jsonmarketgroupdetails, "name"));
        marketgroup.setDescription(JSONConversion.getString(jsonmarketgroupdetails, "description"));
        insertupdateMarket_group(transactionqueue, marketgroup);
        return marketgroup;
    }
    
    public Market_group updateParent(Market_group marketgroup, JSONObject jsonmarketgroupdetails) {
        if(jsonmarketgroupdetails.containsKey("parent_group_id")) 
            marketgroup.setMarket_groupparent_idPK(new Market_groupPK(JSONConversion.getLong(jsonmarketgroupdetails, "parent_group_id")));
        return marketgroup;
    }

}
