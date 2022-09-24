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
import eve.logicentity.Syssettings;
import eve.logicview.*;
import eve.usecases.custom.*;
import general.exception.*;
import java.sql.Date;
import java.io.*;
import java.util.*;
import java.io.IOException;
import org.json.simple.parser.ParseException;

public class Syssettings_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private SQLTwriter sqlwriter = new SQLTwriter();
    private BLsyssettings blsyssettings = new BLsyssettings(sqlreader);
    
    public Syssettings_usecases() {
        this(false);
    }
    
    public Syssettings_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blsyssettings.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

    public long count() throws DBException {
        return blsyssettings.count();
    }
    
    public ArrayList<Syssettings> get_all() throws DBException {
        return blsyssettings.getSyssettingss();
    }
    
    public boolean getSyssettingsExists(ISyssettingsPK syssettingsPK) throws DBException {
        return blsyssettings.getSyssettingsExists(syssettingsPK);
    }
    
    public Syssettings get_syssettings_by_primarykey(ISyssettingsPK syssettingsPK) throws DBException {
        return blsyssettings.getSyssettings(syssettingsPK);
    }

    public ArrayList<Syssettings> search_syssettings(ISyssettingssearch syssettingssearch) throws CustomException {
        return blsyssettings.search(syssettingssearch);
    }
    
    public long search_syssettings_count(ISyssettingssearch syssettingssearch) throws CustomException {
        return blsyssettings.searchcount(syssettingssearch);
    }

    public void insertSyssettings(ISyssettings syssettings) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blsyssettings.insertSyssettings(tq, syssettings);
        sqlwriter.Commit2DB(tq);
    }

    public void updateSyssettings(ISyssettings syssettings) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blsyssettings.updateSyssettings(tq, syssettings);
        sqlwriter.Commit2DB(tq);
    }

    public void deleteSyssettings(ISyssettings syssettings) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blsyssettings.deleteSyssettings(tq, syssettings);
        sqlwriter.Commit2DB(tq);
    }

}

