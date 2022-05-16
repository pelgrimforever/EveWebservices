/*
 * Generated on 13.4.2022 19:13
 */

package eve.usecases;

import data.conversion.JSONConversion;
import eve.interfaces.searchentity.*;
import eve.logicview.*;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.*;
import eve.logicview.View_bp_profitperregion;
import general.exception.*;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class View_bp_profitperregion_usecases {

    private boolean loggedin = false;
    private BLview_bp_profitperregion blview_bp_profitperregion = new BLview_bp_profitperregion();
    
    public View_bp_profitperregion_usecases() {
        this(false);
    }
    
    public View_bp_profitperregion_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blview_bp_profitperregion.setAuthenticated(loggedin);
    }
    
    public ArrayList<View_bp_profitperregion> get_all() throws DBException {
        return blview_bp_profitperregion.getView_bp_profitperregions();
    }
    
//Custom code, do not change this line
//add here custom operations
    public ArrayList<View_bp_profitperregion> getView_bp_profitperregions4lastmonth_usecase() throws CustomException {
        return blview_bp_profitperregion.getView_bp_profitperregions4lastmonth();
    }
//Custom code, do not change this line   

}

