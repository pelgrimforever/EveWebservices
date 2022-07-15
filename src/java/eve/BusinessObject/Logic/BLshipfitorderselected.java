/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 20.11.2021 17:22
 */

package eve.BusinessObject.Logic;

import db.*;
import general.exception.DBException;
import eve.logicentity.Shipfitorderselected;
import eve.BusinessObject.table.Bshipfitorderselected;
import eve.entity.pk.ShipfitorderselectedPK;
import eve.interfaces.entity.pk.IOrdersPK;
import eve.interfaces.entity.pk.IShipfitorderPK;
import eve.interfaces.entity.pk.IShipfitorderselectedPK;
import eve.logicentity.Orders;
import eve.logicentity.Shipfitorder;
import eve.usecases.Shipfitorder_usecases;
import general.exception.CustomException;
import general.exception.DataException;
import java.util.ArrayList;

/**
 * @author Franky Laseure
 */
public class BLshipfitorderselected extends Bshipfitorderselected {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = true; //set this to true if only a loggin account has access to this data
	
    public BLshipfitorderselected(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(true);
    }

    public BLshipfitorderselected(TableBusinessrules businessrules) {
        super(businessrules);
        tableio.setLogginrequired(isprivatetable);
    }

    public void deleleteShipfitorder_for_user_shipname(SQLTqueue transactionqueue, String username, String shipname) throws DBException, DataException {
        Object[][] delparameters = {{ "username", username }, { "shipname", shipname }};
        SQLparameters delsqlparameters = new SQLparameters(delparameters);
        delShipfitorderselected(transactionqueue, delsqlparameters, "and");
    }

}
