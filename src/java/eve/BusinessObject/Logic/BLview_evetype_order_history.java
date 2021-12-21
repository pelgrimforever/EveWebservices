/*
 * BLview_evetype_order_history.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 13.11.2021 18:30
 *
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import eve.logicview.View_evetype_order_history;
import eve.BusinessObject.view.Bview_evetype_order_history;
import eve.conversion.entity.EMview_evetype_order_history;
import eve.interfaces.entity.pk.IEvetypePK;
import java.util.ArrayList;

/**
 * Business Logic Entity class BLview_evetype_order_history
 *
 * Class for manipulating data- and database objects
 * for View View_evetype_order_history and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLview_evetype_order_history extends Bview_evetype_order_history {
//Metacoder: NO AUTHOMATIC UPDATE

    /**
     * get all View_evetype_order_history for an evetypePK
     * @param evetypePK Evetype primary key
     * @return ArrayList of View_evetype_order_history objects
     * @throws DBException
     */
    public ArrayList<View_evetype_order_history> getView_evetype_order_historys(IEvetypePK evetypePK) throws DBException {
        return getEntities(EMview_evetype_order_history.SQLselect4evetype, evetypePK.getSQLprimarykey());
    }
    
    /**
     * Constructor, sets View_evetype_order_history as default Entity
     */
    public BLview_evetype_order_history() {
    }

}
