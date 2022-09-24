/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 16.11.2021 15:51
 * @author Franky Laseure
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import db.*;
import db.SQLreader;
import eve.BusinessObject.view.Bview_wishlist;
import eve.conversion.entity.EMview_wishlist;
import java.util.ArrayList;

public class BLview_wishlist extends Bview_wishlist {
//Metacoder: NO AUTHOMATIC UPDATE
	
    public BLview_wishlist(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(true);
    }

    public ArrayList getView_wishlist4username(String username) throws DBException {
        Object[][] parameter = { { "username", username } };
        SQLparameters sqlparameters = new SQLparameters(parameter);
        return viewio.getEntities(EMview_wishlist.SQLSelect4username, sqlparameters);
    }
}
