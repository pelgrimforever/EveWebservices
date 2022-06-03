/*
 * Generated on 20.4.2022 10:3
 */

package eve.usecases;

import data.conversion.JSONConversion;
import data.interfaces.db.Filedata;
import data.gis.shape.piPoint;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.*;
import eve.interfaces.entity.pk.*;
import eve.logicentity.Shipfit;
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
    private BLshipfit blshipfit = new BLshipfit();
    
    public Shipfit_usecases() {
        this(false);
    }
    
    public Shipfit_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blshipfit.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
    public void order_ship_and_all_modules(IShipfitPK shipfitPK) throws DBException, CustomException {
        blshipfit.order_ship_and_all_modules(shipfitPK);
    }
//Custom code, do not change this line   

    public long count() throws DBException {
        return blshipfit.count();
    }
    
    public ArrayList<Shipfit> get_all() throws DBException {
        return blshipfit.getShipfits();
    }
    
    public boolean getShipfitExists(IShipfitPK shipfitPK) throws DBException {
        return blshipfit.getEntityExists(shipfitPK);
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

    public void secureinsertShipfit(IShipfit shipfit) throws DBException, DataException {
        blshipfit.secureinsertShipfit(shipfit);
    }

    public void secureupdateShipfit(IShipfit shipfit) throws DBException, DataException {
        blshipfit.secureupdateShipfit(shipfit);
    }

    public void securedeleteShipfit(IShipfit shipfit) throws DBException, DataException {
        blshipfit.securedeleteShipfit(shipfit);
    }
}

