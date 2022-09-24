/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */

package eve.BusinessObject.view;

import db.*;
import data.gis.shape.*;
import eve.conversion.entity.EMview_stocktrade_orders;
import general.exception.*;
import java.util.ArrayList;
import eve.logicview.View_stocktrade_orders;
import java.sql.Time;

public abstract class Bview_stocktrade_orders extends ViewBusinessrules {

    public Bview_stocktrade_orders(SQLreader sqlreader) {
        super(new ViewIO(sqlreader, new EMview_stocktrade_orders()));
    }
    
    public ArrayList<View_stocktrade_orders> getView_stocktrade_orderss() throws DBException {
        return (ArrayList<View_stocktrade_orders>)viewio.getEntities(EMview_stocktrade_orders.SQLSelectAll);
    }
}
