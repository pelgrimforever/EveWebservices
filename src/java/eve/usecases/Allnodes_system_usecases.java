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
import eve.logicentity.Allnodes_system;
import eve.logicview.*;
import general.exception.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class Allnodes_system_usecases {

    private boolean loggedin = false;
    private BLallnodes_system blallnodes_system = new BLallnodes_system();
    
    public Allnodes_system_usecases() {
        this(false);
    }
    
    public Allnodes_system_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blallnodes_system.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

    public long count() throws DBException {
        return blallnodes_system.count();
    }
    
    public ArrayList<Allnodes_system> get_all() throws DBException {
        return blallnodes_system.getAllnodes_systems();
    }
    
    public boolean getAllnodes_systemExists(IAllnodes_systemPK allnodes_systemPK) throws DBException {
        return blallnodes_system.getEntityExists(allnodes_systemPK);
    }
    
    public Allnodes_system get_allnodes_system_by_primarykey(IAllnodes_systemPK allnodes_systemPK) throws DBException {
        return blallnodes_system.getAllnodes_system(allnodes_systemPK);
    }

    public ArrayList<Allnodes_system> search_allnodes_system(IAllnodes_systemsearch allnodes_systemsearch) throws ParseException, CustomException {
        return blallnodes_system.search(allnodes_systemsearch);
    }
    
    public long search_allnodes_system_count(IAllnodes_systemsearch allnodes_systemsearch) throws ParseException, CustomException {
        return blallnodes_system.searchcount(allnodes_systemsearch);
    }

    public void secureinsertAllnodes_system(IAllnodes_system allnodes_system) throws DBException, DataException {
        blallnodes_system.secureinsertAllnodes_system(allnodes_system);
    }

    public void secureupdateAllnodes_system(IAllnodes_system allnodes_system) throws DBException, DataException {
        blallnodes_system.secureupdateAllnodes_system(allnodes_system);
    }

    public void securedeleteAllnodes_system(IAllnodes_system allnodes_system) throws DBException, DataException {
        blallnodes_system.securedeleteAllnodes_system(allnodes_system);
    }
}

