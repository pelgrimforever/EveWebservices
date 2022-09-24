/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 3.5.2021 16:27
 * @author Franky Laseure
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import eve.interfaces.logicentity.ILocation;
import eve.logicentity.Location;
import db.*;
import eve.BusinessObject.table.Blocation;
import general.exception.DataException;

public class BLlocation extends Blocation {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    public BLlocation(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(true);
    }

    public BLlocation(TableBusinessrules businessrules) {
        super(businessrules);
        tableio.setLogginrequired(isprivatetable);
    }



}
