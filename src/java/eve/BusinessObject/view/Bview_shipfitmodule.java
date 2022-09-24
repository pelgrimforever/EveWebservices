/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */

package eve.BusinessObject.view;

import db.*;
import data.gis.shape.*;
import eve.conversion.entity.EMview_shipfitmodule;
import general.exception.*;
import java.util.ArrayList;
import eve.logicview.View_shipfitmodule;
import java.sql.Time;

public abstract class Bview_shipfitmodule extends ViewBusinessrules {

    public Bview_shipfitmodule(SQLreader sqlreader) {
        super(new ViewIO(sqlreader, new EMview_shipfitmodule()));
    }
    
    public ArrayList<View_shipfitmodule> getView_shipfitmodules() throws DBException {
        return (ArrayList<View_shipfitmodule>)viewio.getEntities(EMview_shipfitmodule.SQLSelectAll);
    }
}
