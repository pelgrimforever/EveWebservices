/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 17.11.2021 15:28
 */

package eve.BusinessObject.Logic;

import db.*;
import db.SQLTqueue;
import general.exception.DBException;
import eve.interfaces.logicentity.IShipfit;
import eve.logicentity.Shipfit;
import eve.BusinessObject.table.Bshipfit;
import eve.entity.pk.ShipfitorderPK;
import eve.interfaces.entity.pk.IShipfitPK;
import eve.logicentity.Shipfitmodule;
import eve.logicentity.Shipfitorder;
import general.exception.CustomException;
import general.exception.DataException;
import java.util.ArrayList;

/**
 * @author Franky Laseure
 */
public class BLshipfit extends Bshipfit {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = true; //set this to true if only a loggin account has access to this data
	
    public BLshipfit(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(true);
    }

    public BLshipfit(TableBusinessrules businessrules) {
        super(businessrules);
        tableio.setLogginrequired(isprivatetable);
    }
}
