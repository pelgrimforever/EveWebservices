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
import eve.logicentity.System;
import eve.logicview.*;
import eve.usecases.custom.*;
import general.exception.*;
import java.sql.Date;
import java.io.*;
import java.util.*;
import java.io.IOException;
import org.json.simple.parser.ParseException;

public class System_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private SQLTwriter sqlwriter = new SQLTwriter();
    private BLsystem blsystem = new BLsystem(sqlreader);
    
    public System_usecases() {
        this(false);
    }
    
    public System_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blsystem.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

    public long count() throws DBException {
        return blsystem.count();
    }
    
    public ArrayList<System> get_all() throws DBException {
        return blsystem.getSystems();
    }
    
    public boolean getSystemExists(ISystemPK systemPK) throws DBException {
        return blsystem.getSystemExists(systemPK);
    }
    
    public System get_system_by_primarykey(ISystemPK systemPK) throws DBException {
        return blsystem.getSystem(systemPK);
    }

    public ArrayList<System> get_system_with_foreignkey_security_island(ISecurity_islandPK security_islandPK) throws CustomException {
        return blsystem.getSystems4security_island(security_islandPK);
    }
    
    public ArrayList<System> get_system_with_foreignkey_constellation(IConstellationPK constellationPK) throws CustomException {
        return blsystem.getSystems4constellation(constellationPK);
    }
    
    public System get_system_with_externalforeignkey_systemjumpsSystem_end(ISystemjumpsPK systemjumpsSystem_endPK) throws CustomException {
        return blsystem.getSystemjumpssystem_end(systemjumpsSystem_endPK);
    }
    
    public System get_system_with_externalforeignkey_systemjumpsSystem_start(ISystemjumpsPK systemjumpsSystem_startPK) throws CustomException {
        return blsystem.getSystemjumpssystem_start(systemjumpsSystem_startPK);
    }
    
    public System get_system_with_externalforeignkey_tradecombinedBuy_system(ITradecombinedPK tradecombinedBuy_systemPK) throws CustomException {
        return blsystem.getTradecombinedbuy_system(tradecombinedBuy_systemPK);
    }
    
    public System get_system_with_externalforeignkey_tradecombinedSell_system(ITradecombinedPK tradecombinedSell_systemPK) throws CustomException {
        return blsystem.getTradecombinedsell_system(tradecombinedSell_systemPK);
    }
    
    public ArrayList<System> search_system(ISystemsearch systemsearch) throws CustomException {
        return blsystem.search(systemsearch);
    }
    
    public long search_system_count(ISystemsearch systemsearch) throws CustomException {
        return blsystem.searchcount(systemsearch);
    }

    public void insertSystem(ISystem system) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blsystem.insertSystem(tq, system);
        sqlwriter.Commit2DB(tq);
    }

    public void updateSystem(ISystem system) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blsystem.updateSystem(tq, system);
        sqlwriter.Commit2DB(tq);
    }

    public void deleteSystem(ISystem system) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blsystem.deleteSystem(tq, system);
        sqlwriter.Commit2DB(tq);
    }

    public void delete_all_containing_Security_island(ISecurity_islandPK security_islandPK) throws CustomException {
        SQLTqueue tq = new SQLTqueue();
        blsystem.delete4security_island(tq, security_islandPK);
        sqlwriter.Commit2DB(tq);
    }
    
    public void delete_all_containing_Constellation(IConstellationPK constellationPK) throws CustomException {
        SQLTqueue tq = new SQLTqueue();
        blsystem.delete4constellation(tq, constellationPK);
        sqlwriter.Commit2DB(tq);
    }
    
}

