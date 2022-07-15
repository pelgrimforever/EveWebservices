/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 12.6.2022 10:8
 *
 */

package eve.BusinessObject.view;

import db.*;
import data.gis.shape.*;
import eve.conversion.entity.EMview_userbp;
import general.exception.*;
import java.util.ArrayList;
import eve.logicview.View_userbp;
import java.sql.Time;

/**
 * @author Franky Laseure
 */
public abstract class Bview_userbp extends ViewBusinessrules {

    public Bview_userbp(SQLreader sqlreader) {
        super(new ViewIO(sqlreader, new EMview_userbp()));
    }
    
    public ArrayList<View_userbp> getView_userbps() throws DBException {
        return (ArrayList<View_userbp>)viewio.getEntities(EMview_userbp.SQLSelectAll);
    }
}
