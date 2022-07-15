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
public class View_bpmaterial_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private BLview_bpmaterial blview_bpmaterial = new BLview_bpmaterial(sqlreader);
    
    public View_bpmaterial_usecases() {
        this(false);
    }
    
    public View_bpmaterial_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blview_bpmaterial.setAuthenticated(loggedin);
    }
    
    public ArrayList<View_bpmaterial> get_all() throws DBException {
        return blview_bpmaterial.getView_bpmaterials();
    }
    
//Custom code, do not change this line
//add here custom operations
    public ArrayList<View_bpmaterial> getView_bpmaterials_for_blueprint_usecase(long blueprintid) throws DBException {
        return blview_bpmaterial.getView_bpmaterials(blueprintid);
    }
//Custom code, do not change this line   

}

