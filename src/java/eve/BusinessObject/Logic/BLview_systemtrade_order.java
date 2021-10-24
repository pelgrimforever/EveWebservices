/*
 * BLview_systemtrade_order.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 4.6.2021 14:41
 *
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import eve.BusinessObject.view.Bview_systemtrade_order;
import eve.conversion.entity.EMview_systemtrade_order;
import eve.entity.pk.SystemtradePK;
import java.util.ArrayList;

/**
 * Business Logic Entity class BLview_systemtrade_order
 *
 * Class for manipulating data- and database objects
 * for View View_systemtrade_order and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLview_systemtrade_order extends Bview_systemtrade_order {
//ProjectGenerator: NO AUTHOMATIC UPDATE
	
    /**
     * Constructor, sets View_systemtrade_order as default Entity
     */
    public BLview_systemtrade_order() {
    }

    /**
     * get all View_systemtrade_order for a systemtradePK
     * @param systemtradePK: systemtrade primary key
     * @return ArrayList of View_trade objects
     * @throws DBException
     */
    public ArrayList getView_all4systemtrade(SystemtradePK systemtradePK) throws DBException {
        return getEntities(EMview_systemtrade_order.SQLSelectAll4systemtrade, systemtradePK.getSQLprimarykey());
    }
}
