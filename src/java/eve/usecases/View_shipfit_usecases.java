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
public class View_shipfit_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private BLview_shipfit blview_shipfit = new BLview_shipfit(sqlreader);
    
    public View_shipfit_usecases() {
        this(false);
    }
    
    public View_shipfit_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blview_shipfit.setAuthenticated(loggedin);
    }
    
    public ArrayList<View_shipfit> get_all() throws DBException {
        return blview_shipfit.getView_shipfits();
    }
    
//Custom code, do not change this line
//add here custom operations
    public ArrayList<View_shipfit> getView_shipfits4username_usecase(String username) throws DBException {
        return blview_shipfit.getView_shipfits4username(username);
    }
//Custom code, do not change this line   

}

