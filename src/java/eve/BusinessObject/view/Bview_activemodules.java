/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */

package eve.BusinessObject.view;

import db.*;
import data.gis.shape.*;
import eve.conversion.entity.EMview_activemodules;
import general.exception.*;
import java.util.ArrayList;
import eve.logicview.View_activemodules;
import java.sql.Time;

public abstract class Bview_activemodules extends ViewBusinessrules {

    public Bview_activemodules(SQLreader sqlreader) {
        super(new ViewIO(sqlreader, new EMview_activemodules()));
    }
    
    public ArrayList<View_activemodules> getView_activemoduless() throws DBException {
        return (ArrayList<View_activemodules>)viewio.getEntities(EMview_activemodules.SQLSelectAll);
    }
}
