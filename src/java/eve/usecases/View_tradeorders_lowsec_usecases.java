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
public class View_tradeorders_lowsec_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private BLview_tradeorders_lowsec blview_tradeorders_lowsec = new BLview_tradeorders_lowsec(sqlreader);
    
    public View_tradeorders_lowsec_usecases() {
        this(false);
    }
    
    public View_tradeorders_lowsec_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blview_tradeorders_lowsec.setAuthenticated(loggedin);
    }
    
    public ArrayList<View_tradeorders_lowsec> get_all() throws DBException {
        return blview_tradeorders_lowsec.getView_tradeorders_lowsecs();
    }
    
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

}

