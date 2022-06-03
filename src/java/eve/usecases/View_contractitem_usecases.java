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
import eve.logicview.View_contractitem;
import general.exception.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class View_contractitem_usecases {

    private boolean loggedin = false;
    private BLview_contractitem blview_contractitem = new BLview_contractitem();
    
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

