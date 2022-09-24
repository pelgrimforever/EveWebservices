/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */

package eve.BusinessObject.view;

import db.*;
import data.gis.shape.*;
import eve.conversion.entity.EMview_tradecombined;
import general.exception.*;
import java.util.ArrayList;
import eve.logicview.View_tradecombined;
import java.sql.Time;

public abstract class Bview_tradecombined extends ViewBusinessrules {

    public Bview_tradecombined(SQLreader sqlreader) {
        super(new ViewIO(sqlreader, new EMview_tradecombined()));
    }
    
    public ArrayList<View_tradecombined> getView_tradecombineds() throws DBException {
        return (ArrayList<View_tradecombined>)viewio.getEntities(EMview_tradecombined.SQLSelectAll);
    }
}
