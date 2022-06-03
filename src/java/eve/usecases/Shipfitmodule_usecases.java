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
import eve.logicentity.Shipfitmodule;
import general.exception.*;
import java.sql.Date;
import java.util.*;
import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class Shipfitmodule_usecases {

    private boolean loggedin = false;
    private BLshipfitmodule blshipfitmodule = new BLshipfitmodule();
    
    public Shipfitmodule_usecases() {
        this(false);
    }
    
    public Shipfitmodule_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blshipfitmodule.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

    public long count() throws DBException {
        return blshipfitmodule.count();
    }
    
    public ArrayList<Shipfitmodule> get_all() throws DBException {
        return blshipfitmodule.getShipfitmodules();
    }
    
    public boolean getShipfitmoduleExists(IShipfitmodulePK shipfitmodulePK) throws DBException {
        return blshipfitmodule.getEntityExists(shipfitmodulePK);
    }
    
    public Shipfitmodule get_shipfitmodule_by_primarykey(IShipfitmodulePK shipfitmodulePK) throws DBException {
        return blshipfitmodule.getShipfitmodule(shipfitmodulePK);
    }

    public ArrayList<Shipfitmodule> get_shipfitmodule_with_foreignkey_evetype(IEvetypePK evetypePK) throws CustomException {
        return blshipfitmodule.getShipfitmodules4evetype(evetypePK);
    }
    
    public ArrayList<Shipfitmodule> get_shipfitmodule_with_foreignkey_shipfit(IShipfitPK shipfitPK) throws CustomException {
        return blshipfitmodule.getShipfitmodules4shipfit(shipfitPK);
    }
    
    public ArrayList<Shipfitmodule> search_shipfitmodule(IShipfitmodulesearch shipfitmodulesearch) throws CustomException {
        return blshipfitmodule.search(shipfitmodulesearch);
    }
    
    public long search_shipfitmodule_count(IShipfitmodulesearch shipfitmodulesearch) throws CustomException {
        return blshipfitmodule.searchcount(shipfitmodulesearch);
    }

    public void secureinsertShipfitmodule(IShipfitmodule shipfitmodule) throws DBException, DataException {
        blshipfitmodule.secureinsertShipfitmodule(shipfitmodule);
    }

    public void secureupdateShipfitmodule(IShipfitmodule shipfitmodule) throws DBException, DataException {
        blshipfitmodule.secureupdateShipfitmodule(shipfitmodule);
    }

    public void securedeleteShipfitmodule(IShipfitmodule shipfitmodule) throws DBException, DataException {
        blshipfitmodule.securedeleteShipfitmodule(shipfitmodule);
    }
}

