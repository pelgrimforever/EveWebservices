/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 2.0.2022 18:23
 * @author Franky Laseure
 */

package eve.BusinessObject.Logic;

import db.*;
import general.exception.DBException;
import eve.interfaces.logicentity.IContractitem;
import eve.logicentity.Contractitem;
import eve.BusinessObject.table.Bcontractitem;
import general.exception.DataException;

public class BLcontractitem extends Bcontractitem {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    public BLcontractitem(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(true);
    }

    public BLcontractitem(TableBusinessrules businessrules) {
        super(businessrules);
        tableio.setLogginrequired(isprivatetable);
    }

}
