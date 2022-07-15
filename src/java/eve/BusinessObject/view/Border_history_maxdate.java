/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 12.6.2022 10:8
 *
 */

package eve.BusinessObject.view;

import db.*;
import data.gis.shape.*;
import eve.conversion.entity.EMorder_history_maxdate;
import general.exception.*;
import java.util.ArrayList;
import eve.logicview.Order_history_maxdate;
import java.sql.Time;

/**
 * @author Franky Laseure
 */
public abstract class Border_history_maxdate extends ViewBusinessrules {

    public Border_history_maxdate(SQLreader sqlreader) {
        super(new ViewIO(sqlreader, new EMorder_history_maxdate()));
    }
    
    public ArrayList<Order_history_maxdate> getOrder_history_maxdates() throws DBException {
        return (ArrayList<Order_history_maxdate>)viewio.getEntities(EMorder_history_maxdate.SQLSelectAll);
    }
}
