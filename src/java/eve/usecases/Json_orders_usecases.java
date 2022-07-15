/*
 * Generated on 13.6.2022 11:21
 */

package eve.usecases;

import db.*;
import data.conversion.JSONConversion;
import data.interfaces.db.Filedata;
import data.gis.shape.piPoint;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.*;
import eve.interfaces.entity.pk.*;
import eve.logicentity.*;
import eve.logicentity.Json_orders;
import eve.logicview.*;
import eve.usecases.custom.*;
import general.exception.*;
import java.sql.Date;
import java.util.*;
import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class Json_orders_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private SQLTwriter sqlwriter = new SQLTwriter();
    private BLjson_orders bljson_orders = new BLjson_orders(sqlreader);
    
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
        return bljson_orders.getJson_ordersExists(json_ordersPK);
    }
    
    public Json_orders get_json_orders_by_primarykey(IJson_ordersPK json_ordersPK) throws DBException {
        return bljson_orders.getJson_orders(json_ordersPK);
    }

    public ArrayList<Json_orders> search_json_orders(IJson_orderssearch json_orderssearch) throws CustomException {
        return bljson_orders.search(json_orderssearch);
    }
    
    public long search_json_orders_count(IJson_orderssearch json_orderssearch) throws CustomException {
        return bljson_orders.searchcount(json_orderssearch);
    }

    public void insertJson_orders(IJson_orders json_orders) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        bljson_orders.insertJson_orders(tq, json_orders);
        sqlwriter.Commit2DB(tq);
    }

    public void updateJson_orders(IJson_orders json_orders) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        bljson_orders.updateJson_orders(tq, json_orders);
        sqlwriter.Commit2DB(tq);
    }

    public void deleteJson_orders(IJson_orders json_orders) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        bljson_orders.deleteJson_orders(tq, json_orders);
        sqlwriter.Commit2DB(tq);
    }

}

