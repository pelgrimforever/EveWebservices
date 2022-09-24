/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */

package eve.BusinessObject.view;

import db.*;
import data.gis.shape.*;
import eve.conversion.entity.EMview_evetype_order_history_month;
import general.exception.*;
import java.util.ArrayList;
import eve.logicview.View_evetype_order_history_month;
import java.sql.Time;

public abstract class Bview_evetype_order_history_month extends ViewBusinessrules {

    public Bview_evetype_order_history_month(SQLreader sqlreader) {
        super(new ViewIO(sqlreader, new EMview_evetype_order_history_month()));
    }
    
    public ArrayList<View_evetype_order_history_month> getView_evetype_order_history_months() throws DBException {
        return (ArrayList<View_evetype_order_history_month>)viewio.getEntities(EMview_evetype_order_history_month.SQLSelectAll);
    }
}
