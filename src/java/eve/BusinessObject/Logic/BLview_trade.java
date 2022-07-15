/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 16.5.2021 16:45
 */

package eve.BusinessObject.Logic;

import db.*;
import general.exception.DBException;
import eve.logicview.View_trade;
import eve.BusinessObject.view.Bview_trade;
import eve.conversion.entity.EMview_trade;
import eve.entity.pk.SystemPK;
import java.util.ArrayList;

/**
 * @author Franky Laseure
 */
public class BLview_trade extends Bview_trade {
//Metacoder: NO AUTHOMATIC UPDATE
	
    public BLview_trade(SQLreader sqlreader) {
        super(sqlreader);
    }

    public ArrayList getView_trades_Startsystem(SystemPK systemPK) throws DBException {
        return viewio.getEntities(EMview_trade.SQLSelectAll4Startingsystem, systemPK.getSQLprimarykey());
    }

    public ArrayList getView_trades_Startendsystem(SystemPK startsystemPK, SystemPK endsystemPK) throws DBException {
        Object[][] parameter = {{ "startsystemid", startsystemPK.getId() }, { "endsystemid", endsystemPK.getId() }};
        SQLparameters sqlparameters = new SQLparameters(parameter);
        return viewio.getEntities(EMview_trade.SQLSelectAll4Startendsystem, sqlparameters);
    }
}
