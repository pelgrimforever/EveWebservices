/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 23.10.2021 18:1
 */

package eve.BusinessObject.Logic;

import db.SQLreader;
import general.exception.DBException;
import eve.BusinessObject.view.Bview_tradecombined;
import eve.conversion.entity.EMview_tradecombined;
import eve.entity.pk.SystemPK;
import eve.entity.pk.TradecombinedPK;
import eve.logicview.View_tradecombined;
import java.util.ArrayList;

/**
 * @author Franky Laseure
 */
public class BLview_tradecombined extends Bview_tradecombined {
//Metacoder: NO AUTHOMATIC UPDATE
	
    public BLview_tradecombined(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(true);
    }

    public ArrayList getView_tradecombined_Startsystem(SystemPK systemPK) throws DBException {
        return viewio.getEntities(EMview_tradecombined.SQLSelectAll4Startingsystem, systemPK.getSQLprimarykey());
    }

    public View_tradecombined getView_tradecombined(TradecombinedPK tradecombinedPK) throws DBException {
        return (View_tradecombined)viewio.getEntity(EMview_tradecombined.SQLSelectAll4Tradecombined, tradecombinedPK.getSQLprimarykey());
    }
}
