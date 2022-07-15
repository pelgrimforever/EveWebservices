/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 12.6.2022 10:8
 *
 */

package eve.BusinessObject.view;

import db.*;
import data.gis.shape.*;
import eve.conversion.entity.EMview_contractitem;
import general.exception.*;
import java.util.ArrayList;
import eve.logicview.View_contractitem;
import java.sql.Time;

/**
 * @author Franky Laseure
 */
public abstract class Bview_contractitem extends ViewBusinessrules {

    public Bview_contractitem(SQLreader sqlreader) {
        super(new ViewIO(sqlreader, new EMview_contractitem()));
    }
    
    public ArrayList<View_contractitem> getView_contractitems() throws DBException {
        return (ArrayList<View_contractitem>)viewio.getEntities(EMview_contractitem.SQLSelectAll);
    }
}
