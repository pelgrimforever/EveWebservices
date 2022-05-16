/*
 * Generated on 13.4.2022 19:13
 */

package eve.usecases;

import data.conversion.JSONConversion;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.*;
import eve.interfaces.entity.pk.*;
import eve.logicentity.Json_orders;
import eve.logicview.*;
import general.exception.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class Json_orders_usecases {

    private boolean loggedin = false;
    private BLjson_orders bljson_orders = new BLjson_orders();
    
    public Json_orders_usecases() {
        this(false);
    }
    
    public Json_orders_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        bljson_orders.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

    public long count() throws DBException {
        return bljson_orders.count();
    }
    
    public ArrayList<Json_orders> get_all() throws DBException {
        return bljson_orders.getJson_orderss();
    }
    
    public boolean getJson_ordersExists(IJson_ordersPK json_ordersPK) throws DBException {
        return bljson_orders.getEntityExists(json_ordersPK);
    }
    
    public Json_orders get_json_orders_by_primarykey(IJson_ordersPK json_ordersPK) throws DBException {
        return bljson_orders.getJson_orders(json_ordersPK);
    }

    public ArrayList<Json_orders> search_json_orders(IJson_orderssearch json_orderssearch) throws ParseException, CustomException {
        return bljson_orders.search(json_orderssearch);
    }
    
    public long search_json_orders_count(IJson_orderssearch json_orderssearch) throws ParseException, CustomException {
        return bljson_orders.searchcount(json_orderssearch);
    }

    public void secureinsertJson_orders(IJson_orders json_orders) throws DBException, DataException {
        bljson_orders.secureinsertJson_orders(json_orders);
    }

    public void secureupdateJson_orders(IJson_orders json_orders) throws DBException, DataException {
        bljson_orders.secureupdateJson_orders(json_orders);
    }

    public void securedeleteJson_orders(IJson_orders json_orders) throws DBException, DataException {
        bljson_orders.securedeleteJson_orders(json_orders);
    }
}

