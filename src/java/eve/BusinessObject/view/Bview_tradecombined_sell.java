/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */

package eve.BusinessObject.view;

import db.*;
import data.gis.shape.*;
import eve.conversion.entity.EMview_tradecombined_sell;
import general.exception.*;
import java.util.ArrayList;
import eve.logicview.View_tradecombined_sell;
import java.sql.Time;

public abstract class Bview_tradecombined_sell extends ViewBusinessrules {

    public Bview_tradecombined_sell(SQLreader sqlreader) {
        super(new ViewIO(sqlreader, new EMview_tradecombined_sell()));
    }
    
    public ArrayList<View_tradecombined_sell> getView_tradecombined_sells() throws DBException {
        return (ArrayList<View_tradecombined_sell>)viewio.getEntities(EMview_tradecombined_sell.SQLSelectAll);
    }
}
