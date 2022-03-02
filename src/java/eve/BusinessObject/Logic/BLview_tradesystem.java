/*
 * BLview_tradesystem.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 2.11.2021 21:14
 *
 */

package eve.BusinessObject.Logic;

import db.SQLparameters;
import general.exception.DBException;
import eve.BusinessObject.view.Bview_tradesystem;
import eve.conversion.entity.EMview_tradesystem;
import eve.entity.pk.SystemPK;
import eve.logicview.View_tradesystem;
import java.util.ArrayList;

/**
 * Business Logic Entity class BLview_tradesystem
 *
 * Class for manipulating data- and database objects
 * for View View_tradesystem and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLview_tradesystem extends Bview_tradesystem {
//Metacoder: NO AUTHOMATIC UPDATE
	
    /**
     * Constructor, sets View_tradesystem as default Entity
     */
    public BLview_tradesystem() {
        this.setLogginrequired(true);
    }

    /**
     * get all View_tradesystem objects with jump count from start system from database
     * @param systemPK System primary key of starting system
     * @return ArrayList of View_tradesystem objects
     * @throws DBException
     */
    public ArrayList getView_tradesystem_Startsystem(SystemPK systemPK) throws DBException {
        return getEntities(EMview_tradesystem.SQLSelectAll4Startingsystem, systemPK.getSQLprimarykey());
    }

    /**
     * get View_tradesystem for sell/buy system primary key combination
     * @param sell_systemPK sell system primary key
     * @param buy_systemPK buy system primary key
     * @return View_tradesystem
     * @throws DBException 
     */
    public View_tradesystem getView_tradesystem(SystemPK sell_systemPK, SystemPK buy_systemPK) throws DBException {
        Object[][] systemparameters = { { "sell_systemid", sell_systemPK.getId() }, { "buy_systemid", buy_systemPK.getId() } };
        SQLparameters parameters = new SQLparameters(systemparameters);
        return (View_tradesystem)getEntity(EMview_tradesystem.SQLSelectAll4sellbuysystem, parameters);
    }
}
