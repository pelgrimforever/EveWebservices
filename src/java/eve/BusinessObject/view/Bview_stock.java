/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 12.6.2022 10:8
 *
 */

package eve.BusinessObject.view;

import db.*;
import data.gis.shape.*;
import eve.conversion.entity.EMview_stock;
import general.exception.*;
import java.util.ArrayList;
import eve.logicview.View_stock;
import java.sql.Time;

/**
 * @author Franky Laseure
 */
public abstract class Bview_stock extends ViewBusinessrules {

    public Bview_stock(SQLreader sqlreader) {
        super(new ViewIO(sqlreader, new EMview_stock()));
    }
    
    public ArrayList<View_stock> getView_stocks() throws DBException {
        return (ArrayList<View_stock>)viewio.getEntities(EMview_stock.SQLSelectAll);
    }
}
