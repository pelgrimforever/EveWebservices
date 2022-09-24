/*
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
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
import eve.logicentity.Order_history_month;
import eve.logicview.*;
import eve.usecases.custom.*;
import general.exception.*;
import java.sql.Date;
import java.io.*;
import java.util.*;
import java.io.IOException;
import org.json.simple.parser.ParseException;

public class Order_history_month_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private SQLTwriter sqlwriter = new SQLTwriter();
    private BLorder_history_month blorder_history_month = new BLorder_history_month(sqlreader);
    
    public Order_history_month_usecases() {
        this(false);
    }
    
    public Order_history_month_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blorder_history_month.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

    public long count() throws DBException {
        return blorder_history_month.count();
    }
    
    public ArrayList<Order_history_month> get_all() throws DBException {
        return blorder_history_month.getOrder_history_months();
    }
    
    public boolean getOrder_history_monthExists(IOrder_history_monthPK order_history_monthPK) throws DBException {
        return blorder_history_month.getOrder_history_monthExists(order_history_monthPK);
    }
    
    public Order_history_month get_order_history_month_by_primarykey(IOrder_history_monthPK order_history_monthPK) throws DBException {
        return blorder_history_month.getOrder_history_month(order_history_monthPK);
    }

    public ArrayList<Order_history_month> get_order_history_month_with_foreignkey_evetype(IEvetypePK evetypePK) throws CustomException {
        return blorder_history_month.getOrder_history_months4evetype(evetypePK);
    }
    
    public ArrayList<Order_history_month> get_order_history_month_with_foreignkey_region(IRegionPK regionPK) throws CustomException {
        return blorder_history_month.getOrder_history_months4region(regionPK);
    }
    
    public ArrayList<Order_history_month> search_order_history_month(IOrder_history_monthsearch order_history_monthsearch) throws CustomException {
        return blorder_history_month.search(order_history_monthsearch);
    }
    
    public long search_order_history_month_count(IOrder_history_monthsearch order_history_monthsearch) throws CustomException {
        return blorder_history_month.searchcount(order_history_monthsearch);
    }

    public void insertOrder_history_month(IOrder_history_month order_history_month) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blorder_history_month.insertOrder_history_month(tq, order_history_month);
        sqlwriter.Commit2DB(tq);
    }

    public void updateOrder_history_month(IOrder_history_month order_history_month) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blorder_history_month.updateOrder_history_month(tq, order_history_month);
        sqlwriter.Commit2DB(tq);
    }

    public void deleteOrder_history_month(IOrder_history_month order_history_month) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blorder_history_month.deleteOrder_history_month(tq, order_history_month);
        sqlwriter.Commit2DB(tq);
    }

    public void delete_all_containing_Evetype(IEvetypePK evetypePK) throws CustomException {
        SQLTqueue tq = new SQLTqueue();
        blorder_history_month.delete4evetype(tq, evetypePK);
        sqlwriter.Commit2DB(tq);
    }
    
    public void delete_all_containing_Region(IRegionPK regionPK) throws CustomException {
        SQLTqueue tq = new SQLTqueue();
        blorder_history_month.delete4region(tq, regionPK);
        sqlwriter.Commit2DB(tq);
    }
    
}

