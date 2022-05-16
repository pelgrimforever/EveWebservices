/*
 * Generated on 13.4.2022 19:13
 */

package eve.usecases;

import data.conversion.JSONConversion;
import eve.interfaces.searchentity.*;
import eve.logicview.*;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.*;
import eve.logicview.View_tradeorders;
import general.exception.*;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class View_tradeorders_usecases {

    private boolean loggedin = false;
    private BLview_tradeorders blview_tradeorders = new BLview_tradeorders();
    
    public View_tradeorders_usecases() {
        this(false);
    }
    
    public View_tradeorders_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blview_tradeorders.setAuthenticated(loggedin);
    }
    
    public ArrayList<View_tradeorders> get_all() throws DBException {
        return blview_tradeorders.getView_tradeorderss();
    }
    
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

}

