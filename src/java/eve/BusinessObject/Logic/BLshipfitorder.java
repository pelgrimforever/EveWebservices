/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 19.11.2021 16:16
 */

package eve.BusinessObject.Logic;

import db.*;
import db.*;
import db.SQLTqueue;
import general.exception.DBException;
import eve.logicentity.Shipfitorder;
import eve.BusinessObject.table.Bshipfitorder;
import eve.conversion.entity.EMshipfitorder;
import eve.entity.pk.ShipfitPK;
import eve.interfaces.entity.pk.IShipfitorderPK;
import eve.interfaces.logicentity.IShipfitorder;
import general.exception.DataException;
import java.util.ArrayList;

/**
 * @author Franky Laseure
 */
public class BLshipfitorder extends Bshipfitorder {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = true; //set this to true if only a loggin account has access to this data
	
    public BLshipfitorder(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(true);
    }

    public BLshipfitorder(TableBusinessrules businessrules) {
        super(businessrules);
        tableio.setLogginrequired(isprivatetable);
    }

    public void updateAmount(SQLTqueue transactionqueue, IShipfitorderPK shipfitorderPK, int amount) throws DBException, DataException {
        Shipfitorder shipfitorder = this.getShipfitorder(shipfitorderPK);
        shipfitorder.incAmountinstock(amount);
        updateShipfitorder(transactionqueue, shipfitorder);
    }
    
    public ArrayList<Shipfitorder> getShipfitorders_for_user(String username) throws DBException {
        Object[][] parameters = {{ "username", username }};
        SQLparameters sqlparameters = new SQLparameters(parameters);
        return getEntities(EMshipfitorder.SQLSelect4user, sqlparameters);
    }
    
    public void deleleteShipfitorder_for_user_shipname(SQLTqueue transactionqueue, String username, String shipname) throws DBException, DataException {
        Object[][] delparameters = {{ "username", username }, { "shipname", shipname }};
        SQLparameters delsqlparameters = new SQLparameters(delparameters);
        delShipfitorder(transactionqueue, delsqlparameters, "and");
    }
}
