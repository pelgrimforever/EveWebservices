/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 2.11.2021 21:14
 * @author Franky Laseure
 */

package eve.BusinessObject.Logic;

import db.*;
import general.exception.DBException;
import eve.BusinessObject.view.Bview_tradesystem;
import eve.conversion.entity.EMview_tradesystem;
import eve.entity.pk.SystemPK;
import eve.logicview.View_tradesystem;
import java.util.ArrayList;

public class BLview_tradesystem extends Bview_tradesystem {
//Metacoder: NO AUTHOMATIC UPDATE
	
    public BLview_tradesystem(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(true);
    }

    public ArrayList getView_tradesystem_Startsystem(SystemPK systemPK) throws DBException {
        return viewio.getEntities(EMview_tradesystem.SQLSelectAll4Startingsystem, systemPK.getSQLprimarykey());
    }

    public View_tradesystem getView_tradesystem(SystemPK sell_systemPK, SystemPK buy_systemPK) throws DBException {
        Object[][] systemparameters = { { "sell_systemid", sell_systemPK.getId() }, { "buy_systemid", buy_systemPK.getId() } };
        SQLparameters parameters = new SQLparameters(systemparameters);
        return (View_tradesystem)viewio.getEntity(EMview_tradesystem.SQLSelectAll4sellbuysystem, parameters);
    }
}
