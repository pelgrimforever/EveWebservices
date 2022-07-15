/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 12.6.2022 10:8
 *
 */

package eve.BusinessObject.view;

import db.*;
import data.gis.shape.*;
import eve.conversion.entity.EMview_tradesystem;
import general.exception.*;
import java.util.ArrayList;
import eve.logicview.View_tradesystem;
import java.sql.Time;

/**
 * @author Franky Laseure
 */
public abstract class Bview_tradesystem extends ViewBusinessrules {

    public Bview_tradesystem(SQLreader sqlreader) {
        super(new ViewIO(sqlreader, new EMview_tradesystem()));
    }
    
    public ArrayList<View_tradesystem> getView_tradesystems() throws DBException {
        return (ArrayList<View_tradesystem>)viewio.getEntities(EMview_tradesystem.SQLSelectAll);
    }
}
