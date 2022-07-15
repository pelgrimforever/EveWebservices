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
import eve.logicentity.Stargate;
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
public class Stargate_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private SQLTwriter sqlwriter = new SQLTwriter();
    private BLstargate blstargate = new BLstargate(sqlreader);
    
    public Stargate_usecases() {
        this(false);
    }
    
    public Stargate_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blstargate.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

    public long count() throws DBException {
        return blstargate.count();
    }
    
    public ArrayList<Stargate> get_all() throws DBException {
        return blstargate.getStargates();
    }
    
    public boolean getStargateExists(IStargatePK stargatePK) throws DBException {
        return blstargate.getStargateExists(stargatePK);
    }
    
    public Stargate get_stargate_by_primarykey(IStargatePK stargatePK) throws DBException {
        return blstargate.getStargate(stargatePK);
    }

    public ArrayList<Stargate> get_stargate_with_foreignkey_systemSystem(ISystemPK systemSystemPK) throws CustomException {
        return blstargate.getStargates4systemSystem(systemSystemPK);
    }
    
    public ArrayList<Stargate> get_stargate_with_foreignkey_systemTo_system(ISystemPK systemTo_systemPK) throws CustomException {
        return blstargate.getStargates4systemTo_system(systemTo_systemPK);
    }
    
    public ArrayList<Stargate> search_stargate(IStargatesearch stargatesearch) throws CustomException {
        return blstargate.search(stargatesearch);
    }
    
    public long search_stargate_count(IStargatesearch stargatesearch) throws CustomException {
        return blstargate.searchcount(stargatesearch);
    }

    public void insertStargate(IStargate stargate) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blstargate.insertStargate(tq, stargate);
        sqlwriter.Commit2DB(tq);
    }

    public void updateStargate(IStargate stargate) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blstargate.updateStargate(tq, stargate);
        sqlwriter.Commit2DB(tq);
    }

    public void deleteStargate(IStargate stargate) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blstargate.deleteStargate(tq, stargate);
        sqlwriter.Commit2DB(tq);
    }

    public void delete_all_containing_Systemsystem(ISystemPK systemSystemPK) throws CustomException {
        SQLTqueue tq = new SQLTqueue();
        blstargate.delete4systemSystem(tq, systemSystemPK);
        sqlwriter.Commit2DB(tq);
    }
    
    public void delete_all_containing_Systemto_system(ISystemPK systemTo_systemPK) throws CustomException {
        SQLTqueue tq = new SQLTqueue();
        blstargate.delete4systemTo_system(tq, systemTo_systemPK);
        sqlwriter.Commit2DB(tq);
    }
    
}

