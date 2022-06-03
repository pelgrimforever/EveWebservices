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
import eve.logicview.View_materialinputavg;
import general.exception.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class View_materialinputavg_usecases {

    private boolean loggedin = false;
    private BLview_materialinputavg blview_materialinputavg = new BLview_materialinputavg();
    
    public View_materialinputavg_usecases() {
        this(false);
    }
    
    public View_materialinputavg_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blview_materialinputavg.setAuthenticated(loggedin);
    }
    
    public ArrayList<View_materialinputavg> get_all() throws DBException {
        return blview_materialinputavg.getView_materialinputavgs();
    }
    
//Custom code, do not change this line
//add here custom operations
    public ArrayList<View_materialinputavg> getView_materialinputavgs_for_user_usecase(String username) throws DBException {
        return blview_materialinputavg.getView_materialinputavgs(username);
    }
//Custom code, do not change this line   

}

