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
import eve.logicentity.Routetype;
import eve.logicview.*;
import eve.usecases.custom.*;
import general.exception.*;
import java.sql.Date;
import java.io.*;
import java.util.*;
import java.io.IOException;
import org.json.simple.parser.ParseException;

public class Routetype_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private SQLTwriter sqlwriter = new SQLTwriter();
    private BLroutetype blroutetype = new BLroutetype(sqlreader);
    
    public Routetype_usecases() {
        this(false);
    }
    
    public Routetype_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blroutetype.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

    public long count() throws DBException {
        return blroutetype.count();
    }
    
    public ArrayList<Routetype> get_all() throws DBException {
        return blroutetype.getRoutetypes();
    }
    
    public boolean getRoutetypeExists(IRoutetypePK routetypePK) throws DBException {
        return blroutetype.getRoutetypeExists(routetypePK);
    }
    
    public Routetype get_routetype_by_primarykey(IRoutetypePK routetypePK) throws DBException {
        return blroutetype.getRoutetype(routetypePK);
    }

    public ArrayList<Routetype> get_routetype_with_foreignkey_security_island(ISecurity_islandPK security_islandPK) throws CustomException {
        return blroutetype.getRoutetypes4security_island(security_islandPK);
    }
    
    public ArrayList<Routetype> search_routetype(IRoutetypesearch routetypesearch) throws CustomException {
        return blroutetype.search(routetypesearch);
    }
    
    public long search_routetype_count(IRoutetypesearch routetypesearch) throws CustomException {
        return blroutetype.searchcount(routetypesearch);
    }

    public void insertRoutetype(IRoutetype routetype) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blroutetype.insertRoutetype(tq, routetype);
        sqlwriter.Commit2DB(tq);
    }

    public void updateRoutetype(IRoutetype routetype) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blroutetype.updateRoutetype(tq, routetype);
        sqlwriter.Commit2DB(tq);
    }

    public void deleteRoutetype(IRoutetype routetype) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blroutetype.deleteRoutetype(tq, routetype);
        sqlwriter.Commit2DB(tq);
    }

    public void delete_all_containing_Security_island(ISecurity_islandPK security_islandPK) throws CustomException {
        SQLTqueue tq = new SQLTqueue();
        blroutetype.delete4security_island(tq, security_islandPK);
        sqlwriter.Commit2DB(tq);
    }
    
}

