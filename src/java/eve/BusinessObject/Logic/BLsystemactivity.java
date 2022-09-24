/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 5.3.2022 17:21
 * @author Franky Laseure
 */

package eve.BusinessObject.Logic;

import db.*;
import general.exception.DBException;
import eve.interfaces.logicentity.ISystemactivity;
import eve.logicentity.Systemactivity;
import eve.BusinessObject.table.Bsystemactivity;
import general.exception.DataException;

public class BLsystemactivity extends Bsystemactivity {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    public BLsystemactivity(SQLreader sqlreader) {
        super(sqlreader);
        tableio.setLogginrequired(isprivatetable);
    }

    public BLsystemactivity(TableIO tableio) {
        super(tableio);
        tableio.setLogginrequired(isprivatetable);
    }


}
