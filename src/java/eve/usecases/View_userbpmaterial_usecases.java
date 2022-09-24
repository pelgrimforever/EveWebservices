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

public class View_userbpmaterial_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private BLview_userbpmaterial blview_userbpmaterial = new BLview_userbpmaterial(sqlreader);
    
    public View_userbpmaterial_usecases() {
        this(false);
    }
    
    public View_userbpmaterial_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blview_userbpmaterial.setAuthenticated(loggedin);
    }
    
    public ArrayList<View_userbpmaterial> get_all() throws DBException {
        return blview_userbpmaterial.getView_userbpmaterials();
    }
    
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

}

