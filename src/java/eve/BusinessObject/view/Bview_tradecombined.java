/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 12.6.2022 10:8
 *
 */

package eve.BusinessObject.view;

import db.*;
import data.gis.shape.*;
import eve.conversion.entity.EMview_tradecombined;
import general.exception.*;
import java.util.ArrayList;
import eve.logicview.View_tradecombined;
import java.sql.Time;

/**
 * @author Franky Laseure
 */
public abstract class Bview_tradecombined extends ViewBusinessrules {

    public Bview_tradecombined(SQLreader sqlreader) {
        super(new ViewIO(sqlreader, new EMview_tradecombined()));
    }
    
    public ArrayList<View_tradecombined> getView_tradecombineds() throws DBException {
        return (ArrayList<View_tradecombined>)viewio.getEntities(EMview_tradecombined.SQLSelectAll);
    }
}
