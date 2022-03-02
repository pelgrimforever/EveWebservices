/*
 * BLview_bpmaterial.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 24.0.2022 17:38
 *
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import db.SQLparameters;
import eve.logicview.View_bpmaterial;
import eve.BusinessObject.view.Bview_bpmaterial;
import eve.conversion.entity.EMview_bpmaterial;
import java.util.ArrayList;

/**
 * Business Logic Entity class BLview_bpmaterial
 *
 * Class for manipulating data- and database objects
 * for View View_bpmaterial and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLview_bpmaterial extends Bview_bpmaterial {
//Metacoder: NO AUTHOMATIC UPDATE
	
    /**
     * Constructor, sets View_bpmaterial as default Entity
     */
    public BLview_bpmaterial() {
        this.setLogginrequired(true);
    }

    /**
     * get all View_bpmaterial for a blueprint (evetype of category blueprint)
     * @return ArrayList of View_bpmaterial objects
     * @throws DBException
     */
    public ArrayList<View_bpmaterial> getView_bpmaterials(long blueprintid) throws DBException {
        Object[][] parameters = {{ "bp", blueprintid }};
        SQLparameters sqlparameters = new SQLparameters(parameters);
        return getEntities(EMview_bpmaterial.SQLSelect4blueprint, sqlparameters);
    }
}
