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
import eve.logicview.View_stock;
import general.exception.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class View_stock_usecases {

    private boolean loggedin = false;
    private BLview_stock blview_stock = new BLview_stock();
    
    public View_stock_usecases() {
        this(false);
    }
    
    public View_stock_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blview_stock.setAuthenticated(loggedin);
    }
    
    public ArrayList<View_stock> get_all() throws DBException {
        return blview_stock.getView_stocks();
    }
    
//Custom code, do not change this line
//add here custom operations
    public ArrayList<View_stock> getView_stock4username_usecase(String username) throws DBException {
        return blview_stock.getView_stock4username(username);
    }
//Custom code, do not change this line   

}

