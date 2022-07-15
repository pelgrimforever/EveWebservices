/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 21.4.2021 21:43
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import eve.interfaces.logicentity.IOrder_history;
import eve.logicentity.Order_history;
import db.*;
import data.conversion.JSONConversion;
import db.SQLTqueue;
import eve.BusinessObject.table.Border_history;
import eve.data.Swagger;
import general.exception.DataException;
import org.json.simple.JSONObject;

/**
 * @author Franky Laseure
 */
public class BLorder_history extends Border_history {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    public BLorder_history(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(true);
    }

    public BLorder_history(TableBusinessrules businessrules) {
        super(businessrules);
        tableio.setLogginrequired(isprivatetable);
    }

    public Order_history updateOrder_history(SQLTqueue transactionqueue, long regionid, long evetypeid, JSONObject jsonhistory) throws DBException, DataException {
        String stringdate = JSONConversion.getString(jsonhistory, "date");
        Order_history history = new Order_history(regionid, evetypeid, Swagger.datestring2Date(stringdate));
        history.setAverage(JSONConversion.getDouble(jsonhistory, "average"));
        history.setHighest(JSONConversion.getDouble(jsonhistory, "highest"));
        history.setLowest(JSONConversion.getDouble(jsonhistory, "lowest"));
        history.setOrder_count(JSONConversion.getint(jsonhistory, "order_count"));
        history.setVolume(JSONConversion.getint(jsonhistory, "volume"));
        this.insertupdateOrder_history(transactionqueue, history);
        return history;
    }

}
