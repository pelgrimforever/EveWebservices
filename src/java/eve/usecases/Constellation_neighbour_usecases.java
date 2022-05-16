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
import eve.logicentity.Constellation_neighbour;
import eve.logicview.*;
import general.exception.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class Constellation_neighbour_usecases {

    private boolean loggedin = false;
    private BLconstellation_neighbour blconstellation_neighbour = new BLconstellation_neighbour();
    
    public Constellation_neighbour_usecases() {
        this(false);
    }
    
    public Constellation_neighbour_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blconstellation_neighbour.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

    public long count() throws DBException {
        return blconstellation_neighbour.count();
    }
    
    public ArrayList<Constellation_neighbour> get_all() throws DBException {
        return blconstellation_neighbour.getConstellation_neighbours();
    }
    
    public boolean getConstellation_neighbourExists(IConstellation_neighbourPK constellation_neighbourPK) throws DBException {
        return blconstellation_neighbour.getEntityExists(constellation_neighbourPK);
    }
    
    public Constellation_neighbour get_constellation_neighbour_by_primarykey(IConstellation_neighbourPK constellation_neighbourPK) throws DBException {
        return blconstellation_neighbour.getConstellation_neighbour(constellation_neighbourPK);
    }

    public ArrayList<Constellation_neighbour> get_constellation_neighbour_with_foreignkey_constellationNeighbour(IConstellationPK constellationNeighbourPK) throws CustomException {
        return blconstellation_neighbour.getConstellation_neighbours4constellationNeighbour(constellationNeighbourPK);
    }
    
    public ArrayList<Constellation_neighbour> get_constellation_neighbour_with_foreignkey_constellationConstellation(IConstellationPK constellationConstellationPK) throws CustomException {
        return blconstellation_neighbour.getConstellation_neighbours4constellationConstellation(constellationConstellationPK);
    }
    
    public ArrayList<Constellation_neighbour> search_constellation_neighbour(IConstellation_neighboursearch constellation_neighboursearch) throws ParseException, CustomException {
        return blconstellation_neighbour.search(constellation_neighboursearch);
    }
    
    public long search_constellation_neighbour_count(IConstellation_neighboursearch constellation_neighboursearch) throws ParseException, CustomException {
        return blconstellation_neighbour.searchcount(constellation_neighboursearch);
    }

    public void secureinsertConstellation_neighbour(IConstellation_neighbour constellation_neighbour) throws DBException, DataException {
        blconstellation_neighbour.secureinsertConstellation_neighbour(constellation_neighbour);
    }

    public void secureupdateConstellation_neighbour(IConstellation_neighbour constellation_neighbour) throws DBException, DataException {
        blconstellation_neighbour.secureupdateConstellation_neighbour(constellation_neighbour);
    }

    public void securedeleteConstellation_neighbour(IConstellation_neighbour constellation_neighbour) throws DBException, DataException {
        blconstellation_neighbour.securedeleteConstellation_neighbour(constellation_neighbour);
    }
}

