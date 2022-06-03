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
import eve.logicview.View_tradecombined_sell;
import general.exception.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class View_tradecombined_sell_usecases {

    private boolean loggedin = false;
    private BLview_tradecombined_sell blview_tradecombined_sell = new BLview_tradecombined_sell();
    
    public View_tradecombined_sell_usecases() {
        this(false);
    }
    
    public View_tradecombined_sell_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blview_tradecombined_sell.setAuthenticated(loggedin);
    }
    
    public ArrayList<View_tradecombined_sell> get_all() throws DBException {
        return blview_tradecombined_sell.getView_tradecombined_sells();
    }
    
//Custom code, do not change this line
//add here custom operations
    public ArrayList<View_tradecombined_sell> getView_tradecombined_sells_for_primarykey_usecase(TradecombinedPK tradecombinedPK) throws DBException {
        return blview_tradecombined_sell.getView_tradecombined_sells(tradecombinedPK);
    }

    public ArrayList<View_tradecombined_sell> getView_tradecombined_sells_usecase(SystemPK sell_systemPK, SystemPK buy_systemPK) throws DBException {
        return blview_tradecombined_sell.getView_tradecombined_sells(sell_systemPK, buy_systemPK);
    }
//Custom code, do not change this line   

}

