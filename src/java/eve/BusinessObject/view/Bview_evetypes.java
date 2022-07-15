/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 12.6.2022 10:8
 *
 */

package eve.BusinessObject.view;

import db.*;
import data.gis.shape.*;
import eve.conversion.entity.EMview_evetypes;
import general.exception.*;
import java.util.ArrayList;
import eve.logicview.View_evetypes;
import java.sql.Time;

/**
 * @author Franky Laseure
 */
public abstract class Bview_evetypes extends ViewBusinessrules {

    public Bview_evetypes(SQLreader sqlreader) {
        super(new ViewIO(sqlreader, new EMview_evetypes()));
    }
    
    public ArrayList<View_evetypes> getView_evetypess() throws DBException {
        return (ArrayList<View_evetypes>)viewio.getEntities(EMview_evetypes.SQLSelectAll);
    }
}
