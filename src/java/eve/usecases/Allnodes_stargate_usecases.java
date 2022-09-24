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
import eve.logicentity.Allnodes_stargate;
import eve.logicview.*;
import eve.usecases.custom.*;
import general.exception.*;
import java.sql.Date;
import java.io.*;
import java.util.*;
import java.io.IOException;
import org.json.simple.parser.ParseException;

public class Allnodes_stargate_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private SQLTwriter sqlwriter = new SQLTwriter();
    private BLallnodes_stargate blallnodes_stargate = new BLallnodes_stargate(sqlreader);
    
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
        return blallnodes_stargate.getAllnodes_stargateExists(allnodes_stargatePK);
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

    public void insertAllnodes_stargate(IAllnodes_stargate allnodes_stargate) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blallnodes_stargate.insertAllnodes_stargate(tq, allnodes_stargate);
        sqlwriter.Commit2DB(tq);
    }

    public void updateAllnodes_stargate(IAllnodes_stargate allnodes_stargate) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blallnodes_stargate.updateAllnodes_stargate(tq, allnodes_stargate);
        sqlwriter.Commit2DB(tq);
    }

    public void deleteAllnodes_stargate(IAllnodes_stargate allnodes_stargate) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blallnodes_stargate.deleteAllnodes_stargate(tq, allnodes_stargate);
        sqlwriter.Commit2DB(tq);
    }

}

