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
public class View_shipfitorderselected_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private BLview_shipfitorderselected blview_shipfitorderselected = new BLview_shipfitorderselected(sqlreader);
    
    public View_shipfitorderselected_usecases() {
        this(false);
    }
    
    public View_shipfitorderselected_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blview_shipfitorderselected.setAuthenticated(loggedin);
    }
    
    public ArrayList<View_shipfitorderselected> get_all() throws DBException {
        return blview_shipfitorderselected.getView_shipfitorderselecteds();
    }
    
//Custom code, do not change this line
//add here custom operations
    public ArrayList<View_shipfitorderselected> blview_shipfitorderselected_for_user_usecase(String username) throws DBException {
        return blview_shipfitorderselected.getView_shipfitorderselecteds(username);
    }

    public ArrayList<View_shipfitorderselected> blview_shipfitorderselected_for_user_system_usecase(String username, long systemid) throws DBException {
        return blview_shipfitorderselected.getView_shipfitorderselecteds(username, systemid);
    }
//Custom code, do not change this line   

}

