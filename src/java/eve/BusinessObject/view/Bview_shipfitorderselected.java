/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */

package eve.BusinessObject.view;

import db.*;
import data.gis.shape.*;
import eve.conversion.entity.EMview_shipfitorderselected;
import general.exception.*;
import java.util.ArrayList;
import eve.logicview.View_shipfitorderselected;
import java.sql.Time;

public abstract class Bview_shipfitorderselected extends ViewBusinessrules {

    public Bview_shipfitorderselected(SQLreader sqlreader) {
        super(new ViewIO(sqlreader, new EMview_shipfitorderselected()));
    }
    
    public ArrayList<View_shipfitorderselected> getView_shipfitorderselecteds() throws DBException {
        return (ArrayList<View_shipfitorderselected>)viewio.getEntities(EMview_shipfitorderselected.SQLSelectAll);
    }
}
