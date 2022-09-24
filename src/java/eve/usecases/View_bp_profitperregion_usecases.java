/*
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
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

public class View_bp_profitperregion_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private BLview_bp_profitperregion blview_bp_profitperregion = new BLview_bp_profitperregion(sqlreader);
    
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

