/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 11.11.2021 13:40
 */

package eve.BusinessObject.Logic;

import db.*;
import general.exception.DBException;
import eve.interfaces.logicentity.ISyssettings;
import eve.logicentity.Syssettings;
import eve.BusinessObject.table.Bsyssettings;
import eve.entity.pk.SyssettingsPK;
import general.exception.DataException;

/**
 * @author Franky Laseure
 */
public class BLsyssettings extends Bsyssettings {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    public BLsyssettings(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(true);
    }

    public BLsyssettings(TableBusinessrules businessrules) {
        super(businessrules);
        tableio.setLogginrequired(isprivatetable);
    }

    public Syssettings getSyssettings(String syssettingsconstant) throws DBException, DataException {
        return this.getSyssettings(new SyssettingsPK(syssettingsconstant));
    }
    
}
