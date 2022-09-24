/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */

package eve.BusinessObject.view;

import db.*;
import data.gis.shape.*;
import eve.conversion.entity.EMview_bp_profitperregion;
import general.exception.*;
import java.util.ArrayList;
import eve.logicview.View_bp_profitperregion;
import java.sql.Time;

public abstract class Bview_bp_profitperregion extends ViewBusinessrules {

    public Bview_bp_profitperregion(SQLreader sqlreader) {
        super(new ViewIO(sqlreader, new EMview_bp_profitperregion()));
    }
    
    public ArrayList<View_bp_profitperregion> getView_bp_profitperregions() throws DBException {
        return (ArrayList<View_bp_profitperregion>)viewio.getEntities(EMview_bp_profitperregion.SQLSelectAll);
    }
}
