/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */

package eve.BusinessObject.view;

import db.*;
import data.gis.shape.*;
import eve.conversion.entity.EMview_order;
import general.exception.*;
import java.util.ArrayList;
import eve.logicview.View_order;
import java.sql.Time;

public abstract class Bview_order extends ViewBusinessrules {

    public Bview_order(SQLreader sqlreader) {
        super(new ViewIO(sqlreader, new EMview_order()));
    }
    
    public ArrayList<View_order> getView_orders() throws DBException {
        return (ArrayList<View_order>)viewio.getEntities(EMview_order.SQLSelectAll);
    }
}
