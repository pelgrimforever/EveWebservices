/*
 * BLview_combinedtrade.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 10.6.2021 18:46
 *
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import db.SQLparameters;
import eve.logicview.View_combinedtrade;
import eve.BusinessObject.view.Bview_combinedtrade;
import eve.conversion.entity.EMview_combinedtrade;
import eve.entity.pk.SystemPK;
import java.util.ArrayList;

/**
 * Business Logic Entity class BLview_combinedtrade
 *
 * Class for manipulating data- and database objects
 * for View View_combinedtrade and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLview_combinedtrade extends Bview_combinedtrade {
//ProjectGenerator: NO AUTHOMATIC UPDATE
	
    /**
     * Constructor, sets View_combinedtrade as default Entity
     */
    public BLview_combinedtrade() {
    }

    /**
     * get all View_combinedtrade objects from database
     * @return ArrayList of View_trade objects
     * @throws DBException
     */
    public ArrayList getView_combinedtrades_Startsystem(SystemPK systemPK) throws DBException {
        return getEntities(EMview_combinedtrade.SQLSelectAll4Startingsystem, systemPK.getSQLprimarykey());
    }

    /**
     * get combinedtrade for startsystem, endsystem,
     * with jumpcount starting from systemPK
     * @return View_combinedtrade objects
     * @throws DBException
     */
    public View_combinedtrade getView_combinedtrade_Startendsystem(SystemPK systemPK, SystemPK startsystemPK, SystemPK endsystemPK) throws DBException {
        Object[][] parameter = {{ "startsystemid", startsystemPK.getId() }, { "endsystemid", endsystemPK.getId() }};
        SQLparameters sqlparameters = new SQLparameters(parameter);
        sqlparameters.add(systemPK.getSQLprimarykey());
        return (View_combinedtrade)getEntity(EMview_combinedtrade.SQLSelect4Startendsystem, sqlparameters);
    }
}
