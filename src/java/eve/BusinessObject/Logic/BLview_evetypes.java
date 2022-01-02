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
    
    private static final long SHIP = 6;
    private static final long MODULE = 7;
    private static final long CHARGE = 8;
    private static final long DRONE = 18;
    private static final long DEPLOYABLE = 22;
	
    /**
     * Constructor, sets View_evetypes as default Entity
     */
    public BLview_evetypes() {
    }

    /**
     * get all evetypes of category ship
     * @return ArrayList of View_evetypes objects
     * @throws DBException
     */
    public ArrayList<View_evetypes> getShips() throws DBException {
        Object[][] parameter = {{ "category", SHIP }};
        SQLparameters sqlparameters = new SQLparameters(parameter);
        return getEntities(EMview_evetypes.SQLSelect4Category, sqlparameters);
    }
    
    /**
     * get all evetypes of category module
     * @return ArrayList of View_evetypes objects
     * @throws DBException
     */
    public ArrayList<View_evetypes> getModules() throws DBException {
        Object[][] parameter = {{ "category", MODULE }};
        SQLparameters sqlparameters = new SQLparameters(parameter);
        return getEntities(EMview_evetypes.SQLSelect4Category, sqlparameters);
    }
    
    /**
     * get all evetypes of category charge
     * @return ArrayList of View_evetypes objects
     * @throws DBException
     */
    public ArrayList<View_evetypes> getCharges() throws DBException {
        Object[][] parameter = {{ "category", CHARGE }};
        SQLparameters sqlparameters = new SQLparameters(parameter);
        return getEntities(EMview_evetypes.SQLSelect4Category, sqlparameters);
    }
    
    /**
     * get all evetypes of category drone
     * @return ArrayList of View_evetypes objects
     * @throws DBException
     */
    public ArrayList<View_evetypes> getDrones() throws DBException {
        Object[][] parameter = {{ "category", DRONE }};
        SQLparameters sqlparameters = new SQLparameters(parameter);
        return getEntities(EMview_evetypes.SQLSelect4Category, sqlparameters);
    }
    
    /**
     * get all evetypes of category deployable
     * @return ArrayList of View_evetypes objects
     * @throws DBException
     */
    public ArrayList<View_evetypes> getDeployables() throws DBException {
        Object[][] parameter = {{ "category", DEPLOYABLE }};
        SQLparameters sqlparameters = new SQLparameters(parameter);
        return getEntities(EMview_evetypes.SQLSelect4Category, sqlparameters);
    }
        
}
