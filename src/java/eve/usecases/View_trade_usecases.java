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

public class View_trade_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private BLview_trade blview_trade = new BLview_trade(sqlreader);
    
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

