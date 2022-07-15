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
public class View_evetypes_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private BLview_evetypes blview_evetypes = new BLview_evetypes(sqlreader);
    
    public View_evetypes_usecases() {
        this(false);
    }
    
    public View_evetypes_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blview_evetypes.setAuthenticated(loggedin);
    }
    
    public ArrayList<View_evetypes> get_all() throws DBException {
        return blview_evetypes.getView_evetypess();
    }
    
//Custom code, do not change this line
//add here custom operations
    public ArrayList<View_evetypes> getShips_usecase() throws DBException {
        return blview_evetypes.getShips();
    }

    public ArrayList<View_evetypes> getModules_usecase() throws DBException {
        return blview_evetypes.getModules();
    }

    public ArrayList<View_evetypes> getCharges_usecase() throws DBException {
        return blview_evetypes.getCharges();
    }

    public ArrayList<View_evetypes> getDrones_usecase() throws DBException {
        return blview_evetypes.getDrones();
    }

    public ArrayList<View_evetypes> getDeployables_usecase() throws DBException {
        return blview_evetypes.getDeployables();
    }

    public ArrayList<View_evetypes> getMinerals_usecase() throws DBException {
        return blview_evetypes.getMinerals();
    }

    public ArrayList<View_evetypes> getSalvagedmaterials_usecase() throws DBException {
        return blview_evetypes.getSalvagedmaterials();
    }

    public ArrayList<View_evetypes> getBlueprints_usecase(String searchstring) throws DBException {
        return blview_evetypes.getBlueprints(searchstring);
    }

    public View_evetypes getBlueprintresult_usecase(View_evetypes viewevetype) throws DBException {
        return blview_evetypes.getBlueprintresult(viewevetype);
    }

    public ArrayList<View_evetypes> getCommodities_usecase(String searchstring) throws DBException {
        return blview_evetypes.getCommodities(searchstring);
    }

    public ArrayList<View_evetypes> getMaterials_usecase() throws DBException {
        return blview_evetypes.getMaterials();
    }

    public ArrayList<View_evetypes> getPlanetarycommodities_usecase() throws DBException {
        return blview_evetypes.getPlanetarycommodities();
    }
//Custom code, do not change this line   

}

