/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */

package eve.BusinessObject.view;

import db.*;
import data.gis.shape.*;
import eve.conversion.entity.EMview_bpmaterial;
import general.exception.*;
import java.util.ArrayList;
import eve.logicview.View_bpmaterial;
import java.sql.Time;

public abstract class Bview_bpmaterial extends ViewBusinessrules {

    public Bview_bpmaterial(SQLreader sqlreader) {
        super(new ViewIO(sqlreader, new EMview_bpmaterial()));
    }
    
    public ArrayList<View_bpmaterial> getView_bpmaterials() throws DBException {
        return (ArrayList<View_bpmaterial>)viewio.getEntities(EMview_bpmaterial.SQLSelectAll);
    }
}
