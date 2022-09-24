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
import eve.logicentity.Constellation;
import eve.logicview.*;
import eve.usecases.custom.*;
import general.exception.*;
import java.sql.Date;
import java.io.*;
import java.util.*;
import java.io.IOException;
import org.json.simple.parser.ParseException;

public class Constellation_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private SQLTwriter sqlwriter = new SQLTwriter();
    private BLconstellation blconstellation = new BLconstellation(sqlreader);
    
    public Constellation_usecases() {
        this(false);
    }
    
    public Constellation_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blconstellation.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

    public long count() throws DBException {
        return blconstellation.count();
    }
    
    public ArrayList<Constellation> get_all() throws DBException {
        return blconstellation.getConstellations();
    }
    
    public boolean getConstellationExists(IConstellationPK constellationPK) throws DBException {
        return blconstellation.getConstellationExists(constellationPK);
    }
    
    public Constellation get_constellation_by_primarykey(IConstellationPK constellationPK) throws DBException {
        return blconstellation.getConstellation(constellationPK);
    }

    public ArrayList<Constellation> get_constellation_with_foreignkey_region(IRegionPK regionPK) throws CustomException {
        return blconstellation.getConstellations4region(regionPK);
    }
    
    public Constellation get_constellation_with_externalforeignkey_constellation_neighbourNeighbour(IConstellation_neighbourPK constellation_neighbourNeighbourPK) throws CustomException {
        return blconstellation.getConstellation_neighbourneighbour(constellation_neighbourNeighbourPK);
    }
    
    public Constellation get_constellation_with_externalforeignkey_constellation_neighbourConstellation(IConstellation_neighbourPK constellation_neighbourConstellationPK) throws CustomException {
        return blconstellation.getConstellation_neighbourconstellation(constellation_neighbourConstellationPK);
    }
    
    public ArrayList<Constellation> search_constellation(IConstellationsearch constellationsearch) throws CustomException {
        return blconstellation.search(constellationsearch);
    }
    
    public long search_constellation_count(IConstellationsearch constellationsearch) throws CustomException {
        return blconstellation.searchcount(constellationsearch);
    }

    public void insertConstellation(IConstellation constellation) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blconstellation.insertConstellation(tq, constellation);
        sqlwriter.Commit2DB(tq);
    }

    public void updateConstellation(IConstellation constellation) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blconstellation.updateConstellation(tq, constellation);
        sqlwriter.Commit2DB(tq);
    }

    public void deleteConstellation(IConstellation constellation) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blconstellation.deleteConstellation(tq, constellation);
        sqlwriter.Commit2DB(tq);
    }

    public void delete_all_containing_Region(IRegionPK regionPK) throws CustomException {
        SQLTqueue tq = new SQLTqueue();
        blconstellation.delete4region(tq, regionPK);
        sqlwriter.Commit2DB(tq);
    }
    
}

