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
import eve.logicentity.Race;
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
public class Race_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private SQLTwriter sqlwriter = new SQLTwriter();
    private BLrace blrace = new BLrace(sqlreader);
    
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
        return blrace.getRaceExists(racePK);
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

    public void insertRace(IRace race) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blrace.insertRace(tq, race);
        sqlwriter.Commit2DB(tq);
    }

    public void updateRace(IRace race) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blrace.updateRace(tq, race);
        sqlwriter.Commit2DB(tq);
    }

    public void deleteRace(IRace race) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blrace.deleteRace(tq, race);
        sqlwriter.Commit2DB(tq);
    }

    public void delete_all_containing_Faction(IFactionPK factionPK) throws CustomException {
        SQLTqueue tq = new SQLTqueue();
        blrace.delete4faction(tq, factionPK);
        sqlwriter.Commit2DB(tq);
    }
    
}

