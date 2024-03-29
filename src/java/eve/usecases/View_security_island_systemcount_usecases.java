/*
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */

package eve.usecases;

import db.*;
import data.conversion.JSONConversion;
import data.gis.shape.piPoint;
import eve.interfaces.searchentity.*;
import eve.logicview.*;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.*;
import eve.logicentity.*;
import eve.logicview.*;
import eve.usecases.custom.*;
import general.exception.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.parser.ParseException;

public class View_security_island_systemcount_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private BLview_security_island_systemcount blview_security_island_systemcount = new BLview_security_island_systemcount(sqlreader);
    
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

