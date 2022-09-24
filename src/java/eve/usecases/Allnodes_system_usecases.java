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
import eve.logicentity.Allnodes_system;
import eve.logicview.*;
import eve.usecases.custom.*;
import general.exception.*;
import java.sql.Date;
import java.io.*;
import java.util.*;
import java.io.IOException;
import org.json.simple.parser.ParseException;

public class Allnodes_system_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private SQLTwriter sqlwriter = new SQLTwriter();
    private BLallnodes_system blallnodes_system = new BLallnodes_system(sqlreader);
    
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
        return blallnodes_system.getAllnodes_systemExists(allnodes_systemPK);
    }
    
    public Allnodes_system get_allnodes_system_by_primarykey(IAllnodes_systemPK allnodes_systemPK) throws DBException {
        return blallnodes_system.getAllnodes_system(allnodes_systemPK);
    }

    public ArrayList<Allnodes_system> search_allnodes_system(IAllnodes_systemsearch allnodes_systemsearch) throws CustomException {
        return blallnodes_system.search(allnodes_systemsearch);
    }
    
    public long search_allnodes_system_count(IAllnodes_systemsearch allnodes_systemsearch) throws CustomException {
        return blallnodes_system.searchcount(allnodes_systemsearch);
    }

    public void insertAllnodes_system(IAllnodes_system allnodes_system) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blallnodes_system.insertAllnodes_system(tq, allnodes_system);
        sqlwriter.Commit2DB(tq);
    }

    public void updateAllnodes_system(IAllnodes_system allnodes_system) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blallnodes_system.updateAllnodes_system(tq, allnodes_system);
        sqlwriter.Commit2DB(tq);
    }

    public void deleteAllnodes_system(IAllnodes_system allnodes_system) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blallnodes_system.deleteAllnodes_system(tq, allnodes_system);
        sqlwriter.Commit2DB(tq);
    }

}

