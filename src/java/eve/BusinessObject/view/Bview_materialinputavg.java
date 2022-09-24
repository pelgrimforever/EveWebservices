/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */

package eve.BusinessObject.view;

import db.*;
import data.gis.shape.*;
import eve.conversion.entity.EMview_materialinputavg;
import general.exception.*;
import java.util.ArrayList;
import eve.logicview.View_materialinputavg;
import java.sql.Time;

public abstract class Bview_materialinputavg extends ViewBusinessrules {

    public Bview_materialinputavg(SQLreader sqlreader) {
        super(new ViewIO(sqlreader, new EMview_materialinputavg()));
    }
    
    public ArrayList<View_materialinputavg> getView_materialinputavgs() throws DBException {
        return (ArrayList<View_materialinputavg>)viewio.getEntities(EMview_materialinputavg.SQLSelectAll);
    }
}
