/*
 * Generated on 20.4.2022 10:3
 */

package eve.usecases;

import data.conversion.JSONConversion;
import data.interfaces.db.Filedata;
import data.gis.shape.piPoint;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.*;
import eve.interfaces.entity.pk.*;
import eve.logicentity.Allnodes_stargate;
import general.exception.*;
import java.sql.Date;
import java.util.*;
import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class Allnodes_stargate_usecases {

    private boolean loggedin = false;
    private BLallnodes_stargate blallnodes_stargate = new BLallnodes_stargate();
    
    public Allnodes_stargate_usecases() {
        this(false);
    }
    
    public Allnodes_stargate_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blallnodes_stargate.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

    public long count() throws DBException {
        return blallnodes_stargate.count();
    }
    
    public ArrayList<Allnodes_stargate> get_all() throws DBException {
        return blallnodes_stargate.getAllnodes_stargates();
    }
    
    public boolean getAllnodes_stargateExists(IAllnodes_stargatePK allnodes_stargatePK) throws DBException {
        return blallnodes_stargate.getEntityExists(allnodes_stargatePK);
    }
    
    public Allnodes_stargate get_allnodes_stargate_by_primarykey(IAllnodes_stargatePK allnodes_stargatePK) throws DBException {
        return blallnodes_stargate.getAllnodes_stargate(allnodes_stargatePK);
    }

    public ArrayList<Allnodes_stargate> search_allnodes_stargate(IAllnodes_stargatesearch allnodes_stargatesearch) throws CustomException {
        return blallnodes_stargate.search(allnodes_stargatesearch);
    }
    
    public long search_allnodes_stargate_count(IAllnodes_stargatesearch allnodes_stargatesearch) throws CustomException {
        return blallnodes_stargate.searchcount(allnodes_stargatesearch);
    }

    public void secureinsertAllnodes_stargate(IAllnodes_stargate allnodes_stargate) throws DBException, DataException {
        blallnodes_stargate.secureinsertAllnodes_stargate(allnodes_stargate);
    }

    public void secureupdateAllnodes_stargate(IAllnodes_stargate allnodes_stargate) throws DBException, DataException {
        blallnodes_stargate.secureupdateAllnodes_stargate(allnodes_stargate);
    }

    public void securedeleteAllnodes_stargate(IAllnodes_stargate allnodes_stargate) throws DBException, DataException {
        blallnodes_stargate.securedeleteAllnodes_stargate(allnodes_stargate);
    }
}

