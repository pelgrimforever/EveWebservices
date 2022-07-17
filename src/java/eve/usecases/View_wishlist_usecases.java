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
public class View_wishlist_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private BLview_wishlist blview_wishlist = new BLview_wishlist(sqlreader);
    
    public View_wishlist_usecases() {
        this(false);
    }
    
    public View_wishlist_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blview_wishlist.setAuthenticated(loggedin);
    }
    
    public ArrayList<View_wishlist> get_all() throws DBException {
        return blview_wishlist.getView_wishlists();
    }
    
//Custom code, do not change this line
//add here custom operations
    public ArrayList<View_wishlist> getView_wishlist4username_usecase(String username) throws DBException {
        return blview_wishlist.getView_wishlist4username(username);
    }
//Custom code, do not change this line   

}

