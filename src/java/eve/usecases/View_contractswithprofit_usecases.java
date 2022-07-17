/*
 * Generated on 17.6.2022 13:4
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
public class View_contractswithprofit_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private BLview_contractswithprofit blview_contractswithprofit = new BLview_contractswithprofit(sqlreader);
    
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

