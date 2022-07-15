/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 1.5.2021 17:54
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import db.*;
import db.SQLTqueue;
import eve.BusinessObject.table.Btrade;
import eve.conversion.entity.EMtrade;
import general.exception.DataException;
import eve.interfaces.entity.pk.ITradePK;
import eve.logicentity.Orders;
import eve.logicentity.Trade;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Franky Laseure
 */
public class BLtrade extends Btrade {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = true; //set this to true if only a loggin account has access to this data
	
    public BLtrade(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(true);
    }

    public BLtrade(TableBusinessrules businessrules) {
        super(businessrules);
        tableio.setLogginrequired(isprivatetable);
    }

    public ArrayList<Trade> getSellbuyorders(ITradePK tradepk) throws DBException {
        return getEntities(EMtrade.SQLSellBuyOrders, tradepk.getSQLprimarykey());
    }
    
    public void deletetrade(SQLTqueue transactionqueue) throws DBException, DataException {
        addStatement(transactionqueue, EMtrade.SQLdeleteall);
    }
}
