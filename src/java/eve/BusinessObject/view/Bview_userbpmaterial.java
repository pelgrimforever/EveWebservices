/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 12.6.2022 10:8
 *
 */

package eve.BusinessObject.view;

import db.*;
import data.gis.shape.*;
import eve.conversion.entity.EMview_userbpmaterial;
import general.exception.*;
import java.util.ArrayList;
import eve.logicview.View_userbpmaterial;
import java.sql.Time;

/**
 * @author Franky Laseure
 */
public abstract class Bview_userbpmaterial extends ViewBusinessrules {

    public Bview_userbpmaterial(SQLreader sqlreader) {
        super(new ViewIO(sqlreader, new EMview_userbpmaterial()));
    }
    
    public ArrayList<View_userbpmaterial> getView_userbpmaterials() throws DBException {
        return (ArrayList<View_userbpmaterial>)viewio.getEntities(EMview_userbpmaterial.SQLSelectAll);
    }
}
