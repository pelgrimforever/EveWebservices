/*
 * Generated on 17.6.2022 13:4
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
import eve.logicentity.Shipfitorder;
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
public class Shipfitorder_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private SQLTwriter sqlwriter = new SQLTwriter();
    private BLshipfitorder blshipfitorder = new BLshipfitorder(sqlreader);
    
    public Shipfitorder_usecases() {
        this(false);
    }
    
    public Shipfitorder_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blshipfitorder.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
    private SQLTqueue transactionqueue;
    private BLshipfitorderselected blshipfitorderselected;
    private boolean ordercomplete;
    
    public void update_shipfitorder_amount(IShipfitorderPK shipfitorderPK, int amount) throws DBException, DataException {
        transactionqueue = new SQLTqueue();
        blshipfitorder.updateAmount(transactionqueue, shipfitorderPK, amount);
        sqlwriter.Commit2DB(transactionqueue);
        deleteShipfitorder_complete_for_user(shipfitorderPK.getUsername());
    }

    private ShipfitPK previousshipfitpk;
    
    public void deleteShipfitorder_complete_for_user(String username) throws DBException, DataException {
        blshipfitorderselected = new BLshipfitorderselected(blshipfitorder);
        blshipfitorderselected.setAuthenticated(loggedin);
        ArrayList<Shipfitorder> shipfitorders = blshipfitorder.getShipfitorders_for_user(username);
        previousshipfitpk = null;
        ordercomplete = true;
        for(Shipfitorder shipfitorder: shipfitorders)
            delete_shipfitorder_when_complete(shipfitorder);
        if(ordercomplete && previousshipfitpk!=null)
            delete_shipfitorder(previousshipfitpk.getUsername(), previousshipfitpk.getShipname());
        sqlwriter.Commit2DB(transactionqueue);
    }
    
    private void delete_shipfitorder_when_complete(Shipfitorder shipfitorder) throws DBException, DataException {
        ShipfitPK shipfitpk = (ShipfitPK)shipfitorder.getPrimaryKey().getShipfitPK();
        if(shipfitpk.equals(previousshipfitpk))
            ordercomplete = ordercomplete && shipfitorder.getAmountwanted()<=shipfitorder.getAmountinstock();
        else
            delete_shipfitorder_for_previousship_when_complete(shipfitorder);
        previousshipfitpk = shipfitpk;
    }

    private void delete_shipfitorder_for_previousship_when_complete(Shipfitorder shipfitorder) throws DBException, DataException {
        if(ordercomplete && previousshipfitpk!=null)
            delete_shipfitorder(previousshipfitpk.getUsername(), previousshipfitpk.getShipname());
        ordercomplete = shipfitorder.getAmountwanted()<=shipfitorder.getAmountinstock();
    }
    
    private void delete_shipfitorder(String username, String shipname)  throws DBException, DataException {
        blshipfitorderselected.deleleteShipfitorder_for_user_shipname(transactionqueue, username, shipname);
        blshipfitorder.deleleteShipfitorder_for_user_shipname(transactionqueue, username, shipname);
    }

//Custom code, do not change this line   

    public long count() throws DBException {
        return blshipfitorder.count();
    }
    
    public ArrayList<Shipfitorder> get_all() throws DBException {
        return blshipfitorder.getShipfitorders();
    }
    
    public boolean getShipfitorderExists(IShipfitorderPK shipfitorderPK) throws DBException {
        return blshipfitorder.getShipfitorderExists(shipfitorderPK);
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
    
    public ArrayList<Shipfitorder> search_shipfitorder(IShipfitordersearch shipfitordersearch) throws CustomException {
        return blshipfitorder.search(shipfitordersearch);
    }
    
    public long search_shipfitorder_count(IShipfitordersearch shipfitordersearch) throws CustomException {
        return blshipfitorder.searchcount(shipfitordersearch);
    }

    public void insertShipfitorder(IShipfitorder shipfitorder) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blshipfitorder.insertShipfitorder(tq, shipfitorder);
        sqlwriter.Commit2DB(tq);
    }

    public void updateShipfitorder(IShipfitorder shipfitorder) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blshipfitorder.updateShipfitorder(tq, shipfitorder);
        sqlwriter.Commit2DB(tq);
    }

    public void deleteShipfitorder(IShipfitorder shipfitorder) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blshipfitorder.deleteShipfitorder(tq, shipfitorder);
        sqlwriter.Commit2DB(tq);
    }

    public void delete_all_containing_Shipfit(IShipfitPK shipfitPK) throws CustomException {
        SQLTqueue tq = new SQLTqueue();
        blshipfitorder.delete4shipfit(tq, shipfitPK);
        sqlwriter.Commit2DB(tq);
    }
    
    public void delete_all_containing_Evetype(IEvetypePK evetypePK) throws CustomException {
        SQLTqueue tq = new SQLTqueue();
        blshipfitorder.delete4evetype(tq, evetypePK);
        sqlwriter.Commit2DB(tq);
    }
    
}

