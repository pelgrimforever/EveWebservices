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
import eve.logicentity.Routetype;
import eve.logicview.*;
import general.exception.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class Routetype_usecases {

    private boolean loggedin = false;
    private BLroutetype blroutetype = new BLroutetype();
    
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
        return blroutetype.getEntityExists(routetypePK);
    }
    
    public Routetype get_routetype_by_primarykey(IRoutetypePK routetypePK) throws DBException {
        return blroutetype.getRoutetype(routetypePK);
    }

    public ArrayList<Routetype> get_routetype_with_foreignkey_security_island(ISecurity_islandPK security_islandPK) throws CustomException {
        return blroutetype.getRoutetypes4security_island(security_islandPK);
    }
    
    public ArrayList<Routetype> search_routetype(IRoutetypesearch routetypesearch) throws ParseException, CustomException {
        return blroutetype.search(routetypesearch);
    }
    
    public long search_routetype_count(IRoutetypesearch routetypesearch) throws ParseException, CustomException {
        return blroutetype.searchcount(routetypesearch);
    }

    public void secureinsertRoutetype(IRoutetype routetype) throws DBException, DataException {
        blroutetype.secureinsertRoutetype(routetype);
    }

    public void secureupdateRoutetype(IRoutetype routetype) throws DBException, DataException {
        blroutetype.secureupdateRoutetype(routetype);
    }

    public void securedeleteRoutetype(IRoutetype routetype) throws DBException, DataException {
        blroutetype.securedeleteRoutetype(routetype);
    }
}

