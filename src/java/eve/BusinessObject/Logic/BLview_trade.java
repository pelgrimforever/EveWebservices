/*
 * BLview_trade.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 16.5.2021 16:45
 *
 */

package eve.BusinessObject.Logic;

import db.SQLparameters;
import general.exception.DBException;
import eve.logicview.View_trade;
import eve.BusinessObject.view.Bview_trade;
import eve.conversion.entity.EMview_trade;
import eve.entity.pk.SystemPK;
import java.util.ArrayList;

/**
 * Business Logic Entity class BLview_trade
 *
 * Class for manipulating data- and database objects
 * for View View_trade and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLview_trade extends Bview_trade {
//Metacoder: NO AUTHOMATIC UPDATE
	
    /**
     * Constructor, sets View_trade as default Entity
     */
    public BLview_trade() {
    }

    /**
     * get all View_trade lines starting on systemPK
     * @param startsystemPK: start system primary key
     * @return ArrayList of View_trade objects
     * @throws DBException
     */
    public ArrayList getView_trades_Startsystem(SystemPK systemPK) throws DBException {
        return getEntities(EMview_trade.SQLSelectAll4Startingsystem, systemPK.getSQLprimarykey());
    }

    /**
     * get all Vie_trade lines starting at startsystem, ending at endsystem
     * @param startsystemPK: start system primary key
     * @param endsystemPK: end system primary key
     * @return
     * @throws DBException 
     */
    public ArrayList getView_trades_Startendsystem(SystemPK startsystemPK, SystemPK endsystemPK) throws DBException {
        Object[][] parameter = {{ "startsystemid", startsystemPK.getId() }, { "endsystemid", endsystemPK.getId() }};
        SQLparameters sqlparameters = new SQLparameters(parameter);
        return getEntities(EMview_trade.SQLSelectAll4Startendsystem, sqlparameters);
    }
}
