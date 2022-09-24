/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */

package eve.BusinessObject.view;

import db.*;
import data.gis.shape.*;
import eve.conversion.entity.EMview_tradeorders;
import general.exception.*;
import java.util.ArrayList;
import eve.logicview.View_tradeorders;
import java.sql.Time;

public abstract class Bview_tradeorders extends ViewBusinessrules {

    public Bview_tradeorders(SQLreader sqlreader) {
        super(new ViewIO(sqlreader, new EMview_tradeorders()));
    }
    
    public ArrayList<View_tradeorders> getView_tradeorderss() throws DBException {
        return (ArrayList<View_tradeorders>)viewio.getEntities(EMview_tradeorders.SQLSelectAll);
    }
}
