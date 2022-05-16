/*
 * Generated on 13.4.2022 19:13
 */

package eve.usecases;

import data.conversion.JSONConversion;
import eve.interfaces.searchentity.*;
import eve.logicview.*;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.*;
import eve.logicview.View_tradecombined;
import general.exception.*;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class View_tradecombined_usecases {

    private boolean loggedin = false;
    private BLview_tradecombined blview_tradecombined = new BLview_tradecombined();
    
    public View_tradecombined_usecases() {
        this(false);
    }
    
    public View_tradecombined_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blview_tradecombined.setAuthenticated(loggedin);
    }
    
    public ArrayList<View_tradecombined> get_all() throws DBException {
        return blview_tradecombined.getView_tradecombineds();
    }
    
//Custom code, do not change this line
//add here custom operations
    public ArrayList<View_tradecombined> getView_tradecombined_Startsystem_usecase(eve.entity.pk.SystemPK systemPK) throws DBException {
        return blview_tradecombined.getView_tradecombined_Startsystem(systemPK);
    }

    public View_tradecombined getView_tradecombined_for_primarykey_usecase(TradecombinedPK tradecombinedPK) throws DBException {
        return blview_tradecombined.getView_tradecombined(tradecombinedPK);
    }
//Custom code, do not change this line   

}

