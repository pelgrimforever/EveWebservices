/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */

package eve.BusinessObject.view;

import db.*;
import data.gis.shape.*;
import eve.conversion.entity.EMview_stocktrade_system;
import general.exception.*;
import java.util.ArrayList;
import eve.logicview.View_stocktrade_system;
import java.sql.Time;

public abstract class Bview_stocktrade_system extends ViewBusinessrules {

    public Bview_stocktrade_system(SQLreader sqlreader) {
        super(new ViewIO(sqlreader, new EMview_stocktrade_system()));
    }
    
    public ArrayList<View_stocktrade_system> getView_stocktrade_systems() throws DBException {
        return (ArrayList<View_stocktrade_system>)viewio.getEntities(EMview_stocktrade_system.SQLSelectAll);
    }
}
