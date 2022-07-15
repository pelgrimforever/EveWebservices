/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 12.6.2022 10:8
 *
 */

package eve.BusinessObject.view;

import db.*;
import data.gis.shape.*;
import eve.conversion.entity.EMview_materialinputavg;
import general.exception.*;
import java.util.ArrayList;
import eve.logicview.View_materialinputavg;
import java.sql.Time;

/**
 * @author Franky Laseure
 */
public abstract class Bview_materialinputavg extends ViewBusinessrules {

    public Bview_materialinputavg(SQLreader sqlreader) {
        super(new ViewIO(sqlreader, new EMview_materialinputavg()));
    }
    
    public ArrayList<View_materialinputavg> getView_materialinputavgs() throws DBException {
        return (ArrayList<View_materialinputavg>)viewio.getEntities(EMview_materialinputavg.SQLSelectAll);
    }
}
