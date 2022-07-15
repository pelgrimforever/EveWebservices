/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 12.6.2022 10:8
 *
 */

package eve.BusinessObject.view;

import db.*;
import data.gis.shape.*;
import eve.conversion.entity.EMview_system;
import general.exception.*;
import java.util.ArrayList;
import eve.logicview.View_system;
import java.sql.Time;

/**
 * @author Franky Laseure
 */
public abstract class Bview_system extends ViewBusinessrules {

    public Bview_system(SQLreader sqlreader) {
        super(new ViewIO(sqlreader, new EMview_system()));
    }
    
    public ArrayList<View_system> getView_systems() throws DBException {
        return (ArrayList<View_system>)viewio.getEntities(EMview_system.SQLSelectAll);
    }
}
