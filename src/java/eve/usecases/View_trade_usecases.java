/*
 * Generated on 13.4.2022 19:13
 */

package eve.usecases;

import data.conversion.JSONConversion;
import eve.interfaces.searchentity.*;
import eve.logicview.*;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.*;
import eve.logicview.View_trade;
import general.exception.*;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class View_trade_usecases {

    private boolean loggedin = false;
    private BLview_trade blview_trade = new BLview_trade();
    
    public View_trade_usecases() {
        this(false);
    }
    
    public View_trade_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blview_trade.setAuthenticated(loggedin);
    }
    
    public ArrayList<View_trade> get_all() throws DBException {
        return blview_trade.getView_trades();
    }
    
//Custom code, do not change this line
//add here custom operations
    public ArrayList<View_trade> getView_trades_Startsystem_usecase(eve.entity.pk.SystemPK systemPK) throws DBException {
        return blview_trade.getView_trades_Startsystem(systemPK);
    }

    public ArrayList<View_trade> getView_trades_Startendsystem_usecase(eve.entity.pk.SystemPK startsystemPK, eve.entity.pk.SystemPK endsystemPK) throws DBException {
        return blview_trade.getView_trades_Startendsystem(startsystemPK, endsystemPK);
    }
//Custom code, do not change this line   

}

