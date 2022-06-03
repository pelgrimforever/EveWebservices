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
import eve.logicview.View_trade_systemsevetype;
import general.exception.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class View_trade_systemsevetype_usecases {

    private boolean loggedin = false;
    private BLview_trade_systemsevetype blview_trade_systemsevetype = new BLview_trade_systemsevetype();
    
    public View_trade_systemsevetype_usecases() {
        this(false);
    }
    
    public View_trade_systemsevetype_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blview_trade_systemsevetype.setAuthenticated(loggedin);
    }
    
    public ArrayList<View_trade_systemsevetype> get_all() throws DBException {
        return blview_trade_systemsevetype.getView_trade_systemsevetypes();
    }
    
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

}

