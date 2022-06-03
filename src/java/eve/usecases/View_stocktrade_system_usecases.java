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
import eve.logicview.View_stocktrade_system;
import general.exception.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class View_stocktrade_system_usecases {

    private boolean loggedin = false;
    private BLview_stocktrade_system blview_stocktrade_system = new BLview_stocktrade_system();
    
    public View_stocktrade_system_usecases() {
        this(false);
    }
    
    public View_stocktrade_system_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blview_stocktrade_system.setAuthenticated(loggedin);
    }
    
    public ArrayList<View_stocktrade_system> get_all() throws DBException {
        return blview_stocktrade_system.getView_stocktrade_systems();
    }
    
//Custom code, do not change this line
//add here custom operations
    public ArrayList<View_stocktrade_system> getView_stocktrade_system4username_usecase(String username) throws DataException, DBException {
        return blview_stocktrade_system.getView_stocktrade_system4username(username);
    }
//Custom code, do not change this line   

}

