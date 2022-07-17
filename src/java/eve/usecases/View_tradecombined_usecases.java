/*
 * Generated on 17.6.2022 13:4
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
public class View_tradecombined_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private BLview_tradecombined blview_tradecombined = new BLview_tradecombined(sqlreader);
    
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

