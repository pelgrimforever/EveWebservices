/*
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
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
import eve.logicentity.Location;
import eve.logicview.*;
import eve.usecases.custom.*;
import general.exception.*;
import java.sql.Date;
import java.io.*;
import java.util.*;
import java.io.IOException;
import org.json.simple.parser.ParseException;

public class Location_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private SQLTwriter sqlwriter = new SQLTwriter();
    private BLlocation bllocation = new BLlocation(sqlreader);
    
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
        return bllocation.getLocationExists(locationPK);
    }
    
    public Location get_location_by_primarykey(ILocationPK locationPK) throws DBException {
        return bllocation.getLocation(locationPK);
    }

    public ArrayList<Location> get_location_with_foreignkey_system(ISystemPK systemPK) throws CustomException {
        return bllocation.getLocations4system(systemPK);
    }
    
    public ArrayList<Location> search_location(ILocationsearch locationsearch) throws CustomException {
        return bllocation.search(locationsearch);
    }
    
    public long search_location_count(ILocationsearch locationsearch) throws CustomException {
        return bllocation.searchcount(locationsearch);
    }

    public void insertLocation(ILocation location) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        bllocation.insertLocation(tq, location);
        sqlwriter.Commit2DB(tq);
    }

    public void updateLocation(ILocation location) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        bllocation.updateLocation(tq, location);
        sqlwriter.Commit2DB(tq);
    }

    public void deleteLocation(ILocation location) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        bllocation.deleteLocation(tq, location);
        sqlwriter.Commit2DB(tq);
    }

    public void delete_all_containing_System(ISystemPK systemPK) throws CustomException {
        SQLTqueue tq = new SQLTqueue();
        bllocation.delete4system(tq, systemPK);
        sqlwriter.Commit2DB(tq);
    }
    
}

