/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */

package eve.BusinessObject.view;

import db.*;
import data.gis.shape.*;
import eve.conversion.entity.EMview_tradeorders_lowsec;
import general.exception.*;
import java.util.ArrayList;
import eve.logicview.View_tradeorders_lowsec;
import java.sql.Time;

public abstract class Bview_tradeorders_lowsec extends ViewBusinessrules {

    public Bview_tradeorders_lowsec(SQLreader sqlreader) {
        super(new ViewIO(sqlreader, new EMview_tradeorders_lowsec()));
    }
    
    public ArrayList<View_tradeorders_lowsec> getView_tradeorders_lowsecs() throws DBException {
        return (ArrayList<View_tradeorders_lowsec>)viewio.getEntities(EMview_tradeorders_lowsec.SQLSelectAll);
    }
}
