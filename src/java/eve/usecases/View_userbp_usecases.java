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

public class View_userbp_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private BLview_userbp blview_userbp = new BLview_userbp(sqlreader);
    
    public View_userbp_usecases() {
        this(false);
    }
    
    public View_userbp_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blview_userbp.setAuthenticated(loggedin);
    }
    
    public ArrayList<View_userbp> get_all() throws DBException {
        return blview_userbp.getView_userbps();
    }
    
//Custom code, do not change this line
//add here custom operations
    public ArrayList<View_userbp> getView_userbps_for_user_usecase(String username) throws DBException {
        return blview_userbp.getView_userbps(username);
    }

    public ArrayList<View_userbp> getView_userbps_for_user_blueprint_usecase(String username, long bp) throws DBException {
        return blview_userbp.getView_userbps(username, bp);
    }
//Custom code, do not change this line   

}

