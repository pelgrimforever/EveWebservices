/*
 * BLview_tradecombined.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 23.10.2021 18:1
 *
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import eve.BusinessObject.view.Bview_tradecombined;
import eve.conversion.entity.EMview_tradecombined;
import eve.entity.pk.SystemPK;
import eve.entity.pk.TradecombinedPK;
import eve.logicview.View_tradecombined;
import java.util.ArrayList;

/**
 * Business Logic Entity class BLview_tradecombined
 *
 * Class for manipulating data- and database objects
 * for View View_tradecombined and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLview_tradecombined extends Bview_tradecombined {
//Metacoder: NO AUTHOMATIC UPDATE
	
    /**
     * Constructor, sets View_tradecombined as default Entity
     */
    public BLview_tradecombined() {
    }

    /**
     * get all View_tradecombined objects with jump count from start system from database
     * @param systemPK System primary key of starting system
     * @return ArrayList of View_trade objects
     * @throws DBException
     */
    public ArrayList getView_tradecombined_Startsystem(SystemPK systemPK) throws DBException {
        return getEntities(EMview_tradecombined.SQLSelectAll4Startingsystem, systemPK.getSQLprimarykey());
    }

    /**
     * get View_tradecombined for Tradecombined primary key
     * @param tradecombinedPK Tradecombined primary key
     * @return View_tradecombined
     * @throws DBException 
     */
    public View_tradecombined getView_tradecombined(TradecombinedPK tradecombinedPK) throws DBException {
        return (View_tradecombined)getEntity(EMview_tradecombined.SQLSelectAll4Tradecombined, tradecombinedPK.getSQLprimarykey());
    }
}
