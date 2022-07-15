/*
 * Generated on 13.6.2022 11:21
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

/**
 * @author Franky Laseure
 */
public class View_tradesystem_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private BLview_tradesystem blview_tradesystem = new BLview_tradesystem(sqlreader);
    
    public View_tradesystem_usecases() {
        this(false);
    }
    
    public View_tradesystem_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blview_tradesystem.setAuthenticated(loggedin);
    }
    
    public ArrayList<View_tradesystem> get_all() throws DBException {
        return blview_tradesystem.getView_tradesystems();
    }
    
//Custom code, do not change this line
//add here custom operations
    public ArrayList<View_tradesystem> getView_tradesystem_for_startsystem_usecase(eve.entity.pk.SystemPK systemPK) throws DBException {
        return blview_tradesystem.getView_tradesystem_Startsystem(systemPK);
    }

    public View_tradesystem getView_tradesystem_for_sell_buy_system_usecase(eve.entity.pk.SystemPK sell_systemPK, eve.entity.pk.SystemPK buy_systemPK) throws DBException {
        return blview_tradesystem.getView_tradesystem(sell_systemPK, buy_systemPK);
    }
//Custom code, do not change this line   

}

