/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 16.1.2022 20:53
 */

package eve.BusinessObject.Logic;

import db.*;
import general.exception.DBException;
import eve.interfaces.logicentity.IFrontendpage_auth;
import eve.logicentity.Frontendpage_auth;
import eve.BusinessObject.table.Bfrontendpage_auth;
import eve.entity.pk.Frontendpage_authPK;
import general.exception.DataException;

/**
 * @author Franky Laseure
 */
public class BLfrontendpage_auth extends Bfrontendpage_auth {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = true; //set this to true if only a loggin account has access to this data
	
    public BLfrontendpage_auth(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(true);
    }

    public boolean checkAuth(String username, String page) throws DBException {
        Frontendpage_authPK frontendpage_authpk = new Frontendpage_authPK(username, page);
        return tableio.getEntityExists(frontendpage_authpk);
    }
    
    public BLfrontendpage_auth(TableBusinessrules businessrules) {
        super(businessrules);
        tableio.setLogginrequired(isprivatetable);
    }

}
