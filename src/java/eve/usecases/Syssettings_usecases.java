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
import eve.logicentity.Syssettings;
import eve.logicview.*;
import general.exception.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class Syssettings_usecases {

    private boolean loggedin = false;
    private BLsyssettings blsyssettings = new BLsyssettings();
    
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
        return blsyssettings.getEntityExists(syssettingsPK);
    }
    
    public Syssettings get_syssettings_by_primarykey(ISyssettingsPK syssettingsPK) throws DBException {
        return blsyssettings.getSyssettings(syssettingsPK);
    }

    public ArrayList<Syssettings> search_syssettings(ISyssettingssearch syssettingssearch) throws ParseException, CustomException {
        return blsyssettings.search(syssettingssearch);
    }
    
    public long search_syssettings_count(ISyssettingssearch syssettingssearch) throws ParseException, CustomException {
        return blsyssettings.searchcount(syssettingssearch);
    }

    public void secureinsertSyssettings(ISyssettings syssettings) throws DBException, DataException {
        blsyssettings.secureinsertSyssettings(syssettings);
    }

    public void secureupdateSyssettings(ISyssettings syssettings) throws DBException, DataException {
        blsyssettings.secureupdateSyssettings(syssettings);
    }

    public void securedeleteSyssettings(ISyssettings syssettings) throws DBException, DataException {
        blsyssettings.securedeleteSyssettings(syssettings);
    }
}

