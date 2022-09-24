/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 29.4.2021 10:38
 * @author Franky Laseure
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import eve.interfaces.logicentity.IRoutetype;
import eve.logicentity.Routetype;
import db.*;
import eve.BusinessObject.table.Broutetype;
import general.exception.DataException;

public class BLroutetype extends Broutetype {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    public BLroutetype(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(true);
    }

    public BLroutetype(TableBusinessrules businessrules) {
        super(businessrules);
        tableio.setLogginrequired(isprivatetable);
    }

}
