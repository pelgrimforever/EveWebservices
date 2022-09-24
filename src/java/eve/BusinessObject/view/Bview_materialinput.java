/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */

package eve.BusinessObject.view;

import db.*;
import data.gis.shape.*;
import eve.conversion.entity.EMview_materialinput;
import general.exception.*;
import java.util.ArrayList;
import eve.logicview.View_materialinput;
import java.sql.Time;

public abstract class Bview_materialinput extends ViewBusinessrules {

    public Bview_materialinput(SQLreader sqlreader) {
        super(new ViewIO(sqlreader, new EMview_materialinput()));
    }
    
    public ArrayList<View_materialinput> getView_materialinputs() throws DBException {
        return (ArrayList<View_materialinput>)viewio.getEntities(EMview_materialinput.SQLSelectAll);
    }
}
