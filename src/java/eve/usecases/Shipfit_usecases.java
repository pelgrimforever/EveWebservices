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
import eve.logicentity.Shipfit;
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
public class Shipfit_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private SQLTwriter sqlwriter = new SQLTwriter();
    private BLshipfit blshipfit = new BLshipfit(sqlreader);
    
    public Shipfit_usecases() {
        this(false);
    }
    
    public Shipfit_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blshipfit.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
    private BLshipfitmodule blshipfitmodule = new BLshipfitmodule(sqlreader);
    private BLshipfitorder blshipfitorder = new BLshipfitorder(sqlreader);
    
    public void order_ship_and_all_modules(IShipfitPK shipfitPK) throws DBException, CustomException {
        SQLTqueue transactionqueue = new SQLTqueue();
        blshipfitmodule.setAuthenticated(loggedin);
        blshipfitorder.setAuthenticated(loggedin);
        order_ship(shipfitPK, transactionqueue);
        order_modules(shipfitPK, transactionqueue);
        sqlwriter.Commit2DB(transactionqueue);
    }

    private void order_ship(IShipfitPK shipfitPK, SQLTqueue transactionqueue) throws DBException, DataException {
        Shipfitorder shipfitorder;
        Shipfit shipfit = blshipfit.getShipfit(shipfitPK);
        ShipfitorderPK shipfitorderPK = new ShipfitorderPK();
        shipfitorderPK.setShipfitPK(shipfitPK);
        shipfitorderPK.setEvetypePK(shipfit.getEvetypePK());
        shipfitorder = blshipfitorder.getShipfitorder(shipfitorderPK);
        if(shipfitorder==null)
            create_new_ship_order(shipfitorderPK, transactionqueue);
        else
            add_1_to_existing_ship_order(shipfitorder, transactionqueue);
    }

    private void add_1_to_existing_ship_order(Shipfitorder shipfitorder, SQLTqueue transactionqueue) throws DBException, DataException {
        shipfitorder.incAmountwanted(1);
        blshipfitorder.updateShipfitorder(transactionqueue, shipfitorder);
    }

    private void create_new_ship_order(ShipfitorderPK shipfitorderPK, SQLTqueue transactionqueue) throws DBException, DataException {
        Shipfitorder shipfitorder = new Shipfitorder(shipfitorderPK);
        shipfitorder.setAmountinstock(0);
        shipfitorder.setAmountwanted(1);
        blshipfitorder.insertShipfitorder(transactionqueue, shipfitorder);
    }

    private void order_modules(IShipfitPK shipfitPK, SQLTqueue transactionqueue) throws CustomException, DataException, DBException {
        //order modules
        ArrayList<Shipfitmodule> modules = blshipfitmodule.getShipfitmodules4shipfit(shipfitPK);
        for(Shipfitmodule module: modules)
            order_module(module, transactionqueue);
    }

    private void order_module(Shipfitmodule module, SQLTqueue transactionqueue) throws DBException, DataException {
        ShipfitorderPK shipfitorderPK = new ShipfitorderPK();
        shipfitorderPK.setShipfitPK(module.getPrimaryKey().getShipfitPK());
        shipfitorderPK.setEvetypePK(module.getPrimaryKey().getEvetypePK());
        Shipfitorder shipfitorder = blshipfitorder.getShipfitorder(shipfitorderPK);
        if(shipfitorder==null)
            create_new_module_order(shipfitorderPK, module, transactionqueue);
        else
            add_x_to_existing_module_order(shipfitorder, module, transactionqueue);
    }

    private void add_x_to_existing_module_order(Shipfitorder shipfitorder, Shipfitmodule module, SQLTqueue transactionqueue) throws DataException, DBException {
        shipfitorder.incAmountwanted(module.getAmount());
        blshipfitorder.updateShipfitorder(transactionqueue, shipfitorder);
    }

    private void create_new_module_order(ShipfitorderPK shipfitorderPK, Shipfitmodule module, SQLTqueue transactionqueue) throws DBException, DataException {
        Shipfitorder shipfitorder = new Shipfitorder(shipfitorderPK);
        shipfitorder.setAmountinstock(0);
        shipfitorder.setAmountwanted(module.getAmount());
        blshipfitorder.insertShipfitorder(transactionqueue, shipfitorder);
    }
//Custom code, do not change this line   

    public long count() throws DBException {
        return blshipfit.count();
    }
    
    public ArrayList<Shipfit> get_all() throws DBException {
        return blshipfit.getShipfits();
    }
    
    public boolean getShipfitExists(IShipfitPK shipfitPK) throws DBException {
        return blshipfit.getShipfitExists(shipfitPK);
    }
    
    public Shipfit get_shipfit_by_primarykey(IShipfitPK shipfitPK) throws DBException {
        return blshipfit.getShipfit(shipfitPK);
    }

    public ArrayList<Shipfit> get_shipfit_with_foreignkey_evetype(IEvetypePK evetypePK) throws CustomException {
        return blshipfit.getShipfits4evetype(evetypePK);
    }
    
    public Shipfit get_shipfit_with_externalforeignkey_shipfitmodule(IShipfitmodulePK shipfitmodulePK) throws CustomException {
        return blshipfit.getShipfitmodule(shipfitmodulePK);
    }
    
    public Shipfit get_shipfit_with_externalforeignkey_shipfitorder(IShipfitorderPK shipfitorderPK) throws CustomException {
        return blshipfit.getShipfitorder(shipfitorderPK);
    }
    
    public ArrayList<Shipfit> search_shipfit(IShipfitsearch shipfitsearch) throws CustomException {
        return blshipfit.search(shipfitsearch);
    }
    
    public long search_shipfit_count(IShipfitsearch shipfitsearch) throws CustomException {
        return blshipfit.searchcount(shipfitsearch);
    }

    public void insertShipfit(IShipfit shipfit) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blshipfit.insertShipfit(tq, shipfit);
        sqlwriter.Commit2DB(tq);
    }

    public void updateShipfit(IShipfit shipfit) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blshipfit.updateShipfit(tq, shipfit);
        sqlwriter.Commit2DB(tq);
    }

    public void deleteShipfit(IShipfit shipfit) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blshipfit.deleteShipfit(tq, shipfit);
        sqlwriter.Commit2DB(tq);
    }

    public void delete_all_containing_Evetype(IEvetypePK evetypePK) throws CustomException {
        SQLTqueue tq = new SQLTqueue();
        blshipfit.delete4evetype(tq, evetypePK);
        sqlwriter.Commit2DB(tq);
    }
    
}

