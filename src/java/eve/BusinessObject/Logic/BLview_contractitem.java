/*
 * BLview_contractitem.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 9.0.2022 7:52
 *
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import eve.logicview.View_contractitem;
import eve.BusinessObject.view.Bview_contractitem;
import eve.conversion.entity.EMview_contractitem;
import eve.entity.pk.ContractPK;
import java.util.ArrayList;

/**
 * Business Logic Entity class BLview_contractitem
 *
 * Class for manipulating data- and database objects
 * for View View_contractitem and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLview_contractitem extends Bview_contractitem {
//Metacoder: NO AUTHOMATIC UPDATE
	
    /**
     * Constructor, sets View_contractitem as default Entity
     */
    public BLview_contractitem() {
        this.setLogginrequired(true);
    }

    /**
     * get all View_contractitem objects for a contract
     * @return ArrayList of View_contractitem objects
     * @throws DBException
     */
    public ArrayList<View_contractitem> getView_contractitems(ContractPK contractPK) throws DBException {
        return getEntities(EMview_contractitem.SQLSelect4contract, contractPK.getSQLprimarykey());
    }

}
