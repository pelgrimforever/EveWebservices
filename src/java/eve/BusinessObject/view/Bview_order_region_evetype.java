/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 12.6.2022 10:8
 *
 */

package eve.BusinessObject.view;

import db.*;
import data.gis.shape.*;
import eve.conversion.entity.EMview_order_region_evetype;
import general.exception.*;
import java.util.ArrayList;
import eve.logicview.View_order_region_evetype;
import java.sql.Time;

/**
 * @author Franky Laseure
 */
public abstract class Bview_order_region_evetype extends ViewBusinessrules {

    public Bview_order_region_evetype(SQLreader sqlreader) {
        super(new ViewIO(sqlreader, new EMview_order_region_evetype()));
    }
    
    public ArrayList<View_order_region_evetype> getView_order_region_evetypes() throws DBException {
        return (ArrayList<View_order_region_evetype>)viewio.getEntities(EMview_order_region_evetype.SQLSelectAll);
    }
}
