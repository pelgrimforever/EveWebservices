/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 13.1.2022 17:48
 * @author Franky Laseure
 */

package eve.BusinessObject.Logic;

import db.*;
import general.exception.DBException;
import eve.interfaces.logicentity.IFrontendpage;
import eve.logicentity.Frontendpage;
import eve.BusinessObject.table.Bfrontendpage;
import general.exception.DataException;

public class BLfrontendpage extends Bfrontendpage {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = true; //set this to true if only a loggin account has access to this data
    
    public static final String USERS = "users";
    public static final String DOWNLOADTRADE = "downloadtrade";
    public static final String DOWNLOADCONTRACT = "downloadcontract";
	
    public BLfrontendpage(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(true);
    }

    public BLfrontendpage(TableBusinessrules businessrules) {
        super(businessrules);
        tableio.setLogginrequired(isprivatetable);
    }

}
