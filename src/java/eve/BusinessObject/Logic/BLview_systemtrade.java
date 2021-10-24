/*
 * BLview_systemtrade.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 29.5.2021 13:26
 *
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import eve.BusinessObject.view.Bview_systemtrade;
import eve.conversion.entity.EMview_systemtrade;
import eve.entity.pk.SystemPK;
import java.util.ArrayList;

/**
 * Business Logic Entity class BLview_systemtrade
 *
 * Class for manipulating data- and database objects
 * for View View_systemtrade and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLview_systemtrade extends Bview_systemtrade {
//ProjectGenerator: NO AUTHOMATIC UPDATE
	
    /**
     * Constructor, sets View_systemtrade as default Entity
     */
    public BLview_systemtrade() {
    }

    /**
     * get all View_systemtrade objects from database
     * @return ArrayList of View_trade objects
     * @throws DBException
     */
    public ArrayList getView_systemtrades_Startsystem(SystemPK systemPK) throws DBException {
        return getEntities(EMview_systemtrade.SQLSelectAll4Startingsystem, systemPK.getSQLprimarykey());
    }
}
