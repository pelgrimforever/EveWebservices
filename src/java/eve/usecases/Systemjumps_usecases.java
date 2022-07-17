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
import eve.logicentity.Systemjumps;
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
public class Systemjumps_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private SQLTwriter sqlwriter = new SQLTwriter();
    private BLsystemjumps blsystemjumps = new BLsystemjumps(sqlreader);
    
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
        return blsystemjumps.getSystemjumpsExists(systemjumpsPK);
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
    
    public ArrayList<Systemjumps> search_systemjumps(ISystemjumpssearch systemjumpssearch) throws CustomException {
        return blsystemjumps.search(systemjumpssearch);
    }
    
    public long search_systemjumps_count(ISystemjumpssearch systemjumpssearch) throws CustomException {
        return blsystemjumps.searchcount(systemjumpssearch);
    }

    public void insertSystemjumps(ISystemjumps systemjumps) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blsystemjumps.insertSystemjumps(tq, systemjumps);
        sqlwriter.Commit2DB(tq);
    }

    public void updateSystemjumps(ISystemjumps systemjumps) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blsystemjumps.updateSystemjumps(tq, systemjumps);
        sqlwriter.Commit2DB(tq);
    }

    public void deleteSystemjumps(ISystemjumps systemjumps) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blsystemjumps.deleteSystemjumps(tq, systemjumps);
        sqlwriter.Commit2DB(tq);
    }

    public void delete_all_containing_Systemsystem_end(ISystemPK systemSystem_endPK) throws CustomException {
        SQLTqueue tq = new SQLTqueue();
        blsystemjumps.delete4systemSystem_end(tq, systemSystem_endPK);
        sqlwriter.Commit2DB(tq);
    }
    
    public void delete_all_containing_Systemsystem_start(ISystemPK systemSystem_startPK) throws CustomException {
        SQLTqueue tq = new SQLTqueue();
        blsystemjumps.delete4systemSystem_start(tq, systemSystem_startPK);
        sqlwriter.Commit2DB(tq);
    }
    
}

