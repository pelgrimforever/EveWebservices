/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 13.11.2021 15:8
 */

package eve.BusinessObject.Logic;

import db.*;
import db.SQLTqueue;
import general.exception.DBException;
import eve.interfaces.logicentity.IOrder_history_month;
import eve.logicentity.Order_history_month;
import eve.BusinessObject.table.Border_history_month;
import eve.conversion.entity.EMorder_history_month;
import general.exception.DataException;

/**
 * @author Franky Laseure
 */
public class BLorder_history_month extends Border_history_month {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    public BLorder_history_month(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(true);
    }

    public BLorder_history_month(TableBusinessrules businessrules) {
        super(businessrules);
        tableio.setLogginrequired(isprivatetable);
    }

    public void deleteall(SQLTqueue transactionqueue) {
        addStatement(transactionqueue, EMorder_history_month.SQLdeleteAll);
    }
    
    public void buildfromMarkethistory(SQLTqueue transactionqueue) {
        addStatement(transactionqueue, EMorder_history_month.SQLcopymarkethistory);
    }
    
}
