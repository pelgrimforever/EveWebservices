/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 13.11.2021 18:30
 */

package eve.BusinessObject.Logic;

import db.SQLreader;
import general.exception.DBException;
import eve.logicview.View_evetype_order_history;
import eve.BusinessObject.view.Bview_evetype_order_history;
import eve.conversion.entity.EMview_evetype_order_history;
import eve.interfaces.entity.pk.IEvetypePK;
import java.util.ArrayList;

/**
 * @author Franky Laseure
 */
public class BLview_evetype_order_history extends Bview_evetype_order_history {
//Metacoder: NO AUTHOMATIC UPDATE

    public ArrayList<View_evetype_order_history> getView_evetype_order_historys(IEvetypePK evetypePK) throws DBException {
        return viewio.getEntities(EMview_evetype_order_history.SQLselect4evetype, evetypePK.getSQLprimarykey());
    }
    
    public BLview_evetype_order_history(SQLreader sqlreader) {
        super(sqlreader);
    }

}
