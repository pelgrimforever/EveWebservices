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

public class View_contractitem_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private BLview_contractitem blview_contractitem = new BLview_contractitem(sqlreader);
    
    public View_contractitem_usecases() {
        this(false);
    }
    
    public View_contractitem_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blview_contractitem.setAuthenticated(loggedin);
    }
    
    public ArrayList<View_contractitem> get_all() throws DBException {
        return blview_contractitem.getView_contractitems();
    }
    
//Custom code, do not change this line
//add here custom operations
    public ArrayList<View_contractitem> getView_contractitems_for_contract_usecase(ContractPK contractPK) throws DBException {
        return blview_contractitem.getView_contractitems(contractPK);
    }
//Custom code, do not change this line   

}

