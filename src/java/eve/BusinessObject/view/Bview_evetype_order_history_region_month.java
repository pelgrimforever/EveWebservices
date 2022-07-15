/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 12.6.2022 10:8
 *
 */

package eve.BusinessObject.view;

import db.*;
import data.gis.shape.*;
import eve.conversion.entity.EMview_evetype_order_history_region_month;
import general.exception.*;
import java.util.ArrayList;
import eve.logicview.View_evetype_order_history_region_month;
import java.sql.Time;

/**
 * @author Franky Laseure
 */
public abstract class Bview_evetype_order_history_region_month extends ViewBusinessrules {

    public Bview_evetype_order_history_region_month(SQLreader sqlreader) {
        super(new ViewIO(sqlreader, new EMview_evetype_order_history_region_month()));
    }
    
    public ArrayList<View_evetype_order_history_region_month> getView_evetype_order_history_region_months() throws DBException {
        return (ArrayList<View_evetype_order_history_region_month>)viewio.getEntities(EMview_evetype_order_history_region_month.SQLSelectAll);
    }
}
