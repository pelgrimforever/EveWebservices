/*
 * Generated on 20.4.2022 10:3
 */

package eve.usecases;

import data.conversion.JSONConversion;
import data.gis.shape.piPoint;
import eve.interfaces.searchentity.*;
import eve.logicview.*;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.*;
import eve.logicview.View_system;
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
    private BLview_system blview_system = new BLview_system();
    
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

