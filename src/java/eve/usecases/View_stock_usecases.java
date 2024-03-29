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

public class View_stock_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private BLview_stock blview_stock = new BLview_stock(sqlreader);
    
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

