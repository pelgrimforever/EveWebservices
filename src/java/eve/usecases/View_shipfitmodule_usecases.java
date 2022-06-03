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
import eve.logicview.View_shipfitmodule;
import general.exception.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class View_shipfitmodule_usecases {

    private boolean loggedin = false;
    private BLview_shipfitmodule blview_shipfitmodule = new BLview_shipfitmodule();
    
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

