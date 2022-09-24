/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 22.10.2021 17:25
 * @author Franky Laseure
 */

package eve.BusinessObject.Logic;

import db.*;
import general.exception.DBException;
import eve.interfaces.logicentity.ITradecombined;
import eve.logicentity.Tradecombined;
import eve.BusinessObject.table.Btradecombined;
import general.exception.DataException;

public class BLtradecombined extends Btradecombined {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    public BLtradecombined(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(true);
    }

    public BLtradecombined(TableBusinessrules businessrules) {
        super(businessrules);
        tableio.setLogginrequired(isprivatetable);
    }


}
