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
import eve.logicentity.Security_island;
import eve.logicview.*;
import general.exception.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class Security_island_usecases {

    private boolean loggedin = false;
    private BLsecurity_island blsecurity_island = new BLsecurity_island();
    
    public Security_island_usecases() {
        this(false);
    }
    
    public Security_island_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blsecurity_island.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

    public long count() throws DBException {
        return blsecurity_island.count();
    }
    
    public ArrayList<Security_island> get_all() throws DBException {
        return blsecurity_island.getSecurity_islands();
    }
    
    public boolean getSecurity_islandExists(ISecurity_islandPK security_islandPK) throws DBException {
        return blsecurity_island.getEntityExists(security_islandPK);
    }
    
    public Security_island get_security_island_by_primarykey(ISecurity_islandPK security_islandPK) throws DBException {
        return blsecurity_island.getSecurity_island(security_islandPK);
    }

    public ArrayList<Security_island> search_security_island(ISecurity_islandsearch security_islandsearch) throws ParseException, CustomException {
        return blsecurity_island.search(security_islandsearch);
    }
    
    public long search_security_island_count(ISecurity_islandsearch security_islandsearch) throws ParseException, CustomException {
        return blsecurity_island.searchcount(security_islandsearch);
    }

    public void secureinsertSecurity_island(ISecurity_island security_island) throws DBException, DataException {
        blsecurity_island.secureinsertSecurity_island(security_island);
    }

    public void secureupdateSecurity_island(ISecurity_island security_island) throws DBException, DataException {
        blsecurity_island.secureupdateSecurity_island(security_island);
    }

    public void securedeleteSecurity_island(ISecurity_island security_island) throws DBException, DataException {
        blsecurity_island.securedeleteSecurity_island(security_island);
    }
}

