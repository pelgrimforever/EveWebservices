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
import eve.logicentity.Systemjumps;
import eve.logicview.*;
import general.exception.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class Systemjumps_usecases {

    private boolean loggedin = false;
    private BLsystemjumps blsystemjumps = new BLsystemjumps();
    
    public Systemjumps_usecases() {
        this(false);
    }
    
    public Systemjumps_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blsystemjumps.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

    public long count() throws DBException {
        return blsystemjumps.count();
    }
    
    public ArrayList<Systemjumps> get_all() throws DBException {
        return blsystemjumps.getSystemjumpss();
    }
    
    public boolean getSystemjumpsExists(ISystemjumpsPK systemjumpsPK) throws DBException {
        return blsystemjumps.getEntityExists(systemjumpsPK);
    }
    
    public Systemjumps get_systemjumps_by_primarykey(ISystemjumpsPK systemjumpsPK) throws DBException {
        return blsystemjumps.getSystemjumps(systemjumpsPK);
    }

    public ArrayList<Systemjumps> get_systemjumps_with_foreignkey_systemSystem_end(ISystemPK systemSystem_endPK) throws CustomException {
        return blsystemjumps.getSystemjumpss4systemSystem_end(systemSystem_endPK);
    }
    
    public ArrayList<Systemjumps> get_systemjumps_with_foreignkey_systemSystem_start(ISystemPK systemSystem_startPK) throws CustomException {
        return blsystemjumps.getSystemjumpss4systemSystem_start(systemSystem_startPK);
    }
    
    public ArrayList<Systemjumps> search_systemjumps(ISystemjumpssearch systemjumpssearch) throws ParseException, CustomException {
        return blsystemjumps.search(systemjumpssearch);
    }
    
    public long search_systemjumps_count(ISystemjumpssearch systemjumpssearch) throws ParseException, CustomException {
        return blsystemjumps.searchcount(systemjumpssearch);
    }

    public void secureinsertSystemjumps(ISystemjumps systemjumps) throws DBException, DataException {
        blsystemjumps.secureinsertSystemjumps(systemjumps);
    }

    public void secureupdateSystemjumps(ISystemjumps systemjumps) throws DBException, DataException {
        blsystemjumps.secureupdateSystemjumps(systemjumps);
    }

    public void securedeleteSystemjumps(ISystemjumps systemjumps) throws DBException, DataException {
        blsystemjumps.securedeleteSystemjumps(systemjumps);
    }
}

