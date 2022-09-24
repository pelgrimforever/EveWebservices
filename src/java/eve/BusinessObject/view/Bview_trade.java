/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */

package eve.BusinessObject.view;

import db.*;
import data.gis.shape.*;
import eve.conversion.entity.EMview_trade;
import general.exception.*;
import java.util.ArrayList;
import eve.logicview.View_trade;
import java.sql.Time;

public abstract class Bview_trade extends ViewBusinessrules {

    public Bview_trade(SQLreader sqlreader) {
        super(new ViewIO(sqlreader, new EMview_trade()));
    }
    
    public ArrayList<View_trade> getView_trades() throws DBException {
        return (ArrayList<View_trade>)viewio.getEntities(EMview_trade.SQLSelectAll);
    }
}
