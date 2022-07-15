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
import eve.logicentity.Order_history;
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
public class Order_history_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private SQLTwriter sqlwriter = new SQLTwriter();
    private BLorder_history blorder_history = new BLorder_history(sqlreader);
    
    public Order_history_usecases() {
        this(false);
    }
    
    public Order_history_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blorder_history.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

    public long count() throws DBException {
        return blorder_history.count();
    }
    
    public ArrayList<Order_history> get_all() throws DBException {
        return blorder_history.getOrder_historys();
    }
    
    public boolean getOrder_historyExists(IOrder_historyPK order_historyPK) throws DBException {
        return blorder_history.getOrder_historyExists(order_historyPK);
    }
    
    public Order_history get_order_history_by_primarykey(IOrder_historyPK order_historyPK) throws DBException {
        return blorder_history.getOrder_history(order_historyPK);
    }

    public ArrayList<Order_history> get_order_history_with_foreignkey_evetype(IEvetypePK evetypePK) throws CustomException {
        return blorder_history.getOrder_historys4evetype(evetypePK);
    }
    
    public ArrayList<Order_history> get_order_history_with_foreignkey_region(IRegionPK regionPK) throws CustomException {
        return blorder_history.getOrder_historys4region(regionPK);
    }
    
    public ArrayList<Order_history> search_order_history(IOrder_historysearch order_historysearch) throws CustomException {
        return blorder_history.search(order_historysearch);
    }
    
    public long search_order_history_count(IOrder_historysearch order_historysearch) throws CustomException {
        return blorder_history.searchcount(order_historysearch);
    }

    public void insertOrder_history(IOrder_history order_history) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blorder_history.insertOrder_history(tq, order_history);
        sqlwriter.Commit2DB(tq);
    }

    public void updateOrder_history(IOrder_history order_history) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blorder_history.updateOrder_history(tq, order_history);
        sqlwriter.Commit2DB(tq);
    }

    public void deleteOrder_history(IOrder_history order_history) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blorder_history.deleteOrder_history(tq, order_history);
        sqlwriter.Commit2DB(tq);
    }

    public void delete_all_containing_Evetype(IEvetypePK evetypePK) throws CustomException {
        SQLTqueue tq = new SQLTqueue();
        blorder_history.delete4evetype(tq, evetypePK);
        sqlwriter.Commit2DB(tq);
    }
    
    public void delete_all_containing_Region(IRegionPK regionPK) throws CustomException {
        SQLTqueue tq = new SQLTqueue();
        blorder_history.delete4region(tq, regionPK);
        sqlwriter.Commit2DB(tq);
    }
    
}

