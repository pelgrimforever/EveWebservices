/*
 * BLview_evetypes.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 18.11.2021 18:23
 *
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import db.SQLparameters;
import eve.logicview.View_evetypes;
import eve.BusinessObject.view.Bview_evetypes;
import eve.conversion.entity.EMview_evetypes;
import eve.searchentity.View_evetypessearch;
import java.util.ArrayList;

/**
 * Business Logic Entity class BLview_evetypes
 *
 * Class for manipulating data- and database objects
 * for View View_evetypes and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLview_evetypes extends Bview_evetypes {
//Metacoder: NO AUTHOMATIC UPDATE
    
    /**
     * Constructor, sets View_evetypes as default Entity
     */
    public BLview_evetypes() {
        this.setLogginrequired(true);
    }

    /**
     * get all evetypes of category ship
     * @return ArrayList of View_evetypes objects
     * @throws DBException
     */
    public ArrayList<View_evetypes> getShips() throws DBException {
        Object[][] parameter = {{ "category", BLcategory.SHIP }};
        SQLparameters sqlparameters = new SQLparameters(parameter);
        return getEntities(EMview_evetypes.SQLSelect4Category, sqlparameters);
    }
    
    /**
     * get all evetypes of category module
     * @return ArrayList of View_evetypes objects
     * @throws DBException
     */
    public ArrayList<View_evetypes> getModules() throws DBException {
        Object[][] parameter = {{ "category", BLcategory.MODULE }};
        SQLparameters sqlparameters = new SQLparameters(parameter);
        return getEntities(EMview_evetypes.SQLSelect4Category, sqlparameters);
    }
    
    /**
     * get all evetypes of category charge
     * @return ArrayList of View_evetypes objects
     * @throws DBException
     */
    public ArrayList<View_evetypes> getCharges() throws DBException {
        Object[][] parameter = {{ "category", BLcategory.CHARGE }};
        SQLparameters sqlparameters = new SQLparameters(parameter);
        return getEntities(EMview_evetypes.SQLSelect4Category, sqlparameters);
    }
    
    /**
     * get all evetypes of category drone
     * @return ArrayList of View_evetypes objects
     * @throws DBException
     */
    public ArrayList<View_evetypes> getDrones() throws DBException {
        Object[][] parameter = {{ "category", BLcategory.DRONE }};
        SQLparameters sqlparameters = new SQLparameters(parameter);
        return getEntities(EMview_evetypes.SQLSelect4Category, sqlparameters);
    }
    
    /**
     * get all evetypes of category deployable
     * @return ArrayList of View_evetypes objects
     * @throws DBException
     */
    public ArrayList<View_evetypes> getDeployables() throws DBException {
        Object[][] parameter = {{ "category", BLcategory.DEPLOYABLE }};
        SQLparameters sqlparameters = new SQLparameters(parameter);
        return getEntities(EMview_evetypes.SQLSelect4Category, sqlparameters);
    }
        
    /**
     * get all evetypes of typegroup minerals
     * @return ArrayList of View_evetypes objects
     * @throws DBException
     */
    public ArrayList<View_evetypes> getMinerals() throws DBException {
        Object[][] parameter = {{ "typegroupid", BLtypegroup.MINERALS }};
        SQLparameters sqlparameters = new SQLparameters(parameter);
        return getEntities(EMview_evetypes.SQLSelect4Typegroup, sqlparameters);
    }
        
    /**
     * get all evetypes of typegroup salvaged material
     * @return ArrayList of View_evetypes objects
     * @throws DBException
     */
    public ArrayList<View_evetypes> getSalvagedmaterials() throws DBException {
        Object[][] parameter = {{ "typegroupid", BLtypegroup.SALVAGEDMATERIAL }};
        SQLparameters sqlparameters = new SQLparameters(parameter);
        return getEntities(EMview_evetypes.SQLSelect4Typegroup, sqlparameters);
    }
        
    /**
     * get all evetypes of category BPO matching searchstring
     * @return ArrayList of View_evetypes objects
     * @throws DBException
     */
    public ArrayList<View_evetypes> getBlueprints(String searchstring) throws DBException {
        Object[][] parameter = {{ "category", BLcategory.BLUEPRINT }, { "searchstring", searchstring }};
        SQLparameters sqlparameters = new SQLparameters(parameter);
        return getEntities(EMview_evetypes.SQLSelect4Categorysearch, sqlparameters);
    }

    /**
     * get result evetype from a blueprint
     * @param bpview: View_evetypes blueprint
     * @return View_evetypes result
     * @throws DBException 
     */
    public View_evetypes getBlueprintresult(View_evetypes bpview) throws DBException {
        int bpsuffixlength = 10; //" Blueprint" at end of a BP name 
        String bpname = bpview.getName();
        String name = bpname.substring(0, bpname.length() - bpsuffixlength);
        View_evetypessearch search = new View_evetypessearch();
        String[] names = { name };
        search.name(names);
        ArrayList<View_evetypes> viewevetypes = this.search(search);
        View_evetypes result = null;
        if(viewevetypes.size()>0) {
            result = viewevetypes.get(0);
        }
        return result;
    }
    
    /**
     * get all evetypes of category commodity matching searchstring
     * @return ArrayList of View_evetypes objects
     * @throws DBException
     */
    public ArrayList<View_evetypes> getCommodities(String searchstring) throws DBException {
        Object[][] parameter = {{ "category", BLcategory.COMMODITY }, { "searchstring", searchstring }};
        SQLparameters sqlparameters = new SQLparameters(parameter);
        return getEntities(EMview_evetypes.SQLSelect4Categorysearch, sqlparameters);
    }

    /**
     * get all evetypes of category material
     * @return ArrayList of View_evetypes objects
     * @throws DBException
     */
    public ArrayList<View_evetypes> getMaterials() throws DBException {
        Object[][] parameter = {{ "category", BLcategory.MATERIAL }};
        SQLparameters sqlparameters = new SQLparameters(parameter);
        return getEntities(EMview_evetypes.SQLSelect4Category, sqlparameters);
    }
    
    /**
     * get all evetypes of category planetary commodity
     * @return ArrayList of View_evetypes objects
     * @throws DBException
     */
    public ArrayList<View_evetypes> getPlanetarycommodities() throws DBException {
        Object[][] parameter = {{ "category", BLcategory.PLANETARYCOMMODITY }};
        SQLparameters sqlparameters = new SQLparameters(parameter);
        return getEntities(EMview_evetypes.SQLSelect4Category, sqlparameters);
    }
    
    
}
