/*
 * Generated on 13.4.2022 19:13
 */

package eve.usecases;

import data.conversion.JSONConversion;
import eve.interfaces.searchentity.*;
import eve.logicview.*;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.*;
import eve.logicview.View_security_island_systemcount;
import general.exception.*;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class View_security_island_systemcount_usecases {

    private boolean loggedin = false;
    private BLview_security_island_systemcount blview_security_island_systemcount = new BLview_security_island_systemcount();
    
    public View_security_island_systemcount_usecases() {
        this(false);
    }
    
    public View_security_island_systemcount_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blview_security_island_systemcount.setAuthenticated(loggedin);
    }
    
    public ArrayList<View_security_island_systemcount> get_all() throws DBException {
        return blview_security_island_systemcount.getView_security_island_systemcounts();
    }
    
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

}

