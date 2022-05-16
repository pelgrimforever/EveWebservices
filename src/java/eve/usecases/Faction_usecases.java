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
import eve.logicentity.Faction;
import eve.logicview.*;
import general.exception.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class Faction_usecases {

    private boolean loggedin = false;
    private BLfaction blfaction = new BLfaction();
    
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
        return blfaction.getEntityExists(factionPK);
    }
    
    public Faction get_faction_by_primarykey(IFactionPK factionPK) throws DBException {
        return blfaction.getFaction(factionPK);
    }

    public ArrayList<Faction> get_faction_with_foreignkey_system(ISystemPK systemPK) throws CustomException {
        return blfaction.getFactions4system(systemPK);
    }
    
    public ArrayList<Faction> search_faction(IFactionsearch factionsearch) throws ParseException, CustomException {
        return blfaction.search(factionsearch);
    }
    
    public long search_faction_count(IFactionsearch factionsearch) throws ParseException, CustomException {
        return blfaction.searchcount(factionsearch);
    }

    public void secureinsertFaction(IFaction faction) throws DBException, DataException {
        blfaction.secureinsertFaction(faction);
    }

    public void secureupdateFaction(IFaction faction) throws DBException, DataException {
        blfaction.secureupdateFaction(faction);
    }

    public void securedeleteFaction(IFaction faction) throws DBException, DataException {
        blfaction.securedeleteFaction(faction);
    }
}

