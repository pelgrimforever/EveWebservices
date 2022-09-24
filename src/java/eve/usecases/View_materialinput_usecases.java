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

public class View_materialinput_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private BLview_materialinput blview_materialinput = new BLview_materialinput(sqlreader);
    
    public View_materialinput_usecases() {
        this(false);
    }
    
    public View_materialinput_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blview_materialinput.setAuthenticated(loggedin);
    }
    
    public ArrayList<View_materialinput> get_all() throws DBException {
        return blview_materialinput.getView_materialinputs();
    }
    
//Custom code, do not change this line
//add here custom operations
    public ArrayList<View_materialinput> getView_materialinputs_for_user_usecase(String username) throws DBException {
        return blview_materialinput.getView_materialinputs(username);
    }
//Custom code, do not change this line   

}

