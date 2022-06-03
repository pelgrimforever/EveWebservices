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
import eve.logicview.View_activemodules;
import general.exception.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class View_activemodules_usecases {

    private boolean loggedin = false;
    private BLview_activemodules blview_activemodules = new BLview_activemodules();
    
    public View_activemodules_usecases() {
        this(false);
    }
    
    public View_activemodules_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blview_activemodules.setAuthenticated(loggedin);
    }
    
    public ArrayList<View_activemodules> get_all() throws DBException {
        return blview_activemodules.getView_activemoduless();
    }
    
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

}

