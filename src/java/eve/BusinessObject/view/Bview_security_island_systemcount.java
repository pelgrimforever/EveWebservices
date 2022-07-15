/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 12.6.2022 10:8
 *
 */

package eve.BusinessObject.view;

import db.*;
import data.gis.shape.*;
import eve.conversion.entity.EMview_security_island_systemcount;
import general.exception.*;
import java.util.ArrayList;
import eve.logicview.View_security_island_systemcount;
import java.sql.Time;

/**
 * @author Franky Laseure
 */
public abstract class Bview_security_island_systemcount extends ViewBusinessrules {

    public Bview_security_island_systemcount(SQLreader sqlreader) {
        super(new ViewIO(sqlreader, new EMview_security_island_systemcount()));
    }
    
    public ArrayList<View_security_island_systemcount> getView_security_island_systemcounts() throws DBException {
        return (ArrayList<View_security_island_systemcount>)viewio.getEntities(EMview_security_island_systemcount.SQLSelectAll);
    }
}
