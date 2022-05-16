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
import eve.logicentity.Shipfitorder;
import eve.logicview.*;
import general.exception.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class Shipfitorder_usecases {

    private boolean loggedin = false;
    private BLshipfitorder blshipfitorder = new BLshipfitorder();
    
    public Shipfitorder_usecases() {
        this(false);
    }
    
    public Shipfitorder_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blshipfitorder.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
    public void update_shipfitorder_amount(IShipfitorderPK shipfitorderPK, int amount) throws DBException, DataException {
        blshipfitorder.updateAmount(shipfitorderPK, amount);
        blshipfitorder.Commit2DB();
        blshipfitorder.removeCompleteorders(shipfitorderPK.getUsername());
    }
//Custom code, do not change this line   

    public long count() throws DBException {
        return blshipfitorder.count();
    }
    
    public ArrayList<Shipfitorder> get_all() throws DBException {
        return blshipfitorder.getShipfitorders();
    }
    
    public boolean getShipfitorderExists(IShipfitorderPK shipfitorderPK) throws DBException {
        return blshipfitorder.getEntityExists(shipfitorderPK);
    }
    
    public Shipfitorder get_shipfitorder_by_primarykey(IShipfitorderPK shipfitorderPK) throws DBException {
        return blshipfitorder.getShipfitorder(shipfitorderPK);
    }

    public ArrayList<Shipfitorder> get_shipfitorder_with_foreignkey_shipfit(IShipfitPK shipfitPK) throws CustomException {
        return blshipfitorder.getShipfitorders4shipfit(shipfitPK);
    }
    
    public ArrayList<Shipfitorder> get_shipfitorder_with_foreignkey_evetype(IEvetypePK evetypePK) throws CustomException {
        return blshipfitorder.getShipfitorders4evetype(evetypePK);
    }
    
    public Shipfitorder get_shipfitorder_with_externalforeignkey_shipfitorderselected(IShipfitorderselectedPK shipfitorderselectedPK) throws CustomException {
        return blshipfitorder.getShipfitorderselected(shipfitorderselectedPK);
    }
    
    public ArrayList<Shipfitorder> search_shipfitorder(IShipfitordersearch shipfitordersearch) throws ParseException, CustomException {
        return blshipfitorder.search(shipfitordersearch);
    }
    
    public long search_shipfitorder_count(IShipfitordersearch shipfitordersearch) throws ParseException, CustomException {
        return blshipfitorder.searchcount(shipfitordersearch);
    }

    public void secureinsertShipfitorder(IShipfitorder shipfitorder) throws DBException, DataException {
        blshipfitorder.secureinsertShipfitorder(shipfitorder);
    }

    public void secureupdateShipfitorder(IShipfitorder shipfitorder) throws DBException, DataException {
        blshipfitorder.secureupdateShipfitorder(shipfitorder);
    }

    public void securedeleteShipfitorder(IShipfitorder shipfitorder) throws DBException, DataException {
        blshipfitorder.securedeleteShipfitorder(shipfitorder);
    }
}

