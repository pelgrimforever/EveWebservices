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
import eve.logicentity.Constellation_neighbour;
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
public class Constellation_neighbour_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private SQLTwriter sqlwriter = new SQLTwriter();
    private BLconstellation_neighbour blconstellation_neighbour = new BLconstellation_neighbour(sqlreader);
    
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
        return blconstellation_neighbour.getConstellation_neighbourExists(constellation_neighbourPK);
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
    
    public ArrayList<Constellation_neighbour> search_constellation_neighbour(IConstellation_neighboursearch constellation_neighboursearch) throws CustomException {
        return blconstellation_neighbour.search(constellation_neighboursearch);
    }
    
    public long search_constellation_neighbour_count(IConstellation_neighboursearch constellation_neighboursearch) throws CustomException {
        return blconstellation_neighbour.searchcount(constellation_neighboursearch);
    }

    public void insertConstellation_neighbour(IConstellation_neighbour constellation_neighbour) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blconstellation_neighbour.insertConstellation_neighbour(tq, constellation_neighbour);
        sqlwriter.Commit2DB(tq);
    }

    public void updateConstellation_neighbour(IConstellation_neighbour constellation_neighbour) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blconstellation_neighbour.updateConstellation_neighbour(tq, constellation_neighbour);
        sqlwriter.Commit2DB(tq);
    }

    public void deleteConstellation_neighbour(IConstellation_neighbour constellation_neighbour) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blconstellation_neighbour.deleteConstellation_neighbour(tq, constellation_neighbour);
        sqlwriter.Commit2DB(tq);
    }

    public void delete_all_containing_Constellationneighbour(IConstellationPK constellationNeighbourPK) throws CustomException {
        SQLTqueue tq = new SQLTqueue();
        blconstellation_neighbour.delete4constellationNeighbour(tq, constellationNeighbourPK);
        sqlwriter.Commit2DB(tq);
    }
    
    public void delete_all_containing_Constellationconstellation(IConstellationPK constellationConstellationPK) throws CustomException {
        SQLTqueue tq = new SQLTqueue();
        blconstellation_neighbour.delete4constellationConstellation(tq, constellationConstellationPK);
        sqlwriter.Commit2DB(tq);
    }
    
}

