/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */

package eve.BusinessObject.view;

import db.*;
import data.gis.shape.*;
import eve.conversion.entity.EMview_shipfit;
import general.exception.*;
import java.util.ArrayList;
import eve.logicview.View_shipfit;
import java.sql.Time;

public abstract class Bview_shipfit extends ViewBusinessrules {

    public Bview_shipfit(SQLreader sqlreader) {
        super(new ViewIO(sqlreader, new EMview_shipfit()));
    }
    
    public ArrayList<View_shipfit> getView_shipfits() throws DBException {
        return (ArrayList<View_shipfit>)viewio.getEntities(EMview_shipfit.SQLSelectAll);
    }
}
