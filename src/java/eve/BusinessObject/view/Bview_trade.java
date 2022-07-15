/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 12.6.2022 10:8
 *
 */

package eve.BusinessObject.view;

import db.*;
import data.gis.shape.*;
import eve.conversion.entity.EMview_trade;
import general.exception.*;
import java.util.ArrayList;
import eve.logicview.View_trade;
import java.sql.Time;

/**
 * @author Franky Laseure
 */
public abstract class Bview_trade extends ViewBusinessrules {

    public Bview_trade(SQLreader sqlreader) {
        super(new ViewIO(sqlreader, new EMview_trade()));
    }
    
    public ArrayList<View_trade> getView_trades() throws DBException {
        return (ArrayList<View_trade>)viewio.getEntities(EMview_trade.SQLSelectAll);
    }
}
