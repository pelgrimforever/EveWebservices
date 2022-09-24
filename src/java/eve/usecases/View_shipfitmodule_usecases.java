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

public class View_shipfitmodule_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private BLview_shipfitmodule blview_shipfitmodule = new BLview_shipfitmodule(sqlreader);
    
    public View_shipfitmodule_usecases() {
        this(false);
    }
    
    public View_shipfitmodule_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blview_shipfitmodule.setAuthenticated(loggedin);
    }
    
    public ArrayList<View_shipfitmodule> get_all() throws DBException {
        return blview_shipfitmodule.getView_shipfitmodules();
    }
    
//Custom code, do not change this line
//add here custom operations
    public ArrayList<View_shipfitmodule> getview_shipfitmodules_for_shipfit_user_usecase(String username, String shipname) throws DBException {
        return blview_shipfitmodule.getview_shipfitmodules(username, shipname);
    }
//Custom code, do not change this line   

}

