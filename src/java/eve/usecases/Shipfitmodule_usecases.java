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
import eve.logicentity.Shipfitmodule;
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
public class Shipfitmodule_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private SQLTwriter sqlwriter = new SQLTwriter();
    private BLshipfitmodule blshipfitmodule = new BLshipfitmodule(sqlreader);
    
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
        return blshipfitmodule.getShipfitmoduleExists(shipfitmodulePK);
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

    public void insertShipfitmodule(IShipfitmodule shipfitmodule) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blshipfitmodule.insertShipfitmodule(tq, shipfitmodule);
        sqlwriter.Commit2DB(tq);
    }

    public void updateShipfitmodule(IShipfitmodule shipfitmodule) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blshipfitmodule.updateShipfitmodule(tq, shipfitmodule);
        sqlwriter.Commit2DB(tq);
    }

    public void deleteShipfitmodule(IShipfitmodule shipfitmodule) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blshipfitmodule.deleteShipfitmodule(tq, shipfitmodule);
        sqlwriter.Commit2DB(tq);
    }

    public void delete_all_containing_Evetype(IEvetypePK evetypePK) throws CustomException {
        SQLTqueue tq = new SQLTqueue();
        blshipfitmodule.delete4evetype(tq, evetypePK);
        sqlwriter.Commit2DB(tq);
    }
    
    public void delete_all_containing_Shipfit(IShipfitPK shipfitPK) throws CustomException {
        SQLTqueue tq = new SQLTqueue();
        blshipfitmodule.delete4shipfit(tq, shipfitPK);
        sqlwriter.Commit2DB(tq);
    }
    
}

