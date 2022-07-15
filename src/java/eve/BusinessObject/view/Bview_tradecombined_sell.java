/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 12.6.2022 10:8
 *
 */

package eve.BusinessObject.view;

import db.*;
import data.gis.shape.*;
import eve.conversion.entity.EMview_tradecombined_sell;
import general.exception.*;
import java.util.ArrayList;
import eve.logicview.View_tradecombined_sell;
import java.sql.Time;

/**
 * @author Franky Laseure
 */
public abstract class Bview_tradecombined_sell extends ViewBusinessrules {

    public Bview_tradecombined_sell(SQLreader sqlreader) {
        super(new ViewIO(sqlreader, new EMview_tradecombined_sell()));
    }
    
    public ArrayList<View_tradecombined_sell> getView_tradecombined_sells() throws DBException {
        return (ArrayList<View_tradecombined_sell>)viewio.getEntities(EMview_tradecombined_sell.SQLSelectAll);
    }
}
