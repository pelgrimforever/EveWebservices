/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */

package eve.BusinessObject.view;

import db.*;
import data.gis.shape.*;
import eve.conversion.entity.EMview_shipfitorder;
import general.exception.*;
import java.util.ArrayList;
import eve.logicview.View_shipfitorder;
import java.sql.Time;

public abstract class Bview_shipfitorder extends ViewBusinessrules {

    public Bview_shipfitorder(SQLreader sqlreader) {
        super(new ViewIO(sqlreader, new EMview_shipfitorder()));
    }
    
    public ArrayList<View_shipfitorder> getView_shipfitorders() throws DBException {
        return (ArrayList<View_shipfitorder>)viewio.getEntities(EMview_shipfitorder.SQLSelectAll);
    }
}
