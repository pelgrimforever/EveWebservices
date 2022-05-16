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
import eve.logicentity.Region_neighbour;
import eve.logicview.*;
import general.exception.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class Region_neighbour_usecases {

    private boolean loggedin = false;
    private BLregion_neighbour blregion_neighbour = new BLregion_neighbour();
    
    public Region_neighbour_usecases() {
        this(false);
    }
    
    public Region_neighbour_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blregion_neighbour.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

    public long count() throws DBException {
        return blregion_neighbour.count();
    }
    
    public ArrayList<Region_neighbour> get_all() throws DBException {
        return blregion_neighbour.getRegion_neighbours();
    }
    
    public boolean getRegion_neighbourExists(IRegion_neighbourPK region_neighbourPK) throws DBException {
        return blregion_neighbour.getEntityExists(region_neighbourPK);
    }
    
    public Region_neighbour get_region_neighbour_by_primarykey(IRegion_neighbourPK region_neighbourPK) throws DBException {
        return blregion_neighbour.getRegion_neighbour(region_neighbourPK);
    }

    public ArrayList<Region_neighbour> get_region_neighbour_with_foreignkey_regionRegion(IRegionPK regionRegionPK) throws CustomException {
        return blregion_neighbour.getRegion_neighbours4regionRegion(regionRegionPK);
    }
    
    public ArrayList<Region_neighbour> get_region_neighbour_with_foreignkey_regionNeighbour(IRegionPK regionNeighbourPK) throws CustomException {
        return blregion_neighbour.getRegion_neighbours4regionNeighbour(regionNeighbourPK);
    }
    
    public ArrayList<Region_neighbour> search_region_neighbour(IRegion_neighboursearch region_neighboursearch) throws ParseException, CustomException {
        return blregion_neighbour.search(region_neighboursearch);
    }
    
    public long search_region_neighbour_count(IRegion_neighboursearch region_neighboursearch) throws ParseException, CustomException {
        return blregion_neighbour.searchcount(region_neighboursearch);
    }

    public void secureinsertRegion_neighbour(IRegion_neighbour region_neighbour) throws DBException, DataException {
        blregion_neighbour.secureinsertRegion_neighbour(region_neighbour);
    }

    public void secureupdateRegion_neighbour(IRegion_neighbour region_neighbour) throws DBException, DataException {
        blregion_neighbour.secureupdateRegion_neighbour(region_neighbour);
    }

    public void securedeleteRegion_neighbour(IRegion_neighbour region_neighbour) throws DBException, DataException {
        blregion_neighbour.securedeleteRegion_neighbour(region_neighbour);
    }
}

