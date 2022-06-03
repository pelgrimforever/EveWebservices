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
import eve.logicview.View_evetype_order_history;
import general.exception.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class View_evetype_order_history_usecases {

    private boolean loggedin = false;
    private BLview_evetype_order_history blview_evetype_order_history = new BLview_evetype_order_history();
    
    public View_evetype_order_history_usecases() {
        this(false);
    }
    
    public View_evetype_order_history_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blview_evetype_order_history.setAuthenticated(loggedin);
    }
    
    public ArrayList<View_evetype_order_history> get_all() throws DBException {
        return blview_evetype_order_history.getView_evetype_order_historys();
    }
    
//Custom code, do not change this line
//add here custom operations
    public ArrayList<View_evetype_order_history> getView_evetype_order_historys_for_evetype_usecase(EvetypePK evetypePK) throws DBException {
        return blview_evetype_order_history.getView_evetype_order_historys(evetypePK);
    }
//Custom code, do not change this line   

}

