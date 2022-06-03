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
import eve.logicview.View_order_region_evetype;
import general.exception.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class View_order_region_evetype_usecases {

    private boolean loggedin = false;
    private BLview_order_region_evetype blview_order_region_evetype = new BLview_order_region_evetype();
    
    public View_order_region_evetype_usecases() {
        this(false);
    }
    
    public View_order_region_evetype_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blview_order_region_evetype.setAuthenticated(loggedin);
    }
    
    public ArrayList<View_order_region_evetype> get_all() throws DBException {
        return blview_order_region_evetype.getView_order_region_evetypes();
    }
    
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

}

