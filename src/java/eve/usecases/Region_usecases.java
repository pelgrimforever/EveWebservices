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
import eve.logicentity.Region;
import general.exception.*;
import java.sql.Date;
import java.util.*;
import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class Region_usecases {

    private boolean loggedin = false;
    private BLregion blregion = new BLregion();
    
    public Region_usecases() {
        this(false);
    }
    
    public Region_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blregion.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

    public long count() throws DBException {
        return blregion.count();
    }
    
    public ArrayList<Region> get_all() throws DBException {
        return blregion.getRegions();
    }
    
    public boolean getRegionExists(IRegionPK regionPK) throws DBException {
        return blregion.getEntityExists(regionPK);
    }
    
    public Region get_region_by_primarykey(IRegionPK regionPK) throws DBException {
        return blregion.getRegion(regionPK);
    }

    public Region get_region_with_externalforeignkey_order_history_month(IOrder_history_monthPK order_history_monthPK) throws CustomException {
        return blregion.getOrder_history_month(order_history_monthPK);
    }
    
    public Region get_region_with_externalforeignkey_order_history(IOrder_historyPK order_historyPK) throws CustomException {
        return blregion.getOrder_history(order_historyPK);
    }
    
    public Region get_region_with_externalforeignkey_region_neighbourRegion(IRegion_neighbourPK region_neighbourRegionPK) throws CustomException {
        return blregion.getRegion_neighbourregion(region_neighbourRegionPK);
    }
    
    public Region get_region_with_externalforeignkey_region_neighbourNeighbour(IRegion_neighbourPK region_neighbourNeighbourPK) throws CustomException {
        return blregion.getRegion_neighbourneighbour(region_neighbourNeighbourPK);
    }
    
    public ArrayList<Region> search_region(IRegionsearch regionsearch) throws CustomException {
        return blregion.search(regionsearch);
    }
    
    public long search_region_count(IRegionsearch regionsearch) throws CustomException {
        return blregion.searchcount(regionsearch);
    }

    public void secureinsertRegion(IRegion region) throws DBException, DataException {
        blregion.secureinsertRegion(region);
    }

    public void secureupdateRegion(IRegion region) throws DBException, DataException {
        blregion.secureupdateRegion(region);
    }

    public void securedeleteRegion(IRegion region) throws DBException, DataException {
        blregion.securedeleteRegion(region);
    }
}

