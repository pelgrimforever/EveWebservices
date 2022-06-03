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
import eve.logicentity.Race;
import general.exception.*;
import java.sql.Date;
import java.util.*;
import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class Race_usecases {

    private boolean loggedin = false;
    private BLrace blrace = new BLrace();
    
    public Race_usecases() {
        this(false);
    }
    
    public Race_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blrace.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

    public long count() throws DBException {
        return blrace.count();
    }
    
    public ArrayList<Race> get_all() throws DBException {
        return blrace.getRaces();
    }
    
    public boolean getRaceExists(IRacePK racePK) throws DBException {
        return blrace.getEntityExists(racePK);
    }
    
    public Race get_race_by_primarykey(IRacePK racePK) throws DBException {
        return blrace.getRace(racePK);
    }

    public ArrayList<Race> get_race_with_foreignkey_faction(IFactionPK factionPK) throws CustomException {
        return blrace.getRaces4faction(factionPK);
    }
    
    public ArrayList<Race> search_race(IRacesearch racesearch) throws CustomException {
        return blrace.search(racesearch);
    }
    
    public long search_race_count(IRacesearch racesearch) throws CustomException {
        return blrace.searchcount(racesearch);
    }

    public void secureinsertRace(IRace race) throws DBException, DataException {
        blrace.secureinsertRace(race);
    }

    public void secureupdateRace(IRace race) throws DBException, DataException {
        blrace.secureupdateRace(race);
    }

    public void securedeleteRace(IRace race) throws DBException, DataException {
        blrace.securedeleteRace(race);
    }
}

