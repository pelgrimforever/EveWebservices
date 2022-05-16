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
import eve.logicentity.Shipfitorderselected;
import eve.logicview.*;
import general.exception.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class Shipfitorderselected_usecases {

    private boolean loggedin = false;
    private BLshipfitorderselected blshipfitorderselected = new BLshipfitorderselected();
    
    public Shipfitorderselected_usecases() {
        this(false);
    }
    
    public Shipfitorderselected_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blshipfitorderselected.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
    public ArrayList<View_system> calculateroute_usecase(String username, long startsystem, long endsystem) throws DBException {
        return blshipfitorderselected.calculateroute(username, startsystem, endsystem);
    }

    public void link_shipfitorder_to_order(IShipfitorderPK shipfitorderPK, IOrdersPK ordersPK) throws DBException, CustomException {
        blshipfitorderselected.link_shipfitorder_to_order(shipfitorderPK, ordersPK);
    }

    public void update_shipfitorderselected_with_bought_amount(IShipfitorderselectedPK shipfitorderselectedPK, int amount) throws DBException, CustomException {
        blshipfitorderselected.update_shipfitorderselected_with_bought_amount(shipfitorderselectedPK, amount);
    }
//Custom code, do not change this line   

    public long count() throws DBException {
        return blshipfitorderselected.count();
    }
    
    public ArrayList<Shipfitorderselected> get_all() throws DBException {
        return blshipfitorderselected.getShipfitorderselecteds();
    }
    
    public boolean getShipfitorderselectedExists(IShipfitorderselectedPK shipfitorderselectedPK) throws DBException {
        return blshipfitorderselected.getEntityExists(shipfitorderselectedPK);
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
    
    public ArrayList<Shipfitorderselected> search_shipfitorderselected(IShipfitorderselectedsearch shipfitorderselectedsearch) throws ParseException, CustomException {
        return blshipfitorderselected.search(shipfitorderselectedsearch);
    }
    
    public long search_shipfitorderselected_count(IShipfitorderselectedsearch shipfitorderselectedsearch) throws ParseException, CustomException {
        return blshipfitorderselected.searchcount(shipfitorderselectedsearch);
    }

    public void secureinsertShipfitorderselected(IShipfitorderselected shipfitorderselected) throws DBException, DataException {
        blshipfitorderselected.secureinsertShipfitorderselected(shipfitorderselected);
    }

    public void secureupdateShipfitorderselected(IShipfitorderselected shipfitorderselected) throws DBException, DataException {
        blshipfitorderselected.secureupdateShipfitorderselected(shipfitorderselected);
    }

    public void securedeleteShipfitorderselected(IShipfitorderselected shipfitorderselected) throws DBException, DataException {
        blshipfitorderselected.securedeleteShipfitorderselected(shipfitorderselected);
    }
}

