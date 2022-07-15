/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 12.6.2022 10:8
 *
 */

package eve.BusinessObject.view;

import db.*;
import data.gis.shape.*;
import eve.conversion.entity.EMview_trade_systemsevetype;
import general.exception.*;
import java.util.ArrayList;
import eve.logicview.View_trade_systemsevetype;
import java.sql.Time;

/**
 * @author Franky Laseure
 */
public abstract class Bview_trade_systemsevetype extends ViewBusinessrules {

    public Bview_trade_systemsevetype(SQLreader sqlreader) {
        super(new ViewIO(sqlreader, new EMview_trade_systemsevetype()));
    }
    
    public ArrayList<View_trade_systemsevetype> getView_trade_systemsevetypes() throws DBException {
        return (ArrayList<View_trade_systemsevetype>)viewio.getEntities(EMview_trade_systemsevetype.SQLSelectAll);
    }
}
