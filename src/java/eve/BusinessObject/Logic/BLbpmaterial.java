/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 24.0.2022 16:47
 * @author Franky Laseure
 */

package eve.BusinessObject.Logic;

import db.*;
import general.exception.DBException;
import eve.interfaces.logicentity.IBpmaterial;
import eve.logicentity.Bpmaterial;
import eve.BusinessObject.table.Bbpmaterial;
import general.exception.DataException;

public class BLbpmaterial extends Bbpmaterial {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    public BLbpmaterial(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(true);
    }

    public BLbpmaterial(TableBusinessrules businessrules) {
        super(businessrules);
        tableio.setLogginrequired(isprivatetable);
    }

}
