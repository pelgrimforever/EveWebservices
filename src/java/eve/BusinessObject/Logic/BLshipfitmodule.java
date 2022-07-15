/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 17.11.2021 15:31
 */

package eve.BusinessObject.Logic;

import db.*;
import general.exception.DBException;
import eve.interfaces.logicentity.IShipfitmodule;
import eve.logicentity.Shipfitmodule;
import eve.BusinessObject.table.Bshipfitmodule;
import general.exception.DataException;

/**
 * @author Franky Laseure
 */
public class BLshipfitmodule extends Bshipfitmodule {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = true; //set this to true if only a loggin account has access to this data
	
    public BLshipfitmodule(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(true);
    }

    public BLshipfitmodule(TableBusinessrules businessrules) {
        super(businessrules);
        tableio.setLogginrequired(isprivatetable);
    }



}
