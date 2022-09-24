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
import eve.logicentity.Shipfitorderselected;
import eve.logicview.*;
import eve.usecases.custom.*;
import general.exception.*;
import java.sql.Date;
import java.io.*;
import java.util.*;
import java.io.IOException;
import org.json.simple.parser.ParseException;

public class Shipfitorderselected_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private SQLTwriter sqlwriter = new SQLTwriter();
    private BLshipfitorderselected blshipfitorderselected = new BLshipfitorderselected(sqlreader);
    
    public Shipfitorderselected_usecases() {
        this(false);
    }
    
    public Shipfitorderselected_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blshipfitorderselected.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
    BLorders blorders;
    BLsystem blsystem = new BLsystem(sqlreader);
    BLsystemjumps blsystemjumps = new BLsystemjumps(sqlreader);
    BLview_system blview_system = new BLview_system(sqlreader);
    BLshipfitorder blshipfitorder;
    Multistoproutecalculator_usecases multistoproutecalculator_usecases = new Multistoproutecalculator_usecases();
    Shipfitorder_usecases shipfitorder_usecases = new Shipfitorder_usecases();
    
    public ArrayList<eve.logicview.View_system> calculateroute_usecase(String username, long startsystemid, long endsystemid) throws DBException {
        blsystem.setAuthenticated(loggedin);
        blsystemjumps.setAuthenticated(loggedin);
        blview_system.setAuthenticated(loggedin);
        eve.logicentity.System startsystem = blsystem.getSystem(new SystemPK(startsystemid));
        eve.logicentity.System endsystem = blsystem.getSystem(new SystemPK(endsystemid));
        ArrayList<eve.logicentity.System> systemstops = blsystem.getSystems4shipfitorderselected(username);
        ArrayList<Systemjumps> systemjumps = blsystemjumps.getSystemjumps4shiporderselected(username, startsystemid, endsystemid);
        ArrayList<eve.logicentity.System> calculatedroute = multistoproutecalculator_usecases.calculateroute(startsystem, endsystem, systemstops, systemjumps);
        return getextra_route_information(startsystem, endsystem, calculatedroute);
    }

    private ArrayList<View_system> getextra_route_information(
            eve.logicentity.System startsystem,
            eve.logicentity.System endsystem,
            ArrayList<eve.logicentity.System> route) throws DBException {
        ArrayList<View_system> routesystems = new ArrayList<>();
        eve.logicentity.System prevsystem = startsystem;
        for(eve.logicentity.System system: route)
            routesystems.add(add_route_information_for_system_with_previousystem_as_startpoint(prevsystem, system));
        return routesystems;
    }

    private View_system add_route_information_for_system_with_previousystem_as_startpoint(eve.logicentity.System prevsystem, eve.logicentity.System system) throws DBException {
        View_system result = blview_system.getView_systems(prevsystem.getPrimaryKey().getId(), system.getPrimaryKey().getId());
        prevsystem = system;
        return result;
    }
    
    public void link_shipfitorder_to_order(IShipfitorderPK shipfitorderPK, IOrdersPK ordersPK) throws DBException, CustomException {
        SQLTqueue transactionqueue = new SQLTqueue();
        ShipfitorderselectedPK shipfitorderselectedPK = construct_shipfitorderselected_primarykey(shipfitorderPK, ordersPK);
        Shipfitorderselected shipfitorderselected = blshipfitorderselected.getShipfitorderselected(shipfitorderselectedPK);
        boolean shipfitorder_not_selected = shipfitorderselected==null;
        if(shipfitorder_not_selected)
            connect_shipfitorder_with_selected_order(transactionqueue, shipfitorderPK, ordersPK);
        sqlwriter.Commit2DB(transactionqueue);
    }

    private void connect_shipfitorder_with_selected_order(SQLTqueue transactionqueue, IShipfitorderPK shipfitorderPK, IOrdersPK ordersPK) throws CustomException, DBException, DataException {
        ShipfitorderselectedPK shipfitorderselectedPK = construct_shipfitorderselected_primarykey(shipfitorderPK, ordersPK);
        long order_availableamount = get_available_amount_from_order(ordersPK);
        int amount_wanted_and_avialable = get_amount_wanted_and_avialable(shipfitorderPK);
        long usedamount_for_other_fits = get_order_amount_used_for_other_fits(ordersPK);
        int amount_to_order = subtract_shipfitorderselected_amount_for_same_shiptype(shipfitorderPK, amount_wanted_and_avialable);
        long orderamount = Math.min(order_availableamount-usedamount_for_other_fits, amount_to_order);
        if(order_availableamount>usedamount_for_other_fits && orderamount>0)
            create_shipfitorderselected_with_order(shipfitorderselectedPK, orderamount, transactionqueue);
    }

    private void create_shipfitorderselected_with_order(ShipfitorderselectedPK shipfitorderselectedPK, long orderamount, SQLTqueue transactionqueue) throws DataException, DBException {
        Shipfitorderselected shipfitorderselected = new Shipfitorderselected(shipfitorderselectedPK);
        shipfitorderselected.setAmount((int)orderamount);
        blshipfitorderselected.insertShipfitorderselected(transactionqueue, shipfitorderselected);
    }

    private int subtract_shipfitorderselected_amount_for_same_shiptype(IShipfitorderPK shipfitorderPK, int amount_to_order) throws CustomException {
        ArrayList<Shipfitorderselected> orderedmodules = blshipfitorderselected.getShipfitorderselecteds4shipfitorder(shipfitorderPK);
        for(Shipfitorderselected usedshipfitorderselected: orderedmodules) {
            amount_to_order -= usedshipfitorderselected.getAmount();
        }
        return amount_to_order;
    }

    private long get_order_amount_used_for_other_fits(IOrdersPK ordersPK) throws CustomException {
        //check if this order is in use for other fits
        ArrayList<Shipfitorderselected> usedorders = blshipfitorderselected.getShipfitorderselecteds4orders(ordersPK);
        long usedamount = 0;
        for(Shipfitorderselected usedshipfitorderselected: usedorders) {
            usedamount += usedshipfitorderselected.getAmount();
        }
        return usedamount;
    }

    private ShipfitorderselectedPK construct_shipfitorderselected_primarykey(IShipfitorderPK shipfitorderPK, IOrdersPK ordersPK) {
        ShipfitorderselectedPK shipfitorderselectedPK = new ShipfitorderselectedPK();
        shipfitorderselectedPK.setShipfitorderPK(shipfitorderPK);
        shipfitorderselectedPK.setOrdersPK(ordersPK);
        return shipfitorderselectedPK;
    }

    private int get_amount_wanted_and_avialable(IShipfitorderPK shipfitorderPK) throws DBException {
        blshipfitorder = new BLshipfitorder(blshipfitorderselected);
        blshipfitorder.setAuthenticated(loggedin);
        Shipfitorder shipfitorder = blshipfitorder.getShipfitorder(shipfitorderPK);
        int amountwanted = shipfitorder.getAmountwanted()-shipfitorder.getAmountinstock();
        return amountwanted;
    }

    private long get_available_amount_from_order(IOrdersPK ordersPK) throws DBException {
        blorders = new BLorders(blshipfitorderselected);
        blorders.setAuthenticated(loggedin);
        Orders sellorder = blorders.getOrders(ordersPK);
        long availableamount = sellorder.getVolume_remain();
        return availableamount;
    }

    public void update_shipfitorderselected_with_bought_amount(IShipfitorderselectedPK shipfitorderselectedPK, int amount) throws DBException, CustomException {
        SQLTqueue transactionqueue = new SQLTqueue();
        remove_amount_from_shipfitorder(shipfitorderselectedPK, amount, transactionqueue);
        update_shipfitorderselected_stock(transactionqueue, shipfitorderselectedPK, amount);
        sqlwriter.Commit2DB(transactionqueue);
        shipfitorder_usecases.deleteShipfitorder_complete_for_user(shipfitorderselectedPK.getUsername());
    }

    private void update_shipfitorderselected_stock(SQLTqueue transactionqueue, IShipfitorderselectedPK shipfitorderselectedPK, int amount) throws CustomException, DBException, DataException {
        blshipfitorder = new BLshipfitorder(blshipfitorderselected);
        blshipfitorder.setAuthenticated(loggedin);
        Shipfitorder shipfitorder = blshipfitorder.getShipfitorderselected(shipfitorderselectedPK);
        blshipfitorder.updateAmount(transactionqueue, shipfitorderselectedPK.getShipfitorderPK(), amount);
    }

    private void remove_amount_from_shipfitorder(IShipfitorderselectedPK shipfitorderselectedPK, int amount, SQLTqueue transactionqueue) throws DataException, DBException {
        Shipfitorderselected shipfitorderselected = blshipfitorderselected.getShipfitorderselected(shipfitorderselectedPK);
        int amountleft = Math.max(shipfitorderselected.getAmount()-amount, 0);
        if(amountleft>0)
            subtract_amount_from_shipfitorderselected(shipfitorderselected, amount, transactionqueue);
        else
            blshipfitorderselected.deleteShipfitorderselected(transactionqueue, shipfitorderselected);
    }

    private void subtract_amount_from_shipfitorderselected(Shipfitorderselected shipfitorderselected, int amount, SQLTqueue transactionqueue) throws DBException, DataException {
        shipfitorderselected.setAmount(Math.max(shipfitorderselected.getAmount()-amount, 0));
        blshipfitorderselected.updateShipfitorderselected(transactionqueue, shipfitorderselected);
    }
//Custom code, do not change this line   

    public long count() throws DBException {
        return blshipfitorderselected.count();
    }
    
    public ArrayList<Shipfitorderselected> get_all() throws DBException {
        return blshipfitorderselected.getShipfitorderselecteds();
    }
    
    public boolean getShipfitorderselectedExists(IShipfitorderselectedPK shipfitorderselectedPK) throws DBException {
        return blshipfitorderselected.getShipfitorderselectedExists(shipfitorderselectedPK);
    }
    
    public Shipfitorderselected get_shipfitorderselected_by_primarykey(IShipfitorderselectedPK shipfitorderselectedPK) throws DBException {
        return blshipfitorderselected.getShipfitorderselected(shipfitorderselectedPK);
    }

    public ArrayList<Shipfitorderselected> get_shipfitorderselected_with_foreignkey_orders(IOrdersPK ordersPK) throws CustomException {
        return blshipfitorderselected.getShipfitorderselecteds4orders(ordersPK);
    }
    
    public ArrayList<Shipfitorderselected> get_shipfitorderselected_with_foreignkey_shipfitorder(IShipfitorderPK shipfitorderPK) throws CustomException {
        return blshipfitorderselected.getShipfitorderselecteds4shipfitorder(shipfitorderPK);
    }
    
    public ArrayList<Shipfitorderselected> search_shipfitorderselected(IShipfitorderselectedsearch shipfitorderselectedsearch) throws CustomException {
        return blshipfitorderselected.search(shipfitorderselectedsearch);
    }
    
    public long search_shipfitorderselected_count(IShipfitorderselectedsearch shipfitorderselectedsearch) throws CustomException {
        return blshipfitorderselected.searchcount(shipfitorderselectedsearch);
    }

    public void insertShipfitorderselected(IShipfitorderselected shipfitorderselected) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blshipfitorderselected.insertShipfitorderselected(tq, shipfitorderselected);
        sqlwriter.Commit2DB(tq);
    }

    public void updateShipfitorderselected(IShipfitorderselected shipfitorderselected) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blshipfitorderselected.updateShipfitorderselected(tq, shipfitorderselected);
        sqlwriter.Commit2DB(tq);
    }

    public void deleteShipfitorderselected(IShipfitorderselected shipfitorderselected) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blshipfitorderselected.deleteShipfitorderselected(tq, shipfitorderselected);
        sqlwriter.Commit2DB(tq);
    }

    public void delete_all_containing_Orders(IOrdersPK ordersPK) throws CustomException {
        SQLTqueue tq = new SQLTqueue();
        blshipfitorderselected.delete4orders(tq, ordersPK);
        sqlwriter.Commit2DB(tq);
    }
    
    public void delete_all_containing_Shipfitorder(IShipfitorderPK shipfitorderPK) throws CustomException {
        SQLTqueue tq = new SQLTqueue();
        blshipfitorderselected.delete4shipfitorder(tq, shipfitorderPK);
        sqlwriter.Commit2DB(tq);
    }
    
}

