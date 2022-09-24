/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 16.11.2021 15:46
 * @author Franky Laseure
 */

package eve.BusinessObject.Logic;

import db.*;
import db.SQLTqueue;
import db.SQLreader;
import general.exception.DBException;
import eve.interfaces.logicentity.IWishlist;
import eve.logicentity.Wishlist;
import eve.BusinessObject.table.Bwishlist;
import general.exception.DataException;

public class BLwishlist extends Bwishlist {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = true; //set this to true if only a loggin account has access to this data
	
    public BLwishlist(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(true);
    }

    public BLwishlist(TableBusinessrules businessrules) {
        super(businessrules);
        tableio.setLogginrequired(isprivatetable);
    }

    
}
