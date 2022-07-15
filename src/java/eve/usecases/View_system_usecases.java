/*
 * Generated on 13.6.2022 11:21
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

/**
 * @author Franky Laseure
 */
public class View_system_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private BLview_system blview_system = new BLview_system(sqlreader);
    
    public View_system_usecases() {
        this(false);
    }
    
    public View_system_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blview_system.setAuthenticated(loggedin);
    }
    
    public ArrayList<View_system> get_all() throws DBException {
        return blview_system.getView_systems();
    }
    
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

}

