/*
 * Generated on 13.4.2022 19:13
 */

package eve.usecases;

import data.conversion.JSONConversion;
import eve.interfaces.searchentity.*;
import eve.logicview.*;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.*;
import eve.logicview.View_materialinput;
import general.exception.*;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class View_materialinput_usecases {

    private boolean loggedin = false;
    private BLview_materialinput blview_materialinput = new BLview_materialinput();
    
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

