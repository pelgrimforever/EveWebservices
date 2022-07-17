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
import eve.logicentity.Security_island;
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
public class Security_island_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private SQLTwriter sqlwriter = new SQLTwriter();
    private BLsecurity_island blsecurity_island = new BLsecurity_island(sqlreader);
    
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
        return blsecurity_island.getSecurity_islandExists(security_islandPK);
    }
    
    public Security_island get_security_island_by_primarykey(ISecurity_islandPK security_islandPK) throws DBException {
        return blsecurity_island.getSecurity_island(security_islandPK);
    }

    public ArrayList<Security_island> search_security_island(ISecurity_islandsearch security_islandsearch) throws CustomException {
        return blsecurity_island.search(security_islandsearch);
    }
    
    public long search_security_island_count(ISecurity_islandsearch security_islandsearch) throws CustomException {
        return blsecurity_island.searchcount(security_islandsearch);
    }

    public void insertSecurity_island(ISecurity_island security_island) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blsecurity_island.insertSecurity_island(tq, security_island);
        sqlwriter.Commit2DB(tq);
    }

    public void updateSecurity_island(ISecurity_island security_island) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blsecurity_island.updateSecurity_island(tq, security_island);
        sqlwriter.Commit2DB(tq);
    }

    public void deleteSecurity_island(ISecurity_island security_island) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blsecurity_island.deleteSecurity_island(tq, security_island);
        sqlwriter.Commit2DB(tq);
    }

}

