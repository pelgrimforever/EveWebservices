/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 24.0.2022 17:38
 * @author Franky Laseure
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import db.*;
import eve.logicview.View_bpmaterial;
import eve.BusinessObject.view.Bview_bpmaterial;
import eve.conversion.entity.EMview_bpmaterial;
import java.util.ArrayList;

public class BLview_bpmaterial extends Bview_bpmaterial {
//Metacoder: NO AUTHOMATIC UPDATE
	
    public BLview_bpmaterial(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(true);
    }

    public ArrayList<View_bpmaterial> getView_bpmaterials(long blueprintid) throws DBException {
        Object[][] parameters = {{ "bp", blueprintid }};
        SQLparameters sqlparameters = new SQLparameters(parameters);
        return viewio.getEntities(EMview_bpmaterial.SQLSelect4blueprint, sqlparameters);
    }
}
