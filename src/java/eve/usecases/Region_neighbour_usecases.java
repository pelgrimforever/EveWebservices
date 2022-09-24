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
import eve.logicentity.Region_neighbour;
import eve.logicview.*;
import eve.usecases.custom.*;
import general.exception.*;
import java.sql.Date;
import java.io.*;
import java.util.*;
import java.io.IOException;
import org.json.simple.parser.ParseException;

public class Region_neighbour_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private SQLTwriter sqlwriter = new SQLTwriter();
    private BLregion_neighbour blregion_neighbour = new BLregion_neighbour(sqlreader);
    
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
        return blregion_neighbour.getRegion_neighbourExists(region_neighbourPK);
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
    
    public ArrayList<Region_neighbour> search_region_neighbour(IRegion_neighboursearch region_neighboursearch) throws CustomException {
        return blregion_neighbour.search(region_neighboursearch);
    }
    
    public long search_region_neighbour_count(IRegion_neighboursearch region_neighboursearch) throws CustomException {
        return blregion_neighbour.searchcount(region_neighboursearch);
    }

    public void insertRegion_neighbour(IRegion_neighbour region_neighbour) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blregion_neighbour.insertRegion_neighbour(tq, region_neighbour);
        sqlwriter.Commit2DB(tq);
    }

    public void updateRegion_neighbour(IRegion_neighbour region_neighbour) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blregion_neighbour.updateRegion_neighbour(tq, region_neighbour);
        sqlwriter.Commit2DB(tq);
    }

    public void deleteRegion_neighbour(IRegion_neighbour region_neighbour) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blregion_neighbour.deleteRegion_neighbour(tq, region_neighbour);
        sqlwriter.Commit2DB(tq);
    }

    public void delete_all_containing_Regionregion(IRegionPK regionRegionPK) throws CustomException {
        SQLTqueue tq = new SQLTqueue();
        blregion_neighbour.delete4regionRegion(tq, regionRegionPK);
        sqlwriter.Commit2DB(tq);
    }
    
    public void delete_all_containing_Regionneighbour(IRegionPK regionNeighbourPK) throws CustomException {
        SQLTqueue tq = new SQLTqueue();
        blregion_neighbour.delete4regionNeighbour(tq, regionNeighbourPK);
        sqlwriter.Commit2DB(tq);
    }
    
}

