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
import eve.logicentity.Location;
import eve.logicview.*;
import general.exception.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class Location_usecases {

    private boolean loggedin = false;
    private BLlocation bllocation = new BLlocation();
    
    public Location_usecases() {
        this(false);
    }
    
    public Location_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        bllocation.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

    public long count() throws DBException {
        return bllocation.count();
    }
    
    public ArrayList<Location> get_all() throws DBException {
        return bllocation.getLocations();
    }
    
    public boolean getLocationExists(ILocationPK locationPK) throws DBException {
        return bllocation.getEntityExists(locationPK);
    }
    
    public Location get_location_by_primarykey(ILocationPK locationPK) throws DBException {
        return bllocation.getLocation(locationPK);
    }

    public ArrayList<Location> get_location_with_foreignkey_system(ISystemPK systemPK) throws CustomException {
        return bllocation.getLocations4system(systemPK);
    }
    
    public ArrayList<Location> search_location(ILocationsearch locationsearch) throws ParseException, CustomException {
        return bllocation.search(locationsearch);
    }
    
    public long search_location_count(ILocationsearch locationsearch) throws ParseException, CustomException {
        return bllocation.searchcount(locationsearch);
    }

    public void secureinsertLocation(ILocation location) throws DBException, DataException {
        bllocation.secureinsertLocation(location);
    }

    public void secureupdateLocation(ILocation location) throws DBException, DataException {
        bllocation.secureupdateLocation(location);
    }

    public void securedeleteLocation(ILocation location) throws DBException, DataException {
        bllocation.securedeleteLocation(location);
    }
}

