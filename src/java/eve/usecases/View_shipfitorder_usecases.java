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
import eve.logicview.View_shipfitorder;
import general.exception.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class View_shipfitorder_usecases {

    private boolean loggedin = false;
    private BLview_shipfitorder blview_shipfitorder = new BLview_shipfitorder();
    
    public View_shipfitorder_usecases() {
        this(false);
    }
    
    public View_shipfitorder_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blview_shipfitorder.setAuthenticated(loggedin);
    }
    
    public ArrayList<View_shipfitorder> get_all() throws DBException {
        return blview_shipfitorder.getView_shipfitorders();
    }
    
//Custom code, do not change this line
//add here custom operations
    public ArrayList<View_shipfitorder> getView_shipfitorders_for_user_usecase(String username) throws DBException {
        return blview_shipfitorder.getView_shipfitorders(username);
    }
//Custom code, do not change this line   

}

