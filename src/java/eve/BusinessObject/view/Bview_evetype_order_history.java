/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 12.6.2022 10:8
 *
 */

package eve.BusinessObject.view;

import db.*;
import data.gis.shape.*;
import eve.conversion.entity.EMview_evetype_order_history;
import general.exception.*;
import java.util.ArrayList;
import eve.logicview.View_evetype_order_history;
import java.sql.Time;

/**
 * @author Franky Laseure
 */
public abstract class Bview_evetype_order_history extends ViewBusinessrules {

    public Bview_evetype_order_history(SQLreader sqlreader) {
        super(new ViewIO(sqlreader, new EMview_evetype_order_history()));
    }
    
    public ArrayList<View_evetype_order_history> getView_evetype_order_historys() throws DBException {
        return (ArrayList<View_evetype_order_history>)viewio.getEntities(EMview_evetype_order_history.SQLSelectAll);
    }
}
