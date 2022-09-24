/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */

package eve.BusinessObject.view;

import db.*;
import data.gis.shape.*;
import eve.conversion.entity.EMview_contractswithprofit;
import general.exception.*;
import java.util.ArrayList;
import eve.logicview.View_contractswithprofit;
import java.sql.Time;

public abstract class Bview_contractswithprofit extends ViewBusinessrules {

    public Bview_contractswithprofit(SQLreader sqlreader) {
        super(new ViewIO(sqlreader, new EMview_contractswithprofit()));
    }
    
    public ArrayList<View_contractswithprofit> getView_contractswithprofits() throws DBException {
        return (ArrayList<View_contractswithprofit>)viewio.getEntities(EMview_contractswithprofit.SQLSelectAll);
    }
}
