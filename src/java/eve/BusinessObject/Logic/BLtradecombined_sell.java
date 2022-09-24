/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 22.10.2021 17:25
 * @author Franky Laseure
 */

package eve.BusinessObject.Logic;

import db.*;
import general.exception.DBException;
import eve.interfaces.logicentity.ITradecombined_sell;
import eve.logicentity.Tradecombined_sell;
import eve.BusinessObject.table.Btradecombined_sell;
import general.exception.DataException;

public class BLtradecombined_sell extends Btradecombined_sell {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    public BLtradecombined_sell(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(true);
    }

    public BLtradecombined_sell(TableBusinessrules businessrules) {
        super(businessrules);
        tableio.setLogginrequired(isprivatetable);
    }


}
