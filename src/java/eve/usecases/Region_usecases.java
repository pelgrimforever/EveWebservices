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
import eve.logicentity.Region;
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
public class Region_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private SQLTwriter sqlwriter = new SQLTwriter();
    private BLregion blregion = new BLregion(sqlreader);
    
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
        return blregion.getRegionExists(regionPK);
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

    public void insertRegion(IRegion region) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blregion.insertRegion(tq, region);
        sqlwriter.Commit2DB(tq);
    }

    public void updateRegion(IRegion region) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blregion.updateRegion(tq, region);
        sqlwriter.Commit2DB(tq);
    }

    public void deleteRegion(IRegion region) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blregion.deleteRegion(tq, region);
        sqlwriter.Commit2DB(tq);
    }

}

