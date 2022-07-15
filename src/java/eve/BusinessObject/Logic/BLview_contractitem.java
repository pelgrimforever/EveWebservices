/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 9.0.2022 7:52
 */

package eve.BusinessObject.Logic;

import db.SQLreader;
import general.exception.DBException;
import eve.logicview.View_contractitem;
import eve.BusinessObject.view.Bview_contractitem;
import eve.conversion.entity.EMview_contractitem;
import eve.entity.pk.ContractPK;
import java.util.ArrayList;

/**
 * @author Franky Laseure
 */
public class BLview_contractitem extends Bview_contractitem {
//Metacoder: NO AUTHOMATIC UPDATE
	
    public BLview_contractitem(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(true);
    }

    public ArrayList<View_contractitem> getView_contractitems(ContractPK contractPK) throws DBException {
        return viewio.getEntities(EMview_contractitem.SQLSelect4contract, contractPK.getSQLprimarykey());
    }

}
