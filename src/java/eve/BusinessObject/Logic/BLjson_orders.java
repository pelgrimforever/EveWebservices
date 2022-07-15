/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 5.5.2021 16:49
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import eve.interfaces.logicentity.IJson_orders;
import eve.logicentity.Json_orders;
import db.*;
import eve.BusinessObject.table.Bjson_orders;
import general.exception.DataException;

/**
 * @author Franky Laseure
 */
public class BLjson_orders extends Bjson_orders {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    public BLjson_orders(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(true);
    }

    public BLjson_orders(TableBusinessrules businessrules) {
        super(businessrules);
        tableio.setLogginrequired(isprivatetable);
    }



}
