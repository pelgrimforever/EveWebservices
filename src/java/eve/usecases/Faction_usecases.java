/*
 * Generated on 13.6.2022 11:21
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
import eve.logicentity.Faction;
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
public class Faction_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private SQLTwriter sqlwriter = new SQLTwriter();
    private BLfaction blfaction = new BLfaction(sqlreader);
    
    public Faction_usecases() {
        this(false);
    }
    
    public Faction_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blfaction.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

    public long count() throws DBException {
        return blfaction.count();
    }
    
    public ArrayList<Faction> get_all() throws DBException {
        return blfaction.getFactions();
    }
    
    public boolean getFactionExists(IFactionPK factionPK) throws DBException {
        return blfaction.getFactionExists(factionPK);
    }
    
    public Faction get_faction_by_primarykey(IFactionPK factionPK) throws DBException {
        return blfaction.getFaction(factionPK);
    }

    public ArrayList<Faction> get_faction_with_foreignkey_system(ISystemPK systemPK) throws CustomException {
        return blfaction.getFactions4system(systemPK);
    }
    
    public ArrayList<Faction> search_faction(IFactionsearch factionsearch) throws CustomException {
        return blfaction.search(factionsearch);
    }
    
    public long search_faction_count(IFactionsearch factionsearch) throws CustomException {
        return blfaction.searchcount(factionsearch);
    }

    public void insertFaction(IFaction faction) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blfaction.insertFaction(tq, faction);
        sqlwriter.Commit2DB(tq);
    }

    public void updateFaction(IFaction faction) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blfaction.updateFaction(tq, faction);
        sqlwriter.Commit2DB(tq);
    }

    public void deleteFaction(IFaction faction) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blfaction.deleteFaction(tq, faction);
        sqlwriter.Commit2DB(tq);
    }

    public void delete_all_containing_System(ISystemPK systemPK) throws CustomException {
        SQLTqueue tq = new SQLTqueue();
        blfaction.delete4system(tq, systemPK);
        sqlwriter.Commit2DB(tq);
    }
    
}

