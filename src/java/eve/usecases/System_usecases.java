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
import eve.logicentity.System;
import eve.logicview.*;
import general.exception.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class System_usecases {

    private boolean loggedin = false;
    private BLsystem blsystem = new BLsystem();
    
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
        return blsystem.getEntityExists(systemPK);
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
    
    public ArrayList<System> search_system(ISystemsearch systemsearch) throws ParseException, CustomException {
        return blsystem.search(systemsearch);
    }
    
    public long search_system_count(ISystemsearch systemsearch) throws ParseException, CustomException {
        return blsystem.searchcount(systemsearch);
    }

    public void secureinsertSystem(ISystem system) throws DBException, DataException {
        blsystem.secureinsertSystem(system);
    }

    public void secureupdateSystem(ISystem system) throws DBException, DataException {
        blsystem.secureupdateSystem(system);
    }

    public void securedeleteSystem(ISystem system) throws DBException, DataException {
        blsystem.securedeleteSystem(system);
    }
}

