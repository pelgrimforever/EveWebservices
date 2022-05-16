/*
 * Generated on 13.4.2022 19:13
 */

package eve.usecases;

import data.conversion.JSONConversion;
import eve.interfaces.searchentity.*;
import eve.logicview.*;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.*;
import eve.logicview.View_contractswithprofit;
import general.exception.*;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class View_contractswithprofit_usecases {

    private boolean loggedin = false;
    private BLview_contractswithprofit blview_contractswithprofit = new BLview_contractswithprofit();
    
    public View_contractswithprofit_usecases() {
        this(false);
    }
    
    public View_contractswithprofit_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blview_contractswithprofit.setAuthenticated(loggedin);
    }
    
    public ArrayList<View_contractswithprofit> get_all() throws DBException {
        return blview_contractswithprofit.getView_contractswithprofits();
    }
    
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

}

